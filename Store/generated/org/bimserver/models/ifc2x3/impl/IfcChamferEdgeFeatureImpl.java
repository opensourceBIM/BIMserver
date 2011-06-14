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
import org.bimserver.models.ifc2x3.IfcChamferEdgeFeature;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Chamfer Edge Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcChamferEdgeFeatureImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcChamferEdgeFeatureImpl#getWidthAsString <em>Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcChamferEdgeFeatureImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcChamferEdgeFeatureImpl#getHeightAsString <em>Height As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcChamferEdgeFeatureImpl extends IfcEdgeFeatureImpl implements IfcChamferEdgeFeature
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcChamferEdgeFeatureImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_Width(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(float newWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_Width(), newWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWidth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_Width());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWidth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_Width());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_WidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidthAsString(String newWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_WidthAsString(), newWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWidthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_WidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWidthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_WidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHeight()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_Height(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(float newHeight)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_Height(), newHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHeight()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_Height());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHeight()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_Height());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeightAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_HeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeightAsString(String newHeightAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_HeightAsString(), newHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHeightAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_HeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHeightAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcChamferEdgeFeature_HeightAsString());
	}

} //IfcChamferEdgeFeatureImpl
