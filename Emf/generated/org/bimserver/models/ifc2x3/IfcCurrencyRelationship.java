/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Currency Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getExchangeRate <em>Exchange Rate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getExchangeRateAsString <em>Exchange Rate As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRateDateTime <em>Rate Date Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRateSource <em>Rate Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyRelationship()
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
	 * @see #isSetRelatingMonetaryUnit()
	 * @see #unsetRelatingMonetaryUnit()
	 * @see #setRelatingMonetaryUnit(IfcMonetaryUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyRelationship_RelatingMonetaryUnit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMonetaryUnit getRelatingMonetaryUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Monetary Unit</em>' reference.
	 * @see #isSetRelatingMonetaryUnit()
	 * @see #unsetRelatingMonetaryUnit()
	 * @see #getRelatingMonetaryUnit()
	 * @generated
	 */
	void setRelatingMonetaryUnit(IfcMonetaryUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingMonetaryUnit()
	 * @see #getRelatingMonetaryUnit()
	 * @see #setRelatingMonetaryUnit(IfcMonetaryUnit)
	 * @generated
	 */
	void unsetRelatingMonetaryUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Monetary Unit</em>' reference is set.
	 * @see #unsetRelatingMonetaryUnit()
	 * @see #getRelatingMonetaryUnit()
	 * @see #setRelatingMonetaryUnit(IfcMonetaryUnit)
	 * @generated
	 */
	boolean isSetRelatingMonetaryUnit();

	/**
	 * Returns the value of the '<em><b>Related Monetary Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Monetary Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Monetary Unit</em>' reference.
	 * @see #isSetRelatedMonetaryUnit()
	 * @see #unsetRelatedMonetaryUnit()
	 * @see #setRelatedMonetaryUnit(IfcMonetaryUnit)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyRelationship_RelatedMonetaryUnit()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcMonetaryUnit getRelatedMonetaryUnit();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Monetary Unit</em>' reference.
	 * @see #isSetRelatedMonetaryUnit()
	 * @see #unsetRelatedMonetaryUnit()
	 * @see #getRelatedMonetaryUnit()
	 * @generated
	 */
	void setRelatedMonetaryUnit(IfcMonetaryUnit value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedMonetaryUnit()
	 * @see #getRelatedMonetaryUnit()
	 * @see #setRelatedMonetaryUnit(IfcMonetaryUnit)
	 * @generated
	 */
	void unsetRelatedMonetaryUnit();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Monetary Unit</em>' reference is set.
	 * @see #unsetRelatedMonetaryUnit()
	 * @see #getRelatedMonetaryUnit()
	 * @see #setRelatedMonetaryUnit(IfcMonetaryUnit)
	 * @generated
	 */
	boolean isSetRelatedMonetaryUnit();

	/**
	 * Returns the value of the '<em><b>Exchange Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exchange Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exchange Rate</em>' attribute.
	 * @see #isSetExchangeRate()
	 * @see #unsetExchangeRate()
	 * @see #setExchangeRate(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyRelationship_ExchangeRate()
	 * @model unsettable="true"
	 * @generated
	 */
	double getExchangeRate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getExchangeRate <em>Exchange Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exchange Rate</em>' attribute.
	 * @see #isSetExchangeRate()
	 * @see #unsetExchangeRate()
	 * @see #getExchangeRate()
	 * @generated
	 */
	void setExchangeRate(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getExchangeRate <em>Exchange Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExchangeRate()
	 * @see #getExchangeRate()
	 * @see #setExchangeRate(double)
	 * @generated
	 */
	void unsetExchangeRate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getExchangeRate <em>Exchange Rate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exchange Rate</em>' attribute is set.
	 * @see #unsetExchangeRate()
	 * @see #getExchangeRate()
	 * @see #setExchangeRate(double)
	 * @generated
	 */
	boolean isSetExchangeRate();

	/**
	 * Returns the value of the '<em><b>Exchange Rate As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exchange Rate As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exchange Rate As String</em>' attribute.
	 * @see #isSetExchangeRateAsString()
	 * @see #unsetExchangeRateAsString()
	 * @see #setExchangeRateAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyRelationship_ExchangeRateAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getExchangeRateAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getExchangeRateAsString <em>Exchange Rate As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exchange Rate As String</em>' attribute.
	 * @see #isSetExchangeRateAsString()
	 * @see #unsetExchangeRateAsString()
	 * @see #getExchangeRateAsString()
	 * @generated
	 */
	void setExchangeRateAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getExchangeRateAsString <em>Exchange Rate As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExchangeRateAsString()
	 * @see #getExchangeRateAsString()
	 * @see #setExchangeRateAsString(String)
	 * @generated
	 */
	void unsetExchangeRateAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getExchangeRateAsString <em>Exchange Rate As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exchange Rate As String</em>' attribute is set.
	 * @see #unsetExchangeRateAsString()
	 * @see #getExchangeRateAsString()
	 * @see #setExchangeRateAsString(String)
	 * @generated
	 */
	boolean isSetExchangeRateAsString();

	/**
	 * Returns the value of the '<em><b>Rate Date Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate Date Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate Date Time</em>' reference.
	 * @see #isSetRateDateTime()
	 * @see #unsetRateDateTime()
	 * @see #setRateDateTime(IfcDateAndTime)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyRelationship_RateDateTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateAndTime getRateDateTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRateDateTime <em>Rate Date Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate Date Time</em>' reference.
	 * @see #isSetRateDateTime()
	 * @see #unsetRateDateTime()
	 * @see #getRateDateTime()
	 * @generated
	 */
	void setRateDateTime(IfcDateAndTime value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRateDateTime <em>Rate Date Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRateDateTime()
	 * @see #getRateDateTime()
	 * @see #setRateDateTime(IfcDateAndTime)
	 * @generated
	 */
	void unsetRateDateTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRateDateTime <em>Rate Date Time</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rate Date Time</em>' reference is set.
	 * @see #unsetRateDateTime()
	 * @see #getRateDateTime()
	 * @see #setRateDateTime(IfcDateAndTime)
	 * @generated
	 */
	boolean isSetRateDateTime();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyRelationship_RateSource()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLibraryInformation getRateSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRateSource <em>Rate Source</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRateSource <em>Rate Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRateSource()
	 * @see #getRateSource()
	 * @see #setRateSource(IfcLibraryInformation)
	 * @generated
	 */
	void unsetRateSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCurrencyRelationship#getRateSource <em>Rate Source</em>}' reference is set.
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
