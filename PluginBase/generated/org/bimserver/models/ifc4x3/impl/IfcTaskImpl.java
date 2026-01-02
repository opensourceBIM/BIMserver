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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcTask;
import org.bimserver.models.ifc4x3.IfcTaskTime;
import org.bimserver.models.ifc4x3.IfcTaskTypeEnum;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskImpl#getWorkMethod <em>Work Method</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskImpl#getIsMilestone <em>Is Milestone</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskImpl#getTaskTime <em>Task Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskImpl#getPredefinedType <em>Predefined Type</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatus() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTask_Status(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(String newStatus) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTask_Status(), newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatus() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTask_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatus() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTask_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWorkMethod() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTask_WorkMethod(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkMethod(String newWorkMethod) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTask_WorkMethod(), newWorkMethod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWorkMethod() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTask_WorkMethod());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWorkMethod() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTask_WorkMethod());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getIsMilestone() {
		return (Tristate) eGet(Ifc4x3Package.eINSTANCE.getIfcTask_IsMilestone(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsMilestone(Tristate newIsMilestone) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTask_IsMilestone(), newIsMilestone);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getPriority() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcTask_Priority(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPriority(long newPriority) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTask_Priority(), newPriority);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPriority() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTask_Priority());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPriority() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTask_Priority());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskTime getTaskTime() {
		return (IfcTaskTime) eGet(Ifc4x3Package.eINSTANCE.getIfcTask_TaskTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTaskTime(IfcTaskTime newTaskTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTask_TaskTime(), newTaskTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTaskTime() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTask_TaskTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTaskTime() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTask_TaskTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskTypeEnum getPredefinedType() {
		return (IfcTaskTypeEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcTask_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcTaskTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTask_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTask_PredefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTask_PredefinedType());
	}

} //IfcTaskImpl
