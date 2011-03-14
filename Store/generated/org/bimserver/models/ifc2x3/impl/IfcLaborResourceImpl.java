/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcLaborResource;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Labor Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLaborResourceImpl#getSkillSet <em>Skill Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLaborResourceImpl extends IfcConstructionResourceImpl implements IfcLaborResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLaborResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcLaborResource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSkillSet() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLaborResource_SkillSet(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkillSet(String newSkillSet) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLaborResource_SkillSet(), newSkillSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSkillSet() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLaborResource_SkillSet());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSkillSet() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLaborResource_SkillSet());
	}

} //IfcLaborResourceImpl
