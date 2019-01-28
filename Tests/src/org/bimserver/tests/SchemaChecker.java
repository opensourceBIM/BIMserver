//package org.bimserver.tests;

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

//import java.util.HashMap;
//
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.compare.match.metamodel.MatchModel;
//import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
//import org.eclipse.emf.compare.match.service.MatchService;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class SchemaChecker {
//	private static final Logger LOGGER = LoggerFactory.getLogger(SchemaChecker.class);
//	private final Schema schema1;
//	private final Schema schema2;
//
//	public SchemaChecker(Schema schema1, Schema schema2) {
//		this.schema1 = schema1;
//		this.schema2 = schema2;
//	}
//
//	public boolean compare() {
//		Resource left = new ResourceImpl();
//		left.getContents().addAll(schema1.getEPackages());
//		Resource right = new ResourceImpl();
//		right.getContents().addAll(schema2.getEPackages());
//		try {
//			MatchModel resourceMatch = MatchService.doResourceMatch(left, right, new HashMap<String, Object>());
//			EList<UnmatchElement> unmatchedElements = resourceMatch.getUnmatchedElements();
//			if (!unmatchedElements.isEmpty()) {
//				for (UnmatchElement unmatchElement : unmatchedElements) {
//					LOGGER.error("Unmatch in: " + unmatchElement.getElement());
//				}
//				return false;
//			} else {
//				return true;
//			}
//		} catch (InterruptedException e) {
//			LOGGER.error("", e);
//		}
//		return false;
//	}
//}