package org.bimserver.jqep;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.VirtualClassLoader;
import org.bimserver.plugins.VirtualFile;
import org.bimserver.plugins.VirtualFileManager;
import org.bimserver.plugins.queryengine.QueryEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaQueryEngine implements QueryEngine {

	private static final Logger LOGGER = LoggerFactory.getLogger(JavaQueryEngine.class);
	private static String libPath = System.getProperty("java.class.path");
	private final ClassLoader classLoader;
	private final JavaFileManager pluginFileManager;
	private Path rootPath;

	public JavaQueryEngine(ClassLoader classLoader, Path rootPath) {
		this.classLoader = classLoader;
		this.rootPath = rootPath;
		this.pluginFileManager = ToolProvider.getSystemJavaCompiler().getStandardFileManager(null, null, null);
	}

	@Override
	public IfcModelInterface query(IfcModelInterface model, String code, Reporter reporter, ModelHelper modelHelper) {
		try {
			QueryInterface queryInterface = createQueryInterface(code);
			queryInterface.query(model, reporter, modelHelper);
			return modelHelper.getTargetModel();
		} catch (Exception e) {
			LOGGER.error("", e);
			reporter.error(e);
		}
		return null;
	}

	public static void addJarFolder(File libDir) {
		if (libDir.exists() && libDir.isDirectory()) {
			for (File file : libDir.listFiles()) {
				if (file.getName().endsWith(".jar")) {
					libPath += file.getAbsolutePath() + File.pathSeparator;
				}
			}
		}
		LOGGER.debug("libPath: " + libPath);
	}
	
	private void getJavaFiles(List<VirtualFile> fileList, VirtualFile baseDir) {
		for (VirtualFile f : baseDir.listFiles()) {
			if (f.isDirectory()) {
				getJavaFiles(fileList, f);
			} else {
				if (f.getName().endsWith(".java")) {
					fileList.add(f);
				}
			}
		}
	}

	private QueryInterface createQueryInterface(String code) throws CompileException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			throw new CompileException("JDK needed for compile tasks");
		}
		VirtualFile baseDir = new VirtualFile();
		VirtualFile file = baseDir.createFile("org/bimserver/jqep/Query.java");
		file.setStringContent(code);
		VirtualFileManager myFileManager = new VirtualFileManager(pluginFileManager, classLoader, baseDir);

		List<VirtualFile> fileList = new ArrayList<VirtualFile>();
		getJavaFiles(fileList, baseDir);
		List<VirtualFile> compilationUnits = baseDir.getAllJavaFileObjects();

		List<String> options = new ArrayList<String>();
		options.add("-cp");
		options.add(libPath);
		options.add("-target");
		options.add("7");

		DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
		compiler.getTask(null, myFileManager, diagnosticsCollector, options, null, compilationUnits).call();
		List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
		for (Diagnostic<? extends JavaFileObject> d : diagnostics) {
			if (d.getKind() == Kind.ERROR) {
				throw new CompileException(d.getMessage(Locale.ENGLISH));
			} else if (d.getKind() == Kind.WARNING) {
				throw new CompileException(d.getMessage(Locale.ENGLISH));
			}
		}
		VirtualClassLoader loader = new VirtualClassLoader(classLoader, baseDir);
		try {
			Class<?> loadClass = loader.loadClass("org.bimserver.jqep.Query");
			QueryInterface newInstance = (QueryInterface) loadClass.newInstance();
			return newInstance;
		} catch (Exception e) {
			throw new CompileException(e);
		}
	}
}