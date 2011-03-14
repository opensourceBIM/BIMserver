/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Center Line Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCenterLineProfileDef#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCenterLineProfileDef#getThicknessAsString <em>Thickness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCenterLineProfileDef()
 * @model
 * @generated
 */
public interface IfcCenterLineProfileDef extends IfcArbitraryOpenProfileDef {
	/**
	 * Returns the value of the '<em><b>Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thickness</em>' attribute.
	 * @see #setThickness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCenterLineProfileDef_Thickness()
	 * @model
	 * @generated
	 */
	float getThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCenterLineProfileDef#getThickness <em>Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thickness</em>' attribute.
	 * @see #getThickness()
	 * @generated
	 */
	void setThickness(float value);

	/**
	 * Returns the value of the '<em><b>Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thickness As String</em>' attribute.
	 * @see #setThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCenterLineProfileDef_ThicknessAsString()
	 * @model
	 * @generated
	 */
	String getThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCenterLineProfileDef#getThicknessAsString <em>Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thickness As String</em>' attribute.
	 * @see #getThicknessAsString()
	 * @generated
	 */
	void setThicknessAsString(String value);

} // IfcCenterLineProfileDef
