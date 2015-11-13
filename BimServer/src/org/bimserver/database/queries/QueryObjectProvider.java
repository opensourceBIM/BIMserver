package org.bimserver.database.queries;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.shared.HashMapVirtualObject;

public class QueryObjectProvider implements ObjectProvider {

	private DatabaseSession databaseSession;
	private BimServer bimServer;
	
	private String json;
	
	private final Set<Long> oidsRead = new HashSet<>();
	private Deque<StackFrame> stack;
	
	public QueryObjectProvider(DatabaseSession databaseSession, BimServer bimServer, String json, Set<Long> roids) {
		this.databaseSession = databaseSession;
		this.bimServer = bimServer;
		this.json = json;
		
		stack = new ArrayDeque<StackFrame>();
		stack.push(new StartFrame(this, roids));
	}

	@Override
	public HashMapVirtualObject next() throws BimserverDatabaseException {
		try {
			while (!stack.isEmpty()) {
				if (stack.size() > 1000) {
					throw new BimserverDatabaseException("Query stack size > 1000, probably a bug, please report");
				}
				StackFrame stackFrame = stack.peek();
				System.out.println(stackFrame);
				StackFrame newStackFrame = stackFrame.process();
				if (newStackFrame == null) {
					stack.pop();
				} else if (newStackFrame == stackFrame) {
					// Do nothing, we stay in the current frame
				} else {
					stack.push(newStackFrame);
				}
				if (stackFrame instanceof ObjectProvidingStackFrame) {
					HashMapVirtualObject currentObject = ((ObjectProvidingStackFrame) stackFrame).getCurrentObject();
					if (currentObject != null) {
						oidsRead.add(currentObject.getOid());
					}
					return currentObject;
				}
			}
		} catch (QueryException e) {
			throw new BimserverDatabaseException(e);
		}
		
		return null;
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
}