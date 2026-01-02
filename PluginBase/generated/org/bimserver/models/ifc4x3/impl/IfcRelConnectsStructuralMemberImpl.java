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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc4x3.IfcBoundaryCondition;
import org.bimserver.models.ifc4x3.IfcRelConnectsStructuralMember;
import org.bimserver.models.ifc4x3.IfcStructuralConnection;
import org.bimserver.models.ifc4x3.IfcStructuralConnectionCondition;
import org.bimserver.models.ifc4x3.IfcStructuralMember;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Structural Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelConnectsStructuralMemberImpl#getRelatingStructuralMember <em>Relating Structural Member</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelConnectsStructuralMemberImpl#getRelatedStructuralConnection <em>Related Structural Connection</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelConnectsStructuralMemberImpl#getAppliedCondition <em>Applied Condition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelConnectsStructuralMemberImpl#getAdditionalConditions <em>Additional Conditions</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelConnectsStructuralMemberImpl#getSupportedLength <em>Supported Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelConnectsStructuralMemberImpl#getSupportedLengthAsString <em>Supported Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelConnectsStructuralMemberImpl#getConditionCoordinateSystem <em>Condition Coordinate System</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralMember getRelatingStructuralMember() {
		return (IfcStructuralMember) eGet(
				Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_RelatingStructuralMember(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingStructuralMember(IfcStructuralMember newRelatingStructuralMember) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_RelatingStructuralMember(),
				newRelatingStructuralMember);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralConnection getRelatedStructuralConnection() {
		return (IfcStructuralConnection) eGet(
				Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_RelatedStructuralConnection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedStructuralConnection(IfcStructuralConnection newRelatedStructuralConnection) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_RelatedStructuralConnection(),
				newRelatedStructuralConnection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundaryCondition getAppliedCondition() {
		return (IfcBoundaryCondition) eGet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AppliedCondition(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAppliedCondition(IfcBoundaryCondition newAppliedCondition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AppliedCondition(), newAppliedCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAppliedCondition() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AppliedCondition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAppliedCondition() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AppliedCondition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralConnectionCondition getAdditionalConditions() {
		return (IfcStructuralConnectionCondition) eGet(
				Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AdditionalConditions(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAdditionalConditions(IfcStructuralConnectionCondition newAdditionalConditions) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AdditionalConditions(), newAdditionalConditions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAdditionalConditions() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AdditionalConditions());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAdditionalConditions() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AdditionalConditions());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSupportedLength() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSupportedLength(double newSupportedLength) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLength(), newSupportedLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSupportedLength() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSupportedLength() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSupportedLengthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSupportedLengthAsString(String newSupportedLengthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLengthAsString(),
				newSupportedLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSupportedLengthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSupportedLengthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAxis2Placement3D getConditionCoordinateSystem() {
		return (IfcAxis2Placement3D) eGet(
				Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_ConditionCoordinateSystem(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConditionCoordinateSystem(IfcAxis2Placement3D newConditionCoordinateSystem) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_ConditionCoordinateSystem(),
				newConditionCoordinateSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConditionCoordinateSystem() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_ConditionCoordinateSystem());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConditionCoordinateSystem() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_ConditionCoordinateSystem());
	}

} //IfcRelConnectsStructuralMemberImpl
