package org.bimserver.querycompiler;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
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

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryCompiler {
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryCompiler.class);
	private static String libPath = System.getProperty("java.class.path");

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

	public QueryInterface compile(String code, JSONObject root) throws CompileException, JSONException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		JSONArray compileWarnings = new JSONArray();
		JSONArray compileErrors = new JSONArray();
		if (compiler == null) {
			compileErrors.put("JDK needed for compile tasks");
			root.put("compileErrors", compileErrors);
			throw new CompileException("JDK needed for compile tasks");
		}
		JavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		ClassLoader classLoader = new ClassLoader(){};
		VirtualFile baseDir = new VirtualFile(null, null);
		VirtualFile file = baseDir.createFile("org" + File.separator + "bimserver" + File.separator + "querycompiler" + File.separator + "Query.java");
		file.setStringContent(code);
		VirtualFileManager myFileManager = new VirtualFileManager(fileManager, classLoader, baseDir);

		List<VirtualFile> fileList = new ArrayList<VirtualFile>();
		getJavaFiles(fileList, baseDir);
		List<VirtualFile> compilationUnits = baseDir.getAllJavaFileObjects();

		List<String> options = new ArrayList<String>();
		options.add("-cp");
		options.add(libPath);
//		options.add("-target");
//		options.add("7");

		DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
		boolean success = true;
		compiler.getTask(null, myFileManager, diagnosticsCollector, options, null, compilationUnits).call();
		List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
		root.put("compileWarnings", compileWarnings);
		root.put("compileErrors", compileErrors);
		for (Diagnostic<? extends JavaFileObject> d : diagnostics) {
			if (d.getKind() == Kind.ERROR) {
				success = false;
				compileErrors.put(d.getMessage(Locale.ENGLISH));
			} else if (d.getKind() == Kind.WARNING) {
				compileWarnings.put(d.getMessage(Locale.ENGLISH));
			}
		}
		if (success) {
			VirtualClassLoader loader = new VirtualClassLoader(getClass().getClassLoader(), baseDir);
			try {
				Class<?> loadClass = loader.loadClass("org.bimserver.querycompiler.Query");
				QueryInterface newInstance = (QueryInterface) loadClass.newInstance();
				return newInstance;
			} catch (ClassNotFoundException e) {
				LOGGER.error("", e);
			} catch (InstantiationException e) {
				LOGGER.error("", e);
			} catch (IllegalAccessException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}
}