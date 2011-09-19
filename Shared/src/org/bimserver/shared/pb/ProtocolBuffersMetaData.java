package org.bimserver.shared.pb;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;

public class ProtocolBuffersMetaData {

	public static class ServiceDescriptorContainer {
		private final Map<String, MethodDescriptorContainer> methodDescriptors = new HashMap<String, MethodDescriptorContainer>();
		private final ServiceDescriptor serviceDescriptor;

		public ServiceDescriptorContainer(ServiceDescriptor serviceDescriptor) {
			this.serviceDescriptor = serviceDescriptor;
			for (MethodDescriptor methodDescriptor : serviceDescriptor.getMethods()) {
				this.methodDescriptors.put(methodDescriptor.getName(), new MethodDescriptorContainer(methodDescriptor));
			}
		}
		
		public ServiceDescriptor getServiceDescriptor() {
			return serviceDescriptor;
		}
		
		public Collection<MethodDescriptorContainer> getMethodDescriptors() {
			return methodDescriptors.values();
		}

		public MethodDescriptorContainer getMethodDescriptor(String methodName) {
			return methodDescriptors.get(methodName);
		}
	}
	
	public static class MethodDescriptorContainer {
		private final Map<String, FieldDescriptor> inputFields = new HashMap<String, Descriptors.FieldDescriptor>();
		private final Map<String, FieldDescriptor> outputFields = new HashMap<String, Descriptors.FieldDescriptor>();
		private final MethodDescriptor methodDescriptor;
		
		public MethodDescriptorContainer(MethodDescriptor methodDescriptor) {
			this.methodDescriptor = methodDescriptor;
			for (FieldDescriptor fieldDescriptor : methodDescriptor.getInputType().getFields()) {
				inputFields.put(fieldDescriptor.getName(), fieldDescriptor);
			}
			for (FieldDescriptor fieldDescriptor : methodDescriptor.getOutputType().getFields()) {
				outputFields.put(fieldDescriptor.getName(), fieldDescriptor);
			}
		}
		
		public FieldDescriptor getInputField(String name) {
			return inputFields.get(name);
		}
		
		public FieldDescriptor getOutputField(String name) {
			return outputFields.get(name);
		}

		public Descriptor getInputDescriptor() {
			return methodDescriptor.getInputType();
		}
		
		public Descriptor getOutputDescriptor() {
			return methodDescriptor.getOutputType();
		}
		
		public MethodDescriptor getMethodDescriptor() {
			return methodDescriptor;
		}
	}
	
	public static class MessageDescriptorContainer {

		private final Map<String, FieldDescriptor> fieldDescriptors = new HashMap<String, Descriptors.FieldDescriptor>();
		
		public MessageDescriptorContainer(Descriptor descriptor) {
			for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
				fieldDescriptors.put(fieldDescriptor.getName(), fieldDescriptor);
			}
		}
		
		public FieldDescriptor getField(String name) {
			return fieldDescriptors.get(name);
		}
	}
	
	private final Map<String, ServiceDescriptorContainer> serviceDescriptors = new HashMap<String, ServiceDescriptorContainer>();
	private final Map<String, MessageDescriptorContainer> messageDescriptors = new HashMap<String, MessageDescriptorContainer>();
	
	public ProtocolBuffersMetaData(URL resource) {
		try {
			FileDescriptorSet descriptorSet = FileDescriptorSet.parseFrom(resource.openStream());
			List<FileDescriptorProto> fileList = descriptorSet.getFileList();
			FileDescriptorProto fileDescriptorProto = fileList.get(0);
			FileDescriptor fileDescriptor = FileDescriptor.buildFrom(fileDescriptorProto, new FileDescriptor[]{});
			for (ServiceDescriptor serviceDescriptor : fileDescriptor.getServices()) {
				this.serviceDescriptors.put(serviceDescriptor.getName(), new ServiceDescriptorContainer(serviceDescriptor));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DescriptorValidationException e) {
			e.printStackTrace();
		}
	}
	
	public ProtocolBuffersMetaData(File file) {
	}

	public Collection<MethodDescriptorContainer> getMethods(String serviceName) {
		return serviceDescriptors.get(serviceName).getMethodDescriptors();
	}

	public MethodDescriptorContainer getMethod(String serviceName, String methodName) {
		return serviceDescriptors.get(serviceName).getMethodDescriptor(methodName);
	}

	public MessageDescriptorContainer getMessageDescriptor(String name) {
		return messageDescriptors.get(name);
	}

	public Collection<ServiceDescriptorContainer> getServices() {
		return serviceDescriptors.values();
	}
}