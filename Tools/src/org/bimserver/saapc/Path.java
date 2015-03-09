package org.bimserver.saapc;

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
		this.links.add(new Link(eReference, index, refIdEObject));
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