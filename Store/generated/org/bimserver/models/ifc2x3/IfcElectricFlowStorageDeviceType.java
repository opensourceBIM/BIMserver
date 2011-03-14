/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Electric Flow Storage Device Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcElectricFlowStorageDeviceType#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElectricFlowStorageDeviceType()
 * @model
 * @generated
 */
public interface IfcElectricFlowStorageDeviceType extends IfcFlowStorageDeviceType {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcElectricFlowStorageDeviceTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcElectricFlowStorageDeviceTypeEnum
	 * @see #setPredefinedType(IfcElectricFlowStorageDeviceTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElectricFlowStorageDeviceType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcElectricFlowStorageDeviceTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcElectricFlowStorageDeviceType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcElectricFlowStorageDeviceTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcElectricFlowStorageDeviceTypeEnum value);

} // IfcElectricFlowStorageDeviceType
