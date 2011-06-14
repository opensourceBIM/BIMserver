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

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEdgeFeature;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Edge Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeFeatureImpl#getFeatureLength <em>Feature Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeFeatureImpl#getFeatureLengthAsString <em>Feature Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEdgeFeatureImpl extends IfcFeatureElementSubtractionImpl implements IfcEdgeFeature
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEdgeFeatureImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcEdgeFeature();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFeatureLength()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureLength(float newFeatureLength)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLength(), newFeatureLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFeatureLength()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFeatureLength()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureLengthAsString(String newFeatureLengthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLengthAsString(), newFeatureLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFeatureLengthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFeatureLengthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLengthAsString());
	}

} //IfcEdgeFeatureImpl
