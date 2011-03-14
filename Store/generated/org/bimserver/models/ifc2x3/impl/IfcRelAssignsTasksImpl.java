/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRelAssignsTasks;
import org.bimserver.models.ifc2x3.IfcScheduleTimeControl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Assigns Tasks</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssignsTasksImpl#getTimeForTask <em>Time For Task</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssignsTasksImpl extends IfcRelAssignsToControlImpl implements IfcRelAssignsTasks {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssignsTasksImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssignsTasks();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcScheduleTimeControl getTimeForTask() {
		return (IfcScheduleTimeControl)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsTasks_TimeForTask(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeForTask(IfcScheduleTimeControl newTimeForTask) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsTasks_TimeForTask(), newTimeForTask);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTimeForTask() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelAssignsTasks_TimeForTask());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTimeForTask() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelAssignsTasks_TimeForTask());
	}

} //IfcRelAssignsTasksImpl
