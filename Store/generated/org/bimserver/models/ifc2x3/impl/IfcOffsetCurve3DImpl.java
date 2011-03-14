/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCurve;
import org.bimserver.models.ifc2x3.IfcDirection;
import org.bimserver.models.ifc2x3.IfcOffsetCurve3D;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Offset Curve3 D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#getDistance <em>Distance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#getDistanceAsString <em>Distance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#isSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl#getRefDirection <em>Ref Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcOffsetCurve3DImpl extends IfcCurveImpl implements IfcOffsetCurve3D {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOffsetCurve3DImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getBasisCurve() {
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_BasisCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisCurve(IfcCurve newBasisCurve) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_BasisCurve(), newBasisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDistance() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_Distance(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistance(float newDistance) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_Distance(), newDistance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistanceAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_DistanceAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistanceAsString(String newDistanceAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_DistanceAsString(), newDistanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelfIntersect() {
		return (Boolean)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_SelfIntersect(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfIntersect(boolean newSelfIntersect) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_SelfIntersect(), newSelfIntersect);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getRefDirection() {
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_RefDirection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefDirection(IfcDirection newRefDirection) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcOffsetCurve3D_RefDirection(), newRefDirection);
	}

} //IfcOffsetCurve3DImpl
