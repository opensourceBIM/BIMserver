package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.utils.StringUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;

public class StructureAnalyzer {
	
	private PrintWriter out;
	private int limit;
	private int count;
	private PrintWriter out2;

	public static void main(String[] args) {
		new StructureAnalyzer().start();
	}

	private void start() {
		limit = 1000000;
		try {
			out = new PrintWriter(Paths.get("structure.txt").toFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int i=0;
//		Ifc2x3tc1Package einstance = Ifc2x3tc1Package.eINSTANCE;
//		System.out.println(printClassifier("root", Ifc2x3tc1Package.eINSTANCE.getEClassifier("IfcWall"), new ArrayList<EClassifier>(), 0));
//		EList<EClassifier> classifiers = Ifc2x3tc1Package.eINSTANCE.getEClassifiers();
		EList<EClassifier> classifiers = new BasicEList<EClassifier>();
		classifiers.add(Ifc2x3tc1Package.eINSTANCE.getEClassifier("IfcWall"));
		for (EClassifier ecl : classifiers) {
			try {
				out2 = new PrintWriter(Paths.get("structure/" + ecl.getName() + ".txt").toFile());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			count = 0;
			int printClassifier = printClassifier("root", ecl, new ArrayList<EClassifier>(), 0);
			if (printClassifier == -1) {
				out2.println("TERMINATED AFTER " + limit + " REFERENCES");
			}
			String string = i + "\t" + printClassifier + "\t" + ecl.getName();
			System.out.println(string);
			out.println(string);
			out.flush();
			out2.close();
			i++;
		}
		out.close();
	}
	
	@SuppressWarnings("unchecked")
	private int printClassifier(String name, EClassifier classifier, ArrayList<EClassifier> referrers, int indention) {
		out2.println(StringUtils.fill("", indention, "\t") + name + ": " + classifier.getName());
		if (count > limit) {
			return -1;
		}
		count++;
		if (classifier instanceof EClass) {
			EClass eClass = (EClass)classifier;
			int references = 0;
			for (EReference reference : eClass.getEAllReferences()) {
				String name2 = reference.getName();
				if (name2.equals("ProvidesBoundaries") || name2.equals("ContainedInStructure") || 
						name2.equals("FillsVoids") || name2.equals("IsDecomposedBy") || name2.equals("Decomposes") ||
						name2.equals("RelatedObjects") || name2.equals("IsDefinedBy") || name2.equals("ReferencedBy") ||
						name2.equals("HasAssociations") || name2.equals("HasAssignments") || name2.equals("ReferencedByPlacements") || 
						name2.equals("ConnectedTo") || name2.equals("HasCoverings") || name2.equals("HasProjections") || 
						name2.equals("HasStructuralMember") || name2.equals("ReferencedInStructures") || name2.equals("VoidsElements") ||
						name2.equals("ConnectedFrom")) {
				} else {
					boolean go = true;
					for (EClassifier referrer : referrers) {
						if (referrer == reference.getEType()) {
							go = false;
						}
					}
					if (go) {
						if (((EClass)reference.getEType()).getEStructuralFeature("wrappedValue") == null) {
							references++;
							ArrayList<EClassifier> newList = (ArrayList<EClassifier>)referrers.clone();
							newList.add(classifier);
							int newReferences = printClassifier(name2, reference.getEType(), newList, indention+1);
							if (newReferences != -1) {
								references += newReferences;
							} else {
								return -1;
							}
						}
					}
				}
			}
			return references;
		}
		return 0;
	}
}