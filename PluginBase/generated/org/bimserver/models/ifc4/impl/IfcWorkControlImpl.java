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
import org.bimserver.models.ifc4.IfcPerson;
import org.bimserver.models.ifc4.IfcWorkControl;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWorkControlImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWorkControlImpl#getCreators <em>Creators</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWorkControlImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWorkControlImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWorkControlImpl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWorkControlImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWorkControlImpl#getFinishTime <em>Finish Time</em>}</li>
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
		return Ifc4Package.Literals.IFC_WORK_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreationDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_WORK_CONTROL__CREATION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationDate(String newCreationDate) {
		eSet(Ifc4Package.Literals.IFC_WORK_CONTROL__CREATION_DATE, newCreationDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPerson> getCreators() {
		return (EList<IfcPerson>) eGet(Ifc4Package.Literals.IFC_WORK_CONTROL__CREATORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCreators() {
		eUnset(Ifc4Package.Literals.IFC_WORK_CONTROL__CREATORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCreators() {
		return eIsSet(Ifc4Package.Literals.IFC_WORK_CONTROL__CREATORS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPurpose() {
		return (String) eGet(Ifc4Package.Literals.IFC_WORK_CONTROL__PURPOSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPurpose(String newPurpose) {
		eSet(Ifc4Package.Literals.IFC_WORK_CONTROL__PURPOSE, newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPurpose() {
		eUnset(Ifc4Package.Literals.IFC_WORK_CONTROL__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPurpose() {
		return eIsSet(Ifc4Package.Literals.IFC_WORK_CONTROL__PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDuration() {
		return (String) eGet(Ifc4Package.Literals.IFC_WORK_CONTROL__DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDuration(String newDuration) {
		eSet(Ifc4Package.Literals.IFC_WORK_CONTROL__DURATION, newDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDuration() {
		eUnset(Ifc4Package.Literals.IFC_WORK_CONTROL__DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDuration() {
		return eIsSet(Ifc4Package.Literals.IFC_WORK_CONTROL__DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTotalFloat() {
		return (String) eGet(Ifc4Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalFloat(String newTotalFloat) {
		eSet(Ifc4Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT, newTotalFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalFloat() {
		eUnset(Ifc4Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalFloat() {
		return eIsSet(Ifc4Package.Literals.IFC_WORK_CONTROL__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartTime() {
		return (String) eGet(Ifc4Package.Literals.IFC_WORK_CONTROL__START_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartTime(String newStartTime) {
		eSet(Ifc4Package.Literals.IFC_WORK_CONTROL__START_TIME, newStartTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFinishTime() {
		return (String) eGet(Ifc4Package.Literals.IFC_WORK_CONTROL__FINISH_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFinishTime(String newFinishTime) {
		eSet(Ifc4Package.Literals.IFC_WORK_CONTROL__FINISH_TIME, newFinishTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFinishTime() {
		eUnset(Ifc4Package.Literals.IFC_WORK_CONTROL__FINISH_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFinishTime() {
		return eIsSet(Ifc4Package.Literals.IFC_WORK_CONTROL__FINISH_TIME);
	}

} //IfcWorkControlImpl
