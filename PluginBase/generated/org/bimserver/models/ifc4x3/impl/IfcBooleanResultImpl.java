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
import org.bimserver.models.ifc4x3.IfcBooleanOperand;
import org.bimserver.models.ifc4x3.IfcBooleanOperator;
import org.bimserver.models.ifc4x3.IfcBooleanResult;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boolean Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBooleanResultImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBooleanResultImpl#getFirstOperand <em>First Operand</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBooleanResultImpl#getSecondOperand <em>Second Operand</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBooleanResultImpl#getDim <em>Dim</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcBooleanResult();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBooleanOperator getOperator() {
		return (IfcBooleanOperator) eGet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_Operator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperator(IfcBooleanOperator newOperator) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_Operator(), newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBooleanOperand getFirstOperand() {
		return (IfcBooleanOperand) eGet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_FirstOperand(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstOperand(IfcBooleanOperand newFirstOperand) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_FirstOperand(), newFirstOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBooleanOperand getSecondOperand() {
		return (IfcBooleanOperand) eGet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_SecondOperand(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondOperand(IfcBooleanOperand newSecondOperand) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_SecondOperand(), newSecondOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDim() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDim(long newDim) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_Dim(), newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDim() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_Dim());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDim() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBooleanResult_Dim());
	}

} //IfcBooleanResultImpl
