package org.bimserver.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.plugins.ObjectAlreadyExistsException;

public class GeometryTargetImpl implements GeometryTarget {

	private PackageMetaData packageMetaData;
	private final Map<Long, IdEObject> objects = new HashMap<>();

	public GeometryTargetImpl(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}
	
	@Override
	public <T extends IdEObject> T create(Class<T> clazz) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		T object = packageMetaData.create(clazz);
		return object;
	}

	@Override
	public IdEObject get(long oid) {
		return objects.get(oid);
	}

	@Override
	public void add(long oid, IdEObject idEObject) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		this.objects.put(oid, idEObject);
	}
	
	public Set<GeometryInfo> getAllGeometryInfo() {
		Set<GeometryInfo> result = new HashSet<>();
		for (IdEObject idEObject : objects.values()) {
			if (idEObject instanceof GeometryInfo) {
				result.add((GeometryInfo) idEObject);
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "GeometryTargetImpl " + objects.size();
	}
}