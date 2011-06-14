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
import org.bimserver.models.ifc2x3.IfcObjectPlacement;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcProductRepresentation;
import org.bimserver.models.ifc2x3.IfcRelAssignsToProduct;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Product</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductImpl#getObjectPlacement <em>Object Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductImpl#getRepresentation <em>Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductImpl#getReferencedBy <em>Referenced By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcProductImpl extends IfcObjectImpl implements IfcProduct
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProductImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcProduct();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectPlacement getObjectPlacement()
	{
		return (IfcObjectPlacement)eGet(Ifc2x3Package.eINSTANCE.getIfcProduct_ObjectPlacement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectPlacement(IfcObjectPlacement newObjectPlacement)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProduct_ObjectPlacement(), newObjectPlacement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetObjectPlacement()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProduct_ObjectPlacement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetObjectPlacement()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProduct_ObjectPlacement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProductRepresentation getRepresentation()
	{
		return (IfcProductRepresentation)eGet(Ifc2x3Package.eINSTANCE.getIfcProduct_Representation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentation(IfcProductRepresentation newRepresentation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProduct_Representation(), newRepresentation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepresentation()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProduct_Representation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepresentation()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProduct_Representation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelAssignsToProduct> getReferencedBy()
	{
		return (EList<IfcRelAssignsToProduct>)eGet(Ifc2x3Package.eINSTANCE.getIfcProduct_ReferencedBy(), true);
	}

} //IfcProductImpl
