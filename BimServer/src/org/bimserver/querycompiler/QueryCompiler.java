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

import org.apache.commons.io.output.NullWriter;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class QueryCompiler {
	private final String libPath = createLibraryPath();
	
	public QueryCompiler() {

	}

	private String createLibraryPath() {
		return "../BimServer/src" + File.pathSeparator + "../Ifc/src" + File.pathSeparator + "../Emf/src" + File.pathSeparator + createPath(new File("../BimServer/lib")) + File.pathSeparator + createPath(new File("../Emf/lib"));
	}

	private String createPath(File dir) {
		if (dir.exists()) {
			StringBuilder result = new StringBuilder();
			for (File f : dir.listFiles()) {
				if (f.getName().endsWith(".jar")) {
					result.append(dir.getPath() + File.separator + f.getName() + File.pathSeparator);
				}
			}
			return result.toString();
		} else {
			return "";
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
	
	public QueryInterface compile(String code, JSONObject root) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			throw new RuntimeException("JDK needed for compile tasks");
		}
		JavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		ClassLoader classLoader = new ClassLoader() {};
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

		DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
		boolean succes = true;
		compiler.getTask(new NullWriter(), myFileManager, diagnosticsCollector, options, null, compilationUnits).call();
		List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
		try {
			JSONArray compileWarnings = new JSONArray();
			root.put("compileWarnings", compileWarnings);
			JSONArray compileErrors = new JSONArray();
			root.put("compileErrors", compileErrors);
			for (Diagnostic<? extends JavaFileObject> d : diagnostics) {
				if (d.getKind() == Kind.ERROR) {
					succes = false;
					compileErrors.put(d.getMessage(Locale.ENGLISH));
				} else if (d.getKind() == Kind.WARNING) {
					compileWarnings.put(d.getMessage(Locale.ENGLISH));
				}
			}
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		if (succes) {
			VirtualClassLoader loader = new VirtualClassLoader(baseDir);
			try {
				Class<?> loadClass = loader.loadClass("org.bimserver.querycompiler.Query");
				QueryInterface newInstance = (QueryInterface) loadClass.newInstance();
				return newInstance;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}