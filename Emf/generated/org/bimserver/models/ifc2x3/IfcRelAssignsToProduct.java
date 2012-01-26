/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Assigns To Product</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProduct#getRelatingProduct <em>Relating Product</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssignsToProduct()
 * @model
 * @generated
 */
public interface IfcRelAssignsToProduct extends IfcRelAssigns {
	/**
	 * Returns the value of the '<em><b>Relating Product</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProduct#getReferencedBy <em>Referenced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Product</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Product</em>' reference.
	 * @see #isSetRelatingProduct()
	 * @see #unsetRelatingProduct()
	 * @see #setRelatingProduct(IfcProduct)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssignsToProduct_RelatingProduct()
	 * @see org.bimserver.models.ifc2x3.IfcProduct#getReferencedBy
	 * @model opposite="ReferencedBy" unsettable="true"
	 * @generated
	 */
	IfcProduct getRelatingProduct();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProduct#getRelatingProduct <em>Relating Product</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Product</em>' reference.
	 * @see #isSetRelatingProduct()
	 * @see #unsetRelatingProduct()
	 * @see #getRelatingProduct()
	 * @generated
	 */
	void setRelatingProduct(IfcProduct value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProduct#getRelatingProduct <em>Relating Product</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingProduct()
	 * @see #getRelatingProduct()
	 * @see #setRelatingProduct(IfcProduct)
	 * @generated
	 */
	void unsetRelatingProduct();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProduct#getRelatingProduct <em>Relating Product</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Product</em>' reference is set.
	 * @see #unsetRelatingProduct()
	 * @see #getRelatingProduct()
	 * @see #setRelatingProduct(IfcProduct)
	 * @generated
	 */
	boolean isSetRelatingProduct();

} // IfcRelAssignsToProduct
