package org.bimserver.emf;

import org.eclipse.emf.ecore.EPackage;

public class PackageLoader implements Runnable {

	private EPackage ePackage;
	private Schema schema;
	private MetaDataManager metaDataManager;

	public PackageLoader(MetaDataManager metaDataManager, EPackage ePackage, Schema schema) {
		this.metaDataManager = metaDataManager;
		this.ePackage = ePackage;
		this.schema = schema;
	}

	@Override
	public void run() {
		metaDataManager.addEPackage(ePackage, schema);
	}
}
