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
 * A representation of the model object '<em><b>Ifc Structural Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcStructuralActivity#getAppliedLoad <em>Applied Load</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcStructuralActivity#getGlobalOrLocal <em>Global Or Local</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcStructuralActivity#getAssignedToStructuralItem <em>Assigned To Structural Item</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralActivity()
 * @model
 * @generated
 */
public interface IfcStructuralActivity extends IfcProduct {
	/**
	 * Returns the value of the '<em><b>Applied Load</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Load</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Load</em>' reference.
	 * @see #setAppliedLoad(IfcStructuralLoad)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralActivity_AppliedLoad()
	 * @model
	 * @generated
	 */
	IfcStructuralLoad getAppliedLoad();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralActivity#getAppliedLoad <em>Applied Load</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Load</em>' reference.
	 * @see #getAppliedLoad()
	 * @generated
	 */
	void setAppliedLoad(IfcStructuralLoad value);

	/**
	 * Returns the value of the '<em><b>Global Or Local</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcGlobalOrLocalEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Or Local</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Or Local</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcGlobalOrLocalEnum
	 * @see #setGlobalOrLocal(IfcGlobalOrLocalEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralActivity_GlobalOrLocal()
	 * @model
	 * @generated
	 */
	IfcGlobalOrLocalEnum getGlobalOrLocal();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralActivity#getGlobalOrLocal <em>Global Or Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Or Local</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcGlobalOrLocalEnum
	 * @see #getGlobalOrLocal()
	 * @generated
	 */
	void setGlobalOrLocal(IfcGlobalOrLocalEnum value);

	/**
	 * Returns the value of the '<em><b>Assigned To Structural Item</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelConnectsStructuralActivity}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelConnectsStructuralActivity#getRelatedStructuralActivity <em>Related Structural Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned To Structural Item</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned To Structural Item</em>' reference list.
	 * @see #isSetAssignedToStructuralItem()
	 * @see #unsetAssignedToStructuralItem()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralActivity_AssignedToStructuralItem()
	 * @see org.bimserver.models.ifc4.IfcRelConnectsStructuralActivity#getRelatedStructuralActivity
	 * @model opposite="RelatedStructuralActivity" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelConnectsStructuralActivity> getAssignedToStructuralItem();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralActivity#getAssignedToStructuralItem <em>Assigned To Structural Item</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAssignedToStructuralItem()
	 * @see #getAssignedToStructuralItem()
	 * @generated
	 */
	void unsetAssignedToStructuralItem();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralActivity#getAssignedToStructuralItem <em>Assigned To Structural Item</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Assigned To Structural Item</em>' reference list is set.
	 * @see #unsetAssignedToStructuralItem()
	 * @see #getAssignedToStructuralItem()
	 * @generated
	 */
	boolean isSetAssignedToStructuralItem();

} // IfcStructuralActivity
