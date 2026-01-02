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
import org.bimserver.models.ifc4x3.IfcReinforcingBarSurfaceEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcement Bar Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getTotalCrossSectionArea <em>Total Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getTotalCrossSectionAreaAsString <em>Total Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getSteelGrade <em>Steel Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getBarSurface <em>Bar Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getEffectiveDepth <em>Effective Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getEffectiveDepthAsString <em>Effective Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getNominalBarDiameter <em>Nominal Bar Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getNominalBarDiameterAsString <em>Nominal Bar Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcementBarPropertiesImpl#getBarCount <em>Bar Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcReinforcementBarPropertiesImpl extends IfcPreDefinedPropertiesImpl
		implements IfcReinforcementBarProperties {
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
		return Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTotalCrossSectionArea() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_TotalCrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalCrossSectionArea(double newTotalCrossSectionArea) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_TotalCrossSectionArea(),
				newTotalCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTotalCrossSectionAreaAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_TotalCrossSectionAreaAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalCrossSectionAreaAsString(String newTotalCrossSectionAreaAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_TotalCrossSectionAreaAsString(),
				newTotalCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSteelGrade() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_SteelGrade(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSteelGrade(String newSteelGrade) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_SteelGrade(), newSteelGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBarSurfaceEnum getBarSurface() {
		return (IfcReinforcingBarSurfaceEnum) eGet(
				Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_BarSurface(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarSurface(IfcReinforcingBarSurfaceEnum newBarSurface) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_BarSurface(), newBarSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarSurface() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_BarSurface());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarSurface() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_BarSurface());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEffectiveDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_EffectiveDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEffectiveDepth(double newEffectiveDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_EffectiveDepth(), newEffectiveDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEffectiveDepth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_EffectiveDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEffectiveDepth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_EffectiveDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEffectiveDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_EffectiveDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEffectiveDepthAsString(String newEffectiveDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_EffectiveDepthAsString(),
				newEffectiveDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEffectiveDepthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_EffectiveDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEffectiveDepthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_EffectiveDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getNominalBarDiameter() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_NominalBarDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominalBarDiameter(double newNominalBarDiameter) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_NominalBarDiameter(), newNominalBarDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominalBarDiameter() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_NominalBarDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominalBarDiameter() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_NominalBarDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNominalBarDiameterAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_NominalBarDiameterAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominalBarDiameterAsString(String newNominalBarDiameterAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_NominalBarDiameterAsString(),
				newNominalBarDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominalBarDiameterAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_NominalBarDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominalBarDiameterAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_NominalBarDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getBarCount() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_BarCount(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarCount(long newBarCount) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_BarCount(), newBarCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarCount() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_BarCount());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarCount() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcementBarProperties_BarCount());
	}

} //IfcReinforcementBarPropertiesImpl
