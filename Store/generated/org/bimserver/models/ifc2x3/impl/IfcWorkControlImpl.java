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
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3.IfcPerson;
import org.bimserver.models.ifc2x3.IfcWorkControl;
import org.bimserver.models.ifc2x3.IfcWorkControlTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Work Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getCreators <em>Creators</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getDurationAsString <em>Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getTotalFloatAsString <em>Total Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getFinishTime <em>Finish Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getWorkControlType <em>Work Control Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl#getUserDefinedControlType <em>User Defined Control Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcWorkControlImpl extends IfcControlImpl implements IfcWorkControl
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWorkControlImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcWorkControl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Identifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Identifier(), newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getCreationDate()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_CreationDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(IfcDateTimeSelect newCreationDate)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_CreationDate(), newCreationDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPerson> getCreators()
	{
		return (EList<IfcPerson>)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Creators(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreators()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Creators());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreators()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Creators());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Purpose(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Purpose(), newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPurpose()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPurpose()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDuration()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Duration(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(float newDuration)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Duration(), newDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDuration()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Duration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDuration()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_Duration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDurationAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_DurationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDurationAsString(String newDurationAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_DurationAsString(), newDurationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDurationAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWorkControl_DurationAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDurationAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_DurationAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTotalFloat()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_TotalFloat(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFloat(float newTotalFloat)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_TotalFloat(), newTotalFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalFloat()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWorkControl_TotalFloat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalFloat()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_TotalFloat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTotalFloatAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_TotalFloatAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFloatAsString(String newTotalFloatAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_TotalFloatAsString(), newTotalFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalFloatAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWorkControl_TotalFloatAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalFloatAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_TotalFloatAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getStartTime()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_StartTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(IfcDateTimeSelect newStartTime)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_StartTime(), newStartTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getFinishTime()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_FinishTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinishTime(IfcDateTimeSelect newFinishTime)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_FinishTime(), newFinishTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFinishTime()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWorkControl_FinishTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFinishTime()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_FinishTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkControlTypeEnum getWorkControlType()
	{
		return (IfcWorkControlTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_WorkControlType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkControlType(IfcWorkControlTypeEnum newWorkControlType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_WorkControlType(), newWorkControlType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedControlType()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_UserDefinedControlType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedControlType(String newUserDefinedControlType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_UserDefinedControlType(), newUserDefinedControlType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedControlType()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWorkControl_UserDefinedControlType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedControlType()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWorkControl_UserDefinedControlType());
	}

} //IfcWorkControlImpl
