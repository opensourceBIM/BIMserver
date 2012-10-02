package org.bimserver.plugins.modelmerger;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.Project;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;

public interface ModelMerger {
	IfcModelInterface merge(Project project, IfcModelSet modelSet, ModelHelper modelHelper) throws MergeException;
}