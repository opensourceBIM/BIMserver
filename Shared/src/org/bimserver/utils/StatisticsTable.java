package org.bimserver.utils;

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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatisticsTable {
	private Map<String, Measurement> measurements = new HashMap<String, Measurement>();
	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsTable.class);

	public void print() {
		for (String key : measurements.keySet()) {
			System.out.println(key + "\t" + Formatters.formatNanoSeconds(measurements.get(key).getTime()));
		}
	}

	private void checkExists(String key) {
		if (!measurements.containsKey(key)) {
			measurements.put(key, new Measurement());
		}
	}
	
	public void startMeasuring(String key) {
		checkExists(key);
		LOGGER.info(key + " Started");
		measurements.get(key).setStart(System.nanoTime());
	}

	public void stopMeasuring(String key) {
		checkExists(key);
		LOGGER.info(key + " Stopped");
		measurements.get(key).setStop(System.nanoTime());
	}

	public void stopStartMeasuring(String key1, String key2) {
		stopMeasuring(key1);
		startMeasuring(key2);
	}
}
