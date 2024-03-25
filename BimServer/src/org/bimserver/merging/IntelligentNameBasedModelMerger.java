package org.bimserver.merging;

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

import com.sun.tools.ws.wsdl.document.Message;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc4.*;
import org.bimserver.shared.Guid;
import org.codehaus.plexus.util.StringUtils;

import java.text.MessageFormat;
import java.util.UUID;
import java.util.stream.Collectors;

public class IntelligentNameBasedModelMerger extends AbstractIntelligentModelMerger {

	@Override
	public String getIdentifier(IdEObject idEObject) {
		if (idEObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) idEObject;
			if (ifcRoot instanceof IfcRelationship) {
				if (ifcRoot instanceof IfcRelDefinesByType) {
					IfcRelDefinesByType rel = (IfcRelDefinesByType)ifcRoot;
					return MessageFormat.format("relType-{0}-{1}", rel.getRelatingType().getName(), rel.getRelatingType().eClass().getName());
				}
				else
					return null;
			} else if (ifcRoot instanceof IfcQuantitySet || ifcRoot instanceof IfcPropertySet)
				return ifcRoot.getGlobalId();
			if (StringUtils.isEmpty(ifcRoot.getName()))
				return ifcRoot.getGlobalId();
			else
				return MessageFormat.format("{0}-{1}", ifcRoot.getName(), ifcRoot.eClass().getName());
		} else if (idEObject instanceof IfcRepresentationContext) {
			IfcRepresentationContext context = (IfcRepresentationContext)idEObject;
			return MessageFormat.format("IfcRepresentationContext-{0}-{1}", context.getContextIdentifier(), context.getContextType());
		} else if (idEObject instanceof IfcGridAxis) {
			IfcGridAxis gridAxis = (IfcGridAxis)idEObject;
			return MessageFormat.format("IfcGridAxis-{0}-{1}-{2}-{3}", gridAxis.getAxisTag(),
					gridAxis.getPartOfU().stream().map(ga -> ga.getName()).collect(Collectors.joining(",")),
					gridAxis.getPartOfV().stream().map(ga -> ga.getName()).collect(Collectors.joining(",")),
					gridAxis.getPartOfW().stream().map(ga -> ga.getName()).collect(Collectors.joining(",")));
		} else if (idEObject instanceof IfcLibraryInformation) {
			IfcLibraryInformation libInfo = (IfcLibraryInformation)idEObject;
			return MessageFormat.format("IfcLibraryInformation-{0}-{1}", libInfo.getName());
		} else if (idEObject instanceof IfcExternalReference) {
			IfcExternalReference ref = (IfcExternalReference)idEObject;
			return MessageFormat.format("IfcExternalReference-{0}-{1}", ref.getLocation(), ref.getName());
		}
		return null;
	}

	public String getIdentifier3(IdEObject idEObject) {
		if (idEObject instanceof IfcRoot) {
			if (idEObject instanceof IfcPropertySet
					|| idEObject instanceof IfcQuantitySet) {
				return ((IfcRoot) idEObject).getGlobalId();
			}/* else if (idEObject instanceof IfcRelDefinesByType) {
				IfcRelDefinesByType rel = (IfcRelDefinesByType)idEObject;
				return MessageFormat.format("relDefinesByType-{0}-{1}", rel.getRelatingType().getName(), rel.getRelatingType().eClass().getName());
			} else if (idEObject instanceof IfcRelAggregates) {
				IfcRelAggregates rel = (IfcRelAggregates)idEObject;
				return MessageFormat.format("relAggregates-{0}-{1}", rel.getRelatingObject().getName(), rel.getRelatingObject().eClass().getName());
			} else if (idEObject instanceof IfcRelContainedInSpatialStructure) {
				IfcRelContainedInSpatialStructure rel = (IfcRelContainedInSpatialStructure)idEObject;
				return MessageFormat.format("relContainedInSpatialStructure-{0}-{1}", rel.getRelatingStructure().getName(), rel.getRelatingStructure().eClass().getName());
			} */else if (idEObject instanceof IfcRelationship) {
				return null;
			} else {
				IfcRoot ifcRoot = (IfcRoot) idEObject;
				if (ifcRoot.getName() == null)
					return null;
				else
					return MessageFormat.format("{0}-{1}", ifcRoot.getName(), ifcRoot.eClass().getName());
			}
			/*if (idEObject instanceof IfcGrid) {
				IfcGrid grid = (IfcGrid)idEObject;
				if (grid.isSetContainedInStructure())
					return MessageFormat.format("{0}-{1}", grid.getName(), grid.getContainedInStructure().stream().map(t -> t.getRelatingStructure().getName()).collect(Collectors.joining()));
			} else if (idEObject instanceof IfcBuildingStorey) {
				IfcBuildingStorey storey = (IfcBuildingStorey)idEObject;
				if (storey.isSetDecomposes())
					return MessageFormat.format("{0}-{1}", storey.getName(), storey.getDecomposes().stream().map(t -> t.getRelatingObject().getName()).collect(Collectors.joining()));
				return storey.getName();
			} else if (idEObject instanceof IfcPropertySet) {
				IfcPropertySet set = (IfcPropertySet)idEObject;
				return MessageFormat.format("pset-{0}-{1}", set.getName(), set.getDefinesType().stream().map(t -> t.getName()).collect(Collectors.joining()));
			} else if (idEObject instanceof IfcRelationship) {
				return null;*/
				/*if (idEObject instanceof IfcRelAggregates) {
					IfcRelAggregates rel = (IfcRelAggregates) idEObject;
					return MessageFormat.format("rel-{0}-{1}", rel.getRelatingObject().getName(), rel.getRelatedObjects().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
				} else if (idEObject instanceof IfcRelDefinesByType) {
					IfcRelDefinesByType rel = (IfcRelDefinesByType) idEObject;
					if (!rel.getRelatedObjects().isEmpty()) {
						if (rel.getRelatedObjects().get(0) instanceof IfcBuildingStorey)
							return MessageFormat.format("rel-{0}", rel.getRelatingType().getName());
						else
							return MessageFormat.format("rel-{0}-{1}", rel.getRelatingType().getName(), rel.getRelatedObjects().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
					}
					else
						return MessageFormat.format("rel-{0}-{1}", rel.getRelatingType().getName(), rel.getRelatedObjects().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
				} else if (idEObject instanceof IfcRelDefinesByProperties) {
					IfcRelDefinesByProperties rel = (IfcRelDefinesByProperties) idEObject;
					if (rel.getRelatingPropertyDefinition() instanceof IfcRoot) {
						return MessageFormat.format("rel-{0}-{1}", ((IfcRoot)rel.getRelatingPropertyDefinition()).getName(), rel.getRelatedObjects().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
					} else {
						int i = 0;
					}
				}
				else if (idEObject instanceof IfcRelAssociatesLibrary) {
					IfcRelAssociatesLibrary rel = (IfcRelAssociatesLibrary) idEObject;
					return MessageFormat.format("rel-{0}-{1}", ((IfcExternalReference)rel.getRelatingLibrary()).getLocation(), rel.getRelatedObjects().stream().map(o -> ((IfcObjectDefinition)o).getName()).sorted().collect(Collectors.joining(",")));
				} else if (idEObject instanceof IfcRelContainedInSpatialStructure) {
					IfcRelContainedInSpatialStructure rel = (IfcRelContainedInSpatialStructure) idEObject;
					return MessageFormat.format("rel-{0}-{1}", rel.getRelatingStructure().getName(), rel.getRelatedElements().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
				} else {
					int i = 0;
				}*/
			} else {
				return null;
			}
	}

	public String getIdentifier2(IdEObject idEObject) {
		if (idEObject instanceof IfcRoot) {
			if (idEObject instanceof IfcRelationship) {
				if (idEObject instanceof IfcRelAggregates) {
					IfcRelAggregates aggr = (IfcRelAggregates) idEObject;
					return MessageFormat.format("{0}-{1}", aggr.getRelatingObject().getName(), aggr.getRelatedObjects().stream().map(o -> o.getName()).collect(Collectors.joining(",")));
				} else if (idEObject instanceof IfcRelDefinesByType) {
					IfcRelDefinesByType rel = (IfcRelDefinesByType) idEObject;
					return MessageFormat.format("{0}-{1}", rel.getRelatingType().getName(), rel.getRelatedObjects().stream().map(o -> o.getName()).collect(Collectors.joining(",")));
				} else if (idEObject instanceof IfcRelDefinesByProperties) {
					IfcRelDefinesByProperties rel = (IfcRelDefinesByProperties) idEObject;
					if (rel.getRelatingPropertyDefinition() instanceof IfcRoot) {
						return MessageFormat.format("{0}-{1}", ((IfcRoot)rel.getRelatingPropertyDefinition()).getName(), rel.getRelatedObjects().stream().map(o -> o.getName()).collect(Collectors.joining(",")));
					} else {
						int i = 0;
					}
				}
				else if (idEObject instanceof IfcRelAssociatesLibrary) {
					IfcRelAssociatesLibrary rel = (IfcRelAssociatesLibrary) idEObject;
					return MessageFormat.format("{0}-{1}", ((IfcExternalReference)rel.getRelatingLibrary()).getName(), rel.getRelatedObjects().stream().map(o -> ((IfcObjectDefinition)o).getName()).collect(Collectors.joining(",")));
				} else if (idEObject instanceof IfcRelContainedInSpatialStructure) {
					IfcRelContainedInSpatialStructure rel = (IfcRelContainedInSpatialStructure) idEObject;
					return MessageFormat.format("{0}-{1}", rel.getRelatingStructure().getName(), rel.getRelatedElements().stream().map(o -> o.getName()).collect(Collectors.joining(",")));
				} else {
					int i = 0;
				}
			}
			if (idEObject instanceof IfcElement) {
				/*if (idEObject instanceof IfcGrid)
					return idEObject.getUuid().toString();
				return UUID.randomUUID().toString();*/
				return UUID.randomUUID().toString();
			}
			if (idEObject instanceof IfcPropertySet) {
				IfcPropertySet set = (IfcPropertySet)idEObject;
				return MessageFormat.format("{0}-{1}", set.getName(), set.getDefinesType().stream().map(t -> t.getName()).collect(Collectors.joining()));
			}/*
			if (idEObject instanceof IfcExternalReference) {
				IfcExternalReference ref = (IfcExternalReference)idEObject;
				return MessageFormat.format("{0}-{1}-{2}", ref.getIdentification().getName(), prop.getPartOfPset().stream().map(t -> t.getName()).collect(Collectors.joining()));
			}*/
			/*
			if (idEObject instanceof IfcGrid)
				return idEObject.getUuid() != null ? idEObject.getUuid().toString() : UUID.randomUUID().toString();*/

			IfcRoot ifcRoot = (IfcRoot) idEObject;
			if (ifcRoot.getName() == null)
				return null;
			else
				return MessageFormat.format("{0}-{1}", ifcRoot.getName(), ifcRoot.eClass().getName());
		}
		return null;
	}
}