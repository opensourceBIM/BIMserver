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
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Boolean Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBooleanResult#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBooleanResult#getFirstOperand <em>First Operand</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBooleanResult#getSecondOperand <em>Second Operand</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBooleanResult#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBooleanResult()
 * @model
 * @generated
 */
public interface IfcBooleanResult extends IfcGeometricRepresentationItem, IfcBooleanOperand, IfcCsgSelect
{
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcBooleanOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcBooleanOperator
	 * @see #setOperator(IfcBooleanOperator)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBooleanResult_Operator()
	 * @model
	 * @generated
	 */
	IfcBooleanOperator getOperator();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBooleanResult#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcBooleanOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(IfcBooleanOperator value);

	/**
	 * Returns the value of the '<em><b>First Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Operand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Operand</em>' reference.
	 * @see #setFirstOperand(IfcBooleanOperand)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBooleanResult_FirstOperand()
	 * @model
	 * @generated
	 */
	IfcBooleanOperand getFirstOperand();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBooleanResult#getFirstOperand <em>First Operand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Operand</em>' reference.
	 * @see #getFirstOperand()
	 * @generated
	 */
	void setFirstOperand(IfcBooleanOperand value);

	/**
	 * Returns the value of the '<em><b>Second Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Operand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Operand</em>' reference.
	 * @see #setSecondOperand(IfcBooleanOperand)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBooleanResult_SecondOperand()
	 * @model
	 * @generated
	 */
	IfcBooleanOperand getSecondOperand();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBooleanResult#getSecondOperand <em>Second Operand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Operand</em>' reference.
	 * @see #getSecondOperand()
	 * @generated
	 */
	void setSecondOperand(IfcBooleanOperand value);

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBooleanResult_Dim()
	 * @model derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBooleanResult#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

} // IfcBooleanResult
