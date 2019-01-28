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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcDirectionSenseEnum;
import org.bimserver.models.ifc2x3tc1.IfcLayerSetDirectionEnum;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer Set Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerSetUsageImpl#getForLayerSet <em>For Layer Set</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerSetUsageImpl#getLayerSetDirection <em>Layer Set Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerSetUsageImpl#getDirectionSense <em>Direction Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerSetUsageImpl#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMaterialLayerSetUsageImpl#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialLayerSetUsageImpl extends IdEObjectImpl implements IfcMaterialLayerSetUsage {
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
		return Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialLayerSet getForLayerSet() {
		return (IfcMaterialLayerSet) eGet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__FOR_LAYER_SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForLayerSet(IfcMaterialLayerSet newForLayerSet) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__FOR_LAYER_SET, newForLayerSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLayerSetDirectionEnum getLayerSetDirection() {
		return (IfcLayerSetDirectionEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__LAYER_SET_DIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerSetDirection(IfcLayerSetDirectionEnum newLayerSetDirection) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__LAYER_SET_DIRECTION, newLayerSetDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirectionSenseEnum getDirectionSense() {
		return (IfcDirectionSenseEnum) eGet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__DIRECTION_SENSE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectionSense(IfcDirectionSenseEnum newDirectionSense) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__DIRECTION_SENSE, newDirectionSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getOffsetFromReferenceLine() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__OFFSET_FROM_REFERENCE_LINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetFromReferenceLine(double newOffsetFromReferenceLine) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__OFFSET_FROM_REFERENCE_LINE,
				newOffsetFromReferenceLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOffsetFromReferenceLineAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__OFFSET_FROM_REFERENCE_LINE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetFromReferenceLineAsString(String newOffsetFromReferenceLineAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MATERIAL_LAYER_SET_USAGE__OFFSET_FROM_REFERENCE_LINE_AS_STRING,
				newOffsetFromReferenceLineAsString);
	}

} //IfcMaterialLayerSetUsageImpl
