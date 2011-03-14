/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForceWarping;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Force Warping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleForceWarpingImpl#getWarpingMoment <em>Warping Moment</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleForceWarpingImpl#getWarpingMomentAsString <em>Warping Moment As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadSingleForceWarpingImpl extends IfcStructuralLoadSingleForceImpl implements IfcStructuralLoadSingleForceWarping {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleForceWarpingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWarpingMoment() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingMoment(float newWarpingMoment) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment(), newWarpingMoment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingMoment() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingMoment() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMoment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWarpingMomentAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingMomentAsString(String newWarpingMomentAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString(), newWarpingMomentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingMomentAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingMomentAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString());
	}

} //IfcStructuralLoadSingleForceWarpingImpl
