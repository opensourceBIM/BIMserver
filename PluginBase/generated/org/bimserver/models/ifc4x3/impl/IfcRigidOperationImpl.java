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
import org.bimserver.models.ifc4x3.IfcMeasureValue;
import org.bimserver.models.ifc4x3.IfcRigidOperation;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rigid Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRigidOperationImpl#getFirstCoordinate <em>First Coordinate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRigidOperationImpl#getSecondCoordinate <em>Second Coordinate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRigidOperationImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRigidOperationImpl#getHeightAsString <em>Height As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRigidOperationImpl extends IfcCoordinateOperationImpl implements IfcRigidOperation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRigidOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_RIGID_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMeasureValue getFirstCoordinate() {
		return (IfcMeasureValue) eGet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__FIRST_COORDINATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstCoordinate(IfcMeasureValue newFirstCoordinate) {
		eSet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__FIRST_COORDINATE, newFirstCoordinate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMeasureValue getSecondCoordinate() {
		return (IfcMeasureValue) eGet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__SECOND_COORDINATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondCoordinate(IfcMeasureValue newSecondCoordinate) {
		eSet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__SECOND_COORDINATE, newSecondCoordinate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getHeight() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeight(double newHeight) {
		eSet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__HEIGHT, newHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHeight() {
		eUnset(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHeight() {
		return eIsSet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHeightAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeightAsString(String newHeightAsString) {
		eSet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__HEIGHT_AS_STRING, newHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHeightAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHeightAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_RIGID_OPERATION__HEIGHT_AS_STRING);
	}

} //IfcRigidOperationImpl
