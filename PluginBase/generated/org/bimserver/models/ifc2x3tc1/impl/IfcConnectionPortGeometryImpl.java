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
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
import org.bimserver.models.ifc2x3tc1.IfcConnectionPortGeometry;
import org.bimserver.models.ifc2x3tc1.IfcProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Port Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPortGeometryImpl#getLocationAtRelatingElement <em>Location At Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPortGeometryImpl#getLocationAtRelatedElement <em>Location At Related Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPortGeometryImpl#getProfileOfPort <em>Profile Of Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConnectionPortGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionPortGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionPortGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getLocationAtRelatingElement() {
		return (IfcAxis2Placement) eGet(
				Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY__LOCATION_AT_RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationAtRelatingElement(IfcAxis2Placement newLocationAtRelatingElement) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY__LOCATION_AT_RELATING_ELEMENT,
				newLocationAtRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getLocationAtRelatedElement() {
		return (IfcAxis2Placement) eGet(
				Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY__LOCATION_AT_RELATED_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationAtRelatedElement(IfcAxis2Placement newLocationAtRelatedElement) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY__LOCATION_AT_RELATED_ELEMENT,
				newLocationAtRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLocationAtRelatedElement() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY__LOCATION_AT_RELATED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLocationAtRelatedElement() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY__LOCATION_AT_RELATED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getProfileOfPort() {
		return (IfcProfileDef) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY__PROFILE_OF_PORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileOfPort(IfcProfileDef newProfileOfPort) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_PORT_GEOMETRY__PROFILE_OF_PORT, newProfileOfPort);
	}

} //IfcConnectionPortGeometryImpl
