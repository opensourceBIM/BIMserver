/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConnectedFaceSet;
import org.bimserver.models.ifc2x3.IfcFaceBasedSurfaceModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Face Based Surface Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFaceBasedSurfaceModelImpl#getFbsmFaces <em>Fbsm Faces</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFaceBasedSurfaceModelImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFaceBasedSurfaceModelImpl extends IfcGeometricRepresentationItemImpl implements IfcFaceBasedSurfaceModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFaceBasedSurfaceModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFaceBasedSurfaceModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConnectedFaceSet> getFbsmFaces() {
		return (EList<IfcConnectedFaceSet>)eGet(Ifc2x3Package.eINSTANCE.getIfcFaceBasedSurfaceModel_FbsmFaces(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcFaceBasedSurfaceModel_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcFaceBasedSurfaceModel_Dim(), newDim);
	}

} //IfcFaceBasedSurfaceModelImpl
