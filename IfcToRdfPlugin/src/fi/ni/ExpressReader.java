package fi.ni;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

import softhema.system.toolkits.ToolkitString;
import fi.ni.rdf.Namespace;
import fi.ni.vo.AttributeVO;
import fi.ni.vo.EntityVO;
import fi.ni.vo.InverseVO;
import fi.ni.vo.PropertyVO;
import fi.ni.vo.TypeVO;

/*
 * ExpressIFC_ClassReader reads EXPPRESS file11 specification of the IFC files and creates 
 * an internal representation of it. IFC2X3 is supported.
 * 
 * The usage:
 * ExpressIFC_ClassReader er = new ExpressIFC_ClassReader(file name);
 * 
 * - outputRDFS(BufferedWriter x) outputs RDFS of the read class hierarchy.
 * - outputOWL(BufferedWriter x) outputs OWL description of the read class hierarchy.
 * - outputIFCClasses() summarizes the model
 * - outputJavaClasses() outputs java classes of the model as files to the specified directory
 *  
 *  - getEntities() - gives map of Entities in IFC
 *  - getTypes()    - gives map of Types in IFC
 *  
 *  
 * @author Jyrki Oraskari
 */
/*
The MIT License (MIT)

Copyright (c) 2014 Jyrki Oraskari

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

public class ExpressReader {

	private Map<String, EntityVO> entities = new HashMap<String, EntityVO>();
	private Map<String, TypeVO> types = new HashMap<String, TypeVO>();
	private Map<String, String> interfaces = new HashMap<String, String>();
	private Map<String, AttributeVO> attributes = new HashMap<String, AttributeVO>();

	private Map<String, Set<String>> siblings = new HashMap<String, Set<String>>();

	private Map<String, String> interface_aliases = new HashMap<String, String>();

	public ExpressReader(String spectxt) {
		// Primitive types:
		types.put("REAL", new TypeVO("REAL"));
		types.put("INTEGER", new TypeVO("INTEGER"));
		types.put("STRING", new TypeVO("STRING"));

		readSpec(spectxt);
		generate_derived_attribute_list();
		generate_derived_inverse_list();
	}

	public Map<String, TypeVO> getTypes() {
		return types;
	}

	public void setTypes(Map<String, TypeVO> types) {
		this.types = types;
	}

	public Map<String, EntityVO> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, EntityVO> entities) {
		this.entities = entities;
	}

	static public String formatClassName(String s) {
		if (s == null)
			return null;
		return filter_extras(s).toUpperCase();
	}

	static public String formatGetterANDSetter(String s) {
		if (s == null)
			return null;
		StringBuffer sb = new StringBuffer();
		sb.append(Character.toUpperCase(s.charAt(0)));
		sb.append(s.substring(1));
		return sb.toString();
	}

	static public String formatProperty(String s) {
		if (s == null)
			return null;

		StringBuffer sb = new StringBuffer();
		sb.append(Character.toLowerCase(s.charAt(0)));
		sb.append(s.substring(1));
		return sb.toString();
	}

	private Map<String, PropertyVO> properties = new HashMap<String, PropertyVO>();

	public void outputRDFS(BufferedWriter out) {
		Iterator<Entry<String, EntityVO>> it = entities.entrySet().iterator();
		try {
			out.write("@prefix rdf:  <" + Namespace.RDF + "> .\n");
			out.write("@prefix rdfs: <" + Namespace.RDFS + "> .\n");
			out.write("@prefix owl: <" + Namespace.OWL + "> .\n");
			out.write("@prefix ifc: <" + Namespace.IFC + "> .\n");
			out.write("@prefix xsd: <" + Namespace.XSD + "> .\n");
			out.write("\n");
			while (it.hasNext()) {
				Entry<String, EntityVO> pairs = it.next();
				EntityVO evo = pairs.getValue();

				if (evo.getSuperclass() == null)
					out.write("ifc:" + evo.getName() + " a rdfs:Class.\n");
				else
					out.write("ifc:" + evo.getName()
							+ " a rdfs:Class; rdfs:subClassOf ifc:"
							+ evo.getSuperclass() + ".\n");

				for (int n = 0; n < evo.getAttributes().size(); n++) {
					String property = evo.getAttributes().get(n).getName()
							.toLowerCase();// formatProperty(evo.getAttributes().get(n).getName());
					PropertyVO t = properties.get(property);
					if (t == null) {
						properties.put(property, null);
						out.write("ifc:" + property + " a rdf:Property.\n");
					}

					out.write("ifc:" + property + " rdfs:domain ifc:"
							+ pairs.getValue().getName() + ".\n");
				}

				for (int n = 0; n < evo.getInverses().size(); n++) {
					String property = formatProperty(evo.getInverses().get(n)
							.getName());
					PropertyVO t = properties.get(property);
					if (t == null) {

						properties.put(property, null);
						out.write("ifc:" + property + " a rdf:Property.\n");
					}

					out.write("ifc:" + property + " rdfs:domain ifc:"
							+ pairs.getValue().getName() + ".\n");
				}

			}
			out.write("ifc:has_linenumber a rdf:Property.\n");
			out.write("ifc:graph_deep a rdf:Property.\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// @formatter:off
	static final String type_datatype_list = "ifc:<_NAME_>\r\n"
			+ "	rdfs:subClassOf [\r\n" + "		a owl:Restriction;\r\n"
			+ "		owl:allValuesFrom [\r\n" + "			a rdfs:Datatype;\r\n"
			+ "			owl:oneOf ( <_DATATYPE_> )\r\n" + "		]\r\n" + "	];\r\n"
			+ "	rdfs:subClassOf rdf:List;\r\n" + "	a owl:Class.\r\n";

	static final String type_entity_list = "ifc:<_NAME_>\r\n"
			+ "	rdfs:subClassOf [\r\n" + "		a owl:Restriction;\r\n"
			+ "		owl:allValuesFrom [\r\n" + "			a owl:Class;\r\n"
			+ "			owl:unionOf ( <_RANGE_> )\r\n" + "		]\r\n" + "	];\r\n"
			+ "	rdfs:subClassOf rdf:List;\r\n" + "	a owl:Class.\r\n";

	static final String type_object_property0 = "ifc:<_NAME_>\r\n"
			+ "	rdfs:domain ifc:<_DOMAIN_>;\r\n" + "	rdfs:range [\r\n"
			+ "		a owl:Class;\r\n" + "		owl:unionOf ( <_RANGE_> )\r\n"
			+ "	];\r\n" + "	a owl:ObjectProperty.\r\n";

	static final String type_object_property1 = "ifc:<_NAME_>\r\n"
			+ "	rdfs:domain [\r\n" + "		a owl:Class;\r\n"
			+ "		owl:unionOf ( <_DOMAIN_> )\r\n" + "	];\r\n"
			+ "	rdfs:range [\r\n" + "		a owl:Class;\r\n"
			+ "		owl:unionOf ( <_RANGE_> )\r\n" + "	];\r\n"
			+ "	a owl:ObjectProperty.\r\n";

	static final String type_type_datatype_property = "ifc:<_NAME_>\r\n"
			+ "	rdfs:domain [\r\n" + "		a owl:Class;\r\n"
			+ "		owl:unionOf ( <_DOMAIN_> )\r\n" + "	];\r\n"
			+ "	rdfs:range <_DATATYPE_>;\r\n" + "	a owl:DatatypeProperty.\r\n";

	static final String type_enum_property = "ifc:<_NAME_>\r\n"
			+ "	owl:oneOf ( <_ENUM_LIST_>);\r\n" + "	a owl:Class.\r\n";

	// @formatter:on

	private void outputOWLproperty(BufferedWriter out, PropertyVO property) {
		try {
			// TODO Select, Inverse
			if (property.isEnumeration) {
				String tmp;
				tmp = type_enum_property;
				tmp = ToolkitString.strReplaceLike(tmp, "<_NAME_>",
						property.getName() + "_enumeration");
				tmp = ToolkitString.strReplaceLike(tmp, "<_ENUM_LIST_>",
						property.getEnumerationsAsString());
				out.write(tmp);

				tmp = type_object_property1;
				tmp = ToolkitString.strReplaceLike(tmp, "<_NAME_>",
						property.getName());
				tmp = ToolkitString.strReplaceLike(tmp, "<_DOMAIN_>",
						property.getIfcClassesAsString());
				tmp = ToolkitString.strReplaceLike(tmp, "<_RANGE_>", "ifc:"
						+ property.getName() + "_enumeration");
				out.write(tmp);

				return; // handled
			}

			if (property.isList)
				if (property.isEntity) {
					String tmp;
					tmp = type_entity_list;
					tmp = ToolkitString.strReplaceLike(tmp, "<_NAME_>",
							property.getName() + "_list");
					tmp = ToolkitString.strReplaceLike(tmp, "<_RANGE_>", "ifc:"
							+ property.getRawtype());
					out.write(tmp);

					tmp = type_object_property1;
					tmp = ToolkitString.strReplaceLike(tmp, "<_NAME_>",
							property.getName());
					tmp = ToolkitString.strReplaceLike(tmp, "<_DOMAIN_>",
							property.getIfcClassesAsString());
					tmp = ToolkitString.strReplaceLike(tmp, "<_RANGE_>", "ifc:"
							+ property.getName() + "_list");
					out.write(tmp);

				} else {
					String tmp;
					tmp = type_datatype_list;
					tmp = ToolkitString.strReplaceLike(tmp, "<_NAME_>",
							property.getName() + "_list");
					tmp = ToolkitString.strReplaceLike(tmp, "<_DATATYPE_>",
							property.getRawtype());
					out.write(tmp);

					tmp = type_object_property1;
					tmp = ToolkitString.strReplaceLike(tmp, "<_NAME_>",
							property.getName());
					tmp = ToolkitString.strReplaceLike(tmp, "<_DOMAIN_>",
							property.getIfcClassesAsString());
					tmp = ToolkitString.strReplaceLike(tmp, "<_RANGE_>", "ifc:"
							+ property.getName() + "_list");
					out.write(tmp);
				}

			else if (property.isEntity) {
				String tmp;
				tmp = type_object_property1;
				tmp = ToolkitString.strReplaceLike(tmp, "<_NAME_>",
						property.getName());
				tmp = ToolkitString.strReplaceLike(tmp, "<_DOMAIN_>",
						property.getIfcClassesAsString());
				tmp = ToolkitString.strReplaceLike(tmp, "<_RANGE_>", "ifc:"
						+ property.getRawtype());
				out.write(tmp);

			} else {
				String tmp;
				tmp = type_type_datatype_property;
				tmp = ToolkitString.strReplaceLike(tmp, "<_NAME_>",
						property.getName());
				tmp = ToolkitString.strReplaceLike(tmp, "<_DOMAIN_>",
						property.getIfcClassesAsString());
				tmp = ToolkitString.strReplaceLike(tmp, "<_DATATYPE_>",
						property.getRawtype());
				out.write(tmp);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// @formatter:off
	static final String owl_header = ""
			+ "@prefix xsd: <" + Namespace.XSD + ">.\n"
			+ "@prefix owl: <" + Namespace.OWL + ">.\n"
			+ "@prefix rdfs: <" + Namespace.RDFS + ">.\n"
			+ "@prefix list: <" + Namespace.LIST + ">.\n"
			+ "@prefix dce: <" + Namespace.DCE + ">.\n"
			+ "@prefix dct: <" + Namespace.DCT + ">.\n"
			+ "@prefix rdf: <" + Namespace.RDF + ">.\n"
			+ "\n" + "ifc:\n" + "	a owl:Thing;\n"
			+ "	a owl:Ontology;\n" + "	dce:title \"\"\"IFC2X3\"\"\"@en;\n"
			+ "	dce:format \"\"\"OWL Full\"\"\"@en;\n"
			+ " 	dce:identifier \"\"\"ifc\"\"\"@en;\n"
			+ "	dce:language \"\"\"English\"\"\"@en.\n" + "\n"
			+ "ifc:Entity\n" + "	rdfs:subClassOf owl:Thing;\n"
			+ "	a owl:Class.";

	// @formatter:on

	public void outputOWL(BufferedWriter out) {
		Iterator<Entry<String, EntityVO>> it = entities.entrySet().iterator();
		try {
			out.write("@prefix ifc: <" + Namespace.IFC + "> .\n");
			out.write(owl_header);
			out.write("\n");
			out.write("ifc:Entity\n");
			out.write("\trdfs:subClassOf owl:Thing;\n");
			out.write("\ta owl:Class.\n");
			out.write("\n");
			while (it.hasNext()) {
				Entry<String, EntityVO> pairs = it.next();
				EntityVO evo = pairs.getValue();
				// Generate the disjoined set:
				StringBuffer sibtxt = new StringBuffer();
				Set<String> sibling_set = this.siblings.get(evo.getName());
				if (sibling_set != null) {
					Iterator sib_it = sibling_set.iterator();
					int ii = 0;
					while (sib_it.hasNext()) {
						String sib = sib_it.next().toString();
						if (!sib.equalsIgnoreCase(evo.getName())) {
							if (ii > 0)
								sibtxt.append(",");
							sibtxt.append(" ifc:");
							sibtxt.append(sib);
							ii++;
						}
					}
				}

				out.write("ifc:" + evo.getName() + "\n");
				if (evo.getSuperclass() != null)
					out.write("\trdfs:subClassOf ifc:" + evo.getSuperclass()
							+ ";\n");
				else
					out.write("\trdfs:subClassOf ifc:Entity;\n");

				if (sibtxt.length() > 0)
					out.write("\towl:disjointWith " + sibtxt.toString() + ";\n");
				out.write("\ta owl:Class.\n");

				for (int n = 0; n < evo.getAttributes().size(); n++) {
					String property = evo.getAttributes().get(n).getName()
							.toLowerCase();// formatProperty(evo.getAttributes().get(n).getName());
					PropertyVO t = properties.get(property);
					if (t == null) {
						EntityVO entity = this.entities.get(formatClassName(evo
								.getAttributes().get(n).getType().getName()));

						String primary_type = evo.getAttributes().get(n)
								.getType().getPrimarytype();
						if (primary_type.equals("ENUMERATION")) {
							t = new PropertyVO(property, evo.getAttributes()
									.get(n).isSet(), false, null, true, evo
									.getAttributes().get(n).getType()
									.getEnum_entities());
						} else {
							String xsd_type = "xsd:string";
							if (primary_type.startsWith("IFC"))
								primary_type = types.get(primary_type)
										.getPrimarytype();
							if ("REAL".equals(primary_type))
								xsd_type = "xsd:double";
							if ("INTEGER".equals(primary_type))
								xsd_type = "xsd:integer";

							if (entity != null)
								t = new PropertyVO(property, evo
										.getAttributes().get(n).isSet(), true,
										evo.getAttributes().get(n).getType()
												.getName());
							else
								t = new PropertyVO(property, evo
										.getAttributes().get(n).isSet(), false,
										xsd_type);
						}
						properties.put(property, t);
					}
					t.addIfcClass(evo.getName());
				}

				for (int n = 0; n < evo.getInverses().size(); n++) {
					String property = formatProperty(evo.getInverses().get(n)
							.getName());
					PropertyVO t = properties.get(property);
					if (t == null) {
						t = new PropertyVO(property, true, true, evo
								.getInverses().get(n).getIfc_class());
						properties.put(property, t);
					}
					t.addIfcClass(evo.getName());
				}

				out.write("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, PropertyVO> entry : properties.entrySet()) {
			PropertyVO property = entry.getValue();
			outputOWLproperty(out, property);
		}

	}

	public void outputIFCClasses() {
		Iterator<Entry<String, EntityVO>> it = entities.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, EntityVO> pairs = it.next();
			EntityVO evo = pairs.getValue();
			if (evo.getSuperclass() != null)
				System.out
						.println(pairs.getKey() + " s:" + evo.getSuperclass());
			else
				System.out.println(pairs.getKey());

			for (int n = 0; n < evo.getDerived_attribute_list().size(); n++) {
				if (evo.getDerived_attribute_list().get(n).isReverse_pointer())
					System.out.println(" "
							+ evo.getDerived_attribute_list().get(n).getType()
									.getName()
							+ ":"
							+ evo.getDerived_attribute_list().get(n).getType()
									.getPrimarytype() + "   "
							+ evo.getDerived_attribute_list().get(n).getName()
							+ " CAN BE REVERSED");
				else
					System.out.println(" "
							+ evo.getDerived_attribute_list().get(n).getType()
									.getName()
							+ ":"
							+ evo.getDerived_attribute_list().get(n).getType()
									.getPrimarytype() + "   "
							+ evo.getDerived_attribute_list().get(n).getName());
			}
			for (int n = 0; n < evo.getDerived_inverse_list().size(); n++) {
				System.out.println(" i:"
						+ evo.getDerived_inverse_list().get(n).getName());
			}
		}
	}

	private void outputJavaStringClass2Interface(String interface_name) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"c:\\jo\\generated\\" + interface_name
							+ "_StringValue.java"));

			out.write("package fi.ni.ifc2x3;\n");
			out.write("import fi.ni.ifc2x3.interfaces.*;\n");

			out.write("\n");
			out.write("/*\n");
			out.write(" * IFC Java class for String valued unknown interface type\n");
			out.write(" * @author Jyrki Oraskari\n");
		    out.write("Permission is hereby granted, free of charge, to any person obtaining a copy\n");
		    out.write("of this software and associated documentation files (the \"Software\"), to deal\n");
		    out.write("in the Software without restriction, including without limitation the rights\n");
		    out.write("to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n");
		    out.write("copies of the Software, and to permit persons to whom the Software is\n");
		    out.write("furnished to do so, subject to the following conditions:\n");
		    out.write("\n");
		    out.write("The above copyright notice and this permission notice shall be included in all\n");
		    out.write("copies or substantial portions of the Software.\n");
		    out.write("\n");
		    out.write("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n");
		    out.write("IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n");
		    out.write("FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n");
		    out.write("AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n");
		    out.write("LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n");
		    out.write("OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n");
		    out.write("SOFTWARE.\n");
			out.write(" */\n");
			out.write("\n");

			out.write("public class ");
			out.write(interface_name + "_StringValue implements "
					+ interface_name);

			out.write("\n{\n");

			out.write("String value;\n");
			out.write("public String geValue() {\n");
			out.write("return value;\n");
			out.write("}\n");
			out.write("public void setValue(String value){\n");
			out.write("this.value=value;\n");

			out.write("}\n");

			out.write("}\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void outputJavaInterfaces() {
		Iterator<Entry<String, String>> it = interfaces.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> pairs = it.next();
			String name = pairs.getValue();
			outputJavaStringClass2Interface(name);
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(
						"c:\\jo\\interfaces\\" + pairs.getValue() + ".java"));

				out.write("package fi.ni.ifc2x3.interfaces;\n");

				out.write("\n");
				out.write("/*\n");
				out.write(" * IFC type select 2 Java interface\n");
				out.write(" * @author Jyrki Oraskari\n");
				out.write("The MIT License (MIT)\n");
			    out.write("\n");
			    out.write("Copyright (c) 2014 Jyrki Oraskari\n");
			    out.write("\n");
			    out.write("Permission is hereby granted, free of charge, to any person obtaining a copy\n");
			    out.write("of this software and associated documentation files (the \"Software\"), to deal\n");
			    out.write("in the Software without restriction, including without limitation the rights\n");
			    out.write("to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n");
			    out.write("copies of the Software, and to permit persons to whom the Software is\n");
			    out.write("furnished to do so, subject to the following conditions:\n");
			    out.write("\n");
			    out.write("The above copyright notice and this permission notice shall be included in all\n");
			    out.write("copies or substantial portions of the Software.\n");
			    out.write("\n");
			    out.write("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n");
			    out.write("IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n");
			    out.write("FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n");
			    out.write("AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n");
			    out.write("LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n");
			    out.write("OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n");
			    out.write("SOFTWARE.\n");
				out.write(" */\n");
				out.write("\n");

				out.write("public interface ");
				out.write(pairs.getValue() + " ");

				out.write("\n{\n");

				out.write("}\n");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void outputJavaClasses() {
		outputJavaInterfaces();
		Iterator<Entry<String, EntityVO>> it = entities.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, EntityVO> pairs = it.next();
			EntityVO evo = pairs.getValue();
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(
						"c:\\jo\\generated\\" + evo.getName() + ".java"));

				out.write("package fi.ni.ifc2x3;\n");
				out.write("import fi.ni.ifc2x3.interfaces.*;\n");
				out.write("import fi.ni.*;\n");
				out.write("import java.util.*;\n");

				out.write("\n");
				out.write("/*\n");
				out.write(" * IFC Java class\n");
				out.write("The MIT License (MIT)\n");
			    out.write("\n");
			    out.write("Copyright (c) 2014 Jyrki Oraskari\n");
			    out.write("\n");
			    out.write("Permission is hereby granted, free of charge, to any person obtaining a copy\n");
			    out.write("of this software and associated documentation files (the \"Software\"), to deal\n");
			    out.write("in the Software without restriction, including without limitation the rights\n");
			    out.write("to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n");
			    out.write("copies of the Software, and to permit persons to whom the Software is\n");
			    out.write("furnished to do so, subject to the following conditions:\n");
			    out.write("\n");
			    out.write("The above copyright notice and this permission notice shall be included in all\n");
			    out.write("copies or substantial portions of the Software.\n");
			    out.write("\n");
			    out.write("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n");
			    out.write("IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n");
			    out.write("FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n");
			    out.write("AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n");
			    out.write("LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n");
			    out.write("OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n");
			    out.write("SOFTWARE.\n");
				out.write(" */\n");
				out.write("\n");

				out.write("public class ");
				if (evo.getSuperclass() != null)
					out.write(evo.getName() + " extends " + evo.getSuperclass()
							+ " ");
				else
					out.write(evo.getName() + " extends Thing ");

				if (evo.getInterfaces().size() > 0)
					out.write("implements");
				for (int n = 0; n < evo.getInterfaces().size(); n++) {
					if (n > 0)
						out.write(",");
					out.write(" " + evo.getInterfaces().get(n));
				}

				out.write("\n{\n");

				outputJavaAttributes(evo, out);
				outputJavaGetSetMethods2Attributes(evo, out);

				if (evo.getInverses().size() > 0)
					out.write(" // Getters and setters of inverse values\n\n");
				for (int n = 0; n < evo.getInverses().size(); n++) {
					out.write(" public InverseLinksList<"
							+ evo.getInverses().get(n).getIfc_class()
							+ "> get"
							+ formatGetterANDSetter(evo.getInverses().get(n)
									.getName()) + "() {\n");
					out.write("   return " + evo.getInverses().get(n).getName()
							+ ";\n");
					out.write("\n }\n");
					out.write(" public void set"
							+ formatGetterANDSetter(evo.getInverses().get(n)
									.getName()) + "("
							+ evo.getInverses().get(n).getIfc_class()
							+ " value){\n");
					out.write("   this." + evo.getInverses().get(n).getName()
							+ ".add(value);\n");
					out.write("\n }\n\n");
				}

				out.write("}\n");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Output java attributes.
	 * 
	 * @param evo
	 *            the IFC class object to write into Java class
	 * @param out
	 *            the writer
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void outputJavaAttributes(EntityVO evo, BufferedWriter out)
			throws IOException {
		if (evo.getAttributes().size() > 0)
			out.write(" // The property attributes\n");

		for (int n = 0; n < evo.getAttributes().size(); n++) {

			EntityVO entity = this.entities.get(formatClassName(evo
					.getAttributes().get(n).getType().getName()));

			String primary_type = evo.getAttributes().get(n).getType()
					.getPrimarytype();
			String java_type = "String";
			if (primary_type.startsWith("IFC"))
				primary_type = types.get(primary_type).getPrimarytype();
			if ("REAL".equals(primary_type))
				java_type = "Double";
			if ("INTEGER".equals(primary_type))
				java_type = "Long";
			if (evo.getAttributes().get(n).getType().getName()
					.equalsIgnoreCase("IfcTimeStamp"))
				java_type = "Date";

			String listtype = "";
			if (evo.getAttributes().get(n).isList())
				listtype = "IfcList";
			else
				listtype = "IfcSet";

			if (entity == null) {
				String typekey = formatClassName(evo.getAttributes().get(n)
						.getType().getName());
				String alias = interface_aliases.get(evo.getAttributes().get(n)
						.getType().getName());
				if (alias != null)
					typekey = formatClassName(alias);
				String itype = this.interfaces.get(typekey);

				if (itype != null) {
					// INTERFACE
					if (evo.getAttributes().get(n).isSet())
						out.write(" List<" + itype + "> "
								+ evo.getAttributes().get(n).getName()
								+ " = new " + listtype + "<" + itype + ">();\n");
					else
						out.write(itype + " "
								+ evo.getAttributes().get(n).getName() + ";\n");
				} else {
					// BASIC ATTRIBUTE
					if (evo.getAttributes().get(n).isSet())
						out.write(" List<" + java_type + "> "
								+ evo.getAttributes().get(n).getName()
								+ " = new " + listtype + "<" + java_type
								+ ">();\n");
					else {
						out.write(" " + java_type + " "
								+ evo.getAttributes().get(n).getName() + ";\n");
					}

				}
			} else {
				// IFC ENTITY
				if (evo.getAttributes().get(n).isSet())
					out.write(" List<"
							+ evo.getAttributes().get(n).getType().getName()
							+ "> " + evo.getAttributes().get(n).getName()
							+ " = new " + listtype + "<"
							+ evo.getAttributes().get(n).getType().getName()
							+ ">();\n");
				else
					out.write(" "
							+ evo.getAttributes().get(n).getType().getName()
							+ "   " + evo.getAttributes().get(n).getName()
							+ ";\n");

			}
		}
		if (evo.getInverses().size() > 0)
			out.write(" // The inverse attributes\n\n");
		for (int n = 0; n < evo.getInverses().size(); n++) {
			out.write(" InverseLinksList<"
					+ evo.getInverses().get(n).getIfc_class() + "> "
					+ evo.getInverses().get(n).getName()
					+ "= new InverseLinksList<"
					+ evo.getInverses().get(n).getIfc_class() + ">();\n");

		}
		out.write("\n\n");
	}

	/**
	 * Output java get set methods for attributes.
	 * 
	 * @param evo
	 *            the IFC class object to write into Java class
	 * @param out
	 *            the writer
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void outputJavaGetSetMethods2Attributes(EntityVO evo,
			BufferedWriter out) throws IOException {
		// Getters & setters
		if (evo.getAttributes().size() > 0)
			out.write(" // Getters and setters of properties\n\n");
		for (int n = 0; n < evo.getAttributes().size(); n++) {

			EntityVO entity = this.entities.get(formatClassName(evo
					.getAttributes().get(n).getType().getName()));

			String primary_type = evo.getAttributes().get(n).getType()
					.getPrimarytype();
			String java_type = "String";
			if (primary_type.startsWith("IFC"))
				primary_type = types.get(primary_type).getPrimarytype();
			if ("REAL".equals(primary_type))
				java_type = "Double";
			if ("INTEGER".equals(primary_type))
				java_type = "Long";
			if (evo.getAttributes().get(n).getType().getName()
					.equalsIgnoreCase("IfcTimeStamp"))
				java_type = "Date";

			if (entity == null) {
				String typekey = formatClassName(evo.getAttributes().get(n)
						.getType().getName());
				String alias = interface_aliases.get(evo.getAttributes().get(n)
						.getType().getName());
				if (alias != null)
					typekey = formatClassName(alias);
				String itype = this.interfaces.get(typekey);

				if (itype != null) {
					// ITYPE: Interface type
					// GET
					if (evo.getAttributes().get(n).isSet()) {
						out.write(" public List<"
								+ evo.getAttributes().get(n).getType()
										.getName()
								+ "> get"
								+ formatGetterANDSetter(evo.getAttributes()
										.get(n).getName()) + "() {\n");
						out.write("   return "
								+ evo.getAttributes().get(n).getName() + ";");
						out.write("\n }\n");
					} else {
						out.write(" public "
								+ itype
								+ " get"
								+ formatGetterANDSetter(evo.getAttributes()
										.get(n).getName()) + "() {\n");
						out.write("   return "
								+ evo.getAttributes().get(n).getName() + ";");
						out.write("\n }\n");

					}
					// SET

					if (evo.getAttributes().get(n).isSet()) {
						out.write(" public void set"
								+ formatGetterANDSetter(evo.getAttributes()
										.get(n).getName()) + "(" + itype
								+ " value){\n");
						out.write("   this."
								+ evo.getAttributes().get(n).getName()
								+ ".add(value);\n");
						out.write("\n }\n\n");
					} else {
						out.write(" public void set"
								+ formatGetterANDSetter(evo.getAttributes()
										.get(n).getName()) + "(" + itype
								+ " value){\n");
						out.write("   this."
								+ evo.getAttributes().get(n).getName()
								+ "=value;\n");
						out.write("\n }\n\n");
					}
				} else {
					// BASIC TYPES
					// GET
					if (evo.getAttributes().get(n).isSet()) {
						out.write(" public List<"
								+ java_type
								+ "> get"
								+ formatGetterANDSetter(evo.getAttributes()
										.get(n).getName()) + "() {\n");
						out.write("   return "
								+ evo.getAttributes().get(n).getName() + ";");
						out.write("\n }\n");
					} else {
						out.write(" public "
								+ java_type
								+ " get"
								+ formatGetterANDSetter(evo.getAttributes()
										.get(n).getName()) + "() {\n");
						out.write("   return "
								+ evo.getAttributes().get(n).getName() + ";");
						out.write("\n }\n");

					}
					// SET
					if (evo.getAttributes().get(n).isSet()) {

						if ("REAL".equals(primary_type)) {
							out.write(" public void set"
									+ formatGetterANDSetter(evo.getAttributes()
											.get(n).getName())
									+ "(String txt){\n");
							out.write("   List<Double> value = i.toDoubleList(txt);\n");
							out.write("   this."
									+ evo.getAttributes().get(n).getName()
									+ "=value;\n");
							out.write("\n }\n\n");
						}

						else if (evo.getAttributes().get(n).getType().getName()
								.equalsIgnoreCase("IfcTimeStamp")) {
							out.write(" public void set"
									+ formatGetterANDSetter(evo.getAttributes()
											.get(n).getName())
									+ "(String txt){\n");
							out.write("   Date value = new Date(1000l * i.toLong(txt) );\n");
							out.write("   this."
									+ evo.getAttributes().get(n).getName()
									+ ".add(value);\n");
							out.write("\n }\n\n");
						}

						else if ("INTEGER".equals(primary_type)) {
							out.write(" public void set"
									+ formatGetterANDSetter(evo.getAttributes()
											.get(n).getName())
									+ "(String txt){\n");
							out.write("   List<Long> value = i.toLongList(txt);\n");
							out.write("   this."
									+ evo.getAttributes().get(n).getName()
									+ "=value;\n");
							out.write("\n }\n\n");

						} else {
							out.write(" public void set"
									+ formatGetterANDSetter(evo.getAttributes()
											.get(n).getName()) + "("
									+ java_type + " value){\n");
							out.write("   this."
									+ evo.getAttributes().get(n).getName()
									+ ".add(value);\n");
							out.write("\n }\n\n");
						}

					} else {
						if ("REAL".equals(primary_type)) {
							out.write(" public void set"
									+ formatGetterANDSetter(evo.getAttributes()
											.get(n).getName())
									+ "(String txt){\n");
							out.write("   Double value = i.toDouble(txt);\n");
							out.write("   this."
									+ evo.getAttributes().get(n).getName()
									+ "=value;\n");
							out.write("\n }\n\n");
						} else if (evo.getAttributes().get(n).getType()
								.getName().equalsIgnoreCase("IfcTimeStamp")) {
							out.write(" public void set"
									+ formatGetterANDSetter(evo.getAttributes()
											.get(n).getName())
									+ "(String txt){\n");
							out.write("   Date value = new Date(1000l * i.toLong(txt) );\n");
							out.write("   this."
									+ evo.getAttributes().get(n).getName()
									+ "=value;\n");
							out.write("\n }\n\n");
						} else if ("INTEGER".equals(primary_type)) {
							out.write(" public void set"
									+ formatGetterANDSetter(evo.getAttributes()
											.get(n).getName())
									+ "(String txt){\n");
							out.write("   Long value = i.toLong(txt);\n");
							out.write("   this."
									+ evo.getAttributes().get(n).getName()
									+ "=value;\n");
							out.write("\n }\n\n");
						} else {
							out.write(" public void set"
									+ formatGetterANDSetter(evo.getAttributes()
											.get(n).getName()) + "("
									+ java_type + " value){\n");
							out.write("   this."
									+ evo.getAttributes().get(n).getName()
									+ "=value;\n");
							out.write("\n }\n\n");

						}

					}
				}

			} else {
				// IFC ENTIY
				// -------------------------
				// GET
				if (evo.getAttributes().get(n).isSet()) {
					out.write(" public List<"
							+ evo.getAttributes().get(n).getType().getName()
							+ "> get"
							+ formatGetterANDSetter(evo.getAttributes().get(n)
									.getName()) + "() {\n");
					out.write("   return "
							+ evo.getAttributes().get(n).getName() + ";\n");
					out.write("\n }\n");
				} else {
					out.write(" public "
							+ evo.getAttributes().get(n).getType().getName()
							+ " get"
							+ formatGetterANDSetter(evo.getAttributes().get(n)
									.getName()) + "() {\n");
					out.write("   return "
							+ evo.getAttributes().get(n).getName() + ";\n");
					out.write("\n }\n");
				}
				// SET
				if (evo.getAttributes().get(n).isSet()) {
					out.write(" public void set"
							+ formatGetterANDSetter(evo.getAttributes().get(n)
									.getName()) + "("
							+ evo.getAttributes().get(n).getType().getName()
							+ " value){\n");
					out.write("   this." + evo.getAttributes().get(n).getName()
							+ ".add(value);\n");
					out.write("\n }\n\n");
				} else {
					out.write(" public void set"
							+ formatGetterANDSetter(evo.getAttributes().get(n)
									.getName()) + "("
							+ evo.getAttributes().get(n).getType().getName()
							+ " value){\n");
					out.write("   this." + evo.getAttributes().get(n).getName()
							+ "=value;\n");
					out.write("\n }\n\n");
				}

			}

		}
	}

	private void printEntity(EntityVO evo) {
		if (evo.getSuperclass() != null) {
			EntityVO sup = entities.get(evo.getSuperclass().toLowerCase());
			if (sup != null)
				printEntity(sup);
		}

		for (int n = 0; n < evo.getAttributes().size(); n++) {
			System.out.println("   " + evo.getName() + " , "
					+ evo.getAttributes().get(n));
		}

	}

	public void iterate() {
		Iterator<Entry<String, EntityVO>> it = entities.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, EntityVO> pairs = it.next();
			EntityVO evo = pairs.getValue();
			if (evo.getSuperclass() != null) {
				System.out
						.println(pairs.getKey() + " s:" + evo.getSuperclass());
				EntityVO sup = entities.get(evo.getName());
				if (sup != null)
					printEntity(sup);
			} else
				System.out.println(pairs.getKey());

			printEntity(evo);
		}

	}

	private void add_attribute_entries(EntityVO evo, EntityVO top) {
		if (evo.getSuperclass() != null) {
			EntityVO sup = entities.get(formatClassName(evo.getSuperclass()));
			if (sup != null)
				add_attribute_entries(sup, top);
		}

		for (int n = 0; n < evo.getAttributes().size(); n++) {
			attributes.put(top.getName() + "#"
					+ evo.getAttributes().get(n).getName(), evo.getAttributes()
					.get(n));
			top.getDerived_attribute_list().add(evo.getAttributes().get(n));
		}

	}

	public void generate_derived_attribute_list() {
		Iterator<Entry<String, EntityVO>> it = entities.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, EntityVO> pairs = it.next();
			EntityVO evo = pairs.getValue();
			add_attribute_entries(evo, evo);
		}

	}

	private boolean isSubClassOf_this(EntityVO evo, String superclass_name) {
		if (evo.getName().equalsIgnoreCase(superclass_name))
			return true;
		if (evo.getSuperclass() != null) {
			EntityVO sup = entities.get(evo.getSuperclass());
			if (sup != null) {
				if (isSubClassOf_this(sup, superclass_name))
					return true;
			}
		}
		return false;
	}

	public boolean isSubClassOf(String class_name, String superclass_name) {
		return isSubClassOf_this(entities.get(class_name), superclass_name);

	}

	private void add_inverse_entries(EntityVO evo, EntityVO top) {
		if (evo.getSuperclass() != null) {
			EntityVO sup = entities.get(evo.getSuperclass());
			if (sup != null)
				add_inverse_entries(sup, top);
		}

		for (int n = 0; n < evo.getInverses().size(); n++) {
			AttributeVO avo = attributes.get(evo.getInverses().get(n)
					.getIfc_class()
					+ "#" + evo.getInverses().get(n).getProperty());
			boolean unique = false;
			if (avo != null) {
				InverseVO ivo = evo.getInverses().get(n);
				if (ivo.isOne_valued())
					if (!avo.isSet())
						avo.setOne2One(true);
				if (avo.isUnique())
					unique = true;
				avo.setReverse_pointer(true);
				avo.setPoints_from(evo.getInverses().get(n));
			} else
				System.err.println("reverse not found:"
						+ evo.getInverses().get(n).getIfc_class() + "#"
						+ evo.getInverses().get(n).getProperty());
			evo.getInverses().get(n).setUnique(unique);
			top.getDerived_inverse_list().add(evo.getInverses().get(n));
		}

	}

	public void generate_derived_inverse_list() {
		Iterator<Entry<String, EntityVO>> it = entities.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, EntityVO> pairs = it.next();
			EntityVO evo = (EntityVO) pairs.getValue();
			add_inverse_entries(evo, evo);
		}

	}

	private static final int INIT_STATE = 0;
	private static final int TYPE_STATE = 1;
	private static final int TYPE_SWITCH = 101;
	private static final int TYPE_SELECT = 102;
	private static final int TYPE_ENUMERATION = 103;
	private static final int TYPE_ENUMERATION_OF = 104;

	private static final int ENTITY_STATE = 2;
	private static final int ENTITY_READY = 201;
	private static final int ENTITY_SUBTYPE_STATE = 3;
	private static final int ENTITY_SUBTYPE_OF_STATE = 4;
	private static final int ENTITY_UNIQUE = 50;
	private static final int ENTITY_UNIQUE_TYPE = 51;
	private static final int ENTITY_ATTRIBUTE = 6;
	private static final int ENTITY_WHERE = 7;
	private static final int ENTITY_DERIVE = 8;
	private static final int ENTITY_SUPERTYPE = 90;
	private static final int ENTITY_SUPERTYPE_OF_ONEOF = 91;
	private static final int ENTITY_NAME_STATE = 11;
	private static final int ENTITY_INVERSE_STATE = 111;
	private static final int ENTITY_INVERSE_SET_OF = 112;
	private static final int ENTITY_INVERSE_FOR = 113;

	private int state = INIT_STATE;
	private EntityVO current_entity = null;
	private String tmp_inverse_name;
	private String tmp_inverse_ifc_class;
	private String tmp_inverse_ifc_property;
	private boolean tmp_inverse_is_one_valued = false;

	private String tmp_entity_name;
	private String tmp_entity_type;
	private TypeVO current_type;
	private Set<String> current_sibling_set;

	private boolean is_set = false;
	private boolean is_list = false;

	private void state_machine(String txt) {

		switch (state) {
		case INIT_STATE:
			if (txt.equalsIgnoreCase("TYPE"))
				state = TYPE_STATE;
			if (txt.equalsIgnoreCase("ENTITY"))
				state = ENTITY_NAME_STATE;
			break;

		case TYPE_STATE:
			if (txt.endsWith("=")) {
				state = TYPE_SWITCH;
			} else {
				String txt_t = formatClassName(txt);
				TypeVO t = types.get(txt_t);
				if (t == null) {
					current_type = new TypeVO(txt);
					types.put(txt_t, current_type);
				}
			}
			break;

		case TYPE_SWITCH:
			if (txt.equalsIgnoreCase("SELECT")) {
				state = TYPE_SELECT;

				for (Map.Entry<String, TypeVO> entry : types.entrySet()) {
					TypeVO vo = entry.getValue();
					// List of all TYPE:SELECT -entries
					for (int n = 0; n < vo.getSelected_entities().size(); n++) {
						if (current_type.getName().equalsIgnoreCase(
								vo.getSelected_entities().get(n))) {
							current_type.setPrimarytype(formatClassName(txt));
							interface_aliases.put(current_type.getName(),
									vo.getName());
							vo.getSelected_entities().remove(n);
							current_type = vo;
							break;
						}
					}
				}

			} else if (txt.equalsIgnoreCase("ENUMERATION")) {
				state = TYPE_ENUMERATION;
			} else {
				state = INIT_STATE;
			}
			current_type.setPrimarytype(formatClassName(txt));
			break;

		case TYPE_SELECT:

			if (txt.endsWith(";")) {
				String txt_t = formatClassName(txt);
				if (current_type != null)
					current_type.getSelected_entities().add(txt_t);
				state = INIT_STATE;
			} else {
				String txt_t = formatClassName(txt);
				if (current_type != null)
					current_type.getSelected_entities().add(txt_t);
			}
			break;

		case TYPE_ENUMERATION:
			if (txt.equals("OF")) {
				state = TYPE_ENUMERATION_OF;
			}
			break;

		case TYPE_ENUMERATION_OF:
			if (txt.endsWith(";")) {
				String txt_t = formatClassName(txt);
				if (current_type != null)
					current_type.getEnum_entities().add(txt_t);
				state = INIT_STATE;
			} else {
				String txt_t = formatClassName(txt);
				if (current_type != null)
					current_type.getEnum_entities().add(txt_t);
			}
			break;

		case ENTITY_NAME_STATE:
			// replaces all non-letter characters with nothing
			String org_name = txt;
			if (org_name.endsWith(";"))
				org_name = org_name.substring(0, org_name.length() - 1);
			String entity_name = ExpressReader.formatClassName(org_name);
			current_entity = entities.get(entity_name);
			if (current_entity == null) {
				current_entity = new EntityVO(org_name);
				entities.put(entity_name, current_entity);
			}
			state = ENTITY_STATE;
			break;

		case ENTITY_STATE:
			is_set = false;
			is_list = false;
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			} else if (txt.equalsIgnoreCase(":")) {
				state = ENTITY_ATTRIBUTE;
			} else if (txt.equalsIgnoreCase("UNIQUE")) {
				state = ENTITY_UNIQUE;
			} else if (txt.equalsIgnoreCase("WHERE")) {
				state = ENTITY_WHERE;
			} else if (txt.equalsIgnoreCase("DERIVE")) {
				state = ENTITY_DERIVE;
			} else if (txt.equalsIgnoreCase("INVERSE")) {
				state = ENTITY_INVERSE_STATE;
			} else if (txt.equalsIgnoreCase("SUPERTYPE")) {
				state = ENTITY_SUPERTYPE;
			} else if (txt.equalsIgnoreCase("ABSTRACT")) {
				state = ENTITY_SUPERTYPE;
			} else {
				tmp_entity_name = ExpressReader.formatProperty(txt);
				state = ENTITY_READY;
			}
			break;

		case ENTITY_READY:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SET")) {
				is_set = true;
			} else if (txt.equalsIgnoreCase("LIST")) {
				is_set = true;
				is_list = true;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			} else if (txt.contains(";")) {

				tmp_entity_type = ExpressReader.formatClassName(txt.substring(
						0, txt.length() - 1));
				TypeVO type = types.get(tmp_entity_type);
				if (type == null) {
					type = new TypeVO(txt.substring(0, txt.length() - 1),
							"CLASS");
				}
				current_entity.getAttributes()
						.add(new AttributeVO(tmp_entity_name, type, is_set,
								is_list));
				state = ENTITY_STATE;
			}
			break;

		case ENTITY_UNIQUE:
			if (txt.equals(":"))
				state = ENTITY_UNIQUE_TYPE;
			else if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("WHERE")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			}
			break;

		case ENTITY_UNIQUE_TYPE:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("WHERE")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			} else {
				if (!txt.contains(",")) {
					String unique_attribute = ExpressReader.formatProperty(txt
							.substring(0, txt.length() - 1));
					// System.out.println("A "+current_entity.getName()+"."+unique_attribute);

					for (int j = 0; j < current_entity.getAttributes().size(); j++) {
						AttributeVO ao = current_entity.getAttributes().get(j);
						if (ao.getName().equals(unique_attribute)) {
							ao.setUnique(true);
						}
					}
				}
				state = ENTITY_UNIQUE;
			}
			break;
		case ENTITY_WHERE:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			}
			break;
		case ENTITY_DERIVE:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			}

			break;
		case ENTITY_ATTRIBUTE:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else {
				if (txt.contains(";"))
					state = ENTITY_STATE;
			}
			break;
		case ENTITY_INVERSE_STATE:
			is_set = false;
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			} else if (txt.equalsIgnoreCase(":")) { // the name of the
				// inverse
				// attribute
				state = ENTITY_INVERSE_SET_OF;
			} else
				tmp_inverse_name = ExpressReader.formatProperty(txt);
			break;

		case ENTITY_INVERSE_SET_OF:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			} else if (txt.equalsIgnoreCase("SET")) {
				is_set = true;
			} else if (txt.equalsIgnoreCase("FOR")) {
				state = ENTITY_INVERSE_FOR;
			} else {
				if (txt.equals("[0:1]"))
					tmp_inverse_is_one_valued = true;
				if (txt.equals("[1:1]"))
					tmp_inverse_is_one_valued = true;

				tmp_inverse_ifc_class = txt;// ExpressReader.formatClassName(txt);
			}
			break;
		case ENTITY_INVERSE_FOR:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			} else if (txt.contains(";")) {

				tmp_inverse_ifc_property = ExpressReader.formatProperty(txt
						.substring(0, txt.length() - 1));
				current_entity.getInverses().add(
						new InverseVO(tmp_inverse_name, tmp_inverse_ifc_class,
								tmp_inverse_ifc_property, is_set,
								tmp_inverse_is_one_valued));
				state = ENTITY_INVERSE_STATE;
			}
			break;

		case ENTITY_SUPERTYPE:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			} else if (txt.equalsIgnoreCase("(ONEOF")) {
				state = ENTITY_SUPERTYPE_OF_ONEOF;
				current_sibling_set = new HashSet<String>();
			} else {
				if (txt.contains(";"))
					state = ENTITY_STATE;
			}
			break;

		case ENTITY_SUPERTYPE_OF_ONEOF:
			if (txt.equalsIgnoreCase("END_ENTITY;")) {
				state = INIT_STATE;
			} else if (txt.equalsIgnoreCase("SUBTYPE")) {
				state = ENTITY_SUBTYPE_STATE;
			} else {
				if (txt.contains(";"))
					state = ENTITY_STATE;
				if (txt.contains(")"))
					state = ENTITY_STATE;
				String sibstr = filter_extras(txt);
				current_sibling_set.add(sibstr);
				@SuppressWarnings("rawtypes")
				Set s = this.siblings.get(sibstr);
				if (s != null)
					System.err.println("DUBLICATE: " + sibstr);
				else
					this.siblings.put(sibstr, current_sibling_set);
			}
			break;

		case ENTITY_SUBTYPE_STATE:
			if (txt.equalsIgnoreCase("OF"))
				state = ENTITY_SUBTYPE_OF_STATE;
			else
				state = ENTITY_STATE;
			break;
		case ENTITY_SUBTYPE_OF_STATE:
			current_entity.setSuperclass(filter_extras(txt));

			state = ENTITY_STATE;
			break;

		default:
			// Do nothing
		}
	}

	static public String filter_extras(String txt) {
		StringBuffer sb = new StringBuffer();
		for (int n = 0; n < txt.length(); n++) {
			char ch = txt.charAt(n);
			switch (ch) {
			case '(':
				break;
			case ';':
				break;
			case ',':
				break;
			case ')':
				break;
			default:
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	private void parse_level(String txt) {
		StringTokenizer st = new StringTokenizer(txt);
		while (st.hasMoreTokens()) {
			state_machine(st.nextToken());
		}
	}

	public void readSpec(String model_file) {
		try {

			FileInputStream fstream = new FileInputStream(model_file);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			try {
				String strLine;
				while ((strLine = br.readLine()) != null) {
					if (strLine.length() > 0) {
						parse_level(strLine);
					}
				}
			} finally {
				br.close();
			}

		}
		catch (FileNotFoundException fe) {
		    System.err.println("The IFC Express file IFC2X3_Final.exp is missing.");
		    System.exit(1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, TypeVO> entry : types.entrySet()) {
			TypeVO vo = entry.getValue();
			// List of all TYPE:SELECT -entries
			for (int n = 0; n < vo.getSelected_entities().size(); n++) {
				EntityVO evo = entities.get(vo.getSelected_entities().get(n));
				if (evo != null) {
					evo.getInterfaces().add(vo.getName());
					interfaces.put(formatClassName(vo.getName()), vo.getName());
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		ExpressReader er = new ExpressReader("c:\\2014\\IFC2X3_Final.exp");
//		ExpressReader er = new ExpressReader("samples\\IFC2X3_TC1.exp");
		//er.outputIFCClasses();
		er.outputJavaClasses();

		FileWriter fw = new FileWriter("out\\IFC2X3_TC1.n3");
		
		BufferedWriter out = new BufferedWriter(fw);
		er.outputRDFS(out);
		er.outputOWL(out);
		
		
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();

	}

}
