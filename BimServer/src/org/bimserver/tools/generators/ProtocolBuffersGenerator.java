package org.bimserver.tools.generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;
import javax.jws.WebParam;

import org.apache.commons.io.FileUtils;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.utils.StringUtils;

public class ProtocolBuffersGenerator {
	private final Map<Class<?>, String> generatedClasses = new HashMap<Class<?>, String>();
	private static final Set<String> methodsToIgnore = new HashSet<String>();
	
	static {
		methodsToIgnore.add("getClass");
		methodsToIgnore.add("getDeclaredAnnotations");
		methodsToIgnore.add("getConstructors");
		methodsToIgnore.add("getParameterAnnotations");
		methodsToIgnore.add("getGenericParameterTypes");
		methodsToIgnore.add("getGenericExceptionTypes");
		methodsToIgnore.add("getExceptionTypes");
		methodsToIgnore.add("getTypeParameters");
		methodsToIgnore.add("getAnnotation");
	}
	
	public static void main(String[] args) {
		new ProtocolBuffersGenerator().start();
	}

	public void start() {
		File protoFile = new File("../Builds/build/pb/service.proto");
		generateProtoFile(protoFile);
		try {
			FileUtils.copyFile(protoFile, new File("../Builds/build/targets/shared/service.proto"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File destDir = new File("../BimServer/generated");
		File protoDir = new File("../Builds//build/pb");
		File execFile = new File("../Builds/build/pb/protoc.exe");
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(execFile.getAbsolutePath(), "-I=" + protoDir.getAbsolutePath(), "--java_out=" + destDir.getAbsolutePath(), protoFile
					.getAbsolutePath());
			final Process exec = processBuilder.start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					InputStream inputStream = exec.getInputStream();
					byte[] buffer = new byte[1024];
					int red;
					try {
						red = inputStream.read(buffer);
						while (red != -1) {
							System.out.print(new String(buffer, 0, red));
							red = inputStream.read(buffer);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					InputStream inputStream = exec.getErrorStream();
					byte[] buffer = new byte[1024];
					int red;
					try {
						red = inputStream.read(buffer);
						while (red != -1) {
							System.err.print(new String(buffer, 0, red));
							red = inputStream.read(buffer);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		generateServiceInterfaceImplementation();
	}

	private void generateServiceInterfaceImplementation() {
		File file = new File("generated/org/bimserver/pb/ProtocolBuffersServiceInterfaceImplementation.java");
		try {
			PrintWriter out = new PrintWriter(file);
			out.println("package org.bimserver.pb;\n");
			out.println("import java.util.*;");
			out.println("import com.google.protobuf.*;");
			out.println("import org.bimserver.utils.*;");
			out.println("import org.bimserver.pb.Service.*;");
			out.println("import com.google.protobuf.BlockingRpcChannel;");
			out.println("import org.bimserver.pb.Service.ServiceInterface.BlockingInterface;");
			out.println("import com.googlecode.protobuf.socketrpc.SocketRpcController;");
			out.println("import com.googlecode.protobuf.socketrpc.RpcChannels;");
			out.println("import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;");
			out.println();
			out.println("@SuppressWarnings(\"unused\")");
			out.println("public class ProtocolBuffersServiceInterfaceImplementation implements org.bimserver.shared.ServiceInterface {\n");
			out.println("\tprivate BlockingInterface service;\n");
			out.println("\tprivate SocketRpcController rpcController;\n");
			out.println("\tpublic ProtocolBuffersServiceInterfaceImplementation(String address, int port) {");
			out.println("\t\tBlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory(address, port));");
			out.println("\t\trpcController = new SocketRpcController();");
			out.println("\t\tservice = ServiceInterface.newBlockingStub(rpcChannel);");
			out.println("\t}\n");
			for (Method method : ServiceInterface.class.getMethods()) {
				boolean returnsVoid = method.getReturnType() == Void.class || method.getReturnType() == void.class;
				String fullResultType = "void";
				if (returnsVoid) {
					out.print("\tpublic void " + method.getName() + "(");
				} else {
					Class<?> genericReturnType = getGenericReturnType(method);
					fullResultType = method.getReturnType().getName();
					if (genericReturnType != null) {
						fullResultType = method.getReturnType().getName() + "<" + genericReturnType.getName() + ">";
					}
					out.print("\tpublic " + fullResultType + " " + method.getName() + "(");
				}
				int parameterCounter = 0;
				for (Class<?> parameterType : method.getParameterTypes()) {
					WebParam annotation = extractAnnotation(method, parameterCounter, WebParam.class);
					String paramName = "unknown";
					if (annotation != null) {
						paramName = annotation.name();
					}
					String typeName = parameterType.getName();
					typeName = typeName.replace("$", ".");
					Class<?> genericType = getGenericType(method, parameterCounter, parameterType);
					if (parameterType.isAssignableFrom(List.class) || parameterType.isAssignableFrom(Set.class)) {
						out.print(typeName + "<" + genericType.getName() + "> " + paramName + (parameterCounter < method.getParameterTypes().length - 1 ? ", " : ""));
					} else {
						out.print(typeName + " " + paramName + (parameterCounter < method.getParameterTypes().length - 1 ? ", " : ""));
					}
					parameterCounter++;
				}
				out.println(") {");
				out.println("\t\ttry {");
				String requestClassName = StringUtils.firstUpperCase(method.getName()) + "Request";
				String responseClassName = StringUtils.firstUpperCase(method.getName()) + "Response";
				out.println("\t\t\t" + requestClassName + ".Builder requestBuilder = " + requestClassName + ".newBuilder();");
				parameterCounter = 0;
				for (Class<?> parameterType : method.getParameterTypes()) {
					WebParam annotation = extractAnnotation(method, parameterCounter, WebParam.class);
					String paramName = "unknown";
					if (annotation != null) {
						paramName = annotation.name();
					}
					if (parameterType.isAssignableFrom(List.class) || parameterType.isAssignableFrom(Set.class)) {
						out.println("\t\t\tfor (" + getGenericType(method, parameterCounter, parameterType).getName() + " val : " + paramName + ") {");
						Class<?> genericType = getGenericType(method, parameterCounter, parameterType);
						if (isPrimitive(genericType) || genericType == String.class) {
							out.println("\t\t\t\t" + genericType.getSimpleName() + " v = val;");
						} else {
							out.println("\t\t\t\tService." + genericType.getSimpleName() + " v = null;");
						}
						out.println("\t\t\t\trequestBuilder.add" + StringUtils.firstUpperCase(paramName) + "(v);");
						out.println("\t\t\t}");
					} else if (parameterType.isAssignableFrom(DataHandler.class)) {
						out.println("\t\t\tByteString bs = ByteString.copyFrom(BinUtils.readInputStream(" + paramName + ".getInputStream()));");
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(paramName) + "(bs);");
					} else if (parameterType.isPrimitive()) {
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(paramName) + "(" + paramName + ");");
					} else if (parameterType.isEnum()) {
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(paramName) + "(Service." + parameterType.getSimpleName() + ".values()[" + paramName + ".ordinal()]);");
					} else if (isPrimitive(parameterType) || parameterType == String.class) {
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(paramName) + "(" + paramName + ");");
					} else {
						out.println("\t\t\tService." + parameterType.getSimpleName() + ".Builder newVal = " + parameterType.getSimpleName() + ".newBuilder();");
						genServiceInterfaceToProtocolBuffers(out, paramName, "newVal", parameterType);
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(paramName) + "(newVal.build());");
					}
					parameterCounter++;
				}
				out.println("\t\t\t" + requestClassName + " request = requestBuilder.build();");
				if (returnsVoid) {
					out.println("\t\t\tservice." + method.getName() + "(rpcController, request);");
				} else {
					out.println("\t\t\t" + responseClassName + " response = service." + method.getName() + "(rpcController, request);");
					if (method.getReturnType().isAssignableFrom(List.class)) {
						Class<?> genericReturnType = getGenericReturnType(method);
						out.println("\t\t\t" + fullResultType + " realResult = new ArrayList<" + genericReturnType.getName() + ">();");
						String fullTypeName = genericReturnType.getSimpleName();
						if (isPrimitive(genericReturnType) || genericReturnType == String.class) {
						} else {
							fullTypeName = "Service." + genericReturnType.getSimpleName();
						}
						out.println("\t\t\tList<" + fullTypeName + "> originalList = response.getValueList();");
						out.println("\t\t\tfor (" + fullTypeName + " val : originalList) {");
						if (getGenericReturnType(method) == String.class) {
							out.println("\t\t\t\trealResult.add(val);");
						} else if (getGenericReturnType(method).isEnum()) {
							out.println("\t\t\t\trealResult.add(" + getGenericReturnType(method).getName() + ".values()[val.ordinal()]);");
						} else {
							out.println("\t\t\t\t" + getGenericReturnType(method).getName() + " v = " + genInitializerCode(getGenericReturnType(method)) + ";");
							genProtocolBuffersToServiceInterface(out, "val", "v", getGenericReturnType(method));
							out.println("\t\t\t\trealResult.add(v);");
						}
						out.println("\t\t\t}");
						out.println("\t\treturn realResult;");
					} else if (method.getReturnType().isAssignableFrom(Set.class)) {
						Class<?> genericReturnType = getGenericReturnType(method);
						out.println("\t\t\t" + fullResultType + " realResult = new HashSet<" + genericReturnType.getName() + ">();");
						String fullTypeName = genericReturnType.getSimpleName();
						if (isPrimitive(genericReturnType) || genericReturnType == String.class) {
						} else {
							fullTypeName = "Service." + genericReturnType.getSimpleName();
						}
						out.println("\t\t\tList<" + fullTypeName + "> originalList = response.getValueList();");
						out.println("\t\t\tfor (" + fullTypeName + " val : originalList) {");
						if (getGenericReturnType(method) == String.class) {
							out.println("\t\t\t\trealResult.add(val);");
						} else if (getGenericReturnType(method).isEnum()) {
							out.println("\t\t\t\trealResult.add(" + getGenericReturnType(method).getName() + ".values()[val.ordinal()]);");
						} else {
							out.println("\t\t\t\t" + getGenericReturnType(method).getName() + " v = " + genInitializerCode(getGenericReturnType(method)) + ";");
							genProtocolBuffersToServiceInterface(out, "val", "v", getGenericReturnType(method));
							out.println("\t\t\t\trealResult.add(v);");
						}
						out.println("\t\t\t}");
						out.println("\t\treturn realResult;");
					} else if (isPrimitive(method.getReturnType()) || method.getReturnType() == String.class) {
						out.println("\t\t\treturn response.getValue();");
					} else if (method.getReturnType().isEnum()) {
						out.println("\t\t\treturn null;");
					} else {
						out.println("\t\t\t" + method.getReturnType().getName() + " realResult = new " + method.getReturnType().getName() + "();");
						
						out.println("\t\t\treturn realResult;");
					}
				}
				out.println("\t\t} catch (Exception e) {}");
				if (!returnsVoid) {
					out.println("\t\treturn " + getDefaultLiteralCode(method.getReturnType()) + ";");
				}
				out.println("\t}\n");
			}
			out.println("}");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void genProtocolBuffersToServiceInterface(PrintWriter out, String sourceName, String targetName, Class<?> parameterType) {
		for (Method method : parameterType.getMethods()) {
			if (method.getName().startsWith("get") && !method.getName().equals("getClass") && method.getParameterTypes().length == 0) {
				String fName = method.getName().substring(3);
				if (method.getReturnType().isAssignableFrom(List.class)) {
					Class<?> genericReturnType = getGenericReturnType(method);
					if (genericReturnType != null) {
//						out.println("\t\t\t\tfor (" + genericReturnType.getName() + " o : " + sourceName + "." + method.getName() + "List()) {");
//						out.println("\t\t\t\t\t" + targetName + ".get" + fName + "().add(o);");
//						out.println("\t\t\t\t}");
					}
				} else if (method.getReturnType() == Date.class) {
					out.println("\t\t\t\t" + targetName + ".set" + fName + "(new Date(" + sourceName + "." + method.getName() + "()));");
				} else if (method.getReturnType() == Class.class) {
					out.println("\t\t\t\t" + targetName + ".set" + fName + "(Class.forName(" + sourceName + "." + method.getName() + "()));");
				} else if (method.getReturnType() == byte[].class) {
					out.println("\t\t\t\t" + targetName + ".set" + fName + "(" + sourceName + "." + method.getName() + "().toByteArray());");
				} else if (method.getReturnType().isEnum()) {
					out.println("\t\t\t\t" + targetName + ".set" + fName + "(" + method.getReturnType().getName().replace("$", ".") + ".values()[" + sourceName + "." + method.getName() + "().ordinal()]);");
				} else {
					out.println("\t\t\t\t" + targetName + ".set" + fName + "(" + sourceName + "." + method.getName() + "());");
				}
			}
		}
	}
	
	private void genServiceInterfaceToProtocolBuffers(PrintWriter out, String sourceName, String targetName, Class<?> parameterType) {
		for (Method method : parameterType.getMethods()) {
			if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
				String fName = method.getName().substring(3);
				if (method.getReturnType().isAssignableFrom(List.class)) {
					Class<?> genericReturnType = getGenericReturnType(method);
					out.println("\t\t\tfor (" + genericReturnType.getName() + " o : " + sourceName + "." + method.getName() + "()) {");
					out.println("\t\t\t\t" + targetName + ".add" + fName + "(o);");
					out.println("\t\t\t}");
				} else if (method.getReturnType() == Date.class) {
					out.println("\t\t\t" + targetName + ".set" + fName + "(" + sourceName + "." + method.getName() + "().getTime());");
				} else if (method.getReturnType() == byte[].class) {
					out.println("\t\t\t" + targetName + ".set" + fName + "(ByteString.copyFrom(" + sourceName + "." + method.getName() + "()));");
				} else if (method.getReturnType().isEnum()) {
					out.println("\t\t\t" + targetName + ".set" + fName + "(" + method.getReturnType().getSimpleName() + ".values()[" + sourceName + "." + method.getName() + "().ordinal()]);");
				} else {
					out.println("\t\t\t" + targetName + ".set" + fName + "(" + sourceName + "." + method.getName() + "());");
				}
			}
		}
	}

	private boolean isPrimitive(Class<?> type) {
		if (type.isPrimitive()) {
			return true;
		} else if (type == Long.class || type == Integer.class || type == Float.class || type == Double.class || type == Boolean.class || type == Character.class) {
			return true;
		}
		return false;
	}
	
	private String genInitializerCode(Class<?> type) {
		if (type.isPrimitive()) {
			return getDefaultLiteralCode(type);
		} else if (type == String.class) {
			return "\"\"";
		} else if (type.isEnum()) {
			return "null";
		} else {
			return "new " + type.getName() + "()";
		}
	}

	private String getDefaultLiteralCode(Class<?> type) {
		if (type == Boolean.class || type == boolean.class) {
			return "false";
		} else if (type == Integer.class || type == int.class) {
			return "0";
		} else if (type == Long.class || type == long.class) {
			return "0L";
		} else if (type.isEnum()) {
			return "null";
		} else {
			return "null";
		}
	}

	@SuppressWarnings("unchecked")
	private void generateProtoFile(File protoFile) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(protoFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			out.println("package org.bimserver.pb;\n");
			out.println("option java_generic_services = true;\n");
			StringBuilder serviceBuilder = new StringBuilder();
			StringBuilder messageBuilder = new StringBuilder();
			serviceBuilder.append("service ServiceInterface {\n");
			Class<ServiceInterface> serviceInterfaceClass = (Class<ServiceInterface>) Class.forName("org.bimserver.shared.ServiceInterface");
			for (Method method : serviceInterfaceClass.getMethods()) {
				String inputObjectName = StringUtils.firstUpperCase(method.getName()) + "Request";
				String outputObjectName = StringUtils.firstUpperCase(method.getName()) + "Response";
				createRequestMessage(messageBuilder, method, inputObjectName);
				if (method.getReturnType() == void.class) {
					outputObjectName = "Void";
				} else {
					createResponseMessage(messageBuilder, method, outputObjectName);
				}
				serviceBuilder.append("\trpc " + method.getName() + " (" + inputObjectName + ") returns (" + outputObjectName + ");\n\n");
			}
			generateVoidMessage(messageBuilder);
			serviceBuilder.append("}\n\n");
			out.print(serviceBuilder.toString());
			out.print(messageBuilder.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private void generateVoidMessage(StringBuilder builder) {
		builder.append("message Void {\n}");
	}
	
	private void createResponseMessage(StringBuilder builder, Method method, String messageName) {
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append("message " + messageName + " {\n");
		messageBuilder.append("\t");
		boolean aggregate = method.getReturnType().isAssignableFrom(List.class) || method.getReturnType().isAssignableFrom(Set.class);
		if (aggregate) {
			messageBuilder.append("repeated ");
		} else {
			messageBuilder.append("optional ");
		}
		Class<?> returnType = method.getReturnType();
		if (aggregate) {
			returnType = getGenericReturnType(method);
		}
		messageBuilder.append(createMessage(builder, returnType) + " value = 2;\n");
		messageBuilder.append("\toptional string errorMessage = 1;\n");
		messageBuilder.append("}\n\n");
		builder.append(messageBuilder);
	}

	private Class<?> getGenericReturnType(Method method) {
		Class<?> returnType;
		Type genericReturnType = method.getGenericReturnType();
		if (genericReturnType instanceof ParameterizedType) {
			ParameterizedType parameterizedTypeImpl = (ParameterizedType)genericReturnType;
			Type type2 = parameterizedTypeImpl.getActualTypeArguments()[0];
			returnType = ((Class<?>)type2);
			return returnType;
		}
		return null;
	}
	
	private String createMessage(StringBuilder sb, Class<?> clazz) {
		if (clazz == Class.class) {
			return "string";
		}
		StringBuilder messageBuilder = new StringBuilder();
		if (clazz == boolean.class || clazz == Boolean.class) {
			return "bool";
		} else if (clazz == String.class) {
			return "string";
		} else if (clazz == Long.class || clazz == long.class) {
			return "int64";
		} else if (clazz == Date.class) {
			return "int64";
		} else if (clazz == DataHandler.class || clazz == byte[].class) {
			return "bytes";
		} else if (clazz == Integer.class | clazz == int.class) {
			return "int32";
		} else if (clazz == Float.class | clazz == float.class) {
			return "float";
		} else if (clazz.isEnum()) {
			return createEnum(sb, clazz);
		} else {
			if (generatedClasses.containsKey(clazz)) {
				return generatedClasses.get(clazz);
			}
		}
		generatedClasses.put(clazz, clazz.getSimpleName());
		messageBuilder.append("message " + clazz.getSimpleName() + " {\n");
		int counter = 1;
		for (Method method : clazz.getMethods()) {
			if (method.getName().startsWith("get") && method.getName().length() > 3 && !methodsToIgnore.contains(method.getName()) && method.getParameterTypes().length == 0) {
				boolean aggregate = method.getReturnType().isAssignableFrom(List.class) || method.getReturnType().isAssignableFrom(Set.class);
				messageBuilder.append("\t");
				if (aggregate) {
					messageBuilder.append("repeated ");
				} else {
					messageBuilder.append("optional ");
				}
				Class<?> parameterType = method.getReturnType();
				if (aggregate) {
					Type genericReturnType = method.getGenericReturnType();
					if (genericReturnType instanceof ParameterizedType) {
						ParameterizedType parameterizedTypeImpl = (ParameterizedType)genericReturnType;
						Type type2 = parameterizedTypeImpl.getActualTypeArguments()[0];
						parameterType = ((Class<?>)type2);
					}
				}
				String fieldName = StringUtils.firstLowerCase(method.getName().substring(3));
				messageBuilder.append(createMessage(sb, parameterType) + " " + fieldName + " = " + (counter++) + ";\n");
			}
		}
		messageBuilder.append("}\n\n");
		sb.append(messageBuilder);
		return clazz.getSimpleName();
	}

	private String createEnum(StringBuilder sb, Class<?> clazz) {
		if (generatedClasses.containsKey(clazz)) {
			return generatedClasses.get(clazz);
		} else {
			generatedClasses.put(clazz, clazz.getSimpleName());
		}
		sb.append("enum " + clazz.getSimpleName() + "{\n");
		int counter = 0;
		for (Object o : clazz.getEnumConstants()) {
			sb.append("\t" + o.toString() + " = " + (counter++) + ";\n");
		}
		sb.append("}\n\n");
		return clazz.getSimpleName();
	}

	@SuppressWarnings("unchecked")
	private <T extends Annotation> T extractAnnotation(Method method, int parameterIndex, Class<T> annotationClass) {
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		Annotation[] annotations = parameterAnnotations[parameterIndex];
		for (Annotation annotation : annotations) {
			if (annotationClass.isInstance(annotation)) {
				return (T) annotation;
			}
		}
		return null;
	}
	
	private void createRequestMessage(StringBuilder builder, Method method, String messageName) {
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append("message " + messageName + " {\n");
		int counter = 1;
		int parameterCounter = 0;
		for (Class<?> parameterType : method.getParameterTypes()) {
			messageBuilder.append("\t");
			WebParam annotation = extractAnnotation(method, parameterCounter, WebParam.class);
			String paramName = "unknown";
			if (annotation != null) {
				paramName = annotation.name();
			}
			boolean aggregate = parameterType.isAssignableFrom(List.class) || parameterType.isAssignableFrom(Set.class);
			if (aggregate) {
				messageBuilder.append("repeated ");
			} else {
				messageBuilder.append("optional ");
			}
			if (aggregate) {
				parameterType = getGenericType(method, parameterCounter, parameterType);
			}
			messageBuilder.append(createMessage(builder, parameterType) + " " + paramName + " = " + (counter++) + ";\n");
			parameterCounter++;
		}
		messageBuilder.append("}\n\n");
		builder.append(messageBuilder);
	}

	private Class<?> getGenericType(Method method, int parameterCounter, Class<?> parameterType) {
		Type genericReturnType = method.getGenericParameterTypes()[parameterCounter];
		if (genericReturnType instanceof ParameterizedType) {
			ParameterizedType parameterizedTypeImpl = (ParameterizedType)genericReturnType;
			Type type2 = parameterizedTypeImpl.getActualTypeArguments()[0];
			parameterType = ((Class<?>)type2);
		} else if (genericReturnType instanceof Class<?>) {
			parameterType = (Class<?>) genericReturnType;
		}
		return parameterType;
	}
}