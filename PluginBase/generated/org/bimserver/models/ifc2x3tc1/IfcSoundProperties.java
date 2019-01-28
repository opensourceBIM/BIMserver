/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3tc1;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Sound Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSoundProperties#getIsAttenuating <em>Is Attenuating</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSoundProperties#getSoundScale <em>Sound Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSoundProperties#getSoundValues <em>Sound Values</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSoundProperties()
 * @model
 * @generated
 */
public interface IfcSoundProperties extends IfcPropertySetDefinition {
	/**
	 * Returns the value of the '<em><b>Is Attenuating</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Attenuating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Attenuating</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #setIsAttenuating(Tristate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSoundProperties_IsAttenuating()
	 * @model
	 * @generated
	 */
	Tristate getIsAttenuating();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSoundProperties#getIsAttenuating <em>Is Attenuating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Attenuating</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #getIsAttenuating()
	 * @generated
	 */
	void setIsAttenuating(Tristate value);

	/**
	 * Returns the value of the '<em><b>Sound Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcSoundScaleEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sound Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sound Scale</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcSoundScaleEnum
	 * @see #isSetSoundScale()
	 * @see #unsetSoundScale()
	 * @see #setSoundScale(IfcSoundScaleEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSoundProperties_SoundScale()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSoundScaleEnum getSoundScale();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSoundProperties#getSoundScale <em>Sound Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sound Scale</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcSoundScaleEnum
	 * @see #isSetSoundScale()
	 * @see #unsetSoundScale()
	 * @see #getSoundScale()
	 * @generated
	 */
	void setSoundScale(IfcSoundScaleEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSoundProperties#getSoundScale <em>Sound Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSoundScale()
	 * @see #getSoundScale()
	 * @see #setSoundScale(IfcSoundScaleEnum)
	 * @generated
	 */
	void unsetSoundScale();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSoundProperties#getSoundScale <em>Sound Scale</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sound Scale</em>' attribute is set.
	 * @see #unsetSoundScale()
	 * @see #getSoundScale()
	 * @see #setSoundScale(IfcSoundScaleEnum)
	 * @generated
	 */
	boolean isSetSoundScale();

	/**
	 * Returns the value of the '<em><b>Sound Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcSoundValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sound Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sound Values</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSoundProperties_SoundValues()
	 * @model
	 * @generated
	 */
	EList<IfcSoundValue> getSoundValues();

} // IfcSoundProperties
