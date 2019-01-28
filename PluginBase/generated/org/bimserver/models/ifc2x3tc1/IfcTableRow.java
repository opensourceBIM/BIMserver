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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Table Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTableRow#getRowCells <em>Row Cells</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTableRow#getIsHeading <em>Is Heading</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTableRow#getOfTable <em>Of Table</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTableRow()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcTableRow extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Row Cells</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Cells</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Cells</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTableRow_RowCells()
	 * @model
	 * @generated
	 */
	EList<IfcValue> getRowCells();

	/**
	 * Returns the value of the '<em><b>Is Heading</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Heading</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Heading</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #setIsHeading(Tristate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTableRow_IsHeading()
	 * @model
	 * @generated
	 */
	Tristate getIsHeading();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTableRow#getIsHeading <em>Is Heading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Heading</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #getIsHeading()
	 * @generated
	 */
	void setIsHeading(Tristate value);

	/**
	 * Returns the value of the '<em><b>Of Table</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcTable#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of Table</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Table</em>' reference.
	 * @see #isSetOfTable()
	 * @see #unsetOfTable()
	 * @see #setOfTable(IfcTable)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTableRow_OfTable()
	 * @see org.bimserver.models.ifc2x3tc1.IfcTable#getRows
	 * @model opposite="Rows" unsettable="true"
	 * @generated
	 */
	IfcTable getOfTable();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTableRow#getOfTable <em>Of Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Of Table</em>' reference.
	 * @see #isSetOfTable()
	 * @see #unsetOfTable()
	 * @see #getOfTable()
	 * @generated
	 */
	void setOfTable(IfcTable value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTableRow#getOfTable <em>Of Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOfTable()
	 * @see #getOfTable()
	 * @see #setOfTable(IfcTable)
	 * @generated
	 */
	void unsetOfTable();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTableRow#getOfTable <em>Of Table</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Of Table</em>' reference is set.
	 * @see #unsetOfTable()
	 * @see #getOfTable()
	 * @see #setOfTable(IfcTable)
	 * @generated
	 */
	boolean isSetOfTable();

} // IfcTableRow
