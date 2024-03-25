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
import org.bimserver.models.ifc4x3.IfcConnectionVolumeGeometry;
import org.bimserver.models.ifc4x3.IfcSolidOrShell;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Volume Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcConnectionVolumeGeometryImpl#getVolumeOnRelatingElement <em>Volume On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcConnectionVolumeGeometryImpl#getVolumeOnRelatedElement <em>Volume On Related Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConnectionVolumeGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionVolumeGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionVolumeGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_CONNECTION_VOLUME_GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSolidOrShell getVolumeOnRelatingElement() {
		return (IfcSolidOrShell) eGet(Ifc4x3Package.Literals.IFC_CONNECTION_VOLUME_GEOMETRY__VOLUME_ON_RELATING_ELEMENT,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVolumeOnRelatingElement(IfcSolidOrShell newVolumeOnRelatingElement) {
		eSet(Ifc4x3Package.Literals.IFC_CONNECTION_VOLUME_GEOMETRY__VOLUME_ON_RELATING_ELEMENT,
				newVolumeOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSolidOrShell getVolumeOnRelatedElement() {
		return (IfcSolidOrShell) eGet(Ifc4x3Package.Literals.IFC_CONNECTION_VOLUME_GEOMETRY__VOLUME_ON_RELATED_ELEMENT,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVolumeOnRelatedElement(IfcSolidOrShell newVolumeOnRelatedElement) {
		eSet(Ifc4x3Package.Literals.IFC_CONNECTION_VOLUME_GEOMETRY__VOLUME_ON_RELATED_ELEMENT,
				newVolumeOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVolumeOnRelatedElement() {
		eUnset(Ifc4x3Package.Literals.IFC_CONNECTION_VOLUME_GEOMETRY__VOLUME_ON_RELATED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVolumeOnRelatedElement() {
		return eIsSet(Ifc4x3Package.Literals.IFC_CONNECTION_VOLUME_GEOMETRY__VOLUME_ON_RELATED_ELEMENT);
	}

} //IfcConnectionVolumeGeometryImpl
