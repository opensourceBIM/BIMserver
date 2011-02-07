package nl.tue.buildingsmart.express.dictionary;


public class DefinedType extends nl.tue.buildingsmart.express.dictionary.NamedType implements nl.tue.buildingsmart.express.dictionary.UnderlyingType{
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
