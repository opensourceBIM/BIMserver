/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcColourRgb;
import org.bimserver.models.ifc2x3.IfcLightDistributionDataSourceSelect;
import org.bimserver.models.ifc2x3.IfcLightEmissionSourceEnum;
import org.bimserver.models.ifc2x3.IfcLightSourceGoniometric;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Goniometric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl#getColourAppearance <em>Colour Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl#getColourTemperature <em>Colour Temperature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl#getColourTemperatureAsString <em>Colour Temperature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl#getLuminousFlux <em>Luminous Flux</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl#getLuminousFluxAsString <em>Luminous Flux As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl#getLightEmissionSource <em>Light Emission Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl#getLightDistributionDataSource <em>Light Distribution Data Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLightSourceGoniometricImpl extends IfcLightSourceImpl implements IfcLightSourceGoniometric
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightSourceGoniometricImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D getPosition()
	{
		return (IfcAxis2Placement3D)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_Position(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(IfcAxis2Placement3D newPosition)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_Position(), newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourRgb getColourAppearance()
	{
		return (IfcColourRgb)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourAppearance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColourAppearance(IfcColourRgb newColourAppearance)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourAppearance(), newColourAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetColourAppearance()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourAppearance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetColourAppearance()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourAppearance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getColourTemperature()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourTemperature(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColourTemperature(float newColourTemperature)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourTemperature(), newColourTemperature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColourTemperatureAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourTemperatureAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColourTemperatureAsString(String newColourTemperatureAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_ColourTemperatureAsString(), newColourTemperatureAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLuminousFlux()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_LuminousFlux(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLuminousFlux(float newLuminousFlux)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_LuminousFlux(), newLuminousFlux);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLuminousFluxAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_LuminousFluxAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLuminousFluxAsString(String newLuminousFluxAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_LuminousFluxAsString(), newLuminousFluxAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightEmissionSourceEnum getLightEmissionSource()
	{
		return (IfcLightEmissionSourceEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_LightEmissionSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLightEmissionSource(IfcLightEmissionSourceEnum newLightEmissionSource)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_LightEmissionSource(), newLightEmissionSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightDistributionDataSourceSelect getLightDistributionDataSource()
	{
		return (IfcLightDistributionDataSourceSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_LightDistributionDataSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLightDistributionDataSource(IfcLightDistributionDataSourceSelect newLightDistributionDataSource)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourceGoniometric_LightDistributionDataSource(), newLightDistributionDataSource);
	}

} //IfcLightSourceGoniometricImpl
