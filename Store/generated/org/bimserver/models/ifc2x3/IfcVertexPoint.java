/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Vertex Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVertexPoint#getVertexGeometry <em>Vertex Geometry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVertexPoint()
 * @model
 * @generated
 */
public interface IfcVertexPoint extends IfcVertex, IfcPointOrVertexPoint {
	/**
	 * Returns the value of the '<em><b>Vertex Geometry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertex Geometry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Geometry</em>' reference.
	 * @see #setVertexGeometry(IfcPoint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVertexPoint_VertexGeometry()
	 * @model
	 * @generated
	 */
	IfcPoint getVertexGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcVertexPoint#getVertexGeometry <em>Vertex Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Geometry</em>' reference.
	 * @see #getVertexGeometry()
	 * @generated
	 */
	void setVertexGeometry(IfcPoint value);

} // IfcVertexPoint
