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
import org.bimserver.models.ifc2x3.IfcAsymmetricIShapeProfileDef;

import org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asymmetric IShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidth <em>Top Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidthAsString <em>Top Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThickness <em>Top Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThicknessAsString <em>Top Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadius <em>Top Flange Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadiusAsString <em>Top Flange Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAsymmetricIShapeProfileDefImpl extends IfcIShapeProfileDefImpl implements IfcAsymmetricIShapeProfileDef
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
	protected IfcAsymmetricIShapeProfileDefImpl()
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
		return Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopFlangeWidth()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeWidth(float newTopFlangeWidth)
	{
		eSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH, newTopFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeWidthAsString(String newTopFlangeWidthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH_AS_STRING, newTopFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopFlangeThickness()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeThickness(float newTopFlangeThickness)
	{
		eSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS, newTopFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeThickness()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeThickness()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeThicknessAsString(String newTopFlangeThicknessAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING, newTopFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeThicknessAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopFlangeFilletRadius()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeFilletRadius(float newTopFlangeFilletRadius)
	{
		eSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS, newTopFlangeFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeFilletRadius()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeFilletRadius()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeFilletRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeFilletRadiusAsString(String newTopFlangeFilletRadiusAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING, newTopFlangeFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeFilletRadiusAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeFilletRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInY()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInY(float newCentreOfGravityInY)
	{
		eSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_Y, newCentreOfGravityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInY()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInY()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInYAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInYAsString(String newCentreOfGravityInYAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_YAS_STRING, newCentreOfGravityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInYAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInYAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_YAS_STRING);
	}

} //IfcAsymmetricIShapeProfileDefImpl
