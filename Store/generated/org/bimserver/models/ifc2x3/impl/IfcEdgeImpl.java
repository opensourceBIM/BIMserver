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
import org.bimserver.models.ifc2x3.IfcEdge;
import org.bimserver.models.ifc2x3.IfcVertex;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeImpl#getEdgeStart <em>Edge Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeImpl#getEdgeEnd <em>Edge End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEdgeImpl extends IfcTopologicalRepresentationItemImpl implements IfcEdge
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEdgeImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcEdge();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertex getEdgeStart()
	{
		return (IfcVertex)eGet(Ifc2x3Package.eINSTANCE.getIfcEdge_EdgeStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeStart(IfcVertex newEdgeStart)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdge_EdgeStart(), newEdgeStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertex getEdgeEnd()
	{
		return (IfcVertex)eGet(Ifc2x3Package.eINSTANCE.getIfcEdge_EdgeEnd(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeEnd(IfcVertex newEdgeEnd)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdge_EdgeEnd(), newEdgeEnd);
	}

} //IfcEdgeImpl
