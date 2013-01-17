package org.bimserver.database;

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

import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.Migrator;
import org.bimserver.emf.MetaDataManager;
import org.eclipse.emf.ecore.EClass;

public interface BimDatabase {
	DatabaseSession createSession();

	void close();

	Migrator getMigrator();

	void init() throws DatabaseInitException, DatabaseRestartRequiredException, InconsistentModelsException;

	long newOid(EClass eClass);
	
	MetaDataManager getMetaDataManager();

	Registry getRegistry();

	EClass getEClassForOid(long oid);
}