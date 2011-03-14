/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Building Element Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBuildingElementProxy#getCompositionType <em>Composition Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuildingElementProxy()
 * @model
 * @generated
 */
public interface IfcBuildingElementProxy extends IfcBuildingElement {
	/**
	 * Returns the value of the '<em><b>Composition Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcElementCompositionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcElementCompositionEnum
	 * @see #setCompositionType(IfcElementCompositionEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBuildingElementProxy_CompositionType()
	 * @model
	 * @generated
	 */
	IfcElementCompositionEnum getCompositionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBuildingElementProxy#getCompositionType <em>Composition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcElementCompositionEnum
	 * @see #getCompositionType()
	 * @generated
	 */
	void setCompositionType(IfcElementCompositionEnum value);

} // IfcBuildingElementProxy
