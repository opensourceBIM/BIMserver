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
package org.bimserver.models.store;

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

public interface LongCheckinActionState extends LongActionState {
	/**
	 * Returns the value of the '<em><b>Roid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roid</em>' attribute.
	 * @see #setRoid(long)
	 * @see org.bimserver.models.store.StorePackage#getLongCheckinActionState_Roid()
	 * @model
	 * @generated
	 */
	long getRoid();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.LongCheckinActionState#getRoid <em>Roid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Roid</em>' attribute.
	 * @see #getRoid()
	 * @generated
	 */
	void setRoid(long value);

	/**
	 * Returns the value of the '<em><b>Deserialize Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deserialize Error Code</em>' attribute.
	 * @see #setDeserializeErrorCode(int)
	 * @see org.bimserver.models.store.StorePackage#getLongCheckinActionState_DeserializeErrorCode()
	 * @model
	 * @generated
	 */
	int getDeserializeErrorCode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.LongCheckinActionState#getDeserializeErrorCode <em>Deserialize Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deserialize Error Code</em>' attribute.
	 * @see #getDeserializeErrorCode()
	 * @generated
	 */
	void setDeserializeErrorCode(int value);

} // LongCheckinActionState
