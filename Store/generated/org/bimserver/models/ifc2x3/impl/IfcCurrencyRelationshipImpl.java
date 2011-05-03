/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCurrencyRelationship;
import org.bimserver.models.ifc2x3.IfcDateAndTime;
import org.bimserver.models.ifc2x3.IfcLibraryInformation;
import org.bimserver.models.ifc2x3.IfcMonetaryUnit;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Currency Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurrencyRelationshipImpl#getRelatingMonetaryUnit <em>Relating Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurrencyRelationshipImpl#getRelatedMonetaryUnit <em>Related Monetary Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurrencyRelationshipImpl#getExchangeRate <em>Exchange Rate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurrencyRelationshipImpl#getExchangeRateAsString <em>Exchange Rate As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurrencyRelationshipImpl#getRateDateTime <em>Rate Date Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurrencyRelationshipImpl#getRateSource <em>Rate Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCurrencyRelationshipImpl extends IdEObjectImpl implements IfcCurrencyRelationship
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurrencyRelationshipImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMonetaryUnit getRelatingMonetaryUnit()
	{
		return (IfcMonetaryUnit)eGet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RELATING_MONETARY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingMonetaryUnit(IfcMonetaryUnit newRelatingMonetaryUnit)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RELATING_MONETARY_UNIT, newRelatingMonetaryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMonetaryUnit getRelatedMonetaryUnit()
	{
		return (IfcMonetaryUnit)eGet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RELATED_MONETARY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedMonetaryUnit(IfcMonetaryUnit newRelatedMonetaryUnit)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RELATED_MONETARY_UNIT, newRelatedMonetaryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getExchangeRate()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__EXCHANGE_RATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExchangeRate(float newExchangeRate)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__EXCHANGE_RATE, newExchangeRate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExchangeRateAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__EXCHANGE_RATE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExchangeRateAsString(String newExchangeRateAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__EXCHANGE_RATE_AS_STRING, newExchangeRateAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateAndTime getRateDateTime()
	{
		return (IfcDateAndTime)eGet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_DATE_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRateDateTime(IfcDateAndTime newRateDateTime)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_DATE_TIME, newRateDateTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLibraryInformation getRateSource()
	{
		return (IfcLibraryInformation)eGet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRateSource(IfcLibraryInformation newRateSource)
	{
		eSet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_SOURCE, newRateSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRateSource()
	{
		eUnset(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRateSource()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_CURRENCY_RELATIONSHIP__RATE_SOURCE);
	}

} //IfcCurrencyRelationshipImpl
