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
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcLightSourcePositional;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Positional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getRadiusAsString <em>Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getConstantAttenuation <em>Constant Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getDistanceAttenuation <em>Distance Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getQuadricAttenuation <em>Quadric Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLightSourcePositionalImpl#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLightSourcePositionalImpl extends IfcLightSourceImpl implements IfcLightSourcePositional {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightSourcePositionalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPosition() {
		return (IfcCartesianPoint) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(IfcCartesianPoint newPosition) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__POSITION, newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRadius() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadius(double newRadius) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__RADIUS, newRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRadiusAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadiusAsString(String newRadiusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__RADIUS_AS_STRING, newRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getConstantAttenuation() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__CONSTANT_ATTENUATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstantAttenuation(double newConstantAttenuation) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__CONSTANT_ATTENUATION, newConstantAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstantAttenuationAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__CONSTANT_ATTENUATION_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstantAttenuationAsString(String newConstantAttenuationAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__CONSTANT_ATTENUATION_AS_STRING,
				newConstantAttenuationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDistanceAttenuation() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__DISTANCE_ATTENUATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistanceAttenuation(double newDistanceAttenuation) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__DISTANCE_ATTENUATION, newDistanceAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistanceAttenuationAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__DISTANCE_ATTENUATION_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistanceAttenuationAsString(String newDistanceAttenuationAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__DISTANCE_ATTENUATION_AS_STRING,
				newDistanceAttenuationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getQuadricAttenuation() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__QUADRIC_ATTENUATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuadricAttenuation(double newQuadricAttenuation) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__QUADRIC_ATTENUATION, newQuadricAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuadricAttenuationAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__QUADRIC_ATTENUATION_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuadricAttenuationAsString(String newQuadricAttenuationAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIGHT_SOURCE_POSITIONAL__QUADRIC_ATTENUATION_AS_STRING,
				newQuadricAttenuationAsString);
	}

} //IfcLightSourcePositionalImpl
