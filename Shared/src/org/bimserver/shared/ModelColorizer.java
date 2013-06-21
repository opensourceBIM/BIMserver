package org.bimserver.shared;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcCharacterStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcCurveStyle;
import org.bimserver.models.ifc2x3tc1.IfcFillAreaStyle;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.models.ifc2x3tc1.IfcSymbolStyle;
import org.bimserver.models.ifc2x3tc1.IfcTextStyle;
import org.bimserver.models.ifc2x3tc1.IfcTextStyleForDefinedFont;
import org.eclipse.emf.common.util.EList;

public class ModelColorizer {
	private IfcModelInterface model;

	public ModelColorizer(IfcModelInterface model) {
		this.model = model;
	}
	
	public void setColor(IfcProduct product, IfcColourRgb color) throws IfcModelInterfaceException {
		IfcProductRepresentation representation = product.getRepresentation();
		if (representation != null) {
			EList<IfcRepresentation> representations = representation.getRepresentations();
			for (IfcRepresentation ifcRepresentation : representations) {
				EList<IfcRepresentationItem> representationItems = ifcRepresentation.getItems();
				for (IfcRepresentationItem ifcRepresentationItem : representationItems) {
					EList<IfcStyledItem> styledByItems = ifcRepresentationItem.getStyledByItem();
					if (styledByItems.isEmpty()) {
						createStyledByItems(model, ifcRepresentationItem, ifcRepresentation.getRepresentationIdentifier(), color);
					} else {
						for (IfcStyledItem ifcStyledItem : styledByItems) {
							EList<IfcPresentationStyleAssignment> styledItemStyles = ifcStyledItem.getStyles();
							if (styledItemStyles.isEmpty()) {
								createStyledItemStyles(model, ifcRepresentation.getRepresentationIdentifier(), ifcStyledItem, color);
							} else {
								for (IfcPresentationStyleAssignment ifcPresentationStyleAssignment : styledItemStyles) {
									EList<IfcPresentationStyleSelect> presentationStyleAssignmentStyles = ifcPresentationStyleAssignment.getStyles();
									if (presentationStyleAssignmentStyles.isEmpty()) {
										createPresentationStyleAssignmentStyles(model, ifcRepresentation.getRepresentationIdentifier(), ifcPresentationStyleAssignment,
												color);
									} else {
										for (IfcPresentationStyleSelect ifcPresentationStyleSelect : presentationStyleAssignmentStyles) {
											if (ifcPresentationStyleSelect instanceof IfcSurfaceStyle) {
												IfcSurfaceStyle ifcSurfaceStyle = (IfcSurfaceStyle) ifcPresentationStyleSelect;
												EList<IfcSurfaceStyleElementSelect> surfaceStyleStyles = ifcSurfaceStyle.getStyles();
												if (surfaceStyleStyles.isEmpty()) {
													createSurfaceStyleStyles(model, ifcRepresentation.getRepresentationIdentifier(), ifcSurfaceStyle, color);
												} else {
													boolean renderingFound = false;
													for (IfcSurfaceStyleElementSelect ifcSurfaceStyleElementSelect : surfaceStyleStyles) {
														if (ifcSurfaceStyleElementSelect instanceof IfcSurfaceStyleRendering) {
															renderingFound = true;
															IfcSurfaceStyleRendering ifcSurfaceStyleRendering = (IfcSurfaceStyleRendering) ifcSurfaceStyleElementSelect;
															if (color != null) {
																ifcSurfaceStyleRendering.setDiffuseColour(color);
																ifcSurfaceStyleRendering.setReflectionColour(color);
																ifcSurfaceStyleRendering.setSpecularColour(color);
																ifcSurfaceStyleRendering.setSurfaceColour(color);
																ifcSurfaceStyleRendering.setTransmissionColour(color);
															} else {
																ifcSurfaceStyleRendering.setTransparency(0.9);
															}
														}
													}
													if (!renderingFound) {
														createSurfaceStyleStyles(model, ifcRepresentation.getRepresentationIdentifier(), ifcSurfaceStyle, color);
													}
												}
											} else if (ifcPresentationStyleSelect instanceof IfcTextStyle) {
												IfcTextStyle ifcTextStyle = (IfcTextStyle) ifcPresentationStyleSelect;
												IfcCharacterStyleSelect textCharacterAppearance = ifcTextStyle.getTextCharacterAppearance();
												if (textCharacterAppearance instanceof IfcTextStyleForDefinedFont) {
													// IfcTextStyleForDefinedFont
													// is the only subclass of
													// IfcCharacterStyleSelect
													IfcTextStyleForDefinedFont ifcTextStyleForDefinedFont = (IfcTextStyleForDefinedFont) textCharacterAppearance;
													ifcTextStyleForDefinedFont.setColour(color);
												}
											} else if (ifcPresentationStyleSelect instanceof IfcCurveStyle) {
												IfcCurveStyle ifcCurveStyle = (IfcCurveStyle) ifcPresentationStyleSelect;
												ifcCurveStyle.setCurveColour(color);
											} else if (ifcPresentationStyleSelect instanceof IfcFillAreaStyle) {
												IfcFillAreaStyle ifcFillAreaStyle = (IfcFillAreaStyle) ifcPresentationStyleSelect;
												ifcFillAreaStyle.getFillStyles().clear();
												ifcFillAreaStyle.getFillStyles().add(color);
											} else if (ifcPresentationStyleSelect instanceof IfcSymbolStyle) {
												IfcSymbolStyle ifcSymbolStyle = (IfcSymbolStyle) ifcPresentationStyleSelect;
												ifcSymbolStyle.setStyleOfSymbol(color);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void createSurfaceStyleStyles(IfcModelInterface model, String representationIdentifier, IfcSurfaceStyle ifcSurfaceStyle, IfcColourRgb color) throws IfcModelInterfaceException {
		IfcSurfaceStyleRendering ifcSurfaceStyleRendering = model.create(IfcSurfaceStyleRendering.class);
		ifcSurfaceStyle.getStyles().add(ifcSurfaceStyleRendering);
		if (color != null) {
			ifcSurfaceStyleRendering.setDiffuseColour(color);
			ifcSurfaceStyleRendering.setReflectionColour(color);
			ifcSurfaceStyleRendering.setSpecularColour(color);
			ifcSurfaceStyleRendering.setSurfaceColour(color);
			ifcSurfaceStyleRendering.setTransmissionColour(color);
		} else {
			ifcSurfaceStyleRendering.setTransparency(0.9);
		}
	}
	
	private void createPresentationStyleAssignmentStyles(IfcModelInterface model, String representationIdentifier,
			IfcPresentationStyleAssignment ifcPresentationStyleAssignment, IfcColourRgb color) throws IfcModelInterfaceException {
		if (representationIdentifier.equals("Body")) {
			IfcSurfaceStyle ifcPresentationStyleSelect = model.create(IfcSurfaceStyle.class);
			ifcPresentationStyleAssignment.getStyles().add(ifcPresentationStyleSelect);
			createSurfaceStyleStyles(model, representationIdentifier, ifcPresentationStyleSelect, color);
		} else {
			// Unimplemented
		}
	}

	private void createStyledByItems(IfcModelInterface model, IfcRepresentationItem ifcRepresentationItem, String representationIdentifier,
			IfcColourRgb color) throws IfcModelInterfaceException {
		IfcStyledItem ifcStyledItem = model.create(IfcStyledItem.class);
		ifcRepresentationItem.getStyledByItem().add(ifcStyledItem);
		createStyledItemStyles(model, representationIdentifier, ifcStyledItem, color);
	}

	private void createStyledItemStyles(IfcModelInterface model, String representationIdentifier, IfcStyledItem ifcStyledItem, IfcColourRgb color) throws IfcModelInterfaceException {
		IfcPresentationStyleAssignment ifcPresentationStyleAssignment = model.create(IfcPresentationStyleAssignment.class);
		ifcStyledItem.getStyles().add(ifcPresentationStyleAssignment);
		createPresentationStyleAssignmentStyles(model, representationIdentifier, ifcPresentationStyleAssignment, color);
	}

	public void makeTransparent(IfcProduct ifcProduct) throws IfcModelInterfaceException {
		setColor(ifcProduct, null);
	}
}