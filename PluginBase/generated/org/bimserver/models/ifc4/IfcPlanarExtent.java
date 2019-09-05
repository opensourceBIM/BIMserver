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

public interface IfcPlanarExtent extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Size In X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size In X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size In X</em>' attribute.
	 * @see #setSizeInX(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPlanarExtent_SizeInX()
	 * @model
	 * @generated
	 */
	double getSizeInX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPlanarExtent#getSizeInX <em>Size In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size In X</em>' attribute.
	 * @see #getSizeInX()
	 * @generated
	 */
	void setSizeInX(double value);

	/**
	 * Returns the value of the '<em><b>Size In XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size In XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size In XAs String</em>' attribute.
	 * @see #setSizeInXAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPlanarExtent_SizeInXAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getSizeInXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPlanarExtent#getSizeInXAsString <em>Size In XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size In XAs String</em>' attribute.
	 * @see #getSizeInXAsString()
	 * @generated
	 */
	void setSizeInXAsString(String value);

	/**
	 * Returns the value of the '<em><b>Size In Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size In Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size In Y</em>' attribute.
	 * @see #setSizeInY(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPlanarExtent_SizeInY()
	 * @model
	 * @generated
	 */
	double getSizeInY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPlanarExtent#getSizeInY <em>Size In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size In Y</em>' attribute.
	 * @see #getSizeInY()
	 * @generated
	 */
	void setSizeInY(double value);

	/**
	 * Returns the value of the '<em><b>Size In YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size In YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size In YAs String</em>' attribute.
	 * @see #setSizeInYAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPlanarExtent_SizeInYAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getSizeInYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPlanarExtent#getSizeInYAsString <em>Size In YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size In YAs String</em>' attribute.
	 * @see #getSizeInYAsString()
	 * @generated
	 */
	void setSizeInYAsString(String value);

} // IfcPlanarExtent
