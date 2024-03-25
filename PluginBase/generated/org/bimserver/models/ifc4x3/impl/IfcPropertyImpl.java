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
import org.bimserver.models.ifc4x3.IfcComplexProperty;
import org.bimserver.models.ifc4x3.IfcProperty;
import org.bimserver.models.ifc4x3.IfcPropertyDependencyRelationship;
import org.bimserver.models.ifc4x3.IfcPropertySet;
import org.bimserver.models.ifc4x3.IfcResourceApprovalRelationship;
import org.bimserver.models.ifc4x3.IfcResourceConstraintRelationship;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertyImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertyImpl#getPartOfPset <em>Part Of Pset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertyImpl#getPropertyForDependance <em>Property For Dependance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertyImpl#getPropertyDependsOn <em>Property Depends On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertyImpl#getPartOfComplex <em>Part Of Complex</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertyImpl#getHasConstraints <em>Has Constraints</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertyImpl#getHasApprovals <em>Has Approvals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertyImpl extends IfcPropertyAbstractionImpl implements IfcProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_PROPERTY__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.Literals.IFC_PROPERTY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSpecification() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_PROPERTY__SPECIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecification(String newSpecification) {
		eSet(Ifc4x3Package.Literals.IFC_PROPERTY__SPECIFICATION, newSpecification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSpecification() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY__SPECIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSpecification() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY__SPECIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPropertySet> getPartOfPset() {
		return (EList<IfcPropertySet>) eGet(Ifc4x3Package.Literals.IFC_PROPERTY__PART_OF_PSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartOfPset() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY__PART_OF_PSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartOfPset() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY__PART_OF_PSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPropertyDependencyRelationship> getPropertyForDependance() {
		return (EList<IfcPropertyDependencyRelationship>) eGet(
				Ifc4x3Package.Literals.IFC_PROPERTY__PROPERTY_FOR_DEPENDANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPropertyForDependance() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY__PROPERTY_FOR_DEPENDANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPropertyForDependance() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY__PROPERTY_FOR_DEPENDANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPropertyDependencyRelationship> getPropertyDependsOn() {
		return (EList<IfcPropertyDependencyRelationship>) eGet(Ifc4x3Package.Literals.IFC_PROPERTY__PROPERTY_DEPENDS_ON,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPropertyDependsOn() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY__PROPERTY_DEPENDS_ON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPropertyDependsOn() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY__PROPERTY_DEPENDS_ON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcComplexProperty> getPartOfComplex() {
		return (EList<IfcComplexProperty>) eGet(Ifc4x3Package.Literals.IFC_PROPERTY__PART_OF_COMPLEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartOfComplex() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY__PART_OF_COMPLEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartOfComplex() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY__PART_OF_COMPLEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcResourceConstraintRelationship> getHasConstraints() {
		return (EList<IfcResourceConstraintRelationship>) eGet(Ifc4x3Package.Literals.IFC_PROPERTY__HAS_CONSTRAINTS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasConstraints() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY__HAS_CONSTRAINTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasConstraints() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY__HAS_CONSTRAINTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcResourceApprovalRelationship> getHasApprovals() {
		return (EList<IfcResourceApprovalRelationship>) eGet(Ifc4x3Package.Literals.IFC_PROPERTY__HAS_APPROVALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasApprovals() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY__HAS_APPROVALS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasApprovals() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY__HAS_APPROVALS);
	}

} //IfcPropertyImpl
