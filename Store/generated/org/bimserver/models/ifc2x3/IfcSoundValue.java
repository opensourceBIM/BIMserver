/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Sound Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSoundValue#getSoundLevelTimeSeries <em>Sound Level Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSoundValue#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSoundValue#getFrequencyAsString <em>Frequency As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSoundValue#getSoundLevelSingleValue <em>Sound Level Single Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundValue()
 * @model
 * @generated
 */
public interface IfcSoundValue extends IfcPropertySetDefinition {
	/**
	 * Returns the value of the '<em><b>Sound Level Time Series</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sound Level Time Series</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sound Level Time Series</em>' reference.
	 * @see #isSetSoundLevelTimeSeries()
	 * @see #unsetSoundLevelTimeSeries()
	 * @see #setSoundLevelTimeSeries(IfcTimeSeries)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundValue_SoundLevelTimeSeries()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTimeSeries getSoundLevelTimeSeries();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundValue#getSoundLevelTimeSeries <em>Sound Level Time Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sound Level Time Series</em>' reference.
	 * @see #isSetSoundLevelTimeSeries()
	 * @see #unsetSoundLevelTimeSeries()
	 * @see #getSoundLevelTimeSeries()
	 * @generated
	 */
	void setSoundLevelTimeSeries(IfcTimeSeries value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundValue#getSoundLevelTimeSeries <em>Sound Level Time Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSoundLevelTimeSeries()
	 * @see #getSoundLevelTimeSeries()
	 * @see #setSoundLevelTimeSeries(IfcTimeSeries)
	 * @generated
	 */
	void unsetSoundLevelTimeSeries();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundValue#getSoundLevelTimeSeries <em>Sound Level Time Series</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sound Level Time Series</em>' reference is set.
	 * @see #unsetSoundLevelTimeSeries()
	 * @see #getSoundLevelTimeSeries()
	 * @see #setSoundLevelTimeSeries(IfcTimeSeries)
	 * @generated
	 */
	boolean isSetSoundLevelTimeSeries();

	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frequency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frequency</em>' attribute.
	 * @see #setFrequency(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundValue_Frequency()
	 * @model
	 * @generated
	 */
	float getFrequency();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundValue#getFrequency <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency</em>' attribute.
	 * @see #getFrequency()
	 * @generated
	 */
	void setFrequency(float value);

	/**
	 * Returns the value of the '<em><b>Frequency As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frequency As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frequency As String</em>' attribute.
	 * @see #setFrequencyAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundValue_FrequencyAsString()
	 * @model
	 * @generated
	 */
	String getFrequencyAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundValue#getFrequencyAsString <em>Frequency As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency As String</em>' attribute.
	 * @see #getFrequencyAsString()
	 * @generated
	 */
	void setFrequencyAsString(String value);

	/**
	 * Returns the value of the '<em><b>Sound Level Single Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sound Level Single Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sound Level Single Value</em>' reference.
	 * @see #isSetSoundLevelSingleValue()
	 * @see #unsetSoundLevelSingleValue()
	 * @see #setSoundLevelSingleValue(IfcDerivedMeasureValue)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundValue_SoundLevelSingleValue()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDerivedMeasureValue getSoundLevelSingleValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundValue#getSoundLevelSingleValue <em>Sound Level Single Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sound Level Single Value</em>' reference.
	 * @see #isSetSoundLevelSingleValue()
	 * @see #unsetSoundLevelSingleValue()
	 * @see #getSoundLevelSingleValue()
	 * @generated
	 */
	void setSoundLevelSingleValue(IfcDerivedMeasureValue value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundValue#getSoundLevelSingleValue <em>Sound Level Single Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSoundLevelSingleValue()
	 * @see #getSoundLevelSingleValue()
	 * @see #setSoundLevelSingleValue(IfcDerivedMeasureValue)
	 * @generated
	 */
	void unsetSoundLevelSingleValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundValue#getSoundLevelSingleValue <em>Sound Level Single Value</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sound Level Single Value</em>' reference is set.
	 * @see #unsetSoundLevelSingleValue()
	 * @see #getSoundLevelSingleValue()
	 * @see #setSoundLevelSingleValue(IfcDerivedMeasureValue)
	 * @generated
	 */
	boolean isSetSoundLevelSingleValue();

} // IfcSoundValue
