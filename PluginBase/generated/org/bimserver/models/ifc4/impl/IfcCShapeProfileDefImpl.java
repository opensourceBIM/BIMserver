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
package org.bimserver.models.ifc4.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcCShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc CShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getWidthAsString <em>Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getGirth <em>Girth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getGirthAsString <em>Girth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getInternalFilletRadius <em>Internal Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCShapeProfileDefImpl#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcCShapeProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCShapeProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepth(double newDepth) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__DEPTH, newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthAsString(String newDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__DEPTH_AS_STRING, newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(double newWidth) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__WIDTH, newWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidthAsString(String newWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__WIDTH_AS_STRING, newWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWallThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__WALL_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWallThickness(double newWallThickness) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__WALL_THICKNESS, newWallThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWallThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__WALL_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWallThicknessAsString(String newWallThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__WALL_THICKNESS_AS_STRING, newWallThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getGirth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__GIRTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGirth(double newGirth) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__GIRTH, newGirth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGirthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__GIRTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGirthAsString(String newGirthAsString) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__GIRTH_AS_STRING, newGirthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getInternalFilletRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInternalFilletRadius(double newInternalFilletRadius) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS, newInternalFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInternalFilletRadius() {
		eUnset(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInternalFilletRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInternalFilletRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInternalFilletRadiusAsString(String newInternalFilletRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS_AS_STRING, newInternalFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInternalFilletRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInternalFilletRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS_AS_STRING);
	}

} //IfcCShapeProfileDefImpl
