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

import org.bimserver.models.ifc2x3.impl.IfcTaskImpl;

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
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

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
		return Ifc2x3Package.Literals.IFC_MOVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getMoveFrom()
	{
		return (IfcSpatialStructureElement)eGet(Ifc2x3Package.Literals.IFC_MOVE__MOVE_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoveFrom(IfcSpatialStructureElement newMoveFrom)
	{
		eSet(Ifc2x3Package.Literals.IFC_MOVE__MOVE_FROM, newMoveFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getMoveTo()
	{
		return (IfcSpatialStructureElement)eGet(Ifc2x3Package.Literals.IFC_MOVE__MOVE_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoveTo(IfcSpatialStructureElement newMoveTo)
	{
		eSet(Ifc2x3Package.Literals.IFC_MOVE__MOVE_TO, newMoveTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getPunchList()
	{
		return (EList<String>)eGet(Ifc2x3Package.Literals.IFC_MOVE__PUNCH_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPunchList()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MOVE__PUNCH_LIST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPunchList()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MOVE__PUNCH_LIST);
	}

} //IfcMoveImpl
