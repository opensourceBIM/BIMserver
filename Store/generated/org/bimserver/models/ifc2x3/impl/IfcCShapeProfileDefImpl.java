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
import org.bimserver.models.ifc2x3.IfcCShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc CShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getWidthAsString <em>Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getGirth <em>Girth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getGirthAsString <em>Girth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getInternalFilletRadius <em>Internal Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcCShapeProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCShapeProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_Depth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepth(float newDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_Depth(), newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_DepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepthAsString(String newDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_DepthAsString(), newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_Width(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(float newWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_Width(), newWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_WidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidthAsString(String newWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_WidthAsString(), newWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWallThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_WallThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWallThickness(float newWallThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_WallThickness(), newWallThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWallThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_WallThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWallThicknessAsString(String newWallThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_WallThicknessAsString(), newWallThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getGirth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_Girth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGirth(float newGirth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_Girth(), newGirth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGirthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_GirthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGirthAsString(String newGirthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_GirthAsString(), newGirthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInternalFilletRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_InternalFilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalFilletRadius(float newInternalFilletRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_InternalFilletRadius(), newInternalFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternalFilletRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_InternalFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternalFilletRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_InternalFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInternalFilletRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_InternalFilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalFilletRadiusAsString(String newInternalFilletRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_InternalFilletRadiusAsString(), newInternalFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternalFilletRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_InternalFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternalFilletRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_InternalFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_CentreOfGravityInX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInX(float newCentreOfGravityInX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_CentreOfGravityInX(), newCentreOfGravityInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_CentreOfGravityInX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_CentreOfGravityInX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_CentreOfGravityInXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInXAsString(String newCentreOfGravityInXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_CentreOfGravityInXAsString(), newCentreOfGravityInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_CentreOfGravityInXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCShapeProfileDef_CentreOfGravityInXAsString());
	}

} //IfcCShapeProfileDefImpl
