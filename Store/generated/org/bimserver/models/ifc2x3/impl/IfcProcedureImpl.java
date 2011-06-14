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
import org.bimserver.models.ifc2x3.IfcProcedure;
import org.bimserver.models.ifc2x3.IfcProcedureTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcedureImpl#getProcedureID <em>Procedure ID</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcedureImpl#getProcedureType <em>Procedure Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcedureImpl#getUserDefinedProcedureType <em>User Defined Procedure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcProcedureImpl extends IfcProcessImpl implements IfcProcedure
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProcedureImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcProcedure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcedureID()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProcedure_ProcedureID(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureID(String newProcedureID)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProcedure_ProcedureID(), newProcedureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcedureTypeEnum getProcedureType()
	{
		return (IfcProcedureTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcProcedure_ProcedureType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureType(IfcProcedureTypeEnum newProcedureType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProcedure_ProcedureType(), newProcedureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedProcedureType()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProcedure_UserDefinedProcedureType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedProcedureType(String newUserDefinedProcedureType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProcedure_UserDefinedProcedureType(), newUserDefinedProcedureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedProcedureType()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProcedure_UserDefinedProcedureType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedProcedureType()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProcedure_UserDefinedProcedureType());
	}

} //IfcProcedureImpl
