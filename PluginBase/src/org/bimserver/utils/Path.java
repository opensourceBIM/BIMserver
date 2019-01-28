package org.bimserver.utils;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class Path {

	private IdEObject firstObject;
	private IdEObject lastObject;
	private Set<IdEObject> objects = new LinkedHashSet<IdEObject>();
	private List<Link> links = new ArrayList<Link>();

	public Path(IdEObject firstObject) {
		this.firstObject = firstObject;
		this.lastObject = firstObject;
		this.objects.add(firstObject);
	}

	public Path(Path path, EReference eReference, int index, IdEObject refIdEObject) {
		this.firstObject = path.getFirstObject();
		this.objects = new HashSet<>(path.getObjects());
		this.links = new ArrayList<Link>(path.getLinks());
		this.objects.add(refIdEObject);
		this.links.add(new Link(eReference, refIdEObject));
		this.lastObject = refIdEObject;
	}
	
	private Collection<? extends Link> getLinks() {
		return links;
	}

	public Set<IdEObject> getObjects() {
		return objects;
	}

	private IdEObject getFirstObject() {
		return firstObject;
	}

	public boolean contains(IdEObject refIdEObject) {
		return objects.contains(refIdEObject);
	}

	public EObject getLastObject() {
		return lastObject;
	}

	public int getLength() {
		return objects.size();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Link\n\t" + firstObject.eClass().getName());
		for (Link link : links) {
			builder.append("." + link + "\n\t");
		}
		return builder.toString();
	}
}