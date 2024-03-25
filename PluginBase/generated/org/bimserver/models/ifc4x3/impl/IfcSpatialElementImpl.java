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

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc4x3.IfcRelInterferesElements;
import org.bimserver.models.ifc4x3.IfcRelReferencedInSpatialStructure;
import org.bimserver.models.ifc4x3.IfcRelServicesBuildings;
import org.bimserver.models.ifc4x3.IfcSpatialElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Spatial Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSpatialElementImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSpatialElementImpl#getContainsElements <em>Contains Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSpatialElementImpl#getServicedBySystems <em>Serviced By Systems</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSpatialElementImpl#getReferencesElements <em>References Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSpatialElementImpl#getIsInterferedByElements <em>Is Interfered By Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSpatialElementImpl#getInterferesElements <em>Interferes Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSpatialElementImpl extends IfcProductImpl implements IfcSpatialElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSpatialElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongName() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__LONG_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongName(String newLongName) {
		eSet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__LONG_NAME, newLongName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongName() {
		eUnset(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__LONG_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongName() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__LONG_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelContainedInSpatialStructure> getContainsElements() {
		return (EList<IfcRelContainedInSpatialStructure>) eGet(
				Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__CONTAINS_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContainsElements() {
		eUnset(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__CONTAINS_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContainsElements() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__CONTAINS_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelServicesBuildings> getServicedBySystems() {
		return (EList<IfcRelServicesBuildings>) eGet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__SERVICED_BY_SYSTEMS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetServicedBySystems() {
		eUnset(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__SERVICED_BY_SYSTEMS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetServicedBySystems() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__SERVICED_BY_SYSTEMS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelReferencedInSpatialStructure> getReferencesElements() {
		return (EList<IfcRelReferencedInSpatialStructure>) eGet(
				Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__REFERENCES_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencesElements() {
		eUnset(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__REFERENCES_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencesElements() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__REFERENCES_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelInterferesElements> getIsInterferedByElements() {
		return (EList<IfcRelInterferesElements>) eGet(
				Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__IS_INTERFERED_BY_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsInterferedByElements() {
		eUnset(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__IS_INTERFERED_BY_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsInterferedByElements() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__IS_INTERFERED_BY_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelInterferesElements> getInterferesElements() {
		return (EList<IfcRelInterferesElements>) eGet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__INTERFERES_ELEMENTS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterferesElements() {
		eUnset(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__INTERFERES_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterferesElements() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SPATIAL_ELEMENT__INTERFERES_ELEMENTS);
	}

} //IfcSpatialElementImpl
