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
import org.bimserver.models.ifc2x3.IfcBooleanOperand;
import org.bimserver.models.ifc2x3.IfcBooleanOperator;
import org.bimserver.models.ifc2x3.IfcBooleanResult;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boolean Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBooleanResultImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBooleanResultImpl#getFirstOperand <em>First Operand</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBooleanResultImpl#getSecondOperand <em>Second Operand</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBooleanResultImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBooleanResultImpl extends IfcGeometricRepresentationItemImpl implements IfcBooleanResult
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBooleanResultImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcBooleanResult();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBooleanOperator getOperator()
	{
		return (IfcBooleanOperator)eGet(Ifc2x3Package.eINSTANCE.getIfcBooleanResult_Operator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(IfcBooleanOperator newOperator)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBooleanResult_Operator(), newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBooleanOperand getFirstOperand()
	{
		return (IfcBooleanOperand)eGet(Ifc2x3Package.eINSTANCE.getIfcBooleanResult_FirstOperand(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstOperand(IfcBooleanOperand newFirstOperand)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBooleanResult_FirstOperand(), newFirstOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBooleanOperand getSecondOperand()
	{
		return (IfcBooleanOperand)eGet(Ifc2x3Package.eINSTANCE.getIfcBooleanResult_SecondOperand(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondOperand(IfcBooleanOperand newSecondOperand)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBooleanResult_SecondOperand(), newSecondOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcBooleanResult_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBooleanResult_Dim(), newDim);
	}

} //IfcBooleanResultImpl
