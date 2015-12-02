package org.bimserver.database.queries;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class QueryObjectProvider implements ObjectProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryObjectProvider.class);
	private DatabaseSession databaseSession;
	private BimServer bimServer;
	
	private String json;
	
	private final Set<Long> oidsRead = new HashSet<>();
	private Deque<StackFrame> stack;
	private long start = -1;
	private long reads = 0;
	private long stackFramesProcessed = 0;
	private Query namespace;
	private final Set<Long> goingToRead = new HashSet<>();

	public QueryObjectProvider(DatabaseSession databaseSession, BimServer bimServer, Query query, Set<Long> roids, PackageMetaData packageMetaData) throws JsonParseException, JsonMappingException, IOException, QueryException {
		this.databaseSession = databaseSession;
		this.bimServer = bimServer;
		this.namespace = query;
		
		stack = new ArrayDeque<StackFrame>();
		stack.push(new StartFrame(this, roids));
		
		for (QueryPart queryPart : query.getQueryParts()) {
			if (queryPart.hasOids()) {
				goingToRead.addAll(queryPart.getOids());
			}
		}
	}
	
	public static QueryObjectProvider fromJsonNode(DatabaseSession databaseSession, BimServer bimServer, JsonNode fullQuery, Set<Long> roids, PackageMetaData packageMetaData) throws JsonParseException, JsonMappingException, IOException, QueryException {
		if (fullQuery instanceof ObjectNode) {
			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(packageMetaData);
			Query namespace = converter.parseJson("query", (ObjectNode) fullQuery);
			return new QueryObjectProvider(databaseSession, bimServer, namespace, roids, packageMetaData);
		} else {
			throw new QueryException("Query root must be of type object");
		}
	}
	
	public static QueryObjectProvider fromJsonString(DatabaseSession databaseSession, BimServer bimServer, String json, Set<Long> roids, PackageMetaData packageMetaData) throws JsonParseException, JsonMappingException, IOException, QueryException {
		return fromJsonNode(databaseSession, bimServer, new ObjectMapper().readValue(json, ObjectNode.class), roids, packageMetaData);
	}
	
	public Query getNameSpace() {
		return namespace;
	}

	@Override
	public HashMapVirtualObject next() throws BimserverDatabaseException {
		if (start == -1) {
			start = System.nanoTime();
		}
		try {
			while (!stack.isEmpty()) {
				if (stack.size() > 10000) {
					dumpEndQuery();
					throw new BimserverDatabaseException("Query stack size > 1000, probably a bug, please report");
				}
				StackFrame stackFrame = stack.peek();
				if (stackFrame.isDone()) {
					stack.pop();
					continue;
				}
				stackFramesProcessed++;
				if (stackFramesProcessed > 10000000) {
					dumpEndQuery();
					throw new BimserverDatabaseException("Too many stack frames processed, probably a bug, please report");
				}
				boolean done = stackFrame.process();
				stackFrame.setDone(done);
				if (stackFrame instanceof ObjectProvidingStackFrame) {
					HashMapVirtualObject currentObject = ((ObjectProvidingStackFrame) stackFrame).getCurrentObject();
					if (currentObject != null) {
						if (!oidsRead.contains(currentObject.getOid())) {
							oidsRead.add(currentObject.getOid());
							return currentObject;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new BimserverDatabaseException(e);
		}

		dumpEndQuery();
		
		return null;
	}
	
	private void dumpEndQuery() {
		StackFrame poll = stack.poll();
		int i=0;
		if (poll != null) {
			LOGGER.info("Query dump");
			while (poll != null && i < 20) {
				i++;
				LOGGER.info("\t" + poll.toString());
				poll = stack.poll();
			}
		}
		long end = System.nanoTime();
		LOGGER.info("Query, " + reads + " reads, " + stackFramesProcessed + " stack frames processed, " + oidsRead.size() + " objects read, " + ((end - start) / 1000000) + "ms");
	}

	public void incReads() {
		reads++;
	}

	public DatabaseSession getDatabaseSession() {
		return databaseSession;
	}

	public MetaDataManager getMetaDataManager() {
		return bimServer.getMetaDataManager();
	}

	public String getJsonString() {
		return json;
	}

	public boolean hasRead(long oid) {
		return oidsRead.contains(oid);
	}

	public void push(StackFrame stackFrame) {
		if (!stackFrame.isDone()) {
			stack.push(stackFrame);
		}
	}

	public boolean hasReadOrIsGoingToRead(Long oid) {
		if (oidsRead.contains(oid)) {
			return true;
		}
		if (goingToRead.contains(oid)) {
			return true;
		}
		return false;
	}
}