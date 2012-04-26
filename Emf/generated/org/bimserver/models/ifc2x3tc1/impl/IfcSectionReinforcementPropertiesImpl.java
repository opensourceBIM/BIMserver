/**
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3tc1.IfcReinforcementBarProperties;
import org.bimserver.models.ifc2x3tc1.IfcReinforcingBarRoleEnum;
import org.bimserver.models.ifc2x3tc1.IfcSectionProperties;
import org.bimserver.models.ifc2x3tc1.IfcSectionReinforcementProperties;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Section Reinforcement Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getLongitudinalStartPosition <em>Longitudinal Start Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getLongitudinalStartPositionAsString <em>Longitudinal Start Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getLongitudinalEndPosition <em>Longitudinal End Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getLongitudinalEndPositionAsString <em>Longitudinal End Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getTransversePosition <em>Transverse Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getTransversePositionAsString <em>Transverse Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getReinforcementRole <em>Reinforcement Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getSectionDefinition <em>Section Definition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSectionReinforcementPropertiesImpl#getCrossSectionReinforcementDefinitions <em>Cross Section Reinforcement Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSectionReinforcementPropertiesImpl extends IdEObjectImpl implements IfcSectionReinforcementProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSectionReinforcementPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitudinalStartPosition() {
		return (Double) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__LONGITUDINAL_START_POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalStartPosition(double newLongitudinalStartPosition) {
		eSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__LONGITUDINAL_START_POSITION, newLongitudinalStartPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalStartPositionAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__LONGITUDINAL_START_POSITION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalStartPositionAsString(String newLongitudinalStartPositionAsString) {
		eSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__LONGITUDINAL_START_POSITION_AS_STRING, newLongitudinalStartPositionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitudinalEndPosition() {
		return (Double) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__LONGITUDINAL_END_POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalEndPosition(double newLongitudinalEndPosition) {
		eSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__LONGITUDINAL_END_POSITION, newLongitudinalEndPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalEndPositionAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__LONGITUDINAL_END_POSITION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalEndPositionAsString(String newLongitudinalEndPositionAsString) {
		eSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__LONGITUDINAL_END_POSITION_AS_STRING, newLongitudinalEndPositionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransversePosition() {
		return (Double) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__TRANSVERSE_POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransversePosition(double newTransversePosition) {
		eSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__TRANSVERSE_POSITION, newTransversePosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransversePosition() {
		eUnset(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__TRANSVERSE_POSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransversePosition() {
		return eIsSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__TRANSVERSE_POSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransversePositionAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__TRANSVERSE_POSITION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransversePositionAsString(String newTransversePositionAsString) {
		eSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__TRANSVERSE_POSITION_AS_STRING, newTransversePositionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransversePositionAsString() {
		eUnset(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__TRANSVERSE_POSITION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransversePositionAsString() {
		return eIsSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__TRANSVERSE_POSITION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingBarRoleEnum getReinforcementRole() {
		return (IfcReinforcingBarRoleEnum) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__REINFORCEMENT_ROLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReinforcementRole(IfcReinforcingBarRoleEnum newReinforcementRole) {
		eSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__REINFORCEMENT_ROLE, newReinforcementRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSectionProperties getSectionDefinition() {
		return (IfcSectionProperties) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__SECTION_DEFINITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSectionDefinition(IfcSectionProperties newSectionDefinition) {
		eSet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__SECTION_DEFINITION, newSectionDefinition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcReinforcementBarProperties> getCrossSectionReinforcementDefinitions() {
		return (EList<IfcReinforcementBarProperties>) eGet(LogPackage.Literals.IFC_SECTION_REINFORCEMENT_PROPERTIES__CROSS_SECTION_REINFORCEMENT_DEFINITIONS, true);
	}

} //IfcSectionReinforcementPropertiesImpl
