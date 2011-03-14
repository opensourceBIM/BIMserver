/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralLoad;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralActivityImpl#getAppliedLoad <em>Applied Load</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralActivityImpl#getGlobalOrLocal <em>Global Or Local</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralActivityImpl#getAssignedToStructuralItem <em>Assigned To Structural Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralActivityImpl extends IfcProductImpl implements IfcStructuralActivity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralActivity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoad getAppliedLoad() {
		return (IfcStructuralLoad)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_AppliedLoad(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedLoad(IfcStructuralLoad newAppliedLoad) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_AppliedLoad(), newAppliedLoad);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGlobalOrLocalEnum getGlobalOrLocal() {
		return (IfcGlobalOrLocalEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_GlobalOrLocal(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOrLocal(IfcGlobalOrLocalEnum newGlobalOrLocal) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_GlobalOrLocal(), newGlobalOrLocal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsStructuralActivity getAssignedToStructuralItem() {
		return (IfcRelConnectsStructuralActivity)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_AssignedToStructuralItem(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignedToStructuralItem(IfcRelConnectsStructuralActivity newAssignedToStructuralItem) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_AssignedToStructuralItem(), newAssignedToStructuralItem);
	}

} //IfcStructuralActivityImpl
