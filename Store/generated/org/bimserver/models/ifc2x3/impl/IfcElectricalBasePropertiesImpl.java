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
import org.bimserver.models.ifc2x3.IfcElectricCurrentEnum;
import org.bimserver.models.ifc2x3.IfcElectricalBaseProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Electrical Base Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getElectricCurrentType <em>Electric Current Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getInputVoltage <em>Input Voltage</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getInputVoltageAsString <em>Input Voltage As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getInputFrequency <em>Input Frequency</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getInputFrequencyAsString <em>Input Frequency As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getFullLoadCurrent <em>Full Load Current</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getFullLoadCurrentAsString <em>Full Load Current As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getMinimumCircuitCurrent <em>Minimum Circuit Current</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getMinimumCircuitCurrentAsString <em>Minimum Circuit Current As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getMaximumPowerInput <em>Maximum Power Input</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getMaximumPowerInputAsString <em>Maximum Power Input As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getRatedPowerInput <em>Rated Power Input</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getRatedPowerInputAsString <em>Rated Power Input As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl#getInputPhase <em>Input Phase</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcElectricalBasePropertiesImpl extends IfcEnergyPropertiesImpl implements IfcElectricalBaseProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcElectricalBasePropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricCurrentEnum getElectricCurrentType()
	{
		return (IfcElectricCurrentEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_ElectricCurrentType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElectricCurrentType(IfcElectricCurrentEnum newElectricCurrentType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_ElectricCurrentType(), newElectricCurrentType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInputVoltage()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputVoltage(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputVoltage(float newInputVoltage)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputVoltage(), newInputVoltage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputVoltageAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputVoltageAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputVoltageAsString(String newInputVoltageAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputVoltageAsString(), newInputVoltageAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInputFrequency()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputFrequency(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputFrequency(float newInputFrequency)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputFrequency(), newInputFrequency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputFrequencyAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputFrequencyAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputFrequencyAsString(String newInputFrequencyAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputFrequencyAsString(), newInputFrequencyAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFullLoadCurrent()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_FullLoadCurrent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullLoadCurrent(float newFullLoadCurrent)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_FullLoadCurrent(), newFullLoadCurrent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFullLoadCurrent()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_FullLoadCurrent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFullLoadCurrent()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_FullLoadCurrent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullLoadCurrentAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_FullLoadCurrentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullLoadCurrentAsString(String newFullLoadCurrentAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_FullLoadCurrentAsString(), newFullLoadCurrentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFullLoadCurrentAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_FullLoadCurrentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFullLoadCurrentAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_FullLoadCurrentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMinimumCircuitCurrent()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MinimumCircuitCurrent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumCircuitCurrent(float newMinimumCircuitCurrent)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MinimumCircuitCurrent(), newMinimumCircuitCurrent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumCircuitCurrent()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MinimumCircuitCurrent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumCircuitCurrent()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MinimumCircuitCurrent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumCircuitCurrentAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MinimumCircuitCurrentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumCircuitCurrentAsString(String newMinimumCircuitCurrentAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MinimumCircuitCurrentAsString(), newMinimumCircuitCurrentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumCircuitCurrentAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MinimumCircuitCurrentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumCircuitCurrentAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MinimumCircuitCurrentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaximumPowerInput()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MaximumPowerInput(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPowerInput(float newMaximumPowerInput)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MaximumPowerInput(), newMaximumPowerInput);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumPowerInput()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MaximumPowerInput());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumPowerInput()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MaximumPowerInput());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumPowerInputAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MaximumPowerInputAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPowerInputAsString(String newMaximumPowerInputAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MaximumPowerInputAsString(), newMaximumPowerInputAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumPowerInputAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MaximumPowerInputAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumPowerInputAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_MaximumPowerInputAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRatedPowerInput()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_RatedPowerInput(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedPowerInput(float newRatedPowerInput)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_RatedPowerInput(), newRatedPowerInput);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRatedPowerInput()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_RatedPowerInput());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRatedPowerInput()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_RatedPowerInput());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRatedPowerInputAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_RatedPowerInputAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedPowerInputAsString(String newRatedPowerInputAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_RatedPowerInputAsString(), newRatedPowerInputAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRatedPowerInputAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_RatedPowerInputAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRatedPowerInputAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_RatedPowerInputAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInputPhase()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputPhase(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputPhase(int newInputPhase)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcElectricalBaseProperties_InputPhase(), newInputPhase);
	}

} //IfcElectricalBasePropertiesImpl
