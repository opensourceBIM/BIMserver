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
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getImplementationLevel <em>Implementation Level</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getTimeStamp <em>Time Stamp</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getPreProcessorVersion <em>Pre Processor Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getOriginatingSystem <em>Originating System</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getIfcSchemaVersion <em>Ifc Schema Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcHeaderImpl#getAuthorization <em>Authorization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcHeaderImpl extends IdEObjectImpl implements IfcHeader {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcHeaderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.IFC_HEADER;
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
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getDescription() {
		return (EList<String>) eGet(StorePackage.Literals.IFC_HEADER__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImplementationLevel() {
		return (String) eGet(StorePackage.Literals.IFC_HEADER__IMPLEMENTATION_LEVEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplementationLevel(String newImplementationLevel) {
		eSet(StorePackage.Literals.IFC_HEADER__IMPLEMENTATION_LEVEL, newImplementationLevel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilename() {
		return (String) eGet(StorePackage.Literals.IFC_HEADER__FILENAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilename(String newFilename) {
		eSet(StorePackage.Literals.IFC_HEADER__FILENAME, newFilename);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getTimeStamp() {
		return (Date) eGet(StorePackage.Literals.IFC_HEADER__TIME_STAMP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeStamp(Date newTimeStamp) {
		eSet(StorePackage.Literals.IFC_HEADER__TIME_STAMP, newTimeStamp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getAuthor() {
		return (EList<String>) eGet(StorePackage.Literals.IFC_HEADER__AUTHOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getOrganization() {
		return (EList<String>) eGet(StorePackage.Literals.IFC_HEADER__ORGANIZATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPreProcessorVersion() {
		return (String) eGet(StorePackage.Literals.IFC_HEADER__PRE_PROCESSOR_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreProcessorVersion(String newPreProcessorVersion) {
		eSet(StorePackage.Literals.IFC_HEADER__PRE_PROCESSOR_VERSION, newPreProcessorVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOriginatingSystem() {
		return (String) eGet(StorePackage.Literals.IFC_HEADER__ORIGINATING_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginatingSystem(String newOriginatingSystem) {
		eSet(StorePackage.Literals.IFC_HEADER__ORIGINATING_SYSTEM, newOriginatingSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIfcSchemaVersion() {
		return (String) eGet(StorePackage.Literals.IFC_HEADER__IFC_SCHEMA_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIfcSchemaVersion(String newIfcSchemaVersion) {
		eSet(StorePackage.Literals.IFC_HEADER__IFC_SCHEMA_VERSION, newIfcSchemaVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthorization() {
		return (String) eGet(StorePackage.Literals.IFC_HEADER__AUTHORIZATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthorization(String newAuthorization) {
		eSet(StorePackage.Literals.IFC_HEADER__AUTHORIZATION, newAuthorization);
	}

} //IfcHeaderImpl
