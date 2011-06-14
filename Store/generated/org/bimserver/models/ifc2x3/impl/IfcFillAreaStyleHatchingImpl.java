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
		return Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveStyle getHatchLineAppearance()
	{
		return (IfcCurveStyle)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_HatchLineAppearance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAppearance(IfcCurveStyle newHatchLineAppearance)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_HatchLineAppearance(), newHatchLineAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHatchLineDistanceSelect getStartOfNextHatchLine()
	{
		return (IfcHatchLineDistanceSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_StartOfNextHatchLine(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartOfNextHatchLine(IfcHatchLineDistanceSelect newStartOfNextHatchLine)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_StartOfNextHatchLine(), newStartOfNextHatchLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPointOfReferenceHatchLine()
	{
		return (IfcCartesianPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_PointOfReferenceHatchLine(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointOfReferenceHatchLine(IfcCartesianPoint newPointOfReferenceHatchLine)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_PointOfReferenceHatchLine(), newPointOfReferenceHatchLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPointOfReferenceHatchLine()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_PointOfReferenceHatchLine());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPointOfReferenceHatchLine()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_PointOfReferenceHatchLine());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPatternStart()
	{
		return (IfcCartesianPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_PatternStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternStart(IfcCartesianPoint newPatternStart)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_PatternStart(), newPatternStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPatternStart()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_PatternStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPatternStart()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_PatternStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHatchLineAngle()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_HatchLineAngle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAngle(float newHatchLineAngle)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_HatchLineAngle(), newHatchLineAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHatchLineAngleAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_HatchLineAngleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAngleAsString(String newHatchLineAngleAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleHatching_HatchLineAngleAsString(), newHatchLineAngleAsString);
	}

} //IfcFillAreaStyleHatchingImpl
