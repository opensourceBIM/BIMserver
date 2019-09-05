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
import org.bimserver.models.ifc4.IfcCartesianPointList3D;
import org.bimserver.models.ifc4.IfcIndexedColourMap;
import org.bimserver.models.ifc4.IfcIndexedTextureMap;
import org.bimserver.models.ifc4.IfcTessellatedFaceSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Tessellated Face Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTessellatedFaceSetImpl#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTessellatedFaceSetImpl#getHasColours <em>Has Colours</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTessellatedFaceSetImpl#getHasTextures <em>Has Textures</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTessellatedFaceSetImpl#getDim <em>Dim</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTessellatedFaceSetImpl extends IfcTessellatedItemImpl implements IfcTessellatedFaceSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTessellatedFaceSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPointList3D getCoordinates() {
		return (IfcCartesianPointList3D) eGet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__COORDINATES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCoordinates(IfcCartesianPointList3D newCoordinates) {
		eSet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__COORDINATES, newCoordinates);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcIndexedColourMap> getHasColours() {
		return (EList<IfcIndexedColourMap>) eGet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__HAS_COLOURS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasColours() {
		eUnset(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__HAS_COLOURS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasColours() {
		return eIsSet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__HAS_COLOURS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcIndexedTextureMap> getHasTextures() {
		return (EList<IfcIndexedTextureMap>) eGet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__HAS_TEXTURES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasTextures() {
		eUnset(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__HAS_TEXTURES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasTextures() {
		return eIsSet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__HAS_TEXTURES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDim() {
		return (Long) eGet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDim(long newDim) {
		eSet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__DIM, newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDim() {
		eUnset(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__DIM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDim() {
		return eIsSet(Ifc4Package.Literals.IFC_TESSELLATED_FACE_SET__DIM);
	}

} //IfcTessellatedFaceSetImpl
