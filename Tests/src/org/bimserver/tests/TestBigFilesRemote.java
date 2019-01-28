package org.bimserver.tests;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDatabaseInformation;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SJavaInfo;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.utils.Formatters;

import com.google.common.net.UrlEscapers;

public class TestBigFilesRemote {
	 public static void main(String[] args) {
		new TestBigFilesRemote().start(args);
	}

	private void start(String[] args) {
		String address = args[0];
		String username = args[1];
		String password = args[2];
		String basepath = args[3];
		System.out.println("Address: " + address);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Basepath: " + basepath);
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory(null, address)){
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo(args[1], args[2]));
			
			String[] fileNames = new String[]{
				"4NC Whole Model.ifc",
				"1006 General withIFC_exportLayerCombos.ifc",
				"12001_17 MOS_AC17SpecialBigVersion.ifc",
				"12510_MASTER_Drofus_Test.ifc",
				"BondBryan10-134 (06) Proposed Site-1.ifc",
				"HLM_39090_12259 University of Sheffield NEB  [PR-BIM-01-bhelberg].ifc"
			};
			

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			for (String fileName : fileNames) {
				String projectName = fileName.substring(0, fileName.lastIndexOf(".ifc"));
				
				List<SProject> projectsByName = client.getServiceInterface().getProjectsByName(projectName);
				SProject project = null;
				if (projectsByName.size() == 1) {
					project = projectsByName.get(0);
				} else {
					System.out.println("Creating project " + fileName);
					project = client.getServiceInterface().addProject(projectName, "ifc2x3tc1");
				}
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				
				System.out.println(dateFormat.format(new Date()));
				SDatabaseInformation databaseInformation = client.getAdminInterface().getDatabaseInformation();
				System.out.println("Database size: " + Formatters.bytesToString(databaseInformation.getDatabaseSizeInBytes()) + " (" + databaseInformation.getDatabaseSizeInBytes() + ")");
				SJavaInfo javaInfo = client.getAdminInterface().getJavaInfo();
				System.out.println("Used: " + Formatters.bytesToString(javaInfo.getHeapUsed()) + ", Free: " + Formatters.bytesToString(javaInfo.getHeapFree()) + ", Max: " + Formatters.bytesToString(javaInfo.getHeapMax()) + ", Total: " + Formatters.bytesToString(javaInfo.getHeapTotal()));
				String downloadUrl = basepath + UrlEscapers.urlPathSegmentEscaper().escape(fileName);
				System.out.println("Download URL: " + downloadUrl);
				client.getServiceInterface().checkinFromUrlSync(project.getOid(), fileName, deserializer.getOid(), fileName, downloadUrl, false);
				System.out.println("Done checking in " + fileName);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}