/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator;
import org.bimserver.models.ifc2x3.IfcDirection;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Transformation Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperatorImpl#getAxis1 <em>Axis1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperatorImpl#getAxis2 <em>Axis2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperatorImpl#getLocalOrigin <em>Local Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperatorImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperatorImpl#getScaleAsString <em>Scale As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperatorImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCartesianTransformationOperatorImpl extends IfcGeometricRepresentationItemImpl implements IfcCartesianTransformationOperator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCartesianTransformationOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getAxis1() {
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxis1(IfcDirection newAxis1) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1(), newAxis1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAxis1() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAxis1() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getAxis2() {
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxis2(IfcDirection newAxis2) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2(), newAxis2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAxis2() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAxis2() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getLocalOrigin() {
		return (IfcCartesianPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_LocalOrigin(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalOrigin(IfcCartesianPoint newLocalOrigin) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_LocalOrigin(), newLocalOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getScale() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scale(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale(float newScale) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Scale(), newScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScaleAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_ScaleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScaleAsString(String newScaleAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_ScaleAsString(), newScaleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator_Dim(), newDim);
	}

} //IfcCartesianTransformationOperatorImpl
