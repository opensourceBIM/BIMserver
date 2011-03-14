/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Covers Spaces</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelCoversSpaces#getRelatedSpace <em>Related Space</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelCoversSpaces#getRelatedCoverings <em>Related Coverings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelCoversSpaces()
 * @model
 * @generated
 */
public interface IfcRelCoversSpaces extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Related Space</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcSpace#getHasCoverings <em>Has Coverings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Space</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Space</em>' reference.
	 * @see #setRelatedSpace(IfcSpace)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelCoversSpaces_RelatedSpace()
	 * @see org.bimserver.models.ifc2x3.IfcSpace#getHasCoverings
	 * @model opposite="HasCoverings"
	 * @generated
	 */
	IfcSpace getRelatedSpace();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelCoversSpaces#getRelatedSpace <em>Related Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Space</em>' reference.
	 * @see #getRelatedSpace()
	 * @generated
	 */
	void setRelatedSpace(IfcSpace value);

	/**
	 * Returns the value of the '<em><b>Related Coverings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCovering}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcCovering#getCoversSpaces <em>Covers Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Coverings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Coverings</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelCoversSpaces_RelatedCoverings()
	 * @see org.bimserver.models.ifc2x3.IfcCovering#getCoversSpaces
	 * @model opposite="CoversSpaces"
	 * @generated
	 */
	EList<IfcCovering> getRelatedCoverings();

} // IfcRelCoversSpaces
