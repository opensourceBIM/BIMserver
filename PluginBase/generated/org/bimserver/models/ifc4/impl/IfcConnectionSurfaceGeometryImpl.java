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
import org.bimserver.models.ifc4.IfcConnectionSurfaceGeometry;
import org.bimserver.models.ifc4.IfcSurfaceOrFaceSurface;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Surface Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionSurfaceGeometryImpl#getSurfaceOnRelatingElement <em>Surface On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionSurfaceGeometryImpl#getSurfaceOnRelatedElement <em>Surface On Related Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConnectionSurfaceGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionSurfaceGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionSurfaceGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceOrFaceSurface getSurfaceOnRelatingElement() {
		return (IfcSurfaceOrFaceSurface) eGet(Ifc4Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSurfaceOnRelatingElement(IfcSurfaceOrFaceSurface newSurfaceOnRelatingElement) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATING_ELEMENT, newSurfaceOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceOrFaceSurface getSurfaceOnRelatedElement() {
		return (IfcSurfaceOrFaceSurface) eGet(Ifc4Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATED_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSurfaceOnRelatedElement(IfcSurfaceOrFaceSurface newSurfaceOnRelatedElement) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATED_ELEMENT, newSurfaceOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSurfaceOnRelatedElement() {
		eUnset(Ifc4Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSurfaceOnRelatedElement() {
		return eIsSet(Ifc4Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATED_ELEMENT);
	}

} //IfcConnectionSurfaceGeometryImpl
