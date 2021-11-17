package org.bimserver.database.actions;

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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
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
import org.bimserver.plugins.modelcompare.ModelCompareException;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.modelmerger.ModelMerger;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class DownloadCompareDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private long roid1;
	private long roid2;
	private int progress;
	private final CompareType compareType;
	private final long mcid;

	public DownloadCompareDatabaseAction(BimServer bimServer, DatabaseSession readOnlyDatabaseSession, AccessMethod accessMethod, Set<Long> roids, long mcid, CompareType compareType,
			Authorization authorization) {
		super(bimServer, readOnlyDatabaseSession, accessMethod, authorization);
		this.mcid = mcid;
		Iterator<Long> iterator = roids.iterator();
		this.roid1 = iterator.next();
		this.roid2 = iterator.next();
		this.compareType = compareType;
	}

	public org.bimserver.plugins.modelcompare.ModelCompare getModelCompare() throws ModelCompareException, BimserverDatabaseException {
		Revision revision1 = getDatabaseSession().get(roid1, OldQuery.getDefault());
		Revision revision2 = getDatabaseSession().get(roid2, OldQuery.getDefault());
		PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision1.getProject().getSchema());
		if (revision1.getProject().getSchema().equals(revision2.getProject().getSchema())) {
			ModelComparePluginConfiguration modelCompareObject = getDatabaseSession().get(StorePackage.eINSTANCE.getModelComparePluginConfiguration(), mcid, OldQuery.getDefault());
			if (modelCompareObject != null) {
				ModelComparePlugin modelComparePlugin = getBimServer().getPluginManager().getModelComparePlugin(modelCompareObject.getPluginDescriptor().getPluginClassName(), true);
				if (modelComparePlugin != null) {
					org.bimserver.plugins.modelcompare.ModelCompare modelCompare = modelComparePlugin.createModelCompare(getBimServer().getPluginSettingsCache().getPluginSettings(modelCompareObject.getOid()), packageMetaData);
					return modelCompare;
				} else {
					throw new ModelCompareException("No Model Compare found " + modelCompareObject.getPluginDescriptor().getPluginClassName());
				}
			} else {
				throw new ModelCompareException("No configured Model Compare found");
			}
		} else {
			throw new ModelCompareException("Schemas not the same");
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
			IfcModelInterface model1 = new DownloadDatabaseAction(getBimServer(), getDatabaseSession(), getAccessMethod(), roid1, -1, -1, getAuthorization()).execute();
			ModelMerger merger = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid());
			PackageMetaData packageMetaData = model1.getPackageMetaData();
			IfcModelInterface mergedModel = getDatabaseSession().createServerModel(packageMetaData, null);
			try(DatabaseSession secondSession = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)){
				IfcModelInterface model2 = new DownloadDatabaseAction(getBimServer(), secondSession, getAccessMethod(), roid2, -1, -1, getAuthorization()).execute();
				try {
					compareResults = getModelCompare().compare(model1, model2, compareType);
				} catch (ModelCompareException e) {
					throw new UserException(e);
				}
				// bimServer.getCompareCache().storeResults(roid1, roid2,
				// compareType, compareIdentifier, compareResults);

				mergedModel = merger.merge(project, new IfcModelSet(model1, model2), new ModelHelper(getBimServer().getMetaDataManager(), mergedModel));
			}
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

			EClass ifcColourRgbClass = packageMetaData.getEClass("IfcColourRgb");
			EStructuralFeature nameFeature = ifcColourRgbClass.getEStructuralFeature("Name");
			EStructuralFeature redFeature = ifcColourRgbClass.getEStructuralFeature("Red");
			EStructuralFeature greenFeature = ifcColourRgbClass.getEStructuralFeature("Green");
			EStructuralFeature blueFeature = ifcColourRgbClass.getEStructuralFeature("Blue");

			IdEObject red = mergedModel.createAndAdd(ifcColourRgbClass);
			red.eSet(nameFeature, "red");
			red.eSet(redFeature, 0.5D);
			red.eSet(greenFeature, 0.0D);
			red.eSet(blueFeature, 0.0D);

			IdEObject green = mergedModel.createAndAdd(ifcColourRgbClass);
			green.eSet(nameFeature, "green");
			green.eSet(redFeature, 0D);
			green.eSet(greenFeature, 0.5D);
			green.eSet(blueFeature, 0D);

			IdEObject blue = mergedModel.createAndAdd(ifcColourRgbClass);
			blue.eSet(nameFeature, "blue");
			blue.eSet(redFeature, 0D);
			blue.eSet(greenFeature, 0D);
			blue.eSet(blueFeature, 0.5D);

			for (IdEObject product : mergedModel.getAllWithSubTypes(packageMetaData.getEClass("IfcProduct"))) {
				IdEObject color = null;
				if (added.contains(product.getOid())) {
					color = green;
				} else if (deleted.contains(product.getOid())) {
					color = red;
				} else if (modified.contains(product.getOid())) {
					color = blue;
				}
				if (color != null) {
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

	@SuppressWarnings("unchecked")
	private void setColor(IfcModelInterface model, IdEObject product, IdEObject color) throws IfcModelInterfaceException {
		EStructuralFeature representationFeature = product.eClass().getEStructuralFeature("Representation");
		IdEObject representation = (IdEObject) product.eGet(representationFeature);
		if (representation != null) {
			EStructuralFeature representationsFeature = representation.eClass().getEStructuralFeature("Representations");
			List<IdEObject> representations = (EList<IdEObject>) representation.eGet(representationsFeature);
			for (IdEObject ifcRepresentation : representations) {
				EStructuralFeature itemsFeature = ifcRepresentation.eClass().getEStructuralFeature("Items");
				List<IdEObject> representationItems = (EList<IdEObject>) ifcRepresentation.eGet(itemsFeature);
				EStructuralFeature representationIdentifierFeature = ifcRepresentation.eClass().getEStructuralFeature("RepresentationIdentifier");
				String identifier = (String) ifcRepresentation.eGet(representationIdentifierFeature);
				for (IdEObject ifcRepresentationItem : representationItems) {
					EStructuralFeature styledByItemFeature = ifcRepresentationItem.eClass().getEStructuralFeature("StyledByItem");
					List<IdEObject> styledByItems = (EList<IdEObject>) ifcRepresentationItem.eGet(styledByItemFeature);
					if (styledByItems.isEmpty()) {
						createStyledByItems(model, ifcRepresentationItem, identifier, color);
					} else {
						for (IdEObject ifcStyledItem : styledByItems) {
							EStructuralFeature stylesFeature = ifcStyledItem.eClass().getEStructuralFeature("Styles");
							List<IdEObject> styledItemStyles = (List<IdEObject>) ifcStyledItem.eGet(stylesFeature);
							if (styledItemStyles.isEmpty()) {
								createStyledItemStyles(model, identifier, ifcStyledItem, color);
							} else {
								for (IdEObject ifcPresentationStyleAssignment : styledItemStyles) {
									EStructuralFeature stylesFeature2 = ifcPresentationStyleAssignment.eClass().getEStructuralFeature("Styles");
									List<IdEObject> presentationStyleAssignmentStyles = (List<IdEObject>) ifcPresentationStyleAssignment.eGet(stylesFeature2);
									if (presentationStyleAssignmentStyles.isEmpty()) {
										createPresentationStyleAssignmentStyles(model, identifier, ifcPresentationStyleAssignment, color);
									} else {
										for (IdEObject ifcPresentationStyleSelect : presentationStyleAssignmentStyles) {
											if (ifcPresentationStyleSelect.eClass().getName().equals("IfcSurfaceStyle")) {
												EStructuralFeature stylesFeature3 = ifcPresentationStyleSelect.eClass().getEStructuralFeature("Styles");
												List<IdEObject> surfaceStyleStyles = (List<IdEObject>) ifcPresentationStyleSelect.eGet(stylesFeature3);
												if (surfaceStyleStyles.isEmpty()) {
													createSurfaceStyleStyles(model, identifier, ifcPresentationStyleSelect, color);
												} else {
													boolean renderingFound = false;
													for (IdEObject ifcSurfaceStyleElementSelect : surfaceStyleStyles) {
														if (ifcSurfaceStyleElementSelect.eClass().getName().equals("IfcSurfaceStyleRendering")) {
															renderingFound = true;
															IdEObject ifcSurfaceStyleRendering = (IdEObject) ifcSurfaceStyleElementSelect;
															setColour(color, ifcSurfaceStyleRendering);
														}
													}
													if (!renderingFound) {
														createSurfaceStyleStyles(model, identifier, ifcPresentationStyleSelect, color);
													}
												}
											} else if (ifcPresentationStyleSelect.eClass().getName().equals("IfcTextStyle")) {
												EStructuralFeature textCharacterAppearanceFeature = ifcPresentationStyleSelect.eClass().getEStructuralFeature("TextCharacterAppearance");
												IdEObject textCharacterAppearance = (IdEObject) ifcPresentationStyleSelect.eGet(textCharacterAppearanceFeature);
												if (textCharacterAppearance.eClass().getName().equals("IfcTextStyleForDefinedFont")) {
													// IfcTextStyleForDefinedFont is the only subclass of IfcCharacterStyleSelect
													textCharacterAppearance.eSet(textCharacterAppearance.eClass().getEStructuralFeature("Colour"), color);
												}
											} else if (ifcPresentationStyleSelect.eClass().getName().equals("IfcCurveStyle")) {
												ifcPresentationStyleSelect.eSet(ifcPresentationStyleSelect.eClass().getEStructuralFeature("CurveColour"), color);
											} else if (ifcPresentationStyleSelect.eClass().getName().equals("IfcFillAreaStyle")) {
												EStructuralFeature fillStylesFeature = ifcPresentationStyleSelect.eClass().getEStructuralFeature("FillStyles");
												List<IdEObject> list = (List<IdEObject>) ifcPresentationStyleSelect.eGet(fillStylesFeature);
												list.clear();
												list.add(color);
											} else if (ifcPresentationStyleSelect.eClass().getName().equals("IfcSymbolStyle")) {
												ifcPresentationStyleSelect.eSet(ifcPresentationStyleSelect.eClass().getEStructuralFeature("StyleOfSymbol"), color);
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

	@SuppressWarnings("unchecked")
	private void createSurfaceStyleStyles(IfcModelInterface model, String representationIdentifier, IdEObject ifcSurfaceStyle, IdEObject color) throws IfcModelInterfaceException {
		EClass ifcSurfaceStyleRenderingClass = model.getPackageMetaData().getEClass("IfcSurfaceStyleRendering");
		IdEObject ifcSurfaceStyleRendering = model.create(ifcSurfaceStyleRenderingClass);
		EStructuralFeature stylesFeature = ifcSurfaceStyle.eClass().getEStructuralFeature("Styles");
		((List<IdEObject>)(ifcSurfaceStyle.eGet(stylesFeature))).add(ifcSurfaceStyleRendering);
		setColour(color, ifcSurfaceStyleRendering);
	}

	private void setColour(IdEObject color, IdEObject ifcSurfaceStyleRendering) {
		if (color != null) {
			EStructuralFeature diffuseColourFeature = ifcSurfaceStyleRendering.eClass().getEStructuralFeature("DiffuseColour");
			EStructuralFeature reflectionColourFeature = ifcSurfaceStyleRendering.eClass().getEStructuralFeature("ReflectionColour");
			EStructuralFeature specularColourFeature = ifcSurfaceStyleRendering.eClass().getEStructuralFeature("SpecularColour");
			EStructuralFeature surfaceColourFeature = ifcSurfaceStyleRendering.eClass().getEStructuralFeature("SurfaceColour");
			EStructuralFeature transmissionColourFeature = ifcSurfaceStyleRendering.eClass().getEStructuralFeature("TransmissionColour");

			ifcSurfaceStyleRendering.eSet(diffuseColourFeature, color);
			ifcSurfaceStyleRendering.eSet(reflectionColourFeature, color);
			ifcSurfaceStyleRendering.eSet(specularColourFeature, color);
			ifcSurfaceStyleRendering.eSet(surfaceColourFeature, color);
			ifcSurfaceStyleRendering.eSet(transmissionColourFeature, color);
		} else {
			EStructuralFeature transparancyFeature = ifcSurfaceStyleRendering.eClass().getEStructuralFeature("Transparency");
			ifcSurfaceStyleRendering.eSet(transparancyFeature, 0.5D);
		}
	}

	@SuppressWarnings("unchecked")
	private void createPresentationStyleAssignmentStyles(IfcModelInterface model, String representationIdentifier, IdEObject ifcPresentationStyleAssignment, IdEObject color)
			throws IfcModelInterfaceException {
		if (representationIdentifier.equals("Body")) {
			IdEObject ifcPresentationStyleSelect = model.create(model.getPackageMetaData().getEClass("IfcSurfaceStyle"));
			EStructuralFeature stylesFeature = ifcPresentationStyleAssignment.eClass().getEStructuralFeature("Styles");
			List<IdEObject> list = (List<IdEObject>) ifcPresentationStyleAssignment.eGet(stylesFeature);
			list.add(ifcPresentationStyleSelect);
			createSurfaceStyleStyles(model, representationIdentifier, ifcPresentationStyleSelect, color);
		} else {
			// Unimplemented
		}
	}

	@SuppressWarnings("unchecked")
	private void createStyledByItems(IfcModelInterface model, IdEObject ifcRepresentationItem, String representationIdentifier, IdEObject color) throws IfcModelInterfaceException {
		IdEObject ifcStyledItem = model.create(model.getPackageMetaData().getEClass("IfcStyledItem"));
		EStructuralFeature styledByItemFeature = ifcStyledItem.eClass().getEStructuralFeature("StyledByItem");
		List<IdEObject> list = (List<IdEObject>) ifcRepresentationItem.eGet(styledByItemFeature);
		list.add(ifcStyledItem);
		createStyledItemStyles(model, representationIdentifier, ifcStyledItem, color);
	}

	@SuppressWarnings("unchecked")
	private void createStyledItemStyles(IfcModelInterface model, String representationIdentifier, IdEObject ifcStyledItem, IdEObject color) throws IfcModelInterfaceException {
		IdEObject ifcPresentationStyleAssignment = model.create(model.getPackageMetaData().getEClass("IfcPresentationStyleAssignment"));
		EStructuralFeature stylesFeature = ifcStyledItem.eClass().getEStructuralFeature("Styles");
		List<IdEObject> list = (List<IdEObject>) ifcStyledItem.eGet(stylesFeature);
		list.add(ifcPresentationStyleAssignment);
		createPresentationStyleAssignmentStyles(model, representationIdentifier, ifcPresentationStyleAssignment, color);
	}

	public int getProgress() {
		return progress;
	}
}