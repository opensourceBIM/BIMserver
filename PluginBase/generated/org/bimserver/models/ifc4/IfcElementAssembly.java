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

public interface IfcElementAssembly extends IfcElement {
	/**
	 * Returns the value of the '<em><b>Assembly Place</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcAssemblyPlaceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Place</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Place</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcAssemblyPlaceEnum
	 * @see #isSetAssemblyPlace()
	 * @see #unsetAssemblyPlace()
	 * @see #setAssemblyPlace(IfcAssemblyPlaceEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcElementAssembly_AssemblyPlace()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAssemblyPlaceEnum getAssemblyPlace();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcElementAssembly#getAssemblyPlace <em>Assembly Place</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Place</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcAssemblyPlaceEnum
	 * @see #isSetAssemblyPlace()
	 * @see #unsetAssemblyPlace()
	 * @see #getAssemblyPlace()
	 * @generated
	 */
	void setAssemblyPlace(IfcAssemblyPlaceEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcElementAssembly#getAssemblyPlace <em>Assembly Place</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAssemblyPlace()
	 * @see #getAssemblyPlace()
	 * @see #setAssemblyPlace(IfcAssemblyPlaceEnum)
	 * @generated
	 */
	void unsetAssemblyPlace();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcElementAssembly#getAssemblyPlace <em>Assembly Place</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Assembly Place</em>' attribute is set.
	 * @see #unsetAssemblyPlace()
	 * @see #getAssemblyPlace()
	 * @see #setAssemblyPlace(IfcAssemblyPlaceEnum)
	 * @generated
	 */
	boolean isSetAssemblyPlace();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcElementAssemblyTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcElementAssemblyTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcElementAssemblyTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcElementAssembly_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcElementAssemblyTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcElementAssembly#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcElementAssemblyTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcElementAssemblyTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcElementAssembly#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcElementAssemblyTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcElementAssembly#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcElementAssemblyTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

} // IfcElementAssembly
