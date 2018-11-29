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
package org.bimserver.models.geometry.impl;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.GeometryPackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getBoundsUntransformed <em>Bounds Untransformed</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getStartVertex <em>Start Vertex</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getPrimitiveCount <em>Primitive Count</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getArea <em>Area</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#isHasTransparency <em>Has Transparency</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getIfcProductOid <em>Ifc Product Oid</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getDensity <em>Density</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getBoundsMm <em>Bounds Mm</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getBoundsUntransformedMm <em>Bounds Untransformed Mm</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getAdditionalData <em>Additional Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeometryInfoImpl extends IdEObjectImpl implements GeometryInfo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometryInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.GEOMETRY_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bounds getBounds() {
		return (Bounds) eGet(GeometryPackage.Literals.GEOMETRY_INFO__BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBounds(Bounds newBounds) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__BOUNDS, newBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bounds getBoundsUntransformed() {
		return (Bounds) eGet(GeometryPackage.Literals.GEOMETRY_INFO__BOUNDS_UNTRANSFORMED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundsUntransformed(Bounds newBoundsUntransformed) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__BOUNDS_UNTRANSFORMED, newBoundsUntransformed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartVertex() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_INFO__START_VERTEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartVertex(Integer newStartVertex) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__START_VERTEX, newStartVertex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartIndex() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_INFO__START_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIndex(Integer newStartIndex) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__START_INDEX, newStartIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPrimitiveCount() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_INFO__PRIMITIVE_COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitiveCount(Integer newPrimitiveCount) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__PRIMITIVE_COUNT, newPrimitiveCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getTransformation() {
		return (byte[]) eGet(GeometryPackage.Literals.GEOMETRY_INFO__TRANSFORMATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(byte[] newTransformation) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__TRANSFORMATION, newTransformation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryData getData() {
		return (GeometryData) eGet(GeometryPackage.Literals.GEOMETRY_INFO__DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(GeometryData newData) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__DATA, newData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getArea() {
		return (Double) eGet(GeometryPackage.Literals.GEOMETRY_INFO__AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(double newArea) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__AREA, newArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVolume() {
		return (Double) eGet(GeometryPackage.Literals.GEOMETRY_INFO__VOLUME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolume(double newVolume) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__VOLUME, newVolume);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasTransparency() {
		return (Boolean) eGet(GeometryPackage.Literals.GEOMETRY_INFO__HAS_TRANSPARENCY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasTransparency(boolean newHasTransparency) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__HAS_TRANSPARENCY, newHasTransparency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getIfcProductOid() {
		return (Long) eGet(GeometryPackage.Literals.GEOMETRY_INFO__IFC_PRODUCT_OID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfcProductOid(long newIfcProductOid) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__IFC_PRODUCT_OID, newIfcProductOid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDensity() {
		return (Float) eGet(GeometryPackage.Literals.GEOMETRY_INFO__DENSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDensity(float newDensity) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__DENSITY, newDensity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bounds getBoundsMm() {
		return (Bounds) eGet(GeometryPackage.Literals.GEOMETRY_INFO__BOUNDS_MM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundsMm(Bounds newBoundsMm) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__BOUNDS_MM, newBoundsMm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bounds getBoundsUntransformedMm() {
		return (Bounds) eGet(GeometryPackage.Literals.GEOMETRY_INFO__BOUNDS_UNTRANSFORMED_MM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundsUntransformedMm(Bounds newBoundsUntransformedMm) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__BOUNDS_UNTRANSFORMED_MM, newBoundsUntransformedMm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdditionalData() {
		return (String) eGet(GeometryPackage.Literals.GEOMETRY_INFO__ADDITIONAL_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalData(String newAdditionalData) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__ADDITIONAL_DATA, newAdditionalData);
	}

} //GeometryInfoImpl
