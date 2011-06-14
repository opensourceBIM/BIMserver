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
import org.bimserver.models.ifc2x3.IfcDirection;
import org.bimserver.models.ifc2x3.IfcExtrudedAreaSolid;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Extruded Area Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcExtrudedAreaSolidImpl#getExtrudedDirection <em>Extruded Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcExtrudedAreaSolidImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcExtrudedAreaSolidImpl#getDepthAsString <em>Depth As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcExtrudedAreaSolidImpl extends IfcSweptAreaSolidImpl implements IfcExtrudedAreaSolid
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcExtrudedAreaSolidImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcExtrudedAreaSolid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getExtrudedDirection()
	{
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcExtrudedAreaSolid_ExtrudedDirection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtrudedDirection(IfcDirection newExtrudedDirection)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcExtrudedAreaSolid_ExtrudedDirection(), newExtrudedDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcExtrudedAreaSolid_Depth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepth(float newDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcExtrudedAreaSolid_Depth(), newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcExtrudedAreaSolid_DepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepthAsString(String newDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcExtrudedAreaSolid_DepthAsString(), newDepthAsString);
	}

} //IfcExtrudedAreaSolidImpl
