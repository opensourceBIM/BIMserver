package org.bimserver.webservices.impl;

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

import org.opensourcebim.bcf.BcfFile;

public class BcfCache {
	public static BcfCache INSTANCE = new BcfCache();
	private final Map<Long, BcfFile> map = new HashMap<>();
	
	public BcfCache() {
		
	}
	
	public synchronized void put(Long extendedDataId, BcfFile bcfFile) {
		map.put(extendedDataId, bcfFile);
	}
	
	public BcfFile get(Long extendedDataId) {
		return map.get(extendedDataId);
	}
}
