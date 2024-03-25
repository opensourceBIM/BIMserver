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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rigid Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getFirstCoordinate <em>First Coordinate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getSecondCoordinate <em>Second Coordinate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getHeightAsString <em>Height As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRigidOperation()
 * @model
 * @generated
 */
public interface IfcRigidOperation extends IfcCoordinateOperation {
	/**
	 * Returns the value of the '<em><b>First Coordinate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Coordinate</em>' reference.
	 * @see #setFirstCoordinate(IfcMeasureValue)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRigidOperation_FirstCoordinate()
	 * @model
	 * @generated
	 */
	IfcMeasureValue getFirstCoordinate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getFirstCoordinate <em>First Coordinate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Coordinate</em>' reference.
	 * @see #getFirstCoordinate()
	 * @generated
	 */
	void setFirstCoordinate(IfcMeasureValue value);

	/**
	 * Returns the value of the '<em><b>Second Coordinate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Coordinate</em>' reference.
	 * @see #setSecondCoordinate(IfcMeasureValue)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRigidOperation_SecondCoordinate()
	 * @model
	 * @generated
	 */
	IfcMeasureValue getSecondCoordinate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getSecondCoordinate <em>Second Coordinate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Coordinate</em>' reference.
	 * @see #getSecondCoordinate()
	 * @generated
	 */
	void setSecondCoordinate(IfcMeasureValue value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #setHeight(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRigidOperation_Height()
	 * @model unsettable="true"
	 * @generated
	 */
	double getHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeight()
	 * @see #getHeight()
	 * @see #setHeight(double)
	 * @generated
	 */
	void unsetHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getHeight <em>Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Height</em>' attribute is set.
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @see #setHeight(double)
	 * @generated
	 */
	boolean isSetHeight();

	/**
	 * Returns the value of the '<em><b>Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height As String</em>' attribute.
	 * @see #isSetHeightAsString()
	 * @see #unsetHeightAsString()
	 * @see #setHeightAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRigidOperation_HeightAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getHeightAsString <em>Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height As String</em>' attribute.
	 * @see #isSetHeightAsString()
	 * @see #unsetHeightAsString()
	 * @see #getHeightAsString()
	 * @generated
	 */
	void setHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getHeightAsString <em>Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeightAsString()
	 * @see #getHeightAsString()
	 * @see #setHeightAsString(String)
	 * @generated
	 */
	void unsetHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRigidOperation#getHeightAsString <em>Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Height As String</em>' attribute is set.
	 * @see #unsetHeightAsString()
	 * @see #getHeightAsString()
	 * @see #setHeightAsString(String)
	 * @generated
	 */
	boolean isSetHeightAsString();

} // IfcRigidOperation
