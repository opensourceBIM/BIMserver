/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.impl;

import org.bimserver.database.store.CheckinState;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.Clash;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.EidClash;
import org.bimserver.database.store.GeoTag;
import org.bimserver.database.store.GuidClash;
import org.bimserver.database.store.ObjectState;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.SIPrefix;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoreFactoryImpl extends EFactoryImpl implements StoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StoreFactory init() {
		try {
			StoreFactory theStoreFactory = (StoreFactory)EPackage.Registry.INSTANCE.getEFactory("store"); 
			if (theStoreFactory != null) {
				return theStoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StorePackage.PROJECT: return (EObject)createProject();
			case StorePackage.USER: return (EObject)createUser();
			case StorePackage.CHECKOUT: return (EObject)createCheckout();
			case StorePackage.GEO_TAG: return (EObject)createGeoTag();
			case StorePackage.CONCRETE_REVISION: return (EObject)createConcreteRevision();
			case StorePackage.REVISION: return (EObject)createRevision();
			case StorePackage.GUID_CLASH: return (EObject)createGuidClash();
			case StorePackage.CLASH_DETECTION_SETTINGS: return (EObject)createClashDetectionSettings();
			case StorePackage.CLASH: return (EObject)createClash();
			case StorePackage.EID_CLASH: return (EObject)createEidClash();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StorePackage.OBJECT_STATE:
				return createObjectStateFromString(eDataType, initialValue);
			case StorePackage.USER_TYPE:
				return createUserTypeFromString(eDataType, initialValue);
			case StorePackage.SI_PREFIX:
				return createSIPrefixFromString(eDataType, initialValue);
			case StorePackage.CHECKIN_STATE:
				return createCheckinStateFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StorePackage.OBJECT_STATE:
				return convertObjectStateToString(eDataType, instanceValue);
			case StorePackage.USER_TYPE:
				return convertUserTypeToString(eDataType, instanceValue);
			case StorePackage.SI_PREFIX:
				return convertSIPrefixToString(eDataType, instanceValue);
			case StorePackage.CHECKIN_STATE:
				return convertCheckinStateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Checkout createCheckout() {
		CheckoutImpl checkout = new CheckoutImpl();
		return checkout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoTag createGeoTag() {
		GeoTagImpl geoTag = new GeoTagImpl();
		return geoTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevision createConcreteRevision() {
		ConcreteRevisionImpl concreteRevision = new ConcreteRevisionImpl();
		return concreteRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision createRevision() {
		RevisionImpl revision = new RevisionImpl();
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuidClash createGuidClash() {
		GuidClashImpl guidClash = new GuidClashImpl();
		return guidClash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clash createClash() {
		ClashImpl clash = new ClashImpl();
		return clash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EidClash createEidClash() {
		EidClashImpl eidClash = new EidClashImpl();
		return eidClash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClashDetectionSettings createClashDetectionSettings() {
		ClashDetectionSettingsImpl clashDetectionSettings = new ClashDetectionSettingsImpl();
		return clashDetectionSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectState createObjectStateFromString(EDataType eDataType, String initialValue) {
		ObjectState result = ObjectState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserType createUserTypeFromString(EDataType eDataType, String initialValue) {
		UserType result = UserType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUserTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIPrefix createSIPrefixFromString(EDataType eDataType, String initialValue) {
		SIPrefix result = SIPrefix.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSIPrefixToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinState createCheckinStateFromString(EDataType eDataType, String initialValue) {
		CheckinState result = CheckinState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCheckinStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorePackage getStorePackage() {
		return (StorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StorePackage getPackage() {
		return StorePackage.eINSTANCE;
	}

} //StoreFactoryImpl
