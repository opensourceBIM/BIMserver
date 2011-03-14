/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator2D;
import org.bimserver.models.ifc2x3.IfcSurfaceTexture;
import org.bimserver.models.ifc2x3.IfcSurfaceTextureEnum;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Texture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceTextureImpl#getRepeatS <em>Repeat S</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceTextureImpl#getRepeatT <em>Repeat T</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceTextureImpl#getTextureType <em>Texture Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceTextureImpl#getTextureTransform <em>Texture Transform</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSurfaceTextureImpl extends IdEObjectImpl implements IfcSurfaceTexture {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceTextureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture();
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
	public Tristate getRepeatS() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_RepeatS(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatS(Tristate newRepeatS) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_RepeatS(), newRepeatS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getRepeatT() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_RepeatT(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatT(Tristate newRepeatT) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_RepeatT(), newRepeatT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceTextureEnum getTextureType() {
		return (IfcSurfaceTextureEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_TextureType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextureType(IfcSurfaceTextureEnum newTextureType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_TextureType(), newTextureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator2D getTextureTransform() {
		return (IfcCartesianTransformationOperator2D)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_TextureTransform(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextureTransform(IfcCartesianTransformationOperator2D newTextureTransform) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_TextureTransform(), newTextureTransform);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextureTransform() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_TextureTransform());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextureTransform() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceTexture_TextureTransform());
	}

} //IfcSurfaceTextureImpl
