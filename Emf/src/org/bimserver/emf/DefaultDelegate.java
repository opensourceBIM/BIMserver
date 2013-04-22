package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 *****************************************************************************/

import org.eclipse.emf.ecore.EStructuralFeature;

public class DefaultDelegate extends Delegate {

	public DefaultDelegate(IdEObject idEObject, QueryInterface queryInterface) {
		super(idEObject, queryInterface);
	}

	@Override
	protected void internalLoad(IdEObject idEObject) {
	}

	@Override
	public void loadForEdit() {
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
	}

	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
	}

	@Override
	public void eGet(EStructuralFeature eFeature) {
	}

	@Override
	public void eIsSet(EStructuralFeature eFeature) {
	}

	@Override
	public void eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
	}

	@Override
	public void eGet(EStructuralFeature eFeature, boolean resolve) {
	}

	@Override
	public void eGet(int featureID, boolean resolve, boolean coreType) {
	}

	@Override
	public void eSet(int featureID, Object newValue) {
	}

	@Override
	public void remove() {
		super.remove();
	}
}