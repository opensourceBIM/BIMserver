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

public interface IfcMappedItem extends IfcRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Mapping Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRepresentationMap#getMapUsage <em>Map Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Source</em>' reference.
	 * @see #setMappingSource(IfcRepresentationMap)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMappedItem_MappingSource()
	 * @see org.bimserver.models.ifc4.IfcRepresentationMap#getMapUsage
	 * @model opposite="MapUsage"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcRepresentationMap getMappingSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMappedItem#getMappingSource <em>Mapping Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Source</em>' reference.
	 * @see #getMappingSource()
	 * @generated
	 */
	void setMappingSource(IfcRepresentationMap value);

	/**
	 * Returns the value of the '<em><b>Mapping Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Target</em>' reference.
	 * @see #setMappingTarget(IfcCartesianTransformationOperator)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMappedItem_MappingTarget()
	 * @model
	 * @generated
	 */
	IfcCartesianTransformationOperator getMappingTarget();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMappedItem#getMappingTarget <em>Mapping Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Target</em>' reference.
	 * @see #getMappingTarget()
	 * @generated
	 */
	void setMappingTarget(IfcCartesianTransformationOperator value);

} // IfcMappedItem
