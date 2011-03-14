/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProperty#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProperty#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProperty#getPropertyForDependance <em>Property For Dependance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProperty#getPropertyDependsOn <em>Property Depends On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProperty#getPartOfComplex <em>Part Of Complex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProperty()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcProperty extends IdEObject {
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProperty_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcProperty#getName <em>Name</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProperty_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcProperty#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcProperty#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcProperty#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Property For Dependance</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDependingProperty <em>Depending Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property For Dependance</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property For Dependance</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProperty_PropertyForDependance()
	 * @see org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDependingProperty
	 * @model opposite="DependingProperty"
	 * @generated
	 */
	EList<IfcPropertyDependencyRelationship> getPropertyForDependance();

	/**
	 * Returns the value of the '<em><b>Property Depends On</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDependantProperty <em>Dependant Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Depends On</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProperty_PropertyDependsOn()
	 * @see org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDependantProperty
	 * @model opposite="DependantProperty"
	 * @generated
	 */
	EList<IfcPropertyDependencyRelationship> getPropertyDependsOn();

	/**
	 * Returns the value of the '<em><b>Part Of Complex</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcComplexProperty}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcComplexProperty#getHasProperties <em>Has Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of Complex</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of Complex</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProperty_PartOfComplex()
	 * @see org.bimserver.models.ifc2x3.IfcComplexProperty#getHasProperties
	 * @model opposite="HasProperties" upper="2"
	 * @generated
	 */
	EList<IfcComplexProperty> getPartOfComplex();

} // IfcProperty
