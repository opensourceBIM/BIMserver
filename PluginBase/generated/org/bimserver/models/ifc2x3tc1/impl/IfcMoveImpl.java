/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3tc1.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcMove;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Move</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMoveImpl#getMoveFrom <em>Move From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMoveImpl#getMoveTo <em>Move To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMoveImpl#getPunchList <em>Punch List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMoveImpl extends IfcTaskImpl implements IfcMove {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMoveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_MOVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getMoveFrom() {
		return (IfcSpatialStructureElement) eGet(Ifc2x3tc1Package.Literals.IFC_MOVE__MOVE_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoveFrom(IfcSpatialStructureElement newMoveFrom) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MOVE__MOVE_FROM, newMoveFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getMoveTo() {
		return (IfcSpatialStructureElement) eGet(Ifc2x3tc1Package.Literals.IFC_MOVE__MOVE_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoveTo(IfcSpatialStructureElement newMoveTo) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MOVE__MOVE_TO, newMoveTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getPunchList() {
		return (EList<String>) eGet(Ifc2x3tc1Package.Literals.IFC_MOVE__PUNCH_LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPunchList() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MOVE__PUNCH_LIST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPunchList() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MOVE__PUNCH_LIST);
	}

} //IfcMoveImpl
