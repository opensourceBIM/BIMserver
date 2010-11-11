/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import org.bimserver.database.store.Clash;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StorePackage;
import org.bimserver.emf.IdEObjectImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clash</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.ClashImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashImpl#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashImpl#getType1 <em>Type1</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashImpl#getType2 <em>Type2</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashImpl#getRevision1 <em>Revision1</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashImpl#getRevision2 <em>Revision2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClashImpl extends IdEObjectImpl implements Clash {
	/**
	 * The default value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected String name1 = NAME1_EDEFAULT;

	/**
	 * The default value of the '{@link #getName2() <em>Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName2()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName2() <em>Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName2()
	 * @generated
	 * @ordered
	 */
	protected String name2 = NAME2_EDEFAULT;

	/**
	 * The default value of the '{@link #getType1() <em>Type1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType1()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType1() <em>Type1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType1()
	 * @generated
	 * @ordered
	 */
	protected String type1 = TYPE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getType2() <em>Type2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType2()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType2() <em>Type2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType2()
	 * @generated
	 * @ordered
	 */
	protected String type2 = TYPE2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRevision1() <em>Revision1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision1()
	 * @generated
	 * @ordered
	 */
	protected Revision revision1;

	/**
	 * The cached value of the '{@link #getRevision2() <em>Revision2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision2()
	 * @generated
	 * @ordered
	 */
	protected Revision revision2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClashImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.CLASH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName1(String newName1) {
		String oldName1 = name1;
		name1 = newName1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CLASH__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName2() {
		return name2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName2(String newName2) {
		String oldName2 = name2;
		name2 = newName2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CLASH__NAME2, oldName2, name2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType1() {
		return type1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType1(String newType1) {
		String oldType1 = type1;
		type1 = newType1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CLASH__TYPE1, oldType1, type1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType2() {
		return type2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType2(String newType2) {
		String oldType2 = type2;
		type2 = newType2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CLASH__TYPE2, oldType2, type2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision1() {
		if (revision1 != null && ((EObject)revision1).eIsProxy()) {
			InternalEObject oldRevision1 = (InternalEObject)revision1;
			revision1 = (Revision)eResolveProxy(oldRevision1);
			if (revision1 != oldRevision1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.CLASH__REVISION1, oldRevision1, revision1));
			}
		}
		return revision1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision basicGetRevision1() {
		return revision1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision1(Revision newRevision1) {
		Revision oldRevision1 = revision1;
		revision1 = newRevision1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CLASH__REVISION1, oldRevision1, revision1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getRevision2() {
		if (revision2 != null && ((EObject)revision2).eIsProxy()) {
			InternalEObject oldRevision2 = (InternalEObject)revision2;
			revision2 = (Revision)eResolveProxy(oldRevision2);
			if (revision2 != oldRevision2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StorePackage.CLASH__REVISION2, oldRevision2, revision2));
			}
		}
		return revision2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision basicGetRevision2() {
		return revision2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision2(Revision newRevision2) {
		Revision oldRevision2 = revision2;
		revision2 = newRevision2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CLASH__REVISION2, oldRevision2, revision2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StorePackage.CLASH__NAME1:
				return getName1();
			case StorePackage.CLASH__NAME2:
				return getName2();
			case StorePackage.CLASH__TYPE1:
				return getType1();
			case StorePackage.CLASH__TYPE2:
				return getType2();
			case StorePackage.CLASH__REVISION1:
				if (resolve) return getRevision1();
				return basicGetRevision1();
			case StorePackage.CLASH__REVISION2:
				if (resolve) return getRevision2();
				return basicGetRevision2();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StorePackage.CLASH__NAME1:
				setName1((String)newValue);
				return;
			case StorePackage.CLASH__NAME2:
				setName2((String)newValue);
				return;
			case StorePackage.CLASH__TYPE1:
				setType1((String)newValue);
				return;
			case StorePackage.CLASH__TYPE2:
				setType2((String)newValue);
				return;
			case StorePackage.CLASH__REVISION1:
				setRevision1((Revision)newValue);
				return;
			case StorePackage.CLASH__REVISION2:
				setRevision2((Revision)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StorePackage.CLASH__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case StorePackage.CLASH__NAME2:
				setName2(NAME2_EDEFAULT);
				return;
			case StorePackage.CLASH__TYPE1:
				setType1(TYPE1_EDEFAULT);
				return;
			case StorePackage.CLASH__TYPE2:
				setType2(TYPE2_EDEFAULT);
				return;
			case StorePackage.CLASH__REVISION1:
				setRevision1((Revision)null);
				return;
			case StorePackage.CLASH__REVISION2:
				setRevision2((Revision)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StorePackage.CLASH__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case StorePackage.CLASH__NAME2:
				return NAME2_EDEFAULT == null ? name2 != null : !NAME2_EDEFAULT.equals(name2);
			case StorePackage.CLASH__TYPE1:
				return TYPE1_EDEFAULT == null ? type1 != null : !TYPE1_EDEFAULT.equals(type1);
			case StorePackage.CLASH__TYPE2:
				return TYPE2_EDEFAULT == null ? type2 != null : !TYPE2_EDEFAULT.equals(type2);
			case StorePackage.CLASH__REVISION1:
				return revision1 != null;
			case StorePackage.CLASH__REVISION2:
				return revision2 != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name1: ");
		result.append(name1);
		result.append(", name2: ");
		result.append(name2);
		result.append(", type1: ");
		result.append(type1);
		result.append(", type2: ");
		result.append(type2);
		result.append(')');
		return result.toString();
	}

} //ClashImpl
