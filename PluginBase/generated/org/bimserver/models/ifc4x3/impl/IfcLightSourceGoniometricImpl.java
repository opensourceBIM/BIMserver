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
import org.bimserver.models.ifc4x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc4x3.IfcColourRgb;
import org.bimserver.models.ifc4x3.IfcLightDistributionDataSourceSelect;
import org.bimserver.models.ifc4x3.IfcLightEmissionSourceEnum;
import org.bimserver.models.ifc4x3.IfcLightSourceGoniometric;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Goniometric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceGoniometricImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceGoniometricImpl#getColourAppearance <em>Colour Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceGoniometricImpl#getColourTemperature <em>Colour Temperature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceGoniometricImpl#getColourTemperatureAsString <em>Colour Temperature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceGoniometricImpl#getLuminousFlux <em>Luminous Flux</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceGoniometricImpl#getLuminousFluxAsString <em>Luminous Flux As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceGoniometricImpl#getLightEmissionSource <em>Light Emission Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceGoniometricImpl#getLightDistributionDataSource <em>Light Distribution Data Source</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAxis2Placement3D getPosition() {
		return (IfcAxis2Placement3D) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_Position(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPosition(IfcAxis2Placement3D newPosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_Position(), newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgb getColourAppearance() {
		return (IfcColourRgb) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourAppearance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColourAppearance(IfcColourRgb newColourAppearance) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourAppearance(), newColourAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetColourAppearance() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourAppearance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetColourAppearance() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourAppearance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getColourTemperature() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourTemperature(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColourTemperature(double newColourTemperature) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourTemperature(), newColourTemperature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getColourTemperatureAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourTemperatureAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColourTemperatureAsString(String newColourTemperatureAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourTemperatureAsString(),
				newColourTemperatureAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLuminousFlux() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_LuminousFlux(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLuminousFlux(double newLuminousFlux) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_LuminousFlux(), newLuminousFlux);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLuminousFluxAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_LuminousFluxAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLuminousFluxAsString(String newLuminousFluxAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_LuminousFluxAsString(), newLuminousFluxAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightEmissionSourceEnum getLightEmissionSource() {
		return (IfcLightEmissionSourceEnum) eGet(
				Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_LightEmissionSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLightEmissionSource(IfcLightEmissionSourceEnum newLightEmissionSource) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_LightEmissionSource(), newLightEmissionSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightDistributionDataSourceSelect getLightDistributionDataSource() {
		return (IfcLightDistributionDataSourceSelect) eGet(
				Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_LightDistributionDataSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLightDistributionDataSource(IfcLightDistributionDataSourceSelect newLightDistributionDataSource) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceGoniometric_LightDistributionDataSource(),
				newLightDistributionDataSource);
	}

} //IfcLightSourceGoniometricImpl
