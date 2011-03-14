/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Ramp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRamp#getShapeType <em>Shape Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRamp()
 * @model
 * @generated
 */
public interface IfcRamp extends IfcBuildingElement {
	/**
	 * Returns the value of the '<em><b>Shape Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcRampTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcRampTypeEnum
	 * @see #setShapeType(IfcRampTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRamp_ShapeType()
	 * @model
	 * @generated
	 */
	IfcRampTypeEnum getShapeType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRamp#getShapeType <em>Shape Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcRampTypeEnum
	 * @see #getShapeType()
	 * @generated
	 */
	void setShapeType(IfcRampTypeEnum value);

} // IfcRamp
