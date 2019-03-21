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
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Long Action State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getEnd <em>End</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getProgress <em>Progress</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.LongActionStateImpl#getTopicId <em>Topic Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LongActionStateImpl extends IdEObjectImpl implements LongActionState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LongActionStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.LONG_ACTION_STATE;
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
	public Date getStart() {
		return (Date) eGet(StorePackage.Literals.LONG_ACTION_STATE__START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStart(Date newStart) {
		eSet(StorePackage.Literals.LONG_ACTION_STATE__START, newStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getEnd() {
		return (Date) eGet(StorePackage.Literals.LONG_ACTION_STATE__END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnd(Date newEnd) {
		eSet(StorePackage.Literals.LONG_ACTION_STATE__END, newEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getProgress() {
		return (Integer) eGet(StorePackage.Literals.LONG_ACTION_STATE__PROGRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProgress(Integer newProgress) {
		eSet(StorePackage.Literals.LONG_ACTION_STATE__PROGRESS, newProgress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionState getState() {
		return (ActionState) eGet(StorePackage.Literals.LONG_ACTION_STATE__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setState(ActionState newState) {
		eSet(StorePackage.Literals.LONG_ACTION_STATE__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return (String) eGet(StorePackage.Literals.LONG_ACTION_STATE__TITLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		eSet(StorePackage.Literals.LONG_ACTION_STATE__TITLE, newTitle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStage() {
		return (Integer) eGet(StorePackage.Literals.LONG_ACTION_STATE__STAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(int newStage) {
		eSet(StorePackage.Literals.LONG_ACTION_STATE__STAGE, newStage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getErrors() {
		return (EList<String>) eGet(StorePackage.Literals.LONG_ACTION_STATE__ERRORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getWarnings() {
		return (EList<String>) eGet(StorePackage.Literals.LONG_ACTION_STATE__WARNINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getInfos() {
		return (EList<String>) eGet(StorePackage.Literals.LONG_ACTION_STATE__INFOS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getTopicId() {
		return (Long) eGet(StorePackage.Literals.LONG_ACTION_STATE__TOPIC_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopicId(long newTopicId) {
		eSet(StorePackage.Literals.LONG_ACTION_STATE__TOPIC_ID, newTopicId);
	}

} //LongActionStateImpl
