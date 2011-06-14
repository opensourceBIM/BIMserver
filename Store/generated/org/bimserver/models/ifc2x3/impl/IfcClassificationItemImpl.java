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
import org.bimserver.models.ifc2x3.IfcClassification;
import org.bimserver.models.ifc2x3.IfcClassificationItem;
import org.bimserver.models.ifc2x3.IfcClassificationItemRelationship;
import org.bimserver.models.ifc2x3.IfcClassificationNotationFacet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Classification Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcClassificationItemImpl#getNotation <em>Notation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcClassificationItemImpl#getItemOf <em>Item Of</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcClassificationItemImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcClassificationItemImpl#getIsClassifiedItemIn <em>Is Classified Item In</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcClassificationItemImpl#getIsClassifyingItemIn <em>Is Classifying Item In</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcClassificationItemImpl extends IdEObjectImpl implements IfcClassificationItem
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcClassificationItemImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcClassificationItem();
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
	public IfcClassificationNotationFacet getNotation()
	{
		return (IfcClassificationNotationFacet)eGet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_Notation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotation(IfcClassificationNotationFacet newNotation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_Notation(), newNotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassification getItemOf()
	{
		return (IfcClassification)eGet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_ItemOf(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemOf(IfcClassification newItemOf)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_ItemOf(), newItemOf);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetItemOf()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_ItemOf());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetItemOf()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_ItemOf());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_Title(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_Title(), newTitle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcClassificationItemRelationship> getIsClassifiedItemIn()
	{
		return (EList<IfcClassificationItemRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_IsClassifiedItemIn(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcClassificationItemRelationship> getIsClassifyingItemIn()
	{
		return (EList<IfcClassificationItemRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcClassificationItem_IsClassifyingItemIn(), true);
	}

} //IfcClassificationItemImpl
