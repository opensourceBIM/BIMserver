package org.bimserver.cache;

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
