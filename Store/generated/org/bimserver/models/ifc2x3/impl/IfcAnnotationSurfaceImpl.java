/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAnnotationSurface;
import org.bimserver.models.ifc2x3.IfcGeometricRepresentationItem;
import org.bimserver.models.ifc2x3.IfcTextureCoordinate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Annotation Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAnnotationSurfaceImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAnnotationSurfaceImpl#getTextureCoordinates <em>Texture Coordinates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAnnotationSurfaceImpl extends IfcGeometricRepresentationItemImpl implements IfcAnnotationSurface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAnnotationSurfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcAnnotationSurface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricRepresentationItem getItem() {
		return (IfcGeometricRepresentationItem)eGet(Ifc2x3Package.eINSTANCE.getIfcAnnotationSurface_Item(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItem(IfcGeometricRepresentationItem newItem) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationSurface_Item(), newItem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextureCoordinate getTextureCoordinates() {
		return (IfcTextureCoordinate)eGet(Ifc2x3Package.eINSTANCE.getIfcAnnotationSurface_TextureCoordinates(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextureCoordinates(IfcTextureCoordinate newTextureCoordinates) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationSurface_TextureCoordinates(), newTextureCoordinates);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextureCoordinates() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAnnotationSurface_TextureCoordinates());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextureCoordinates() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationSurface_TextureCoordinates());
	}

} //IfcAnnotationSurfaceImpl
