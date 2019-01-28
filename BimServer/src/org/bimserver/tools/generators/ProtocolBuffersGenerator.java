package org.bimserver.tools.generators;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;

import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.utils.Licenser;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocolBuffersGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolBuffersGenerator.class);
	private final Map<Class<?>, String> generatedClasses = new HashMap<Class<?>, String>();
	private final Map<String, String> generatedMessages = new HashMap<String, String>();

	public void generate(Class<?> serviceInterfaceClass, File protoFile, File descFile, boolean createBaseMessages, SService service, List<String> imports) {
		generateProtoFile(serviceInterfaceClass, protoFile, createBaseMessages, service, imports);
		generateProtocolBuffersObjects(protoFile, descFile, false);
	}

	private void generateProtocolBuffersObjects(File protoFile, File protoDestFile, boolean javaOut) {
		File destDir = new File("../GeneratedProtocolBuffersClient/generated");
		File protoDir = new File("../BimServerClientLib/src/org/bimserver/client/protocolbuffers/");

		File execFile = null;
		String execFileName = "protoc";
        String path = System.getenv("PATH");
        String[] folders = path.split(File.pathSeparator);  
        for (String folder : folders) {
            File file = new File(folder, execFileName);  
            if (file.isFile()) {
            	execFile = file;
            	break;
            }
		}
        if (execFile == null) {
        	execFile = new File("../BimServer/deploy/protoc.exe");
        }

        try {
			ProcessBuilder processBuilder = null;
			if (javaOut) {
				processBuilder = new ProcessBuilder(execFile.getAbsolutePath(), "-I=" + protoDir.getAbsolutePath(), "--java_out=" + destDir.getAbsolutePath(),
						"--descriptor_set_out=" + protoDestFile.getAbsolutePath(), protoFile.getAbsolutePath());
			} else {
				processBuilder = new ProcessBuilder(execFile.getAbsolutePath(), "-I=" + protoDir.getAbsolutePath(), "--descriptor_set_out=" + protoDestFile.getAbsolutePath(),
						protoFile.getAbsolutePath());
			}
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
						LOGGER.error("", e);
					}
				}
			}, "Protocol Buffers Generator").start();
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
						LOGGER.error("", e);
					}
				}
			}, "Protocol Buffers Generator").start();
			exec.waitFor();
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}
	}

	public void generateServiceInterfaceImplementation(String name, File file, SService sService) {
		try {
			PrintWriter out = new PrintWriter(file);
			out.println("package org.bimserver.pb;\n");
			out.println(Licenser.getCommentedLicenseText(new File("license.txt")));
			out.println("import java.util.*;");
			out.println("import com.google.protobuf.*;");
			out.println("import org.bimserver.utils.*;");
			out.println("import org.bimserver.pb.ProtocolBuffersService.*;");
			out.println("import com.google.protobuf.BlockingRpcChannel;");
			out.println("import org.bimserver.pb.ProtocolBuffersService.ServiceInterface.BlockingInterface;");
			out.println("import com.googlecode.protobuf.socketrpc.SocketRpcController;");
			out.println("import com.googlecode.protobuf.socketrpc.RpcChannels;");
			out.println("import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;");
			out.println("import javax.mail.util.ByteArrayDataSource;");
			out.println("import javax.activation.DataHandler;");
			out.println();
			out.println("@SuppressWarnings(\"unused\")");
			out.println("public class " + name + " implements org.bimserver.shared.ServiceInterface {\n");
			out.println("\tprivate BlockingInterface service;\n");
			out.println("\tprivate SocketRpcController rpcController;\n");
			out.println("\tpublic ProtocolBuffersServiceInterfaceImplementation(String address, int port) {");
			out.println("\t\tBlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory(address, port));");
			out.println("\t\trpcController = new SocketRpcController();");
			out.println("\t\tservice = ServiceInterface.newBlockingStub(rpcChannel);");
			out.println("\t}\n");
			for (SMethod sMethod : sService.getMethods()) {
				String fullResultType = "void";
				if (sMethod.returnsVoid()) {
					out.print("\tpublic void " + sMethod.getName() + "(");
				} else {
					fullResultType = sMethod.getReturnType().getName();
					if (sMethod.isAggregateReturnType()) {
						fullResultType = sMethod.getReturnType().getName() + "<" + sMethod.getGenericReturnType().getName() + ">";
					}
					out.print("\tpublic " + fullResultType + " " + sMethod.getName() + "(");
				}
				for (SParameter parameter : sMethod.getParameters()) {
					if (parameter.isAggregate()) {
						out.print(parameter.getType().getName() + "<" + parameter.getGenericType().getName() + "> " + parameter.getName() + (parameter.isLast() ? "" : ", "));
					} else {
						out.print(parameter.getType().getName() + " " + parameter.getName() + (parameter.isLast() ? "" : ", "));
					}
				}
				out.println(") {");
				out.println("\t\ttry {");
				String requestClassName = StringUtils.firstUpperCase(sMethod.getName()) + "Request";
				String responseClassName = StringUtils.firstUpperCase(sMethod.getName()) + "Response";
				out.println("\t\t\t" + requestClassName + ".Builder requestBuilder = " + requestClassName + ".newBuilder();");
				for (SParameter parameter : sMethod.getParameters()) {
					if (parameter.isAggregate()) {
						out.println("\t\t\tfor (" + parameter.getGenericType() + " val : " + parameter.getName() + ") {");
						if (parameter.getType().isPrimitive() || parameter.getType().getInstanceClass() == String.class) {
							out.println("\t\t\t\t" + parameter.getGenericType().getInstanceClass().getSimpleName() + " v = val;");
						} else {
							out.println("\t\t\t\tProtocolBuffersService." + parameter.getGenericType().getInstanceClass().getSimpleName() + " v = null;");
						}
						out.println("\t\t\t\trequestBuilder.add" + StringUtils.firstUpperCase(parameter.getName()) + "(v);");
						out.println("\t\t\t}");
					} else if (parameter.getType().getInstanceClass().isAssignableFrom(DataHandler.class)) {
						out.println("\t\t\tByteString bs = ByteString.copyFrom(BinUtils.readInputStream(" + parameter.getName() + ".getInputStream()));");
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(parameter.getName()) + "(bs);");
					} else if (parameter.getType().getInstanceClass().isPrimitive()) {
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(parameter.getName()) + "(" + parameter.getName() + ");");
					} else if (parameter.getType().getInstanceClass().isEnum()) {
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(parameter.getName()) + "(ProtocolBuffersService."
								+ parameter.getType().getInstanceClass().getSimpleName() + ".values()[" + parameter.getName() + ".ordinal()]);");
					} else if (parameter.getType().getInstanceClass().isPrimitive() || parameter.getType().getInstanceClass() == String.class) {
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(parameter.getName()) + "(" + parameter.getName() + ");");
					} else {
						out.println("\t\t\tProtocolBuffersService." + parameter.getType().getInstanceClass().getSimpleName() + ".Builder newVal = "
								+ parameter.getType().getInstanceClass().getSimpleName() + ".newBuilder();");
						genServiceInterfaceToProtocolBuffers(out, parameter.getName(), "newVal", parameter.getType());
						out.println("\t\t\trequestBuilder.set" + StringUtils.firstUpperCase(parameter.getName()) + "(newVal.build());");
					}
				}
				out.println("\t\t\t" + requestClassName + " request = requestBuilder.build();");
				if (sMethod.returnsVoid()) {
					out.println("\t\t\tservice." + sMethod.getName() + "(rpcController, request);");
				} else {
					out.println("\t\t\t" + responseClassName + " response = service." + sMethod.getName() + "(rpcController, request);");
					if (sMethod.isListReturnType()) {
						out.println("\t\t\t" + fullResultType + " realResult = new ArrayList<" + sMethod.getGenericReturnType().getName() + ">();");
						String fullTypeName = sMethod.getGenericReturnType().getName();
						if (sMethod.getGenericReturnType().isPrimitive() || sMethod.getGenericReturnType().getInstanceClass() == String.class) {
						} else {
							fullTypeName = "ProtocolBuffersService." + sMethod.getGenericReturnType().getName();
						}
						out.println("\t\t\tList<" + fullTypeName + "> originalList = response.getValueList();");
						out.println("\t\t\tfor (" + fullTypeName + " val : originalList) {");
						if (sMethod.getGenericReturnType().getInstanceClass() == String.class) {
							out.println("\t\t\t\trealResult.add(val);");
						} else if (sMethod.getGenericReturnType().isEnum()) {
							out.println("\t\t\t\trealResult.add(" + sMethod.getGenericReturnType().getName() + ".values()[val.ordinal()]);");
						} else {
							out.println("\t\t\t\t" + sMethod.getGenericReturnType().getName() + " v = " + genInitializerCode(sMethod.getGenericReturnType().getInstanceClass())
									+ ";");
							genProtocolBuffersToServiceInterface(out, "val", "v", sMethod.getGenericReturnType(), sMethod);
							out.println("\t\t\t\trealResult.add(v);");
						}
						out.println("\t\t\t}");
						out.println("\t\treturn realResult;");
					} else if (sMethod.getGenericReturnType().isSet()) {
						out.println("\t\t\t" + fullResultType + " realResult = new HashSet<" + sMethod.getGenericReturnType().getName() + ">();");
						String fullTypeName = "";
						if (sMethod.getGenericReturnType().isPrimitive() || sMethod.getGenericReturnType().isString()) {
						} else {
							fullTypeName = "ProtocolBuffersService." + sMethod.getGenericReturnType().getInstanceClass().getSimpleName();
						}
						out.println("\t\t\tList<" + fullTypeName + "> originalList = response.getValueList();");
						out.println("\t\t\tfor (" + fullTypeName + " val : originalList) {");
						if (sMethod.getGenericReturnType().isString()) {
							out.println("\t\t\t\trealResult.add(val);");
						} else if (sMethod.getGenericReturnType().isEnum()) {
							out.println("\t\t\t\trealResult.add(" + sMethod.getGenericReturnType().getName() + ".values()[val.ordinal()]);");
						} else {
							out.println("\t\t\t\t" + sMethod.getGenericReturnType().getName() + " v = " + genInitializerCode(sMethod.getGenericReturnType().getInstanceClass())
									+ ";");
							genProtocolBuffersToServiceInterface(out, "val", "v", sMethod.getGenericReturnType(), sMethod);
							out.println("\t\t\t\trealResult.add(v);");
						}
						out.println("\t\t\t}");
						out.println("\t\treturn realResult;");
					} else if (sMethod.getReturnType().isPrimitive() || sMethod.getReturnType().isString()) {
						out.println("\t\t\treturn response.getValue();");
					} else if (sMethod.getReturnType().isDate()) {
						out.println("\t\t\treturn new java.util.Date(response.getValue());");
					} else if (sMethod.getGenericReturnType().isEnum()) {
						out.println("\t\t\treturn null;");
					} else {
						out.println("\t\t\t" + sMethod.getGenericReturnType().getName() + " realResult = new " + sMethod.getReturnType().getName() + "();");
						out.println("\t\t\t" + "ProtocolBuffersService." + sMethod.getReturnType().getName() + " val = response.getValue();");
						genProtocolBuffersToServiceInterface(out, "val", "realResult", sMethod.getReturnType(), sMethod);
						out.println("\t\t\treturn realResult;");
					}
				}
				out.println("\t\t} catch (Exception e) {}");
				if (!sMethod.returnsVoid()) {
					out.println("\t\treturn " + getDefaultLiteralCode(sMethod.getGenericReturnType().getInstanceClass()) + ";");
				}
				out.println("\t}\n");
			}
			out.println('}');
			out.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
	}

	private void genProtocolBuffersToServiceInterface(PrintWriter out, String sourceName, String targetName, SClass sType, SMethod method) {
		for (SField field : sType.getAllFields()) {
			if (sType.getInstanceClass().isAssignableFrom(List.class)) {
			} else if (sType.isDate()) {
				out.println("\t\t\t\t" + targetName + ".set" + field.getName() + "(new Date(" + sourceName + "." + method.getName() + "()));");
			} else if (sType.isClass()) {
				out.println("\t\t\t\t" + targetName + ".set" + field.getName() + "(Class.forName(" + sourceName + "." + method.getName() + "()));");
			} else if (sType.isDataHandler()) {
				out.println("\t\t\t\t" + targetName + ".setFile(new DataHandler(new ByteArrayDataSource(" + sourceName + ".getFile().toByteArray(), \"\")));");
			} else if (sType.isEnum()) {
				out.println("\t\t\t\t" + targetName + ".set" + field.getName() + "(" + method.getReturnType().getName().replace("$", ".") + ".values()[" + sourceName + "."
						+ method.getName() + "().ordinal()]);");
			} else {
				out.println("\t\t\t\t" + targetName + ".set" + field.getName() + "(" + sourceName + "." + method.getName() + "());");
			}
		}
	}

	private void genServiceInterfaceToProtocolBuffers(PrintWriter out, String sourceName, String targetName, SClass parameterType) {
		for (SField field : parameterType.getAllFields()) {
			SClass fieldType = field.getType();
			SClass fieldClass = fieldType;
			if (fieldClass.isList()) {
				out.println("\t\t\tfor (" + fieldType.getName() + " o : " + sourceName + "." + field.getName() + "()) {");
				out.println("\t\t\t\t" + targetName + ".add" + field.getName() + "(o);");
				out.println("\t\t\t}");
			} else if (fieldClass.isDate()) {
				out.println("\t\t\t" + targetName + ".set" + field.getName() + "(" + sourceName + "." + field.getName() + "().getTime());");
			} else if (fieldType.getInstanceClass() == byte[].class) {
				out.println("\t\t\t" + targetName + ".set" + field.getName() + "(ByteString.copyFrom(" + sourceName + "." + field.getName() + "()));");
			} else if (fieldClass.isEnum()) {
				out.println("\t\t\t" + targetName + ".set" + field.getName() + "(" + fieldType.getInstanceClass().getSimpleName() + ".values()[" + sourceName + "."
						+ field.getName() + "().ordinal()]);");
			} else {
				out.println("\t\t\t" + targetName + ".set" + field.getName() + "(" + sourceName + "." + field.getName() + "());");
			}
		}
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

	private void generateProtoFile(Class<?> serviceInterfaceClass, File protoFile, boolean createBaseMessages, SService service, List<String> imports) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(protoFile);
			out.println("package org.bimserver.pb;\n");
			out.println(Licenser.getCommentedLicenseText(new File("license.txt")));
			for (String importFile : imports) {
				out.println("import \"" + importFile + ".proto\";");
			}
			out.println("option java_generic_services = true;\n");
			out.println("option java_outer_classname = \"" + service.getSimpleName() + "Impl\";\n");
			out.println("option optimize_for = SPEED;\n"); // or CODE_SIZE
			StringBuilder serviceBuilder = new StringBuilder();
			StringBuilder messageBuilder = new StringBuilder();
			serviceBuilder.append("service " + service.getSimpleName() + " {\n");
			if (createBaseMessages) {
				createVoidResponseMessage(messageBuilder);
				generateVoidMessage(messageBuilder);
			}
			for (SMethod method : service.getMethods()) {
				String inputObjectName = StringUtils.firstUpperCase(method.getName()) + "Request";
				String outputObjectName = StringUtils.firstUpperCase(method.getName()) + "Response";
				createRequestMessage(messageBuilder, method, inputObjectName);
				if (method.returnsVoid()) {
					outputObjectName = "VoidResponse";
				} else {
					createResponseMessage(messageBuilder, method, outputObjectName);
				}
				serviceBuilder.append("\trpc " + method.getName() + " (" + inputObjectName + ") returns (" + outputObjectName + ");\n\n");
			}
			serviceBuilder.append("}\n\n");
			out.print(serviceBuilder.toString());
			out.print(messageBuilder.toString());
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private void generateVoidMessage(StringBuilder builder) {
		builder.append("message Void {\n}");
	}

	private void createVoidResponseMessage(StringBuilder builder) {
		String messageName = "VoidResponse";
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append("message " + messageName + " {\n");
		messageBuilder.append("\toptional string errorMessage = 1;\n");
		messageBuilder.append("}\n\n");
		builder.append(messageBuilder);
	}

	private void createResponseMessage(StringBuilder builder, SMethod method, String messageName) {
		if (generatedMessages.containsKey(messageName)) {
			return;
		}
		generatedMessages.put(messageName, messageName);
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append("message " + messageName + " {\n");
		messageBuilder.append("\toptional string errorMessage = 1;\n");
		messageBuilder.append('\t');
		if (method.isAggregateReturnType()) {
			messageBuilder.append("repeated ");
		} else {
			messageBuilder.append("optional ");
		}
		messageBuilder.append(createMessage(builder, method.isAggregateReturnType() ? method.getGenericReturnType() : method.getReturnType()) + " value = 2;\n");
		messageBuilder.append("}\n\n");
		builder.append(messageBuilder);
	}

	private String createMessage(StringBuilder sb, SClass sType) {
		if (sType == null) {
			return "VoidResponse";
		}
		Class<?> clazz = sType.getInstanceClass();
		if (generatedClasses.containsKey(clazz)) {
			return generatedClasses.get(clazz);
		}
		if (clazz == Class.class) {
			return "string";
		} else if (clazz == boolean.class || clazz == Boolean.class) {
			return "bool";
		} else if (clazz == Long.class || clazz == long.class) {
			return "int64";
		} else if (clazz == Date.class) {
			return "int64";
		} else if (clazz == DataHandler.class || clazz == byte[].class || clazz == Byte[].class) {
			return "bytes";
		} else if (clazz == Integer.class | clazz == int.class) {
			return "int32";
		} else if (clazz == Float.class | clazz == float.class) {
			return "float";
		} else if (clazz == Double.class | clazz == double.class) {
			return "double";
		} else if (clazz.isEnum()) {
			return createEnum(sb, clazz);
		} else if (sType.isString()) {
			return "string";
		} else {
			StringBuilder messageBuilder = new StringBuilder();
			generatedClasses.put(clazz, clazz.getSimpleName());
			messageBuilder.append("message " + clazz.getSimpleName() + " {\n");
			int counter = 1;
			if (!sType.getSubClasses().isEmpty()) {
				messageBuilder.append("\trequired string __actual_type = " + (counter++) + ";\n");
				for (SClass subClass : sType.getSubClasses()) {
					messageBuilder.append('\t');
					messageBuilder.append("optional ");
					messageBuilder.append(createMessage(sb, subClass) + " __" + subClass.getInstanceClass().getSimpleName() + " = " + (counter++) + ";\n");
				}
			}
			for (SField field : sType.getAllFields()) {
				messageBuilder.append('\t');
				if (field.isAggregate()) {
					messageBuilder.append("repeated ");
				} else {
					messageBuilder.append("optional ");
				}
				SClass type = field.getType();
				if (field.isAggregate()) {
					type = field.getGenericType();
					// Type genericReturnType = method.getGenericReturnType();
					// if (genericReturnType instanceof ParameterizedType) {
					// ParameterizedType parameterizedTypeImpl =
					// (ParameterizedType)genericReturnType;
					// Type type2 =
					// parameterizedTypeImpl.getActualTypeArguments()[0];
					// parameterType = ((Class<?>)type2);
					// }
				}
				messageBuilder.append(createMessage(sb, type) + " " + field.getName() + " = " + (counter++) + ";\n");
			}
			messageBuilder.append("}\n\n");
			sb.append(messageBuilder);
			return clazz.getSimpleName();
		}
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
			sb.append("\t" + clazz.getSimpleName() + "_" + o.toString() + " = " + (counter++) + ";\n");
		}
		sb.append("}\n\n");
		return clazz.getSimpleName();
	}

	private void createRequestMessage(StringBuilder builder, SMethod method, String messageName) {
		if (generatedMessages.containsKey(messageName)) {
			return;
		}
		StringBuilder messageBuilder = new StringBuilder();
		generatedMessages.put(messageName, messageName);
		messageBuilder.append("message " + messageName + " {\n");
		int counter = 1;
		for (SParameter sParameter : method.getParameters()) {
			messageBuilder.append('\t');
			if (sParameter.isAggregate()) {
				messageBuilder.append("repeated ");
			} else {
				messageBuilder.append("optional ");
			}
			messageBuilder.append(createMessage(builder, sParameter.getBestType()) + " " + sParameter.getName() + " = " + (counter++) + ";\n");
		}
		messageBuilder.append("}\n\n");
		builder.append(messageBuilder);
	}
}