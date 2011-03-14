/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Text Style For Defined Font</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextStyleForDefinedFont#getColour <em>Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextStyleForDefinedFont#getBackgroundColour <em>Background Colour</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextStyleForDefinedFont()
 * @model
 * @generated
 */
public interface IfcTextStyleForDefinedFont extends IfcCharacterStyleSelect {
	/**
	 * Returns the value of the '<em><b>Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour</em>' reference.
	 * @see #setColour(IfcColour)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextStyleForDefinedFont_Colour()
	 * @model
	 * @generated
	 */
	IfcColour getColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextStyleForDefinedFont#getColour <em>Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colour</em>' reference.
	 * @see #getColour()
	 * @generated
	 */
	void setColour(IfcColour value);

	/**
	 * Returns the value of the '<em><b>Background Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Colour</em>' reference.
	 * @see #isSetBackgroundColour()
	 * @see #unsetBackgroundColour()
	 * @see #setBackgroundColour(IfcColour)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextStyleForDefinedFont_BackgroundColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColour getBackgroundColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextStyleForDefinedFont#getBackgroundColour <em>Background Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Colour</em>' reference.
	 * @see #isSetBackgroundColour()
	 * @see #unsetBackgroundColour()
	 * @see #getBackgroundColour()
	 * @generated
	 */
	void setBackgroundColour(IfcColour value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextStyleForDefinedFont#getBackgroundColour <em>Background Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBackgroundColour()
	 * @see #getBackgroundColour()
	 * @see #setBackgroundColour(IfcColour)
	 * @generated
	 */
	void unsetBackgroundColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTextStyleForDefinedFont#getBackgroundColour <em>Background Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Background Colour</em>' reference is set.
	 * @see #unsetBackgroundColour()
	 * @see #getBackgroundColour()
	 * @see #setBackgroundColour(IfcColour)
	 * @generated
	 */
	boolean isSetBackgroundColour();

} // IfcTextStyleForDefinedFont
