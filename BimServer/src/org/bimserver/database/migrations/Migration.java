package org.bimserver.database.migrations;

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

import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

public abstract class Migration {

	public EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	public abstract void migrate(Schema schema, DatabaseSession databaseSession);

	public void upgrade(Database database) {
	}

	protected EAnnotation createEmbedsReferenceAnnotation() {
		EAnnotation embedsReferenceAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		embedsReferenceAnnotation.setSource("embedsreference");
		return embedsReferenceAnnotation;
	}

	protected EAnnotation createDbEmbedReferenceAnnotation() {
		EAnnotation embedsReferenceAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		embedsReferenceAnnotation.setSource("dbembed");
		return embedsReferenceAnnotation;
	}

	protected EAnnotation createNoDatabaseAnnotation() {
		EAnnotation embedsReferenceAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		embedsReferenceAnnotation.setSource("nodatabase");
		return embedsReferenceAnnotation;
	}

	protected EAnnotation createHiddenAnnotation() {
		EAnnotation hidden = EcoreFactory.eINSTANCE.createEAnnotation();
		hidden.setSource("hidden");
		return hidden;
	}

	@Deprecated
	protected EAnnotation createNoLazyLoadAnnotation() {
		EAnnotation hidden = EcoreFactory.eINSTANCE.createEAnnotation();
		hidden.setSource("nolazyload");
		return hidden;
	}
	
	protected EAnnotation createUniqueAnnotation() {
		EAnnotation unique = EcoreFactory.eINSTANCE.createEAnnotation();
		unique.setSource("unique");
		return unique;
	}
	
	protected void link(EReference eReference1, EReference eReference2) {
		eReference1.setEOpposite(eReference2);
		eReference2.setEOpposite(eReference1);
	}

	public abstract String getDescription();
}