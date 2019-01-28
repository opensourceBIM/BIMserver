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
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBoundaryCondition;
import org.bimserver.models.ifc2x3tc1.IfcRelConnectsStructuralMember;
import org.bimserver.models.ifc2x3tc1.IfcStructuralConnection;
import org.bimserver.models.ifc2x3tc1.IfcStructuralConnectionCondition;
import org.bimserver.models.ifc2x3tc1.IfcStructuralMember;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Structural Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsStructuralMemberImpl#getRelatingStructuralMember <em>Relating Structural Member</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsStructuralMemberImpl#getRelatedStructuralConnection <em>Related Structural Connection</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsStructuralMemberImpl#getAppliedCondition <em>Applied Condition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsStructuralMemberImpl#getAdditionalConditions <em>Additional Conditions</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsStructuralMemberImpl#getSupportedLength <em>Supported Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsStructuralMemberImpl#getSupportedLengthAsString <em>Supported Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelConnectsStructuralMemberImpl#getConditionCoordinateSystem <em>Condition Coordinate System</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelConnectsStructuralMemberImpl extends IfcRelConnectsImpl implements IfcRelConnectsStructuralMember {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsStructuralMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralMember getRelatingStructuralMember() {
		return (IfcStructuralMember) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__RELATING_STRUCTURAL_MEMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingStructuralMember(IfcStructuralMember newRelatingStructuralMember) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__RELATING_STRUCTURAL_MEMBER,
				newRelatingStructuralMember);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralConnection getRelatedStructuralConnection() {
		return (IfcStructuralConnection) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__RELATED_STRUCTURAL_CONNECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedStructuralConnection(IfcStructuralConnection newRelatedStructuralConnection) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__RELATED_STRUCTURAL_CONNECTION,
				newRelatedStructuralConnection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundaryCondition getAppliedCondition() {
		return (IfcBoundaryCondition) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__APPLIED_CONDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedCondition(IfcBoundaryCondition newAppliedCondition) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__APPLIED_CONDITION, newAppliedCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAppliedCondition() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__APPLIED_CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAppliedCondition() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__APPLIED_CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralConnectionCondition getAdditionalConditions() {
		return (IfcStructuralConnectionCondition) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__ADDITIONAL_CONDITIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalConditions(IfcStructuralConnectionCondition newAdditionalConditions) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__ADDITIONAL_CONDITIONS,
				newAdditionalConditions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAdditionalConditions() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__ADDITIONAL_CONDITIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAdditionalConditions() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__ADDITIONAL_CONDITIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSupportedLength() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__SUPPORTED_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedLength(double newSupportedLength) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__SUPPORTED_LENGTH, newSupportedLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSupportedLength() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__SUPPORTED_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSupportedLength() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__SUPPORTED_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSupportedLengthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__SUPPORTED_LENGTH_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedLengthAsString(String newSupportedLengthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__SUPPORTED_LENGTH_AS_STRING,
				newSupportedLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSupportedLengthAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__SUPPORTED_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSupportedLengthAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__SUPPORTED_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D getConditionCoordinateSystem() {
		return (IfcAxis2Placement3D) eGet(
				Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__CONDITION_COORDINATE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionCoordinateSystem(IfcAxis2Placement3D newConditionCoordinateSystem) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__CONDITION_COORDINATE_SYSTEM,
				newConditionCoordinateSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConditionCoordinateSystem() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__CONDITION_COORDINATE_SYSTEM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConditionCoordinateSystem() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_REL_CONNECTS_STRUCTURAL_MEMBER__CONDITION_COORDINATE_SYSTEM);
	}

} //IfcRelConnectsStructuralMemberImpl
