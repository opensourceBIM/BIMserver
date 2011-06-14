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
import org.bimserver.models.ifc2x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3.IfcRelDefinesByType;
import org.bimserver.models.ifc2x3.IfcTypeObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Type Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTypeObjectImpl#getApplicableOccurrence <em>Applicable Occurrence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTypeObjectImpl#getHasPropertySets <em>Has Property Sets</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTypeObjectImpl#getObjectTypeOf <em>Object Type Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTypeObjectImpl extends IfcObjectDefinitionImpl implements IfcTypeObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTypeObjectImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcTypeObject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicableOccurrence()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ApplicableOccurrence(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicableOccurrence(String newApplicableOccurrence)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ApplicableOccurrence(), newApplicableOccurrence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApplicableOccurrence()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ApplicableOccurrence());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApplicableOccurrence()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ApplicableOccurrence());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPropertySetDefinition> getHasPropertySets()
	{
		return (EList<IfcPropertySetDefinition>)eGet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_HasPropertySets(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasPropertySets()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTypeObject_HasPropertySets());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasPropertySets()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_HasPropertySets());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelDefinesByType> getObjectTypeOf()
	{
		return (EList<IfcRelDefinesByType>)eGet(Ifc2x3Package.eINSTANCE.getIfcTypeObject_ObjectTypeOf(), true);
	}

} //IfcTypeObjectImpl
