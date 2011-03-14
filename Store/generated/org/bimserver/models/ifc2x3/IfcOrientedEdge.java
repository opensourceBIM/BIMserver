/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Oriented Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOrientedEdge#getEdgeElement <em>Edge Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOrientedEdge#getOrientation <em>Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOrientedEdge()
 * @model
 * @generated
 */
public interface IfcOrientedEdge extends IfcEdge {
	/**
	 * Returns the value of the '<em><b>Edge Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Element</em>' reference.
	 * @see #setEdgeElement(IfcEdge)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOrientedEdge_EdgeElement()
	 * @model
	 * @generated
	 */
	IfcEdge getEdgeElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrientedEdge#getEdgeElement <em>Edge Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Element</em>' reference.
	 * @see #getEdgeElement()
	 * @generated
	 */
	void setEdgeElement(IfcEdge value);

	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setOrientation(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOrientedEdge_Orientation()
	 * @model
	 * @generated
	 */
	Tristate getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrientedEdge#getOrientation <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(Tristate value);

} // IfcOrientedEdge
