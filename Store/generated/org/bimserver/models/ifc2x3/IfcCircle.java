/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Circle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCircle#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCircle#getRadiusAsString <em>Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCircle()
 * @model
 * @generated
 */
public interface IfcCircle extends IfcConic {
	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCircle_Radius()
	 * @model
	 * @generated
	 */
	float getRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCircle#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(float value);

	/**
	 * Returns the value of the '<em><b>Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius As String</em>' attribute.
	 * @see #setRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCircle_RadiusAsString()
	 * @model
	 * @generated
	 */
	String getRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCircle#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius As String</em>' attribute.
	 * @see #getRadiusAsString()
	 * @generated
	 */
	void setRadiusAsString(String value);

} // IfcCircle
