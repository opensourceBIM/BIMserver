package org.bimserver.querycompiler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.Diagnostic.Kind;

import org.bimserver.ServerInitializer;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryCompiler {
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryCompiler.class);
	private final String libPath = createLibraryPath();

	public QueryCompiler() {
	}

	private String createLibraryPath() {
		StringBuilder path = new StringBuilder();
		addLocalPath(path, ".." + File.separator + "BimServer" + File.separator + "src");
		addLocalPath(path, ".." + File.separator + "Ifc" + File.separator + "src");
		addLocalPath(path, ".." + File.separator + "Emf" + File.separator + "src");
		addLocalJarPath(path, new File(".." + File.separator + "BimServer" + File.separator + "lib"));
		addLocalJarPath(path, new File(".." + File.separator + "BimServer" + File.separator + "lib/emf"));
		File libDir = new File("lib");
		if (!libDir.exists()) {
			libDir = ServerInitializer.getResourceFetcher().getFile("lib" + File.separator);
		}
		if (libDir.exists() && libDir.isDirectory()) {
			for (File file : libDir.listFiles()) {
				if (file.getName().endsWith(".jar")) {
					path.append(file.getAbsolutePath() + File.pathSeparator);
				}
			}
		}
		return path.toString();
	}

	private void addLocalPath(StringBuilder path, String string) {
		File file = new File(string);
		if (file.exists()) {
			path.append(string + File.pathSeparator);
		}
	}

	private void addLocalJarPath(StringBuilder sb, File dir) {
		if (dir.exists()) {
			for (File f : dir.listFiles()) {
				if (f.getName().endsWith(".jar")) {
					sb.append(dir.getPath() + File.separator + f.getName() + File.pathSeparator);
				}
			}
		}
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
		options.add("-target");
		options.add("6");

		DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
		boolean succes = true;
		compiler.getTask(null, myFileManager, diagnosticsCollector, options, null, compilationUnits).call();
		List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
		root.put("compileWarnings", compileWarnings);
		root.put("compileErrors", compileErrors);
		for (Diagnostic<? extends JavaFileObject> d : diagnostics) {
			if (d.getKind() == Kind.ERROR) {
				succes = false;
				compileErrors.put(d.getMessage(Locale.ENGLISH));
			} else if (d.getKind() == Kind.WARNING) {
				compileWarnings.put(d.getMessage(Locale.ENGLISH));
			}
		}
		if (succes) {
			VirtualClassLoader loader = new VirtualClassLoader(baseDir);
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