package org.bimserver.database.queries.om;

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

import java.util.List;
import java.util.Set;

import org.bimserver.database.queries.om.Include.TypeDef;
import org.eclipse.emf.ecore.EClass;

public interface CanInclude {
	void addInclude(Include include);
	void addInclude(String name);
	boolean hasIncludes();
	boolean hasIncludesToResolve();
	List<Include> getIncludes();
	Set<String> getIncludesToResolve();
	boolean isIncludeAllFields();
	void addIncludeReference(Include down, String name);
	boolean hasReferences();
	List<Reference> getReferences();
	Set<TypeDef> getTypes();
	Include createInclude();
	boolean hasTypes();
	void addType(EClass eClass, boolean includeAllSubTypes, Set<EClass> excludedEClasses);
	void addType(EClass eClass, boolean b);
	boolean hasOids();
	void addOutputType(EClass eClass, boolean includeAllSubTypes);
	void addOutputType(EClass eClass, boolean includeAllSubTypes, Set<EClass> excludedEClasses);
}
