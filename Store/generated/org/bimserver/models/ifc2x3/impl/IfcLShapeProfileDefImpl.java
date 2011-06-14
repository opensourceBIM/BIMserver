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
import org.bimserver.models.ifc2x3.IfcLShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc LShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getWidthAsString <em>Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getThicknessAsString <em>Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getEdgeRadius <em>Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getEdgeRadiusAsString <em>Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getLegSlope <em>Leg Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getLegSlopeAsString <em>Leg Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcLShapeProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLShapeProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_Depth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepth(float newDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_Depth(), newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_DepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepthAsString(String newDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_DepthAsString(), newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_Width(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(float newWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_Width(), newWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWidth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_Width());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWidth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_Width());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_WidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidthAsString(String newWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_WidthAsString(), newWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWidthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_WidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWidthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_WidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_Thickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThickness(float newThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_Thickness(), newThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_ThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThicknessAsString(String newThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_ThicknessAsString(), newThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFilletRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_FilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilletRadius(float newFilletRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_FilletRadius(), newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilletRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilletRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilletRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_FilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilletRadiusAsString(String newFilletRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_FilletRadiusAsString(), newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilletRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilletRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getEdgeRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_EdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeRadius(float newEdgeRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_EdgeRadius(), newEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEdgeRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_EdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEdgeRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_EdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEdgeRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_EdgeRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeRadiusAsString(String newEdgeRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_EdgeRadiusAsString(), newEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEdgeRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_EdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEdgeRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_EdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLegSlope()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_LegSlope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLegSlope(float newLegSlope)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_LegSlope(), newLegSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLegSlope()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_LegSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLegSlope()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_LegSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLegSlopeAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_LegSlopeAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLegSlopeAsString(String newLegSlopeAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_LegSlopeAsString(), newLegSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLegSlopeAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_LegSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLegSlopeAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_LegSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInX(float newCentreOfGravityInX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInX(), newCentreOfGravityInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInXAsString(String newCentreOfGravityInXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInXAsString(), newCentreOfGravityInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInY(float newCentreOfGravityInY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInY(), newCentreOfGravityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInYAsString(String newCentreOfGravityInYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInYAsString(), newCentreOfGravityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLShapeProfileDef_CentreOfGravityInYAsString());
	}

} //IfcLShapeProfileDefImpl
