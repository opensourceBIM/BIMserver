/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Property Dependency Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDependingProperty <em>Depending Property</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDependantProperty <em>Dependant Property</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyDependencyRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcPropertyDependencyRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Depending Property</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProperty#getPropertyForDependance <em>Property For Dependance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depending Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depending Property</em>' reference.
	 * @see #setDependingProperty(IfcProperty)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyDependencyRelationship_DependingProperty()
	 * @see org.bimserver.models.ifc2x3.IfcProperty#getPropertyForDependance
	 * @model opposite="PropertyForDependance"
	 * @generated
	 */
	IfcProperty getDependingProperty();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDependingProperty <em>Depending Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depending Property</em>' reference.
	 * @see #getDependingProperty()
	 * @generated
	 */
	void setDependingProperty(IfcProperty value);

	/**
	 * Returns the value of the '<em><b>Dependant Property</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProperty#getPropertyDependsOn <em>Property Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependant Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependant Property</em>' reference.
	 * @see #setDependantProperty(IfcProperty)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyDependencyRelationship_DependantProperty()
	 * @see org.bimserver.models.ifc2x3.IfcProperty#getPropertyDependsOn
	 * @model opposite="PropertyDependsOn"
	 * @generated
	 */
	IfcProperty getDependantProperty();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDependantProperty <em>Dependant Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependant Property</em>' reference.
	 * @see #getDependantProperty()
	 * @generated
	 */
	void setDependantProperty(IfcProperty value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyDependencyRelationship_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyDependencyRelationship_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #setExpression(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertyDependencyRelationship_Expression()
	 * @model unsettable="true"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #isSetExpression()
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExpression()
	 * @see #getExpression()
	 * @see #setExpression(String)
	 * @generated
	 */
	void unsetExpression();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPropertyDependencyRelationship#getExpression <em>Expression</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Expression</em>' attribute is set.
	 * @see #unsetExpression()
	 * @see #getExpression()
	 * @see #setExpression(String)
	 * @generated
	 */
	boolean isSetExpression();

} // IfcPropertyDependencyRelationship
