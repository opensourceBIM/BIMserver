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
import org.bimserver.models.ifc2x3tc1.IfcGeneralProfileProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc General Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getPhysicalWeight <em>Physical Weight</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getPhysicalWeightAsString <em>Physical Weight As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getPerimeter <em>Perimeter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getPerimeterAsString <em>Perimeter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getMinimumPlateThickness <em>Minimum Plate Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getMinimumPlateThicknessAsString <em>Minimum Plate Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getMaximumPlateThickness <em>Maximum Plate Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getMaximumPlateThicknessAsString <em>Maximum Plate Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeneralProfilePropertiesImpl#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcGeneralProfilePropertiesImpl extends IfcProfilePropertiesImpl implements IfcGeneralProfileProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGeneralProfilePropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPhysicalWeight() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PHYSICAL_WEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalWeight(double newPhysicalWeight) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PHYSICAL_WEIGHT, newPhysicalWeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPhysicalWeight() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PHYSICAL_WEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPhysicalWeight() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PHYSICAL_WEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhysicalWeightAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PHYSICAL_WEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalWeightAsString(String newPhysicalWeightAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PHYSICAL_WEIGHT_AS_STRING,
				newPhysicalWeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPhysicalWeightAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PHYSICAL_WEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPhysicalWeightAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PHYSICAL_WEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPerimeter() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PERIMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerimeter(double newPerimeter) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PERIMETER, newPerimeter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPerimeter() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PERIMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPerimeter() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PERIMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPerimeterAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PERIMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerimeterAsString(String newPerimeterAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PERIMETER_AS_STRING, newPerimeterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPerimeterAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PERIMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPerimeterAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__PERIMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinimumPlateThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MINIMUM_PLATE_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumPlateThickness(double newMinimumPlateThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MINIMUM_PLATE_THICKNESS,
				newMinimumPlateThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumPlateThickness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MINIMUM_PLATE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumPlateThickness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MINIMUM_PLATE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumPlateThicknessAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MINIMUM_PLATE_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumPlateThicknessAsString(String newMinimumPlateThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MINIMUM_PLATE_THICKNESS_AS_STRING,
				newMinimumPlateThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumPlateThicknessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MINIMUM_PLATE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumPlateThicknessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MINIMUM_PLATE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximumPlateThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MAXIMUM_PLATE_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPlateThickness(double newMaximumPlateThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MAXIMUM_PLATE_THICKNESS,
				newMaximumPlateThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumPlateThickness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MAXIMUM_PLATE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumPlateThickness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MAXIMUM_PLATE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumPlateThicknessAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MAXIMUM_PLATE_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPlateThicknessAsString(String newMaximumPlateThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MAXIMUM_PLATE_THICKNESS_AS_STRING,
				newMaximumPlateThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumPlateThicknessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MAXIMUM_PLATE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumPlateThicknessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__MAXIMUM_PLATE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCrossSectionArea() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__CROSS_SECTION_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionArea(double newCrossSectionArea) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__CROSS_SECTION_AREA, newCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCrossSectionArea() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__CROSS_SECTION_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCrossSectionArea() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__CROSS_SECTION_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCrossSectionAreaAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__CROSS_SECTION_AREA_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionAreaAsString(String newCrossSectionAreaAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__CROSS_SECTION_AREA_AS_STRING,
				newCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCrossSectionAreaAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__CROSS_SECTION_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCrossSectionAreaAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GENERAL_PROFILE_PROPERTIES__CROSS_SECTION_AREA_AS_STRING);
	}

} //IfcGeneralProfilePropertiesImpl
