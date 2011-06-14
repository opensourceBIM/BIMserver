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
import org.bimserver.models.ifc2x3.IfcGridAxis;
import org.bimserver.models.ifc2x3.IfcVirtualGridIntersection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Virtual Grid Intersection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVirtualGridIntersectionImpl#getIntersectingAxes <em>Intersecting Axes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVirtualGridIntersectionImpl#getOffsetDistances <em>Offset Distances</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVirtualGridIntersectionImpl#getOffsetDistancesAsString <em>Offset Distances As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcVirtualGridIntersectionImpl extends IdEObjectImpl implements IfcVirtualGridIntersection
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcVirtualGridIntersectionImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcVirtualGridIntersection();
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
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getIntersectingAxes()
	{
		return (EList<IfcGridAxis>)eGet(Ifc2x3Package.eINSTANCE.getIfcVirtualGridIntersection_IntersectingAxes(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Float> getOffsetDistances()
	{
		return (EList<Float>)eGet(Ifc2x3Package.eINSTANCE.getIfcVirtualGridIntersection_OffsetDistances(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getOffsetDistancesAsString()
	{
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcVirtualGridIntersection_OffsetDistancesAsString(), true);
	}

} //IfcVirtualGridIntersectionImpl
