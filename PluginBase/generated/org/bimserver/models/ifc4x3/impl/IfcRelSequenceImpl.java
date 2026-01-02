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
import org.bimserver.models.ifc4x3.IfcLagTime;
import org.bimserver.models.ifc4x3.IfcProcess;
import org.bimserver.models.ifc4x3.IfcRelSequence;
import org.bimserver.models.ifc4x3.IfcSequenceEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelSequenceImpl#getRelatingProcess <em>Relating Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelSequenceImpl#getRelatedProcess <em>Related Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelSequenceImpl#getTimeLag <em>Time Lag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelSequenceImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelSequenceImpl#getUserDefinedSequenceType <em>User Defined Sequence Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelSequenceImpl extends IfcRelConnectsImpl implements IfcRelSequence {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcRelSequence();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProcess getRelatingProcess() {
		return (IfcProcess) eGet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_RelatingProcess(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingProcess(IfcProcess newRelatingProcess) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_RelatingProcess(), newRelatingProcess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProcess getRelatedProcess() {
		return (IfcProcess) eGet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_RelatedProcess(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedProcess(IfcProcess newRelatedProcess) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_RelatedProcess(), newRelatedProcess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLagTime getTimeLag() {
		return (IfcLagTime) eGet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_TimeLag(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeLag(IfcLagTime newTimeLag) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_TimeLag(), newTimeLag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTimeLag() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelSequence_TimeLag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTimeLag() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_TimeLag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSequenceEnum getSequenceType() {
		return (IfcSequenceEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_SequenceType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSequenceType(IfcSequenceEnum newSequenceType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_SequenceType(), newSequenceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSequenceType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelSequence_SequenceType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSequenceType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_SequenceType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedSequenceType() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_UserDefinedSequenceType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedSequenceType(String newUserDefinedSequenceType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_UserDefinedSequenceType(), newUserDefinedSequenceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedSequenceType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRelSequence_UserDefinedSequenceType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedSequenceType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRelSequence_UserDefinedSequenceType());
	}

} //IfcRelSequenceImpl
