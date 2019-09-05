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
import org.bimserver.models.ifc4.IfcRoundedRectangleProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rounded Rectangle Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRoundedRectangleProfileDefImpl#getRoundingRadius <em>Rounding Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRoundedRectangleProfileDefImpl#getRoundingRadiusAsString <em>Rounding Radius As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRoundedRectangleProfileDefImpl extends IfcRectangleProfileDefImpl implements IfcRoundedRectangleProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRoundedRectangleProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_ROUNDED_RECTANGLE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRoundingRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ROUNDED_RECTANGLE_PROFILE_DEF__ROUNDING_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRoundingRadius(double newRoundingRadius) {
		eSet(Ifc4Package.Literals.IFC_ROUNDED_RECTANGLE_PROFILE_DEF__ROUNDING_RADIUS, newRoundingRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRoundingRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ROUNDED_RECTANGLE_PROFILE_DEF__ROUNDING_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRoundingRadiusAsString(String newRoundingRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_ROUNDED_RECTANGLE_PROFILE_DEF__ROUNDING_RADIUS_AS_STRING, newRoundingRadiusAsString);
	}

} //IfcRoundedRectangleProfileDefImpl
