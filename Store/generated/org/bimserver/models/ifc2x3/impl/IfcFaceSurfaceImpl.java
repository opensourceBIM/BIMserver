/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcFaceSurface;
import org.bimserver.models.ifc2x3.IfcSurface;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Face Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFaceSurfaceImpl#getFaceSurface <em>Face Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFaceSurfaceImpl#getSameSense <em>Same Sense</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFaceSurfaceImpl extends IfcFaceImpl implements IfcFaceSurface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFaceSurfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFaceSurface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getFaceSurface() {
		return (IfcSurface)eGet(Ifc2x3Package.eINSTANCE.getIfcFaceSurface_FaceSurface(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaceSurface(IfcSurface newFaceSurface) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcFaceSurface_FaceSurface(), newFaceSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getSameSense() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcFaceSurface_SameSense(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSameSense(Tristate newSameSense) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcFaceSurface_SameSense(), newSameSense);
	}

} //IfcFaceSurfaceImpl
