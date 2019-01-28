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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator;
import org.bimserver.models.ifc2x3tc1.IfcMappedItem;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationMap;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mapped Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMappedItemImpl#getMappingSource <em>Mapping Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMappedItemImpl#getMappingTarget <em>Mapping Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMappedItemImpl extends IfcRepresentationItemImpl implements IfcMappedItem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMappedItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_MAPPED_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRepresentationMap getMappingSource() {
		return (IfcRepresentationMap) eGet(Ifc2x3tc1Package.Literals.IFC_MAPPED_ITEM__MAPPING_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingSource(IfcRepresentationMap newMappingSource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MAPPED_ITEM__MAPPING_SOURCE, newMappingSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator getMappingTarget() {
		return (IfcCartesianTransformationOperator) eGet(Ifc2x3tc1Package.Literals.IFC_MAPPED_ITEM__MAPPING_TARGET,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingTarget(IfcCartesianTransformationOperator newMappingTarget) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MAPPED_ITEM__MAPPING_TARGET, newMappingTarget);
	}

} //IfcMappedItemImpl
