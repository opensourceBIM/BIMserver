/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Feature Element Subtraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFeatureElementSubtraction#getVoidsElements <em>Voids Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFeatureElementSubtraction()
 * @model
 * @generated
 */
public interface IfcFeatureElementSubtraction extends IfcFeatureElement {
	/**
	 * Returns the value of the '<em><b>Voids Elements</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelVoidsElement#getRelatedOpeningElement <em>Related Opening Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Voids Elements</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Voids Elements</em>' reference.
	 * @see #setVoidsElements(IfcRelVoidsElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFeatureElementSubtraction_VoidsElements()
	 * @see org.bimserver.models.ifc2x3.IfcRelVoidsElement#getRelatedOpeningElement
	 * @model opposite="RelatedOpeningElement"
	 * @generated
	 */
	IfcRelVoidsElement getVoidsElements();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFeatureElementSubtraction#getVoidsElements <em>Voids Elements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voids Elements</em>' reference.
	 * @see #getVoidsElements()
	 * @generated
	 */
	void setVoidsElements(IfcRelVoidsElement value);

} // IfcFeatureElementSubtraction
