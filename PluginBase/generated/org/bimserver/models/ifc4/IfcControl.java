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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcControl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcControl#getControls <em>Controls</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcControl()
 * @model
 * @generated
 */
public interface IfcControl extends IfcObject {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification</em>' attribute.
	 * @see #isSetIdentification()
	 * @see #unsetIdentification()
	 * @see #setIdentification(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcControl_Identification()
	 * @model unsettable="true"
	 * @generated
	 */
	String getIdentification();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcControl#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' attribute.
	 * @see #isSetIdentification()
	 * @see #unsetIdentification()
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcControl#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdentification()
	 * @see #getIdentification()
	 * @see #setIdentification(String)
	 * @generated
	 */
	void unsetIdentification();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcControl#getIdentification <em>Identification</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Identification</em>' attribute is set.
	 * @see #unsetIdentification()
	 * @see #getIdentification()
	 * @see #setIdentification(String)
	 * @generated
	 */
	boolean isSetIdentification();

	/**
	 * Returns the value of the '<em><b>Controls</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssignsToControl}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelAssignsToControl#getRelatingControl <em>Relating Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controls</em>' reference list.
	 * @see #isSetControls()
	 * @see #unsetControls()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcControl_Controls()
	 * @see org.bimserver.models.ifc4.IfcRelAssignsToControl#getRelatingControl
	 * @model opposite="RelatingControl" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssignsToControl> getControls();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcControl#getControls <em>Controls</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetControls()
	 * @see #getControls()
	 * @generated
	 */
	void unsetControls();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcControl#getControls <em>Controls</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Controls</em>' reference list is set.
	 * @see #unsetControls()
	 * @see #getControls()
	 * @generated
	 */
	boolean isSetControls();

} // IfcControl
