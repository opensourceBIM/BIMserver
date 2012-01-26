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
 * A representation of the model object '<em><b>Ifc Text Literal With Extent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getBoxAlignment <em>Box Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteralWithExtent()
 * @model
 * @generated
 */
public interface IfcTextLiteralWithExtent extends IfcTextLiteral {
	/**
	 * Returns the value of the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' reference.
	 * @see #isSetExtent()
	 * @see #unsetExtent()
	 * @see #setExtent(IfcPlanarExtent)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteralWithExtent_Extent()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPlanarExtent getExtent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getExtent <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' reference.
	 * @see #isSetExtent()
	 * @see #unsetExtent()
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(IfcPlanarExtent value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getExtent <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExtent()
	 * @see #getExtent()
	 * @see #setExtent(IfcPlanarExtent)
	 * @generated
	 */
	void unsetExtent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getExtent <em>Extent</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Extent</em>' reference is set.
	 * @see #unsetExtent()
	 * @see #getExtent()
	 * @see #setExtent(IfcPlanarExtent)
	 * @generated
	 */
	boolean isSetExtent();

	/**
	 * Returns the value of the '<em><b>Box Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Alignment</em>' attribute.
	 * @see #isSetBoxAlignment()
	 * @see #unsetBoxAlignment()
	 * @see #setBoxAlignment(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTextLiteralWithExtent_BoxAlignment()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBoxAlignment();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getBoxAlignment <em>Box Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Alignment</em>' attribute.
	 * @see #isSetBoxAlignment()
	 * @see #unsetBoxAlignment()
	 * @see #getBoxAlignment()
	 * @generated
	 */
	void setBoxAlignment(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getBoxAlignment <em>Box Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxAlignment()
	 * @see #getBoxAlignment()
	 * @see #setBoxAlignment(String)
	 * @generated
	 */
	void unsetBoxAlignment();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent#getBoxAlignment <em>Box Alignment</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Alignment</em>' attribute is set.
	 * @see #unsetBoxAlignment()
	 * @see #getBoxAlignment()
	 * @see #setBoxAlignment(String)
	 * @generated
	 */
	boolean isSetBoxAlignment();

} // IfcTextLiteralWithExtent
