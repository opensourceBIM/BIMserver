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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Table Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTableRow#getRowCells <em>Row Cells</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTableRow#getIsHeading <em>Is Heading</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTableRow#getOfTable <em>Of Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTableRow()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcTableRow extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Row Cells</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Cells</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Cells</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTableRow_RowCells()
	 * @model
	 * @generated
	 */
	EList<IfcValue> getRowCells();

	/**
	 * Returns the value of the '<em><b>Is Heading</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Heading</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Heading</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setIsHeading(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTableRow_IsHeading()
	 * @model
	 * @generated
	 */
	Tristate getIsHeading();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTableRow#getIsHeading <em>Is Heading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Heading</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getIsHeading()
	 * @generated
	 */
	void setIsHeading(Tristate value);

	/**
	 * Returns the value of the '<em><b>Of Table</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcTable#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of Table</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Table</em>' reference.
	 * @see #setOfTable(IfcTable)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTableRow_OfTable()
	 * @see org.bimserver.models.ifc2x3.IfcTable#getRows
	 * @model opposite="Rows"
	 * @generated
	 */
	IfcTable getOfTable();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTableRow#getOfTable <em>Of Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Of Table</em>' reference.
	 * @see #getOfTable()
	 * @generated
	 */
	void setOfTable(IfcTable value);

} // IfcTableRow
