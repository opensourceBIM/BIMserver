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

public class InverseAttribute extends
		Attribute implements
		UnderlyingType {

	private EntityDefinition domain = null;
	private ExplicitAttribute inverted_attr = null;
	private Bound min_cardinality, max_cardinality;

	public InverseAttribute(String name, EntityDefinition parent_entity) {
		super(name, parent_entity);
	}

	public EntityDefinition getDomain() {
		return domain;
	}

	public void setDomain(EntityDefinition domain) {
		this.domain = domain;
	}

	public ExplicitAttribute getInverted_attr() {
		return inverted_attr;
	}

	public void setInverted_attr(ExplicitAttribute inverted_attr) {
		this.inverted_attr = inverted_attr;
	}

	public Bound getMax_cardinality() {
		return max_cardinality;
	}

	public void setMax_cardinality(Bound max_cardinality) {
		this.max_cardinality = max_cardinality;
	}

	public Bound getMin_cardinality() {
		return min_cardinality;
	}

	public void setMin_cardinality(Bound min_cardinality) {
		this.min_cardinality = min_cardinality;
	}
}
