/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcActorSelect;
import org.bimserver.models.ifc2x3.IfcCostSchedule;
import org.bimserver.models.ifc2x3.IfcCostScheduleTypeEnum;
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cost Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl#getSubmittedBy <em>Submitted By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl#getPreparedBy <em>Prepared By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl#getSubmittedOn <em>Submitted On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl#getTargetUsers <em>Target Users</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl#getUpdateDate <em>Update Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCostScheduleImpl extends IfcControlImpl implements IfcCostSchedule
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCostScheduleImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcCostSchedule();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getSubmittedBy()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_SubmittedBy(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubmittedBy(IfcActorSelect newSubmittedBy)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_SubmittedBy(), newSubmittedBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSubmittedBy()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_SubmittedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubmittedBy()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_SubmittedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getPreparedBy()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_PreparedBy(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreparedBy(IfcActorSelect newPreparedBy)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_PreparedBy(), newPreparedBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPreparedBy()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_PreparedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPreparedBy()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_PreparedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getSubmittedOn()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_SubmittedOn(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubmittedOn(IfcDateTimeSelect newSubmittedOn)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_SubmittedOn(), newSubmittedOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSubmittedOn()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_SubmittedOn());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubmittedOn()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_SubmittedOn());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_Status(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_Status(), newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStatus()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStatus()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorSelect> getTargetUsers()
	{
		return (EList<IfcActorSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_TargetUsers(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetUsers()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_TargetUsers());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetUsers()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_TargetUsers());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getUpdateDate()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_UpdateDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateDate(IfcDateTimeSelect newUpdateDate)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_UpdateDate(), newUpdateDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpdateDate()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_UpdateDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpdateDate()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_UpdateDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getID()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_ID(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_ID(), newID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostScheduleTypeEnum getPredefinedType()
	{
		return (IfcCostScheduleTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcCostScheduleTypeEnum newPredefinedType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCostSchedule_PredefinedType(), newPredefinedType);
	}

} //IfcCostScheduleImpl
