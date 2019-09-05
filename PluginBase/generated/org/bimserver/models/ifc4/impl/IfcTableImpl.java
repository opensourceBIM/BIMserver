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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcTable;
import org.bimserver.models.ifc4.IfcTableColumn;
import org.bimserver.models.ifc4.IfcTableRow;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTableImpl#getRows <em>Rows</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTableImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTableImpl#getNumberOfCellsInRow <em>Number Of Cells In Row</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTableImpl#getNumberOfDataRows <em>Number Of Data Rows</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTableImpl#getNumberOfHeadings <em>Number Of Headings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTableImpl extends IdEObjectImpl implements IfcTable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_TABLE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_TABLE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4Package.Literals.IFC_TABLE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_TABLE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcTableRow> getRows() {
		return (EList<IfcTableRow>) eGet(Ifc4Package.Literals.IFC_TABLE__ROWS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRows() {
		eUnset(Ifc4Package.Literals.IFC_TABLE__ROWS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRows() {
		return eIsSet(Ifc4Package.Literals.IFC_TABLE__ROWS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcTableColumn> getColumns() {
		return (EList<IfcTableColumn>) eGet(Ifc4Package.Literals.IFC_TABLE__COLUMNS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetColumns() {
		eUnset(Ifc4Package.Literals.IFC_TABLE__COLUMNS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetColumns() {
		return eIsSet(Ifc4Package.Literals.IFC_TABLE__COLUMNS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNumberOfCellsInRow() {
		return (Long) eGet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_CELLS_IN_ROW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumberOfCellsInRow(long newNumberOfCellsInRow) {
		eSet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_CELLS_IN_ROW, newNumberOfCellsInRow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNumberOfCellsInRow() {
		eUnset(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_CELLS_IN_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNumberOfCellsInRow() {
		return eIsSet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_CELLS_IN_ROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNumberOfDataRows() {
		return (Long) eGet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_DATA_ROWS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumberOfDataRows(long newNumberOfDataRows) {
		eSet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_DATA_ROWS, newNumberOfDataRows);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNumberOfDataRows() {
		eUnset(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_DATA_ROWS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNumberOfDataRows() {
		return eIsSet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_DATA_ROWS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNumberOfHeadings() {
		return (Long) eGet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_HEADINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumberOfHeadings(long newNumberOfHeadings) {
		eSet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_HEADINGS, newNumberOfHeadings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNumberOfHeadings() {
		eUnset(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_HEADINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNumberOfHeadings() {
		return eIsSet(Ifc4Package.Literals.IFC_TABLE__NUMBER_OF_HEADINGS);
	}

} //IfcTableImpl
