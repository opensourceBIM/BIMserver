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

import org.bimserver.models.store.ModelCheckerResultLine;
import org.bimserver.models.store.ModelCheckerResultType;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Checker Result Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerResultLineImpl#getFieldOrClass <em>Field Or Class</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerResultLineImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerResultLineImpl#getShouldBe <em>Should Be</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerResultLineImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ModelCheckerResultLineImpl#getObjectId <em>Object Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelCheckerResultLineImpl extends ModelCheckerResultItemImpl implements ModelCheckerResultLine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelCheckerResultLineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.MODEL_CHECKER_RESULT_LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFieldOrClass() {
		return (String) eGet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__FIELD_OR_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFieldOrClass(String newFieldOrClass) {
		eSet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__FIELD_OR_CLASS, newFieldOrClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValue() {
		return (String) eGet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(String newValue) {
		eSet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getShouldBe() {
		return (String) eGet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__SHOULD_BE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShouldBe(String newShouldBe) {
		eSet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__SHOULD_BE, newShouldBe);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelCheckerResultType getType() {
		return (ModelCheckerResultType) eGet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(ModelCheckerResultType newType) {
		eSet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getObjectId() {
		return (Long) eGet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__OBJECT_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectId(long newObjectId) {
		eSet(StorePackage.Literals.MODEL_CHECKER_RESULT_LINE__OBJECT_ID, newObjectId);
	}

} //ModelCheckerResultLineImpl
