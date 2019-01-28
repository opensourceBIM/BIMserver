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

public interface IfcStairFlight extends IfcBuildingElement {
	/**
	 * Returns the value of the '<em><b>Number Of Riser</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Riser</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Riser</em>' attribute.
	 * @see #isSetNumberOfRiser()
	 * @see #unsetNumberOfRiser()
	 * @see #setNumberOfRiser(long)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStairFlight_NumberOfRiser()
	 * @model unsettable="true"
	 * @generated
	 */
	long getNumberOfRiser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getNumberOfRiser <em>Number Of Riser</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Riser</em>' attribute.
	 * @see #isSetNumberOfRiser()
	 * @see #unsetNumberOfRiser()
	 * @see #getNumberOfRiser()
	 * @generated
	 */
	void setNumberOfRiser(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getNumberOfRiser <em>Number Of Riser</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberOfRiser()
	 * @see #getNumberOfRiser()
	 * @see #setNumberOfRiser(long)
	 * @generated
	 */
	void unsetNumberOfRiser();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getNumberOfRiser <em>Number Of Riser</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Riser</em>' attribute is set.
	 * @see #unsetNumberOfRiser()
	 * @see #getNumberOfRiser()
	 * @see #setNumberOfRiser(long)
	 * @generated
	 */
	boolean isSetNumberOfRiser();

	/**
	 * Returns the value of the '<em><b>Number Of Treads</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Treads</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Treads</em>' attribute.
	 * @see #isSetNumberOfTreads()
	 * @see #unsetNumberOfTreads()
	 * @see #setNumberOfTreads(long)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStairFlight_NumberOfTreads()
	 * @model unsettable="true"
	 * @generated
	 */
	long getNumberOfTreads();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getNumberOfTreads <em>Number Of Treads</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Treads</em>' attribute.
	 * @see #isSetNumberOfTreads()
	 * @see #unsetNumberOfTreads()
	 * @see #getNumberOfTreads()
	 * @generated
	 */
	void setNumberOfTreads(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getNumberOfTreads <em>Number Of Treads</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberOfTreads()
	 * @see #getNumberOfTreads()
	 * @see #setNumberOfTreads(long)
	 * @generated
	 */
	void unsetNumberOfTreads();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getNumberOfTreads <em>Number Of Treads</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Treads</em>' attribute is set.
	 * @see #unsetNumberOfTreads()
	 * @see #getNumberOfTreads()
	 * @see #setNumberOfTreads(long)
	 * @generated
	 */
	boolean isSetNumberOfTreads();

	/**
	 * Returns the value of the '<em><b>Riser Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Riser Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Riser Height</em>' attribute.
	 * @see #isSetRiserHeight()
	 * @see #unsetRiserHeight()
	 * @see #setRiserHeight(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStairFlight_RiserHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRiserHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getRiserHeight <em>Riser Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Riser Height</em>' attribute.
	 * @see #isSetRiserHeight()
	 * @see #unsetRiserHeight()
	 * @see #getRiserHeight()
	 * @generated
	 */
	void setRiserHeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getRiserHeight <em>Riser Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRiserHeight()
	 * @see #getRiserHeight()
	 * @see #setRiserHeight(double)
	 * @generated
	 */
	void unsetRiserHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getRiserHeight <em>Riser Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Riser Height</em>' attribute is set.
	 * @see #unsetRiserHeight()
	 * @see #getRiserHeight()
	 * @see #setRiserHeight(double)
	 * @generated
	 */
	boolean isSetRiserHeight();

	/**
	 * Returns the value of the '<em><b>Riser Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Riser Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Riser Height As String</em>' attribute.
	 * @see #isSetRiserHeightAsString()
	 * @see #unsetRiserHeightAsString()
	 * @see #setRiserHeightAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStairFlight_RiserHeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRiserHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getRiserHeightAsString <em>Riser Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Riser Height As String</em>' attribute.
	 * @see #isSetRiserHeightAsString()
	 * @see #unsetRiserHeightAsString()
	 * @see #getRiserHeightAsString()
	 * @generated
	 */
	void setRiserHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getRiserHeightAsString <em>Riser Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRiserHeightAsString()
	 * @see #getRiserHeightAsString()
	 * @see #setRiserHeightAsString(String)
	 * @generated
	 */
	void unsetRiserHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getRiserHeightAsString <em>Riser Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Riser Height As String</em>' attribute is set.
	 * @see #unsetRiserHeightAsString()
	 * @see #getRiserHeightAsString()
	 * @see #setRiserHeightAsString(String)
	 * @generated
	 */
	boolean isSetRiserHeightAsString();

	/**
	 * Returns the value of the '<em><b>Tread Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tread Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tread Length</em>' attribute.
	 * @see #isSetTreadLength()
	 * @see #unsetTreadLength()
	 * @see #setTreadLength(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStairFlight_TreadLength()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTreadLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getTreadLength <em>Tread Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tread Length</em>' attribute.
	 * @see #isSetTreadLength()
	 * @see #unsetTreadLength()
	 * @see #getTreadLength()
	 * @generated
	 */
	void setTreadLength(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getTreadLength <em>Tread Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTreadLength()
	 * @see #getTreadLength()
	 * @see #setTreadLength(double)
	 * @generated
	 */
	void unsetTreadLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getTreadLength <em>Tread Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tread Length</em>' attribute is set.
	 * @see #unsetTreadLength()
	 * @see #getTreadLength()
	 * @see #setTreadLength(double)
	 * @generated
	 */
	boolean isSetTreadLength();

	/**
	 * Returns the value of the '<em><b>Tread Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tread Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tread Length As String</em>' attribute.
	 * @see #isSetTreadLengthAsString()
	 * @see #unsetTreadLengthAsString()
	 * @see #setTreadLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStairFlight_TreadLengthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTreadLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getTreadLengthAsString <em>Tread Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tread Length As String</em>' attribute.
	 * @see #isSetTreadLengthAsString()
	 * @see #unsetTreadLengthAsString()
	 * @see #getTreadLengthAsString()
	 * @generated
	 */
	void setTreadLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getTreadLengthAsString <em>Tread Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTreadLengthAsString()
	 * @see #getTreadLengthAsString()
	 * @see #setTreadLengthAsString(String)
	 * @generated
	 */
	void unsetTreadLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStairFlight#getTreadLengthAsString <em>Tread Length As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tread Length As String</em>' attribute is set.
	 * @see #unsetTreadLengthAsString()
	 * @see #getTreadLengthAsString()
	 * @see #setTreadLengthAsString(String)
	 * @generated
	 */
	boolean isSetTreadLengthAsString();

} // IfcStairFlight
