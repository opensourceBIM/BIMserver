package org.bimserver.jqep;

import javax.tools.JavaFileManager;

import org.bimserver.models.store.RunResult;
import org.bimserver.plugins.queryengine.QueryEngine;
import org.bimserver.plugins.serializers.IfcModelInterface;

public class JavaQueryEngine implements QueryEngine {

	private final ClassLoader classLoader;
	private final JavaFileManager pluginFileManager;

	public JavaQueryEngine(ClassLoader classLoader, JavaFileManager pluginFileManager) {
		this.classLoader = classLoader;
		this.pluginFileManager = pluginFileManager;
	}

	@Override
	public RunResult query(IfcModelInterface model, String code) {
		QueryCompiler queryCompiler = new QueryCompiler(classLoader, pluginFileManager);
		return queryCompiler.run(code, model);
	}
}