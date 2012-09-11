package org.bimserver.plugins.modelmerger;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.Project;
import org.bimserver.plugins.IfcModelSet;

public interface ModelMerger {

	IfcModelInterface merge(Project project, IfcModelSet modelSet) throws MergeException;
}