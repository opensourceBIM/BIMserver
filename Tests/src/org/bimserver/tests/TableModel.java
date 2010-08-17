//package org.bimserver.tests;
//
//import java.util.ArrayList;
//
//import javax.swing.table.AbstractTableModel;
//
//import org.bimserver.emf2codb.ColumnDatabase;
//import org.bimserver.emf2codb.Record;
//import org.bimserver.emf2codb.RecordIterator;
//import org.bimserver.utils.BimByteUtils;
//import org.bimserver.utils.DoubleHashMap;
//import org.eclipse.emf.ecore.EClass;
//
//public class TableModel extends AbstractTableModel {
//
//	private static final long serialVersionUID = -6514033879348384340L;
//	private final ColumnDatabase columnDatabase;
//	private final DoubleHashMap<Short, EClass> classifiers;
//	private final ArrayList<Row> rows = new ArrayList<Row>();
//
//	private class Row {
//		private final byte[] key;
//		private final byte[] value;
//		private int pid;
//		private long oid;
//		private int rid;
//
//		public Row(byte[] key, byte[] value) {
//			pid = BimByteUtils.extractPid(key);
//			oid = BimByteUtils.extractOid(key);
//			rid = BimByteUtils.extractRid(key);
//			this.key = key;
//			this.value = value;
//		}
//
//		public byte[] getKey() {
//			return key;
//		}
//
//		public byte[] getValue() {
//			return value;
//		}
//
//		public int getPid() {
//			return pid;
//		}
//
//		public long getOid() {
//			return oid;
//		}
//
//		public int getRid() {
//			return rid;
//		}
//	}
//
//	public TableModel(ColumnDatabase columnDatabase, DoubleHashMap<Short, EClass> classifiers) {
//		this.columnDatabase = columnDatabase;
//		this.classifiers = classifiers;
//	}
//
//	@Override
//	public String getColumnName(int column) {
//		switch (column) {
//		case 0:
//			return "Pid";
//		case 1:
//			return "Oid";
//		case 2:
//			return "Rid";
//		case 3:
//			return "Value";
//		default:
//			return "";
//		}
//	}
//
//	@Override
//	public int getColumnCount() {
//		return 4;
//	}
//
//	@Override
//	public int getRowCount() {
//		return rows.size();
//	}
//
//	@Override
//	public Object getValueAt(int rowIndex, int columnIndex) {
//		Row row = rows.get(rowIndex);
//		switch (columnIndex) {
//		case 0:
//			return row.getPid();
//		case 1:
//			return row.getOid();
//		case 2:
//			return row.getRid();
//		case 3:
//			return row.getValue();
//		default:
//			return null;
//		}
//	}
//
//	public void update(EClass selectedItem) {
//		rows.clear();
//		RecordIterator recordIterator = columnDatabase.getRecordIterator(selectedItem.getName());
//		Record next = recordIterator.next();
//		while (next != null) {
//			rows.add(new Row(next.getKey(), next.getValue()));
//			next = recordIterator.next();
//		}
//		fireTableDataChanged();
//	}
//
//	public byte[] getValue(int selectedRow) {
//		return rows.get(selectedRow).getValue();
//	}
//}