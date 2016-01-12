package org.bimserver.merging;

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

import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.Scaler;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.modelmerger.ModelMerger;
import org.eclipse.emf.common.util.EList;

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
				for (long key : ifcModel.keySet()) {
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
				float scale = (float) (getLengthUnitPrefix(ifcModel) / Math.pow(10.0, prefix.getValue()));
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
			float lengthUnitPrefix = getLengthUnitPrefix(ifcModel);
			if (foundPrefix != Float.MIN_VALUE && lengthUnitPrefix != foundPrefix) {
				return false;
			} else {
				foundPrefix = lengthUnitPrefix;
			}
		}
		return true;
	}

	private float getLengthUnitPrefix(IfcModelInterface model) {
		float lengthUnitPrefix = 1.0f;
		boolean prefixFound = false;
		for (IfcProject ifcProject : model.getAll(IfcProject.class)) {
			IfcUnitAssignment unitsInContext = ifcProject.getUnitsInContext();
			if (unitsInContext != null) {
				EList<IfcUnit> units = unitsInContext.getUnits();
				for (IfcUnit unit : units) {
					if (unit instanceof IfcSIUnit) {
						IfcSIUnit ifcSIUnit = (IfcSIUnit) unit;
						IfcUnitEnum unitType = ifcSIUnit.getUnitType();
						if (unitType == IfcUnitEnum.LENGTHUNIT) {
							IfcSIPrefix prefix = ifcSIUnit.getPrefix();
							if (prefix != null) {
								prefixFound = true;
								switch (prefix) {
								case EXA:
									lengthUnitPrefix = 1.0e18f;
									break;
								case PETA:
									lengthUnitPrefix = 1.0e15f;
									break;
								case TERA:
									lengthUnitPrefix = 1.0e12f;
									break;
								case GIGA:
									lengthUnitPrefix = 1.0e9f;
									break;
								case MEGA:
									lengthUnitPrefix = 1.0e6f;
									break;
								case KILO:
									lengthUnitPrefix = 1.0e3f;
									break;
								case HECTO:
									lengthUnitPrefix = 1.0e2f;
									break;
								case DECA:
									lengthUnitPrefix = 1.0e1f;
									break;
								case DECI:
									lengthUnitPrefix = 1.0e-1f;
									break;
								case CENTI:
									lengthUnitPrefix = 1.0e-2f;
									break;
								case MILLI:
									lengthUnitPrefix = 1.0e-3f;
									break;
								case MICRO:
									lengthUnitPrefix = 1.0e-6f;
									break;
								case NANO:
									lengthUnitPrefix = 1.0e-9f;
									break;
								case PICO:
									lengthUnitPrefix = 1.0e-12f;
									break;
								case FEMTO:
									lengthUnitPrefix = 1.0e-15f;
									break;
								case ATTO:
									lengthUnitPrefix = 1.0e-18f;
									break;
								case NULL:
									break;
								}
								break;
							}
						}
					}
				}
			}
			if (prefixFound)
				break;
		}
		return lengthUnitPrefix;
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