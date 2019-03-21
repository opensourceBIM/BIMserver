/**
 * Copyright (C) 2009-2014 BIMserver.org
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

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Date;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.PluginBundleType;
import org.bimserver.models.store.PluginBundleVersion;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin Bundle Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#isMismatch <em>Mismatch</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleVersionImpl#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PluginBundleVersionImpl extends IdEObjectImpl implements PluginBundleVersion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginBundleVersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.PLUGIN_BUNDLE_VERSION;
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
	@Override
	public String getVersion() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginBundleType getType() {
		return (PluginBundleType) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(PluginBundleType newType) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMismatch() {
		return (Boolean) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__MISMATCH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMismatch(boolean newMismatch) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__MISMATCH, newMismatch);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRepository() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__REPOSITORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepository(String newRepository) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__REPOSITORY, newRepository);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGroupId() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__GROUP_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroupId(String newGroupId) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__GROUP_ID, newGroupId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getArtifactId() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__ARTIFACT_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArtifactId(String newArtifactId) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__ARTIFACT_ID, newArtifactId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getIcon() {
		return (byte[]) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__ICON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIcon(byte[] newIcon) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__ICON, newIcon);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOrganization() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__ORGANIZATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrganization(String newOrganization) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__ORGANIZATION, newOrganization);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return (Date) eGet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE_VERSION__DATE, newDate);
	}

} //PluginBundleVersionImpl
