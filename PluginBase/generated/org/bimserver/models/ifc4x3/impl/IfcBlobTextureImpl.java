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
import org.bimserver.models.ifc4x3.IfcBlobTexture;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Blob Texture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBlobTextureImpl#getRasterFormat <em>Raster Format</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBlobTextureImpl#getRasterCode <em>Raster Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBlobTextureImpl extends IfcSurfaceTextureImpl implements IfcBlobTexture {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBlobTextureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_BLOB_TEXTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRasterFormat() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_BLOB_TEXTURE__RASTER_FORMAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRasterFormat(String newRasterFormat) {
		eSet(Ifc4x3Package.Literals.IFC_BLOB_TEXTURE__RASTER_FORMAT, newRasterFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getRasterCode() {
		return (byte[]) eGet(Ifc4x3Package.Literals.IFC_BLOB_TEXTURE__RASTER_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRasterCode(byte[] newRasterCode) {
		eSet(Ifc4x3Package.Literals.IFC_BLOB_TEXTURE__RASTER_CODE, newRasterCode);
	}

} //IfcBlobTextureImpl
