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
import org.bimserver.models.ifc4x3.IfcDirection;
import org.bimserver.models.ifc4x3.IfcLightSourceSpot;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Spot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceSpotImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceSpotImpl#getConcentrationExponent <em>Concentration Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceSpotImpl#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceSpotImpl#getSpreadAngle <em>Spread Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceSpotImpl#getSpreadAngleAsString <em>Spread Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceSpotImpl#getBeamWidthAngle <em>Beam Width Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceSpotImpl#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection getOrientation() {
		return (IfcDirection) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_Orientation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrientation(IfcDirection newOrientation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_Orientation(), newOrientation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getConcentrationExponent() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_ConcentrationExponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConcentrationExponent(double newConcentrationExponent) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_ConcentrationExponent(), newConcentrationExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConcentrationExponent() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_ConcentrationExponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConcentrationExponent() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_ConcentrationExponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConcentrationExponentAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_ConcentrationExponentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConcentrationExponentAsString(String newConcentrationExponentAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_ConcentrationExponentAsString(),
				newConcentrationExponentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConcentrationExponentAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_ConcentrationExponentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConcentrationExponentAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_ConcentrationExponentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSpreadAngle() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_SpreadAngle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpreadAngle(double newSpreadAngle) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_SpreadAngle(), newSpreadAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSpreadAngleAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_SpreadAngleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpreadAngleAsString(String newSpreadAngleAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_SpreadAngleAsString(), newSpreadAngleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBeamWidthAngle() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_BeamWidthAngle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBeamWidthAngle(double newBeamWidthAngle) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_BeamWidthAngle(), newBeamWidthAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBeamWidthAngleAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_BeamWidthAngleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBeamWidthAngleAsString(String newBeamWidthAngleAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourceSpot_BeamWidthAngleAsString(), newBeamWidthAngleAsString);
	}

} //IfcLightSourceSpotImpl
