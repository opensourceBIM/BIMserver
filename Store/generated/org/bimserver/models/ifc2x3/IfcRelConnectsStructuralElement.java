/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Connects Structural Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatedStructuralMember <em>Related Structural Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsStructuralElement()
 * @model
 * @generated
 */
public interface IfcRelConnectsStructuralElement extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcElement#getHasStructuralMember <em>Has Structural Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Element</em>' reference.
	 * @see #setRelatingElement(IfcElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsStructuralElement_RelatingElement()
	 * @see org.bimserver.models.ifc2x3.IfcElement#getHasStructuralMember
	 * @model opposite="HasStructuralMember"
	 * @generated
	 */
	IfcElement getRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Element</em>' reference.
	 * @see #getRelatingElement()
	 * @generated
	 */
	void setRelatingElement(IfcElement value);

	/**
	 * Returns the value of the '<em><b>Related Structural Member</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcStructuralMember#getReferencesElement <em>References Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Structural Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Structural Member</em>' reference.
	 * @see #setRelatedStructuralMember(IfcStructuralMember)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelConnectsStructuralElement_RelatedStructuralMember()
	 * @see org.bimserver.models.ifc2x3.IfcStructuralMember#getReferencesElement
	 * @model opposite="ReferencesElement"
	 * @generated
	 */
	IfcStructuralMember getRelatedStructuralMember();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelConnectsStructuralElement#getRelatedStructuralMember <em>Related Structural Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Structural Member</em>' reference.
	 * @see #getRelatedStructuralMember()
	 * @generated
	 */
	void setRelatedStructuralMember(IfcStructuralMember value);

} // IfcRelConnectsStructuralElement
