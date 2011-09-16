/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Serializer Plugin Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.SerializerPluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultName <em>Default Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultExtension <em>Default Extension</em>}</li>
 *   <li>{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultContentType <em>Default Content Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getSerializerPluginDescriptor()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface SerializerPluginDescriptor extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Plugin Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Class Name</em>' attribute.
	 * @see #setPluginClassName(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginDescriptor_PluginClassName()
	 * @model
	 * @generated
	 */
	String getPluginClassName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Class Name</em>' attribute.
	 * @see #getPluginClassName()
	 * @generated
	 */
	void setPluginClassName(String value);

	/**
	 * Returns the value of the '<em><b>Default Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Name</em>' attribute.
	 * @see #setDefaultName(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginDescriptor_DefaultName()
	 * @model
	 * @generated
	 */
	String getDefaultName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultName <em>Default Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Name</em>' attribute.
	 * @see #getDefaultName()
	 * @generated
	 */
	void setDefaultName(String value);

	/**
	 * Returns the value of the '<em><b>Default Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Extension</em>' attribute.
	 * @see #setDefaultExtension(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginDescriptor_DefaultExtension()
	 * @model
	 * @generated
	 */
	String getDefaultExtension();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultExtension <em>Default Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Extension</em>' attribute.
	 * @see #getDefaultExtension()
	 * @generated
	 */
	void setDefaultExtension(String value);

	/**
	 * Returns the value of the '<em><b>Default Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Content Type</em>' attribute.
	 * @see #setDefaultContentType(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginDescriptor_DefaultContentType()
	 * @model
	 * @generated
	 */
	String getDefaultContentType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultContentType <em>Default Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Content Type</em>' attribute.
	 * @see #getDefaultContentType()
	 * @generated
	 */
	void setDefaultContentType(String value);

} // SerializerPluginDescriptor
