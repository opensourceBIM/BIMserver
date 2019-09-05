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
import org.bimserver.models.ifc4.IfcReinforcementBarProperties;
import org.bimserver.models.ifc4.IfcReinforcingBarSurfaceEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcement Bar Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getTotalCrossSectionArea <em>Total Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getTotalCrossSectionAreaAsString <em>Total Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getSteelGrade <em>Steel Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getBarSurface <em>Bar Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getEffectiveDepth <em>Effective Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getEffectiveDepthAsString <em>Effective Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getNominalBarDiameter <em>Nominal Bar Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getNominalBarDiameterAsString <em>Nominal Bar Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getBarCount <em>Bar Count</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementBarPropertiesImpl#getBarCountAsString <em>Bar Count As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcReinforcementBarPropertiesImpl extends IfcPreDefinedPropertiesImpl implements IfcReinforcementBarProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReinforcementBarPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTotalCrossSectionArea() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__TOTAL_CROSS_SECTION_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalCrossSectionArea(double newTotalCrossSectionArea) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__TOTAL_CROSS_SECTION_AREA, newTotalCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTotalCrossSectionAreaAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__TOTAL_CROSS_SECTION_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalCrossSectionAreaAsString(String newTotalCrossSectionAreaAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__TOTAL_CROSS_SECTION_AREA_AS_STRING, newTotalCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSteelGrade() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__STEEL_GRADE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSteelGrade(String newSteelGrade) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__STEEL_GRADE, newSteelGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBarSurfaceEnum getBarSurface() {
		return (IfcReinforcingBarSurfaceEnum) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarSurface(IfcReinforcingBarSurfaceEnum newBarSurface) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_SURFACE, newBarSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarSurface() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_SURFACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarSurface() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_SURFACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEffectiveDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__EFFECTIVE_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEffectiveDepth(double newEffectiveDepth) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__EFFECTIVE_DEPTH, newEffectiveDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEffectiveDepth() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__EFFECTIVE_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEffectiveDepth() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__EFFECTIVE_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEffectiveDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__EFFECTIVE_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEffectiveDepthAsString(String newEffectiveDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__EFFECTIVE_DEPTH_AS_STRING, newEffectiveDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEffectiveDepthAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__EFFECTIVE_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEffectiveDepthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__EFFECTIVE_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getNominalBarDiameter() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__NOMINAL_BAR_DIAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominalBarDiameter(double newNominalBarDiameter) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__NOMINAL_BAR_DIAMETER, newNominalBarDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominalBarDiameter() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__NOMINAL_BAR_DIAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominalBarDiameter() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__NOMINAL_BAR_DIAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNominalBarDiameterAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__NOMINAL_BAR_DIAMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominalBarDiameterAsString(String newNominalBarDiameterAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__NOMINAL_BAR_DIAMETER_AS_STRING, newNominalBarDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominalBarDiameterAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__NOMINAL_BAR_DIAMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominalBarDiameterAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__NOMINAL_BAR_DIAMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBarCount() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarCount(double newBarCount) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_COUNT, newBarCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarCount() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_COUNT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarCount() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_COUNT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBarCountAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_COUNT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarCountAsString(String newBarCountAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_COUNT_AS_STRING, newBarCountAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarCountAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_COUNT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarCountAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCEMENT_BAR_PROPERTIES__BAR_COUNT_AS_STRING);
	}

} //IfcReinforcementBarPropertiesImpl
