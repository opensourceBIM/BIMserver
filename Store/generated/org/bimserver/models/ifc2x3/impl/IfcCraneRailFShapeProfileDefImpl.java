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
import org.bimserver.models.ifc2x3.IfcCraneRailFShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Crane Rail FShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getOverallHeight <em>Overall Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getOverallHeightAsString <em>Overall Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getHeadWidth <em>Head Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getHeadWidthAsString <em>Head Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getRadiusAsString <em>Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getHeadDepth2 <em>Head Depth2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getHeadDepth2AsString <em>Head Depth2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getHeadDepth3 <em>Head Depth3</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getHeadDepth3AsString <em>Head Depth3 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getBaseDepth1 <em>Base Depth1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getBaseDepth1AsString <em>Base Depth1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getBaseDepth2 <em>Base Depth2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getBaseDepth2AsString <em>Base Depth2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCraneRailFShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcCraneRailFShapeProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCraneRailFShapeProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOverallHeight()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_OverallHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallHeight(float newOverallHeight)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_OverallHeight(), newOverallHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallHeightAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_OverallHeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallHeightAsString(String newOverallHeightAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_OverallHeightAsString(), newOverallHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHeadWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadWidth(float newHeadWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadWidth(), newHeadWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeadWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadWidthAsString(String newHeadWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadWidthAsString(), newHeadWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_Radius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadius(float newRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_Radius(), newRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_Radius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_Radius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_RadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadiusAsString(String newRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_RadiusAsString(), newRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_RadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_RadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHeadDepth2()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadDepth2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadDepth2(float newHeadDepth2)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadDepth2(), newHeadDepth2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeadDepth2AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadDepth2AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadDepth2AsString(String newHeadDepth2AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadDepth2AsString(), newHeadDepth2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHeadDepth3()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadDepth3(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadDepth3(float newHeadDepth3)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadDepth3(), newHeadDepth3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeadDepth3AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadDepth3AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadDepth3AsString(String newHeadDepth3AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_HeadDepth3AsString(), newHeadDepth3AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWebThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_WebThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebThickness(float newWebThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_WebThickness(), newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWebThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_WebThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebThicknessAsString(String newWebThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_WebThicknessAsString(), newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBaseDepth1()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_BaseDepth1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseDepth1(float newBaseDepth1)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_BaseDepth1(), newBaseDepth1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseDepth1AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_BaseDepth1AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseDepth1AsString(String newBaseDepth1AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_BaseDepth1AsString(), newBaseDepth1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBaseDepth2()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_BaseDepth2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseDepth2(float newBaseDepth2)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_BaseDepth2(), newBaseDepth2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseDepth2AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_BaseDepth2AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseDepth2AsString(String newBaseDepth2AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_BaseDepth2AsString(), newBaseDepth2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_CentreOfGravityInY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInY(float newCentreOfGravityInY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_CentreOfGravityInY(), newCentreOfGravityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_CentreOfGravityInYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInYAsString(String newCentreOfGravityInYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_CentreOfGravityInYAsString(), newCentreOfGravityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_CentreOfGravityInYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCraneRailFShapeProfileDef_CentreOfGravityInYAsString());
	}

} //IfcCraneRailFShapeProfileDefImpl
