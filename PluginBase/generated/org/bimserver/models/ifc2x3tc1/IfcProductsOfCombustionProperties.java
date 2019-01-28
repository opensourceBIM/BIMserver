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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcProductsOfCombustionProperties extends IfcMaterialProperties {
	/**
	 * Returns the value of the '<em><b>Specific Heat Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific Heat Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific Heat Capacity</em>' attribute.
	 * @see #isSetSpecificHeatCapacity()
	 * @see #unsetSpecificHeatCapacity()
	 * @see #setSpecificHeatCapacity(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProductsOfCombustionProperties_SpecificHeatCapacity()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSpecificHeatCapacity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specific Heat Capacity</em>' attribute.
	 * @see #isSetSpecificHeatCapacity()
	 * @see #unsetSpecificHeatCapacity()
	 * @see #getSpecificHeatCapacity()
	 * @generated
	 */
	void setSpecificHeatCapacity(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecificHeatCapacity()
	 * @see #getSpecificHeatCapacity()
	 * @see #setSpecificHeatCapacity(double)
	 * @generated
	 */
	void unsetSpecificHeatCapacity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Specific Heat Capacity</em>' attribute is set.
	 * @see #unsetSpecificHeatCapacity()
	 * @see #getSpecificHeatCapacity()
	 * @see #setSpecificHeatCapacity(double)
	 * @generated
	 */
	boolean isSetSpecificHeatCapacity();

	/**
	 * Returns the value of the '<em><b>Specific Heat Capacity As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific Heat Capacity As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific Heat Capacity As String</em>' attribute.
	 * @see #isSetSpecificHeatCapacityAsString()
	 * @see #unsetSpecificHeatCapacityAsString()
	 * @see #setSpecificHeatCapacityAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProductsOfCombustionProperties_SpecificHeatCapacityAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSpecificHeatCapacityAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specific Heat Capacity As String</em>' attribute.
	 * @see #isSetSpecificHeatCapacityAsString()
	 * @see #unsetSpecificHeatCapacityAsString()
	 * @see #getSpecificHeatCapacityAsString()
	 * @generated
	 */
	void setSpecificHeatCapacityAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecificHeatCapacityAsString()
	 * @see #getSpecificHeatCapacityAsString()
	 * @see #setSpecificHeatCapacityAsString(String)
	 * @generated
	 */
	void unsetSpecificHeatCapacityAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Specific Heat Capacity As String</em>' attribute is set.
	 * @see #unsetSpecificHeatCapacityAsString()
	 * @see #getSpecificHeatCapacityAsString()
	 * @see #setSpecificHeatCapacityAsString(String)
	 * @generated
	 */
	boolean isSetSpecificHeatCapacityAsString();

	/**
	 * Returns the value of the '<em><b>N20 Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>N20 Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>N20 Content</em>' attribute.
	 * @see #isSetN20Content()
	 * @see #unsetN20Content()
	 * @see #setN20Content(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProductsOfCombustionProperties_N20Content()
	 * @model unsettable="true"
	 * @generated
	 */
	double getN20Content();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getN20Content <em>N20 Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N20 Content</em>' attribute.
	 * @see #isSetN20Content()
	 * @see #unsetN20Content()
	 * @see #getN20Content()
	 * @generated
	 */
	void setN20Content(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getN20Content <em>N20 Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetN20Content()
	 * @see #getN20Content()
	 * @see #setN20Content(double)
	 * @generated
	 */
	void unsetN20Content();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getN20Content <em>N20 Content</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>N20 Content</em>' attribute is set.
	 * @see #unsetN20Content()
	 * @see #getN20Content()
	 * @see #setN20Content(double)
	 * @generated
	 */
	boolean isSetN20Content();

	/**
	 * Returns the value of the '<em><b>N20 Content As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>N20 Content As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>N20 Content As String</em>' attribute.
	 * @see #isSetN20ContentAsString()
	 * @see #unsetN20ContentAsString()
	 * @see #setN20ContentAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProductsOfCombustionProperties_N20ContentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getN20ContentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getN20ContentAsString <em>N20 Content As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N20 Content As String</em>' attribute.
	 * @see #isSetN20ContentAsString()
	 * @see #unsetN20ContentAsString()
	 * @see #getN20ContentAsString()
	 * @generated
	 */
	void setN20ContentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getN20ContentAsString <em>N20 Content As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetN20ContentAsString()
	 * @see #getN20ContentAsString()
	 * @see #setN20ContentAsString(String)
	 * @generated
	 */
	void unsetN20ContentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getN20ContentAsString <em>N20 Content As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>N20 Content As String</em>' attribute is set.
	 * @see #unsetN20ContentAsString()
	 * @see #getN20ContentAsString()
	 * @see #setN20ContentAsString(String)
	 * @generated
	 */
	boolean isSetN20ContentAsString();

	/**
	 * Returns the value of the '<em><b>CO Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CO Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CO Content</em>' attribute.
	 * @see #isSetCOContent()
	 * @see #unsetCOContent()
	 * @see #setCOContent(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProductsOfCombustionProperties_COContent()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCOContent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCOContent <em>CO Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CO Content</em>' attribute.
	 * @see #isSetCOContent()
	 * @see #unsetCOContent()
	 * @see #getCOContent()
	 * @generated
	 */
	void setCOContent(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCOContent <em>CO Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCOContent()
	 * @see #getCOContent()
	 * @see #setCOContent(double)
	 * @generated
	 */
	void unsetCOContent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCOContent <em>CO Content</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>CO Content</em>' attribute is set.
	 * @see #unsetCOContent()
	 * @see #getCOContent()
	 * @see #setCOContent(double)
	 * @generated
	 */
	boolean isSetCOContent();

	/**
	 * Returns the value of the '<em><b>CO Content As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CO Content As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CO Content As String</em>' attribute.
	 * @see #isSetCOContentAsString()
	 * @see #unsetCOContentAsString()
	 * @see #setCOContentAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProductsOfCombustionProperties_COContentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCOContentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCOContentAsString <em>CO Content As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CO Content As String</em>' attribute.
	 * @see #isSetCOContentAsString()
	 * @see #unsetCOContentAsString()
	 * @see #getCOContentAsString()
	 * @generated
	 */
	void setCOContentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCOContentAsString <em>CO Content As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCOContentAsString()
	 * @see #getCOContentAsString()
	 * @see #setCOContentAsString(String)
	 * @generated
	 */
	void unsetCOContentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCOContentAsString <em>CO Content As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>CO Content As String</em>' attribute is set.
	 * @see #unsetCOContentAsString()
	 * @see #getCOContentAsString()
	 * @see #setCOContentAsString(String)
	 * @generated
	 */
	boolean isSetCOContentAsString();

	/**
	 * Returns the value of the '<em><b>CO2 Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CO2 Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CO2 Content</em>' attribute.
	 * @see #isSetCO2Content()
	 * @see #unsetCO2Content()
	 * @see #setCO2Content(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProductsOfCombustionProperties_CO2Content()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCO2Content();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCO2Content <em>CO2 Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CO2 Content</em>' attribute.
	 * @see #isSetCO2Content()
	 * @see #unsetCO2Content()
	 * @see #getCO2Content()
	 * @generated
	 */
	void setCO2Content(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCO2Content <em>CO2 Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCO2Content()
	 * @see #getCO2Content()
	 * @see #setCO2Content(double)
	 * @generated
	 */
	void unsetCO2Content();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCO2Content <em>CO2 Content</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>CO2 Content</em>' attribute is set.
	 * @see #unsetCO2Content()
	 * @see #getCO2Content()
	 * @see #setCO2Content(double)
	 * @generated
	 */
	boolean isSetCO2Content();

	/**
	 * Returns the value of the '<em><b>CO2 Content As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CO2 Content As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CO2 Content As String</em>' attribute.
	 * @see #isSetCO2ContentAsString()
	 * @see #unsetCO2ContentAsString()
	 * @see #setCO2ContentAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcProductsOfCombustionProperties_CO2ContentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCO2ContentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCO2ContentAsString <em>CO2 Content As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CO2 Content As String</em>' attribute.
	 * @see #isSetCO2ContentAsString()
	 * @see #unsetCO2ContentAsString()
	 * @see #getCO2ContentAsString()
	 * @generated
	 */
	void setCO2ContentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCO2ContentAsString <em>CO2 Content As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCO2ContentAsString()
	 * @see #getCO2ContentAsString()
	 * @see #setCO2ContentAsString(String)
	 * @generated
	 */
	void unsetCO2ContentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcProductsOfCombustionProperties#getCO2ContentAsString <em>CO2 Content As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>CO2 Content As String</em>' attribute is set.
	 * @see #unsetCO2ContentAsString()
	 * @see #getCO2ContentAsString()
	 * @see #setCO2ContentAsString(String)
	 * @generated
	 */
	boolean isSetCO2ContentAsString();

} // IfcProductsOfCombustionProperties
