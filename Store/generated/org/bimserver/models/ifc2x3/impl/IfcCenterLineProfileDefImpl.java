/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCenterLineProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Center Line Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCenterLineProfileDefImpl#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCenterLineProfileDefImpl#getThicknessAsString <em>Thickness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCenterLineProfileDefImpl extends IfcArbitraryOpenProfileDefImpl implements IfcCenterLineProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCenterLineProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCenterLineProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThickness() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCenterLineProfileDef_Thickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThickness(float newThickness) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCenterLineProfileDef_Thickness(), newThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThicknessAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCenterLineProfileDef_ThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThicknessAsString(String newThicknessAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCenterLineProfileDef_ThicknessAsString(), newThicknessAsString);
	}

} //IfcCenterLineProfileDefImpl
