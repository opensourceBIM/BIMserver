/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator3D;
import org.bimserver.models.ifc2x3.IfcDirection;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Transformation Operator3 D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator3DImpl#getAxis3 <em>Axis3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCartesianTransformationOperator3DImpl extends IfcCartesianTransformationOperatorImpl implements IfcCartesianTransformationOperator3D {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCartesianTransformationOperator3DImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3D();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getAxis3() {
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3D_Axis3(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxis3(IfcDirection newAxis3) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3D_Axis3(), newAxis3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAxis3() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3D_Axis3());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAxis3() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator3D_Axis3());
	}

} //IfcCartesianTransformationOperator3DImpl
