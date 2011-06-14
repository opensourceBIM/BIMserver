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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Stair Flight</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStairFlight#getNumberOfRiser <em>Number Of Riser</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStairFlight#getNumberOfTreads <em>Number Of Treads</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStairFlight#getRiserHeight <em>Riser Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStairFlight#getRiserHeightAsString <em>Riser Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStairFlight#getTreadLength <em>Tread Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStairFlight#getTreadLengthAsString <em>Tread Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStairFlight()
 * @model
 * @generated
 */
public interface IfcStairFlight extends IfcBuildingElement
{
	/**
	 * Returns the value of the '<em><b>Number Of Riser</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Riser</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Riser</em>' attribute.
	 * @see #setNumberOfRiser(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStairFlight_NumberOfRiser()
	 * @model
	 * @generated
	 */
	int getNumberOfRiser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getNumberOfRiser <em>Number Of Riser</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Riser</em>' attribute.
	 * @see #getNumberOfRiser()
	 * @generated
	 */
	void setNumberOfRiser(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Treads</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Treads</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Treads</em>' attribute.
	 * @see #setNumberOfTreads(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStairFlight_NumberOfTreads()
	 * @model
	 * @generated
	 */
	int getNumberOfTreads();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getNumberOfTreads <em>Number Of Treads</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Treads</em>' attribute.
	 * @see #getNumberOfTreads()
	 * @generated
	 */
	void setNumberOfTreads(int value);

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
	 * @see #setRiserHeight(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStairFlight_RiserHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRiserHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getRiserHeight <em>Riser Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Riser Height</em>' attribute.
	 * @see #isSetRiserHeight()
	 * @see #unsetRiserHeight()
	 * @see #getRiserHeight()
	 * @generated
	 */
	void setRiserHeight(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getRiserHeight <em>Riser Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRiserHeight()
	 * @see #getRiserHeight()
	 * @see #setRiserHeight(float)
	 * @generated
	 */
	void unsetRiserHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getRiserHeight <em>Riser Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Riser Height</em>' attribute is set.
	 * @see #unsetRiserHeight()
	 * @see #getRiserHeight()
	 * @see #setRiserHeight(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStairFlight_RiserHeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRiserHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getRiserHeightAsString <em>Riser Height As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getRiserHeightAsString <em>Riser Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRiserHeightAsString()
	 * @see #getRiserHeightAsString()
	 * @see #setRiserHeightAsString(String)
	 * @generated
	 */
	void unsetRiserHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getRiserHeightAsString <em>Riser Height As String</em>}' attribute is set.
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
	 * @see #setTreadLength(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStairFlight_TreadLength()
	 * @model unsettable="true"
	 * @generated
	 */
	float getTreadLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getTreadLength <em>Tread Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tread Length</em>' attribute.
	 * @see #isSetTreadLength()
	 * @see #unsetTreadLength()
	 * @see #getTreadLength()
	 * @generated
	 */
	void setTreadLength(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getTreadLength <em>Tread Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTreadLength()
	 * @see #getTreadLength()
	 * @see #setTreadLength(float)
	 * @generated
	 */
	void unsetTreadLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getTreadLength <em>Tread Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tread Length</em>' attribute is set.
	 * @see #unsetTreadLength()
	 * @see #getTreadLength()
	 * @see #setTreadLength(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStairFlight_TreadLengthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTreadLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getTreadLengthAsString <em>Tread Length As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getTreadLengthAsString <em>Tread Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTreadLengthAsString()
	 * @see #getTreadLengthAsString()
	 * @see #setTreadLengthAsString(String)
	 * @generated
	 */
	void unsetTreadLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStairFlight#getTreadLengthAsString <em>Tread Length As String</em>}' attribute is set.
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
