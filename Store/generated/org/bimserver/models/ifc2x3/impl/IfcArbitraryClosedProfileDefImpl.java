/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcArbitraryClosedProfileDef;
import org.bimserver.models.ifc2x3.IfcCurve;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Arbitrary Closed Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcArbitraryClosedProfileDefImpl#getOuterCurve <em>Outer Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcArbitraryClosedProfileDefImpl extends IfcProfileDefImpl implements IfcArbitraryClosedProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcArbitraryClosedProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcArbitraryClosedProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getOuterCurve() {
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcArbitraryClosedProfileDef_OuterCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterCurve(IfcCurve newOuterCurve) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcArbitraryClosedProfileDef_OuterCurve(), newOuterCurve);
	}

} //IfcArbitraryClosedProfileDefImpl
