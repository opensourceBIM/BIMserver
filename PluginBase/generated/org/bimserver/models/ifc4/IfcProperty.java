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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcProperty#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProperty#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProperty#getPartOfPset <em>Part Of Pset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProperty#getPropertyForDependance <em>Property For Dependance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProperty#getPropertyDependsOn <em>Property Depends On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProperty#getPartOfComplex <em>Part Of Complex</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProperty#getHasConstraints <em>Has Constraints</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProperty#getHasApprovals <em>Has Approvals</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty()
 * @model
 * @generated
 */
public interface IfcProperty extends IfcPropertyAbstraction {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty_Name()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Part Of Pset</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcPropertySet}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcPropertySet#getHasProperties <em>Has Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of Pset</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of Pset</em>' reference list.
	 * @see #isSetPartOfPset()
	 * @see #unsetPartOfPset()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty_PartOfPset()
	 * @see org.bimserver.models.ifc4.IfcPropertySet#getHasProperties
	 * @model opposite="HasProperties" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPropertySet> getPartOfPset();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getPartOfPset <em>Part Of Pset</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPartOfPset()
	 * @see #getPartOfPset()
	 * @generated
	 */
	void unsetPartOfPset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getPartOfPset <em>Part Of Pset</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Part Of Pset</em>' reference list is set.
	 * @see #unsetPartOfPset()
	 * @see #getPartOfPset()
	 * @generated
	 */
	boolean isSetPartOfPset();

	/**
	 * Returns the value of the '<em><b>Property For Dependance</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getDependingProperty <em>Depending Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property For Dependance</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property For Dependance</em>' reference list.
	 * @see #isSetPropertyForDependance()
	 * @see #unsetPropertyForDependance()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty_PropertyForDependance()
	 * @see org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getDependingProperty
	 * @model opposite="DependingProperty" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPropertyDependencyRelationship> getPropertyForDependance();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getPropertyForDependance <em>Property For Dependance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPropertyForDependance()
	 * @see #getPropertyForDependance()
	 * @generated
	 */
	void unsetPropertyForDependance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getPropertyForDependance <em>Property For Dependance</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Property For Dependance</em>' reference list is set.
	 * @see #unsetPropertyForDependance()
	 * @see #getPropertyForDependance()
	 * @generated
	 */
	boolean isSetPropertyForDependance();

	/**
	 * Returns the value of the '<em><b>Property Depends On</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getDependantProperty <em>Dependant Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Depends On</em>' reference list.
	 * @see #isSetPropertyDependsOn()
	 * @see #unsetPropertyDependsOn()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty_PropertyDependsOn()
	 * @see org.bimserver.models.ifc4.IfcPropertyDependencyRelationship#getDependantProperty
	 * @model opposite="DependantProperty" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPropertyDependencyRelationship> getPropertyDependsOn();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getPropertyDependsOn <em>Property Depends On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPropertyDependsOn()
	 * @see #getPropertyDependsOn()
	 * @generated
	 */
	void unsetPropertyDependsOn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getPropertyDependsOn <em>Property Depends On</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Property Depends On</em>' reference list is set.
	 * @see #unsetPropertyDependsOn()
	 * @see #getPropertyDependsOn()
	 * @generated
	 */
	boolean isSetPropertyDependsOn();

	/**
	 * Returns the value of the '<em><b>Part Of Complex</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcComplexProperty}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcComplexProperty#getHasProperties <em>Has Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of Complex</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of Complex</em>' reference list.
	 * @see #isSetPartOfComplex()
	 * @see #unsetPartOfComplex()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty_PartOfComplex()
	 * @see org.bimserver.models.ifc4.IfcComplexProperty#getHasProperties
	 * @model opposite="HasProperties" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcComplexProperty> getPartOfComplex();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getPartOfComplex <em>Part Of Complex</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPartOfComplex()
	 * @see #getPartOfComplex()
	 * @generated
	 */
	void unsetPartOfComplex();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getPartOfComplex <em>Part Of Complex</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Part Of Complex</em>' reference list is set.
	 * @see #unsetPartOfComplex()
	 * @see #getPartOfComplex()
	 * @generated
	 */
	boolean isSetPartOfComplex();

	/**
	 * Returns the value of the '<em><b>Has Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcResourceConstraintRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Constraints</em>' reference list.
	 * @see #isSetHasConstraints()
	 * @see #unsetHasConstraints()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty_HasConstraints()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcResourceConstraintRelationship> getHasConstraints();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getHasConstraints <em>Has Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasConstraints()
	 * @see #getHasConstraints()
	 * @generated
	 */
	void unsetHasConstraints();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getHasConstraints <em>Has Constraints</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Constraints</em>' reference list is set.
	 * @see #unsetHasConstraints()
	 * @see #getHasConstraints()
	 * @generated
	 */
	boolean isSetHasConstraints();

	/**
	 * Returns the value of the '<em><b>Has Approvals</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcResourceApprovalRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Approvals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Approvals</em>' reference list.
	 * @see #isSetHasApprovals()
	 * @see #unsetHasApprovals()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProperty_HasApprovals()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcResourceApprovalRelationship> getHasApprovals();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getHasApprovals <em>Has Approvals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasApprovals()
	 * @see #getHasApprovals()
	 * @generated
	 */
	void unsetHasApprovals();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProperty#getHasApprovals <em>Has Approvals</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Approvals</em>' reference list is set.
	 * @see #unsetHasApprovals()
	 * @see #getHasApprovals()
	 * @generated
	 */
	boolean isSetHasApprovals();

} // IfcProperty
