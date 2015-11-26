package org.bimserver.database.queries;

import java.io.IOException;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.shared.QueryException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract class StackFrame {
	private boolean done = false;
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	abstract boolean process() throws BimserverDatabaseException, QueryException, JsonParseException, JsonMappingException, IOException;
}