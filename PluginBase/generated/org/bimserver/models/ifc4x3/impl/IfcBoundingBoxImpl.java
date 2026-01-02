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
import org.bimserver.models.ifc4x3.IfcBoundingBox;
import org.bimserver.models.ifc4x3.IfcCartesianPoint;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Bounding Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundingBoxImpl#getCorner <em>Corner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundingBoxImpl#getXDim <em>XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundingBoxImpl#getXDimAsString <em>XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundingBoxImpl#getYDim <em>YDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundingBoxImpl#getYDimAsString <em>YDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundingBoxImpl#getZDim <em>ZDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundingBoxImpl#getZDimAsString <em>ZDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBoundingBoxImpl#getDim <em>Dim</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBoundingBoxImpl extends IfcGeometricRepresentationItemImpl implements IfcBoundingBox {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundingBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcBoundingBox();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPoint getCorner() {
		return (IfcCartesianPoint) eGet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_Corner(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCorner(IfcCartesianPoint newCorner) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_Corner(), newCorner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getXDim() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_XDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXDim(double newXDim) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_XDim(), newXDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getXDimAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_XDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXDimAsString(String newXDimAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_XDimAsString(), newXDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getYDim() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_YDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYDim(double newYDim) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_YDim(), newYDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getYDimAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_YDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYDimAsString(String newYDimAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_YDimAsString(), newYDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getZDim() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_ZDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZDim(double newZDim) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_ZDim(), newZDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getZDimAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_ZDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZDimAsString(String newZDimAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_ZDimAsString(), newZDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDim() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDim(long newDim) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_Dim(), newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDim() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_Dim());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDim() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBoundingBox_Dim());
	}

} //IfcBoundingBoxImpl
