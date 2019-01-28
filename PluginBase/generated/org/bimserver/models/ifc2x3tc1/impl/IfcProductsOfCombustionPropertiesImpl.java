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
import org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Products Of Combustion Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProductsOfCombustionPropertiesImpl#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProductsOfCombustionPropertiesImpl#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProductsOfCombustionPropertiesImpl#getN20Content <em>N20 Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProductsOfCombustionPropertiesImpl#getN20ContentAsString <em>N20 Content As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProductsOfCombustionPropertiesImpl#getCOContent <em>CO Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProductsOfCombustionPropertiesImpl#getCOContentAsString <em>CO Content As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProductsOfCombustionPropertiesImpl#getCO2Content <em>CO2 Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProductsOfCombustionPropertiesImpl#getCO2ContentAsString <em>CO2 Content As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcProductsOfCombustionPropertiesImpl extends IfcMaterialPropertiesImpl
		implements IfcProductsOfCombustionProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProductsOfCombustionPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSpecificHeatCapacity() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__SPECIFIC_HEAT_CAPACITY,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificHeatCapacity(double newSpecificHeatCapacity) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__SPECIFIC_HEAT_CAPACITY,
				newSpecificHeatCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecificHeatCapacity() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__SPECIFIC_HEAT_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecificHeatCapacity() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__SPECIFIC_HEAT_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecificHeatCapacityAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificHeatCapacityAsString(String newSpecificHeatCapacityAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING,
				newSpecificHeatCapacityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecificHeatCapacityAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecificHeatCapacityAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getN20Content() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__N20_CONTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN20Content(double newN20Content) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__N20_CONTENT, newN20Content);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetN20Content() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__N20_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetN20Content() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__N20_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getN20ContentAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__N20_CONTENT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN20ContentAsString(String newN20ContentAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__N20_CONTENT_AS_STRING,
				newN20ContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetN20ContentAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__N20_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetN20ContentAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__N20_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCOContent() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO_CONTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCOContent(double newCOContent) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO_CONTENT, newCOContent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCOContent() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCOContent() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCOContentAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO_CONTENT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCOContentAsString(String newCOContentAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO_CONTENT_AS_STRING,
				newCOContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCOContentAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCOContentAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCO2Content() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO2_CONTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCO2Content(double newCO2Content) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO2_CONTENT, newCO2Content);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCO2Content() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO2_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCO2Content() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO2_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCO2ContentAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO2_CONTENT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCO2ContentAsString(String newCO2ContentAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO2_CONTENT_AS_STRING,
				newCO2ContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCO2ContentAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO2_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCO2ContentAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES__CO2_CONTENT_AS_STRING);
	}

} //IfcProductsOfCombustionPropertiesImpl
