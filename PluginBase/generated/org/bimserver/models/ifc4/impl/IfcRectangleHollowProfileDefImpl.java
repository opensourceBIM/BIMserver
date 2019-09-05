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
import org.bimserver.models.ifc4.IfcRectangleHollowProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rectangle Hollow Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRectangleHollowProfileDefImpl#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRectangleHollowProfileDefImpl#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRectangleHollowProfileDefImpl#getInnerFilletRadius <em>Inner Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRectangleHollowProfileDefImpl#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRectangleHollowProfileDefImpl#getOuterFilletRadius <em>Outer Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRectangleHollowProfileDefImpl#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRectangleHollowProfileDefImpl extends IfcRectangleProfileDefImpl implements IfcRectangleHollowProfileDef {
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
		return Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWallThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__WALL_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWallThickness(double newWallThickness) {
		eSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__WALL_THICKNESS, newWallThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWallThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__WALL_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWallThicknessAsString(String newWallThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__WALL_THICKNESS_AS_STRING, newWallThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getInnerFilletRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInnerFilletRadius(double newInnerFilletRadius) {
		eSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS, newInnerFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInnerFilletRadius() {
		eUnset(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInnerFilletRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInnerFilletRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInnerFilletRadiusAsString(String newInnerFilletRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS_AS_STRING, newInnerFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInnerFilletRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInnerFilletRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__INNER_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOuterFilletRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOuterFilletRadius(double newOuterFilletRadius) {
		eSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS, newOuterFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOuterFilletRadius() {
		eUnset(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOuterFilletRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOuterFilletRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOuterFilletRadiusAsString(String newOuterFilletRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS_AS_STRING, newOuterFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOuterFilletRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOuterFilletRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_RECTANGLE_HOLLOW_PROFILE_DEF__OUTER_FILLET_RADIUS_AS_STRING);
	}

} //IfcRectangleHollowProfileDefImpl
