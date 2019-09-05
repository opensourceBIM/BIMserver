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
import org.bimserver.models.ifc4.IfcDoorLiningProperties;
import org.bimserver.models.ifc4.IfcShapeAspect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door Lining Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningDepth <em>Lining Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningDepthAsString <em>Lining Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningThickness <em>Lining Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningThicknessAsString <em>Lining Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getThresholdDepth <em>Threshold Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getThresholdDepthAsString <em>Threshold Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getThresholdThickness <em>Threshold Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getThresholdThicknessAsString <em>Threshold Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getTransomThickness <em>Transom Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getTransomThicknessAsString <em>Transom Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getTransomOffset <em>Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getTransomOffsetAsString <em>Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningOffset <em>Lining Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningOffsetAsString <em>Lining Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getThresholdOffset <em>Threshold Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getThresholdOffsetAsString <em>Threshold Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getCasingThickness <em>Casing Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getCasingThicknessAsString <em>Casing Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getCasingDepth <em>Casing Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getCasingDepthAsString <em>Casing Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningToPanelOffsetX <em>Lining To Panel Offset X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningToPanelOffsetXAsString <em>Lining To Panel Offset XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningToPanelOffsetY <em>Lining To Panel Offset Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorLiningPropertiesImpl#getLiningToPanelOffsetYAsString <em>Lining To Panel Offset YAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDoorLiningPropertiesImpl extends IfcPreDefinedPropertySetImpl implements IfcDoorLiningProperties {
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
		return Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningDepth(double newLiningDepth) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH, newLiningDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningDepth() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningDepth() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningDepthAsString(String newLiningDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH_AS_STRING, newLiningDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningDepthAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningDepthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningThickness(double newLiningThickness) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS, newLiningThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningThickness() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningThicknessAsString(String newLiningThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING, newLiningThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getThresholdDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdDepth(double newThresholdDepth) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH, newThresholdDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdDepth() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdDepth() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThresholdDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdDepthAsString(String newThresholdDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH_AS_STRING, newThresholdDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdDepthAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdDepthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getThresholdThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdThickness(double newThresholdThickness) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS, newThresholdThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdThickness() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThresholdThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdThicknessAsString(String newThresholdThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS_AS_STRING, newThresholdThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransomThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomThickness(double newTransomThickness) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS, newTransomThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomThickness() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransomThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomThicknessAsString(String newTransomThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING, newTransomThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransomOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomOffset(double newTransomOffset) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET, newTransomOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomOffset() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomOffset() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransomOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomOffsetAsString(String newTransomOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET_AS_STRING, newTransomOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomOffsetAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomOffsetAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__TRANSOM_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningOffset(double newLiningOffset) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET, newLiningOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningOffset() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningOffset() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningOffsetAsString(String newLiningOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET_AS_STRING, newLiningOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningOffsetAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningOffsetAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getThresholdOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdOffset(double newThresholdOffset) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET, newThresholdOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdOffset() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdOffset() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThresholdOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdOffsetAsString(String newThresholdOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET_AS_STRING, newThresholdOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdOffsetAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdOffsetAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__THRESHOLD_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCasingThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCasingThickness(double newCasingThickness) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS, newCasingThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCasingThickness() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCasingThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCasingThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCasingThicknessAsString(String newCasingThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS_AS_STRING, newCasingThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCasingThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCasingThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCasingDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCasingDepth(double newCasingDepth) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH, newCasingDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCasingDepth() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCasingDepth() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCasingDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCasingDepthAsString(String newCasingDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH_AS_STRING, newCasingDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCasingDepthAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCasingDepthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__CASING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeAspect getShapeAspectStyle() {
		return (IfcShapeAspect) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__SHAPE_ASPECT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__SHAPE_ASPECT_STYLE, newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShapeAspectStyle() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShapeAspectStyle() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningToPanelOffsetX() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetX(double newLiningToPanelOffsetX) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_X, newLiningToPanelOffsetX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetX() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetX() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningToPanelOffsetXAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetXAsString(String newLiningToPanelOffsetXAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_XAS_STRING, newLiningToPanelOffsetXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetXAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetXAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningToPanelOffsetY() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetY(double newLiningToPanelOffsetY) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_Y, newLiningToPanelOffsetY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetY() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetY() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningToPanelOffsetYAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetYAsString(String newLiningToPanelOffsetYAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_YAS_STRING, newLiningToPanelOffsetYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetYAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetYAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_YAS_STRING);
	}

} //IfcDoorLiningPropertiesImpl
