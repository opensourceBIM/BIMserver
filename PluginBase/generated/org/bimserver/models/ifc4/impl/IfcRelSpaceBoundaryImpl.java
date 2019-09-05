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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcConnectionGeometry;
import org.bimserver.models.ifc4.IfcElement;
import org.bimserver.models.ifc4.IfcInternalOrExternalEnum;
import org.bimserver.models.ifc4.IfcPhysicalOrVirtualEnum;
import org.bimserver.models.ifc4.IfcRelSpaceBoundary;
import org.bimserver.models.ifc4.IfcSpaceBoundarySelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Space Boundary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundaryImpl#getRelatingSpace <em>Relating Space</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundaryImpl#getRelatedBuildingElement <em>Related Building Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundaryImpl#getConnectionGeometry <em>Connection Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundaryImpl#getPhysicalOrVirtualBoundary <em>Physical Or Virtual Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundaryImpl#getInternalOrExternalBoundary <em>Internal Or External Boundary</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelSpaceBoundaryImpl extends IfcRelConnectsImpl implements IfcRelSpaceBoundary {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelSpaceBoundaryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpaceBoundarySelect getRelatingSpace() {
		return (IfcSpaceBoundarySelect) eGet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATING_SPACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingSpace(IfcSpaceBoundarySelect newRelatingSpace) {
		eSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATING_SPACE, newRelatingSpace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElement getRelatedBuildingElement() {
		return (IfcElement) eGet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATED_BUILDING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatedBuildingElement(IfcElement newRelatedBuildingElement) {
		eSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__RELATED_BUILDING_ELEMENT, newRelatedBuildingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionGeometry getConnectionGeometry() {
		return (IfcConnectionGeometry) eGet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__CONNECTION_GEOMETRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectionGeometry(IfcConnectionGeometry newConnectionGeometry) {
		eSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__CONNECTION_GEOMETRY, newConnectionGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConnectionGeometry() {
		eUnset(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__CONNECTION_GEOMETRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConnectionGeometry() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__CONNECTION_GEOMETRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPhysicalOrVirtualEnum getPhysicalOrVirtualBoundary() {
		return (IfcPhysicalOrVirtualEnum) eGet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__PHYSICAL_OR_VIRTUAL_BOUNDARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPhysicalOrVirtualBoundary(IfcPhysicalOrVirtualEnum newPhysicalOrVirtualBoundary) {
		eSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__PHYSICAL_OR_VIRTUAL_BOUNDARY, newPhysicalOrVirtualBoundary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInternalOrExternalEnum getInternalOrExternalBoundary() {
		return (IfcInternalOrExternalEnum) eGet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__INTERNAL_OR_EXTERNAL_BOUNDARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInternalOrExternalBoundary(IfcInternalOrExternalEnum newInternalOrExternalBoundary) {
		eSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY__INTERNAL_OR_EXTERNAL_BOUNDARY, newInternalOrExternalBoundary);
	}

} //IfcRelSpaceBoundaryImpl
