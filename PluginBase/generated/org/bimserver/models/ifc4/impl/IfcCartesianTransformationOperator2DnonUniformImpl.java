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
import org.bimserver.models.ifc4.IfcCartesianTransformationOperator2DnonUniform;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Transformation Operator2 Dnon Uniform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperator2DnonUniformImpl#getScale2 <em>Scale2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperator2DnonUniformImpl#getScale2AsString <em>Scale2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperator2DnonUniformImpl#getScl2 <em>Scl2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperator2DnonUniformImpl#getScl2AsString <em>Scl2 As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCartesianTransformationOperator2DnonUniformImpl extends IfcCartesianTransformationOperator2DImpl implements IfcCartesianTransformationOperator2DnonUniform {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCartesianTransformationOperator2DnonUniformImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScale2() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCALE2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale2(double newScale2) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCALE2, newScale2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScale2() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCALE2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScale2() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCALE2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScale2AsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCALE2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale2AsString(String newScale2AsString) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCALE2_AS_STRING, newScale2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScale2AsString() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCALE2_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScale2AsString() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCALE2_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScl2() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCL2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScl2(double newScl2) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCL2, newScl2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScl2() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCL2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScl2() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCL2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScl2AsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCL2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScl2AsString(String newScl2AsString) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCL2_AS_STRING, newScl2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScl2AsString() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCL2_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScl2AsString() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM__SCL2_AS_STRING);
	}

} //IfcCartesianTransformationOperator2DnonUniformImpl
