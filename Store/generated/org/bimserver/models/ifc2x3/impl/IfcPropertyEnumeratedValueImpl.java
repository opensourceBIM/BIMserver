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
import org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3.IfcValue;

import org.bimserver.models.ifc2x3.impl.IfcSimplePropertyImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Enumerated Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyEnumeratedValueImpl#getEnumerationValues <em>Enumeration Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyEnumeratedValueImpl#getEnumerationReference <em>Enumeration Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPropertyEnumeratedValueImpl extends IfcSimplePropertyImpl implements IfcPropertyEnumeratedValue
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
	protected IfcPropertyEnumeratedValueImpl()
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
		return Ifc2x3Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getEnumerationValues()
	{
		return (EList<IfcValue>)eGet(Ifc2x3Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyEnumeration getEnumerationReference()
	{
		return (IfcPropertyEnumeration)eGet(Ifc2x3Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumerationReference(IfcPropertyEnumeration newEnumerationReference)
	{
		eSet(Ifc2x3Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_REFERENCE, newEnumerationReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEnumerationReference()
	{
		eUnset(Ifc2x3Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEnumerationReference()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_PROPERTY_ENUMERATED_VALUE__ENUMERATION_REFERENCE);
	}

} //IfcPropertyEnumeratedValueImpl
