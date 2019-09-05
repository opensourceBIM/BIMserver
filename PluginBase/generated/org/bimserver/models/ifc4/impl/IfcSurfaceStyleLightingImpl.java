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
import org.bimserver.models.ifc4.IfcColourRgb;
import org.bimserver.models.ifc4.IfcSurfaceStyleLighting;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Style Lighting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceStyleLightingImpl#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceStyleLightingImpl#getDiffuseReflectionColour <em>Diffuse Reflection Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceStyleLightingImpl#getTransmissionColour <em>Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceStyleLightingImpl#getReflectanceColour <em>Reflectance Colour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSurfaceStyleLightingImpl extends IfcPresentationItemImpl implements IfcSurfaceStyleLighting {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceStyleLightingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgb getDiffuseTransmissionColour() {
		return (IfcColourRgb) eGet(Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING__DIFFUSE_TRANSMISSION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDiffuseTransmissionColour(IfcColourRgb newDiffuseTransmissionColour) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING__DIFFUSE_TRANSMISSION_COLOUR, newDiffuseTransmissionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgb getDiffuseReflectionColour() {
		return (IfcColourRgb) eGet(Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING__DIFFUSE_REFLECTION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDiffuseReflectionColour(IfcColourRgb newDiffuseReflectionColour) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING__DIFFUSE_REFLECTION_COLOUR, newDiffuseReflectionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgb getTransmissionColour() {
		return (IfcColourRgb) eGet(Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING__TRANSMISSION_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransmissionColour(IfcColourRgb newTransmissionColour) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING__TRANSMISSION_COLOUR, newTransmissionColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgb getReflectanceColour() {
		return (IfcColourRgb) eGet(Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING__REFLECTANCE_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReflectanceColour(IfcColourRgb newReflectanceColour) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_LIGHTING__REFLECTANCE_COLOUR, newReflectanceColour);
	}

} //IfcSurfaceStyleLightingImpl
