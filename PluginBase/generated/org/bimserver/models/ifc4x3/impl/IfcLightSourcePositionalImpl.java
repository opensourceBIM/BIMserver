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
import org.bimserver.models.ifc4x3.IfcCartesianPoint;
import org.bimserver.models.ifc4x3.IfcLightSourcePositional;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Positional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getRadiusAsString <em>Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getConstantAttenuation <em>Constant Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getDistanceAttenuation <em>Distance Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getQuadricAttenuation <em>Quadric Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourcePositionalImpl#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPoint getPosition() {
		return (IfcCartesianPoint) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_Position(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPosition(IfcCartesianPoint newPosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_Position(), newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_Radius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRadius(double newRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_Radius(), newRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_RadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRadiusAsString(String newRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_RadiusAsString(), newRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getConstantAttenuation() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_ConstantAttenuation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantAttenuation(double newConstantAttenuation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_ConstantAttenuation(), newConstantAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConstantAttenuationAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_ConstantAttenuationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantAttenuationAsString(String newConstantAttenuationAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_ConstantAttenuationAsString(),
				newConstantAttenuationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDistanceAttenuation() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_DistanceAttenuation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistanceAttenuation(double newDistanceAttenuation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_DistanceAttenuation(), newDistanceAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDistanceAttenuationAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_DistanceAttenuationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistanceAttenuationAsString(String newDistanceAttenuationAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_DistanceAttenuationAsString(),
				newDistanceAttenuationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getQuadricAttenuation() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_QuadricAttenuation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuadricAttenuation(double newQuadricAttenuation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_QuadricAttenuation(), newQuadricAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQuadricAttenuationAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_QuadricAttenuationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuadricAttenuationAsString(String newQuadricAttenuationAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSourcePositional_QuadricAttenuationAsString(),
				newQuadricAttenuationAsString);
	}

} //IfcLightSourcePositionalImpl
