package org.bimserver.database.migrations;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.database.Database;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

public abstract class Migration {
	
	public EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	public abstract void migrate(Schema schema);

	public void upgrade(Database database) {
	}

	protected EAnnotation createEmbedsReference() {
		EAnnotation embedsReferenceAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		embedsReferenceAnnotation.setSource("embedsreference");
		return embedsReferenceAnnotation;
	}
	
	public abstract String getDescription();
}