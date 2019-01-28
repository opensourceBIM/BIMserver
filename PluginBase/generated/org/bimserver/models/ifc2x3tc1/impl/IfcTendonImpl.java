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
import org.bimserver.models.ifc2x3tc1.IfcTendon;
import org.bimserver.models.ifc2x3tc1.IfcTendonTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Tendon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getTensionForce <em>Tension Force</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getTensionForceAsString <em>Tension Force As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getPreStress <em>Pre Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getPreStressAsString <em>Pre Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getFrictionCoefficient <em>Friction Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getFrictionCoefficientAsString <em>Friction Coefficient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getAnchorageSlip <em>Anchorage Slip</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getAnchorageSlipAsString <em>Anchorage Slip As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getMinCurvatureRadius <em>Min Curvature Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTendonImpl#getMinCurvatureRadiusAsString <em>Min Curvature Radius As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTendonImpl extends IfcReinforcingElementImpl implements IfcTendon {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTendonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_TENDON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTendonTypeEnum getPredefinedType() {
		return (IfcTendonTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcTendonTypeEnum newPredefinedType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNominalDiameter() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__NOMINAL_DIAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalDiameter(double newNominalDiameter) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__NOMINAL_DIAMETER, newNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNominalDiameterAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__NOMINAL_DIAMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalDiameterAsString(String newNominalDiameterAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__NOMINAL_DIAMETER_AS_STRING, newNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCrossSectionArea() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__CROSS_SECTION_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionArea(double newCrossSectionArea) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__CROSS_SECTION_AREA, newCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCrossSectionAreaAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__CROSS_SECTION_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionAreaAsString(String newCrossSectionAreaAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__CROSS_SECTION_AREA_AS_STRING, newCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTensionForce() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__TENSION_FORCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionForce(double newTensionForce) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__TENSION_FORCE, newTensionForce);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionForce() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__TENSION_FORCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionForce() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__TENSION_FORCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTensionForceAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__TENSION_FORCE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionForceAsString(String newTensionForceAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__TENSION_FORCE_AS_STRING, newTensionForceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionForceAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__TENSION_FORCE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionForceAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__TENSION_FORCE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPreStress() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__PRE_STRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreStress(double newPreStress) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__PRE_STRESS, newPreStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPreStress() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__PRE_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPreStress() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__PRE_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreStressAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__PRE_STRESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreStressAsString(String newPreStressAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__PRE_STRESS_AS_STRING, newPreStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPreStressAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__PRE_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPreStressAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__PRE_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFrictionCoefficient() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__FRICTION_COEFFICIENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrictionCoefficient(double newFrictionCoefficient) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__FRICTION_COEFFICIENT, newFrictionCoefficient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrictionCoefficient() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__FRICTION_COEFFICIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrictionCoefficient() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__FRICTION_COEFFICIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrictionCoefficientAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__FRICTION_COEFFICIENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrictionCoefficientAsString(String newFrictionCoefficientAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__FRICTION_COEFFICIENT_AS_STRING, newFrictionCoefficientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrictionCoefficientAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__FRICTION_COEFFICIENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrictionCoefficientAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__FRICTION_COEFFICIENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAnchorageSlip() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__ANCHORAGE_SLIP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnchorageSlip(double newAnchorageSlip) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__ANCHORAGE_SLIP, newAnchorageSlip);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAnchorageSlip() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__ANCHORAGE_SLIP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAnchorageSlip() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__ANCHORAGE_SLIP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnchorageSlipAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__ANCHORAGE_SLIP_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnchorageSlipAsString(String newAnchorageSlipAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__ANCHORAGE_SLIP_AS_STRING, newAnchorageSlipAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAnchorageSlipAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__ANCHORAGE_SLIP_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAnchorageSlipAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__ANCHORAGE_SLIP_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinCurvatureRadius() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__MIN_CURVATURE_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinCurvatureRadius(double newMinCurvatureRadius) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__MIN_CURVATURE_RADIUS, newMinCurvatureRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinCurvatureRadius() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__MIN_CURVATURE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinCurvatureRadius() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__MIN_CURVATURE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinCurvatureRadiusAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TENDON__MIN_CURVATURE_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinCurvatureRadiusAsString(String newMinCurvatureRadiusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TENDON__MIN_CURVATURE_RADIUS_AS_STRING, newMinCurvatureRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinCurvatureRadiusAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TENDON__MIN_CURVATURE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinCurvatureRadiusAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TENDON__MIN_CURVATURE_RADIUS_AS_STRING);
	}

} //IfcTendonImpl
