package org.bimserver.database.queries;

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
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.NotImplementedException;
import org.bimserver.database.queries.om.Tiles;
import org.bimserver.database.queries.om.TilingInterface;
import org.bimserver.geometry.accellerator.GeometryObject;
import org.bimserver.geometry.accellerator.Node;
import org.bimserver.geometry.accellerator.Octree;
import org.bimserver.geometry.accellerator.Traverser;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.query.logical.And;
import com.googlecode.cqengine.query.option.EngineThresholds;
import com.googlecode.cqengine.query.option.QueryOptions;
import com.googlecode.cqengine.resultset.ResultSet;

public class TilingImplementation implements TilingInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(TilingImplementation.class);
	private IndexedCollection<GeometryObject> objects = new ConcurrentIndexedCollection<>();

	public static final Attribute<GeometryObject, Long> CROID = new SimpleAttribute<GeometryObject, Long>("croid") {
		@Override
		public Long getValue(GeometryObject object, QueryOptions queryOptions) {
			return object.getCroid();
		}
	};

	public static final Attribute<GeometryObject, EClass> ECLASS = new SimpleAttribute<GeometryObject, EClass>("eclass") {
		public EClass getValue(GeometryObject object, QueryOptions queryOptions) {
			return object.geteClass();
		}
	};

	public static final Attribute<GeometryObject, Integer> TILE_ID = new SimpleAttribute<GeometryObject, Integer>("tildId") {
		public Integer getValue(GeometryObject object, QueryOptions queryOptions) {
			return object.getTileId();
		}
	};

	public static final Attribute<GeometryObject, Integer> TILE_LEVEL = new SimpleAttribute<GeometryObject, Integer>("tileLevel") {
		public Integer getValue(GeometryObject object, QueryOptions queryOptions) {
			return object.getTileLevel();
		}
	};

	public static final Attribute<GeometryObject, Float> DENSITY = new SimpleAttribute<GeometryObject, Float>("density") {
		public Float getValue(GeometryObject object, QueryOptions queryOptions) {
			return object.getDensity();
		}
	};

	public static final Attribute<GeometryObject, Float> ORDER = new SimpleAttribute<GeometryObject, Float>("order") {
		public Float getValue(GeometryObject object, QueryOptions queryOptions) {
			return object.getOrder();
		}
	};

	private Octree octree;

	public TilingImplementation(Octree octree) {
		this.octree = octree;
		objects.addIndex(HashIndex.onAttribute(CROID));
		objects.addIndex(HashIndex.onAttribute(ECLASS));
		objects.addIndex(HashIndex.onAttribute(TILE_ID));
		objects.addIndex(HashIndex.onAttribute(TILE_LEVEL));
		objects.addIndex(HashIndex.onAttribute(DENSITY));
		objects.addIndex(HashIndex.onAttribute(ORDER));

		for (Node node : octree.values()) {
			for (GeometryObject geometryObject : node.getValues()) {
				objects.add(geometryObject);
			}
		}
	}

	@Override
	public void queryOids(List<Long> oids, List<Long> oidsFiltered, long croid, EClass eClass, Tiles tiles) {
		if (tiles.getTileIds().size() > 1) {
			throw new NotImplementedException("Only one tile id supported in this method");
		}
		Set<Query<GeometryObject>> queries = new HashSet<>();
		queries.add(QueryFactory.equal(CROID, croid));
		if (eClass != null) {
			queries.add(QueryFactory.equal(ECLASS, eClass));
		}
		if (tiles.getTileIds().contains(0) && tiles.getMaxDepth() == 0) {
			// When we are querying TILE_ID = 0 in a context where the maxdepth = 0, we need to get all levels, basically we can omit the TILE_ID
		} else {
			// For every tile we load that has a level < maxdepth -> Just load the tile
			// For every tile we load that has a level > maxdepth, log a message, makes no sense
			// For every tile we load that has a level == maxdepth, we need to make sure to also load all tiles of lower levels (level > q < actual max depth of octree)
			
			// TODO this code for now assumes one single tileId
			Integer tileId = tiles.getTileIds().iterator().next();
			
			int level = Octree.getLevelOfId(tileId);
			if (level < tiles.getMaxDepth()) {
				queries.add(QueryFactory.equal(TILE_ID, tileId));
			} else if (level > tiles.getMaxDepth()) {
				LOGGER.info("Not cool");
			} else {
				// TODO it must be possible to make this faster...
				Node node = octree.getById(tileId);
				Set<Integer> in = new HashSet<>();
				node.traverseBreathFirst(new Traverser() {
					@Override
					public void traverse(Node t) {
						in.add(t.getId());
					}
				});
				queries.add(QueryFactory.in(TILE_ID, in));
			}
		}
		if (tiles.getMaximumThreshold() != -1 && tiles.getMinimumThreshold() != -1) {
			queries.add(QueryFactory.between(DENSITY, tiles.getMinimumThreshold(), false, tiles.getMaximumThreshold(), true));
		} else {
			if (tiles.getMaximumThreshold() != -1) {
				queries.add(QueryFactory.lessThanOrEqualTo(DENSITY, tiles.getMaximumThreshold()));
			}
			if (tiles.getMinimumThreshold() != -1) {
				queries.add(QueryFactory.greaterThan(DENSITY, tiles.getMinimumThreshold()));
			}
		}
		Query<GeometryObject> query = null;
		if (queries.size() == 1) {
			query = queries.iterator().next();
		} else {
			query = new And<>(queries);
		}
		ResultSet<GeometryObject> retrieve = objects.retrieve(query, 
			QueryFactory.queryOptions(
				QueryFactory.orderBy(QueryFactory.descending(ORDER)), 
				QueryFactory.applyThresholds(QueryFactory.threshold(EngineThresholds.INDEX_ORDERING_SELECTIVITY, 1.0))));
		for (GeometryObject geometryObject : retrieve) {
			if (tiles.getMinimumReuseThreshold() != -1 && tiles.getMinimumReuseThreshold() <= geometryObject.getSaveableTriangles()) {
				// We still have to send this object, we just need to somehow make sure the associated GeometryData is not sent
				oidsFiltered.add(geometryObject.getOid());
			} else {
				oids.add(geometryObject.getOid());
			}
		}
	}
}