package org.bimserver.shared;

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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ChangeSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChangeSet {
	@XmlElement(name = "Addition")
	private List<Addition> additions = new ArrayList<Addition>();

	@XmlElement(name = "Modification")
	private List<Modification> modifications = new ArrayList<Modification>();

	@XmlElement(name = "Removal")
	private List<Removal> removals = new ArrayList<Removal>();

	public ChangeSet() {
	}

	public List<Addition> getAdditions() {
		return additions;
	}

	public List<Modification> getModifications() {
		return modifications;
	}

	public List<Removal> getRemovals() {
		return removals;
	}

	public Addition addAddition(Addition addition) {
		additions.add(addition);
		return addition;
	}

	public void addModification(Modification modification) {
		modifications.add(modification);
	}

	public void addRemoval(Removal removal) {
		removals.add(removal);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		System.out.println("ChangeSet");
		for (Addition addition : additions) {
			stringBuilder.append(addition.toString());
		}
		for (Modification modification : modifications) {
			stringBuilder.append(modification.toString());
		}
		for (Removal removal : removals) {
			stringBuilder.append(removal.toString());
		}
		return stringBuilder.toString();
	}
}