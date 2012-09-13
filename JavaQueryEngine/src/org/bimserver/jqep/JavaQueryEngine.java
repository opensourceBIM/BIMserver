package org.bimserver.jqep;

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

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.store.CompileResult;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.QueryEngineHelper;
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

	public JavaQueryEngine(ClassLoader classLoader, JavaFileManager pluginFileManager) {
		this.classLoader = classLoader;
		this.pluginFileManager = pluginFileManager;
		pluginFileManager = ToolProvider.getSystemJavaCompiler().getStandardFileManager(null, null, null);
	}

	@Override
	public IfcModelInterface query(IfcModelInterface model, String code, Reporter reporter, QueryEngineHelper queryEngineHelper) {
		try {
			QueryInterface queryInterface = createQueryInterface(code);
			IfcModelInterface dest = new IfcModel();
			queryInterface.query(model, dest, reporter, queryEngineHelper);
			return dest;
		} catch (CompileException e) {
			LOGGER.error("", e);
			reporter.error(e.getMessage());
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
		VirtualFile baseDir = new VirtualFile(null, null);
		VirtualFile file = baseDir.createFile("org" + File.separator + "bimserver" + File.separator + "jqep" + File.separator + "Query.java");
		file.setStringContent(code);
		VirtualFileManager myFileManager = new VirtualFileManager(pluginFileManager, classLoader, baseDir);

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
		for (Diagnostic<? extends JavaFileObject> d : diagnostics) {
			if (d.getKind() == Kind.ERROR) {
				success = false;
				throw new CompileException(d.getMessage(Locale.ENGLISH));
			} else if (d.getKind() == Kind.WARNING) {
				throw new CompileException(d.getMessage(Locale.ENGLISH));
			}
		}
		if (success) {
			VirtualClassLoader loader = new VirtualClassLoader(classLoader, baseDir);
			try {
				Class<?> loadClass = loader.loadClass("org.bimserver.jqep.Query");
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
	
	public CompileResult compile(String code) {
		CompileResult compileResult = StoreFactory.eINSTANCE.createCompileResult();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			compileResult.setCompileOke(false);
			compileResult.getErrors().add("JDK needed for compile tasks");
			return compileResult;
		}
		JavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		VirtualFile baseDir = new VirtualFile(null, null);
		VirtualFile file = baseDir.createFile("org" + File.separator + "bimserver" + File.separator + "jqep" + File.separator + "Query.java");
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
		compiler.getTask(null, myFileManager, diagnosticsCollector, options, null, compilationUnits).call();
		List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
		compileResult.setCompileOke(true);
		for (Diagnostic<? extends JavaFileObject> d : diagnostics) {
			if (d.getKind() == Kind.ERROR) {
				compileResult.setCompileOke(false);
				compileResult.getErrors().add(d.getMessage(Locale.ENGLISH));
			} else if (d.getKind() == Kind.WARNING) {
				compileResult.getErrors().add(d.getMessage(Locale.ENGLISH));
			}
		}
		return compileResult;
	}

}