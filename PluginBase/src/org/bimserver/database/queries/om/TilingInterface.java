package org.bimserver.database.queries.om;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

public interface TilingInterface {

	void queryOids(List<Long> oids, List<Long> oidsFiltered, long roid, EClass eClass, Tiles tiles);
}
