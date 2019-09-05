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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcLightDistributionData;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Distribution Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLightDistributionDataImpl#getMainPlaneAngle <em>Main Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLightDistributionDataImpl#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLightDistributionDataImpl#getSecondaryPlaneAngle <em>Secondary Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLightDistributionDataImpl#getSecondaryPlaneAngleAsString <em>Secondary Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLightDistributionDataImpl#getLuminousIntensity <em>Luminous Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLightDistributionDataImpl#getLuminousIntensityAsString <em>Luminous Intensity As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLightDistributionDataImpl extends IdEObjectImpl implements IfcLightDistributionData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightDistributionDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA;
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
	@Override
	public double getMainPlaneAngle() {
		return (Double) eGet(Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__MAIN_PLANE_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMainPlaneAngle(double newMainPlaneAngle) {
		eSet(Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__MAIN_PLANE_ANGLE, newMainPlaneAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMainPlaneAngleAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__MAIN_PLANE_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMainPlaneAngleAsString(String newMainPlaneAngleAsString) {
		eSet(Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__MAIN_PLANE_ANGLE_AS_STRING, newMainPlaneAngleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getSecondaryPlaneAngle() {
		return (EList<Double>) eGet(Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__SECONDARY_PLANE_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getSecondaryPlaneAngleAsString() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__SECONDARY_PLANE_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getLuminousIntensity() {
		return (EList<Double>) eGet(Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__LUMINOUS_INTENSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getLuminousIntensityAsString() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__LUMINOUS_INTENSITY_AS_STRING, true);
	}

} //IfcLightDistributionDataImpl
