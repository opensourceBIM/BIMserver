/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDimensionCurveTerminator;
import org.bimserver.models.ifc2x3.IfcDimensionExtentUsage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Dimension Curve Terminator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionCurveTerminatorImpl#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDimensionCurveTerminatorImpl extends IfcTerminatorSymbolImpl implements IfcDimensionCurveTerminator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDimensionCurveTerminatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDimensionCurveTerminator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionExtentUsage getRole() {
		return (IfcDimensionExtentUsage)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionCurveTerminator_Role(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(IfcDimensionExtentUsage newRole) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDimensionCurveTerminator_Role(), newRole);
	}

} //IfcDimensionCurveTerminatorImpl
