/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Polygonal Bounded Half Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPolygonalBoundedHalfSpace#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPolygonalBoundedHalfSpace#getPolygonalBoundary <em>Polygonal Boundary</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPolygonalBoundedHalfSpace()
 * @model
 * @generated
 */
public interface IfcPolygonalBoundedHalfSpace extends IfcHalfSpaceSolid {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' reference.
	 * @see #setPosition(IfcAxis2Placement3D)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPolygonalBoundedHalfSpace_Position()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement3D getPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPolygonalBoundedHalfSpace#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(IfcAxis2Placement3D value);

	/**
	 * Returns the value of the '<em><b>Polygonal Boundary</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Polygonal Boundary</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Polygonal Boundary</em>' reference.
	 * @see #setPolygonalBoundary(IfcBoundedCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPolygonalBoundedHalfSpace_PolygonalBoundary()
	 * @model
	 * @generated
	 */
	IfcBoundedCurve getPolygonalBoundary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPolygonalBoundedHalfSpace#getPolygonalBoundary <em>Polygonal Boundary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Polygonal Boundary</em>' reference.
	 * @see #getPolygonalBoundary()
	 * @generated
	 */
	void setPolygonalBoundary(IfcBoundedCurve value);

} // IfcPolygonalBoundedHalfSpace
