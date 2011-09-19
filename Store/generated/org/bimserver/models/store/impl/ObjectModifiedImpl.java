/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.models.store.ObjectModified;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Modified</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ObjectModifiedImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ObjectModifiedImpl#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ObjectModifiedImpl#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectModifiedImpl extends CompareItemImpl implements ObjectModified {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectModifiedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.OBJECT_MODIFIED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldName() {
		return (String)eGet(StorePackage.Literals.OBJECT_MODIFIED__FIELD_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldName(String newFieldName) {
		eSet(StorePackage.Literals.OBJECT_MODIFIED__FIELD_NAME, newFieldName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldValue() {
		return (String)eGet(StorePackage.Literals.OBJECT_MODIFIED__OLD_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldValue(String newOldValue) {
		eSet(StorePackage.Literals.OBJECT_MODIFIED__OLD_VALUE, newOldValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewValue() {
		return (String)eGet(StorePackage.Literals.OBJECT_MODIFIED__NEW_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(String newNewValue) {
		eSet(StorePackage.Literals.OBJECT_MODIFIED__NEW_VALUE, newNewValue);
	}

} //ObjectModifiedImpl
