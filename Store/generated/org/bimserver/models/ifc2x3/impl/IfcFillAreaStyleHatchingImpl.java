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
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcCurveStyle;
import org.bimserver.models.ifc2x3.IfcFillAreaStyleHatching;
import org.bimserver.models.ifc2x3.IfcHatchLineDistanceSelect;

import org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationItemImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fill Area Style Hatching</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleHatchingImpl#getHatchLineAppearance <em>Hatch Line Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleHatchingImpl#getStartOfNextHatchLine <em>Start Of Next Hatch Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleHatchingImpl#getPointOfReferenceHatchLine <em>Point Of Reference Hatch Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleHatchingImpl#getPatternStart <em>Pattern Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleHatchingImpl#getHatchLineAngle <em>Hatch Line Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleHatchingImpl#getHatchLineAngleAsString <em>Hatch Line Angle As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFillAreaStyleHatchingImpl extends IfcGeometricRepresentationItemImpl implements IfcFillAreaStyleHatching
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
	protected IfcFillAreaStyleHatchingImpl()
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
		return Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveStyle getHatchLineAppearance()
	{
		return (IfcCurveStyle)eGet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_APPEARANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAppearance(IfcCurveStyle newHatchLineAppearance)
	{
		eSet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_APPEARANCE, newHatchLineAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHatchLineDistanceSelect getStartOfNextHatchLine()
	{
		return (IfcHatchLineDistanceSelect)eGet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__START_OF_NEXT_HATCH_LINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartOfNextHatchLine(IfcHatchLineDistanceSelect newStartOfNextHatchLine)
	{
		eSet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__START_OF_NEXT_HATCH_LINE, newStartOfNextHatchLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPointOfReferenceHatchLine()
	{
		return (IfcCartesianPoint)eGet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__POINT_OF_REFERENCE_HATCH_LINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointOfReferenceHatchLine(IfcCartesianPoint newPointOfReferenceHatchLine)
	{
		eSet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__POINT_OF_REFERENCE_HATCH_LINE, newPointOfReferenceHatchLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPointOfReferenceHatchLine()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__POINT_OF_REFERENCE_HATCH_LINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPointOfReferenceHatchLine()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__POINT_OF_REFERENCE_HATCH_LINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPatternStart()
	{
		return (IfcCartesianPoint)eGet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__PATTERN_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternStart(IfcCartesianPoint newPatternStart)
	{
		eSet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__PATTERN_START, newPatternStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPatternStart()
	{
		eUnset(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__PATTERN_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPatternStart()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__PATTERN_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHatchLineAngle()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAngle(float newHatchLineAngle)
	{
		eSet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_ANGLE, newHatchLineAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHatchLineAngleAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAngleAsString(String newHatchLineAngleAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_ANGLE_AS_STRING, newHatchLineAngleAsString);
	}

} //IfcFillAreaStyleHatchingImpl
