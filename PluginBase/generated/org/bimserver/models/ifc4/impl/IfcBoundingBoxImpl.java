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
import org.bimserver.models.ifc4.IfcBoundingBox;
import org.bimserver.models.ifc4.IfcCartesianPoint;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Bounding Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundingBoxImpl#getCorner <em>Corner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundingBoxImpl#getXDim <em>XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundingBoxImpl#getXDimAsString <em>XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundingBoxImpl#getYDim <em>YDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundingBoxImpl#getYDimAsString <em>YDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundingBoxImpl#getZDim <em>ZDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundingBoxImpl#getZDimAsString <em>ZDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundingBoxImpl#getDim <em>Dim</em>}</li>
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
		return Ifc4Package.Literals.IFC_BOUNDING_BOX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPoint getCorner() {
		return (IfcCartesianPoint) eGet(Ifc4Package.Literals.IFC_BOUNDING_BOX__CORNER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCorner(IfcCartesianPoint newCorner) {
		eSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__CORNER, newCorner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getXDim() {
		return (Double) eGet(Ifc4Package.Literals.IFC_BOUNDING_BOX__XDIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXDim(double newXDim) {
		eSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__XDIM, newXDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getXDimAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_BOUNDING_BOX__XDIM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXDimAsString(String newXDimAsString) {
		eSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__XDIM_AS_STRING, newXDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getYDim() {
		return (Double) eGet(Ifc4Package.Literals.IFC_BOUNDING_BOX__YDIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYDim(double newYDim) {
		eSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__YDIM, newYDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getYDimAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_BOUNDING_BOX__YDIM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYDimAsString(String newYDimAsString) {
		eSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__YDIM_AS_STRING, newYDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getZDim() {
		return (Double) eGet(Ifc4Package.Literals.IFC_BOUNDING_BOX__ZDIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZDim(double newZDim) {
		eSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__ZDIM, newZDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getZDimAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_BOUNDING_BOX__ZDIM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZDimAsString(String newZDimAsString) {
		eSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__ZDIM_AS_STRING, newZDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDim() {
		return (Long) eGet(Ifc4Package.Literals.IFC_BOUNDING_BOX__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDim(long newDim) {
		eSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__DIM, newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDim() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDING_BOX__DIM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDim() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDING_BOX__DIM);
	}

} //IfcBoundingBoxImpl
