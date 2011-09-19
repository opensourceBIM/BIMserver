/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.models.store.ReferenceDataValue;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Data Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ReferenceDataValueImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ReferenceDataValueImpl#getGuid <em>Guid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceDataValueImpl extends DataValueImpl implements ReferenceDataValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceDataValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.REFERENCE_DATA_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeName() {
		return (String)eGet(StorePackage.Literals.REFERENCE_DATA_VALUE__TYPE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(String newTypeName) {
		eSet(StorePackage.Literals.REFERENCE_DATA_VALUE__TYPE_NAME, newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuid() {
		return (String)eGet(StorePackage.Literals.REFERENCE_DATA_VALUE__GUID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuid(String newGuid) {
		eSet(StorePackage.Literals.REFERENCE_DATA_VALUE__GUID, newGuid);
	}

} //ReferenceDataValueImpl
