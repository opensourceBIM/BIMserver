/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.SerializerPluginDescriptor;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serializer Plugin Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.SerializerPluginDescriptorImpl#getPluginClassName <em>Plugin Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerPluginDescriptorImpl#getDefaultName <em>Default Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerPluginDescriptorImpl#getDefaultExtension <em>Default Extension</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerPluginDescriptorImpl#getDefaultContentType <em>Default Content Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SerializerPluginDescriptorImpl extends IdEObjectImpl implements SerializerPluginDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SerializerPluginDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR;
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
	public String getPluginClassName() {
		return (String)eGet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginClassName(String newPluginClassName) {
		eSet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME, newPluginClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultName() {
		return (String)eGet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultName(String newDefaultName) {
		eSet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_NAME, newDefaultName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultExtension() {
		return (String)eGet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_EXTENSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultExtension(String newDefaultExtension) {
		eSet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_EXTENSION, newDefaultExtension);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultContentType() {
		return (String)eGet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_CONTENT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultContentType(String newDefaultContentType) {
		eSet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_CONTENT_TYPE, newDefaultContentType);
	}

} //SerializerPluginDescriptorImpl
