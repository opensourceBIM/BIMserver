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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style Font Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl#getVisibleSegmentLength <em>Visible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl#getVisibleSegmentLengthAsString <em>Visible Segment Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl#getInvisibleSegmentLength <em>Invisible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl#getInvisibleSegmentLengthAsString <em>Invisible Segment Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCurveStyleFontPatternImpl extends IdEObjectImpl implements IfcCurveStyleFontPattern
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveStyleFontPatternImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVisibleSegmentLength()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_VisibleSegmentLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleSegmentLength(float newVisibleSegmentLength)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_VisibleSegmentLength(), newVisibleSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleSegmentLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_VisibleSegmentLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleSegmentLengthAsString(String newVisibleSegmentLengthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_VisibleSegmentLengthAsString(), newVisibleSegmentLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInvisibleSegmentLength()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_InvisibleSegmentLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvisibleSegmentLength(float newInvisibleSegmentLength)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_InvisibleSegmentLength(), newInvisibleSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInvisibleSegmentLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_InvisibleSegmentLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvisibleSegmentLengthAsString(String newInvisibleSegmentLengthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCurveStyleFontPattern_InvisibleSegmentLengthAsString(), newInvisibleSegmentLengthAsString);
	}

} //IfcCurveStyleFontPatternImpl
