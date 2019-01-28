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

import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SService;

public class MethodStats {
	private final AtomicLong nrCalls = new AtomicLong();
	private final AtomicLong totalNanoSeconds = new AtomicLong();

	public MethodStats(SService sService, SMethod sMethod) {
	}

	public void add(Recording recording) {
		nrCalls.incrementAndGet();
		totalNanoSeconds.addAndGet(recording.getTotalTime());
	}
	
	public long getAverageNanoSecondsPerCall() {
		return totalNanoSeconds.get() / nrCalls.get();
	}

	public long getNrCalls() {
		return nrCalls.get();
	}
}