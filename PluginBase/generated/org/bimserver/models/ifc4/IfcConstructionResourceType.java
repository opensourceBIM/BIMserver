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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Construction Resource Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstructionResourceType#getBaseCosts <em>Base Costs</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcConstructionResourceType#getBaseQuantity <em>Base Quantity</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstructionResourceType()
 * @model
 * @generated
 */
public interface IfcConstructionResourceType extends IfcTypeResource {
	/**
	 * Returns the value of the '<em><b>Base Costs</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcAppliedValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Costs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Costs</em>' reference list.
	 * @see #isSetBaseCosts()
	 * @see #unsetBaseCosts()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstructionResourceType_BaseCosts()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcAppliedValue> getBaseCosts();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstructionResourceType#getBaseCosts <em>Base Costs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBaseCosts()
	 * @see #getBaseCosts()
	 * @generated
	 */
	void unsetBaseCosts();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstructionResourceType#getBaseCosts <em>Base Costs</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Base Costs</em>' reference list is set.
	 * @see #unsetBaseCosts()
	 * @see #getBaseCosts()
	 * @generated
	 */
	boolean isSetBaseCosts();

	/**
	 * Returns the value of the '<em><b>Base Quantity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Quantity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Quantity</em>' reference.
	 * @see #isSetBaseQuantity()
	 * @see #unsetBaseQuantity()
	 * @see #setBaseQuantity(IfcPhysicalQuantity)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConstructionResourceType_BaseQuantity()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPhysicalQuantity getBaseQuantity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConstructionResourceType#getBaseQuantity <em>Base Quantity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Quantity</em>' reference.
	 * @see #isSetBaseQuantity()
	 * @see #unsetBaseQuantity()
	 * @see #getBaseQuantity()
	 * @generated
	 */
	void setBaseQuantity(IfcPhysicalQuantity value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcConstructionResourceType#getBaseQuantity <em>Base Quantity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBaseQuantity()
	 * @see #getBaseQuantity()
	 * @see #setBaseQuantity(IfcPhysicalQuantity)
	 * @generated
	 */
	void unsetBaseQuantity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcConstructionResourceType#getBaseQuantity <em>Base Quantity</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Base Quantity</em>' reference is set.
	 * @see #unsetBaseQuantity()
	 * @see #getBaseQuantity()
	 * @see #setBaseQuantity(IfcPhysicalQuantity)
	 * @generated
	 */
	boolean isSetBaseQuantity();

} // IfcConstructionResourceType
