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
import org.bimserver.models.ifc2x3.IfcObjectReferenceSelect;
import org.bimserver.models.ifc2x3.IfcPropertyReferenceValue;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Reference Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyReferenceValueImpl#getUsageName <em>Usage Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyReferenceValueImpl#getPropertyReference <em>Property Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPropertyReferenceValueImpl extends IfcSimplePropertyImpl implements IfcPropertyReferenceValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyReferenceValueImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsageName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_UsageName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageName(String newUsageName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_UsageName(), newUsageName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsageName()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_UsageName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsageName()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_UsageName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectReferenceSelect getPropertyReference()
	{
		return (IfcObjectReferenceSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_PropertyReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyReference(IfcObjectReferenceSelect newPropertyReference)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_PropertyReference(), newPropertyReference);
	}

} //IfcPropertyReferenceValueImpl
