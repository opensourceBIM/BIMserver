package org.bimserver.javamodelchecker;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.models.store.ModelCheckerResultLine;
import org.bimserver.models.store.ModelCheckerResultType;
import org.bimserver.models.store.StoreFactory;

public class WindowWidthChecker implements JavaModelCheckerInterface {
	public ModelCheckerResult check(IfcModelInterface model) {
		ModelCheckerResult modelCheckerResult = StoreFactory.eINSTANCE.createModelCheckerResult();
		modelCheckerResult.setValid(true);
		for (IfcWindow ifcWindow : model.getAllWithSubTypes(IfcWindow.class)) {
			ModelCheckerResultLine line = StoreFactory.eINSTANCE.createModelCheckerResultLine();
			line.setFieldOrClass("IfcWindow");
			line.setObjectId(ifcWindow.getOid());
			line.setShouldBe("> 50");
			line.setValue("" + ifcWindow.getOverallWidth());
			modelCheckerResult.getItems().add(line);
			if (ifcWindow.getOverallWidth() < 50) {
				modelCheckerResult.setValid(false);
				line.setType(ModelCheckerResultType.ERROR);
			} else {
				line.setType(ModelCheckerResultType.SUCCESS);
			}
		}
		return modelCheckerResult;
	}
}