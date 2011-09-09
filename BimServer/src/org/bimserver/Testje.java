package org.bimserver;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DynamicMessage;

public class Testje {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("service.desc");
			DescriptorProtos.FileDescriptorSet set = DescriptorProtos.FileDescriptorSet.parseFrom(fin);
			DescriptorProto md = set.getFile(0).getMessageType(0);
			DynamicMessage message = DynamicMessage.getDefaultInstance(md.getDescriptorForType());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
