package org.bimserver.plugins.modelcompare;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;

public interface ModelCompare {

	CompareResult compare(IfcModelInterface model1, IfcModelInterface model2, CompareType compareType) throws ModelCompareException;
}
