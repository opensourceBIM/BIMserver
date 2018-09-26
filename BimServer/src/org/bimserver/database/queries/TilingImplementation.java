package org.bimserver.database.queries;

import java.util.List;

import org.bimserver.database.queries.om.Tiles;
import org.bimserver.database.queries.om.TilingInterface;
import org.bimserver.geometry.accellerator.GeometryObject;
import org.bimserver.geometry.accellerator.Node;
import org.bimserver.geometry.accellerator.Octree;
import org.bimserver.geometry.accellerator.Traverser;
import org.eclipse.emf.ecore.EClass;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.query.option.QueryOptions;

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

		octree.traverseBreathFirst(new Traverser<GeometryObject>() {
			@Override
			public void traverse(Node<GeometryObject> t) {
				for (ObjectWrapper<GeometryObject> objectWrapper : t.getValues()) {
					objects.add(objectWrapper.getV());
				}
			}});
	}

	@Override
	public void queryOids(List<Long> oids, List<Long> oidsFiltered, long roid, EClass eClass, Tiles tiles) {
		Query<GeometryObject> query = QueryFactory.and(QueryFactory.equal(ROID, roid), QueryFactory.equal(ECLASS, eClass), QueryFactory.in(TILE_ID, tiles.getTileIds()));
		if (tiles.getMaximumThreshold() != -1) {
			query = QueryFactory.and(query, QueryFactory.lessThanOrEqualTo(DENSITY, tiles.getMaximumThreshold()));
		}
		if (tiles.getMinimumThreshold() != -1) {
			query = QueryFactory.and(query, QueryFactory.greaterThan(DENSITY, tiles.getMinimumThreshold()));
		}
		for (GeometryObject geometryObject : objects.retrieve(query)) {
			if (tiles.getMinimumReuseThreshold() != -1 && tiles.getMinimumReuseThreshold() <= geometryObject.getSaveableTriangles()) {
				// We still have to send this object, we just need to somehow make sure the associated GeometryData is not sent
				oidsFiltered.add(geometryObject.getOid());
			} else {
				oids.add(geometryObject.getOid());
			}
		}
	}
}