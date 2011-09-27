package org.bimserver.tools.generators;

import java.util.LinkedHashSet;
import java.util.Set;

public class ImportManager {
	private int index;
	private final Set<String> imports = new LinkedHashSet<String>();
	
	public ImportManager() {
		
	}
	
	public void mark(StringBuffer stringBuffer) {
		index = stringBuffer.length();
	}
	
	public String getImport(String imp) {
		imports.add(imp);
		return imp;
	}
	
	public void writeImports(StringBuffer stringBuffer) {
		for (String imp : imports) {
			stringBuffer.insert(index, "import " + imp + ";\n");
		}
	}
}
