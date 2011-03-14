/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcArbitraryProfileDefWithVoids;
import org.bimserver.models.ifc2x3.IfcCurve;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Arbitrary Profile Def With Voids</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcArbitraryProfileDefWithVoidsImpl#getInnerCurves <em>Inner Curves</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcArbitraryProfileDefWithVoidsImpl extends IfcArbitraryClosedProfileDefImpl implements IfcArbitraryProfileDefWithVoids {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcArbitraryProfileDefWithVoidsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcArbitraryProfileDefWithVoids();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcCurve> getInnerCurves() {
		return (EList<IfcCurve>)eGet(Ifc2x3Package.eINSTANCE.getIfcArbitraryProfileDefWithVoids_InnerCurves(), true);
	}

} //IfcArbitraryProfileDefWithVoidsImpl
