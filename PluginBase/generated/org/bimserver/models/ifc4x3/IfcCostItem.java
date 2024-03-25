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
package org.bimserver.models.ifc4x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Cost Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCostItem#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCostItem#getCostValues <em>Cost Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCostItem#getCostQuantities <em>Cost Quantities</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCostItem()
 * @model
 * @generated
 */
public interface IfcCostItem extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcCostItemTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcCostItemTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcCostItemTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCostItem_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCostItemTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCostItem#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcCostItemTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcCostItemTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcCostItem#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcCostItemTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcCostItem#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcCostItemTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>Cost Values</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcCostValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cost Values</em>' reference list.
	 * @see #isSetCostValues()
	 * @see #unsetCostValues()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCostItem_CostValues()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcCostValue> getCostValues();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcCostItem#getCostValues <em>Cost Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCostValues()
	 * @see #getCostValues()
	 * @generated
	 */
	void unsetCostValues();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcCostItem#getCostValues <em>Cost Values</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cost Values</em>' reference list is set.
	 * @see #unsetCostValues()
	 * @see #getCostValues()
	 * @generated
	 */
	boolean isSetCostValues();

	/**
	 * Returns the value of the '<em><b>Cost Quantities</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcPhysicalQuantity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cost Quantities</em>' reference list.
	 * @see #isSetCostQuantities()
	 * @see #unsetCostQuantities()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCostItem_CostQuantities()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcPhysicalQuantity> getCostQuantities();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcCostItem#getCostQuantities <em>Cost Quantities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCostQuantities()
	 * @see #getCostQuantities()
	 * @generated
	 */
	void unsetCostQuantities();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcCostItem#getCostQuantities <em>Cost Quantities</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cost Quantities</em>' reference list is set.
	 * @see #unsetCostQuantities()
	 * @see #getCostQuantities()
	 * @generated
	 */
	boolean isSetCostQuantities();

} // IfcCostItem
