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
import org.bimserver.models.ifc4x3.IfcDirection;
import org.bimserver.models.ifc4x3.IfcVector;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Vector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcVectorImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcVectorImpl#getMagnitude <em>Magnitude</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcVectorImpl#getMagnitudeAsString <em>Magnitude As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcVectorImpl#getDim <em>Dim</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcVectorImpl extends IfcGeometricRepresentationItemImpl implements IfcVector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcVectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcVector();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection getOrientation() {
		return (IfcDirection) eGet(Ifc4x3Package.eINSTANCE.getIfcVector_Orientation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrientation(IfcDirection newOrientation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcVector_Orientation(), newOrientation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMagnitude() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcVector_Magnitude(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMagnitude(double newMagnitude) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcVector_Magnitude(), newMagnitude);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMagnitudeAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcVector_MagnitudeAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMagnitudeAsString(String newMagnitudeAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcVector_MagnitudeAsString(), newMagnitudeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDim() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcVector_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDim(long newDim) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcVector_Dim(), newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDim() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcVector_Dim());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDim() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcVector_Dim());
	}

} //IfcVectorImpl
