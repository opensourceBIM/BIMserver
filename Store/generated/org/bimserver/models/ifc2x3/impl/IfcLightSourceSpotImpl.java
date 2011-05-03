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
import org.bimserver.models.ifc2x3.IfcDirection;
import org.bimserver.models.ifc2x3.IfcLightSourceSpot;

import org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Spot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceSpotImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceSpotImpl#getConcentrationExponent <em>Concentration Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceSpotImpl#getConcentrationExponentAsString <em>Concentration Exponent As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceSpotImpl#getSpreadAngle <em>Spread Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceSpotImpl#getSpreadAngleAsString <em>Spread Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceSpotImpl#getBeamWidthAngle <em>Beam Width Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceSpotImpl#getBeamWidthAngleAsString <em>Beam Width Angle As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLightSourceSpotImpl extends IfcLightSourcePositionalImpl implements IfcLightSourceSpot
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
	protected IfcLightSourceSpotImpl()
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
		return Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getOrientation()
	{
		return (IfcDirection)eGet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__ORIENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientation(IfcDirection newOrientation)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__ORIENTATION, newOrientation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getConcentrationExponent()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcentrationExponent(float newConcentrationExponent)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT, newConcentrationExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConcentrationExponent()
	{
		eUnset(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConcentrationExponent()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConcentrationExponentAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcentrationExponentAsString(String newConcentrationExponentAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT_AS_STRING, newConcentrationExponentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConcentrationExponentAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConcentrationExponentAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__CONCENTRATION_EXPONENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSpreadAngle()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__SPREAD_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpreadAngle(float newSpreadAngle)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__SPREAD_ANGLE, newSpreadAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpreadAngleAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__SPREAD_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpreadAngleAsString(String newSpreadAngleAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__SPREAD_ANGLE_AS_STRING, newSpreadAngleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBeamWidthAngle()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__BEAM_WIDTH_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeamWidthAngle(float newBeamWidthAngle)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__BEAM_WIDTH_ANGLE, newBeamWidthAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBeamWidthAngleAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__BEAM_WIDTH_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeamWidthAngleAsString(String newBeamWidthAngleAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_LIGHT_SOURCE_SPOT__BEAM_WIDTH_ANGLE_AS_STRING, newBeamWidthAngleAsString);
	}

} //IfcLightSourceSpotImpl
