package org.bimserver.database.actions;

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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.ServerIfcModel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.emf.IdEObject;
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
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareItem;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.ObjectAdded;
import org.bimserver.models.store.ObjectModified;
import org.bimserver.models.store.ObjectRemoved;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.modelcompare.ModelCompareException;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.modelmerger.ModelMerger;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.common.util.EList;

public class DownloadCompareDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private long roid1;
	private long roid2;
	private int progress;
	private final CompareType compareType;
	private final long mcid;

	public DownloadCompareDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, long mcid,
			CompareType compareType, Authorization authorization, ObjectIDM objectIDM) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.mcid = mcid;
		Iterator<Long> iterator = roids.iterator();
		this.roid1 = iterator.next();
		this.roid2 = iterator.next();
		this.compareType = compareType;
	}
	
	public org.bimserver.plugins.modelcompare.ModelCompare getModelCompare() throws ModelCompareException, BimserverDatabaseException {
		ModelComparePluginConfiguration modelCompareObject = getDatabaseSession().get(StorePackage.eINSTANCE.getModelComparePluginConfiguration(), mcid, Query.getDefault());
		if (modelCompareObject != null) {
			ModelComparePlugin modelComparePlugin = getBimServer().getPluginManager().getModelComparePlugin(modelCompareObject.getPluginDescriptor().getPluginClassName(), true);
			if (modelComparePlugin != null) {
				org.bimserver.plugins.modelcompare.ModelCompare modelCompare = modelComparePlugin.createModelCompare(new PluginConfiguration(modelCompareObject.getSettings()));
				return modelCompare;
			} else {
				throw new ModelCompareException("No Model Compare found " + modelCompareObject.getPluginDescriptor().getPluginClassName());
			}
		} else {
			throw new ModelCompareException("No configured Model Compare found");
		}
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		try {
			Revision revision1 = getRevisionByRoid(roid1);
			Revision revision2 = getRevisionByRoid(roid2);
			Project project = revision1.getProject();
			CompareResult compareResults = null;// bimServer.getCompareCache().getCompareResults(roid1,
												// roid2, compareType,
												// compareIdentifier);
			IfcModelInterface model1 = new DownloadDatabaseAction(getBimServer(), getDatabaseSession(), getAccessMethod(), roid1, -1, -1, getAuthorization(), null).execute();
			IfcModelInterface model2 = new DownloadDatabaseAction(getBimServer(), getDatabaseSession(), getAccessMethod(), roid2, -1, -1, getAuthorization(), null).execute();

			try {
				compareResults = getModelCompare().compare(model1, model2, compareType);
			} catch (ModelCompareException e) {
				throw new UserException(e);
			}
//			bimServer.getCompareCache().storeResults(roid1, roid2, compareType, compareIdentifier, compareResults);

			ModelMerger merger = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid());
			IfcModelInterface mergedModel = new ServerIfcModel(null, null, getDatabaseSession()); // TODO
			mergedModel = merger.merge(project, new IfcModelSet(model1, model2), new ModelHelper(getBimServer().getMetaDataManager(), mergedModel));
			mergedModel.getModelMetaData().setName(project.getName() + "." + revision1.getId() + "." + revision2.getId());

			Set<Long> added = new HashSet<Long>();
			Set<Long> modified = new HashSet<Long>();
			Set<Long> deleted = new HashSet<Long>();

			for (CompareContainer compareContainer : compareResults.getItems()) {
				for (CompareItem compareItem : compareContainer.getItems()) {
					DataObject dataObject = compareItem.getDataObject();
					if (compareItem instanceof ObjectAdded) {
						added.add(dataObject.getOid());
					} else if (compareItem instanceof ObjectModified) {
						modified.add(dataObject.getOid());
					} else if (compareItem instanceof ObjectRemoved) {
						deleted.add(dataObject.getOid());
					}
				}
			}

			IfcColourRgb red = mergedModel.create(IfcColourRgb.class);
			red.setName("red");
			red.setRed(0.5);
			red.setGreen(0.0);
			red.setBlue(0.0);

			IfcColourRgb green = mergedModel.create(IfcColourRgb.class);
			green.setName("green");
			green.setRed(0);
			green.setGreen(0.5);
			green.setBlue(0);

			IfcColourRgb blue = mergedModel.create(IfcColourRgb.class);
			blue.setName("blue");
			blue.setRed(0);
			blue.setGreen(0);
			blue.setBlue(0.5);

			for (IdEObject idEObject : mergedModel.getValues()) {
				if (idEObject instanceof IfcProduct) {
					IfcProduct product = (IfcProduct) idEObject;
					IfcColourRgb color = null;
					if (added.contains(product.getOid())) {
						color = green;
					} else if (deleted.contains(product.getOid())) {
						color = red;
					} else if (modified.contains(product.getOid())) {
						color = blue;
					}
					setColor(mergedModel, product, color);
				}
			}
			mergedModel.fixOidCounter();
			return mergedModel;
		} catch (IfcModelInterfaceException e) {
			throw new UserException(e);
		} catch (MergeException e) {
			throw new UserException(e);
		}
	}

	private void setColor(IfcModelInterface model, IfcProduct product, IfcColourRgb color) throws IfcModelInterfaceException {
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
																ifcSurfaceStyleRendering.setTransparency(0.5);
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
			ifcSurfaceStyleRendering.setTransparency(0.5);
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

	public int getProgress() {
		return progress;
	}
}