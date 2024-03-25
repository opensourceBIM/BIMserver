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
import org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace;
import org.bimserver.models.ifc4x3.IfcPolygonalFaceSet;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Polygonal Face Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolygonalFaceSetImpl#getClosed <em>Closed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolygonalFaceSetImpl#getFaces <em>Faces</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolygonalFaceSetImpl#getPnIndex <em>Pn Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPolygonalFaceSetImpl extends IfcTessellatedFaceSetImpl implements IfcPolygonalFaceSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPolygonalFaceSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getClosed() {
		return (Tristate) eGet(Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET__CLOSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClosed(Tristate newClosed) {
		eSet(Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET__CLOSED, newClosed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetClosed() {
		eUnset(Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET__CLOSED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClosed() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET__CLOSED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcIndexedPolygonalFace> getFaces() {
		return (EList<IfcIndexedPolygonalFace>) eGet(Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET__FACES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getPnIndex() {
		return (EList<Long>) eGet(Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET__PN_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPnIndex() {
		eUnset(Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET__PN_INDEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPnIndex() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POLYGONAL_FACE_SET__PN_INDEX);
	}

} //IfcPolygonalFaceSetImpl
