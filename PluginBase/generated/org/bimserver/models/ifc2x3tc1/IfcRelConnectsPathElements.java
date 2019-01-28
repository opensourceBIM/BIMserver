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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Connects Path Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPathElements#getRelatingPriorities <em>Relating Priorities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPathElements#getRelatedPriorities <em>Related Priorities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPathElements#getRelatedConnectionType <em>Related Connection Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPathElements#getRelatingConnectionType <em>Relating Connection Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRelConnectsPathElements()
 * @model
 * @generated
 */
public interface IfcRelConnectsPathElements extends IfcRelConnectsElements {
	/**
	 * Returns the value of the '<em><b>Relating Priorities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Priorities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Priorities</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRelConnectsPathElements_RelatingPriorities()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getRelatingPriorities();

	/**
	 * Returns the value of the '<em><b>Related Priorities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Priorities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Priorities</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRelConnectsPathElements_RelatedPriorities()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getRelatedPriorities();

	/**
	 * Returns the value of the '<em><b>Related Connection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcConnectionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Connection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Connection Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcConnectionTypeEnum
	 * @see #setRelatedConnectionType(IfcConnectionTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRelConnectsPathElements_RelatedConnectionType()
	 * @model
	 * @generated
	 */
	IfcConnectionTypeEnum getRelatedConnectionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPathElements#getRelatedConnectionType <em>Related Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Connection Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcConnectionTypeEnum
	 * @see #getRelatedConnectionType()
	 * @generated
	 */
	void setRelatedConnectionType(IfcConnectionTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Relating Connection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcConnectionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Connection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Connection Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcConnectionTypeEnum
	 * @see #setRelatingConnectionType(IfcConnectionTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRelConnectsPathElements_RelatingConnectionType()
	 * @model
	 * @generated
	 */
	IfcConnectionTypeEnum getRelatingConnectionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRelConnectsPathElements#getRelatingConnectionType <em>Relating Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Connection Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcConnectionTypeEnum
	 * @see #getRelatingConnectionType()
	 * @generated
	 */
	void setRelatingConnectionType(IfcConnectionTypeEnum value);

} // IfcRelConnectsPathElements
