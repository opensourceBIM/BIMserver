/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Surface Of Revolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceOfRevolution#getAxisPosition <em>Axis Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfRevolution()
 * @model
 * @generated
 */
public interface IfcSurfaceOfRevolution extends IfcSweptSurface {
	/**
	 * Returns the value of the '<em><b>Axis Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Position</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Position</em>' reference.
	 * @see #setAxisPosition(IfcAxis1Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceOfRevolution_AxisPosition()
	 * @model
	 * @generated
	 */
	IfcAxis1Placement getAxisPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceOfRevolution#getAxisPosition <em>Axis Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Position</em>' reference.
	 * @see #getAxisPosition()
	 * @generated
	 */
	void setAxisPosition(IfcAxis1Placement value);

} // IfcSurfaceOfRevolution
