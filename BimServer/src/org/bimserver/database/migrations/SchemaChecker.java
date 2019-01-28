package org.bimserver.database.migrations;

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

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public class SchemaChecker {

	private Schema schema1;
	private Schema schema2;

	public SchemaChecker(Schema schema1, Schema schema2) {
		this.schema1 = schema1;
		this.schema2 = schema2;
	}

	public boolean compare() throws SchemaCompareException {
		if (schema1 == null || schema2 == null) {
			throw new SchemaCompareException("Schema cannot be null");
		}
		if (schema1.getEPackages().size() != schema2.getEPackages().size()) {
			throw new SchemaCompareException("Schema 1 has " + schema1.getEPackages().size() + " packages, schema2 has " + schema2.getEPackages().size() + " packages");
		}
		Iterator<EPackage> packageIterator1 = schema1.getEPackages().iterator();
		Iterator<EPackage> packageIterator2 = schema2.getEPackages().iterator();
		while (packageIterator1.hasNext()) {
			EPackage package1 = packageIterator1.next();
			EPackage package2 = packageIterator2.next();
			comparePackage(package1, package2);
		}
		return false;
	}

	private void comparePackage(EPackage package1, EPackage package2) throws SchemaCompareException {
		if (!package1.getName().equals(package2.getName())) {
			throw new SchemaCompareException("Schema package names not the same");
		}
		if (package1.getEClassifiers().size() != package2.getEClassifiers().size()) {
			throw new SchemaCompareException("Not the same amount of classifiers in package " + package1.getName());
		}
		Iterator<EClassifier> classifierIterator1 = package1.getEClassifiers().iterator();
		Iterator<EClassifier> classifierIterator2 = package2.getEClassifiers().iterator();
		while (classifierIterator1.hasNext()) {
			EClassifier classifier1 = classifierIterator1.next();
			EClassifier classifier2 = classifierIterator2.next();
			compareClassifier(classifier1, classifier2);
		}
	}

	private void compareClassifier(EClassifier classifier1, EClassifier classifier2) throws SchemaCompareException {
		if (!classifier1.getName().equals(classifier2.getName())) {
			throw new SchemaCompareException("Classifiers not the same name");
		}
		if (classifier1.getClass() != classifier2.getClass()) {
			throw new SchemaCompareException("Classifiers not of the same type");
		}
		if (classifier1 instanceof EEnum) {
			EEnum eEnum1 = (EEnum)classifier1;
			EEnum eEnum2 = (EEnum)classifier2;
			compareEEnum(eEnum1, eEnum2);
		} else if (classifier1 instanceof EClass) {
			EClass eClass1 = (EClass)classifier1;
			EClass eClass2 = (EClass)classifier2;
			compareEClass(eClass1, eClass2);
		}
	}

	private void compareEClass(EClass eClass1, EClass eClass2) throws SchemaCompareException {
		if (eClass1.getEAllStructuralFeatures().size() != eClass2.getEAllStructuralFeatures().size()) {
			throw new SchemaCompareException("Not the same amount of features in " + eClass1.getName());
		}
		Iterator<EStructuralFeature> iterator1 = eClass1.getEAllStructuralFeatures().iterator();
		Iterator<EStructuralFeature> iterator2 = eClass2.getEAllStructuralFeatures().iterator();
		while (iterator1.hasNext()) {
			EStructuralFeature structuralFeature1 = iterator1.next();
			EStructuralFeature structuralFeature2 = iterator2.next();
			if (!structuralFeature1.getName().equals(structuralFeature2.getName())) {
				throw new SchemaCompareException("Features not the same name");
			}
			if (!structuralFeature1.getEType().getName().equals(structuralFeature2.getEType().getName())) {
				throw new SchemaCompareException("Features not of the same type");
			}
		}
	}

	private void compareEEnum(EEnum eEnum1, EEnum eEnum2) throws SchemaCompareException {
		if (eEnum1.getELiterals().size() != eEnum2.getELiterals().size()) {
			throw new SchemaCompareException("Not the same amount of literals");
		}
		Iterator<EEnumLiteral> iterator1 = eEnum1.getELiterals().iterator();
		Iterator<EEnumLiteral> iterator2 = eEnum2.getELiterals().iterator();
		while (iterator1.hasNext()) {
			EEnumLiteral enumLiteral1 = iterator1.next();
			EEnumLiteral enumLiteral2 = iterator2.next();
			if (!enumLiteral1.getName().equals(enumLiteral2.getName())) {
				throw new SchemaCompareException("Literal not the same");
			}
		}
	}
}
