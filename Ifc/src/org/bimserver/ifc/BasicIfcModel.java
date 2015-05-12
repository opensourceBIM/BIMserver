package org.bimserver.ifc;

import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.PackageMetaData;

public class BasicIfcModel extends IfcModel {

	public BasicIfcModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap) {
		super(packageMetaData, pidRoidMap);
	}

	public BasicIfcModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap, int size) {
		super(packageMetaData, pidRoidMap, size);
	}

	@Override
	public void load(IdEObject idEObject) {
	}
}
