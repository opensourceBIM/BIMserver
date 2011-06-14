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
import org.bimserver.models.ifc2x3.IfcZShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc ZShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getFlangeWidth <em>Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getFlangeWidthAsString <em>Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getEdgeRadius <em>Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl#getEdgeRadiusAsString <em>Edge Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcZShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcZShapeProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcZShapeProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_Depth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepth(float newDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_Depth(), newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_DepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepthAsString(String newDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_DepthAsString(), newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFlangeWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeWidth(float newFlangeWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeWidth(), newFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlangeWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeWidthAsString(String newFlangeWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeWidthAsString(), newFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWebThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_WebThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebThickness(float newWebThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_WebThickness(), newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWebThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_WebThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebThicknessAsString(String newWebThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_WebThicknessAsString(), newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFlangeThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeThickness(float newFlangeThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeThickness(), newFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlangeThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeThicknessAsString(String newFlangeThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeThicknessAsString(), newFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFilletRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilletRadius(float newFilletRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadius(), newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilletRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilletRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilletRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilletRadiusAsString(String newFilletRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadiusAsString(), newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilletRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilletRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getEdgeRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeRadius(float newEdgeRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadius(), newEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEdgeRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEdgeRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEdgeRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeRadiusAsString(String newEdgeRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadiusAsString(), newEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEdgeRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEdgeRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadiusAsString());
	}

} //IfcZShapeProfileDefImpl
