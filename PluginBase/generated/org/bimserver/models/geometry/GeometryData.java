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
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getNrIndices <em>Nr Indices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getNrVertices <em>Nr Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getNrNormals <em>Nr Normals</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getNrColors <em>Nr Colors</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getVerticesQuantized <em>Vertices Quantized</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getNormals <em>Normals</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getNormalsQuantized <em>Normals Quantized</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getColorsQuantized <em>Colors Quantized</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getColor <em>Color</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#isHasTransparency <em>Has Transparency</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getReused <em>Reused</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getMostUsedColor <em>Most Used Color</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getBoundsMm <em>Bounds Mm</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getSaveableTriangles <em>Saveable Triangles</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getColorPack <em>Color Pack</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getLineIndices <em>Line Indices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getNrLineIndices <em>Nr Line Indices</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface GeometryData extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Nr Indices</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Indices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Indices</em>' attribute.
	 * @see #setNrIndices(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_NrIndices()
	 * @model default="0"
	 * @generated
	 */
	int getNrIndices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getNrIndices <em>Nr Indices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Indices</em>' attribute.
	 * @see #getNrIndices()
	 * @generated
	 */
	void setNrIndices(int value);

	/**
	 * Returns the value of the '<em><b>Nr Vertices</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Vertices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Vertices</em>' attribute.
	 * @see #setNrVertices(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_NrVertices()
	 * @model default="0"
	 * @generated
	 */
	int getNrVertices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getNrVertices <em>Nr Vertices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Vertices</em>' attribute.
	 * @see #getNrVertices()
	 * @generated
	 */
	void setNrVertices(int value);

	/**
	 * Returns the value of the '<em><b>Nr Normals</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Normals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Normals</em>' attribute.
	 * @see #setNrNormals(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_NrNormals()
	 * @model default="0"
	 * @generated
	 */
	int getNrNormals();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getNrNormals <em>Nr Normals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Normals</em>' attribute.
	 * @see #getNrNormals()
	 * @generated
	 */
	void setNrNormals(int value);

	/**
	 * Returns the value of the '<em><b>Nr Colors</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nr Colors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Colors</em>' attribute.
	 * @see #setNrColors(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_NrColors()
	 * @model default="0"
	 * @generated
	 */
	int getNrColors();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getNrColors <em>Nr Colors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Colors</em>' attribute.
	 * @see #getNrColors()
	 * @generated
	 */
	void setNrColors(int value);

	/**
	 * Returns the value of the '<em><b>Indices</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indices</em>' reference.
	 * @see #setIndices(Buffer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Indices()
	 * @model
	 * @generated
	 */
	Buffer getIndices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getIndices <em>Indices</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indices</em>' reference.
	 * @see #getIndices()
	 * @generated
	 */
	void setIndices(Buffer value);

	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices</em>' reference.
	 * @see #setVertices(Buffer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Vertices()
	 * @model
	 * @generated
	 */
	Buffer getVertices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getVertices <em>Vertices</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertices</em>' reference.
	 * @see #getVertices()
	 * @generated
	 */
	void setVertices(Buffer value);

	/**
	 * Returns the value of the '<em><b>Normals</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normals</em>' reference.
	 * @see #setNormals(Buffer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Normals()
	 * @model
	 * @generated
	 */
	Buffer getNormals();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getNormals <em>Normals</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normals</em>' reference.
	 * @see #getNormals()
	 * @generated
	 */
	void setNormals(Buffer value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' reference.
	 * @see #setColor(Vector4f)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Color()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Vector4f getColor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getColor <em>Color</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' reference.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(Vector4f value);

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
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_HasTransparency()
	 * @model
	 * @generated
	 */
	boolean isHasTransparency();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#isHasTransparency <em>Has Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Transparency</em>' attribute.
	 * @see #isHasTransparency()
	 * @generated
	 */
	void setHasTransparency(boolean value);

	/**
	 * Returns the value of the '<em><b>Reused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reused</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reused</em>' attribute.
	 * @see #setReused(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Reused()
	 * @model
	 * @generated
	 */
	int getReused();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getReused <em>Reused</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reused</em>' attribute.
	 * @see #getReused()
	 * @generated
	 */
	void setReused(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(short)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Type()
	 * @model
	 * @generated
	 */
	short getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(short value);

	/**
	 * Returns the value of the '<em><b>Most Used Color</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Most Used Color</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Most Used Color</em>' reference.
	 * @see #setMostUsedColor(Vector4f)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_MostUsedColor()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Vector4f getMostUsedColor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getMostUsedColor <em>Most Used Color</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Most Used Color</em>' reference.
	 * @see #getMostUsedColor()
	 * @generated
	 */
	void setMostUsedColor(Vector4f value);

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
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_BoundsMm()
	 * @model annotation="dbembed"
	 *        annotation="embedsreference"
	 *        annotation="hidden"
	 * @generated
	 */
	Bounds getBoundsMm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getBoundsMm <em>Bounds Mm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Mm</em>' reference.
	 * @see #getBoundsMm()
	 * @generated
	 */
	void setBoundsMm(Bounds value);

	/**
	 * Returns the value of the '<em><b>Saveable Triangles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Saveable Triangles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Saveable Triangles</em>' attribute.
	 * @see #setSaveableTriangles(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_SaveableTriangles()
	 * @model
	 * @generated
	 */
	int getSaveableTriangles();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getSaveableTriangles <em>Saveable Triangles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Saveable Triangles</em>' attribute.
	 * @see #getSaveableTriangles()
	 * @generated
	 */
	void setSaveableTriangles(int value);

	/**
	 * Returns the value of the '<em><b>Color Pack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color Pack</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Pack</em>' reference.
	 * @see #setColorPack(ColorPack)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_ColorPack()
	 * @model annotation="embedsreference"
	 * @generated
	 */
	ColorPack getColorPack();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getColorPack <em>Color Pack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Pack</em>' reference.
	 * @see #getColorPack()
	 * @generated
	 */
	void setColorPack(ColorPack value);

	/**
	 * Returns the value of the '<em><b>Line Indices</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Indices</em>' reference.
	 * @see #setLineIndices(Buffer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_LineIndices()
	 * @model
	 * @generated
	 */
	Buffer getLineIndices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getLineIndices <em>Line Indices</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Indices</em>' reference.
	 * @see #getLineIndices()
	 * @generated
	 */
	void setLineIndices(Buffer value);

	/**
	 * Returns the value of the '<em><b>Nr Line Indices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nr Line Indices</em>' attribute.
	 * @see #setNrLineIndices(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_NrLineIndices()
	 * @model
	 * @generated
	 */
	int getNrLineIndices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getNrLineIndices <em>Nr Line Indices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nr Line Indices</em>' attribute.
	 * @see #getNrLineIndices()
	 * @generated
	 */
	void setNrLineIndices(int value);

	/**
	 * Returns the value of the '<em><b>Normals Quantized</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normals Quantized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normals Quantized</em>' reference.
	 * @see #setNormalsQuantized(Buffer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_NormalsQuantized()
	 * @model
	 * @generated
	 */
	Buffer getNormalsQuantized();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getNormalsQuantized <em>Normals Quantized</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normals Quantized</em>' reference.
	 * @see #getNormalsQuantized()
	 * @generated
	 */
	void setNormalsQuantized(Buffer value);

	/**
	 * Returns the value of the '<em><b>Vertices Quantized</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices Quantized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices Quantized</em>' reference.
	 * @see #setVerticesQuantized(Buffer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_VerticesQuantized()
	 * @model
	 * @generated
	 */
	Buffer getVerticesQuantized();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getVerticesQuantized <em>Vertices Quantized</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertices Quantized</em>' reference.
	 * @see #getVerticesQuantized()
	 * @generated
	 */
	void setVerticesQuantized(Buffer value);

	/**
	 * Returns the value of the '<em><b>Colors Quantized</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colors Quantized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colors Quantized</em>' reference.
	 * @see #setColorsQuantized(Buffer)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_ColorsQuantized()
	 * @model
	 * @generated
	 */
	Buffer getColorsQuantized();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getColorsQuantized <em>Colors Quantized</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colors Quantized</em>' reference.
	 * @see #getColorsQuantized()
	 * @generated
	 */
	void setColorsQuantized(Buffer value);

} // GeometryData
