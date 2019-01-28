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
import org.bimserver.models.ifc2x3tc1.IfcAxis1Placement;
import org.bimserver.models.ifc2x3tc1.IfcRevolvedAreaSolid;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Revolved Area Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRevolvedAreaSolidImpl#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRevolvedAreaSolidImpl#getAngle <em>Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRevolvedAreaSolidImpl#getAngleAsString <em>Angle As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRevolvedAreaSolidImpl extends IfcSweptAreaSolidImpl implements IfcRevolvedAreaSolid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRevolvedAreaSolidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_REVOLVED_AREA_SOLID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis1Placement getAxis() {
		return (IfcAxis1Placement) eGet(Ifc2x3tc1Package.Literals.IFC_REVOLVED_AREA_SOLID__AXIS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxis(IfcAxis1Placement newAxis) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REVOLVED_AREA_SOLID__AXIS, newAxis);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAngle() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_REVOLVED_AREA_SOLID__ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngle(double newAngle) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REVOLVED_AREA_SOLID__ANGLE, newAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAngleAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_REVOLVED_AREA_SOLID__ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngleAsString(String newAngleAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_REVOLVED_AREA_SOLID__ANGLE_AS_STRING, newAngleAsString);
	}

} //IfcRevolvedAreaSolidImpl
