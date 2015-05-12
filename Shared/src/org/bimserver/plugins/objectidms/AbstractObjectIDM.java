package org.bimserver.plugins.objectidms;

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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class AbstractObjectIDM implements ObjectIDM {

	private final Set<EClass> includedClasses = new HashSet<EClass>();
	private final Map<EClass, Set<EStructuralFeature>> includedFeatures = new HashMap<EClass, Set<EStructuralFeature>>();
	private final Map<EClass, AbstractObjectIDM> originMap = new HashMap<EClass, AbstractObjectIDM>();
	private final SchemaDefinition schema;
	private PackageMetaData packageMetaData;

	public AbstractObjectIDM(SchemaDefinition schema, PackageMetaData packageMetaData) {
		this.schema = schema;
		this.packageMetaData = packageMetaData;
	}
	
	public void includeAllClasses() {
		for (EClassifier eClassifier : Ifc2x3tc1Package.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				includedClasses.add((EClass)eClassifier);
			}
		}
	}
	
	public void exclude(EClass eClass) {
		includedClasses.remove(eClass);
		for (EClass subClass : packageMetaData.getDirectSubClasses(eClass)) {
			exclude(subClass);
		}
	}
	
	public SchemaDefinition getSchema() {
		return schema;
	}
	
	public void include(EClass eClass) {
		includedClasses.add(eClass);
		for (EClass subClass : packageMetaData.getDirectSubClasses(eClass)) {
			include(subClass);
		}
	}

	public AbstractObjectIDM getOrigin(EClass originalClass) {
		if (!originMap.containsKey(originalClass)) {
			AbstractObjectIDM originObjectIdm = new AbstractObjectIDM(getSchema(), packageMetaData);
			originMap.put(originalClass, originObjectIdm);
			return originObjectIdm;
		}
		return originMap.get(originalClass);
	}
	
	protected boolean isInverse(EStructuralFeature eStructuralFeature) throws ObjectIDMException {
		if (eStructuralFeature instanceof EReference && eStructuralFeature.getEContainingClass().getEAnnotation("wrapped") == null) {
			if (eStructuralFeature.getEAnnotation("hidden") == null && eStructuralFeature.getEContainingClass().getEAnnotation("hidden") == null) {
				EntityDefinition entityBN = schema.getEntityBN(eStructuralFeature.getEContainingClass().getName());
				if (entityBN == null) {
					throw new ObjectIDMException(eStructuralFeature.getEContainingClass().getName() + " not found");
				}
				Attribute attribute = entityBN.getAttributeBNWithSuper(eStructuralFeature.getName());
				return attribute instanceof InverseAttribute;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public void include(EClass eClass, EStructuralFeature eStructuralFeature) {
		if (!includedFeatures.containsKey(eClass)) {
			includedFeatures.put(eClass, new HashSet<EStructuralFeature>());
		}
		includedFeatures.get(eClass).add(eStructuralFeature);
		for (EClass subClass : packageMetaData.getDirectSubClasses(eClass)) {
			include(subClass, eStructuralFeature);
		}
	}
	
	public void exclude(EClass eClass, EStructuralFeature eStructuralFeature) {
		if (includedFeatures.containsKey(eClass)) {
			includedFeatures.get(eClass).remove(eStructuralFeature);
		}
		for (EClass subClass : packageMetaData.getDirectSubClasses(eClass)) {
			exclude(subClass, eStructuralFeature);
		}
	}
	
	@Override
	public boolean shouldFollowReference(EClass originalClass, EClass eClass, EStructuralFeature eStructuralFeature) {
		if (originMap.containsKey(originalClass)) {
			return originMap.get(originalClass).shouldFollowReference(originalClass, eClass, eStructuralFeature);
		} else {
			return includedFeatures.containsKey(eClass) && includedFeatures.get(eClass).contains(eStructuralFeature);
		}
	}

	@Override
	public boolean shouldIncludeClass(EClass originalClass, EClass eClass) {
		if (originMap.containsKey(originalClass)) {
			return originMap.get(originalClass).shouldIncludeClass(originalClass, eClass);
		} else {
			return includedClasses.contains(eClass);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Included classes:\n");
		for (EClass eClass : includedClasses) {
			sb.append("  " + eClass.getName() + "\n");
		}
		sb.append("Included features:\n");
		for (EClass eClass : includedFeatures.keySet()) {
			sb.append("  " + eClass.getName() + "\n");
			for (EStructuralFeature eStructuralFeature : includedFeatures.get(eClass)) {
				sb.append("    " + eStructuralFeature.getName() + "\n");
			}
		}
		return sb.toString();
	}
}