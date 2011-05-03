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
package org.bimserver.models.store;

import org.bimserver.models.store.Clash;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guid Clash</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.GuidClash#getGuid1 <em>Guid1</em>}</li>
 *   <li>{@link org.bimserver.models.store.GuidClash#getGuid2 <em>Guid2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getGuidClash()
 * @model
 * @generated
 */
public interface GuidClash extends Clash
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * Returns the value of the '<em><b>Guid1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guid1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guid1</em>' attribute.
	 * @see #setGuid1(String)
	 * @see org.bimserver.models.store.StorePackage#getGuidClash_Guid1()
	 * @model
	 * @generated
	 */
	String getGuid1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GuidClash#getGuid1 <em>Guid1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid1</em>' attribute.
	 * @see #getGuid1()
	 * @generated
	 */
	void setGuid1(String value);

	/**
	 * Returns the value of the '<em><b>Guid2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guid2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guid2</em>' attribute.
	 * @see #setGuid2(String)
	 * @see org.bimserver.models.store.StorePackage#getGuidClash_Guid2()
	 * @model
	 * @generated
	 */
	String getGuid2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GuidClash#getGuid2 <em>Guid2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid2</em>' attribute.
	 * @see #getGuid2()
	 * @generated
	 */
	void setGuid2(String value);

} // GuidClash
