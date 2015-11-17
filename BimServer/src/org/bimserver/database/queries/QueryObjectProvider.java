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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	public QueryObjectProvider(DatabaseSession databaseSession, BimServer bimServer, String json, Set<Long> roids) {
		this.databaseSession = databaseSession;
		this.bimServer = bimServer;
		this.json = json;
		
		stack = new ArrayDeque<StackFrame>();
		stack.push(new StartFrame(this, roids));
	}

	@Override
	public HashMapVirtualObject next() throws BimserverDatabaseException {
		if (start == -1) {
			start = System.nanoTime();
		}
		try {
			while (!stack.isEmpty()) {
				if (stack.size() > 1000) {
					// TODO include stack dump
					dumpEndQuery();
					throw new BimserverDatabaseException("Query stack size > 1000, probably a bug, please report");
				}
				StackFrame stackFrame = stack.peek();
				stackFramesProcessed++;
				if (stackFramesProcessed > 1000000) {
					// TODO include stack dump
					dumpEndQuery();
					throw new BimserverDatabaseException("Too many stack frames processed, probably a bug, please report");
				}
//				System.out.println(stackFrame);
				Set<StackFrame> newStackFrames = stackFrame.process();
				if (newStackFrames == null || newStackFrames.size() == 0) {
					stack.pop();
				} else if (newStackFrames.size() == 1) {
					StackFrame newStackFrame = newStackFrames.iterator().next();
					if (newStackFrame == stackFrame) {
						// Do nothing, we stay in the current frame
					} else {
						stack.push(newStackFrame);
					}
				} else {
					for (StackFrame newStackFrame : newStackFrames) {
						stack.push(newStackFrame);
					}
				}
				if (stackFrame instanceof ObjectProvidingStackFrame) {
					HashMapVirtualObject currentObject = ((ObjectProvidingStackFrame) stackFrame).getCurrentObject();
					if (currentObject != null) {
						oidsRead.add(currentObject.getOid());
						return currentObject;
					}
				}
			}
		} catch (QueryException e) {
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
}