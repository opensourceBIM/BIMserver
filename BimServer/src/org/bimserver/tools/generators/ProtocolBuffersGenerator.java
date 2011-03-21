package org.bimserver.tools.generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import org.bimserver.shared.ServiceInterface;
import org.bimserver.utils.StringUtils;

public class ProtocolBuffersGenerator {
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
			StringBuilder serviceBuilder = new StringBuilder();
			StringBuilder messageBuilder = new StringBuilder();
			serviceBuilder.append("service ServiceInterface {\n");
			Class<ServiceInterface> serviceInterfaceClass = (Class<ServiceInterface>) Class.forName("org.bimserver.shared.ServiceInterface");
			for (Method method : serviceInterfaceClass.getMethods()) {
				String inputObjectName = StringUtils.firstUpperCase(method.getName()) + "Request";
				String outputObjectName = StringUtils.firstUpperCase(method.getName()) + "Response";
				createRequestMessage(messageBuilder, method, inputObjectName);
				createResponseMessage(messageBuilder, method, outputObjectName);
				serviceBuilder.append("\trpc " + method.getName() + " (" + inputObjectName + ") returns (" + outputObjectName + ");\n\n");
			}
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

	private void createResponseMessage(StringBuilder builder, Method method, String messageName) {
		builder.append("message " + messageName + " {\n");
		builder.append("}\n\n");
	}

	private void createRequestMessage(StringBuilder builder, Method method, String messageName) {
		builder.append("message " + messageName + " {\n");
		builder.append("}\n\n");
	}
}