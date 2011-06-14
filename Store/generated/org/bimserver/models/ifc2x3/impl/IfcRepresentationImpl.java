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
import org.bimserver.models.ifc2x3.IfcProductRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentationContext;
import org.bimserver.models.ifc2x3.IfcRepresentationItem;
import org.bimserver.models.ifc2x3.IfcRepresentationMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationImpl#getContextOfItems <em>Context Of Items</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationImpl#getRepresentationIdentifier <em>Representation Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationImpl#getRepresentationType <em>Representation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationImpl#getRepresentationMap <em>Representation Map</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRepresentationImpl#getOfProductRepresentation <em>Of Product Representation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRepresentationImpl extends IdEObjectImpl implements IfcRepresentation
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRepresentationImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRepresentation();
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
	public IfcRepresentationContext getContextOfItems()
	{
		return (IfcRepresentationContext)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_ContextOfItems(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextOfItems(IfcRepresentationContext newContextOfItems)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_ContextOfItems(), newContextOfItems);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepresentationIdentifier()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationIdentifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentationIdentifier(String newRepresentationIdentifier)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationIdentifier(), newRepresentationIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepresentationIdentifier()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationIdentifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepresentationIdentifier()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationIdentifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepresentationType()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentationType(String newRepresentationType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationType(), newRepresentationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepresentationType()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepresentationType()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRepresentationItem> getItems()
	{
		return (EList<IfcRepresentationItem>)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_Items(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRepresentationMap> getRepresentationMap()
	{
		return (EList<IfcRepresentationMap>)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_RepresentationMap(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcProductRepresentation> getOfProductRepresentation()
	{
		return (EList<IfcProductRepresentation>)eGet(Ifc2x3Package.eINSTANCE.getIfcRepresentation_OfProductRepresentation(), true);
	}

} //IfcRepresentationImpl
