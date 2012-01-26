/**
 * Copyright (C) 2011  BIMserver.org
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
public interface IfcDoorStyle extends IfcTypeProduct {
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
	 * @see #isSetOperationType()
	 * @see #unsetOperationType()
	 * @see #setOperationType(IfcDoorStyleOperationEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle_OperationType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDoorStyleOperationEnum getOperationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDoorStyleOperationEnum
	 * @see #isSetOperationType()
	 * @see #unsetOperationType()
	 * @see #getOperationType()
	 * @generated
	 */
	void setOperationType(IfcDoorStyleOperationEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getOperationType <em>Operation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOperationType()
	 * @see #getOperationType()
	 * @see #setOperationType(IfcDoorStyleOperationEnum)
	 * @generated
	 */
	void unsetOperationType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getOperationType <em>Operation Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Operation Type</em>' attribute is set.
	 * @see #unsetOperationType()
	 * @see #getOperationType()
	 * @see #setOperationType(IfcDoorStyleOperationEnum)
	 * @generated
	 */
	boolean isSetOperationType();

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
	 * @see #isSetConstructionType()
	 * @see #unsetConstructionType()
	 * @see #setConstructionType(IfcDoorStyleConstructionEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle_ConstructionType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDoorStyleConstructionEnum getConstructionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getConstructionType <em>Construction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Construction Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcDoorStyleConstructionEnum
	 * @see #isSetConstructionType()
	 * @see #unsetConstructionType()
	 * @see #getConstructionType()
	 * @generated
	 */
	void setConstructionType(IfcDoorStyleConstructionEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getConstructionType <em>Construction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstructionType()
	 * @see #getConstructionType()
	 * @see #setConstructionType(IfcDoorStyleConstructionEnum)
	 * @generated
	 */
	void unsetConstructionType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getConstructionType <em>Construction Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Construction Type</em>' attribute is set.
	 * @see #unsetConstructionType()
	 * @see #getConstructionType()
	 * @see #setConstructionType(IfcDoorStyleConstructionEnum)
	 * @generated
	 */
	boolean isSetConstructionType();

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
	 * @see #isSetParameterTakesPrecedence()
	 * @see #unsetParameterTakesPrecedence()
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle_ParameterTakesPrecedence()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getParameterTakesPrecedence();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Takes Precedence</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetParameterTakesPrecedence()
	 * @see #unsetParameterTakesPrecedence()
	 * @see #getParameterTakesPrecedence()
	 * @generated
	 */
	void setParameterTakesPrecedence(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameterTakesPrecedence()
	 * @see #getParameterTakesPrecedence()
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @generated
	 */
	void unsetParameterTakesPrecedence();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameter Takes Precedence</em>' attribute is set.
	 * @see #unsetParameterTakesPrecedence()
	 * @see #getParameterTakesPrecedence()
	 * @see #setParameterTakesPrecedence(Tristate)
	 * @generated
	 */
	boolean isSetParameterTakesPrecedence();

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
	 * @see #isSetSizeable()
	 * @see #unsetSizeable()
	 * @see #setSizeable(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDoorStyle_Sizeable()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getSizeable();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getSizeable <em>Sizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sizeable</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetSizeable()
	 * @see #unsetSizeable()
	 * @see #getSizeable()
	 * @generated
	 */
	void setSizeable(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getSizeable <em>Sizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSizeable()
	 * @see #getSizeable()
	 * @see #setSizeable(Tristate)
	 * @generated
	 */
	void unsetSizeable();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDoorStyle#getSizeable <em>Sizeable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sizeable</em>' attribute is set.
	 * @see #unsetSizeable()
	 * @see #getSizeable()
	 * @see #setSizeable(Tristate)
	 * @generated
	 */
	boolean isSetSizeable();

} // IfcDoorStyle
