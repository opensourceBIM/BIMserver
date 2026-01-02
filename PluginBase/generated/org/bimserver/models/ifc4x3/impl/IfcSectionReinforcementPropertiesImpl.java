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
import org.bimserver.models.ifc4x3.IfcReinforcementBarProperties;
import org.bimserver.models.ifc4x3.IfcReinforcingBarRoleEnum;
import org.bimserver.models.ifc4x3.IfcSectionProperties;
import org.bimserver.models.ifc4x3.IfcSectionReinforcementProperties;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Section Reinforcement Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getLongitudinalStartPosition <em>Longitudinal Start Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getLongitudinalStartPositionAsString <em>Longitudinal Start Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getLongitudinalEndPosition <em>Longitudinal End Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getLongitudinalEndPositionAsString <em>Longitudinal End Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getTransversePosition <em>Transverse Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getTransversePositionAsString <em>Transverse Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getReinforcementRole <em>Reinforcement Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getSectionDefinition <em>Section Definition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSectionReinforcementPropertiesImpl#getCrossSectionReinforcementDefinitions <em>Cross Section Reinforcement Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSectionReinforcementPropertiesImpl extends IfcPreDefinedPropertiesImpl
		implements IfcSectionReinforcementProperties {
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
		return Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLongitudinalStartPosition() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_LongitudinalStartPosition(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalStartPosition(double newLongitudinalStartPosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_LongitudinalStartPosition(),
				newLongitudinalStartPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongitudinalStartPositionAsString() {
		return (String) eGet(
				Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_LongitudinalStartPositionAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalStartPositionAsString(String newLongitudinalStartPositionAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_LongitudinalStartPositionAsString(),
				newLongitudinalStartPositionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLongitudinalEndPosition() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_LongitudinalEndPosition(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalEndPosition(double newLongitudinalEndPosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_LongitudinalEndPosition(),
				newLongitudinalEndPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongitudinalEndPositionAsString() {
		return (String) eGet(
				Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_LongitudinalEndPositionAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalEndPositionAsString(String newLongitudinalEndPositionAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_LongitudinalEndPositionAsString(),
				newLongitudinalEndPositionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransversePosition() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_TransversePosition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransversePosition(double newTransversePosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_TransversePosition(), newTransversePosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransversePosition() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_TransversePosition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransversePosition() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_TransversePosition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransversePositionAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_TransversePositionAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransversePositionAsString(String newTransversePositionAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_TransversePositionAsString(),
				newTransversePositionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransversePositionAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_TransversePositionAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransversePositionAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_TransversePositionAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBarRoleEnum getReinforcementRole() {
		return (IfcReinforcingBarRoleEnum) eGet(
				Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_ReinforcementRole(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReinforcementRole(IfcReinforcingBarRoleEnum newReinforcementRole) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_ReinforcementRole(), newReinforcementRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSectionProperties getSectionDefinition() {
		return (IfcSectionProperties) eGet(
				Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_SectionDefinition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSectionDefinition(IfcSectionProperties newSectionDefinition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_SectionDefinition(), newSectionDefinition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcReinforcementBarProperties> getCrossSectionReinforcementDefinitions() {
		return (EList<IfcReinforcementBarProperties>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcSectionReinforcementProperties_CrossSectionReinforcementDefinitions(),
				true);
	}

} //IfcSectionReinforcementPropertiesImpl
