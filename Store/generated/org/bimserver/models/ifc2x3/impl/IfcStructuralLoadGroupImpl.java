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
import org.bimserver.models.ifc2x3.IfcActionSourceTypeEnum;
import org.bimserver.models.ifc2x3.IfcActionTypeEnum;
import org.bimserver.models.ifc2x3.IfcLoadGroupTypeEnum;
import org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel;
import org.bimserver.models.ifc2x3.IfcStructuralLoadGroup;
import org.bimserver.models.ifc2x3.IfcStructuralResultGroup;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl#getActionType <em>Action Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl#getActionSource <em>Action Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl#getCoefficient <em>Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl#getCoefficientAsString <em>Coefficient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl#getSourceOfResultGroup <em>Source Of Result Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl#getLoadGroupFor <em>Load Group For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadGroupImpl extends IfcGroupImpl implements IfcStructuralLoadGroup
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadGroupImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLoadGroupTypeEnum getPredefinedType()
	{
		return (IfcLoadGroupTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcLoadGroupTypeEnum newPredefinedType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActionTypeEnum getActionType()
	{
		return (IfcActionTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_ActionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionType(IfcActionTypeEnum newActionType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_ActionType(), newActionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActionSourceTypeEnum getActionSource()
	{
		return (IfcActionSourceTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_ActionSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionSource(IfcActionSourceTypeEnum newActionSource)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_ActionSource(), newActionSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCoefficient()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_Coefficient(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoefficient(float newCoefficient)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_Coefficient(), newCoefficient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCoefficient()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_Coefficient());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCoefficient()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_Coefficient());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoefficientAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_CoefficientAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoefficientAsString(String newCoefficientAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_CoefficientAsString(), newCoefficientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCoefficientAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_CoefficientAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCoefficientAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_CoefficientAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_Purpose(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_Purpose(), newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPurpose()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPurpose()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralResultGroup> getSourceOfResultGroup()
	{
		return (EList<IfcStructuralResultGroup>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_SourceOfResultGroup(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralAnalysisModel> getLoadGroupFor()
	{
		return (EList<IfcStructuralAnalysisModel>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadGroup_LoadGroupFor(), true);
	}

} //IfcStructuralLoadGroupImpl
