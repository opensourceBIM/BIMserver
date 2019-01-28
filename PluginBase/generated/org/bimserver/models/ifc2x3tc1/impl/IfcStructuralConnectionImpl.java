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
import org.bimserver.models.ifc2x3tc1.IfcBoundaryCondition;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsStructuralMember;
import org.bimserver.models.ifc2x3tc1.IfcStructuralConnection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralConnectionImpl#getAppliedCondition <em>Applied Condition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralConnectionImpl#getConnectsStructuralMembers <em>Connects Structural Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralConnectionImpl extends IfcStructuralItemImpl implements IfcStructuralConnection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundaryCondition getAppliedCondition() {
		return (IfcBoundaryCondition) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_CONNECTION__APPLIED_CONDITION,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedCondition(IfcBoundaryCondition newAppliedCondition) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_CONNECTION__APPLIED_CONDITION, newAppliedCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAppliedCondition() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_CONNECTION__APPLIED_CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAppliedCondition() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_CONNECTION__APPLIED_CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsStructuralMember> getConnectsStructuralMembers() {
		return (EList<IfcRelConnectsStructuralMember>) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_CONNECTION__CONNECTS_STRUCTURAL_MEMBERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectsStructuralMembers() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_CONNECTION__CONNECTS_STRUCTURAL_MEMBERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectsStructuralMembers() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_CONNECTION__CONNECTS_STRUCTURAL_MEMBERS);
	}

} //IfcStructuralConnectionImpl
