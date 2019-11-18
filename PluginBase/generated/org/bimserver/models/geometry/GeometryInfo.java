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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getBoundsUntransformed <em>Bounds Untransformed</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getStartVertex <em>Start Vertex</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getPrimitiveCount <em>Primitive Count</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getData <em>Data</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getArea <em>Area</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#isHasTransparency <em>Has Transparency</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getIfcProductOid <em>Ifc Product Oid</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getIfcProductUuid <em>Ifc Product Uuid</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getIfcProductRid <em>Ifc Product Rid</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getDensity <em>Density</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getBoundsMm <em>Bounds Mm</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getBoundsUntransformedMm <em>Bounds Untransformed Mm</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getAdditionalData <em>Additional Data</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getNrColors <em>Nr Colors</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getNrVertices <em>Nr Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryInfo#getIfcProductPid <em>Ifc Product Pid</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo()
 * @model annotation="hidden"
 * @extends IdEObject
 * @generated
 */
public interface GeometryInfo extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds</em>' reference.
	 * @see #setBounds(Bounds)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_Bounds()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBounds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getBounds <em>Bounds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds</em>' reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(Bounds value);

	/**
	 * Returns the value of the '<em><b>Bounds Untransformed</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds Untransformed</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds Untransformed</em>' reference.
	 * @see #setBoundsUntransformed(Bounds)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_BoundsUntransformed()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBoundsUntransformed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getBoundsUntransformed <em>Bounds Untransformed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Untransformed</em>' reference.
	 * @see #getBoundsUntransformed()
	 * @generated
	 */
	void setBoundsUntransformed(Bounds value);

	/**
	 * Returns the value of the '<em><b>Start Vertex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Vertex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Vertex</em>' attribute.
	 * @see #setStartVertex(Integer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_StartVertex()
	 * @model
	 * @generated
	 */
	Integer getStartVertex();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getStartVertex <em>Start Vertex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Vertex</em>' attribute.
	 * @see #getStartVertex()
	 * @generated
	 */
	void setStartVertex(Integer value);

	/**
	 * Returns the value of the '<em><b>Start Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Index</em>' attribute.
	 * @see #setStartIndex(Integer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_StartIndex()
	 * @model
	 * @generated
	 */
	Integer getStartIndex();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getStartIndex <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Index</em>' attribute.
	 * @see #getStartIndex()
	 * @generated
	 */
	void setStartIndex(Integer value);

	/**
	 * Returns the value of the '<em><b>Primitive Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Count</em>' attribute.
	 * @see #setPrimitiveCount(Integer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_PrimitiveCount()
	 * @model
	 * @generated
	 */
	Integer getPrimitiveCount();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getPrimitiveCount <em>Primitive Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Count</em>' attribute.
	 * @see #getPrimitiveCount()
	 * @generated
	 */
	void setPrimitiveCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' attribute.
	 * @see #setTransformation(byte[])
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_Transformation()
	 * @model
	 * @generated
	 */
	byte[] getTransformation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getTransformation <em>Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' attribute.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(byte[] value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' reference.
	 * @see #setData(GeometryData)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_Data()
	 * @model
	 * @generated
	 */
	GeometryData getData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getData <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(GeometryData value);

	/**
	 * Returns the value of the '<em><b>Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' attribute.
	 * @see #setArea(double)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_Area()
	 * @model
	 * @generated
	 */
	double getArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getArea <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' attribute.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(double value);

	/**
	 * Returns the value of the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume</em>' attribute.
	 * @see #setVolume(double)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_Volume()
	 * @model
	 * @generated
	 */
	double getVolume();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getVolume <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume</em>' attribute.
	 * @see #getVolume()
	 * @generated
	 */
	void setVolume(double value);

	/**
	 * Returns the value of the '<em><b>Has Transparency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Transparency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Transparency</em>' attribute.
	 * @see #setHasTransparency(boolean)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_HasTransparency()
	 * @model
	 * @generated
	 */
	boolean isHasTransparency();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#isHasTransparency <em>Has Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Transparency</em>' attribute.
	 * @see #isHasTransparency()
	 * @generated
	 */
	void setHasTransparency(boolean value);

	/**
	 * Returns the value of the '<em><b>Ifc Product Oid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Product Oid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Product Oid</em>' attribute.
	 * @see #setIfcProductOid(long)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_IfcProductOid()
	 * @model
	 * @generated
	 */
	long getIfcProductOid();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getIfcProductOid <em>Ifc Product Oid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Product Oid</em>' attribute.
	 * @see #getIfcProductOid()
	 * @generated
	 */
	void setIfcProductOid(long value);

	/**
	 * Returns the value of the '<em><b>Ifc Product Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Product Uuid</em>' attribute.
	 * @see #setIfcProductUuid(byte[])
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_IfcProductUuid()
	 * @model
	 * @generated
	 */
	byte[] getIfcProductUuid();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getIfcProductUuid <em>Ifc Product Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Product Uuid</em>' attribute.
	 * @see #getIfcProductUuid()
	 * @generated
	 */
	void setIfcProductUuid(byte[] value);

	/**
	 * Returns the value of the '<em><b>Ifc Product Rid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Product Rid</em>' attribute.
	 * @see #setIfcProductRid(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_IfcProductRid()
	 * @model
	 * @generated
	 */
	int getIfcProductRid();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getIfcProductRid <em>Ifc Product Rid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Product Rid</em>' attribute.
	 * @see #getIfcProductRid()
	 * @generated
	 */
	void setIfcProductRid(int value);

	/**
	 * Returns the value of the '<em><b>Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Density</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Density</em>' attribute.
	 * @see #setDensity(float)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_Density()
	 * @model
	 * @generated
	 */
	float getDensity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getDensity <em>Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Density</em>' attribute.
	 * @see #getDensity()
	 * @generated
	 */
	void setDensity(float value);

	/**
	 * Returns the value of the '<em><b>Bounds Mm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds Mm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds Mm</em>' reference.
	 * @see #setBoundsMm(Bounds)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_BoundsMm()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBoundsMm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getBoundsMm <em>Bounds Mm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Mm</em>' reference.
	 * @see #getBoundsMm()
	 * @generated
	 */
	void setBoundsMm(Bounds value);

	/**
	 * Returns the value of the '<em><b>Bounds Untransformed Mm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds Untransformed Mm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds Untransformed Mm</em>' reference.
	 * @see #setBoundsUntransformedMm(Bounds)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_BoundsUntransformedMm()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBoundsUntransformedMm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getBoundsUntransformedMm <em>Bounds Untransformed Mm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Untransformed Mm</em>' reference.
	 * @see #getBoundsUntransformedMm()
	 * @generated
	 */
	void setBoundsUntransformedMm(Bounds value);

	/**
	 * Returns the value of the '<em><b>Additional Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Data</em>' attribute.
	 * @see #setAdditionalData(String)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_AdditionalData()
	 * @model
	 * @generated
	 */
	String getAdditionalData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getAdditionalData <em>Additional Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additional Data</em>' attribute.
	 * @see #getAdditionalData()
	 * @generated
	 */
	void setAdditionalData(String value);

	/**
	 * Returns the value of the '<em><b>Nr Colors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Colors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Colors</em>' attribute.
	 * @see #setNrColors(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_NrColors()
	 * @model
	 * @generated
	 */
	int getNrColors();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getNrColors <em>Nr Colors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Colors</em>' attribute.
	 * @see #getNrColors()
	 * @generated
	 */
	void setNrColors(int value);

	/**
	 * Returns the value of the '<em><b>Nr Vertices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Vertices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Vertices</em>' attribute.
	 * @see #setNrVertices(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_NrVertices()
	 * @model
	 * @generated
	 */
	int getNrVertices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getNrVertices <em>Nr Vertices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Vertices</em>' attribute.
	 * @see #getNrVertices()
	 * @generated
	 */
	void setNrVertices(int value);

	/**
	 * Returns the value of the '<em><b>Ifc Product Pid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Product Pid</em>' attribute.
	 * @see #setIfcProductPid(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryInfo_IfcProductPid()
	 * @model
	 * @generated
	 */
	int getIfcProductPid();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryInfo#getIfcProductPid <em>Ifc Product Pid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Product Pid</em>' attribute.
	 * @see #getIfcProductPid()
	 * @generated
	 */
	void setIfcProductPid(int value);

} // GeometryInfo
