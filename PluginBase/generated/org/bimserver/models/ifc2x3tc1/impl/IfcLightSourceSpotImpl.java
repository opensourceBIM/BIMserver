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
import org.bimserver.models.ifc2x3tc1.IfcDirection;
import org.bimserver.models.ifc2x3tc1.IfcLightSourceSpot;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Spot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceSpotImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceSpotImpl#getConcentrationExponent <em>Concentration Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceSpotImpl#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceSpotImpl#getSpreadAngle <em>Spread Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceSpotImpl#getSpreadAngleAsString <em>Spread Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceSpotImpl#getBeamWidthAngle <em>Beam Width Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourceSpotImpl#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLightSourceSpotImpl extends IfcLightSourcePositionalImpl implements IfcLightSourceSpot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightSourceSpotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getOrientation() {
		return (IfcDirection) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__ORIENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientation(IfcDirection newOrientation) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__ORIENTATION, newOrientation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getConcentrationExponent() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcentrationExponent(double newConcentrationExponent) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT, newConcentrationExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConcentrationExponent() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConcentrationExponent() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConcentrationExponentAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcentrationExponentAsString(String newConcentrationExponentAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT_AS_STRING,
				newConcentrationExponentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConcentrationExponentAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConcentrationExponentAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSpreadAngle() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__SPREAD_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpreadAngle(double newSpreadAngle) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__SPREAD_ANGLE, newSpreadAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpreadAngleAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__SPREAD_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpreadAngleAsString(String newSpreadAngleAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__SPREAD_ANGLE_AS_STRING, newSpreadAngleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBeamWidthAngle() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__BEAM_WIDTH_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeamWidthAngle(double newBeamWidthAngle) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__BEAM_WIDTH_ANGLE, newBeamWidthAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBeamWidthAngleAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__BEAM_WIDTH_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeamWidthAngleAsString(String newBeamWidthAngleAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_SPOT__BEAM_WIDTH_ANGLE_AS_STRING, newBeamWidthAngleAsString);
	}

} //IfcLightSourceSpotImpl
