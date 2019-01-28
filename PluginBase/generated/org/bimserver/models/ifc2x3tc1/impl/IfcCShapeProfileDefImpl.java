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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcCShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc CShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getWidthAsString <em>Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getGirth <em>Girth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getGirthAsString <em>Girth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getInternalFilletRadius <em>Internal Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCShapeProfileDefImpl#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}</li>
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
		return Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDepth() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepth(double newDepth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__DEPTH, newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepthAsString(String newDepthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__DEPTH_AS_STRING, newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWidth() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(double newWidth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__WIDTH, newWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWidthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidthAsString(String newWidthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__WIDTH_AS_STRING, newWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWallThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__WALL_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWallThickness(double newWallThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__WALL_THICKNESS, newWallThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWallThicknessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__WALL_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWallThicknessAsString(String newWallThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__WALL_THICKNESS_AS_STRING, newWallThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGirth() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__GIRTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGirth(double newGirth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__GIRTH, newGirth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGirthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__GIRTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGirthAsString(String newGirthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__GIRTH_AS_STRING, newGirthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInternalFilletRadius() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalFilletRadius(double newInternalFilletRadius) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS, newInternalFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternalFilletRadius() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternalFilletRadius() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInternalFilletRadiusAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalFilletRadiusAsString(String newInternalFilletRadiusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS_AS_STRING,
				newInternalFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternalFilletRadiusAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternalFilletRadiusAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__INTERNAL_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCentreOfGravityInX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInX(double newCentreOfGravityInX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_X, newCentreOfGravityInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInXAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInXAsString(String newCentreOfGravityInXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_XAS_STRING,
				newCentreOfGravityInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CSHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_XAS_STRING);
	}

} //IfcCShapeProfileDefImpl
