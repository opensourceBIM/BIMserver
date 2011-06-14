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
import org.bimserver.models.ifc2x3.IfcColour;
import org.bimserver.models.ifc2x3.IfcCurveFontOrScaledCurveFontSelect;
import org.bimserver.models.ifc2x3.IfcCurveStyle;
import org.bimserver.models.ifc2x3.IfcSizeSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleImpl#getCurveFont <em>Curve Font</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleImpl#getCurveWidth <em>Curve Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleImpl#getCurveColour <em>Curve Colour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCurveStyleImpl extends IfcPresentationStyleImpl implements IfcCurveStyle
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveStyleImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcCurveStyle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveFontOrScaledCurveFontSelect getCurveFont()
	{
		return (IfcCurveFontOrScaledCurveFontSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveFont(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveFont(IfcCurveFontOrScaledCurveFontSelect newCurveFont)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveFont(), newCurveFont);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveFont()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveFont());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveFont()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveFont());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getCurveWidth()
	{
		return (IfcSizeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveWidth(IfcSizeSelect newCurveWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveWidth(), newCurveWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveWidth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveWidth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColour getCurveColour()
	{
		return (IfcColour)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveColour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveColour(IfcColour newCurveColour)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveColour(), newCurveColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveColour()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveColour());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveColour()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyle_CurveColour());
	}

} //IfcCurveStyleImpl
