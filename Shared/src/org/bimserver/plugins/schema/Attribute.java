package org.bimserver.plugins.schema;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

public abstract class Attribute {
	private String name;
	private EntityDefinition parent_entity;
	private boolean derived;

	public Attribute(String name, EntityDefinition parent_entity) {

		this.name = name;
		this.parent_entity = parent_entity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EntityDefinition getParent_entity() {
		return parent_entity;
	}

	public void setParent_entity(EntityDefinition parent_entity) {
		this.parent_entity = parent_entity;
	}

	public void setDerived(boolean derived) {
		this.derived = derived;
	}

	public boolean isDerived() {
		return derived;
	}
}
