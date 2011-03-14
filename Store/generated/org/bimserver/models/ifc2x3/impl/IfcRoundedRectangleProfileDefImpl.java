/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rounded Rectangle Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRoundedRectangleProfileDefImpl#getRoundingRadius <em>Rounding Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRoundedRectangleProfileDefImpl#getRoundingRadiusAsString <em>Rounding Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRoundedRectangleProfileDefImpl extends IfcRectangleProfileDefImpl implements IfcRoundedRectangleProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRoundedRectangleProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRoundedRectangleProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRoundingRadius() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRoundedRectangleProfileDef_RoundingRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundingRadius(float newRoundingRadius) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRoundedRectangleProfileDef_RoundingRadius(), newRoundingRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoundingRadiusAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRoundedRectangleProfileDef_RoundingRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundingRadiusAsString(String newRoundingRadiusAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRoundedRectangleProfileDef_RoundingRadiusAsString(), newRoundingRadiusAsString);
	}

} //IfcRoundedRectangleProfileDefImpl
