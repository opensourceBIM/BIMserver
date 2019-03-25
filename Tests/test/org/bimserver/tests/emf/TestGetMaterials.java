package org.bimserver.tests.emf;

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

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Include.TypeDef;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialList;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;

public class TestGetMaterials extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());

			// Checkin the file
			bimServerClient.checkinSync(newProject.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-Institute-Var-2-IFC.ifc"));

			// Refresh project info
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());

			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), false, false);
			
			Query query = new Query(model.getPackageMetaData());
			query.setDoubleBuffer(true);
			QueryPart queryPart = query.createQueryPart();
			queryPart.addType(new TypeDef(model.getPackageMetaData().getEClass("IfcProduct"), true));

			Include include = queryPart.createInclude();
			include.addType(model.getPackageMetaData().getEClass("IfcObjectDefinition"), true);
			include.addField("HasAssociations");
			include.addInclude("ifc2x3tc1-stdlib:IfcRelAssociatesMaterial");
			
			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(model.getPackageMetaData());
			model.query(converter.toJson(query), true);
			
			int nrMaterialsWithName = 0;
			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
				Set<IfcMaterial> materials = getMaterials(ifcProduct);
				for (IfcMaterial ifcMaterial : materials) {
					if (ifcMaterial.getName() != null) {
						System.out.println(ifcMaterial.getName());
						nrMaterialsWithName++;
					}
				}
			}
			Assert.assertEquals(416, nrMaterialsWithName);
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
	
	public static Set<IfcMaterial> getMaterials(IfcProduct ifcProduct) {
		Set<IfcMaterial> materials = new HashSet<>();
		for (IfcRelAssociates ifcRelAssociates : ifcProduct.getHasAssociations()) {
			if (ifcRelAssociates instanceof IfcRelAssociatesMaterial) {
				IfcRelAssociatesMaterial ifcRelAssociatesMaterial = (IfcRelAssociatesMaterial) ifcRelAssociates;
				IfcMaterialSelect relatingMaterial = ifcRelAssociatesMaterial.getRelatingMaterial();
//				System.out.println(relatingMaterial);
				if (relatingMaterial instanceof IfcMaterial) {
					materials.add((IfcMaterial) relatingMaterial);
				} else if (relatingMaterial instanceof IfcMaterialLayerSetUsage) {
					IfcMaterialLayerSetUsage ifcMaterialLayerSetUsage = (IfcMaterialLayerSetUsage) relatingMaterial;
					IfcMaterialLayerSet forLayerSet = ifcMaterialLayerSetUsage.getForLayerSet();
					if (forLayerSet != null) {
						for (IfcMaterialLayer ifcMaterialLayer : forLayerSet.getMaterialLayers()) {
							IfcMaterial material = ifcMaterialLayer.getMaterial();
							materials.add(material);
						}
					}
				} else if (relatingMaterial instanceof IfcMaterialList) {
					materials.addAll(((IfcMaterialList) relatingMaterial).getMaterials());
				} else if (relatingMaterial instanceof IfcMaterialLayerSet) {
					for (IfcMaterialLayer ifcMaterialLayer : ((IfcMaterialLayerSet) relatingMaterial).getMaterialLayers()) {
						materials.add(ifcMaterialLayer.getMaterial());
					}
				} else {
					throw new UnsupportedOperationException(relatingMaterial.toString());
				}
			}
		}

		Iterator<IfcMaterial> iterator = materials.iterator();
		while (iterator.hasNext()) {
			IfcMaterial next = iterator.next();
			if (next == null || next.getName() == null) {
				System.out.println(next.getOid());
				iterator.remove();
			}
		}

		if (materials.size() > 0) {
			System.out.println(ifcProduct.eClass().getName() + ": " + Joiner.on(", ").join(materials));
		}
		
		return new HashSet<>(materials);
	}
}