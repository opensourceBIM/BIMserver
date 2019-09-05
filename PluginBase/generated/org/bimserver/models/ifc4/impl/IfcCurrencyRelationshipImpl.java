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
import org.bimserver.models.ifc4.IfcCurrencyRelationship;
import org.bimserver.models.ifc4.IfcLibraryInformation;
import org.bimserver.models.ifc4.IfcMonetaryUnit;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Currency Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurrencyRelationshipImpl#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurrencyRelationshipImpl#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurrencyRelationshipImpl#getExchangeRate <em>Exchange Rate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurrencyRelationshipImpl#getExchangeRateAsString <em>Exchange Rate As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurrencyRelationshipImpl#getRateDateTime <em>Rate Date Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurrencyRelationshipImpl#getRateSource <em>Rate Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCurrencyRelationshipImpl extends IfcResourceLevelRelationshipImpl implements IfcCurrencyRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurrencyRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMonetaryUnit getRelatingMonetaryUnit() {
		return (IfcMonetaryUnit) eGet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RELATING_MONETARY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingMonetaryUnit(IfcMonetaryUnit newRelatingMonetaryUnit) {
		eSet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RELATING_MONETARY_UNIT, newRelatingMonetaryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMonetaryUnit getRelatedMonetaryUnit() {
		return (IfcMonetaryUnit) eGet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RELATED_MONETARY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedMonetaryUnit(IfcMonetaryUnit newRelatedMonetaryUnit) {
		eSet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RELATED_MONETARY_UNIT, newRelatedMonetaryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getExchangeRate() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__EXCHANGE_RATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExchangeRate(double newExchangeRate) {
		eSet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__EXCHANGE_RATE, newExchangeRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExchangeRateAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__EXCHANGE_RATE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExchangeRateAsString(String newExchangeRateAsString) {
		eSet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__EXCHANGE_RATE_AS_STRING, newExchangeRateAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRateDateTime() {
		return (String) eGet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_DATE_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRateDateTime(String newRateDateTime) {
		eSet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_DATE_TIME, newRateDateTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRateDateTime() {
		eUnset(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_DATE_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRateDateTime() {
		return eIsSet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_DATE_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLibraryInformation getRateSource() {
		return (IfcLibraryInformation) eGet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRateSource(IfcLibraryInformation newRateSource) {
		eSet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_SOURCE, newRateSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRateSource() {
		eUnset(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRateSource() {
		return eIsSet(Ifc4Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_SOURCE);
	}

} //IfcCurrencyRelationshipImpl
