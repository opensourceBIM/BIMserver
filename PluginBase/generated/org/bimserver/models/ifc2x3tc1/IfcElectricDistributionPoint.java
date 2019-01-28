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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcElectricDistributionPoint extends IfcFlowController {
	/**
	 * Returns the value of the '<em><b>Distribution Point Function</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPointFunctionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distribution Point Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distribution Point Function</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPointFunctionEnum
	 * @see #setDistributionPointFunction(IfcElectricDistributionPointFunctionEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcElectricDistributionPoint_DistributionPointFunction()
	 * @model
	 * @generated
	 */
	IfcElectricDistributionPointFunctionEnum getDistributionPointFunction();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPoint#getDistributionPointFunction <em>Distribution Point Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distribution Point Function</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPointFunctionEnum
	 * @see #getDistributionPointFunction()
	 * @generated
	 */
	void setDistributionPointFunction(IfcElectricDistributionPointFunctionEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Function</em>' attribute.
	 * @see #isSetUserDefinedFunction()
	 * @see #unsetUserDefinedFunction()
	 * @see #setUserDefinedFunction(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcElectricDistributionPoint_UserDefinedFunction()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedFunction();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPoint#getUserDefinedFunction <em>User Defined Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Function</em>' attribute.
	 * @see #isSetUserDefinedFunction()
	 * @see #unsetUserDefinedFunction()
	 * @see #getUserDefinedFunction()
	 * @generated
	 */
	void setUserDefinedFunction(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPoint#getUserDefinedFunction <em>User Defined Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedFunction()
	 * @see #getUserDefinedFunction()
	 * @see #setUserDefinedFunction(String)
	 * @generated
	 */
	void unsetUserDefinedFunction();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcElectricDistributionPoint#getUserDefinedFunction <em>User Defined Function</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Function</em>' attribute is set.
	 * @see #unsetUserDefinedFunction()
	 * @see #getUserDefinedFunction()
	 * @see #setUserDefinedFunction(String)
	 * @generated
	 */
	boolean isSetUserDefinedFunction();

} // IfcElectricDistributionPoint
