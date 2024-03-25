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
 * A representation of the model object '<em><b>Ifc External Spatial Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcExternalSpatialElement#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcExternalSpatialElement#getBoundedBy <em>Bounded By</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcExternalSpatialElement()
 * @model
 * @generated
 */
public interface IfcExternalSpatialElement extends IfcExternalSpatialStructureElement, IfcSpaceBoundarySelect {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcExternalSpatialElementTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcExternalSpatialElementTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcExternalSpatialElementTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcExternalSpatialElement_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcExternalSpatialElementTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcExternalSpatialElement#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcExternalSpatialElementTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcExternalSpatialElementTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcExternalSpatialElement#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcExternalSpatialElementTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcExternalSpatialElement#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcExternalSpatialElementTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>Bounded By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRelSpaceBoundary}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounded By</em>' reference list.
	 * @see #isSetBoundedBy()
	 * @see #unsetBoundedBy()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcExternalSpatialElement_BoundedBy()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelSpaceBoundary> getBoundedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcExternalSpatialElement#getBoundedBy <em>Bounded By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoundedBy()
	 * @see #getBoundedBy()
	 * @generated
	 */
	void unsetBoundedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcExternalSpatialElement#getBoundedBy <em>Bounded By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bounded By</em>' reference list is set.
	 * @see #unsetBoundedBy()
	 * @see #getBoundedBy()
	 * @generated
	 */
	boolean isSetBoundedBy();

} // IfcExternalSpatialElement
