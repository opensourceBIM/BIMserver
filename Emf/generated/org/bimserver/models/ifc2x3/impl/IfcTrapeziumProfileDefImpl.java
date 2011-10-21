/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Trapezium Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getBottomXDim <em>Bottom XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getBottomXDimAsString <em>Bottom XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getTopXDim <em>Top XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getTopXDimAsString <em>Top XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getYDim <em>YDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getYDimAsString <em>YDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getTopXOffset <em>Top XOffset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getTopXOffsetAsString <em>Top XOffset As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTrapeziumProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcTrapeziumProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTrapeziumProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBottomXDim() {
		return (Float) eGet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__BOTTOM_XDIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomXDim(float newBottomXDim) {
		eSet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__BOTTOM_XDIM, newBottomXDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBottomXDimAsString() {
		return (String) eGet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__BOTTOM_XDIM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomXDimAsString(String newBottomXDimAsString) {
		eSet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__BOTTOM_XDIM_AS_STRING, newBottomXDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopXDim() {
		return (Float) eGet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__TOP_XDIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopXDim(float newTopXDim) {
		eSet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__TOP_XDIM, newTopXDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopXDimAsString() {
		return (String) eGet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__TOP_XDIM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopXDimAsString(String newTopXDimAsString) {
		eSet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__TOP_XDIM_AS_STRING, newTopXDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYDim() {
		return (Float) eGet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__YDIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYDim(float newYDim) {
		eSet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__YDIM, newYDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYDimAsString() {
		return (String) eGet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__YDIM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYDimAsString(String newYDimAsString) {
		eSet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__YDIM_AS_STRING, newYDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopXOffset() {
		return (Float) eGet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__TOP_XOFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopXOffset(float newTopXOffset) {
		eSet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__TOP_XOFFSET, newTopXOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopXOffsetAsString() {
		return (String) eGet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__TOP_XOFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopXOffsetAsString(String newTopXOffsetAsString) {
		eSet(Ifc2x3Package.Literals.IFC_TRAPEZIUM_PROFILE_DEF__TOP_XOFFSET_AS_STRING, newTopXOffsetAsString);
	}

} //IfcTrapeziumProfileDefImpl
