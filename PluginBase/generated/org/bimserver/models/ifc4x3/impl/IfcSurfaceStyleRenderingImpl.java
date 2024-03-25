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
import org.bimserver.models.ifc4x3.IfcColourOrFactor;
import org.bimserver.models.ifc4x3.IfcReflectanceMethodEnum;
import org.bimserver.models.ifc4x3.IfcSpecularHighlightSelect;
import org.bimserver.models.ifc4x3.IfcSurfaceStyleRendering;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Style Rendering</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleRenderingImpl#getDiffuseColour <em>Diffuse Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleRenderingImpl#getTransmissionColour <em>Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleRenderingImpl#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleRenderingImpl#getReflectionColour <em>Reflection Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleRenderingImpl#getSpecularColour <em>Specular Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleRenderingImpl#getSpecularHighlight <em>Specular Highlight</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleRenderingImpl#getReflectanceMethod <em>Reflectance Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSurfaceStyleRenderingImpl extends IfcSurfaceStyleShadingImpl implements IfcSurfaceStyleRendering {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceStyleRenderingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourOrFactor getDiffuseColour() {
		return (IfcColourOrFactor) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDiffuseColour(IfcColourOrFactor newDiffuseColour) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR, newDiffuseColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDiffuseColour() {
		eUnset(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDiffuseColour() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourOrFactor getTransmissionColour() {
		return (IfcColourOrFactor) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransmissionColour(IfcColourOrFactor newTransmissionColour) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR, newTransmissionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransmissionColour() {
		eUnset(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransmissionColour() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourOrFactor getDiffuseTransmissionColour() {
		return (IfcColourOrFactor) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDiffuseTransmissionColour(IfcColourOrFactor newDiffuseTransmissionColour) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR,
				newDiffuseTransmissionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDiffuseTransmissionColour() {
		eUnset(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDiffuseTransmissionColour() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourOrFactor getReflectionColour() {
		return (IfcColourOrFactor) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReflectionColour(IfcColourOrFactor newReflectionColour) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR, newReflectionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReflectionColour() {
		eUnset(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReflectionColour() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourOrFactor getSpecularColour() {
		return (IfcColourOrFactor) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecularColour(IfcColourOrFactor newSpecularColour) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR, newSpecularColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSpecularColour() {
		eUnset(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSpecularColour() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpecularHighlightSelect getSpecularHighlight() {
		return (IfcSpecularHighlightSelect) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecularHighlight(IfcSpecularHighlightSelect newSpecularHighlight) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT, newSpecularHighlight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSpecularHighlight() {
		eUnset(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSpecularHighlight() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReflectanceMethodEnum getReflectanceMethod() {
		return (IfcReflectanceMethodEnum) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTANCE_METHOD,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReflectanceMethod(IfcReflectanceMethodEnum newReflectanceMethod) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTANCE_METHOD, newReflectanceMethod);
	}

} //IfcSurfaceStyleRenderingImpl
