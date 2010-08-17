package org.bimserver.database.hbase;
//package org.bimserver.emf2codb.hbase;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.HColumnDescriptor;
//import org.apache.hadoop.hbase.HTableDescriptor;
//import org.apache.hadoop.hbase.MasterNotRunningException;
//import org.apache.hadoop.hbase.client.HBaseAdmin;
//import org.apache.hadoop.hbase.client.HTable;
//import org.apache.hadoop.hbase.io.BatchUpdate;
//import org.apache.hadoop.hbase.io.Cell;
//import org.bimserver.emf2codb.ColumnDatabase;
//import org.bimserver.emf2codb.ColumnDatabaseException;
//import org.bimserver.emf2codb.Record;
//import org.bimserver.emf2codb.RecordIterator;
//import org.bimserver.utils.BinUtils;
//
//public class HbaseColumnDatabase implements ColumnDatabase {
//
//	private HBaseConfiguration baseConfiguration;
//	private HBaseAdmin baseAdmin;
//	private Map<String, HTable> tables = new HashMap<String, HTable>();
//
//	public HbaseColumnDatabase() {
//		baseConfiguration = new HBaseConfiguration();
//		try {
//			baseAdmin = new HBaseAdmin(baseConfiguration);
//		} catch (MasterNotRunningException e) {
//			e.printStackTrace();
//		}
//		clear();
//	}
//	
//	private void deleteTable(String tableName) {
//		try {
//			baseAdmin.disableTable(tableName);
//			baseAdmin.deleteTable(tableName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void clear() {
//		deleteTable("INT-ClassLookup");
//		deleteTable("INT-Store");
//		deleteTable("INT-Registry");
//		deleteTable("INT-Blob");
//		deleteTable("Project");
//		deleteTable("User");
//		deleteTable("Checkout");
//		deleteTable("Revision");
//	}
//
//	@Override
//	public void close() {
//	}
//
//	@Override
//	public boolean containsTable(String tableName) {
//		System.out.println("contains " + tableName);
//		try {
//			return HTable.isTableEnabled(tableName);
//		} catch (IOException e) {
//			return false;
//		}
//	}
//
//	@Override
//	public long count(String tableName) {
//		return 0;
//	}
//
//	@Override
//	public boolean createTableIfNotExists(String tableName) {
////		if (!containsTable(tableName)) {
//			HTableDescriptor table = new HTableDescriptor(tableName);
//			table.addFamily(new HColumnDescriptor("value:"));
//			try {
//				baseAdmin.createTableAsync(table);
//			} catch (IOException e) {
//			}
//			try {
//				tables.put(tableName, new HTable(tableName));
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//			return true;
////		}
////		return false;
//	}
//
//	@Override
//	public byte[] get(String tableName, byte[] key) {
//		try {
//			Cell cell = tables.get(tableName).get(key, "value:".getBytes("UTF-8"));
//			if (cell == null) {
//				return null;
//			}
//			return cell.getValue();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public byte[] getFirstStartingWith(String tableName, byte[] key) {
//		return null;
//	}
//
//	@Override
//	public short getHighestKey(String tableName) {
//		RecordIterator recordIterator = getRecordIterator(tableName);
//		Record object = recordIterator.next();
//		Record lastobject = object;
//		while (object != null) {
//			lastobject = object;
//			object = recordIterator.next();
//		}
//		return BinUtils.byteArrayToShort(lastobject.getKey());
//	}
//
//	@Override
//	public RecordIterator getRecordIterator(String tableName) {
//		return new HbaseRecordIterator(tables.get(tableName));
//	}
//
//	@Override
//	public RecordIterator getRecordIterator(String tableName, byte[] keyStart) {
//		return new HbaseSearchingRecordIterator(tables.get(tableName), keyStart);
//	}
//
//	@Override
//	public boolean isNew() {
//		return true;
//	}
//
//	@Override
//	public void store(String tableName, byte[] key, byte[] value) throws ColumnDatabaseException {
//		BatchUpdate batchUpdate = new BatchUpdate(key);
//		batchUpdate.put("value:", value);
//		try {
//			tables.get(tableName).commit(batchUpdate);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void sync() {
//	}
//
//	@Override
//	public void delete(String tableName, byte[] key) {
//	}
//}