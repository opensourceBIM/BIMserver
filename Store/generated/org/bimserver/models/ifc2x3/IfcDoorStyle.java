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
 * A representation of the model object '<em><b>Ifc Door Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getConstructionType <em>Construction Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getSizeable <em>Sizeable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle()
 * @model
 * @generated
 */
public interface IfcDoorStyle extends IfcTypeProduct
{
	/**
	 * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcDoorStyleOperationEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDoorStyleOperationEnum
	 * @see #setOperationType(IfcDoorStyleOperationEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle_OperationType()
	 * @model
	 * @generated
	 */
	IfcDoorStyleOperationEnum getOperationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDoorStyleOperationEnum
	 * @see #getOperationType()
	 * @generated
	 */
	void setOperationType(IfcDoorStyleOperationEnum value);

	/**
	 * Returns the value of the '<em><b>Construction Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcDoorStyleConstructionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Construction Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Construction Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDoorStyleConstructionEnum
	 * @see #setConstructionType(IfcDoorStyleConstructionEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle_ConstructionType()
	 * @model
	 * @generated
	 */
	IfcDoorStyleConstructionEnum getConstructionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getConstructionType <em>Construction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Construction Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDoorStyleConstructionEnum
	 * @see #getConstructionType()
	 * @generated
	 */
	void setConstructionType(IfcDoorStyleConstructionEnum value);

	/**
	 * Returns the value of the '<em><b>Parameter Takes Precedence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Takes Precedence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Takes Precedence</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle_ParameterTakesPrecedence()
	 * @model
	 * @generated
	 */
	Tristate getParameterTakesPrecedence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Takes Precedence</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getParameterTakesPrecedence()
	 * @generated
	 */
	void setParameterTakesPrecedence(Tristate value);

	/**
	 * Returns the value of the '<em><b>Sizeable</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sizeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sizeable</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setSizeable(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle_Sizeable()
	 * @model
	 * @generated
	 */
	Tristate getSizeable();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getSizeable <em>Sizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sizeable</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getSizeable()
	 * @generated
	 */
	void setSizeable(Tristate value);

} // IfcDoorStyle
