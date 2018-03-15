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
package org.bimserver.models.geometry;

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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.bimserver.models.geometry.GeometryFactory
 * @model kind="package"
 * @generated
 */
public interface GeometryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "geometry";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "geometry";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "geometry";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeometryPackage eINSTANCE = org.bimserver.models.geometry.impl.GeometryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bimserver.models.geometry.impl.GeometryInfoImpl <em>Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.geometry.impl.GeometryInfoImpl
	 * @see org.bimserver.models.geometry.impl.GeometryPackageImpl#getGeometryInfo()
	 * @generated
	 */
	int GEOMETRY_INFO = 0;

	/**
	 * The feature id for the '<em><b>Min Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__MIN_BOUNDS = 0;

	/**
	 * The feature id for the '<em><b>Max Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__MAX_BOUNDS = 1;

	/**
	 * The feature id for the '<em><b>Start Vertex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__START_VERTEX = 2;

	/**
	 * The feature id for the '<em><b>Start Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__START_INDEX = 3;

	/**
	 * The feature id for the '<em><b>Primitive Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__PRIMITIVE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__DATA = 5;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__TRANSFORMATION = 6;

	/**
	 * The feature id for the '<em><b>Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__AREA = 7;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__VOLUME = 8;

	/**
	 * The feature id for the '<em><b>Min Bounds Untranslated</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__MIN_BOUNDS_UNTRANSLATED = 9;

	/**
	 * The feature id for the '<em><b>Max Bounds Untranslated</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO__MAX_BOUNDS_UNTRANSLATED = 10;

	/**
	 * The number of structural features of the '<em>Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_INFO_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.bimserver.models.geometry.impl.Vector3fImpl <em>Vector3f</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.geometry.impl.Vector3fImpl
	 * @see org.bimserver.models.geometry.impl.GeometryPackageImpl#getVector3f()
	 * @generated
	 */
	int VECTOR3F = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR3F__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR3F__Y = 1;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR3F__Z = 2;

	/**
	 * The number of structural features of the '<em>Vector3f</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR3F_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.geometry.impl.GeometryDataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.geometry.impl.GeometryDataImpl
	 * @see org.bimserver.models.geometry.impl.GeometryPackageImpl#getGeometryData()
	 * @generated
	 */
	int GEOMETRY_DATA = 2;

	/**
	 * The feature id for the '<em><b>Indices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_DATA__INDICES = 0;

	/**
	 * The feature id for the '<em><b>Vertices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_DATA__VERTICES = 1;

	/**
	 * The feature id for the '<em><b>Normals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_DATA__NORMALS = 2;

	/**
	 * The feature id for the '<em><b>Materials</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_DATA__MATERIALS = 3;

	/**
	 * The feature id for the '<em><b>Material Indices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_DATA__MATERIAL_INDICES = 4;

	/**
	 * The feature id for the '<em><b>Color</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_DATA__COLOR = 5;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRY_DATA_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.geometry.impl.Vector4fImpl <em>Vector4f</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.geometry.impl.Vector4fImpl
	 * @see org.bimserver.models.geometry.impl.GeometryPackageImpl#getVector4f()
	 * @generated
	 */
	int VECTOR4F = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR4F__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR4F__Y = 1;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR4F__Z = 2;

	/**
	 * The feature id for the '<em><b>W</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR4F__W = 3;

	/**
	 * The number of structural features of the '<em>Vector4f</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR4F_FEATURE_COUNT = 4;

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.geometry.GeometryInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo
	 * @generated
	 */
	EClass getGeometryInfo();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.geometry.GeometryInfo#getMinBounds <em>Min Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min Bounds</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getMinBounds()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EReference getGeometryInfo_MinBounds();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.geometry.GeometryInfo#getMaxBounds <em>Max Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max Bounds</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getMaxBounds()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EReference getGeometryInfo_MaxBounds();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryInfo#getStartVertex <em>Start Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Vertex</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getStartVertex()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EAttribute getGeometryInfo_StartVertex();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryInfo#getStartIndex <em>Start Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Index</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getStartIndex()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EAttribute getGeometryInfo_StartIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryInfo#getPrimitiveCount <em>Primitive Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive Count</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getPrimitiveCount()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EAttribute getGeometryInfo_PrimitiveCount();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.geometry.GeometryInfo#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getData()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EReference getGeometryInfo_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryInfo#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transformation</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getTransformation()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EAttribute getGeometryInfo_Transformation();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryInfo#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Area</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getArea()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EAttribute getGeometryInfo_Area();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryInfo#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getVolume()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EAttribute getGeometryInfo_Volume();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.geometry.GeometryInfo#getMinBoundsUntranslated <em>Min Bounds Untranslated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min Bounds Untranslated</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getMinBoundsUntranslated()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EReference getGeometryInfo_MinBoundsUntranslated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.geometry.GeometryInfo#getMaxBoundsUntranslated <em>Max Bounds Untranslated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max Bounds Untranslated</em>'.
	 * @see org.bimserver.models.geometry.GeometryInfo#getMaxBoundsUntranslated()
	 * @see #getGeometryInfo()
	 * @generated
	 */
	EReference getGeometryInfo_MaxBoundsUntranslated();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.geometry.Vector3f <em>Vector3f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vector3f</em>'.
	 * @see org.bimserver.models.geometry.Vector3f
	 * @generated
	 */
	EClass getVector3f();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.Vector3f#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.bimserver.models.geometry.Vector3f#getX()
	 * @see #getVector3f()
	 * @generated
	 */
	EAttribute getVector3f_X();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.Vector3f#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.bimserver.models.geometry.Vector3f#getY()
	 * @see #getVector3f()
	 * @generated
	 */
	EAttribute getVector3f_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.Vector3f#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see org.bimserver.models.geometry.Vector3f#getZ()
	 * @see #getVector3f()
	 * @generated
	 */
	EAttribute getVector3f_Z();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.geometry.GeometryData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see org.bimserver.models.geometry.GeometryData
	 * @generated
	 */
	EClass getGeometryData();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryData#getIndices <em>Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indices</em>'.
	 * @see org.bimserver.models.geometry.GeometryData#getIndices()
	 * @see #getGeometryData()
	 * @generated
	 */
	EAttribute getGeometryData_Indices();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryData#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertices</em>'.
	 * @see org.bimserver.models.geometry.GeometryData#getVertices()
	 * @see #getGeometryData()
	 * @generated
	 */
	EAttribute getGeometryData_Vertices();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryData#getNormals <em>Normals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normals</em>'.
	 * @see org.bimserver.models.geometry.GeometryData#getNormals()
	 * @see #getGeometryData()
	 * @generated
	 */
	EAttribute getGeometryData_Normals();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryData#getMaterials <em>Materials</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Materials</em>'.
	 * @see org.bimserver.models.geometry.GeometryData#getMaterials()
	 * @see #getGeometryData()
	 * @generated
	 */
	EAttribute getGeometryData_Materials();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.GeometryData#getMaterialIndices <em>Material Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Material Indices</em>'.
	 * @see org.bimserver.models.geometry.GeometryData#getMaterialIndices()
	 * @see #getGeometryData()
	 * @generated
	 */
	EAttribute getGeometryData_MaterialIndices();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.geometry.GeometryData#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Color</em>'.
	 * @see org.bimserver.models.geometry.GeometryData#getColor()
	 * @see #getGeometryData()
	 * @generated
	 */
	EReference getGeometryData_Color();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.geometry.Vector4f <em>Vector4f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vector4f</em>'.
	 * @see org.bimserver.models.geometry.Vector4f
	 * @generated
	 */
	EClass getVector4f();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.Vector4f#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.bimserver.models.geometry.Vector4f#getX()
	 * @see #getVector4f()
	 * @generated
	 */
	EAttribute getVector4f_X();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.Vector4f#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.bimserver.models.geometry.Vector4f#getY()
	 * @see #getVector4f()
	 * @generated
	 */
	EAttribute getVector4f_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.Vector4f#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see org.bimserver.models.geometry.Vector4f#getZ()
	 * @see #getVector4f()
	 * @generated
	 */
	EAttribute getVector4f_Z();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.geometry.Vector4f#getW <em>W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>W</em>'.
	 * @see org.bimserver.models.geometry.Vector4f#getW()
	 * @see #getVector4f()
	 * @generated
	 */
	EAttribute getVector4f_W();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeometryFactory getGeometryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.bimserver.models.geometry.impl.GeometryInfoImpl <em>Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.geometry.impl.GeometryInfoImpl
		 * @see org.bimserver.models.geometry.impl.GeometryPackageImpl#getGeometryInfo()
		 * @generated
		 */
		EClass GEOMETRY_INFO = eINSTANCE.getGeometryInfo();

		/**
		 * The meta object literal for the '<em><b>Min Bounds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEOMETRY_INFO__MIN_BOUNDS = eINSTANCE.getGeometryInfo_MinBounds();

		/**
		 * The meta object literal for the '<em><b>Max Bounds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEOMETRY_INFO__MAX_BOUNDS = eINSTANCE.getGeometryInfo_MaxBounds();

		/**
		 * The meta object literal for the '<em><b>Start Vertex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_INFO__START_VERTEX = eINSTANCE.getGeometryInfo_StartVertex();

		/**
		 * The meta object literal for the '<em><b>Start Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_INFO__START_INDEX = eINSTANCE.getGeometryInfo_StartIndex();

		/**
		 * The meta object literal for the '<em><b>Primitive Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_INFO__PRIMITIVE_COUNT = eINSTANCE.getGeometryInfo_PrimitiveCount();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEOMETRY_INFO__DATA = eINSTANCE.getGeometryInfo_Data();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_INFO__TRANSFORMATION = eINSTANCE.getGeometryInfo_Transformation();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_INFO__AREA = eINSTANCE.getGeometryInfo_Area();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_INFO__VOLUME = eINSTANCE.getGeometryInfo_Volume();

		/**
		 * The meta object literal for the '<em><b>Min Bounds Untranslated</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEOMETRY_INFO__MIN_BOUNDS_UNTRANSLATED = eINSTANCE.getGeometryInfo_MinBoundsUntranslated();

		/**
		 * The meta object literal for the '<em><b>Max Bounds Untranslated</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEOMETRY_INFO__MAX_BOUNDS_UNTRANSLATED = eINSTANCE.getGeometryInfo_MaxBoundsUntranslated();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.geometry.impl.Vector3fImpl <em>Vector3f</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.geometry.impl.Vector3fImpl
		 * @see org.bimserver.models.geometry.impl.GeometryPackageImpl#getVector3f()
		 * @generated
		 */
		EClass VECTOR3F = eINSTANCE.getVector3f();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTOR3F__X = eINSTANCE.getVector3f_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTOR3F__Y = eINSTANCE.getVector3f_Y();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTOR3F__Z = eINSTANCE.getVector3f_Z();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.geometry.impl.GeometryDataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.geometry.impl.GeometryDataImpl
		 * @see org.bimserver.models.geometry.impl.GeometryPackageImpl#getGeometryData()
		 * @generated
		 */
		EClass GEOMETRY_DATA = eINSTANCE.getGeometryData();

		/**
		 * The meta object literal for the '<em><b>Indices</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_DATA__INDICES = eINSTANCE.getGeometryData_Indices();

		/**
		 * The meta object literal for the '<em><b>Vertices</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_DATA__VERTICES = eINSTANCE.getGeometryData_Vertices();

		/**
		 * The meta object literal for the '<em><b>Normals</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_DATA__NORMALS = eINSTANCE.getGeometryData_Normals();

		/**
		 * The meta object literal for the '<em><b>Materials</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_DATA__MATERIALS = eINSTANCE.getGeometryData_Materials();

		/**
		 * The meta object literal for the '<em><b>Material Indices</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEOMETRY_DATA__MATERIAL_INDICES = eINSTANCE.getGeometryData_MaterialIndices();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEOMETRY_DATA__COLOR = eINSTANCE.getGeometryData_Color();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.geometry.impl.Vector4fImpl <em>Vector4f</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.geometry.impl.Vector4fImpl
		 * @see org.bimserver.models.geometry.impl.GeometryPackageImpl#getVector4f()
		 * @generated
		 */
		EClass VECTOR4F = eINSTANCE.getVector4f();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTOR4F__X = eINSTANCE.getVector4f_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTOR4F__Y = eINSTANCE.getVector4f_Y();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTOR4F__Z = eINSTANCE.getVector4f_Z();

		/**
		 * The meta object literal for the '<em><b>W</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VECTOR4F__W = eINSTANCE.getVector4f_W();

	}

} //GeometryPackage
