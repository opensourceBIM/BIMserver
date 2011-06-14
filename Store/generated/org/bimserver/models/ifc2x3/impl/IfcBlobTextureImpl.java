/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcBlobTexture;
import org.bimserver.models.ifc2x3.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Blob Texture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlobTextureImpl#getRasterFormat <em>Raster Format</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlobTextureImpl#getRasterCode <em>Raster Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBlobTextureImpl extends IfcSurfaceTextureImpl implements IfcBlobTexture
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBlobTextureImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcBlobTexture();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRasterFormat()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBlobTexture_RasterFormat(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRasterFormat(String newRasterFormat)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlobTexture_RasterFormat(), newRasterFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getRasterCode()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcBlobTexture_RasterCode(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRasterCode(Tristate newRasterCode)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlobTexture_RasterCode(), newRasterCode);
	}

} //IfcBlobTextureImpl
