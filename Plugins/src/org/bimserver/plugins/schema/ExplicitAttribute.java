package org.bimserver.plugins.schema;


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
