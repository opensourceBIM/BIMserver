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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTable#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTable#getRows <em>Rows</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTable#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTable#getNumberOfCellsInRow <em>Number Of Cells In Row</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTable#getNumberOfDataRows <em>Number Of Data Rows</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTable#getNumberOfHeadings <em>Number Of Headings</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTable()
 * @model
 * @generated
 */
public interface IfcTable extends IfcMetricValueSelect, IfcObjectReferenceSelect {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTable_Name()
	 * @model unsettable="true"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTable#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Rows</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcTableRow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' reference list.
	 * @see #isSetRows()
	 * @see #unsetRows()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTable_Rows()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcTableRow> getRows();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getRows <em>Rows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRows()
	 * @see #getRows()
	 * @generated
	 */
	void unsetRows();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTable#getRows <em>Rows</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rows</em>' reference list is set.
	 * @see #unsetRows()
	 * @see #getRows()
	 * @generated
	 */
	boolean isSetRows();

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcTableColumn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see #isSetColumns()
	 * @see #unsetColumns()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTable_Columns()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcTableColumn> getColumns();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getColumns <em>Columns</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetColumns()
	 * @see #getColumns()
	 * @generated
	 */
	void unsetColumns();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTable#getColumns <em>Columns</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Columns</em>' reference list is set.
	 * @see #unsetColumns()
	 * @see #getColumns()
	 * @generated
	 */
	boolean isSetColumns();

	/**
	 * Returns the value of the '<em><b>Number Of Cells In Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Cells In Row</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Cells In Row</em>' attribute.
	 * @see #isSetNumberOfCellsInRow()
	 * @see #unsetNumberOfCellsInRow()
	 * @see #setNumberOfCellsInRow(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTable_NumberOfCellsInRow()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getNumberOfCellsInRow();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfCellsInRow <em>Number Of Cells In Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Cells In Row</em>' attribute.
	 * @see #isSetNumberOfCellsInRow()
	 * @see #unsetNumberOfCellsInRow()
	 * @see #getNumberOfCellsInRow()
	 * @generated
	 */
	void setNumberOfCellsInRow(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfCellsInRow <em>Number Of Cells In Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberOfCellsInRow()
	 * @see #getNumberOfCellsInRow()
	 * @see #setNumberOfCellsInRow(long)
	 * @generated
	 */
	void unsetNumberOfCellsInRow();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfCellsInRow <em>Number Of Cells In Row</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Cells In Row</em>' attribute is set.
	 * @see #unsetNumberOfCellsInRow()
	 * @see #getNumberOfCellsInRow()
	 * @see #setNumberOfCellsInRow(long)
	 * @generated
	 */
	boolean isSetNumberOfCellsInRow();

	/**
	 * Returns the value of the '<em><b>Number Of Data Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Data Rows</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Data Rows</em>' attribute.
	 * @see #isSetNumberOfDataRows()
	 * @see #unsetNumberOfDataRows()
	 * @see #setNumberOfDataRows(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTable_NumberOfDataRows()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getNumberOfDataRows();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfDataRows <em>Number Of Data Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Data Rows</em>' attribute.
	 * @see #isSetNumberOfDataRows()
	 * @see #unsetNumberOfDataRows()
	 * @see #getNumberOfDataRows()
	 * @generated
	 */
	void setNumberOfDataRows(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfDataRows <em>Number Of Data Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberOfDataRows()
	 * @see #getNumberOfDataRows()
	 * @see #setNumberOfDataRows(long)
	 * @generated
	 */
	void unsetNumberOfDataRows();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfDataRows <em>Number Of Data Rows</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Data Rows</em>' attribute is set.
	 * @see #unsetNumberOfDataRows()
	 * @see #getNumberOfDataRows()
	 * @see #setNumberOfDataRows(long)
	 * @generated
	 */
	boolean isSetNumberOfDataRows();

	/**
	 * Returns the value of the '<em><b>Number Of Headings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Headings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Headings</em>' attribute.
	 * @see #isSetNumberOfHeadings()
	 * @see #unsetNumberOfHeadings()
	 * @see #setNumberOfHeadings(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTable_NumberOfHeadings()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getNumberOfHeadings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfHeadings <em>Number Of Headings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Headings</em>' attribute.
	 * @see #isSetNumberOfHeadings()
	 * @see #unsetNumberOfHeadings()
	 * @see #getNumberOfHeadings()
	 * @generated
	 */
	void setNumberOfHeadings(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfHeadings <em>Number Of Headings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumberOfHeadings()
	 * @see #getNumberOfHeadings()
	 * @see #setNumberOfHeadings(long)
	 * @generated
	 */
	void unsetNumberOfHeadings();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTable#getNumberOfHeadings <em>Number Of Headings</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Number Of Headings</em>' attribute is set.
	 * @see #unsetNumberOfHeadings()
	 * @see #getNumberOfHeadings()
	 * @see #setNumberOfHeadings(long)
	 * @generated
	 */
	boolean isSetNumberOfHeadings();

} // IfcTable
