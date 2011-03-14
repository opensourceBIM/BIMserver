/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAddress;
import org.bimserver.models.ifc2x3.IfcAddressTypeEnum;
import org.bimserver.models.ifc2x3.IfcOrganization;
import org.bimserver.models.ifc2x3.IfcPerson;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getUserDefinedPurpose <em>User Defined Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getOfPerson <em>Of Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getOfOrganization <em>Of Organization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAddressImpl extends IdEObjectImpl implements IfcAddress {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcAddress();
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
	public IfcAddressTypeEnum getPurpose() {
		return (IfcAddressTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcAddress_Purpose(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(IfcAddressTypeEnum newPurpose) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAddress_Purpose(), newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAddress_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAddress_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAddress_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAddress_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedPurpose() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAddress_UserDefinedPurpose(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedPurpose(String newUserDefinedPurpose) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAddress_UserDefinedPurpose(), newUserDefinedPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedPurpose() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAddress_UserDefinedPurpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedPurpose() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAddress_UserDefinedPurpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPerson> getOfPerson() {
		return (EList<IfcPerson>)eGet(Ifc2x3Package.eINSTANCE.getIfcAddress_OfPerson(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcOrganization> getOfOrganization() {
		return (EList<IfcOrganization>)eGet(Ifc2x3Package.eINSTANCE.getIfcAddress_OfOrganization(), true);
	}

} //IfcAddressImpl
