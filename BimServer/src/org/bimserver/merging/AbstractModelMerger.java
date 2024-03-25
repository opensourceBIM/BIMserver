package org.bimserver.merging;

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

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.Scaler;
import org.bimserver.models.ifc4.*;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.modelmerger.ModelMerger;
import org.bimserver.utils.IfcUtils;
import org.eclipse.emf.common.util.EList;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractModelMerger implements ModelMerger {
	// TODO: Actually we should not modify the original objects and then copy them to the destination model, but the other way around...
	protected IfcModelInterface mergeScales(Project project, Set<IfcModelInterface> ifcModels, ModelHelper modelHelper) throws MergeException {
		long size = 0;
		PackageMetaData packageMetaData = null;
		for (IfcModelInterface ifcModel : ifcModels) {
			size += ifcModel.size();
			packageMetaData = ifcModel.getPackageMetaData();
		}
		IfcModelInterface endModel = new BasicIfcModel(packageMetaData, null, (int) size);
		modelHelper.setTargetModel(endModel);
		modelHelper.setObjectFactory(endModel);
		modelHelper.setKeepOriginalOids(true);
		float foundPrefix = Float.MIN_VALUE;
		boolean allModelsSameScale = allModelsSameScale(ifcModels, foundPrefix);
		if (allModelsSameScale) {
			for (IfcModelInterface ifcModel : ifcModels) {
				for (long key : new HashSet<>(ifcModel.keySet())) {
					IdEObject ideObject = (IdEObject) ifcModel.get(key);
					if (ideObject instanceof IfcRoot) {
						String name = ((IfcRoot) ideObject).getName();
						if (name != null && name.equalsIgnoreCase("dummy"))
							continue;
					}
					try {
						modelHelper.copy(ideObject, true);
					} catch (IfcModelInterfaceException e) {
						throw new MergeException(e);
					}
				}
			}
		} else {
			endModel.setUseDoubleStrings(false);
			SIPrefix prefix = project.getExportLengthMeasurePrefix();
			for (IfcModelInterface ifcModel : ifcModels) {
				float scale = (float) (IfcUtils.getLengthUnitPrefix(ifcModel) / Math.pow(10.0, prefix.getValue()));
				setLengthUnitMeasure(ifcModel, prefix);
				ifcModel.indexGuids();
				Scaler scaler = new Scaler(ifcModel);
				scaler.scale(scale);
				for (long key : ifcModel.keySet()) {
					try {
						modelHelper.copy((IdEObject) ifcModel.get(key), true);
					} catch (IfcModelInterfaceException e) {
						throw new MergeException(e);
					}
				}
			}
		}
		return endModel;
	}

	private boolean allModelsSameScale(Set<IfcModelInterface> ifcModels, float foundPrefix) {
		for (IfcModelInterface ifcModel : ifcModels) {
			float lengthUnitPrefix = IfcUtils.getLengthUnitPrefix(ifcModel);
			if (foundPrefix != Float.MIN_VALUE && lengthUnitPrefix != foundPrefix) {
				return false;
			} else {
				foundPrefix = lengthUnitPrefix;
			}
		}
		return true;
	}

	private void setLengthUnitMeasure(IfcModelInterface model, SIPrefix prefix) {
		boolean prefixFound = false;
		for (IfcProject ifcProject : model.getAll(IfcProject.class)) {
			IfcUnitAssignment unitsInContext = ifcProject.getUnitsInContext();
			EList<IfcUnit> units = unitsInContext.getUnits();
			for (IfcUnit unit : units) {
				if (unit instanceof IfcSIUnit) {
					IfcSIUnit ifcSIUnit = (IfcSIUnit) unit;
					IfcUnitEnum unitType = ifcSIUnit.getUnitType();
					if (unitType == IfcUnitEnum.LENGTHUNIT) {
						prefixFound = true;
						if (prefix == SIPrefix.METER) {
							// Set the prefix to null, there is no "meter"
							// prefix in IFC
							ifcSIUnit.setPrefix(null);
						} else {
							String siPrefix = prefix.getLiteral().substring(0, prefix.getLiteral().length() - 5).toUpperCase();
							ifcSIUnit.setPrefix(IfcSIPrefix.valueOf(siPrefix));
						}
						break;
					}
				}
			}
			if (prefixFound) {
				break;
			}
		}
	}
}