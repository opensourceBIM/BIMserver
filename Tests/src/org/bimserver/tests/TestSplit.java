package org.bimserver.tests;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.bimserver.LocalDevSetup;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

import com.google.common.base.Charsets;

public class TestSplit {
	public static void main(String[] args) {
		BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");

		try {
			SSerializerPluginConfiguration serializer = client.getBimsie1ServiceInterface().getSerializerByName("Ifc2x3");
			long poid = 131073;
			
			SProject project = client.getBimsie1ServiceInterface().getProjectByPoid(poid);
			
			IfcModelInterface model = client.getModel(project, project.getLastRevisionId(), true, false);
			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
				Long topicId = client.getBimsie1ServiceInterface().downloadByOids(Collections.singleton(project.getLastRevisionId()), Collections.singleton(ifcProduct.getOid()), serializer.getOid(), true, false);
				System.out.println(topicId);
				InputStream downloadData = client.getDownloadData(topicId, serializer.getOid());
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				org.apache.commons.io.IOUtils.copy(downloadData, byteArrayOutputStream);
				downloadData.close();
				System.out.println(new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8));
				System.out.println();
			}
		} catch (ServerException | UserException | PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
