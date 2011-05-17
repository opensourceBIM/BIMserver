package org.bimserver.plugins.schema;


public class DefinedType extends NamedType implements UnderlyingType{
	private UnderlyingType domain;
		
	public UnderlyingType getDomain() {
		return domain;
	}

	public void setDomain(UnderlyingType domain) {
		this.domain = domain;
	}

	public DefinedType(String name, UnderlyingType domain) {
		super(name);
		this.domain = domain;
	}

	public DefinedType(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public UnderlyingType getDomain(boolean includeSubtypes){
		UnderlyingType ut = this.domain;
		if (ut instanceof DefinedType ){
			ut = ((DefinedType)domain).getDomain(includeSubtypes);
		}
		return ut;
	}

	
}
