package org.bimserver.cache;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.util.Set;

import org.bimserver.database.queries.om.Query;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class DownloadDescriptor {
	private Set<Long> roids;
	private Query query;
	private long serializerOid;
	private String fileNameWithoutExtension;

	public DownloadDescriptor(Set<Long> roids, Query query, long serializerOid, String fileNameWithoutExtension) {
		this.roids = roids;
		this.query = query;
		this.serializerOid = serializerOid;
		this.fileNameWithoutExtension = fileNameWithoutExtension;
	}
	
	public String getCacheKey() {
		HashFunction hf = Hashing.md5();
		Hasher hasher = hf.newHasher();
		hasher.putLong(serializerOid);
		for (long roid : roids) {
			hasher.putLong(roid);
		}
		hasher.putString(query.toString(), Charsets.UTF_8);
		HashCode hashcode = hasher.hash();
		return hashcode.toString();
	}

	public String getFileNameWithoutExtension() {
		return fileNameWithoutExtension;
	}
}
