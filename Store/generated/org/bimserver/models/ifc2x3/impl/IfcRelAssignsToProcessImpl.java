/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcMeasureWithUnit;
import org.bimserver.models.ifc2x3.IfcProcess;
import org.bimserver.models.ifc2x3.IfcRelAssignsToProcess;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Assigns To Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssignsToProcessImpl#getRelatingProcess <em>Relating Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssignsToProcessImpl#getQuantityInProcess <em>Quantity In Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssignsToProcessImpl extends IfcRelAssignsImpl implements IfcRelAssignsToProcess {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssignsToProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssignsToProcess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcess getRelatingProcess() {
		return (IfcProcess)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToProcess_RelatingProcess(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingProcess(IfcProcess newRelatingProcess) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToProcess_RelatingProcess(), newRelatingProcess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureWithUnit getQuantityInProcess() {
		return (IfcMeasureWithUnit)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToProcess_QuantityInProcess(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantityInProcess(IfcMeasureWithUnit newQuantityInProcess) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToProcess_QuantityInProcess(), newQuantityInProcess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetQuantityInProcess() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToProcess_QuantityInProcess());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetQuantityInProcess() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsToProcess_QuantityInProcess());
	}

} //IfcRelAssignsToProcessImpl
