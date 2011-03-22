package org.bimserver.tools.generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;
import javax.jws.WebParam;

import org.bimserver.shared.ServiceInterface;
import org.bimserver.utils.StringUtils;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

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

	private void start() {
		File protoFile = new File("build/pb/service.proto");
		generateProtoFile(protoFile);

		File destDir = new File("generated");
		File protoDir = new File("build/pb");
		File execFile = new File("build/pb/protoc.exe");
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
			out.println("package org.bimserver.pb;");
			out.println("option java_generic_services = true;");
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
			serviceBuilder.append("}\n");
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
			Type genericReturnType = method.getGenericReturnType();
			ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl)genericReturnType;
			Type type2 = parameterizedTypeImpl.getActualTypeArguments()[0];
			returnType = ((Class<?>)type2);
		}
		messageBuilder.append(createMessage(builder, returnType) + " value = 1;\n");
		messageBuilder.append("}\n\n");
		builder.append(messageBuilder);
	}
	
	private String createMessage(StringBuilder sb, Class<?> clazz) {
		StringBuilder messageBuilder = new StringBuilder();
		if (clazz == boolean.class || clazz == Boolean.class) {
			return "bool";
		} else if (clazz == String.class) {
			return "string";
		} else if (clazz == Long.class || clazz == long.class) {
			return "int64";
		} else if (clazz == Date.class) {
			return "int64";
		} else if (clazz == DataHandler.class) {
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
			if (method.getName().startsWith("get") && method.getName().length() > 3 && !methodsToIgnore.contains(method.getName())) {
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
					if (genericReturnType instanceof ParameterizedTypeImpl) {
						ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl)genericReturnType;
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
				Type genericReturnType = method.getGenericReturnType();
				if (genericReturnType instanceof ParameterizedTypeImpl) {
					ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl)genericReturnType;
					Type type2 = parameterizedTypeImpl.getActualTypeArguments()[0];
					parameterType = ((Class<?>)type2);
				}
			}
			messageBuilder.append(createMessage(builder, parameterType) + " " + paramName + " = " + (counter++) + ";\n");
			parameterCounter++;
		}
		messageBuilder.append("}\n\n");
		builder.append(messageBuilder);
	}
}