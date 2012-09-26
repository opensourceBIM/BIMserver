package org.bimserver.tools.generators;

import java.io.File;
import java.io.PrintWriter;

import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.utils.Licenser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterfaceReflectorGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterfaceReflectorGenerator.class);
	
	public void generateServiceInterfaceImplementationForReflector(SService service, File reflectorImplementationFile) {
		try {
			PrintWriter out = new PrintWriter(reflectorImplementationFile);
			out.println("package org.bimserver.interfaces;\n");
			out.println(Licenser.getCommentedLicenseText(new File("license.txt")));
			out.println("import org.bimserver.shared.reflector.Reflector;\n");
			out.println("import org.bimserver.shared.reflector.KeyValuePair;\n");
			out.println("@SuppressWarnings(\"unchecked\")");
			out.println("public class " + service.getName() + "ReflectorImpl implements " + service.getInstanceClass().getName() + " {\n");
			out.println("private Reflector reflector;\n");
			out.println("\tpublic " + service.getName() + "ReflectorImpl (Reflector reflector) {this.reflector = reflector;}");

			for (SMethod method : service.getMethods()) {
				String returnType = method.getPrintableName();
				out.print("\tpublic " + returnType + " " + method.getName() + "(");
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				for (SParameter parameter : method.getParameters()) {
					sb1.append(parameter.getPrintableName() + " " + parameter.getName() + (parameter.isLast() ? "" : ", "));
					sb2.append("new KeyValuePair(\"" + parameter.getName() + "\", " + parameter.getName() + ")" + (parameter.isLast() ? "" : ", "));
				}
				out.println(sb1.toString() + ") throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {");
				if (method.returnsVoid()) {
					out.println("\t\treflector.callMethod(\"" + service.getName() + "\", \"" + method.getName() + "\"" + ", " + method.getReturnType().getName() + ".class"
							+ (method.getParameters().size() > 0 ? ", " : "") + sb2.toString() + ");");
				} else {
					out.println("\t\treturn (" + returnType + ") reflector.callMethod(\"" + service.getName() + "\", \"" + method.getName() + "\", "
							+ method.getReturnType().getName() + ".class" + (method.getParameters().size() > 0 ? (", " + sb2.toString()) : "") + ");");
				}
				out.println("\t}");
			}
			out.println("}");
			out.close();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}