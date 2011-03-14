/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianPointImpl#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianPointImpl#getCoordinatesAsString <em>Coordinates As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianPointImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCartesianPointImpl extends IfcPointImpl implements IfcCartesianPoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCartesianPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCartesianPoint();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Float> getCoordinates() {
		return (EList<Float>)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianPoint_Coordinates(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getCoordinatesAsString() {
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianPoint_CoordinatesAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianPoint_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianPoint_Dim(), newDim);
	}

} //IfcCartesianPointImpl
