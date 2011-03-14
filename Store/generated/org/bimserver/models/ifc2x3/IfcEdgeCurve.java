/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Edge Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEdgeCurve#getEdgeGeometry <em>Edge Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEdgeCurve#getSameSense <em>Same Sense</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEdgeCurve()
 * @model
 * @generated
 */
public interface IfcEdgeCurve extends IfcEdge, IfcCurveOrEdgeCurve {
	/**
	 * Returns the value of the '<em><b>Edge Geometry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Geometry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Geometry</em>' reference.
	 * @see #setEdgeGeometry(IfcCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEdgeCurve_EdgeGeometry()
	 * @model
	 * @generated
	 */
	IfcCurve getEdgeGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEdgeCurve#getEdgeGeometry <em>Edge Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Geometry</em>' reference.
	 * @see #getEdgeGeometry()
	 * @generated
	 */
	void setEdgeGeometry(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Same Sense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Same Sense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Same Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setSameSense(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEdgeCurve_SameSense()
	 * @model
	 * @generated
	 */
	Tristate getSameSense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEdgeCurve#getSameSense <em>Same Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Same Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getSameSense()
	 * @generated
	 */
	void setSameSense(Tristate value);

} // IfcEdgeCurve
