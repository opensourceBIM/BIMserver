/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcProfileDef;
import org.bimserver.models.ifc2x3.IfcProfileTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProfileDefImpl#getProfileType <em>Profile Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProfileDefImpl#getProfileName <em>Profile Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcProfileDefImpl extends IdEObjectImpl implements IfcProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileTypeEnum getProfileType() {
		return (IfcProfileTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcProfileDef_ProfileType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileType(IfcProfileTypeEnum newProfileType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcProfileDef_ProfileType(), newProfileType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileName() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProfileDef_ProfileName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileName(String newProfileName) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcProfileDef_ProfileName(), newProfileName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProfileName() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProfileDef_ProfileName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProfileName() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProfileDef_ProfileName());
	}

} //IfcProfileDefImpl
