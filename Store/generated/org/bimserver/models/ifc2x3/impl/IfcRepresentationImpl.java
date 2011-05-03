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
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

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
		return Ifc2x3Package.Literals.IFC_REPRESENTATION;
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
		return (IfcRepresentationContext)eGet(Ifc2x3Package.Literals.IFC_REPRESENTATION__CONTEXT_OF_ITEMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextOfItems(IfcRepresentationContext newContextOfItems)
	{
		eSet(Ifc2x3Package.Literals.IFC_REPRESENTATION__CONTEXT_OF_ITEMS, newContextOfItems);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepresentationIdentifier()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentationIdentifier(String newRepresentationIdentifier)
	{
		eSet(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_IDENTIFIER, newRepresentationIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepresentationIdentifier()
	{
		eUnset(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepresentationIdentifier()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepresentationType()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentationType(String newRepresentationType)
	{
		eSet(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_TYPE, newRepresentationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepresentationType()
	{
		eUnset(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepresentationType()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRepresentationItem> getItems()
	{
		return (EList<IfcRepresentationItem>)eGet(Ifc2x3Package.Literals.IFC_REPRESENTATION__ITEMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRepresentationMap> getRepresentationMap()
	{
		return (EList<IfcRepresentationMap>)eGet(Ifc2x3Package.Literals.IFC_REPRESENTATION__REPRESENTATION_MAP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcProductRepresentation> getOfProductRepresentation()
	{
		return (EList<IfcProductRepresentation>)eGet(Ifc2x3Package.Literals.IFC_REPRESENTATION__OF_PRODUCT_REPRESENTATION, true);
	}

} //IfcRepresentationImpl
