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
import org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc4.IfcRelReferencedInSpatialStructure;
import org.bimserver.models.ifc4.IfcRelServicesBuildings;
import org.bimserver.models.ifc4.IfcSpatialElement;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpatialElementImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpatialElementImpl#getContainsElements <em>Contains Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpatialElementImpl#getServicedBySystems <em>Serviced By Systems</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpatialElementImpl#getReferencesElements <em>References Elements</em>}</li>
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
		return Ifc4Package.Literals.IFC_SPATIAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongName() {
		return (String) eGet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__LONG_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongName(String newLongName) {
		eSet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__LONG_NAME, newLongName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongName() {
		eUnset(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__LONG_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongName() {
		return eIsSet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__LONG_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelContainedInSpatialStructure> getContainsElements() {
		return (EList<IfcRelContainedInSpatialStructure>) eGet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__CONTAINS_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContainsElements() {
		eUnset(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__CONTAINS_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContainsElements() {
		return eIsSet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__CONTAINS_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelServicesBuildings> getServicedBySystems() {
		return (EList<IfcRelServicesBuildings>) eGet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__SERVICED_BY_SYSTEMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetServicedBySystems() {
		eUnset(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__SERVICED_BY_SYSTEMS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetServicedBySystems() {
		return eIsSet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__SERVICED_BY_SYSTEMS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelReferencedInSpatialStructure> getReferencesElements() {
		return (EList<IfcRelReferencedInSpatialStructure>) eGet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__REFERENCES_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencesElements() {
		eUnset(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__REFERENCES_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencesElements() {
		return eIsSet(Ifc4Package.Literals.IFC_SPATIAL_ELEMENT__REFERENCES_ELEMENTS);
	}

} //IfcSpatialElementImpl
