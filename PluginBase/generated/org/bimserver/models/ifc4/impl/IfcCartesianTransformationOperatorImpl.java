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
import org.bimserver.models.ifc4.IfcCartesianPoint;
import org.bimserver.models.ifc4.IfcCartesianTransformationOperator;
import org.bimserver.models.ifc4.IfcDirection;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Transformation Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperatorImpl#getAxis1 <em>Axis1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperatorImpl#getAxis2 <em>Axis2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperatorImpl#getLocalOrigin <em>Local Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperatorImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperatorImpl#getScaleAsString <em>Scale As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperatorImpl#getDim <em>Dim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperatorImpl#getScl <em>Scl</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCartesianTransformationOperatorImpl#getSclAsString <em>Scl As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCartesianTransformationOperatorImpl extends IfcGeometricRepresentationItemImpl implements IfcCartesianTransformationOperator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCartesianTransformationOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection getAxis1() {
		return (IfcDirection) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__AXIS1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxis1(IfcDirection newAxis1) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__AXIS1, newAxis1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAxis1() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__AXIS1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAxis1() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__AXIS1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection getAxis2() {
		return (IfcDirection) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__AXIS2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxis2(IfcDirection newAxis2) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__AXIS2, newAxis2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAxis2() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__AXIS2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAxis2() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__AXIS2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPoint getLocalOrigin() {
		return (IfcCartesianPoint) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__LOCAL_ORIGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocalOrigin(IfcCartesianPoint newLocalOrigin) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__LOCAL_ORIGIN, newLocalOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScale() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCALE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale(double newScale) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCALE, newScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScale() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCALE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScale() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCALE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScaleAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCALE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScaleAsString(String newScaleAsString) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCALE_AS_STRING, newScaleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScaleAsString() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCALE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScaleAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCALE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDim() {
		return (Long) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDim(long newDim) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__DIM, newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDim() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__DIM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDim() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__DIM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScl() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScl(double newScl) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCL, newScl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScl() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScl() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSclAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCL_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSclAsString(String newSclAsString) {
		eSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCL_AS_STRING, newSclAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSclAsString() {
		eUnset(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSclAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_CARTESIAN_TRANSFORMATION_OPERATOR__SCL_AS_STRING);
	}

} //IfcCartesianTransformationOperatorImpl
