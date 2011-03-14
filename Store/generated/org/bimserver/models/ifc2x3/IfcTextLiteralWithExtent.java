/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Text Literal With Extent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getBoxAlignment <em>Box Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteralWithExtent()
 * @model
 * @generated
 */
public interface IfcTextLiteralWithExtent extends IfcTextLiteral {
	/**
	 * Returns the value of the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' reference.
	 * @see #setExtent(IfcPlanarExtent)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteralWithExtent_Extent()
	 * @model
	 * @generated
	 */
	IfcPlanarExtent getExtent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getExtent <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' reference.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(IfcPlanarExtent value);

	/**
	 * Returns the value of the '<em><b>Box Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Alignment</em>' attribute.
	 * @see #setBoxAlignment(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteralWithExtent_BoxAlignment()
	 * @model
	 * @generated
	 */
	String getBoxAlignment();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getBoxAlignment <em>Box Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Alignment</em>' attribute.
	 * @see #getBoxAlignment()
	 * @generated
	 */
	void setBoxAlignment(String value);

} // IfcTextLiteralWithExtent
