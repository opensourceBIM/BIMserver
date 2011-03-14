/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Distribution Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDistributionPort#getFlowDirection <em>Flow Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDistributionPort()
 * @model
 * @generated
 */
public interface IfcDistributionPort extends IfcPort {
	/**
	 * Returns the value of the '<em><b>Flow Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcFlowDirectionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcFlowDirectionEnum
	 * @see #setFlowDirection(IfcFlowDirectionEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDistributionPort_FlowDirection()
	 * @model
	 * @generated
	 */
	IfcFlowDirectionEnum getFlowDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDistributionPort#getFlowDirection <em>Flow Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flow Direction</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcFlowDirectionEnum
	 * @see #getFlowDirection()
	 * @generated
	 */
	void setFlowDirection(IfcFlowDirectionEnum value);

} // IfcDistributionPort
