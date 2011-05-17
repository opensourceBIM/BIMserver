package org.bimserver.plugins.schema;

/**
 * Base class capturing an EXPRESS <code>ATTRIBUTE</code> of the EXPRESS
 * Language. <code>ATTRIBUTE</code>s are defined local to an EXPRESS
 * <code>ENTITY</code> (@see EntityDefinition) {@link EntityDefinition}
 * 
 * @author Jakob Beetz
 * @version %I% %G%
 */
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
