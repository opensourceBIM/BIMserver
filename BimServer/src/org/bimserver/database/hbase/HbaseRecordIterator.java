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
//
//import org.apache.hadoop.hbase.client.HTable;
//import org.apache.hadoop.hbase.client.Scanner;
//import org.apache.hadoop.hbase.io.RowResult;
//import org.bimserver.emf2codb.Record;
//import org.bimserver.emf2codb.RecordIterator;
//
//public class HbaseRecordIterator implements RecordIterator {
//
//	private Scanner scanner;
//
//	public HbaseRecordIterator(HTable table) {
//		try {
//			scanner = table.getScanner(new String[]{"value:"});
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void close() {
//		scanner.close();
//	}
//
//	@Override
//	public Record next() {
//		try {
//			RowResult next = scanner.next();
//			if (next != null) {
//				return new HbaseRecord(next.getRow(), next.get("value:").getValue());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}
