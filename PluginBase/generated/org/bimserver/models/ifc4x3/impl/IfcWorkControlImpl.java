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
import org.bimserver.models.ifc4x3.IfcPerson;
import org.bimserver.models.ifc4x3.IfcWorkControl;

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
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkControlImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkControlImpl#getCreators <em>Creators</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkControlImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkControlImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkControlImpl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkControlImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkControlImpl#getFinishTime <em>Finish Time</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcWorkControl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreationDate() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_CreationDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationDate(String newCreationDate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_CreationDate(), newCreationDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPerson> getCreators() {
		return (EList<IfcPerson>) eGet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Creators(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCreators() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Creators());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCreators() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Creators());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPurpose() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Purpose(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPurpose(String newPurpose) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Purpose(), newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPurpose() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPurpose() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDuration() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Duration(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDuration(String newDuration) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Duration(), newDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDuration() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Duration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDuration() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_Duration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTotalFloat() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_TotalFloat(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalFloat(String newTotalFloat) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_TotalFloat(), newTotalFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalFloat() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWorkControl_TotalFloat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalFloat() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_TotalFloat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_StartTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartTime(String newStartTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_StartTime(), newStartTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFinishTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_FinishTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFinishTime(String newFinishTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_FinishTime(), newFinishTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFinishTime() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWorkControl_FinishTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFinishTime() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWorkControl_FinishTime());
	}

} //IfcWorkControlImpl
