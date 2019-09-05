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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcTask;
import org.bimserver.models.ifc4.IfcTaskTime;
import org.bimserver.models.ifc4.IfcTaskTypeEnum;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskImpl#getWorkMethod <em>Work Method</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskImpl#getIsMilestone <em>Is Milestone</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskImpl#getTaskTime <em>Task Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTaskImpl extends IfcProcessImpl implements IfcTask {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatus() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(String newStatus) {
		eSet(Ifc4Package.Literals.IFC_TASK__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatus() {
		eUnset(Ifc4Package.Literals.IFC_TASK__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatus() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWorkMethod() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK__WORK_METHOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkMethod(String newWorkMethod) {
		eSet(Ifc4Package.Literals.IFC_TASK__WORK_METHOD, newWorkMethod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWorkMethod() {
		eUnset(Ifc4Package.Literals.IFC_TASK__WORK_METHOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWorkMethod() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK__WORK_METHOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getIsMilestone() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_TASK__IS_MILESTONE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsMilestone(Tristate newIsMilestone) {
		eSet(Ifc4Package.Literals.IFC_TASK__IS_MILESTONE, newIsMilestone);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getPriority() {
		return (Long) eGet(Ifc4Package.Literals.IFC_TASK__PRIORITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPriority(long newPriority) {
		eSet(Ifc4Package.Literals.IFC_TASK__PRIORITY, newPriority);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPriority() {
		eUnset(Ifc4Package.Literals.IFC_TASK__PRIORITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPriority() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK__PRIORITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskTime getTaskTime() {
		return (IfcTaskTime) eGet(Ifc4Package.Literals.IFC_TASK__TASK_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTaskTime(IfcTaskTime newTaskTime) {
		eSet(Ifc4Package.Literals.IFC_TASK__TASK_TIME, newTaskTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTaskTime() {
		eUnset(Ifc4Package.Literals.IFC_TASK__TASK_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTaskTime() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK__TASK_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskTypeEnum getPredefinedType() {
		return (IfcTaskTypeEnum) eGet(Ifc4Package.Literals.IFC_TASK__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcTaskTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_TASK__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_TASK__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK__PREDEFINED_TYPE);
	}

} //IfcTaskImpl
