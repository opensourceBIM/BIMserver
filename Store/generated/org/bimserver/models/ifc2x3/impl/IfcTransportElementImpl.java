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

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcTransportElement;
import org.bimserver.models.ifc2x3.IfcTransportElementTypeEnum;

import org.bimserver.models.ifc2x3.impl.IfcElementImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Transport Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTransportElementImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTransportElementImpl#getCapacityByWeight <em>Capacity By Weight</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTransportElementImpl#getCapacityByWeightAsString <em>Capacity By Weight As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTransportElementImpl#getCapacityByNumber <em>Capacity By Number</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTransportElementImpl#getCapacityByNumberAsString <em>Capacity By Number As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTransportElementImpl extends IfcElementImpl implements IfcTransportElement
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
	protected IfcTransportElementImpl()
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
		return Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTransportElementTypeEnum getOperationType()
	{
		return (IfcTransportElementTypeEnum)eGet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__OPERATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationType(IfcTransportElementTypeEnum newOperationType)
	{
		eSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__OPERATION_TYPE, newOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCapacityByWeight()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_WEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityByWeight(float newCapacityByWeight)
	{
		eSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_WEIGHT, newCapacityByWeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCapacityByWeight()
	{
		eUnset(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_WEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCapacityByWeight()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_WEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCapacityByWeightAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_WEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityByWeightAsString(String newCapacityByWeightAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_WEIGHT_AS_STRING, newCapacityByWeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCapacityByWeightAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_WEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCapacityByWeightAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_WEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCapacityByNumber()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_NUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityByNumber(float newCapacityByNumber)
	{
		eSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_NUMBER, newCapacityByNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCapacityByNumber()
	{
		eUnset(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_NUMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCapacityByNumber()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_NUMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCapacityByNumberAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_NUMBER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacityByNumberAsString(String newCapacityByNumberAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_NUMBER_AS_STRING, newCapacityByNumberAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCapacityByNumberAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_NUMBER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCapacityByNumberAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_TRANSPORT_ELEMENT__CAPACITY_BY_NUMBER_AS_STRING);
	}

} //IfcTransportElementImpl
