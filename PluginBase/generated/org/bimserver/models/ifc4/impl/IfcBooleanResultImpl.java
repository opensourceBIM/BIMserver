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
import org.bimserver.models.ifc4.IfcBooleanOperand;
import org.bimserver.models.ifc4.IfcBooleanOperator;
import org.bimserver.models.ifc4.IfcBooleanResult;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boolean Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBooleanResultImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBooleanResultImpl#getFirstOperand <em>First Operand</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBooleanResultImpl#getSecondOperand <em>Second Operand</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBooleanResultImpl#getDim <em>Dim</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBooleanResultImpl extends IfcGeometricRepresentationItemImpl implements IfcBooleanResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBooleanResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_BOOLEAN_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBooleanOperator getOperator() {
		return (IfcBooleanOperator) eGet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__OPERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperator(IfcBooleanOperator newOperator) {
		eSet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__OPERATOR, newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBooleanOperand getFirstOperand() {
		return (IfcBooleanOperand) eGet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__FIRST_OPERAND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstOperand(IfcBooleanOperand newFirstOperand) {
		eSet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__FIRST_OPERAND, newFirstOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBooleanOperand getSecondOperand() {
		return (IfcBooleanOperand) eGet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__SECOND_OPERAND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondOperand(IfcBooleanOperand newSecondOperand) {
		eSet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__SECOND_OPERAND, newSecondOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDim() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDim(long newDim) {
		eSet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__DIM, newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDim() {
		eUnset(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__DIM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDim() {
		return eIsSet(Ifc4Package.Literals.IFC_BOOLEAN_RESULT__DIM);
	}

} //IfcBooleanResultImpl
