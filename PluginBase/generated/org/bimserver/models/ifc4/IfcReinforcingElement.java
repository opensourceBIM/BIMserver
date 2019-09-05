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

public interface IfcReinforcingElement extends IfcElementComponent {
	/**
	 * Returns the value of the '<em><b>Steel Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steel Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steel Grade</em>' attribute.
	 * @see #isSetSteelGrade()
	 * @see #unsetSteelGrade()
	 * @see #setSteelGrade(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReinforcingElement_SteelGrade()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSteelGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingElement#getSteelGrade <em>Steel Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steel Grade</em>' attribute.
	 * @see #isSetSteelGrade()
	 * @see #unsetSteelGrade()
	 * @see #getSteelGrade()
	 * @generated
	 */
	void setSteelGrade(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingElement#getSteelGrade <em>Steel Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSteelGrade()
	 * @see #getSteelGrade()
	 * @see #setSteelGrade(String)
	 * @generated
	 */
	void unsetSteelGrade();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcReinforcingElement#getSteelGrade <em>Steel Grade</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Steel Grade</em>' attribute is set.
	 * @see #unsetSteelGrade()
	 * @see #getSteelGrade()
	 * @see #setSteelGrade(String)
	 * @generated
	 */
	boolean isSetSteelGrade();

} // IfcReinforcingElement
