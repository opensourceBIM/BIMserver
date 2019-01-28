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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcWorkControl;
import org.bimserver.models.ifc2x3tc1.IfcWorkControlTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Work Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getCreators <em>Creators</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getDurationAsString <em>Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getTotalFloatAsString <em>Total Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getFinishTime <em>Finish Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getWorkControlType <em>Work Control Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWorkControlImpl#getUserDefinedControlType <em>User Defined Control Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcWorkControlImpl extends IfcControlImpl implements IfcWorkControl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWorkControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getCreationDate() {
		return (IfcDateTimeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__CREATION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(IfcDateTimeSelect newCreationDate) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__CREATION_DATE, newCreationDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPerson> getCreators() {
		return (EList<IfcPerson>) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__CREATORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreators() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__CREATORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreators() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__CREATORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__PURPOSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__PURPOSE, newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPurpose() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPurpose() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDuration() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(double newDuration) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__DURATION, newDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDuration() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDuration() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDurationAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__DURATION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDurationAsString(String newDurationAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__DURATION_AS_STRING, newDurationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDurationAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDurationAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalFloat() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFloat(double newTotalFloat) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT, newTotalFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalFloat() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalFloat() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTotalFloatAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFloatAsString(String newTotalFloatAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT_AS_STRING, newTotalFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalFloatAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalFloatAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getStartTime() {
		return (IfcDateTimeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__START_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(IfcDateTimeSelect newStartTime) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__START_TIME, newStartTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getFinishTime() {
		return (IfcDateTimeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__FINISH_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinishTime(IfcDateTimeSelect newFinishTime) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__FINISH_TIME, newFinishTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFinishTime() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__FINISH_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFinishTime() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__FINISH_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkControlTypeEnum getWorkControlType() {
		return (IfcWorkControlTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__WORK_CONTROL_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkControlType(IfcWorkControlTypeEnum newWorkControlType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__WORK_CONTROL_TYPE, newWorkControlType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWorkControlType() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__WORK_CONTROL_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWorkControlType() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__WORK_CONTROL_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedControlType() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__USER_DEFINED_CONTROL_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedControlType(String newUserDefinedControlType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__USER_DEFINED_CONTROL_TYPE, newUserDefinedControlType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedControlType() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__USER_DEFINED_CONTROL_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedControlType() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WORK_CONTROL__USER_DEFINED_CONTROL_TYPE);
	}

} //IfcWorkControlImpl
