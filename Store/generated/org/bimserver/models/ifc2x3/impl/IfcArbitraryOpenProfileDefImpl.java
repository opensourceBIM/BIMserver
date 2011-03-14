/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcArbitraryOpenProfileDef;
import org.bimserver.models.ifc2x3.IfcBoundedCurve;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Arbitrary Open Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcArbitraryOpenProfileDefImpl#getCurve <em>Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcArbitraryOpenProfileDefImpl extends IfcProfileDefImpl implements IfcArbitraryOpenProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcArbitraryOpenProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcArbitraryOpenProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundedCurve getCurve() {
		return (IfcBoundedCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcArbitraryOpenProfileDef_Curve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurve(IfcBoundedCurve newCurve) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcArbitraryOpenProfileDef_Curve(), newCurve);
	}

} //IfcArbitraryOpenProfileDefImpl
