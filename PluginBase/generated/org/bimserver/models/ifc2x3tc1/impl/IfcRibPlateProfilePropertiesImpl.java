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
import org.bimserver.models.ifc2x3tc1.IfcRibPlateDirectionEnum;
import org.bimserver.models.ifc2x3tc1.IfcRibPlateProfileProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rib Plate Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getThicknessAsString <em>Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getRibHeight <em>Rib Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getRibHeightAsString <em>Rib Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getRibWidth <em>Rib Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getRibWidthAsString <em>Rib Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getRibSpacing <em>Rib Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getRibSpacingAsString <em>Rib Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRibPlateProfilePropertiesImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRibPlateProfilePropertiesImpl extends IfcProfilePropertiesImpl implements IfcRibPlateProfileProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRibPlateProfilePropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThickness(double newThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__THICKNESS, newThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThickness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThickness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThicknessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThicknessAsString(String newThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__THICKNESS_AS_STRING, newThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThicknessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThicknessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRibHeight() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibHeight(double newRibHeight) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_HEIGHT, newRibHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibHeight() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibHeight() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRibHeightAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibHeightAsString(String newRibHeightAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_HEIGHT_AS_STRING, newRibHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibHeightAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibHeightAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRibWidth() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibWidth(double newRibWidth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_WIDTH, newRibWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibWidth() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibWidth() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRibWidthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibWidthAsString(String newRibWidthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_WIDTH_AS_STRING, newRibWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibWidthAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibWidthAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRibSpacing() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibSpacing(double newRibSpacing) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_SPACING, newRibSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibSpacing() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibSpacing() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRibSpacingAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_SPACING_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibSpacingAsString(String newRibSpacingAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_SPACING_AS_STRING, newRibSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibSpacingAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_SPACING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibSpacingAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__RIB_SPACING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRibPlateDirectionEnum getDirection() {
		return (IfcRibPlateDirectionEnum) eGet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__DIRECTION,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(IfcRibPlateDirectionEnum newDirection) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIB_PLATE_PROFILE_PROPERTIES__DIRECTION, newDirection);
	}

} //IfcRibPlateProfilePropertiesImpl
