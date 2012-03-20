package org.bimserver.tests.diff;

public class SubModel extends AbstractModel {
	private final Model parentModel;

	public SubModel(Model parentModel) {
		this.parentModel = parentModel;
	}
	
	@Override
	public void addMatchedObject(ModelObject matchedObject) {
		super.addMatchedObject(matchedObject);
		parentModel.addMatchedObject(matchedObject);
	}
}