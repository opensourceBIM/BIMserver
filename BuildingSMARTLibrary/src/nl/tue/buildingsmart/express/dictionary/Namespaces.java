package nl.tue.buildingsmart.express.dictionary;

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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.XmlException;
import org.iai.ifcNamespaces.Namespace;
import org.iai.ifcNamespaces.NamespacesDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class Namespaces {
	private static final Logger LOGGER = LoggerFactory.getLogger(Namespaces.class);

	// XML file for where the Namespaces are stored
	private File nsConfFile;
	// XMLBeans instance of reader/writer for config file
	private NamespacesDocument ifcNamespaces;

	// whether or not only on namespace for all entries exist
	private boolean singleNamespace = false;

	// a list of namespaces with a list of Strings that
	// belong to the namespace
	private HashMap<String, List<String>> namespaces;

	// Hashmap EXPRESS name, namespace
	private HashMap<String, String> EXPRESSnames;

	private String defaultNS = "";

	public Namespaces(String filename) {
		EXPRESSnames = new HashMap<String, String>();
		nsConfFile = new File(filename);

		namespaces = new HashMap<String, List<String>>();
		if (!nsConfFile.exists()) {
			System.out.println("no existing file provided, using '" + filename + "' as namespace");
			singleNamespace = true;
			defaultNS = filename;
			namespaces.put(filename, new ArrayList<String>());
		}

	}

	public boolean readNSConfig() {
		if (nsConfFile.canRead() && !singleNamespace) {
			try {
				ifcNamespaces = NamespacesDocument.Factory.parse(nsConfFile);
				Namespace[] nsArray = ifcNamespaces.getNamespaces().getNamespaceArray();
				for (int i = 0; i < nsArray.length; i++) {
					Namespace ns = nsArray[i];
					List<String> objects = new ArrayList<String>();
					if (ns.getDefinedtypes() != null)
						objects.addAll(toStringList(ns.getDefinedtypes().getDefinedtypeArray()));
					if (ns.getEntites() != null)
						objects.addAll(toStringList(ns.getEntites().getEntityArray()));
					if (ns.getEnumerations() != null)
						objects.addAll(toStringList(ns.getEnumerations().getEnumerationArray()));
					if (ns.getSelects() != null)
						objects.addAll(toStringList(ns.getSelects().getSelectArray()));

					// add all objects to HashMap for easy retrieval
					String nsName = ns.getName();
					Iterator iter = objects.iterator();
					while (iter.hasNext()) {
						addNamespaceEntry((String) iter.next(), nsName);
					}

					// store the namespace with all its contents in an
					// convinient structure
					namespaces.put(nsName, objects);
				}

				return true;
			} catch (XmlException e) {
				LOGGER.error("", e);
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return false;
	}

	/**
	 * gets the namespace for an EXPRESS object such as an ENTITY, TYPE, SELECT
	 * etc.
	 * 
	 * @param objName
	 *            name of the ENTITY/TYPE/SELECT
	 * @return name of the namespace
	 */
	public String getNS(String objName) {
		if (singleNamespace)
			return defaultNS;
		return EXPRESSnames.get(objName);
	}

	private List<String> toStringList(String[] inArray) {
		List<String> sl = new ArrayList<String>();
		for (int i = 0; i < inArray.length; i++) {
			sl.add(inArray[i]);
		}
		return sl;
	}

	public void addNamespaceEntry(String EXPRESSname, String namespace) {
		EXPRESSnames.put(EXPRESSname, namespace);

	}

	public Set<String> getNamespaces() {
		return namespaces.keySet();
	}

}