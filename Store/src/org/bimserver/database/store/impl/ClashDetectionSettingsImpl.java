/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import java.util.Collection;

import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StorePackage;
import org.bimserver.emf.IdEObjectImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clash Detection Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.impl.ClashDetectionSettingsImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashDetectionSettingsImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashDetectionSettingsImpl#getMargin <em>Margin</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashDetectionSettingsImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.database.store.impl.ClashDetectionSettingsImpl#getIgnoredClasses <em>Ignored Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClashDetectionSettingsImpl extends IdEObjectImpl implements ClashDetectionSettings {
	/**
	 * An array of objects representing the values of non-primitive features.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Object[] eVirtualValues;

	/**
	 * A bit field representing the indices of non-primitive feature values.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int eVirtualIndexBits0;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getMargin() <em>Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMargin()
	 * @generated
	 * @ordered
	 */
	protected static final float MARGIN_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMargin() <em>Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMargin()
	 * @generated
	 * @ordered
	 */
	protected float margin = MARGIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClashDetectionSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.CLASH_DETECTION_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CLASH_DETECTION_SETTINGS__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMargin() {
		return margin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMargin(float newMargin) {
		float oldMargin = margin;
		margin = newMargin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StorePackage.CLASH_DETECTION_SETTINGS__MARGIN, oldMargin, margin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Project> getProjects() {
		EList<Project> projects = (EList<Project>)eVirtualGet(StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS);
		if (projects == null) {
			eVirtualSet(StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS, projects = new EObjectWithInverseResolvingEList<Project>(Project.class, this, StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS, StorePackage.PROJECT__CLASH_DETECTION_SETTINGS));
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Revision> getRevisions() {
		EList<Revision> revisions = (EList<Revision>)eVirtualGet(StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS);
		if (revisions == null) {
			eVirtualSet(StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS, revisions = new EObjectResolvingEList<Revision>(Revision.class, this, StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS));
		}
		return revisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getIgnoredClasses() {
		EList<String> ignoredClasses = (EList<String>)eVirtualGet(StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES);
		if (ignoredClasses == null) {
			eVirtualSet(StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES, ignoredClasses = new EDataTypeUniqueEList<String>(String.class, this, StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES));
		}
		return ignoredClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjects()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StorePackage.CLASH_DETECTION_SETTINGS__ENABLED:
				return isEnabled();
			case StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS:
				return getProjects();
			case StorePackage.CLASH_DETECTION_SETTINGS__MARGIN:
				return getMargin();
			case StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS:
				return getRevisions();
			case StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES:
				return getIgnoredClasses();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StorePackage.CLASH_DETECTION_SETTINGS__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends Project>)newValue);
				return;
			case StorePackage.CLASH_DETECTION_SETTINGS__MARGIN:
				setMargin((Float)newValue);
				return;
			case StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS:
				getRevisions().clear();
				getRevisions().addAll((Collection<? extends Revision>)newValue);
				return;
			case StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES:
				getIgnoredClasses().clear();
				getIgnoredClasses().addAll((Collection<? extends String>)newValue);
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
			case StorePackage.CLASH_DETECTION_SETTINGS__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS:
				getProjects().clear();
				return;
			case StorePackage.CLASH_DETECTION_SETTINGS__MARGIN:
				setMargin(MARGIN_EDEFAULT);
				return;
			case StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS:
				getRevisions().clear();
				return;
			case StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES:
				getIgnoredClasses().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StorePackage.CLASH_DETECTION_SETTINGS__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS:
				EList<Project> projects = (EList<Project>)eVirtualGet(StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS);
				return projects != null && !projects.isEmpty();
			case StorePackage.CLASH_DETECTION_SETTINGS__MARGIN:
				return margin != MARGIN_EDEFAULT;
			case StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS:
				EList<Revision> revisions = (EList<Revision>)eVirtualGet(StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS);
				return revisions != null && !revisions.isEmpty();
			case StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES:
				EList<String> ignoredClasses = (EList<String>)eVirtualGet(StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES);
				return ignoredClasses != null && !ignoredClasses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Object[] eVirtualValues() {
		return eVirtualValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void eSetVirtualValues(Object[] newValues) {
		eVirtualValues = newValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eVirtualIndexBits(int offset) {
		switch (offset) {
			case 0 :
				return eVirtualIndexBits0;
			default :
				throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void eSetVirtualIndexBits(int offset, int newIndexBits) {
		switch (offset) {
			case 0 :
				eVirtualIndexBits0 = newIndexBits;
				break;
			default :
				throw new IndexOutOfBoundsException();
		}
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", margin: ");
		result.append(margin);
		result.append(", ignoredClasses: ");
		result.append(eVirtualGet(StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES));
		result.append(')');
		return result.toString();
	}

} //ClashDetectionSettingsImpl
