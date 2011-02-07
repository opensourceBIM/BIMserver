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
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> projects;

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
	 * The cached value of the '{@link #getRevisions() <em>Revisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevisions()
	 * @generated
	 * @ordered
	 */
	protected EList<Revision> revisions;

	/**
	 * The cached value of the '{@link #getIgnoredClasses() <em>Ignored Classes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoredClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ignoredClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClashDetectionSettingsImpl() {
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
	public EList<Project> getProjects() {
		if (projects == null) {
			projects = new EObjectWithInverseResolvingEList<Project>(Project.class, this, StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS, StorePackage.PROJECT__CLASH_DETECTION_SETTINGS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Revision> getRevisions() {
		if (revisions == null) {
			revisions = new EObjectResolvingEList<Revision>(Revision.class, this, StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS);
		}
		return revisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIgnoredClasses() {
		if (ignoredClasses == null) {
			ignoredClasses = new EDataTypeUniqueEList<String>(String.class, this, StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES);
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StorePackage.CLASH_DETECTION_SETTINGS__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case StorePackage.CLASH_DETECTION_SETTINGS__PROJECTS:
				return projects != null && !projects.isEmpty();
			case StorePackage.CLASH_DETECTION_SETTINGS__MARGIN:
				return margin != MARGIN_EDEFAULT;
			case StorePackage.CLASH_DETECTION_SETTINGS__REVISIONS:
				return revisions != null && !revisions.isEmpty();
			case StorePackage.CLASH_DETECTION_SETTINGS__IGNORED_CLASSES:
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", margin: ");
		result.append(margin);
		result.append(", ignoredClasses: ");
		result.append(ignoredClasses);
		result.append(')');
		return result.toString();
	}

} //ClashDetectionSettingsImpl
