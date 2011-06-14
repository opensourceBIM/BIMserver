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
import org.bimserver.models.ifc2x3.IfcMove;
import org.bimserver.models.ifc2x3.IfcSpatialStructureElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Move</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMoveImpl#getMoveFrom <em>Move From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMoveImpl#getMoveTo <em>Move To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMoveImpl#getPunchList <em>Punch List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMoveImpl extends IfcTaskImpl implements IfcMove
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMoveImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcMove();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getMoveFrom()
	{
		return (IfcSpatialStructureElement)eGet(Ifc2x3Package.eINSTANCE.getIfcMove_MoveFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoveFrom(IfcSpatialStructureElement newMoveFrom)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMove_MoveFrom(), newMoveFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getMoveTo()
	{
		return (IfcSpatialStructureElement)eGet(Ifc2x3Package.eINSTANCE.getIfcMove_MoveTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoveTo(IfcSpatialStructureElement newMoveTo)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMove_MoveTo(), newMoveTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getPunchList()
	{
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcMove_PunchList(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPunchList()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMove_PunchList());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPunchList()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMove_PunchList());
	}

} //IfcMoveImpl
