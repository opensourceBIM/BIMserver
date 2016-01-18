package org.bimserver.javamodelchecker;

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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.plugins.VirtualClassLoader;
import org.bimserver.plugins.VirtualFile;
import org.bimserver.plugins.VirtualFileManager;
import org.bimserver.plugins.modelchecker.ModelCheckException;
import org.bimserver.plugins.modelchecker.ModelChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaModelChecker implements ModelChecker {
	private static final Logger LOGGER = LoggerFactory.getLogger(JavaModelChecker.class);
	private static String libPath = System.getProperty("java.class.path");
	private ClassLoader classLoader;
	private JavaFileManager pluginFileManager;

	public JavaModelChecker(ClassLoader classLoader, Path rootPath) {
		this.classLoader = classLoader;
		this.pluginFileManager = ToolProvider.getSystemJavaCompiler().getStandardFileManager(null, null, null);
	}

	@Override
	public ModelCheckerResult check(IfcModelInterface model, byte[] compiledCode) throws ModelCheckException {
		try {
			VirtualFile baseDir = VirtualFile.fromJar(new ByteArrayInputStream(compiledCode));
			VirtualClassLoader loader = new VirtualClassLoader(classLoader, baseDir);
			try {
				Class<?> loadClass = loader.loadClass("org.bimserver.javamodelchecker.Implementation");
				JavaModelCheckerInterface modelCheckerInterface = (JavaModelCheckerInterface) loadClass.newInstance();
				ModelCheckerResult modelCheckerResult = modelCheckerInterface.check(model);
				return modelCheckerResult;
			} catch (Exception e) {
				throw new CompileException(e);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
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

	@Override
	public byte[] compile(String code) throws ModelCheckException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			throw new ModelCheckException("JDK needed for compile tasks");
		}
		VirtualFile baseDir = new VirtualFile();
		VirtualFile file = baseDir.createFile("org" + File.separator + "bimserver" + File.separator + "javamodelchecker" + File.separator + "Implementation.java");
		file.setStringContent(code);
		VirtualFileManager myFileManager = new VirtualFileManager(pluginFileManager, classLoader, baseDir);

		List<VirtualFile> fileList = new ArrayList<VirtualFile>();
		getJavaFiles(fileList, baseDir);
		List<VirtualFile> compilationUnits = baseDir.getAllJavaFileObjects();

		List<String> options = new ArrayList<String>();
		options.add("-cp");
		options.add(libPath);

		DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
		compiler.getTask(null, myFileManager, diagnosticsCollector, options, null, compilationUnits).call();
		List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
		for (Diagnostic<? extends JavaFileObject> d : diagnostics) {
			if (d.getKind() == Kind.ERROR) {
				throw new ModelCheckException(d.getMessage(Locale.ENGLISH));
			} else if (d.getKind() == Kind.WARNING) {
				throw new ModelCheckException(d.getMessage(Locale.ENGLISH));
			}
		}
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		baseDir.createJar(outputStream);
		
		return outputStream.toByteArray();
	}
}