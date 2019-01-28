package org.bimserver.cache;

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

import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.emf.PackageMetaData;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class DownloadDescriptor {
	private static final HashFunction hf = Hashing.md5();
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private Set<Long> roids;
	private Query query;
	private long serializerOid;
	private String fileNameWithoutExtension;
	private PackageMetaData packageMetaData;
	private String jsonQuery;

	public long getSerializerOid() {
		return serializerOid;
	}
	
	public DownloadDescriptor(PackageMetaData packageMetaData, String jsonQuery, Set<Long> roids, Query query, long serializerOid, String fileNameWithoutExtension) {
		this.packageMetaData = packageMetaData;
		this.jsonQuery = jsonQuery;
		this.roids = roids;
		this.query = query;
		this.serializerOid = serializerOid;
		this.fileNameWithoutExtension = fileNameWithoutExtension;
	}
	
	public String getCacheKey() {
		Hasher hasher = hf.newHasher();
		// TODO This serializerOid actually makes the cache a per-user cache... Maybe not the most useful feature
		hasher.putLong(serializerOid);
		for (long roid : roids) {
			hasher.putLong(roid);
		}
		if (jsonQuery != null) {
			// TODO This is based on the incoming JSON (if there is any), this should be replaced at some point by a canonical-form
			hasher.putString(jsonQuery, Charsets.UTF_8);
			HashCode hashcode = hasher.hash();
			return hashcode.toString();
		} else {
			// TODO This does not work because the toJson function is not complete
			ObjectNode json = new JsonQueryObjectModelConverter(packageMetaData).toJson(query);
			try {
				StringWriter stringWriter = new StringWriter();
				OBJECT_MAPPER.writeValue(stringWriter, json);
				System.out.println(query.toString());
				hasher.putString(stringWriter.toString(), Charsets.UTF_8);
				HashCode hashcode = hasher.hash();
				return hashcode.toString();
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getFileNameWithoutExtension() {
		return fileNameWithoutExtension;
	}
}
