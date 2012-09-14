package org.bimserver.merging;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.Project;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;

public class BasicModelMerger extends AbstractModelMerger {

	@Override
	public IfcModelInterface merge(Project project, IfcModelSet modelSet, ModelHelper modelHelper) throws MergeException {
		if (modelSet.size() == 1) {
			// Do no merging on only 1 model, same in - same out principle of
			// Leon :)
			return modelSet.iterator().next();
		}
		modelSet.sortByDate();
		return mergeScales(project, modelSet, modelHelper);
	}
}