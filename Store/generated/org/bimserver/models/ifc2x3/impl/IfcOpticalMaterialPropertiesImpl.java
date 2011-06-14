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
import org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Optical Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getVisibleTransmittance <em>Visible Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getSolarTransmittance <em>Solar Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getSolarReflectanceFront <em>Solar Reflectance Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getSolarReflectanceBack <em>Solar Reflectance Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcOpticalMaterialPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcOpticalMaterialProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOpticalMaterialPropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVisibleTransmittance()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleTransmittance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleTransmittance(float newVisibleTransmittance)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleTransmittance(), newVisibleTransmittance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleTransmittance()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleTransmittance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleTransmittance()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleTransmittance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleTransmittanceAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleTransmittanceAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleTransmittanceAsString(String newVisibleTransmittanceAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleTransmittanceAsString(), newVisibleTransmittanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleTransmittanceAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleTransmittanceAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleTransmittanceAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleTransmittanceAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSolarTransmittance()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarTransmittance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarTransmittance(float newSolarTransmittance)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarTransmittance(), newSolarTransmittance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarTransmittance()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarTransmittance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarTransmittance()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarTransmittance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolarTransmittanceAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarTransmittanceAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarTransmittanceAsString(String newSolarTransmittanceAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarTransmittanceAsString(), newSolarTransmittanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarTransmittanceAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarTransmittanceAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarTransmittanceAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarTransmittanceAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThermalIrTransmittance()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrTransmittance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrTransmittance(float newThermalIrTransmittance)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrTransmittance(), newThermalIrTransmittance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrTransmittance()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrTransmittance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrTransmittance()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrTransmittance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalIrTransmittanceAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrTransmittanceAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrTransmittanceAsString(String newThermalIrTransmittanceAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrTransmittanceAsString(), newThermalIrTransmittanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrTransmittanceAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrTransmittanceAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrTransmittanceAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrTransmittanceAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThermalIrEmissivityBack()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityBack(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrEmissivityBack(float newThermalIrEmissivityBack)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityBack(), newThermalIrEmissivityBack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrEmissivityBack()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityBack());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrEmissivityBack()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityBack());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalIrEmissivityBackAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityBackAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrEmissivityBackAsString(String newThermalIrEmissivityBackAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityBackAsString(), newThermalIrEmissivityBackAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrEmissivityBackAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityBackAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrEmissivityBackAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityBackAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThermalIrEmissivityFront()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityFront(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrEmissivityFront(float newThermalIrEmissivityFront)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityFront(), newThermalIrEmissivityFront);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrEmissivityFront()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityFront());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrEmissivityFront()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityFront());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalIrEmissivityFrontAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityFrontAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrEmissivityFrontAsString(String newThermalIrEmissivityFrontAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityFrontAsString(), newThermalIrEmissivityFrontAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrEmissivityFrontAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityFrontAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrEmissivityFrontAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_ThermalIrEmissivityFrontAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVisibleReflectanceBack()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceBack(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleReflectanceBack(float newVisibleReflectanceBack)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceBack(), newVisibleReflectanceBack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleReflectanceBack()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceBack());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleReflectanceBack()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceBack());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleReflectanceBackAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceBackAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleReflectanceBackAsString(String newVisibleReflectanceBackAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceBackAsString(), newVisibleReflectanceBackAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleReflectanceBackAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceBackAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleReflectanceBackAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceBackAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVisibleReflectanceFront()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceFront(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleReflectanceFront(float newVisibleReflectanceFront)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceFront(), newVisibleReflectanceFront);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleReflectanceFront()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceFront());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleReflectanceFront()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceFront());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleReflectanceFrontAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceFrontAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleReflectanceFrontAsString(String newVisibleReflectanceFrontAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceFrontAsString(), newVisibleReflectanceFrontAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleReflectanceFrontAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceFrontAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleReflectanceFrontAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_VisibleReflectanceFrontAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSolarReflectanceFront()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceFront(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarReflectanceFront(float newSolarReflectanceFront)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceFront(), newSolarReflectanceFront);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarReflectanceFront()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceFront());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarReflectanceFront()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceFront());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolarReflectanceFrontAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceFrontAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarReflectanceFrontAsString(String newSolarReflectanceFrontAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceFrontAsString(), newSolarReflectanceFrontAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarReflectanceFrontAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceFrontAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarReflectanceFrontAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceFrontAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSolarReflectanceBack()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceBack(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarReflectanceBack(float newSolarReflectanceBack)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceBack(), newSolarReflectanceBack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarReflectanceBack()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceBack());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarReflectanceBack()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceBack());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolarReflectanceBackAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceBackAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarReflectanceBackAsString(String newSolarReflectanceBackAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceBackAsString(), newSolarReflectanceBackAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarReflectanceBackAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceBackAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarReflectanceBackAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOpticalMaterialProperties_SolarReflectanceBackAsString());
	}

} //IfcOpticalMaterialPropertiesImpl
