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
import org.bimserver.models.ifc2x3tc1.IfcDerivedMeasureValue;
import org.bimserver.models.ifc2x3tc1.IfcSoundValue;
import org.bimserver.models.ifc2x3tc1.IfcTimeSeries;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Sound Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSoundValueImpl#getSoundLevelTimeSeries <em>Sound Level Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSoundValueImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSoundValueImpl#getFrequencyAsString <em>Frequency As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSoundValueImpl#getSoundLevelSingleValue <em>Sound Level Single Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSoundValueImpl extends IfcPropertySetDefinitionImpl implements IfcSoundValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSoundValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getSoundLevelTimeSeries() {
		return (IfcTimeSeries) eGet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__SOUND_LEVEL_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoundLevelTimeSeries(IfcTimeSeries newSoundLevelTimeSeries) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__SOUND_LEVEL_TIME_SERIES, newSoundLevelTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSoundLevelTimeSeries() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__SOUND_LEVEL_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSoundLevelTimeSeries() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__SOUND_LEVEL_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFrequency() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__FREQUENCY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrequency(double newFrequency) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__FREQUENCY, newFrequency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrequencyAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__FREQUENCY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrequencyAsString(String newFrequencyAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__FREQUENCY_AS_STRING, newFrequencyAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedMeasureValue getSoundLevelSingleValue() {
		return (IfcDerivedMeasureValue) eGet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__SOUND_LEVEL_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoundLevelSingleValue(IfcDerivedMeasureValue newSoundLevelSingleValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__SOUND_LEVEL_SINGLE_VALUE, newSoundLevelSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSoundLevelSingleValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__SOUND_LEVEL_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSoundLevelSingleValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SOUND_VALUE__SOUND_LEVEL_SINGLE_VALUE);
	}

} //IfcSoundValueImpl
