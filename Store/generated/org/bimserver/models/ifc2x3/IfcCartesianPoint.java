/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Cartesian Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianPoint#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianPoint#getCoordinatesAsString <em>Coordinates As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCartesianPoint#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianPoint()
 * @model
 * @generated
 */
public interface IfcCartesianPoint extends IfcPoint, IfcTrimmingSelect {
	/**
	 * Returns the value of the '<em><b>Coordinates</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinates</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinates</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianPoint_Coordinates()
	 * @model unique="false"
	 * @generated
	 */
	EList<Float> getCoordinates();

	/**
	 * Returns the value of the '<em><b>Coordinates As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinates As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinates As String</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianPoint_CoordinatesAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getCoordinatesAsString();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCartesianPoint_Dim()
	 * @model derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCartesianPoint#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

} // IfcCartesianPoint
