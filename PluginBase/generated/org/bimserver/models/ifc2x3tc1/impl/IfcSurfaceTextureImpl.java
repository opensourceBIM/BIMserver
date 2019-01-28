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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator2D;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceTexture;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceTextureEnum;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Texture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceTextureImpl#getRepeatS <em>Repeat S</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceTextureImpl#getRepeatT <em>Repeat T</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceTextureImpl#getTextureType <em>Texture Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceTextureImpl#getTextureTransform <em>Texture Transform</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSurfaceTextureImpl extends IdEObjectImpl implements IfcSurfaceTexture {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceTextureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE;
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
	public Tristate getRepeatS() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__REPEAT_S, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatS(Tristate newRepeatS) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__REPEAT_S, newRepeatS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getRepeatT() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__REPEAT_T, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatT(Tristate newRepeatT) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__REPEAT_T, newRepeatT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceTextureEnum getTextureType() {
		return (IfcSurfaceTextureEnum) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextureType(IfcSurfaceTextureEnum newTextureType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TYPE, newTextureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator2D getTextureTransform() {
		return (IfcCartesianTransformationOperator2D) eGet(
				Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TRANSFORM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextureTransform(IfcCartesianTransformationOperator2D newTextureTransform) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TRANSFORM, newTextureTransform);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextureTransform() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TRANSFORM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextureTransform() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TRANSFORM);
	}

} //IfcSurfaceTextureImpl
