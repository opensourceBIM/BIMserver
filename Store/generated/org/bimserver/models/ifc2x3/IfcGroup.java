/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGroup#getIsGroupedBy <em>Is Grouped By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGroup()
 * @model
 * @generated
 */
public interface IfcGroup extends IfcObject {
	/**
	 * Returns the value of the '<em><b>Is Grouped By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToGroup#getRelatingGroup <em>Relating Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Grouped By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Grouped By</em>' reference.
	 * @see #setIsGroupedBy(IfcRelAssignsToGroup)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGroup_IsGroupedBy()
	 * @see org.bimserver.models.ifc2x3.IfcRelAssignsToGroup#getRelatingGroup
	 * @model opposite="RelatingGroup"
	 * @generated
	 */
	IfcRelAssignsToGroup getIsGroupedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGroup#getIsGroupedBy <em>Is Grouped By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Grouped By</em>' reference.
	 * @see #getIsGroupedBy()
	 * @generated
	 */
	void setIsGroupedBy(IfcRelAssignsToGroup value);

} // IfcGroup
