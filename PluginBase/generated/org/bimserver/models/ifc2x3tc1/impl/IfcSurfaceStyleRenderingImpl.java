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
import org.bimserver.models.ifc2x3tc1.IfcColourOrFactor;
import org.bimserver.models.ifc2x3tc1.IfcReflectanceMethodEnum;
import org.bimserver.models.ifc2x3tc1.IfcSpecularHighlightSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Style Rendering</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getTransparency <em>Transparency</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getTransparencyAsString <em>Transparency As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getDiffuseColour <em>Diffuse Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getTransmissionColour <em>Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getReflectionColour <em>Reflection Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getSpecularColour <em>Specular Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getSpecularHighlight <em>Specular Highlight</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSurfaceStyleRenderingImpl#getReflectanceMethod <em>Reflectance Method</em>}</li>
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
		return Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransparency() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransparency(double newTransparency) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY, newTransparency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransparency() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransparency() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransparencyAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransparencyAsString(String newTransparencyAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY_AS_STRING, newTransparencyAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransparencyAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransparencyAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSPARENCY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getDiffuseColour() {
		return (IfcColourOrFactor) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiffuseColour(IfcColourOrFactor newDiffuseColour) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR, newDiffuseColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDiffuseColour() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiffuseColour() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getTransmissionColour() {
		return (IfcColourOrFactor) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransmissionColour(IfcColourOrFactor newTransmissionColour) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR, newTransmissionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransmissionColour() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransmissionColour() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getDiffuseTransmissionColour() {
		return (IfcColourOrFactor) eGet(
				Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiffuseTransmissionColour(IfcColourOrFactor newDiffuseTransmissionColour) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR,
				newDiffuseTransmissionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDiffuseTransmissionColour() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiffuseTransmissionColour() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__DIFFUSE_TRANSMISSION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getReflectionColour() {
		return (IfcColourOrFactor) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectionColour(IfcColourOrFactor newReflectionColour) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR, newReflectionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReflectionColour() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReflectionColour() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTION_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourOrFactor getSpecularColour() {
		return (IfcColourOrFactor) eGet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecularColour(IfcColourOrFactor newSpecularColour) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR, newSpecularColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecularColour() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecularColour() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpecularHighlightSelect getSpecularHighlight() {
		return (IfcSpecularHighlightSelect) eGet(
				Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecularHighlight(IfcSpecularHighlightSelect newSpecularHighlight) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT, newSpecularHighlight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecularHighlight() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecularHighlight() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__SPECULAR_HIGHLIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReflectanceMethodEnum getReflectanceMethod() {
		return (IfcReflectanceMethodEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTANCE_METHOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectanceMethod(IfcReflectanceMethodEnum newReflectanceMethod) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SURFACE_STYLE_RENDERING__REFLECTANCE_METHOD, newReflectanceMethod);
	}

} //IfcSurfaceStyleRenderingImpl
