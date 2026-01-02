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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcPresentationLayerAssignment;
import org.bimserver.models.ifc4x3.IfcProductRepresentation;
import org.bimserver.models.ifc4x3.IfcRepresentation;
import org.bimserver.models.ifc4x3.IfcRepresentationContext;
import org.bimserver.models.ifc4x3.IfcRepresentationItem;
import org.bimserver.models.ifc4x3.IfcRepresentationMap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationImpl#getContextOfItems <em>Context Of Items</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationImpl#getRepresentationIdentifier <em>Representation Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationImpl#getRepresentationType <em>Representation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationImpl#getRepresentationMap <em>Representation Map</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationImpl#getLayerAssignments <em>Layer Assignments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationImpl#getOfProductRepresentation <em>Of Product Representation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRepresentationImpl extends IdEObjectImpl implements IfcRepresentation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRepresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcRepresentation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRepresentationContext getContextOfItems() {
		return (IfcRepresentationContext) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_ContextOfItems(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContextOfItems(IfcRepresentationContext newContextOfItems) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_ContextOfItems(), newContextOfItems);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRepresentationIdentifier() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationIdentifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepresentationIdentifier(String newRepresentationIdentifier) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationIdentifier(), newRepresentationIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRepresentationIdentifier() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationIdentifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRepresentationIdentifier() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationIdentifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRepresentationType() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepresentationType(String newRepresentationType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationType(), newRepresentationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRepresentationType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRepresentationType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRepresentationItem> getItems() {
		return (EList<IfcRepresentationItem>) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_Items(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRepresentationMap> getRepresentationMap() {
		return (EList<IfcRepresentationMap>) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationMap(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRepresentationMap() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationMap());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRepresentationMap() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_RepresentationMap());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPresentationLayerAssignment> getLayerAssignments() {
		return (EList<IfcPresentationLayerAssignment>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcRepresentation_LayerAssignments(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLayerAssignments() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRepresentation_LayerAssignments());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLayerAssignments() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_LayerAssignments());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcProductRepresentation> getOfProductRepresentation() {
		return (EList<IfcProductRepresentation>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcRepresentation_OfProductRepresentation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOfProductRepresentation() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRepresentation_OfProductRepresentation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOfProductRepresentation() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRepresentation_OfProductRepresentation());
	}

} //IfcRepresentationImpl
