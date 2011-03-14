/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rounded Edge Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRoundedEdgeFeature#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRoundedEdgeFeature#getRadiusAsString <em>Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoundedEdgeFeature()
 * @model
 * @generated
 */
public interface IfcRoundedEdgeFeature extends IfcEdgeFeature {
	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #isSetRadius()
	 * @see #unsetRadius()
	 * @see #setRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoundedEdgeFeature_Radius()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedEdgeFeature#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #isSetRadius()
	 * @see #unsetRadius()
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedEdgeFeature#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadius()
	 * @see #getRadius()
	 * @see #setRadius(float)
	 * @generated
	 */
	void unsetRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedEdgeFeature#getRadius <em>Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Radius</em>' attribute is set.
	 * @see #unsetRadius()
	 * @see #getRadius()
	 * @see #setRadius(float)
	 * @generated
	 */
	boolean isSetRadius();

	/**
	 * Returns the value of the '<em><b>Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius As String</em>' attribute.
	 * @see #isSetRadiusAsString()
	 * @see #unsetRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoundedEdgeFeature_RadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedEdgeFeature#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius As String</em>' attribute.
	 * @see #isSetRadiusAsString()
	 * @see #unsetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @generated
	 */
	void setRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedEdgeFeature#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @generated
	 */
	void unsetRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedEdgeFeature#getRadiusAsString <em>Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Radius As String</em>' attribute is set.
	 * @see #unsetRadiusAsString()
	 * @see #getRadiusAsString()
	 * @see #setRadiusAsString(String)
	 * @generated
	 */
	boolean isSetRadiusAsString();

} // IfcRoundedEdgeFeature
