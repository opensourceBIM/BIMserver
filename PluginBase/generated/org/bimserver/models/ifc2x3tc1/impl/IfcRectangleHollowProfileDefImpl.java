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
import org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rectangle Hollow Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangleHollowProfileDefImpl#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangleHollowProfileDefImpl#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangleHollowProfileDefImpl#getInnerFilletRadius <em>Inner Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangleHollowProfileDefImpl#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangleHollowProfileDefImpl#getOuterFilletRadius <em>Outer Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangleHollowProfileDefImpl#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRectangleHollowProfileDefImpl extends IfcRectangleProfileDefImpl
		implements IfcRectangleHollowProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRectangleHollowProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWallThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__WALL_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWallThickness(double newWallThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__WALL_THICKNESS, newWallThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWallThicknessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__WALL_THICKNESS_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWallThicknessAsString(String newWallThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__WALL_THICKNESS_AS_STRING,
				newWallThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInnerFilletRadius() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerFilletRadius(double newInnerFilletRadius) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS, newInnerFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInnerFilletRadius() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInnerFilletRadius() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInnerFilletRadiusAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerFilletRadiusAsString(String newInnerFilletRadiusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS_AS_STRING,
				newInnerFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInnerFilletRadiusAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInnerFilletRadiusAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getOuterFilletRadius() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterFilletRadius(double newOuterFilletRadius) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS, newOuterFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOuterFilletRadius() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOuterFilletRadius() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOuterFilletRadiusAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterFilletRadiusAsString(String newOuterFilletRadiusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS_AS_STRING,
				newOuterFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOuterFilletRadiusAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOuterFilletRadiusAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS_AS_STRING);
	}

} //IfcRectangleHollowProfileDefImpl
