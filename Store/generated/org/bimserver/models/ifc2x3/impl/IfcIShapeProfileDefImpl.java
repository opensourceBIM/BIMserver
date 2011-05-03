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
import org.bimserver.models.ifc2x3.IfcIShapeProfileDef;

import org.bimserver.models.ifc2x3.impl.IfcParameterizedProfileDefImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc IShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getOverallWidth <em>Overall Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getOverallWidthAsString <em>Overall Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getOverallDepth <em>Overall Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getOverallDepthAsString <em>Overall Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcIShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcIShapeProfileDef
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
	protected IfcIShapeProfileDefImpl()
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
		return Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOverallWidth()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__OVERALL_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallWidth(float newOverallWidth)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__OVERALL_WIDTH, newOverallWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__OVERALL_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallWidthAsString(String newOverallWidthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__OVERALL_WIDTH_AS_STRING, newOverallWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOverallDepth()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__OVERALL_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallDepth(float newOverallDepth)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__OVERALL_DEPTH, newOverallDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverallDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__OVERALL_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverallDepthAsString(String newOverallDepthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__OVERALL_DEPTH_AS_STRING, newOverallDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWebThickness()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__WEB_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebThickness(float newWebThickness)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__WEB_THICKNESS, newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWebThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__WEB_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebThicknessAsString(String newWebThicknessAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__WEB_THICKNESS_AS_STRING, newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFlangeThickness()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FLANGE_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeThickness(float newFlangeThickness)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FLANGE_THICKNESS, newFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlangeThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FLANGE_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlangeThicknessAsString(String newFlangeThicknessAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FLANGE_THICKNESS_AS_STRING, newFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFilletRadius()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilletRadius(float newFilletRadius)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FILLET_RADIUS, newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilletRadius()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilletRadius()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilletRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilletRadiusAsString(String newFilletRadiusAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING, newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFilletRadiusAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFilletRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ISHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING);
	}

} //IfcIShapeProfileDefImpl
