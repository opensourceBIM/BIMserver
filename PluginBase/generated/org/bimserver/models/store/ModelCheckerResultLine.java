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

public interface ModelCheckerResultLine extends ModelCheckerResultItem {
	/**
	 * Returns the value of the '<em><b>Field Or Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Or Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Or Class</em>' attribute.
	 * @see #setFieldOrClass(String)
	 * @see org.bimserver.models.store.StorePackage#getModelCheckerResultLine_FieldOrClass()
	 * @model
	 * @generated
	 */
	String getFieldOrClass();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ModelCheckerResultLine#getFieldOrClass <em>Field Or Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Or Class</em>' attribute.
	 * @see #getFieldOrClass()
	 * @generated
	 */
	void setFieldOrClass(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.bimserver.models.store.StorePackage#getModelCheckerResultLine_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ModelCheckerResultLine#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Should Be</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Should Be</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Should Be</em>' attribute.
	 * @see #setShouldBe(String)
	 * @see org.bimserver.models.store.StorePackage#getModelCheckerResultLine_ShouldBe()
	 * @model
	 * @generated
	 */
	String getShouldBe();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ModelCheckerResultLine#getShouldBe <em>Should Be</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Should Be</em>' attribute.
	 * @see #getShouldBe()
	 * @generated
	 */
	void setShouldBe(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.ModelCheckerResultType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.bimserver.models.store.ModelCheckerResultType
	 * @see #setType(ModelCheckerResultType)
	 * @see org.bimserver.models.store.StorePackage#getModelCheckerResultLine_Type()
	 * @model
	 * @generated
	 */
	ModelCheckerResultType getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ModelCheckerResultLine#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.bimserver.models.store.ModelCheckerResultType
	 * @see #getType()
	 * @generated
	 */
	void setType(ModelCheckerResultType value);

	/**
	 * Returns the value of the '<em><b>Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Id</em>' attribute.
	 * @see #setObjectId(long)
	 * @see org.bimserver.models.store.StorePackage#getModelCheckerResultLine_ObjectId()
	 * @model
	 * @generated
	 */
	long getObjectId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ModelCheckerResultLine#getObjectId <em>Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Id</em>' attribute.
	 * @see #getObjectId()
	 * @generated
	 */
	void setObjectId(long value);

} // ModelCheckerResultLine
