/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLine#getPnt <em>Pnt</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLine#getDir <em>Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLine()
 * @model
 * @generated
 */
public interface IfcLine extends IfcCurve {
	/**
	 * Returns the value of the '<em><b>Pnt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pnt</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pnt</em>' reference.
	 * @see #setPnt(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLine_Pnt()
	 * @model
	 * @generated
	 */
	IfcCartesianPoint getPnt();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLine#getPnt <em>Pnt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pnt</em>' reference.
	 * @see #getPnt()
	 * @generated
	 */
	void setPnt(IfcCartesianPoint value);

	/**
	 * Returns the value of the '<em><b>Dir</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dir</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dir</em>' reference.
	 * @see #setDir(IfcVector)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLine_Dir()
	 * @model
	 * @generated
	 */
	IfcVector getDir();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLine#getDir <em>Dir</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dir</em>' reference.
	 * @see #getDir()
	 * @generated
	 */
	void setDir(IfcVector value);

} // IfcLine
