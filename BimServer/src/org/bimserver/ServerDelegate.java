//package org.bimserver;
//
///******************************************************************************
// * Copyright (C) 2009-2013  BIMserver.org
// * 
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU Affero General Public License as
// * published by the Free Software Foundation, either version 3 of the
// * License, or (at your option) any later version.
// * 
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU Affero General Public License for more details.
// * 
// * You should have received a copy of the GNU Affero General Public License
// * along with this program.  If not, see <http://www.gnu.org/licenses/>.
// *****************************************************************************/
//
//import org.bimserver.database.DatabaseSession;
//import org.bimserver.emf.Delegate;
//import org.bimserver.emf.IdEObject;
//import org.bimserver.emf.QueryInterface;
//import org.eclipse.emf.ecore.EStructuralFeature;
//
//public class ServerDelegate extends Delegate {
//
//	private DatabaseSession databaseSession;
//
//	public ServerDelegate(DatabaseSession databaseSession, IdEObject idEObject, QueryInterface queryInterface) {
//		super(idEObject, queryInterface);
//		this.databaseSession = databaseSession;
//		if (queryInterface == null || queryInterface.isDeep()) {
//			setState(State.NO_LAZY_LOADING);
//		} else {
//			setState(State.TO_BE_LOADED);
//		}
//	}
//
//	@Override
//	protected void internalLoad(IdEObject idEObject) {
//		databaseSession.load(idEObject);
//	}
//
//	@Override
//	public void loadForEdit() {
//	}
//
//	@Override
//	public void eUnset(EStructuralFeature eFeature) {
//		load();
//	}
//
//	@Override
//	public void eSet(EStructuralFeature eFeature, Object newValue) {
//		load();
//	}
//
//	@Override
//	public void eGet(EStructuralFeature eFeature) {
//		load();
//	}
//
//	@Override
//	public void eIsSet(EStructuralFeature eFeature) {
//		load();
//	}
//
//	@Override
//	public void eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
//		load();
//	}
//
//	@Override
//	public void eGet(EStructuralFeature eFeature, boolean resolve) {
//		load();
//	}
//
//	@Override
//	public void eGet(int featureID, boolean resolve, boolean coreType) {
//		load();
//	}
//
//	@Override
//	public void eSet(int featureID, Object newValue) {
//		load();
//	}
//
//	@Override
//	public void remove() {
//		super.remove();
//	}
//}