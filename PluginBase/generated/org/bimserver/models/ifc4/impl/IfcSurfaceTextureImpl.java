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
import org.bimserver.models.ifc4.IfcCartesianTransformationOperator2D;
import org.bimserver.models.ifc4.IfcSurfaceStyleWithTextures;
import org.bimserver.models.ifc4.IfcSurfaceTexture;
import org.bimserver.models.ifc4.IfcTextureCoordinate;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Texture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceTextureImpl#getRepeatS <em>Repeat S</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceTextureImpl#getRepeatT <em>Repeat T</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceTextureImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceTextureImpl#getTextureTransform <em>Texture Transform</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceTextureImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceTextureImpl#getIsMappedBy <em>Is Mapped By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceTextureImpl#getUsedInStyles <em>Used In Styles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSurfaceTextureImpl extends IfcPresentationItemImpl implements IfcSurfaceTexture {
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
		return Ifc4Package.Literals.IFC_SURFACE_TEXTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getRepeatS() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__REPEAT_S, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepeatS(Tristate newRepeatS) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__REPEAT_S, newRepeatS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getRepeatT() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__REPEAT_T, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepeatT(Tristate newRepeatT) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__REPEAT_T, newRepeatT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMode() {
		return (String) eGet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__MODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMode(String newMode) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__MODE, newMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMode() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__MODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMode() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__MODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianTransformationOperator2D getTextureTransform() {
		return (IfcCartesianTransformationOperator2D) eGet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TRANSFORM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextureTransform(IfcCartesianTransformationOperator2D newTextureTransform) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TRANSFORM, newTextureTransform);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTextureTransform() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TRANSFORM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTextureTransform() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__TEXTURE_TRANSFORM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getParameter() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__PARAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetParameter() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__PARAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetParameter() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__PARAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcTextureCoordinate> getIsMappedBy() {
		return (EList<IfcTextureCoordinate>) eGet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__IS_MAPPED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsMappedBy() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__IS_MAPPED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsMappedBy() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__IS_MAPPED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcSurfaceStyleWithTextures> getUsedInStyles() {
		return (EList<IfcSurfaceStyleWithTextures>) eGet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__USED_IN_STYLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUsedInStyles() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__USED_IN_STYLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUsedInStyles() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_TEXTURE__USED_IN_STYLES);
	}

} //IfcSurfaceTextureImpl
