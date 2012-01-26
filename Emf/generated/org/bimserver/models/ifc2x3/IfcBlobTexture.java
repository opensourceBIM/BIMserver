/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Blob Texture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBlobTexture#getRasterFormat <em>Raster Format</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBlobTexture#getRasterCode <em>Raster Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlobTexture()
 * @model
 * @generated
 */
public interface IfcBlobTexture extends IfcSurfaceTexture {
	/**
	 * Returns the value of the '<em><b>Raster Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raster Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raster Format</em>' attribute.
	 * @see #isSetRasterFormat()
	 * @see #unsetRasterFormat()
	 * @see #setRasterFormat(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlobTexture_RasterFormat()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRasterFormat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlobTexture#getRasterFormat <em>Raster Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raster Format</em>' attribute.
	 * @see #isSetRasterFormat()
	 * @see #unsetRasterFormat()
	 * @see #getRasterFormat()
	 * @generated
	 */
	void setRasterFormat(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlobTexture#getRasterFormat <em>Raster Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRasterFormat()
	 * @see #getRasterFormat()
	 * @see #setRasterFormat(String)
	 * @generated
	 */
	void unsetRasterFormat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBlobTexture#getRasterFormat <em>Raster Format</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Raster Format</em>' attribute is set.
	 * @see #unsetRasterFormat()
	 * @see #getRasterFormat()
	 * @see #setRasterFormat(String)
	 * @generated
	 */
	boolean isSetRasterFormat();

	/**
	 * Returns the value of the '<em><b>Raster Code</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raster Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raster Code</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetRasterCode()
	 * @see #unsetRasterCode()
	 * @see #setRasterCode(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBlobTexture_RasterCode()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getRasterCode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlobTexture#getRasterCode <em>Raster Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raster Code</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetRasterCode()
	 * @see #unsetRasterCode()
	 * @see #getRasterCode()
	 * @generated
	 */
	void setRasterCode(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBlobTexture#getRasterCode <em>Raster Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRasterCode()
	 * @see #getRasterCode()
	 * @see #setRasterCode(Tristate)
	 * @generated
	 */
	void unsetRasterCode();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBlobTexture#getRasterCode <em>Raster Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Raster Code</em>' attribute is set.
	 * @see #unsetRasterCode()
	 * @see #getRasterCode()
	 * @see #setRasterCode(Tristate)
	 * @generated
	 */
	boolean isSetRasterCode();

} // IfcBlobTexture
