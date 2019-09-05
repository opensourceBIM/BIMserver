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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcLagTime;
import org.bimserver.models.ifc4.IfcProcess;
import org.bimserver.models.ifc4.IfcRelSequence;
import org.bimserver.models.ifc4.IfcSequenceEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSequenceImpl#getRelatingProcess <em>Relating Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSequenceImpl#getRelatedProcess <em>Related Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSequenceImpl#getTimeLag <em>Time Lag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSequenceImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSequenceImpl#getUserDefinedSequenceType <em>User Defined Sequence Type</em>}</li>
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
		return Ifc4Package.Literals.IFC_REL_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProcess getRelatingProcess() {
		return (IfcProcess) eGet(Ifc4Package.Literals.IFC_REL_SEQUENCE__RELATING_PROCESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingProcess(IfcProcess newRelatingProcess) {
		eSet(Ifc4Package.Literals.IFC_REL_SEQUENCE__RELATING_PROCESS, newRelatingProcess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProcess getRelatedProcess() {
		return (IfcProcess) eGet(Ifc4Package.Literals.IFC_REL_SEQUENCE__RELATED_PROCESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedProcess(IfcProcess newRelatedProcess) {
		eSet(Ifc4Package.Literals.IFC_REL_SEQUENCE__RELATED_PROCESS, newRelatedProcess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLagTime getTimeLag() {
		return (IfcLagTime) eGet(Ifc4Package.Literals.IFC_REL_SEQUENCE__TIME_LAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeLag(IfcLagTime newTimeLag) {
		eSet(Ifc4Package.Literals.IFC_REL_SEQUENCE__TIME_LAG, newTimeLag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTimeLag() {
		eUnset(Ifc4Package.Literals.IFC_REL_SEQUENCE__TIME_LAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTimeLag() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_SEQUENCE__TIME_LAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSequenceEnum getSequenceType() {
		return (IfcSequenceEnum) eGet(Ifc4Package.Literals.IFC_REL_SEQUENCE__SEQUENCE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSequenceType(IfcSequenceEnum newSequenceType) {
		eSet(Ifc4Package.Literals.IFC_REL_SEQUENCE__SEQUENCE_TYPE, newSequenceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSequenceType() {
		eUnset(Ifc4Package.Literals.IFC_REL_SEQUENCE__SEQUENCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSequenceType() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_SEQUENCE__SEQUENCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedSequenceType() {
		return (String) eGet(Ifc4Package.Literals.IFC_REL_SEQUENCE__USER_DEFINED_SEQUENCE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedSequenceType(String newUserDefinedSequenceType) {
		eSet(Ifc4Package.Literals.IFC_REL_SEQUENCE__USER_DEFINED_SEQUENCE_TYPE, newUserDefinedSequenceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedSequenceType() {
		eUnset(Ifc4Package.Literals.IFC_REL_SEQUENCE__USER_DEFINED_SEQUENCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedSequenceType() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_SEQUENCE__USER_DEFINED_SEQUENCE_TYPE);
	}

} //IfcRelSequenceImpl
