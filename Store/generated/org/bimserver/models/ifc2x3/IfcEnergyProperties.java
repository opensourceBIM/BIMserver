/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Energy Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getEnergySequence <em>Energy Sequence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyProperties()
 * @model
 * @generated
 */
public interface IfcEnergyProperties extends IfcPropertySetDefinition {
	/**
	 * Returns the value of the '<em><b>Energy Sequence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcEnergySequenceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Energy Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Energy Sequence</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcEnergySequenceEnum
	 * @see #setEnergySequence(IfcEnergySequenceEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyProperties_EnergySequence()
	 * @model
	 * @generated
	 */
	IfcEnergySequenceEnum getEnergySequence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getEnergySequence <em>Energy Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energy Sequence</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcEnergySequenceEnum
	 * @see #getEnergySequence()
	 * @generated
	 */
	void setEnergySequence(IfcEnergySequenceEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Energy Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Energy Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Energy Sequence</em>' attribute.
	 * @see #isSetUserDefinedEnergySequence()
	 * @see #unsetUserDefinedEnergySequence()
	 * @see #setUserDefinedEnergySequence(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEnergyProperties_UserDefinedEnergySequence()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedEnergySequence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Energy Sequence</em>' attribute.
	 * @see #isSetUserDefinedEnergySequence()
	 * @see #unsetUserDefinedEnergySequence()
	 * @see #getUserDefinedEnergySequence()
	 * @generated
	 */
	void setUserDefinedEnergySequence(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedEnergySequence()
	 * @see #getUserDefinedEnergySequence()
	 * @see #setUserDefinedEnergySequence(String)
	 * @generated
	 */
	void unsetUserDefinedEnergySequence();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcEnergyProperties#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Energy Sequence</em>' attribute is set.
	 * @see #unsetUserDefinedEnergySequence()
	 * @see #getUserDefinedEnergySequence()
	 * @see #setUserDefinedEnergySequence(String)
	 * @generated
	 */
	boolean isSetUserDefinedEnergySequence();

} // IfcEnergyProperties
