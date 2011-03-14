/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Air To Air Heat Recovery Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAirToAirHeatRecoveryType#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAirToAirHeatRecoveryType()
 * @model
 * @generated
 */
public interface IfcAirToAirHeatRecoveryType extends IfcEnergyConversionDeviceType {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcAirToAirHeatRecoveryTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcAirToAirHeatRecoveryTypeEnum
	 * @see #setPredefinedType(IfcAirToAirHeatRecoveryTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAirToAirHeatRecoveryType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcAirToAirHeatRecoveryTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAirToAirHeatRecoveryType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcAirToAirHeatRecoveryTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcAirToAirHeatRecoveryTypeEnum value);

} // IfcAirToAirHeatRecoveryType
