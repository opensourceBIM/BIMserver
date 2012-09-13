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

import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.ObjectIDM;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getObjectIDM <em>Object IDM</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SerializerImpl#getIfcEngine <em>Ifc Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SerializerImpl extends PluginImpl implements Serializer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SerializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SERIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtension() {
		return (String) eGet(StorePackage.Literals.SERIALIZER__EXTENSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(String newExtension) {
		eSet(StorePackage.Literals.SERIALIZER__EXTENSION, newExtension);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContentType() {
		return (String) eGet(StorePackage.Literals.SERIALIZER__CONTENT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentType(String newContentType) {
		eSet(StorePackage.Literals.SERIALIZER__CONTENT_TYPE, newContentType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectIDM getObjectIDM() {
		return (ObjectIDM) eGet(StorePackage.Literals.SERIALIZER__OBJECT_IDM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectIDM(ObjectIDM newObjectIDM) {
		eSet(StorePackage.Literals.SERIALIZER__OBJECT_IDM, newObjectIDM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserSettings getSettings() {
		return (UserSettings) eGet(StorePackage.Literals.SERIALIZER__SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettings(UserSettings newSettings) {
		eSet(StorePackage.Literals.SERIALIZER__SETTINGS, newSettings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEngine getIfcEngine() {
		return (IfcEngine) eGet(StorePackage.Literals.SERIALIZER__IFC_ENGINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfcEngine(IfcEngine newIfcEngine) {
		eSet(StorePackage.Literals.SERIALIZER__IFC_ENGINE, newIfcEngine);
	}

} //SerializerImpl
