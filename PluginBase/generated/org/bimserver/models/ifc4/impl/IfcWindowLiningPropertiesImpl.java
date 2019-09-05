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
import org.bimserver.models.ifc4.IfcShapeAspect;
import org.bimserver.models.ifc4.IfcWindowLiningProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Window Lining Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningDepth <em>Lining Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningDepthAsString <em>Lining Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningThickness <em>Lining Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningThicknessAsString <em>Lining Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getTransomThickness <em>Transom Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getTransomThicknessAsString <em>Transom Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getMullionThickness <em>Mullion Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getMullionThicknessAsString <em>Mullion Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getFirstTransomOffset <em>First Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getFirstTransomOffsetAsString <em>First Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getSecondTransomOffset <em>Second Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getSecondTransomOffsetAsString <em>Second Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getFirstMullionOffset <em>First Mullion Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getFirstMullionOffsetAsString <em>First Mullion Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getSecondMullionOffset <em>Second Mullion Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getSecondMullionOffsetAsString <em>Second Mullion Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningOffset <em>Lining Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningOffsetAsString <em>Lining Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningToPanelOffsetX <em>Lining To Panel Offset X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningToPanelOffsetXAsString <em>Lining To Panel Offset XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningToPanelOffsetY <em>Lining To Panel Offset Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowLiningPropertiesImpl#getLiningToPanelOffsetYAsString <em>Lining To Panel Offset YAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcWindowLiningPropertiesImpl extends IfcPreDefinedPropertySetImpl implements IfcWindowLiningProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWindowLiningPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningDepth(double newLiningDepth) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_DEPTH, newLiningDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningDepth() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningDepth() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningDepthAsString(String newLiningDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_DEPTH_AS_STRING, newLiningDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningDepthAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningDepthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningThickness(double newLiningThickness) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_THICKNESS, newLiningThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningThickness() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningThicknessAsString(String newLiningThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING, newLiningThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransomThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__TRANSOM_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomThickness(double newTransomThickness) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__TRANSOM_THICKNESS, newTransomThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomThickness() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__TRANSOM_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__TRANSOM_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransomThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomThicknessAsString(String newTransomThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING, newTransomThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__TRANSOM_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMullionThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__MULLION_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMullionThickness(double newMullionThickness) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__MULLION_THICKNESS, newMullionThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMullionThickness() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__MULLION_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMullionThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__MULLION_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMullionThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__MULLION_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMullionThicknessAsString(String newMullionThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__MULLION_THICKNESS_AS_STRING, newMullionThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMullionThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__MULLION_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMullionThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__MULLION_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFirstTransomOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_TRANSOM_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstTransomOffset(double newFirstTransomOffset) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_TRANSOM_OFFSET, newFirstTransomOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFirstTransomOffset() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_TRANSOM_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFirstTransomOffset() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_TRANSOM_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFirstTransomOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_TRANSOM_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstTransomOffsetAsString(String newFirstTransomOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_TRANSOM_OFFSET_AS_STRING, newFirstTransomOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFirstTransomOffsetAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_TRANSOM_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFirstTransomOffsetAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_TRANSOM_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSecondTransomOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_TRANSOM_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondTransomOffset(double newSecondTransomOffset) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_TRANSOM_OFFSET, newSecondTransomOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSecondTransomOffset() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_TRANSOM_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSecondTransomOffset() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_TRANSOM_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSecondTransomOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_TRANSOM_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondTransomOffsetAsString(String newSecondTransomOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_TRANSOM_OFFSET_AS_STRING, newSecondTransomOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSecondTransomOffsetAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_TRANSOM_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSecondTransomOffsetAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_TRANSOM_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFirstMullionOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_MULLION_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstMullionOffset(double newFirstMullionOffset) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_MULLION_OFFSET, newFirstMullionOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFirstMullionOffset() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_MULLION_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFirstMullionOffset() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_MULLION_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFirstMullionOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_MULLION_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstMullionOffsetAsString(String newFirstMullionOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_MULLION_OFFSET_AS_STRING, newFirstMullionOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFirstMullionOffsetAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_MULLION_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFirstMullionOffsetAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__FIRST_MULLION_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSecondMullionOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_MULLION_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondMullionOffset(double newSecondMullionOffset) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_MULLION_OFFSET, newSecondMullionOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSecondMullionOffset() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_MULLION_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSecondMullionOffset() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_MULLION_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSecondMullionOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_MULLION_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondMullionOffsetAsString(String newSecondMullionOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_MULLION_OFFSET_AS_STRING, newSecondMullionOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSecondMullionOffsetAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_MULLION_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSecondMullionOffsetAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SECOND_MULLION_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeAspect getShapeAspectStyle() {
		return (IfcShapeAspect) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SHAPE_ASPECT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SHAPE_ASPECT_STYLE, newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShapeAspectStyle() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShapeAspectStyle() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningOffset(double newLiningOffset) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_OFFSET, newLiningOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningOffset() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningOffset() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningOffsetAsString(String newLiningOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_OFFSET_AS_STRING, newLiningOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningOffsetAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningOffsetAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_OFFSET_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningToPanelOffsetX() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetX(double newLiningToPanelOffsetX) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_X, newLiningToPanelOffsetX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetX() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetX() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningToPanelOffsetXAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetXAsString(String newLiningToPanelOffsetXAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_XAS_STRING, newLiningToPanelOffsetXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetXAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetXAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningToPanelOffsetY() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetY(double newLiningToPanelOffsetY) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_Y, newLiningToPanelOffsetY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetY() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetY() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningToPanelOffsetYAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetYAsString(String newLiningToPanelOffsetYAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_YAS_STRING, newLiningToPanelOffsetYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetYAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetYAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_LINING_PROPERTIES__LINING_TO_PANEL_OFFSET_YAS_STRING);
	}

} //IfcWindowLiningPropertiesImpl
