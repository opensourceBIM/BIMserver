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
	 * @see #setExtent(IfcPlanarExtent)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextLiteralWithExtent_Extent()
	 * @model
	 * @generated
	 */
	IfcPlanarExtent getExtent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTextLiteralWithExtent#getExtent <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' reference.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(IfcPlanarExtent value);

	/**
	 * Returns the value of the '<em><b>Box Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Alignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Alignment</em>' attribute.
	 * @see #setBoxAlignment(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextLiteralWithExtent_BoxAlignment()
	 * @model
	 * @generated
	 */
	String getBoxAlignment();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTextLiteralWithExtent#getBoxAlignment <em>Box Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Alignment</em>' attribute.
	 * @see #getBoxAlignment()
	 * @generated
	 */
	void setBoxAlignment(String value);

} // IfcTextLiteralWithExtent
