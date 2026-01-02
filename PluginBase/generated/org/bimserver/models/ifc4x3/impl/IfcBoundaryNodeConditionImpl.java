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
import org.bimserver.models.ifc4x3.IfcBoundaryNodeCondition;
import org.bimserver.models.ifc4x3.IfcRotationalStiffnessSelect;
import org.bimserver.models.ifc4x3.IfcTranslationalStiffnessSelect;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Node Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundaryNodeConditionImpl#getTranslationalStiffnessX <em>Translational Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundaryNodeConditionImpl#getTranslationalStiffnessY <em>Translational Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundaryNodeConditionImpl#getTranslationalStiffnessZ <em>Translational Stiffness Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessX <em>Rotational Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBoundaryNodeConditionImpl extends IfcBoundaryConditionImpl implements IfcBoundaryNodeCondition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundaryNodeConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTranslationalStiffnessSelect getTranslationalStiffnessX() {
		return (IfcTranslationalStiffnessSelect) eGet(
				Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessX(IfcTranslationalStiffnessSelect newTranslationalStiffnessX) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessX(), newTranslationalStiffnessX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessX() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessX() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTranslationalStiffnessSelect getTranslationalStiffnessY() {
		return (IfcTranslationalStiffnessSelect) eGet(
				Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessY(IfcTranslationalStiffnessSelect newTranslationalStiffnessY) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessY(), newTranslationalStiffnessY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessY() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessY() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTranslationalStiffnessSelect getTranslationalStiffnessZ() {
		return (IfcTranslationalStiffnessSelect) eGet(
				Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessZ(IfcTranslationalStiffnessSelect newTranslationalStiffnessZ) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessZ(), newTranslationalStiffnessZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessZ() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessZ() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_TranslationalStiffnessZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalStiffnessSelect getRotationalStiffnessX() {
		return (IfcRotationalStiffnessSelect) eGet(
				Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessX(IfcRotationalStiffnessSelect newRotationalStiffnessX) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessX(), newRotationalStiffnessX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessX() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessX() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalStiffnessSelect getRotationalStiffnessY() {
		return (IfcRotationalStiffnessSelect) eGet(
				Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessY(IfcRotationalStiffnessSelect newRotationalStiffnessY) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessY(), newRotationalStiffnessY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessY() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessY() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalStiffnessSelect getRotationalStiffnessZ() {
		return (IfcRotationalStiffnessSelect) eGet(
				Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessZ(IfcRotationalStiffnessSelect newRotationalStiffnessZ) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZ(), newRotationalStiffnessZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessZ() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessZ() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZ());
	}

} //IfcBoundaryNodeConditionImpl
