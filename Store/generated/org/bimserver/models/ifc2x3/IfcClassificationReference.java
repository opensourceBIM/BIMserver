/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Classification Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationReference()
 * @model
 * @generated
 */
public interface IfcClassificationReference extends IfcExternalReference, IfcClassificationNotationSelect {
	/**
	 * Returns the value of the '<em><b>Referenced Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Source</em>' reference.
	 * @see #isSetReferencedSource()
	 * @see #unsetReferencedSource()
	 * @see #setReferencedSource(IfcClassification)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationReference_ReferencedSource()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcClassification getReferencedSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Source</em>' reference.
	 * @see #isSetReferencedSource()
	 * @see #unsetReferencedSource()
	 * @see #getReferencedSource()
	 * @generated
	 */
	void setReferencedSource(IfcClassification value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedSource()
	 * @see #getReferencedSource()
	 * @see #setReferencedSource(IfcClassification)
	 * @generated
	 */
	void unsetReferencedSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationReference#getReferencedSource <em>Referenced Source</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced Source</em>' reference is set.
	 * @see #unsetReferencedSource()
	 * @see #getReferencedSource()
	 * @see #setReferencedSource(IfcClassification)
	 * @generated
	 */
	boolean isSetReferencedSource();

} // IfcClassificationReference
