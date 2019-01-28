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
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcLightDistributionDataSourceSelect;
import org.bimserver.models.ifc2x3tc1.IfcLightEmissionSourceEnum;
import org.bimserver.models.ifc2x3tc1.IfcLightSourceGoniometric;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Goniometric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceGoniometricImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceGoniometricImpl#getColourAppearance <em>Colour Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceGoniometricImpl#getColourTemperature <em>Colour Temperature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceGoniometricImpl#getColourTemperatureAsString <em>Colour Temperature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceGoniometricImpl#getLuminousFlux <em>Luminous Flux</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceGoniometricImpl#getLuminousFluxAsString <em>Luminous Flux As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceGoniometricImpl#getLightEmissionSource <em>Light Emission Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceGoniometricImpl#getLightDistributionDataSource <em>Light Distribution Data Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLightSourceGoniometricImpl extends IfcLightSourceImpl implements IfcLightSourceGoniometric {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightSourceGoniometricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D getPosition() {
		return (IfcAxis2Placement3D) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(IfcAxis2Placement3D newPosition) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__POSITION, newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourRgb getColourAppearance() {
		return (IfcColourRgb) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__COLOUR_APPEARANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColourAppearance(IfcColourRgb newColourAppearance) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__COLOUR_APPEARANCE, newColourAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetColourAppearance() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__COLOUR_APPEARANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetColourAppearance() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__COLOUR_APPEARANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getColourTemperature() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__COLOUR_TEMPERATURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColourTemperature(double newColourTemperature) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__COLOUR_TEMPERATURE, newColourTemperature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColourTemperatureAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__COLOUR_TEMPERATURE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColourTemperatureAsString(String newColourTemperatureAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__COLOUR_TEMPERATURE_AS_STRING,
				newColourTemperatureAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLuminousFlux() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__LUMINOUS_FLUX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLuminousFlux(double newLuminousFlux) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__LUMINOUS_FLUX, newLuminousFlux);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLuminousFluxAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__LUMINOUS_FLUX_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLuminousFluxAsString(String newLuminousFluxAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__LUMINOUS_FLUX_AS_STRING, newLuminousFluxAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightEmissionSourceEnum getLightEmissionSource() {
		return (IfcLightEmissionSourceEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__LIGHT_EMISSION_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLightEmissionSource(IfcLightEmissionSourceEnum newLightEmissionSource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__LIGHT_EMISSION_SOURCE, newLightEmissionSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightDistributionDataSourceSelect getLightDistributionDataSource() {
		return (IfcLightDistributionDataSourceSelect) eGet(
				Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__LIGHT_DISTRIBUTION_DATA_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLightDistributionDataSource(IfcLightDistributionDataSourceSelect newLightDistributionDataSource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_GONIOMETRIC__LIGHT_DISTRIBUTION_DATA_SOURCE,
				newLightDistributionDataSource);
	}

} //IfcLightSourceGoniometricImpl
