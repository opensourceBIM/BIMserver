package org.bimserver.database.queries;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.AbstractDownloadDatabaseAction;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.QueryContext;
import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ConcreteRevisionStackFrame extends StackFrame {

	private QueryObjectProvider queryObjectProvider;
	private PackageMetaData packageMetaData;
	private QueryContext reusable;

	public ConcreteRevisionStackFrame(QueryObjectProvider queryObjectProvider, ConcreteRevision concreteRevision) {
		this.queryObjectProvider = queryObjectProvider;
		int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(concreteRevision.getProject(), concreteRevision);
		packageMetaData = queryObjectProvider.getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
		Revision revision = concreteRevision.getRevisions().get(0);
		
		reusable = new QueryContext(queryObjectProvider.getDatabaseSession(), packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), revision.getOid(), highestStopId);
		updateOidCounters(reusable, concreteRevision, queryObjectProvider.getDatabaseSession());
	}
	
	private void updateOidCounters(QueryContext reusable, ConcreteRevision subRevision, DatabaseSession databaseSession) {
		if (subRevision.getOidCounters() != null) {
			Map<EClass, Long> oidCounters = new HashMap<>();
			ByteBuffer buffer = ByteBuffer.wrap(subRevision.getOidCounters());
			for (int i=0; i<buffer.capacity() / 10; i++) {
				short cid = buffer.getShort();
				long oid = buffer.getLong();
				EClass eClass = databaseSession.getEClass(cid);
				oidCounters.put(eClass, oid);
			}
			reusable.setOidCounters(oidCounters);
		}
	}

	@Override
	public boolean process() throws BimserverDatabaseException, JsonParseException, JsonMappingException, IOException {
		queryObjectProvider.push(new QueryStackFrame(queryObjectProvider, reusable));
		return true;
	}
}