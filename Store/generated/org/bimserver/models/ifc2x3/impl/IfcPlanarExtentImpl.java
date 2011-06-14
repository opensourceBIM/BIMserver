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
import org.bimserver.models.ifc2x3.IfcPlanarExtent;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Planar Extent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPlanarExtentImpl#getSizeInX <em>Size In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPlanarExtentImpl#getSizeInXAsString <em>Size In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPlanarExtentImpl#getSizeInY <em>Size In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPlanarExtentImpl#getSizeInYAsString <em>Size In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPlanarExtentImpl extends IfcGeometricRepresentationItemImpl implements IfcPlanarExtent
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPlanarExtentImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcPlanarExtent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSizeInX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcPlanarExtent_SizeInX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeInX(float newSizeInX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPlanarExtent_SizeInX(), newSizeInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSizeInXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPlanarExtent_SizeInXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeInXAsString(String newSizeInXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPlanarExtent_SizeInXAsString(), newSizeInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSizeInY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcPlanarExtent_SizeInY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeInY(float newSizeInY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPlanarExtent_SizeInY(), newSizeInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSizeInYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPlanarExtent_SizeInYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeInYAsString(String newSizeInYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPlanarExtent_SizeInYAsString(), newSizeInYAsString);
	}

} //IfcPlanarExtentImpl
