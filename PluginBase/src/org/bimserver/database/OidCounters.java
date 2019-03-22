package org.bimserver.database;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.plugins.deserializers.DatabaseInterface;
import org.eclipse.emf.ecore.EClass;

public class OidCounters {

	private final Map<EClass, Long> map = new HashMap<>();

	public OidCounters() {
	}

	public OidCounters(DatabaseInterface databaseInterface, byte[] oidCounters) throws BimserverDatabaseException {
		if (oidCounters == null) {
			return;
		}
		ByteBuffer buffer = ByteBuffer.wrap(oidCounters);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		for (int i=0; i<buffer.capacity() / 8; i++) {
			long oid = buffer.getLong();
			EClass eClass = databaseInterface.getEClassForOid(oid);
			map.put(eClass, oid);
		}
	}

	public void put(EClass eClass, long oid) {
		map.put(eClass, oid);
	}

	public byte[] getBytes() {
		ByteBuffer buffer = ByteBuffer.allocate(8 * map.size());
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		for (EClass eClass : map.keySet()) {
			buffer.putLong(map.get(eClass));
		}
		return buffer.array();
	}

	public boolean containsKey(EClass eClass) {
		return map.containsKey(eClass);
	}

	public long get(EClass eClass) {
		return map.get(eClass);
	}

	public Set<EClass> keySet() {
		return map.keySet();
	}
	
	@Override
	public String toString() {
		return "OidCounters: " + map.keySet().stream().map(EClass::getName).collect(Collectors.joining(", "));
	}

	public void putIfAbsent(EClass eClass, long oid) {
		if (map.putIfAbsent(eClass, oid) == null) {
//			System.out.println("Putting " + eClass.getName() + ": " + oid);
		}
	}
}
