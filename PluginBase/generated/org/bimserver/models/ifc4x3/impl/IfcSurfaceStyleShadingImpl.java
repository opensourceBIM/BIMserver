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
import org.bimserver.models.ifc4x3.IfcColourRgb;
import org.bimserver.models.ifc4x3.IfcSurfaceStyleShading;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Style Shading</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleShadingImpl#getSurfaceColour <em>Surface Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleShadingImpl#getTransparency <em>Transparency</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSurfaceStyleShadingImpl#getTransparencyAsString <em>Transparency As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSurfaceStyleShadingImpl extends IfcPresentationItemImpl implements IfcSurfaceStyleShading {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceStyleShadingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgb getSurfaceColour() {
		return (IfcColourRgb) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__SURFACE_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSurfaceColour(IfcColourRgb newSurfaceColour) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__SURFACE_COLOUR, newSurfaceColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransparency() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__TRANSPARENCY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransparency(double newTransparency) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__TRANSPARENCY, newTransparency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransparency() {
		eUnset(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__TRANSPARENCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransparency() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__TRANSPARENCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransparencyAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__TRANSPARENCY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransparencyAsString(String newTransparencyAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__TRANSPARENCY_AS_STRING, newTransparencyAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransparencyAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__TRANSPARENCY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransparencyAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SURFACE_STYLE_SHADING__TRANSPARENCY_AS_STRING);
	}

} //IfcSurfaceStyleShadingImpl
