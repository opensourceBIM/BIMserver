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
import org.bimserver.models.ifc2x3.IfcTShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc TShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFlangeWidth <em>Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFlangeWidthAsString <em>Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFlangeEdgeRadius <em>Flange Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getWebEdgeRadius <em>Web Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getWebEdgeRadiusAsString <em>Web Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getWebSlope <em>Web Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getWebSlopeAsString <em>Web Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFlangeSlope <em>Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getFlangeSlopeAsString <em>Flange Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcTShapeProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTShapeProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_Depth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepth(float newDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_Depth(), newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_DepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepthAsString(String newDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_DepthAsString(), newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFlangeWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeWidth(float newFlangeWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeWidth(), newFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlangeWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeWidthAsString(String newFlangeWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeWidthAsString(), newFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWebThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebThickness(float newWebThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebThickness(), newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWebThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebThicknessAsString(String newWebThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebThicknessAsString(), newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFlangeThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeThickness(float newFlangeThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeThickness(), newFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlangeThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeThicknessAsString(String newFlangeThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeThicknessAsString(), newFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFilletRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilletRadius(float newFilletRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FilletRadius(), newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilletRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilletRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilletRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilletRadiusAsString(String newFilletRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FilletRadiusAsString(), newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilletRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilletRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFlangeEdgeRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeEdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeEdgeRadius(float newFlangeEdgeRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeEdgeRadius(), newFlangeEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlangeEdgeRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlangeEdgeRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlangeEdgeRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeEdgeRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeEdgeRadiusAsString(String newFlangeEdgeRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeEdgeRadiusAsString(), newFlangeEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlangeEdgeRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlangeEdgeRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWebEdgeRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebEdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebEdgeRadius(float newWebEdgeRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebEdgeRadius(), newWebEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWebEdgeRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWebEdgeRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWebEdgeRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebEdgeRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebEdgeRadiusAsString(String newWebEdgeRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebEdgeRadiusAsString(), newWebEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWebEdgeRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWebEdgeRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWebSlope()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebSlope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebSlope(float newWebSlope)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebSlope(), newWebSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWebSlope()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWebSlope()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWebSlopeAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebSlopeAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebSlopeAsString(String newWebSlopeAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebSlopeAsString(), newWebSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWebSlopeAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWebSlopeAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_WebSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFlangeSlope()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeSlope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeSlope(float newFlangeSlope)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeSlope(), newFlangeSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlangeSlope()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlangeSlope()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlangeSlopeAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeSlopeAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeSlopeAsString(String newFlangeSlopeAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeSlopeAsString(), newFlangeSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlangeSlopeAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlangeSlopeAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_FlangeSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_CentreOfGravityInY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInY(float newCentreOfGravityInY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_CentreOfGravityInY(), newCentreOfGravityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_CentreOfGravityInYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInYAsString(String newCentreOfGravityInYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_CentreOfGravityInYAsString(), newCentreOfGravityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_CentreOfGravityInYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTShapeProfileDef_CentreOfGravityInYAsString());
	}

} //IfcTShapeProfileDefImpl
