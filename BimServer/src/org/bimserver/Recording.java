package org.bimserver;

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

import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SService;

public class Recording {
	private long start;
	private MetricsRegistry metricsRegistry;
	private long end;
	private SMethod method;

	public Recording(MetricsRegistry metricsRegistry, SService sService, SMethod method) {
		this.metricsRegistry = metricsRegistry;
		this.method = method;
		start = System.nanoTime();
	}

	public void finish() {
		end = System.nanoTime();
		metricsRegistry.getMethodStats(method).add(this);
	}

	public long getTotalTime() {
		return end - start;
	}
}
