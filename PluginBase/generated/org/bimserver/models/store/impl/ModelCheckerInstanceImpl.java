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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Checker Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerInstanceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerInstanceImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerInstanceImpl#getCompiled <em>Compiled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerInstanceImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerInstanceImpl#getModelCheckerPluginClassName <em>Model Checker Plugin Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelCheckerInstanceImpl extends IdEObjectImpl implements ModelCheckerInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelCheckerInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.MODEL_CHECKER_INSTANCE;
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
	public String getName() {
		return (String) eGet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCode() {
		return (String) eGet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCode(String newCode) {
		eSet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__CODE, newCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getCompiled() {
		return (byte[]) eGet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__COMPILED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompiled(byte[] newCompiled) {
		eSet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__COMPILED, newCompiled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isValid() {
		return (Boolean) eGet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__VALID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValid(boolean newValid) {
		eSet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__VALID, newValid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelCheckerPluginClassName() {
		return (String) eGet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__MODEL_CHECKER_PLUGIN_CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelCheckerPluginClassName(String newModelCheckerPluginClassName) {
		eSet(StorePackage.Literals.MODEL_CHECKER_INSTANCE__MODEL_CHECKER_PLUGIN_CLASS_NAME, newModelCheckerPluginClassName);
	}

} //ModelCheckerInstanceImpl
