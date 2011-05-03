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
 * A representation of the model object '<em><b>Eid Clash</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.EidClash#getEid1 <em>Eid1</em>}</li>
 *   <li>{@link org.bimserver.models.store.EidClash#getEid2 <em>Eid2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getEidClash()
 * @model
 * @generated
 */
public interface EidClash extends Clash
{
	/**
	 * Returns the value of the '<em><b>Eid1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eid1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eid1</em>' attribute.
	 * @see #setEid1(long)
	 * @see org.bimserver.models.store.StorePackage#getEidClash_Eid1()
	 * @model
	 * @generated
	 */
	long getEid1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.EidClash#getEid1 <em>Eid1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eid1</em>' attribute.
	 * @see #getEid1()
	 * @generated
	 */
	void setEid1(long value);

	/**
	 * Returns the value of the '<em><b>Eid2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eid2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eid2</em>' attribute.
	 * @see #setEid2(long)
	 * @see org.bimserver.models.store.StorePackage#getEidClash_Eid2()
	 * @model
	 * @generated
	 */
	long getEid2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.EidClash#getEid2 <em>Eid2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eid2</em>' attribute.
	 * @see #getEid2()
	 * @generated
	 */
	void setEid2(long value);

} // EidClash
