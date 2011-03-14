/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcTable;
import org.bimserver.models.ifc2x3.IfcTableRow;
import org.bimserver.models.ifc2x3.IfcValue;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Table Row</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTableRowImpl#getRowCells <em>Row Cells</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTableRowImpl#getIsHeading <em>Is Heading</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTableRowImpl#getOfTable <em>Of Table</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTableRowImpl extends IdEObjectImpl implements IfcTableRow {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTableRowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTableRow();
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
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getRowCells() {
		return (EList<IfcValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcTableRow_RowCells(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsHeading() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcTableRow_IsHeading(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsHeading(Tristate newIsHeading) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTableRow_IsHeading(), newIsHeading);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTable getOfTable() {
		return (IfcTable)eGet(Ifc2x3Package.eINSTANCE.getIfcTableRow_OfTable(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOfTable(IfcTable newOfTable) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTableRow_OfTable(), newOfTable);
	}

} //IfcTableRowImpl
