/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Feature Element Addition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFeatureElementAddition()
 * @model
 * @generated
 */
public interface IfcFeatureElementAddition extends IfcFeatureElement {
	/**
	 * Returns the value of the '<em><b>Projects Elements</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatedFeatureElement <em>Related Feature Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects Elements</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects Elements</em>' reference.
	 * @see #setProjectsElements(IfcRelProjectsElement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFeatureElementAddition_ProjectsElements()
	 * @see org.bimserver.models.ifc2x3.IfcRelProjectsElement#getRelatedFeatureElement
	 * @model opposite="RelatedFeatureElement"
	 * @generated
	 */
	IfcRelProjectsElement getProjectsElements();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFeatureElementAddition#getProjectsElements <em>Projects Elements</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projects Elements</em>' reference.
	 * @see #getProjectsElements()
	 * @generated
	 */
	void setProjectsElements(IfcRelProjectsElement value);

} // IfcFeatureElementAddition
