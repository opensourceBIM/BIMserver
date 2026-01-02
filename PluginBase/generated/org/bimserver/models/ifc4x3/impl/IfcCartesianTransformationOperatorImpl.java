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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcCartesianPoint;
import org.bimserver.models.ifc4x3.IfcCartesianTransformationOperator;
import org.bimserver.models.ifc4x3.IfcDirection;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Transformation Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianTransformationOperatorImpl#getAxis1 <em>Axis1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianTransformationOperatorImpl#getAxis2 <em>Axis2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianTransformationOperatorImpl#getLocalOrigin <em>Local Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianTransformationOperatorImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianTransformationOperatorImpl#getScaleAsString <em>Scale As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianTransformationOperatorImpl#getDim <em>Dim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianTransformationOperatorImpl#getScl <em>Scl</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCartesianTransformationOperatorImpl#getSclAsString <em>Scl As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCartesianTransformationOperatorImpl extends IfcGeometricRepresentationItemImpl
		implements IfcCartesianTransformationOperator {
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
		return Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection getAxis1() {
		return (IfcDirection) eGet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxis1(IfcDirection newAxis1) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1(), newAxis1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAxis1() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAxis1() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection getAxis2() {
		return (IfcDirection) eGet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxis2(IfcDirection newAxis2) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2(), newAxis2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAxis2() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAxis2() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPoint getLocalOrigin() {
		return (IfcCartesianPoint) eGet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_LocalOrigin(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocalOrigin(IfcCartesianPoint newLocalOrigin) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_LocalOrigin(), newLocalOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScale() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scale(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale(double newScale) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scale(), newScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScale() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scale());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScale() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scale());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScaleAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_ScaleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScaleAsString(String newScaleAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_ScaleAsString(), newScaleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScaleAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_ScaleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScaleAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_ScaleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDim() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDim(long newDim) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Dim(), newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDim() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Dim());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDim() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Dim());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScl() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scl(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScl(double newScl) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scl(), newScl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScl() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScl() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSclAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_SclAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSclAsString(String newSclAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_SclAsString(), newSclAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSclAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_SclAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSclAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcCartesianTransformationOperator_SclAsString());
	}

} //IfcCartesianTransformationOperatorImpl
