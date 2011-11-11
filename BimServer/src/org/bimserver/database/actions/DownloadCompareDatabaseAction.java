package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.ifc.compare.Compare;
import org.bimserver.merging.Merger;
import org.bimserver.models.ifc2x3.Ifc2x3Factory;
import org.bimserver.models.ifc2x3.IfcColourRgb;
import org.bimserver.models.ifc2x3.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcProductRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentation;
import org.bimserver.models.ifc2x3.IfcRepresentationItem;
import org.bimserver.models.ifc2x3.IfcStyledItem;
import org.bimserver.models.ifc2x3.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleRendering;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareIdentifier;
import org.bimserver.models.store.CompareItem;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.MergeIdentifier;
import org.bimserver.models.store.ObjectAdded;
import org.bimserver.models.store.ObjectModified;
import org.bimserver.models.store.ObjectRemoved;
import org.bimserver.models.store.Project;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.exceptions.UserException;

public class DownloadCompareDatabaseAction extends BimDatabaseAction<IfcModelInterface> {

	private final long actingUoid;
	private long roid1;
	private long roid2;
	private int progress;
	private final BimServer bimServer;
	private final ObjectIDM objectIDM;
	private final CompareType compareType;
	private final CompareIdentifier compareIdentifier;

	public DownloadCompareDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Set<Long> roids, CompareIdentifier compareIdentifier, CompareType compareType, long actingUoid, ObjectIDM objectIDM) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		Iterator<Long> iterator = roids.iterator();
		this.roid1 = iterator.next();
		this.roid2 = iterator.next();
		this.compareType = compareType;
		this.compareIdentifier = compareIdentifier;
		this.actingUoid = actingUoid;
		this.objectIDM = objectIDM;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = getRevisionByRoid(roid1).getProject();
		Compare compare = new Compare(objectIDM);
		CompareResult compareResults = null;// bimServer.getCompareCache().getCompareResults(roid1, roid2, compareType, compareIdentifier);
		IfcModelInterface model1 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid1, actingUoid, null).execute();
		IfcModelInterface model2 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid2, actingUoid, null).execute();
		if (compareIdentifier == CompareIdentifier.GUID_ID) {
			compareResults = compare.compareOnGuids(model1, model2, compareType);
		} else if (compareIdentifier == CompareIdentifier.NAME_ID) {
			compareResults = compare.compareOnNames(model1, model2, compareType);
		}
		bimServer.getCompareCache().storeResults(roid1, roid2, compareType, compareIdentifier, compareResults);
		
		Merger merger = bimServer.getMergerFactory().createMerger(compareIdentifier == CompareIdentifier.GUID_ID ? MergeIdentifier.GUID : MergeIdentifier.NAME);
		IfcModelInterface mergedModel = merger.merge(project, new IfcModelSet(model1, model2), false);

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
		
		IfcColourRgb red = Ifc2x3Factory.eINSTANCE.createIfcColourRgb();
		red.setName("red");
		mergedModel.add(red);
		red.setRed(0.5);
		red.setGreen(0.0);
		red.setBlue(0.0);

		IfcColourRgb green = Ifc2x3Factory.eINSTANCE.createIfcColourRgb();
		green.setName("green");
		mergedModel.add(green);
		green.setRed(0);
		green.setGreen(0.5);
		green.setBlue(0);

		IfcColourRgb blue = Ifc2x3Factory.eINSTANCE.createIfcColourRgb();
		blue.setName("blue");
		mergedModel.add(blue);
		blue.setRed(0);
		blue.setGreen(0);
		blue.setBlue(0.5);
		
		for (IdEObject idEObject : mergedModel.getValues()) {
			if (idEObject instanceof IfcProduct) {
				System.out.println(idEObject.eClass().getName());
				IfcProduct product = (IfcProduct)idEObject;
				IfcColourRgb color = null;
				if (added.contains(product.getOid())) {
					color = green;
				} else if (deleted.contains(product.getOid())) {
					color = red;
				} else if (modified.contains(product.getOid())) {
					color = blue;
				}
				IfcProductRepresentation representation = product.getRepresentation();
				if (representation != null) {
					for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
						for (IfcRepresentationItem ifcRepresentationItem : ifcRepresentation.getItems()) {
							for (IfcStyledItem ifcStyledItem : ifcRepresentationItem.getStyledByItem()) {
								for (IfcPresentationStyleAssignment ifcPresentationStyleAssignment : ifcStyledItem.getStyles()) {
									for (IfcPresentationStyleSelect ifcPresentationStyleSelect : ifcPresentationStyleAssignment.getStyles()) {
										if (ifcPresentationStyleSelect instanceof IfcSurfaceStyle) {
											IfcSurfaceStyle ifcSurfaceStyle = (IfcSurfaceStyle)ifcPresentationStyleSelect;
											for (IfcSurfaceStyleElementSelect ifcSurfaceStyleElementSelect : ifcSurfaceStyle.getStyles()) {
												if (ifcSurfaceStyleElementSelect instanceof IfcSurfaceStyleRendering) {
													IfcSurfaceStyleRendering ifcSurfaceStyleRendering = (IfcSurfaceStyleRendering)ifcSurfaceStyleElementSelect;
													System.out.println("Changing appearance");
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
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return mergedModel;
	}

	public int getProgress() {
		return progress;
	}
}