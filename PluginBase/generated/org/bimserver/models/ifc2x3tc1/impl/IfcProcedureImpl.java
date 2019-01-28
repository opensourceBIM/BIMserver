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
import org.bimserver.models.ifc2x3tc1.IfcProcedure;
import org.bimserver.models.ifc2x3tc1.IfcProcedureTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProcedureImpl#getProcedureID <em>Procedure ID</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProcedureImpl#getProcedureType <em>Procedure Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProcedureImpl#getUserDefinedProcedureType <em>User Defined Procedure Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcProcedureImpl extends IfcProcessImpl implements IfcProcedure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProcedureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_PROCEDURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcedureID() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PROCEDURE__PROCEDURE_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureID(String newProcedureID) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PROCEDURE__PROCEDURE_ID, newProcedureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcedureTypeEnum getProcedureType() {
		return (IfcProcedureTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_PROCEDURE__PROCEDURE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureType(IfcProcedureTypeEnum newProcedureType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PROCEDURE__PROCEDURE_TYPE, newProcedureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedProcedureType() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PROCEDURE__USER_DEFINED_PROCEDURE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedProcedureType(String newUserDefinedProcedureType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PROCEDURE__USER_DEFINED_PROCEDURE_TYPE, newUserDefinedProcedureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedProcedureType() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PROCEDURE__USER_DEFINED_PROCEDURE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedProcedureType() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PROCEDURE__USER_DEFINED_PROCEDURE_TYPE);
	}

} //IfcProcedureImpl
