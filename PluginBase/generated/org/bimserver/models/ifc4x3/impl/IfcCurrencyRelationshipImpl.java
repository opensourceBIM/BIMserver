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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcCurrencyRelationship;
import org.bimserver.models.ifc4x3.IfcLibraryInformation;
import org.bimserver.models.ifc4x3.IfcMonetaryUnit;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Currency Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurrencyRelationshipImpl#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurrencyRelationshipImpl#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurrencyRelationshipImpl#getExchangeRate <em>Exchange Rate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurrencyRelationshipImpl#getExchangeRateAsString <em>Exchange Rate As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurrencyRelationshipImpl#getRateDateTime <em>Rate Date Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurrencyRelationshipImpl#getRateSource <em>Rate Source</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMonetaryUnit getRelatingMonetaryUnit() {
		return (IfcMonetaryUnit) eGet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RelatingMonetaryUnit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingMonetaryUnit(IfcMonetaryUnit newRelatingMonetaryUnit) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RelatingMonetaryUnit(), newRelatingMonetaryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMonetaryUnit getRelatedMonetaryUnit() {
		return (IfcMonetaryUnit) eGet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RelatedMonetaryUnit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedMonetaryUnit(IfcMonetaryUnit newRelatedMonetaryUnit) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RelatedMonetaryUnit(), newRelatedMonetaryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getExchangeRate() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_ExchangeRate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExchangeRate(double newExchangeRate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_ExchangeRate(), newExchangeRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExchangeRateAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_ExchangeRateAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExchangeRateAsString(String newExchangeRateAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_ExchangeRateAsString(), newExchangeRateAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRateDateTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RateDateTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRateDateTime(String newRateDateTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RateDateTime(), newRateDateTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRateDateTime() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RateDateTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRateDateTime() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RateDateTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLibraryInformation getRateSource() {
		return (IfcLibraryInformation) eGet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RateSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRateSource(IfcLibraryInformation newRateSource) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RateSource(), newRateSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRateSource() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RateSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRateSource() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCurrencyRelationship_RateSource());
	}

} //IfcCurrencyRelationshipImpl
