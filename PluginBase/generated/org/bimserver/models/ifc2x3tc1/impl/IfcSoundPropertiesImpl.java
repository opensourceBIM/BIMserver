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
import org.bimserver.models.ifc2x3tc1.IfcSoundProperties;
import org.bimserver.models.ifc2x3tc1.IfcSoundScaleEnum;
import org.bimserver.models.ifc2x3tc1.IfcSoundValue;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Sound Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSoundPropertiesImpl#getIsAttenuating <em>Is Attenuating</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSoundPropertiesImpl#getSoundScale <em>Sound Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSoundPropertiesImpl#getSoundValues <em>Sound Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSoundPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcSoundProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSoundPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SOUND_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsAttenuating() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_SOUND_PROPERTIES__IS_ATTENUATING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAttenuating(Tristate newIsAttenuating) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SOUND_PROPERTIES__IS_ATTENUATING, newIsAttenuating);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSoundScaleEnum getSoundScale() {
		return (IfcSoundScaleEnum) eGet(Ifc2x3tc1Package.Literals.IFC_SOUND_PROPERTIES__SOUND_SCALE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoundScale(IfcSoundScaleEnum newSoundScale) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SOUND_PROPERTIES__SOUND_SCALE, newSoundScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSoundScale() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SOUND_PROPERTIES__SOUND_SCALE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSoundScale() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SOUND_PROPERTIES__SOUND_SCALE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcSoundValue> getSoundValues() {
		return (EList<IfcSoundValue>) eGet(Ifc2x3tc1Package.Literals.IFC_SOUND_PROPERTIES__SOUND_VALUES, true);
	}

} //IfcSoundPropertiesImpl
