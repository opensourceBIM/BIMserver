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
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Light Intensity Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightIntensityDistribution#getLightDistributionCurve <em>Light Distribution Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightIntensityDistribution#getDistributionData <em>Distribution Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightIntensityDistribution()
 * @model
 * @generated
 */
public interface IfcLightIntensityDistribution extends IfcLightDistributionDataSourceSelect
{
	/**
	 * Returns the value of the '<em><b>Light Distribution Curve</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcLightDistributionCurveEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Light Distribution Curve</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Light Distribution Curve</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLightDistributionCurveEnum
	 * @see #setLightDistributionCurve(IfcLightDistributionCurveEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightIntensityDistribution_LightDistributionCurve()
	 * @model
	 * @generated
	 */
	IfcLightDistributionCurveEnum getLightDistributionCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightIntensityDistribution#getLightDistributionCurve <em>Light Distribution Curve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Light Distribution Curve</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLightDistributionCurveEnum
	 * @see #getLightDistributionCurve()
	 * @generated
	 */
	void setLightDistributionCurve(IfcLightDistributionCurveEnum value);

	/**
	 * Returns the value of the '<em><b>Distribution Data</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcLightDistributionData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distribution Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distribution Data</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightIntensityDistribution_DistributionData()
	 * @model
	 * @generated
	 */
	EList<IfcLightDistributionData> getDistributionData();

} // IfcLightIntensityDistribution
