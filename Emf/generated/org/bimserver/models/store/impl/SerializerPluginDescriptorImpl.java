/**
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.store.impl;

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
 *   <li>{@link org.bimserver.models.store.impl.SerializerPluginDescriptorImpl#getDefaultExtension <em>Default Extension</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerPluginDescriptorImpl#getDefaultContentType <em>Default Content Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SerializerPluginDescriptorImpl extends PluginDescriptorImpl implements SerializerPluginDescriptor {
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
	public String getDefaultExtension() {
		return (String) eGet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_EXTENSION, true);
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
		return (String) eGet(StorePackage.Literals.SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_CONTENT_TYPE, true);
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
