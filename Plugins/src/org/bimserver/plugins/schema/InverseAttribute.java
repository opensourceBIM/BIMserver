package org.bimserver.plugins.schema;

@SuppressWarnings("all")
public class InverseAttribute extends
		Attribute implements
		UnderlyingType {

	private EntityDefinition domain = null;
	private ExplicitAttribute inverted_attr = null;
	private InverseAttribute redeclaring = null;
	private Bound min_cardinality, max_cardinality;
	private boolean duplicates;

	public InverseAttribute(String name, EntityDefinition parent_entity) {
		super(name, parent_entity);
		// TODO Auto-generated constructor stub
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
