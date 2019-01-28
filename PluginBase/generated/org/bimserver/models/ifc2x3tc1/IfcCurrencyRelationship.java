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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Currency Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getExchangeRate <em>Exchange Rate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getExchangeRateAsString <em>Exchange Rate As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRateDateTime <em>Rate Date Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRateSource <em>Rate Source</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurrencyRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcCurrencyRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Relating Monetary Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Monetary Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Monetary Unit</em>' reference.
	 * @see #setRelatingMonetaryUnit(IfcMonetaryUnit)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurrencyRelationship_RelatingMonetaryUnit()
	 * @model
	 * @generated
	 */
	IfcMonetaryUnit getRelatingMonetaryUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Monetary Unit</em>' reference.
	 * @see #getRelatingMonetaryUnit()
	 * @generated
	 */
	void setRelatingMonetaryUnit(IfcMonetaryUnit value);

	/**
	 * Returns the value of the '<em><b>Related Monetary Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Monetary Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Monetary Unit</em>' reference.
	 * @see #setRelatedMonetaryUnit(IfcMonetaryUnit)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurrencyRelationship_RelatedMonetaryUnit()
	 * @model
	 * @generated
	 */
	IfcMonetaryUnit getRelatedMonetaryUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Monetary Unit</em>' reference.
	 * @see #getRelatedMonetaryUnit()
	 * @generated
	 */
	void setRelatedMonetaryUnit(IfcMonetaryUnit value);

	/**
	 * Returns the value of the '<em><b>Exchange Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exchange Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exchange Rate</em>' attribute.
	 * @see #setExchangeRate(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurrencyRelationship_ExchangeRate()
	 * @model
	 * @generated
	 */
	double getExchangeRate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getExchangeRate <em>Exchange Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exchange Rate</em>' attribute.
	 * @see #getExchangeRate()
	 * @generated
	 */
	void setExchangeRate(double value);

	/**
	 * Returns the value of the '<em><b>Exchange Rate As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exchange Rate As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exchange Rate As String</em>' attribute.
	 * @see #setExchangeRateAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurrencyRelationship_ExchangeRateAsString()
	 * @model
	 * @generated
	 */
	String getExchangeRateAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getExchangeRateAsString <em>Exchange Rate As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exchange Rate As String</em>' attribute.
	 * @see #getExchangeRateAsString()
	 * @generated
	 */
	void setExchangeRateAsString(String value);

	/**
	 * Returns the value of the '<em><b>Rate Date Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate Date Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate Date Time</em>' reference.
	 * @see #setRateDateTime(IfcDateAndTime)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurrencyRelationship_RateDateTime()
	 * @model
	 * @generated
	 */
	IfcDateAndTime getRateDateTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRateDateTime <em>Rate Date Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate Date Time</em>' reference.
	 * @see #getRateDateTime()
	 * @generated
	 */
	void setRateDateTime(IfcDateAndTime value);

	/**
	 * Returns the value of the '<em><b>Rate Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate Source</em>' reference.
	 * @see #isSetRateSource()
	 * @see #unsetRateSource()
	 * @see #setRateSource(IfcLibraryInformation)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurrencyRelationship_RateSource()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLibraryInformation getRateSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRateSource <em>Rate Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate Source</em>' reference.
	 * @see #isSetRateSource()
	 * @see #unsetRateSource()
	 * @see #getRateSource()
	 * @generated
	 */
	void setRateSource(IfcLibraryInformation value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRateSource <em>Rate Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRateSource()
	 * @see #getRateSource()
	 * @see #setRateSource(IfcLibraryInformation)
	 * @generated
	 */
	void unsetRateSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurrencyRelationship#getRateSource <em>Rate Source</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rate Source</em>' reference is set.
	 * @see #unsetRateSource()
	 * @see #getRateSource()
	 * @see #setRateSource(IfcLibraryInformation)
	 * @generated
	 */
	boolean isSetRateSource();

} // IfcCurrencyRelationship
