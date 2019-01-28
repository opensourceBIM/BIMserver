package org.bimserver.endpoints;

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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

public class EndPointManager {

	private final BiMap<Long, EndPoint> endPoints = Maps.synchronizedBiMap(HashBiMap.<Long, EndPoint>create());
	private final Map<String, EndPoint> tokenToEndPoint = Collections.synchronizedMap(new HashMap<>());
	private final AtomicLong idCounter = new AtomicLong(1);
	
	public long register(EndPoint endPoint) {
		long id = idCounter.incrementAndGet();
		endPoints.forcePut(id, endPoint);
		tokenToEndPoint.put(endPoint.getToken(), endPoint);
		return id;
	}

	public void unregister(EndPoint endPoint) {
		endPoints.remove(endPoint.getEndPointId());
		tokenToEndPoint.remove(endPoint.getToken());
		endPoint.cleanup();
	}

	public void unregister(long endPointId) {
		EndPoint endPoint = endPoints.get(endPointId);
		if (endPoint != null) {
			endPoints.remove(endPointId);
			endPoint.cleanup();
		}
	}
	
	public EndPoint get(String token) {
		return tokenToEndPoint.get(token);
	}
	
	public EndPoint get(long endPointId) {
		return endPoints.get(endPointId);
	}

	public void clear() {
		for (Entry<Long, EndPoint> entry : endPoints.entrySet()) {
			entry.getValue().cleanup();
		}
		endPoints.clear();
	}
}