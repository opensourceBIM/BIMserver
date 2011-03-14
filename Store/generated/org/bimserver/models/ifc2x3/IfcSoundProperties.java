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
 * A representation of the model object '<em><b>Ifc Sound Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSoundProperties#getIsAttenuating <em>Is Attenuating</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSoundProperties#getSoundScale <em>Sound Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSoundProperties#getSoundValues <em>Sound Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundProperties()
 * @model
 * @generated
 */
public interface IfcSoundProperties extends IfcPropertySetDefinition {
	/**
	 * Returns the value of the '<em><b>Is Attenuating</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Attenuating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Attenuating</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setIsAttenuating(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundProperties_IsAttenuating()
	 * @model
	 * @generated
	 */
	Tristate getIsAttenuating();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundProperties#getIsAttenuating <em>Is Attenuating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Attenuating</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getIsAttenuating()
	 * @generated
	 */
	void setIsAttenuating(Tristate value);

	/**
	 * Returns the value of the '<em><b>Sound Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcSoundScaleEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sound Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sound Scale</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSoundScaleEnum
	 * @see #setSoundScale(IfcSoundScaleEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundProperties_SoundScale()
	 * @model
	 * @generated
	 */
	IfcSoundScaleEnum getSoundScale();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSoundProperties#getSoundScale <em>Sound Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sound Scale</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSoundScaleEnum
	 * @see #getSoundScale()
	 * @generated
	 */
	void setSoundScale(IfcSoundScaleEnum value);

	/**
	 * Returns the value of the '<em><b>Sound Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcSoundValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sound Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sound Values</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSoundProperties_SoundValues()
	 * @model
	 * @generated
	 */
	EList<IfcSoundValue> getSoundValues();

} // IfcSoundProperties
