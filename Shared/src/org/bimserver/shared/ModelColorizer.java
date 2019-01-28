package org.bimserver.shared;

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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcLayeredItem;
import org.bimserver.models.ifc2x3tc1.IfcMappedItem;
import org.bimserver.models.ifc2x3tc1.IfcPresentationLayerAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationMap;
import org.bimserver.models.ifc2x3tc1.IfcShapeAspect;
import org.bimserver.models.ifc2x3tc1.IfcShapeModel;
import org.bimserver.models.ifc2x3tc1.IfcStyleModel;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.models.ifc2x3tc1.IfcTopologyRepresentation;

public class ModelColorizer {
	private static final float TRANSPARENCY = 0.98F;
	private IfcModelInterface model;
	private final Map<IfcStyledItem, Set<IfcProduct>> styledItemToProduct = new HashMap<IfcStyledItem, Set<IfcProduct>>();
	private final Map<IfcProduct, Set<IfcStyledItem>> productToStyledItem = new HashMap<IfcProduct, Set<IfcStyledItem>>();

	public ModelColorizer(IfcModelInterface model) {
		this.model = model;
		for (IfcProduct product : model.getAllWithSubTypes(IfcProduct.class)) {
			IfcProductRepresentation productRepresentation = product.getRepresentation();
			if (productRepresentation != null) {
				if (productRepresentation instanceof IfcProductDefinitionShape) {
					IfcProductDefinitionShape productDefinitionShape = (IfcProductDefinitionShape)productRepresentation;
					for (IfcRepresentation representation : productDefinitionShape.getRepresentations()) {
						processRepresentation(product, representation);
					}
					for (IfcShapeAspect shapeAspect : productDefinitionShape.getHasShapeAspects()) {
						for (IfcShapeModel shapeModel : shapeAspect.getShapeRepresentations()) {
							processRepresentation(product, shapeModel);
						}
					}
				}
				for (IfcRepresentation representation : productRepresentation.getRepresentations()) {
					processRepresentation(product, representation);
				}
			}
		}
		for (IfcStyledItem styledItem : styledItemToProduct.keySet()) {
			System.out.println(styledItem);
			System.out.println();
			for (IfcProduct product : styledItemToProduct.get(styledItem)) {
				System.out.println("\t" + product);
			}
			System.out.println();
		}
	}
	
	private void link(IfcProduct product, IfcStyledItem styledItem) {
		if (!styledItemToProduct.containsKey(styledItem)) {
			styledItemToProduct.put(styledItem, new HashSet<IfcProduct>());
		}
		if (!productToStyledItem.containsKey(product)) {
			productToStyledItem.put(product, new HashSet<IfcStyledItem>());
		}
		styledItemToProduct.get(styledItem).add(product);
		productToStyledItem.get(product).add(styledItem);
	}

	private void processRepresentation(IfcProduct product, IfcRepresentation representation) {
		if (representation instanceof IfcPresentationLayerAssignment) {
			IfcPresentationLayerAssignment presentationLayerAssignment = (IfcPresentationLayerAssignment)representation;
			for (IfcLayeredItem layeredItem : presentationLayerAssignment.getAssignedItems()) {
				if (layeredItem instanceof IfcRepresentation) {
					processRepresentation(product, (IfcRepresentation) layeredItem);
				} else if (layeredItem instanceof IfcRepresentationItem) {
					processRepresentationItem(product, representation, (IfcRepresentationItem) layeredItem);
				}
			}
		} else if (representation instanceof IfcStyleModel) {
			
		} else if (representation instanceof IfcShapeModel) {
			
		} else if (representation instanceof IfcTopologyRepresentation) {
		}
		for (IfcRepresentationMap representationMap : representation.getRepresentationMap()) {
			for (IfcMappedItem mappedItem : representationMap.getMapUsage()) {
				if (mappedItem instanceof IfcRepresentationItem) {
					processRepresentationItem(product, representation, mappedItem);
				}
			}
		}
		for (IfcRepresentationItem representationItem : representation.getItems()) {
			processRepresentationItem(product, representation, representationItem);
		}
	}

	private void processRepresentationItem(IfcProduct product, IfcRepresentation representation, IfcRepresentationItem representationItem) {
		if (representation instanceof IfcStyledItem) {
			link(product, (IfcStyledItem) representation);
		} else {
			
		}
		for (IfcStyledItem styledItem : representationItem.getStyledByItem()) {
			link(product, styledItem);
		}
	}
	
	public void setColor(IfcProduct product, double[] color, float transparency) throws IfcModelInterfaceException {
		if (!productToStyledItem.containsKey(product) || productToStyledItem.get(product).isEmpty()) {
			// There is no style, let's construct a path to a new one
			System.out.println("No style for " + product + " " + product.getGlobalId());
			IfcProductRepresentation productRepresentation = product.getRepresentation();
			if (product.getRepresentation() == null) {
				productRepresentation = model.create(IfcProductRepresentation.class);
				product.setRepresentation(productRepresentation);
			}
			IfcRepresentation representation = null;
			if (productRepresentation.getRepresentations().isEmpty()) {
				representation = model.create(IfcRepresentation.class);
				productRepresentation.getRepresentations().add(representation);
			} else {
				representation = productRepresentation.getRepresentations().get(0);
			}
			IfcRepresentationItem representationItem = null;
			if (representation.getItems().isEmpty()) {
				representationItem = model.create(IfcRepresentationItem.class);
				representation.getItems().add(representationItem);
			} else {
				representationItem = representation.getItems().get(0);
			}
			IfcStyledItem styledItem = model.create(IfcStyledItem.class);
			representationItem.getStyledByItem().clear();
			representationItem.getStyledByItem().add(styledItem);
			createStyle(color, transparency, styledItem);
		} else if (productToStyledItem.get(product).size() == 1) {
			// There is one style, we can work with that
			IfcStyledItem styledItem = productToStyledItem.get(product).iterator().next();
			Set<IfcProduct> products = styledItemToProduct.get(styledItem);
			if (products.isEmpty()) {
				// That's weird, inconsistent with other map
			} else if (products.size() == 1) {
				// That's probably us, we can alter the Style safely
				createStyle(color, transparency, styledItem);
			} else {
				// Multiple objects are using this style, we have to do some magic
			}
		} else {
			// There are multiple styles, that's a bit much...
			System.out.println(productToStyledItem.get(product).size() + " styles for " + product);
		}
	}

	private void createStyle(double[] color, float transparency, IfcStyledItem styledItem) throws IfcModelInterfaceException {
		IfcPresentationStyleAssignment presentationStyleAssignment = null;
		if (styledItem.getStyles().isEmpty()) {
			presentationStyleAssignment = model.create(IfcPresentationStyleAssignment.class);
			styledItem.getStyles().add(presentationStyleAssignment);
		} else {
			presentationStyleAssignment = styledItem.getStyles().get(0);
		}
		IfcSurfaceStyle surfaceStyle = null;
		if (presentationStyleAssignment.getStyles().isEmpty()) {
			surfaceStyle = model.create(IfcSurfaceStyle.class);
			presentationStyleAssignment.getStyles().add(surfaceStyle);
		} else {
			if (presentationStyleAssignment.getStyles().get(0) instanceof IfcSurfaceStyle) {
				surfaceStyle = (IfcSurfaceStyle) presentationStyleAssignment.getStyles().get(0);
			} else {
				surfaceStyle = model.create(IfcSurfaceStyle.class);
				presentationStyleAssignment.getStyles().set(0, surfaceStyle);
			}
		}
		IfcSurfaceStyleRendering surfaceStyleRendering = null;
		if (surfaceStyle.getStyles().isEmpty()) {
			surfaceStyleRendering = model.create(IfcSurfaceStyleRendering.class);
			surfaceStyle.getStyles().add(surfaceStyleRendering);
		} else {
			if (surfaceStyle.getStyles().get(0) instanceof IfcSurfaceStyleRendering) {
				surfaceStyleRendering = (IfcSurfaceStyleRendering) surfaceStyle.getStyles().get(0);
			} else {
				surfaceStyleRendering = model.create(IfcSurfaceStyleRendering.class);
				surfaceStyle.getStyles().set(0, surfaceStyleRendering);
			}
		}
		IfcColourRgb colourRgb = model.create(IfcColourRgb.class);
		colourRgb.setRed(color[0]);
		colourRgb.setGreen(color[1]);
		colourRgb.setBlue(color[2]);
		surfaceStyleRendering.setDiffuseColour(colourRgb);
		surfaceStyleRendering.setReflectionColour(colourRgb);
		surfaceStyleRendering.setSpecularColour(colourRgb);
		surfaceStyleRendering.setSurfaceColour(colourRgb);
		surfaceStyleRendering.setTransmissionColour(colourRgb);
		surfaceStyleRendering.setTransparency(transparency);
	}
	
//	public void setColor(IfcProduct product, double[] color, float transparency) throws IfcModelInterfaceException {
//		IfcProductRepresentation representation = product.getRepresentation();
//		if (representation != null) {
//			EList<IfcRepresentation> representations = representation.getRepresentations();
//			for (IfcRepresentation ifcRepresentation : representations) {
//				EList<IfcRepresentationItem> representationItems = ifcRepresentation.getItems();
//				for (IfcRepresentationItem ifcRepresentationItem : representationItems) {
//					EList<IfcStyledItem> styledByItems = ifcRepresentationItem.getStyledByItem();
//					if (styledByItems.isEmpty()) {
//						createStyledByItems(model, ifcRepresentationItem, ifcRepresentation.getRepresentationIdentifier(), color, transparency);
//					} else {
//						for (IfcStyledItem ifcStyledItem : styledByItems) {
//							EList<IfcPresentationStyleAssignment> styledItemStyles = ifcStyledItem.getStyles();
//							if (styledItemStyles.isEmpty()) {
//								createStyledItemStyles(model, ifcRepresentation.getRepresentationIdentifier(), ifcStyledItem, color, transparency);
//							} else {
//								for (IfcPresentationStyleAssignment ifcPresentationStyleAssignment : styledItemStyles) {
//									EList<IfcPresentationStyleSelect> presentationStyleAssignmentStyles = ifcPresentationStyleAssignment.getStyles();
//									if (presentationStyleAssignmentStyles.isEmpty()) {
//										createPresentationStyleAssignmentStyles(model, ifcRepresentation.getRepresentationIdentifier(), ifcPresentationStyleAssignment,
//												color, transparency);
//									} else {
//										for (IfcPresentationStyleSelect ifcPresentationStyleSelect : presentationStyleAssignmentStyles) {
//											if (ifcPresentationStyleSelect instanceof IfcSurfaceStyle) {
//												IfcSurfaceStyle ifcSurfaceStyle = (IfcSurfaceStyle) ifcPresentationStyleSelect;
//												EList<IfcSurfaceStyleElementSelect> surfaceStyleStyles = ifcSurfaceStyle.getStyles();
//												if (surfaceStyleStyles.isEmpty()) {
//													createSurfaceStyleStyles(model, ifcRepresentation.getRepresentationIdentifier(), ifcSurfaceStyle, color, transparency);
//												} else {
//													boolean renderingFound = false;
//													for (IfcSurfaceStyleElementSelect ifcSurfaceStyleElementSelect : surfaceStyleStyles) {
//														if (ifcSurfaceStyleElementSelect instanceof IfcSurfaceStyleRendering) {
//															renderingFound = true;
//															IfcSurfaceStyleRendering ifcSurfaceStyleRendering = (IfcSurfaceStyleRendering) ifcSurfaceStyleElementSelect;
//															if (color != null) {
//																IfcColourRgb colourRgb = createColor(color);
//																ifcSurfaceStyleRendering.setDiffuseColour(colourRgb);
//																ifcSurfaceStyleRendering.setReflectionColour(colourRgb);
//																ifcSurfaceStyleRendering.setSpecularColour(colourRgb);
//																ifcSurfaceStyleRendering.setSurfaceColour(colourRgb);
//																ifcSurfaceStyleRendering.setTransmissionColour(colourRgb);
//															}
//															ifcSurfaceStyleRendering.setTransparency(transparency);
//														}
//													}
//													if (!renderingFound) {
//														createSurfaceStyleStyles(model, ifcRepresentation.getRepresentationIdentifier(), ifcSurfaceStyle, color, transparency);
//													}
//												}
//											} else if (ifcPresentationStyleSelect instanceof IfcTextStyle) {
//												IfcTextStyle ifcTextStyle = (IfcTextStyle) ifcPresentationStyleSelect;
//												IfcCharacterStyleSelect textCharacterAppearance = ifcTextStyle.getTextCharacterAppearance();
//												if (textCharacterAppearance instanceof IfcTextStyleForDefinedFont) {
//													// IfcTextStyleForDefinedFont
//													// is the only subclass of
//													// IfcCharacterStyleSelect
//													IfcTextStyleForDefinedFont ifcTextStyleForDefinedFont = (IfcTextStyleForDefinedFont) textCharacterAppearance;
//													IfcColourRgb colourRgb = createColor(color);
//													ifcTextStyleForDefinedFont.setColour(colourRgb);
//												}
//											} else if (ifcPresentationStyleSelect instanceof IfcCurveStyle) {
//												IfcCurveStyle ifcCurveStyle = (IfcCurveStyle) ifcPresentationStyleSelect;
//												IfcColourRgb colourRgb = createColor(color);
//												ifcCurveStyle.setCurveColour(colourRgb);
//											} else if (ifcPresentationStyleSelect instanceof IfcFillAreaStyle) {
//												IfcFillAreaStyle ifcFillAreaStyle = (IfcFillAreaStyle) ifcPresentationStyleSelect;
//												ifcFillAreaStyle.getFillStyles().clear();
//												IfcColourRgb colourRgb = createColor(color);
//												ifcFillAreaStyle.getFillStyles().add(colourRgb);
//											} else if (ifcPresentationStyleSelect instanceof IfcSymbolStyle) {
//												IfcSymbolStyle ifcSymbolStyle = (IfcSymbolStyle) ifcPresentationStyleSelect;
//												IfcColourRgb colourRgb = createColor(color);
//												ifcSymbolStyle.setStyleOfSymbol(colourRgb);
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//	}

//	private IfcColourRgb createColor(double[] color) throws IfcModelInterfaceException {
//		IfcColourRgb colourRgb = model.create(IfcColourRgb.class);
//		colourRgb.setRed(color[0]);
//		colourRgb.setGreen(color[1]);
//		colourRgb.setBlue(color[2]);
//		return colourRgb;
//	}
//	
//	private void createSurfaceStyleStyles(IfcModelInterface model, String representationIdentifier, IfcSurfaceStyle ifcSurfaceStyle, double[] color, float transparency) throws IfcModelInterfaceException {
//		IfcSurfaceStyleRendering ifcSurfaceStyleRendering = model.create(IfcSurfaceStyleRendering.class);
//		ifcSurfaceStyle.getStyles().add(ifcSurfaceStyleRendering);
//		if (color != null) {
//			IfcColourRgb colourRgb = model.create(IfcColourRgb.class);
//			colourRgb.setRed(color[0]);
//			colourRgb.setGreen(color[1]);
//			colourRgb.setBlue(color[2]);
//			ifcSurfaceStyleRendering.setDiffuseColour(colourRgb);
//			ifcSurfaceStyleRendering.setReflectionColour(colourRgb);
//			ifcSurfaceStyleRendering.setSpecularColour(colourRgb);
//			ifcSurfaceStyleRendering.setSurfaceColour(colourRgb);
//			ifcSurfaceStyleRendering.setTransmissionColour(colourRgb);
//		}
//		ifcSurfaceStyleRendering.setTransparency(transparency);
//	}
	
//	private void createPresentationStyleAssignmentStyles(IfcModelInterface model, String representationIdentifier,
//			IfcPresentationStyleAssignment ifcPresentationStyleAssignment, double[] color, float transparency) throws IfcModelInterfaceException {
//		if (representationIdentifier.equals("Body")) {
//			IfcSurfaceStyle ifcPresentationStyleSelect = model.create(IfcSurfaceStyle.class);
//			ifcPresentationStyleAssignment.getStyles().add(ifcPresentationStyleSelect);
//			createSurfaceStyleStyles(model, representationIdentifier, ifcPresentationStyleSelect, color, transparency);
//		} else {
//			// Unimplemented
//		}
//	}

//	private void createStyledByItems(IfcModelInterface model, IfcRepresentationItem ifcRepresentationItem, String representationIdentifier,
//			double[] color, float transparency) throws IfcModelInterfaceException {
//		IfcStyledItem ifcStyledItem = model.create(IfcStyledItem.class);
//		ifcRepresentationItem.getStyledByItem().add(ifcStyledItem);
//		createStyledItemStyles(model, representationIdentifier, ifcStyledItem, color, transparency);
//	}

//	private void createStyledItemStyles(IfcModelInterface model, String representationIdentifier, IfcStyledItem ifcStyledItem, double[] color, float transparency) throws IfcModelInterfaceException {
//		IfcPresentationStyleAssignment ifcPresentationStyleAssignment = model.create(IfcPresentationStyleAssignment.class);
//		ifcStyledItem.getStyles().add(ifcPresentationStyleAssignment);
//		createPresentationStyleAssignmentStyles(model, representationIdentifier, ifcPresentationStyleAssignment, color, transparency);
//	}

	public void makeTransparent(IfcProduct ifcProduct) throws IfcModelInterfaceException {
		setColor(ifcProduct, null, TRANSPARENCY);
	}
}