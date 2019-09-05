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
import org.bimserver.models.ifc4.IfcConnectionPointGeometry;
import org.bimserver.models.ifc4.IfcPointOrVertexPoint;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Point Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionPointGeometryImpl#getPointOnRelatingElement <em>Point On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConnectionPointGeometryImpl#getPointOnRelatedElement <em>Point On Related Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConnectionPointGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionPointGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionPointGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CONNECTION_POINT_GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPointOrVertexPoint getPointOnRelatingElement() {
		return (IfcPointOrVertexPoint) eGet(Ifc4Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPointOnRelatingElement(IfcPointOrVertexPoint newPointOnRelatingElement) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATING_ELEMENT, newPointOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPointOrVertexPoint getPointOnRelatedElement() {
		return (IfcPointOrVertexPoint) eGet(Ifc4Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATED_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPointOnRelatedElement(IfcPointOrVertexPoint newPointOnRelatedElement) {
		eSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATED_ELEMENT, newPointOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPointOnRelatedElement() {
		eUnset(Ifc4Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPointOnRelatedElement() {
		return eIsSet(Ifc4Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATED_ELEMENT);
	}

} //IfcConnectionPointGeometryImpl
