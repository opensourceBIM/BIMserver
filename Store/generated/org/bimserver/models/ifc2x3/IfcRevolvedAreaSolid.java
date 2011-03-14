/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Revolved Area Solid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAngle <em>Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAngleAsString <em>Angle As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid()
 * @model
 * @generated
 */
public interface IfcRevolvedAreaSolid extends IfcSweptAreaSolid {
	/**
	 * Returns the value of the '<em><b>Axis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis</em>' reference.
	 * @see #setAxis(IfcAxis1Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_Axis()
	 * @model
	 * @generated
	 */
	IfcAxis1Placement getAxis();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAxis <em>Axis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis</em>' reference.
	 * @see #getAxis()
	 * @generated
	 */
	void setAxis(IfcAxis1Placement value);

	/**
	 * Returns the value of the '<em><b>Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angle</em>' attribute.
	 * @see #setAngle(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_Angle()
	 * @model
	 * @generated
	 */
	float getAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAngle <em>Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angle</em>' attribute.
	 * @see #getAngle()
	 * @generated
	 */
	void setAngle(float value);

	/**
	 * Returns the value of the '<em><b>Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angle As String</em>' attribute.
	 * @see #setAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_AngleAsString()
	 * @model
	 * @generated
	 */
	String getAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAngleAsString <em>Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angle As String</em>' attribute.
	 * @see #getAngleAsString()
	 * @generated
	 */
	void setAngleAsString(String value);

} // IfcRevolvedAreaSolid
