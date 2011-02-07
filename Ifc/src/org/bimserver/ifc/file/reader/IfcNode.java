package org.bimserver.ifc.file.reader;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class IfcNode {
	private EObject eObject;
	private List<WaitingObject> waitingObjects;
	
	public IfcNode(EObject eObject) {
		if (eObject == null) {
			throw new IllegalArgumentException();
		}
		this.eObject = eObject;
	}

	public IfcNode() {
		this.eObject = null;
	}

	public EObject getEObject() {
		return eObject;
	}

	public void addWaiting(EObject object, EStructuralFeature structuralFeature) {
		if (waitingObjects == null) {
			waitingObjects = new ArrayList<WaitingObject>();
		}
		waitingObjects.add(new WaitingObject(object, structuralFeature, -1));
	}

	public void setObject(EObject eObject) {
		this.eObject = eObject;
	}

	public List<WaitingObject> getWaiting() {
		return waitingObjects;
	}

	public void clearWaiting() {
		waitingObjects = null;
	}

	public void addWaiting(EObject object, EStructuralFeature structuralFeature, int index) {
		if (waitingObjects == null) {
			waitingObjects = new ArrayList<WaitingObject>();
		}
		waitingObjects.add(new WaitingObject(object, structuralFeature, index));
	}
}