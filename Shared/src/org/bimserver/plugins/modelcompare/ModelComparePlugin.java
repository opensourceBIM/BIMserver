package org.bimserver.plugins.modelcompare;

import org.bimserver.plugins.Plugin;

public interface ModelComparePlugin extends Plugin {
	String getDefaultModelCompareName();
	ModelCompare createModelCompare() throws ModelCompareException;
}
