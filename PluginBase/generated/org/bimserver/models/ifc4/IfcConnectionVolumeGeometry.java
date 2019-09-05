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
package org.bimserver.models.ifc4;

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

public interface IfcConnectionVolumeGeometry extends IfcConnectionGeometry {
	/**
	 * Returns the value of the '<em><b>Volume On Relating Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume On Relating Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume On Relating Element</em>' reference.
	 * @see #setVolumeOnRelatingElement(IfcSolidOrShell)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConnectionVolumeGeometry_VolumeOnRelatingElement()
	 * @model
	 * @generated
	 */
	IfcSolidOrShell getVolumeOnRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConnectionVolumeGeometry#getVolumeOnRelatingElement <em>Volume On Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume On Relating Element</em>' reference.
	 * @see #getVolumeOnRelatingElement()
	 * @generated
	 */
	void setVolumeOnRelatingElement(IfcSolidOrShell value);

	/**
	 * Returns the value of the '<em><b>Volume On Related Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume On Related Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume On Related Element</em>' reference.
	 * @see #isSetVolumeOnRelatedElement()
	 * @see #unsetVolumeOnRelatedElement()
	 * @see #setVolumeOnRelatedElement(IfcSolidOrShell)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConnectionVolumeGeometry_VolumeOnRelatedElement()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSolidOrShell getVolumeOnRelatedElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConnectionVolumeGeometry#getVolumeOnRelatedElement <em>Volume On Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume On Related Element</em>' reference.
	 * @see #isSetVolumeOnRelatedElement()
	 * @see #unsetVolumeOnRelatedElement()
	 * @see #getVolumeOnRelatedElement()
	 * @generated
	 */
	void setVolumeOnRelatedElement(IfcSolidOrShell value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConnectionVolumeGeometry#getVolumeOnRelatedElement <em>Volume On Related Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVolumeOnRelatedElement()
	 * @see #getVolumeOnRelatedElement()
	 * @see #setVolumeOnRelatedElement(IfcSolidOrShell)
	 * @generated
	 */
	void unsetVolumeOnRelatedElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConnectionVolumeGeometry#getVolumeOnRelatedElement <em>Volume On Related Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Volume On Related Element</em>' reference is set.
	 * @see #unsetVolumeOnRelatedElement()
	 * @see #getVolumeOnRelatedElement()
	 * @see #setVolumeOnRelatedElement(IfcSolidOrShell)
	 * @generated
	 */
	boolean isSetVolumeOnRelatedElement();

} // IfcConnectionVolumeGeometry
