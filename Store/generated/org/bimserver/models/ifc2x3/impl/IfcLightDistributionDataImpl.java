/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcLightDistributionData;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Distribution Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getMainPlaneAngle <em>Main Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getMainPlaneAngleAsString <em>Main Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getSecondaryPlaneAngle <em>Secondary Plane Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getSecondaryPlaneAngleAsString <em>Secondary Plane Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getLuminousIntensity <em>Luminous Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl#getLuminousIntensityAsString <em>Luminous Intensity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLightDistributionDataImpl extends IdEObjectImpl implements IfcLightDistributionData
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightDistributionDataImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMainPlaneAngle()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__MAIN_PLANE_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainPlaneAngle(float newMainPlaneAngle)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__MAIN_PLANE_ANGLE, newMainPlaneAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMainPlaneAngleAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__MAIN_PLANE_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainPlaneAngleAsString(String newMainPlaneAngleAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__MAIN_PLANE_ANGLE_AS_STRING, newMainPlaneAngleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Float> getSecondaryPlaneAngle()
	{
		return (EList<Float>)eGet(Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__SECONDARY_PLANE_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getSecondaryPlaneAngleAsString()
	{
		return (EList<String>)eGet(Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__SECONDARY_PLANE_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Float> getLuminousIntensity()
	{
		return (EList<Float>)eGet(Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__LUMINOUS_INTENSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getLuminousIntensityAsString()
	{
		return (EList<String>)eGet(Ifc2x3Package.Literals.IFC_LIGHT_DISTRIBUTION_DATA__LUMINOUS_INTENSITY_AS_STRING, true);
	}

} //IfcLightDistributionDataImpl
