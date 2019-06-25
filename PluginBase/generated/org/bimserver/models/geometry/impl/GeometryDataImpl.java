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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.Buffer;
import org.bimserver.models.geometry.ColorPack;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.geometry.Vector4f;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getNrIndices <em>Nr Indices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getNrVertices <em>Nr Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getNrNormals <em>Nr Normals</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getNrColors <em>Nr Colors</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getVerticesQuantized <em>Vertices Quantized</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getNormals <em>Normals</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getNormalsQuantized <em>Normals Quantized</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getColorsQuantized <em>Colors Quantized</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getColor <em>Color</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#isHasTransparency <em>Has Transparency</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getReused <em>Reused</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getMostUsedColor <em>Most Used Color</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getBoundsMm <em>Bounds Mm</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getSaveableTriangles <em>Saveable Triangles</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getColorPack <em>Color Pack</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getLineIndices <em>Line Indices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryDataImpl#getNrLineIndices <em>Nr Line Indices</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeometryDataImpl extends IdEObjectImpl implements GeometryData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometryDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.GEOMETRY_DATA;
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
	@Override
	public int getNrIndices() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__NR_INDICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNrIndices(int newNrIndices) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__NR_INDICES, newNrIndices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNrVertices() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__NR_VERTICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNrVertices(int newNrVertices) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__NR_VERTICES, newNrVertices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNrNormals() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__NR_NORMALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNrNormals(int newNrNormals) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__NR_NORMALS, newNrNormals);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNrColors() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__NR_COLORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNrColors(int newNrColors) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__NR_COLORS, newNrColors);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getIndices() {
		return (Buffer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__INDICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndices(Buffer newIndices) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__INDICES, newIndices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getVertices() {
		return (Buffer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__VERTICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertices(Buffer newVertices) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__VERTICES, newVertices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getNormals() {
		return (Buffer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__NORMALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNormals(Buffer newNormals) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__NORMALS, newNormals);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector4f getColor() {
		return (Vector4f) eGet(GeometryPackage.Literals.GEOMETRY_DATA__COLOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColor(Vector4f newColor) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__COLOR, newColor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasTransparency() {
		return (Boolean) eGet(GeometryPackage.Literals.GEOMETRY_DATA__HAS_TRANSPARENCY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasTransparency(boolean newHasTransparency) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__HAS_TRANSPARENCY, newHasTransparency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getReused() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__REUSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReused(int newReused) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__REUSED, newReused);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public short getType() {
		return (Short) eGet(GeometryPackage.Literals.GEOMETRY_DATA__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(short newType) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector4f getMostUsedColor() {
		return (Vector4f) eGet(GeometryPackage.Literals.GEOMETRY_DATA__MOST_USED_COLOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMostUsedColor(Vector4f newMostUsedColor) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__MOST_USED_COLOR, newMostUsedColor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bounds getBoundsMm() {
		return (Bounds) eGet(GeometryPackage.Literals.GEOMETRY_DATA__BOUNDS_MM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoundsMm(Bounds newBoundsMm) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__BOUNDS_MM, newBoundsMm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSaveableTriangles() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__SAVEABLE_TRIANGLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSaveableTriangles(int newSaveableTriangles) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__SAVEABLE_TRIANGLES, newSaveableTriangles);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColorPack getColorPack() {
		return (ColorPack) eGet(GeometryPackage.Literals.GEOMETRY_DATA__COLOR_PACK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorPack(ColorPack newColorPack) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__COLOR_PACK, newColorPack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getLineIndices() {
		return (Buffer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__LINE_INDICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLineIndices(Buffer newLineIndices) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__LINE_INDICES, newLineIndices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNrLineIndices() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__NR_LINE_INDICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNrLineIndices(int newNrLineIndices) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__NR_LINE_INDICES, newNrLineIndices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getNormalsQuantized() {
		return (Buffer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__NORMALS_QUANTIZED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNormalsQuantized(Buffer newNormalsQuantized) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__NORMALS_QUANTIZED, newNormalsQuantized);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getVerticesQuantized() {
		return (Buffer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__VERTICES_QUANTIZED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerticesQuantized(Buffer newVerticesQuantized) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__VERTICES_QUANTIZED, newVerticesQuantized);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getColorsQuantized() {
		return (Buffer) eGet(GeometryPackage.Literals.GEOMETRY_DATA__COLORS_QUANTIZED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorsQuantized(Buffer newColorsQuantized) {
		eSet(GeometryPackage.Literals.GEOMETRY_DATA__COLORS_QUANTIZED, newColorsQuantized);
	}

} //GeometryDataImpl
