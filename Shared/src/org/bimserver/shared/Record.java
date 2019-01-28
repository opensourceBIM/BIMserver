package org.bimserver.shared;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Record {

	private EClass eClass;
	private final Map<EStructuralFeature, Object> values = new HashMap<EStructuralFeature, Object>();
	private long oid;

	public Record(EClass eClass) {
		this.eClass = eClass;
	}

	public void eUnset(EStructuralFeature structuralFeature) {
	}

	public void eSet(EStructuralFeature doubleStringFeature, String val) {
	}

	public void eSet(EStructuralFeature doubleStringFeature, boolean val) {
	}

	public void eSet(EStructuralFeature doubleStringFeature, Enumerator enumerator) {
	}
	
	public void setReference(EStructuralFeature eStructuralFeature, long referredOid) {
	}

	public void setWrapped(EStructuralFeature structuralFeature, EClass eClass, Enumerator enumerator) {
	}

	@SuppressWarnings("unchecked")
	public List<Record> getList(EStructuralFeature structuralFeature) {
		return (List<Record>) values.get(structuralFeature);
	}

	public EClass eClass() {
		return eClass;
	}

	public long getOid() {
		return oid;
	}
}