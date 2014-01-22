package org.bimserver.shared.pb;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolBuffersMetaData.class);

	public static class ServiceDescriptorContainer {
		private final Map<String, MethodDescriptorContainer> methodDescriptors = new HashMap<String, MethodDescriptorContainer>();
		private final ServiceDescriptor serviceDescriptor;

		public ServiceDescriptorContainer(ServiceDescriptor serviceDescriptor) {
			this.serviceDescriptor = serviceDescriptor;
			for (MethodDescriptor methodDescriptor : serviceDescriptor.getMethods()) {
				this.methodDescriptors.put(methodDescriptor.getName(), new MethodDescriptorContainer(this, methodDescriptor));
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

		public String getName() {
			return serviceDescriptor.getName();
		}
	}
	
	public static class MethodDescriptorContainer {
		private final Map<String, FieldDescriptor> inputFields = new HashMap<String, Descriptors.FieldDescriptor>();
		private final Map<String, FieldDescriptor> outputFields = new HashMap<String, Descriptors.FieldDescriptor>();
		private final MethodDescriptor methodDescriptor;
		private final ServiceDescriptorContainer serviceDescriptorContainer;
		
		public MethodDescriptorContainer(ServiceDescriptorContainer serviceDescriptorContainer, MethodDescriptor methodDescriptor) {
			this.serviceDescriptorContainer = serviceDescriptorContainer;
			this.methodDescriptor = methodDescriptor;
			for (FieldDescriptor fieldDescriptor : methodDescriptor.getInputType().getFields()) {
				inputFields.put(fieldDescriptor.getName(), fieldDescriptor);
			}
			for (FieldDescriptor fieldDescriptor : methodDescriptor.getOutputType().getFields()) {
				outputFields.put(fieldDescriptor.getName(), fieldDescriptor);
			}
		}
		
		public ServiceDescriptorContainer getServiceDescriptorContainer() {
			return serviceDescriptorContainer;
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

		public String getName() {
			return methodDescriptor.getName();
		}
	}
	
	public static class MessageDescriptorContainer {

		private final Map<String, FieldDescriptor> fieldDescriptors = new HashMap<String, Descriptors.FieldDescriptor>();
		private final Descriptor descriptor;
		
		public MessageDescriptorContainer(Descriptor descriptor) {
			this.descriptor = descriptor;
			for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
				fieldDescriptors.put(fieldDescriptor.getName(), fieldDescriptor);
			}
		}
		
		public Descriptor getDescriptor() {
			return descriptor;
		}
		
		public FieldDescriptor getField(String name) {
			return fieldDescriptors.get(name);
		}
	}
	
	private final Map<String, ServiceDescriptorContainer> serviceDescriptors = new HashMap<String, ServiceDescriptorContainer>();
	private final Map<String, MessageDescriptorContainer> messageDescriptors = new HashMap<String, MessageDescriptorContainer>();

	private final Map<String, FileDescriptor> loaded = new HashMap<String, Descriptors.FileDescriptor>();
	
	public String load(InputStream inputStream) {
		try {
			FileDescriptorSet descriptorSet = FileDescriptorSet.parseFrom(inputStream);
			List<FileDescriptorProto> fileList = descriptorSet.getFileList();
			FileDescriptorProto fileDescriptorProto = fileList.get(0);
			FileDescriptor[] ar = new FileDescriptor[fileDescriptorProto.getDependencyCount()];
			int i=0;
			for (String dep : fileDescriptorProto.getDependencyList()) {
				FileDescriptor fileDescriptor = loaded.get(dep);
				if (fileDescriptor == null) {
					LOGGER.error("Dependency " + dep + " of " + fileDescriptorProto.getName() + " not found");
				}
				ar[i++] = fileDescriptor;
			}
			FileDescriptor fileDescriptor = FileDescriptor.buildFrom(fileDescriptorProto, ar);
			loaded.put(fileDescriptor.getName(), fileDescriptor);
			for (Descriptor descriptor : fileDescriptor.getMessageTypes()) {
				this.messageDescriptors.put(descriptor.getName(), new MessageDescriptorContainer(descriptor));
			}
			for (ServiceDescriptor serviceDescriptor : fileDescriptor.getServices()) {
				this.serviceDescriptors.put(serviceDescriptor.getName(), new ServiceDescriptorContainer(serviceDescriptor));
				return serviceDescriptor.getName();
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (DescriptorValidationException e) {
			LOGGER.error("", e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}
	
	public String load(URL url) throws IOException {
		return load(url.openStream());
	}
	
	public void load(File file) throws FileNotFoundException {
		load(new FileInputStream(file));
	}

	public Collection<MethodDescriptorContainer> getMethods(String serviceName) {
		return serviceDescriptors.get(serviceName).getMethodDescriptors();
	}

	public MethodDescriptorContainer getMethod(String serviceName, String methodName) throws ServiceNotFoundException, ServiceMethodNotFoundException {
		ServiceDescriptorContainer serviceDescriptorContainer = serviceDescriptors.get(serviceName);
		if (serviceDescriptorContainer == null) {
			throw new ServiceNotFoundException("No service with name " + serviceName + " was found");
		}
		MethodDescriptorContainer methodDescriptor = serviceDescriptorContainer.getMethodDescriptor(methodName);
		if (methodDescriptor == null) {
			throw new ServiceMethodNotFoundException("No method with name " + methodName + " was found on service " + serviceName);
		}
		return methodDescriptor;
	}

	public MessageDescriptorContainer getMessageDescriptor(String name) {
		return messageDescriptors.get(name);
	}

	public Collection<ServiceDescriptorContainer> getServices() {
		return serviceDescriptors.values();
	}

	public void load(SServicesMap servicesMap, Class<?> loaderClass) {
		try {
			for (Class<? extends PublicInterface> clazz : servicesMap.getInterfaceClasses()) {
				URL resource = loaderClass.getResource(clazz.getSimpleName() + ".desc");
				if (resource != null) {
					load(resource);
				} else {
					LOGGER.error("Resource not found");
				}
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
}