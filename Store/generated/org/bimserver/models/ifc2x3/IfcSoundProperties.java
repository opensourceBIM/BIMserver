/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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
public interface IfcSoundProperties extends IfcPropertySetDefinition
{
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
