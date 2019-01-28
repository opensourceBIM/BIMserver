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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcDoorLiningProperties;
import org.bimserver.models.ifc2x3tc1.IfcShapeAspect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door Lining Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getLiningDepth <em>Lining Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getLiningDepthAsString <em>Lining Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getLiningThickness <em>Lining Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getLiningThicknessAsString <em>Lining Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getThresholdDepth <em>Threshold Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getThresholdDepthAsString <em>Threshold Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getThresholdThickness <em>Threshold Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getThresholdThicknessAsString <em>Threshold Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getTransomThickness <em>Transom Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getTransomThicknessAsString <em>Transom Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getTransomOffset <em>Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getTransomOffsetAsString <em>Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getLiningOffset <em>Lining Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getLiningOffsetAsString <em>Lining Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getThresholdOffset <em>Threshold Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getThresholdOffsetAsString <em>Threshold Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getCasingThickness <em>Casing Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getCasingThicknessAsString <em>Casing Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getCasingDepth <em>Casing Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getCasingDepthAsString <em>Casing Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDoorLiningPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDoorLiningPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcDoorLiningProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDoorLiningPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLiningDepth() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningDepth(double newLiningDepth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH, newLiningDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningDepth() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningDepth() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiningDepthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningDepthAsString(String newLiningDepthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH_AS_STRING, newLiningDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningDepthAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningDepthAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLiningThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningThickness(double newLiningThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS, newLiningThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningThickness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningThickness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiningThicknessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningThicknessAsString(String newLiningThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING,
				newLiningThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningThicknessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningThicknessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThresholdDepth() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdDepth(double newThresholdDepth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH, newThresholdDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdDepth() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdDepth() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThresholdDepthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdDepthAsString(String newThresholdDepthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH_AS_STRING,
				newThresholdDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdDepthAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdDepthAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThresholdThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdThickness(double newThresholdThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS, newThresholdThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdThickness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdThickness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThresholdThicknessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdThicknessAsString(String newThresholdThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS_AS_STRING,
				newThresholdThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdThicknessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdThicknessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransomThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomThickness(double newTransomThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS, newTransomThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomThickness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomThickness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransomThicknessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomThicknessAsString(String newTransomThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING,
				newTransomThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomThicknessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomThicknessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransomOffset() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomOffset(double newTransomOffset) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET, newTransomOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomOffset() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomOffset() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransomOffsetAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomOffsetAsString(String newTransomOffsetAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET_AS_STRING, newTransomOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomOffsetAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomOffsetAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLiningOffset() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningOffset(double newLiningOffset) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET, newLiningOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningOffset() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningOffset() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiningOffsetAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningOffsetAsString(String newLiningOffsetAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET_AS_STRING, newLiningOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningOffsetAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningOffsetAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThresholdOffset() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdOffset(double newThresholdOffset) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET, newThresholdOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdOffset() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdOffset() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThresholdOffsetAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdOffsetAsString(String newThresholdOffsetAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET_AS_STRING,
				newThresholdOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdOffsetAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdOffsetAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCasingThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasingThickness(double newCasingThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS, newCasingThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCasingThickness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCasingThickness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCasingThicknessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasingThicknessAsString(String newCasingThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS_AS_STRING,
				newCasingThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCasingThicknessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCasingThicknessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCasingDepth() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasingDepth(double newCasingDepth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH, newCasingDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCasingDepth() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCasingDepth() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCasingDepthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasingDepthAsString(String newCasingDepthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH_AS_STRING, newCasingDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCasingDepthAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCasingDepthAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getShapeAspectStyle() {
		return (IfcShapeAspect) eGet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__SHAPE_ASPECT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle) {
		eSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__SHAPE_ASPECT_STYLE, newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShapeAspectStyle() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShapeAspectStyle() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DOOR_LINING_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

} //IfcDoorLiningPropertiesImpl
