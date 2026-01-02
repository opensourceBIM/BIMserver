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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcObjectPlacement;
import org.bimserver.models.ifc4x3.IfcProduct;
import org.bimserver.models.ifc4x3.IfcProductRepresentation;
import org.bimserver.models.ifc4x3.IfcRelAssignsToProduct;
import org.bimserver.models.ifc4x3.IfcRelPositions;
import org.bimserver.models.ifc4x3.IfcRelReferencedInSpatialStructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Product</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProductImpl#getObjectPlacement <em>Object Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProductImpl#getRepresentation <em>Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProductImpl#getReferencedBy <em>Referenced By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProductImpl#getPositionedRelativeTo <em>Positioned Relative To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProductImpl#getReferencedInStructures <em>Referenced In Structures</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProductImpl#getGeometry <em>Geometry</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcProductImpl extends IfcObjectImpl implements IfcProduct {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProductImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcProduct();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcObjectPlacement getObjectPlacement() {
		return (IfcObjectPlacement) eGet(Ifc4x3Package.eINSTANCE.getIfcProduct_ObjectPlacement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectPlacement(IfcObjectPlacement newObjectPlacement) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcProduct_ObjectPlacement(), newObjectPlacement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetObjectPlacement() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProduct_ObjectPlacement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetObjectPlacement() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProduct_ObjectPlacement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProductRepresentation getRepresentation() {
		return (IfcProductRepresentation) eGet(Ifc4x3Package.eINSTANCE.getIfcProduct_Representation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepresentation(IfcProductRepresentation newRepresentation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcProduct_Representation(), newRepresentation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRepresentation() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProduct_Representation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRepresentation() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProduct_Representation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssignsToProduct> getReferencedBy() {
		return (EList<IfcRelAssignsToProduct>) eGet(Ifc4x3Package.eINSTANCE.getIfcProduct_ReferencedBy(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencedBy() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProduct_ReferencedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencedBy() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProduct_ReferencedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelPositions> getPositionedRelativeTo() {
		return (EList<IfcRelPositions>) eGet(Ifc4x3Package.eINSTANCE.getIfcProduct_PositionedRelativeTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPositionedRelativeTo() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProduct_PositionedRelativeTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPositionedRelativeTo() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProduct_PositionedRelativeTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelReferencedInSpatialStructure> getReferencedInStructures() {
		return (EList<IfcRelReferencedInSpatialStructure>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcProduct_ReferencedInStructures(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencedInStructures() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProduct_ReferencedInStructures());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencedInStructures() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProduct_ReferencedInStructures());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GeometryInfo getGeometry() {
		return (GeometryInfo) eGet(Ifc4x3Package.eINSTANCE.getIfcProduct_Geometry(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeometry(GeometryInfo newGeometry) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcProduct_Geometry(), newGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetGeometry() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProduct_Geometry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGeometry() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProduct_Geometry());
	}

} //IfcProductImpl
