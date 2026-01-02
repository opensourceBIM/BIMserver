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
import org.bimserver.models.ifc4x3.IfcColourRgb;
import org.bimserver.models.ifc4x3.IfcLightSource;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceImpl#getLightColour <em>Light Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceImpl#getAmbientIntensity <em>Ambient Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceImpl#getAmbientIntensityAsString <em>Ambient Intensity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceImpl#getIntensity <em>Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLightSourceImpl#getIntensityAsString <em>Intensity As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLightSourceImpl extends IfcGeometricRepresentationItemImpl implements IfcLightSource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcLightSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSource_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLightSource_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgb getLightColour() {
		return (IfcColourRgb) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSource_LightColour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLightColour(IfcColourRgb newLightColour) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_LightColour(), newLightColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getAmbientIntensity() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSource_AmbientIntensity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAmbientIntensity(double newAmbientIntensity) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_AmbientIntensity(), newAmbientIntensity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAmbientIntensity() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLightSource_AmbientIntensity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAmbientIntensity() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_AmbientIntensity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAmbientIntensityAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSource_AmbientIntensityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAmbientIntensityAsString(String newAmbientIntensityAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_AmbientIntensityAsString(), newAmbientIntensityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAmbientIntensityAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLightSource_AmbientIntensityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAmbientIntensityAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_AmbientIntensityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getIntensity() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSource_Intensity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntensity(double newIntensity) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_Intensity(), newIntensity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIntensity() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLightSource_Intensity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIntensity() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_Intensity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIntensityAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLightSource_IntensityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntensityAsString(String newIntensityAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_IntensityAsString(), newIntensityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIntensityAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLightSource_IntensityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIntensityAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLightSource_IntensityAsString());
	}

} //IfcLightSourceImpl
