/**
 * Copyright (C) 2009-2014 BIMserver.org
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
 */
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcDirectionSenseEnum;
import org.bimserver.models.ifc4.IfcLayerSetDirectionEnum;
import org.bimserver.models.ifc4.IfcMaterialLayerSet;
import org.bimserver.models.ifc4.IfcMaterialLayerSetUsage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer Set Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetUsageImpl#getForLayerSet <em>For Layer Set</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetUsageImpl#getLayerSetDirection <em>Layer Set Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetUsageImpl#getDirectionSense <em>Direction Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetUsageImpl#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetUsageImpl#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetUsageImpl#getReferenceExtent <em>Reference Extent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialLayerSetUsageImpl#getReferenceExtentAsString <em>Reference Extent As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialLayerSetUsageImpl extends IfcMaterialUsageDefinitionImpl implements IfcMaterialLayerSetUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialLayerSetUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialLayerSet getForLayerSet() {
		return (IfcMaterialLayerSet) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__FOR_LAYER_SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForLayerSet(IfcMaterialLayerSet newForLayerSet) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__FOR_LAYER_SET, newForLayerSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLayerSetDirectionEnum getLayerSetDirection() {
		return (IfcLayerSetDirectionEnum) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__LAYER_SET_DIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayerSetDirection(IfcLayerSetDirectionEnum newLayerSetDirection) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__LAYER_SET_DIRECTION, newLayerSetDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirectionSenseEnum getDirectionSense() {
		return (IfcDirectionSenseEnum) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__DIRECTION_SENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDirectionSense(IfcDirectionSenseEnum newDirectionSense) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__DIRECTION_SENSE, newDirectionSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOffsetFromReferenceLine() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__OFFSET_FROM_REFERENCE_LINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetFromReferenceLine(double newOffsetFromReferenceLine) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__OFFSET_FROM_REFERENCE_LINE, newOffsetFromReferenceLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOffsetFromReferenceLineAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__OFFSET_FROM_REFERENCE_LINE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetFromReferenceLineAsString(String newOffsetFromReferenceLineAsString) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__OFFSET_FROM_REFERENCE_LINE_AS_STRING, newOffsetFromReferenceLineAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getReferenceExtent() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__REFERENCE_EXTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceExtent(double newReferenceExtent) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__REFERENCE_EXTENT, newReferenceExtent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferenceExtent() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__REFERENCE_EXTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferenceExtent() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__REFERENCE_EXTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReferenceExtentAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__REFERENCE_EXTENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceExtentAsString(String newReferenceExtentAsString) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__REFERENCE_EXTENT_AS_STRING, newReferenceExtentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferenceExtentAsString() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__REFERENCE_EXTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferenceExtentAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__REFERENCE_EXTENT_AS_STRING);
	}

} //IfcMaterialLayerSetUsageImpl
