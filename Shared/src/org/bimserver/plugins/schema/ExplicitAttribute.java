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

public class ExplicitAttribute extends Attribute implements UnderlyingType,
		ExplicitOrDerived {

	private BaseType domain;
	private ExplicitOrDerived redeclares;
	private boolean optional = false;
	private boolean derived = false;

	public ExplicitAttribute(String name, EntityDefinition parent_entity) {
		super(name, parent_entity);
	}

	public BaseType getDomain() {
		return domain;
	}

	public BaseType getDomain(boolean includeSubtypes) {
		BaseType bt = this.domain;
		if (bt instanceof DefinedType)
			bt = (BaseType) ((DefinedType) bt).getDomain(true);
		return bt;
	}

	public void setDomain(BaseType domain) {
		this.domain = domain;

	}

	public ExplicitOrDerived getRedeclares() {
		return redeclares;
	}

	public void setRedeclares(ExplicitOrDerived redeclares) {
		this.redeclares = redeclares;
	}

	public boolean isDerived() {
		return derived;
	}
	
	public void setDerived(boolean derived) {
//		LOGGER.info("derived: " + derived);
		this.derived = derived;
	}
	
	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional_flag) {
		this.optional = optional_flag;
	}
}
