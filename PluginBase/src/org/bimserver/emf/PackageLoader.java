package org.bimserver.emf;

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

import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackageLoader implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(PackageLoader.class);
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
		try {
			metaDataManager.addEPackage(ePackage, schema);
		} catch (Throwable e) {
			LOGGER.error("", e);
		}
	}
}
