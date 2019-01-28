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
import org.bimserver.models.ifc2x3tc1.IfcEllipseProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Ellipse Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcEllipseProfileDefImpl#getSemiAxis1 <em>Semi Axis1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcEllipseProfileDefImpl#getSemiAxis1AsString <em>Semi Axis1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcEllipseProfileDefImpl#getSemiAxis2 <em>Semi Axis2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcEllipseProfileDefImpl#getSemiAxis2AsString <em>Semi Axis2 As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcEllipseProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcEllipseProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEllipseProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSemiAxis1() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF__SEMI_AXIS1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis1(double newSemiAxis1) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF__SEMI_AXIS1, newSemiAxis1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemiAxis1AsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF__SEMI_AXIS1_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis1AsString(String newSemiAxis1AsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF__SEMI_AXIS1_AS_STRING, newSemiAxis1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSemiAxis2() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF__SEMI_AXIS2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis2(double newSemiAxis2) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF__SEMI_AXIS2, newSemiAxis2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemiAxis2AsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF__SEMI_AXIS2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis2AsString(String newSemiAxis2AsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELLIPSE_PROFILE_DEF__SEMI_AXIS2_AS_STRING, newSemiAxis2AsString);
	}

} //IfcEllipseProfileDefImpl
