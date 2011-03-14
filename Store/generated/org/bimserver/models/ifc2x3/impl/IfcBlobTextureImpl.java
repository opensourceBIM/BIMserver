/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
		return Ifc2x3Package.eINSTANCE.getIfcBlobTexture();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRasterFormat() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBlobTexture_RasterFormat(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRasterFormat(String newRasterFormat) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlobTexture_RasterFormat(), newRasterFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getRasterCode() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcBlobTexture_RasterCode(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRasterCode(Tristate newRasterCode) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBlobTexture_RasterCode(), newRasterCode);
	}

} //IfcBlobTextureImpl
