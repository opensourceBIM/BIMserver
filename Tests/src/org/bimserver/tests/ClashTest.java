package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

//import java.io.File;
//import java.util.Set;
//
//import org.bimserver.database.store.Clash;
//
//public class ClashTest {
//	public static void main(String[] args) {
//		new ClashTest().start();
//	}
//
//	private void start() {
//		IfcEngine ifcEngine = new IfcEngine(new File("../IFCEngine/lib"));
//		try {
//			int modelId = ifcEngine.sdaiOpenModelBN(0, TestFile.AC11.getFile().getAbsolutePath(), "../BimServer/deploy/shared/IFC2X3_FINAL.exp");
//			int nrClashes = ifcEngine.initializeClashes(modelId, 0.0);
//			Set<Clash> clashes = ifcEngine.finalizeClashesByGuid(modelId, nrClashes);
//			for (Clash clash : clashes) {
//				System.out.println(clash.getGuid1() + " - " + clash.getGuid2());
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//	}
//}