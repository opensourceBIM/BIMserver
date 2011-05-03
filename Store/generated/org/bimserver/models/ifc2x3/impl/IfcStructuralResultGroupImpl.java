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
import org.bimserver.models.ifc2x3.IfcAnalysisTheoryTypeEnum;
import org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel;
import org.bimserver.models.ifc2x3.IfcStructuralLoadGroup;
import org.bimserver.models.ifc2x3.IfcStructuralResultGroup;
import org.bimserver.models.ifc2x3.Tristate;

import org.bimserver.models.ifc2x3.impl.IfcGroupImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Result Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl#getTheoryType <em>Theory Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl#getResultForLoadGroup <em>Result For Load Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl#getIsLinear <em>Is Linear</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl#getResultGroupFor <em>Result Group For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralResultGroupImpl extends IfcGroupImpl implements IfcStructuralResultGroup
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralResultGroupImpl()
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
		return Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnalysisTheoryTypeEnum getTheoryType()
	{
		return (IfcAnalysisTheoryTypeEnum)eGet(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__THEORY_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheoryType(IfcAnalysisTheoryTypeEnum newTheoryType)
	{
		eSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__THEORY_TYPE, newTheoryType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadGroup getResultForLoadGroup()
	{
		return (IfcStructuralLoadGroup)eGet(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_FOR_LOAD_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultForLoadGroup(IfcStructuralLoadGroup newResultForLoadGroup)
	{
		eSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_FOR_LOAD_GROUP, newResultForLoadGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResultForLoadGroup()
	{
		eUnset(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_FOR_LOAD_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResultForLoadGroup()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_FOR_LOAD_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsLinear()
	{
		return (Tristate)eGet(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__IS_LINEAR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLinear(Tristate newIsLinear)
	{
		eSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__IS_LINEAR, newIsLinear);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralAnalysisModel> getResultGroupFor()
	{
		return (EList<IfcStructuralAnalysisModel>)eGet(Ifc2x3Package.Literals.IFC_STRUCTURAL_RESULT_GROUP__RESULT_GROUP_FOR, true);
	}

} //IfcStructuralResultGroupImpl
