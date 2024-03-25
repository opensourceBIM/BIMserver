/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcCartesianPoint;
import org.bimserver.models.ifc4x3.IfcOpenCrossProfileDef;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Open Cross Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOpenCrossProfileDefImpl#getHorizontalWidths <em>Horizontal Widths</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOpenCrossProfileDefImpl#getWidths <em>Widths</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOpenCrossProfileDefImpl#getWidthsAsString <em>Widths As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOpenCrossProfileDefImpl#getSlopes <em>Slopes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOpenCrossProfileDefImpl#getSlopesAsString <em>Slopes As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOpenCrossProfileDefImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOpenCrossProfileDefImpl#getOffsetPoint <em>Offset Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcOpenCrossProfileDefImpl extends IfcProfileDefImpl implements IfcOpenCrossProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOpenCrossProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getHorizontalWidths() {
		return (Tristate) eGet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__HORIZONTAL_WIDTHS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHorizontalWidths(Tristate newHorizontalWidths) {
		eSet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__HORIZONTAL_WIDTHS, newHorizontalWidths);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getWidths() {
		return (EList<Double>) eGet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__WIDTHS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getWidthsAsString() {
		return (EList<String>) eGet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__WIDTHS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getSlopes() {
		return (EList<Double>) eGet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__SLOPES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getSlopesAsString() {
		return (EList<String>) eGet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__SLOPES_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getTags() {
		return (EList<String>) eGet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__TAGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTags() {
		eUnset(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__TAGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTags() {
		return eIsSet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__TAGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPoint getOffsetPoint() {
		return (IfcCartesianPoint) eGet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__OFFSET_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetPoint(IfcCartesianPoint newOffsetPoint) {
		eSet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__OFFSET_POINT, newOffsetPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOffsetPoint() {
		eUnset(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__OFFSET_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOffsetPoint() {
		return eIsSet(Ifc4x3Package.Literals.IFC_OPEN_CROSS_PROFILE_DEF__OFFSET_POINT);
	}

} //IfcOpenCrossProfileDefImpl
