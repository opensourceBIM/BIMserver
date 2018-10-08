package org.bimserver.database.queries;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.database.queries.om.Tiles;
import org.bimserver.database.queries.om.TilingInterface;
import org.bimserver.geometry.accellerator.GeometryObject;
import org.bimserver.geometry.accellerator.Node;
import org.bimserver.geometry.accellerator.Octree;
import org.eclipse.emf.ecore.EClass;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.index.compound.CompoundIndex;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.navigable.NavigableIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.query.logical.And;
import com.googlecode.cqengine.query.option.QueryOptions;
import com.googlecode.cqengine.resultset.ResultSet;

public class TilingImplementation implements TilingInterface {

	private IndexedCollection<GeometryObject> objects = new ConcurrentIndexedCollection<>();

	public static final Attribute<GeometryObject, Long> ROID = new SimpleAttribute<GeometryObject, Long>("roid") {
		@Override
		public Long getValue(GeometryObject object, QueryOptions queryOptions) {
			return object.getRoid();
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

	public static final Attribute<GeometryObject, Float> DENSITY = new SimpleAttribute<GeometryObject, Float>("density") {
		public Float getValue(GeometryObject object, QueryOptions queryOptions) {
			return object.getDensity();
		}
	};

	public TilingImplementation(Octree<GeometryObject> octree) {
		objects.addIndex(HashIndex.onAttribute(ROID));
		objects.addIndex(HashIndex.onAttribute(ECLASS));
		objects.addIndex(HashIndex.onAttribute(TILE_ID));
		objects.addIndex(HashIndex.onAttribute(DENSITY));

		for (Node<GeometryObject> node : octree.values()) {
			for (ObjectWrapper<GeometryObject> objectWrapper : node.getValues()) {
				objects.add(objectWrapper.getV());
			}
		}
	}

	@Override
	public void queryOids(List<Long> oids, List<Long> oidsFiltered, long roid, EClass eClass, Tiles tiles) {
		Set<Query<GeometryObject>> queries = new HashSet<>();
		queries.add(QueryFactory.equal(ROID, roid));
		queries.add(QueryFactory.equal(ECLASS, eClass));
		queries.add(QueryFactory.in(TILE_ID, tiles.getTileIds()));
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
		ResultSet<GeometryObject> retrieve = objects.retrieve(new And<>(queries));
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