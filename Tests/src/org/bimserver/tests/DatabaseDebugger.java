package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//import java.util.Set;
//import java.util.TreeSet;
//
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.ListSelectionModel;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
//import org.bimserver.emf2codb.ColumnDatabase;
//import org.bimserver.emf2codb.FileFieldIgnoreMap;
//import org.bimserver.emf2codb.Record;
//import org.bimserver.emf2codb.RecordIterator;
//import org.bimserver.emf2codb.berkeley.BerkeleyColumnDatabase;
//import org.bimserver.emf2codb.store.StorePackage;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3tc1Package;
//import org.bimserver.utils.BinUtils;
//import org.bimserver.utils.DoubleHashMap;
//import org.bimserver.utils.SwingUtil;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EClassifier;
//import org.eclipse.emf.ecore.EPackage;
//
//public class DatabaseDebugger extends JFrame {
//
//	private static final long serialVersionUID = 1778542332785180639L;
//	private ColumnDatabase columnDatabase;
//	private static final String CLASS_LOOKUP_TABLE = "INT-ClassLookup";
//	private final DoubleHashMap<Short, EClass> classifiers = new DoubleHashMap<Short, EClass>();
//	private final Set<EPackage> emfPackages = new HashSet<EPackage>();
//	private FileFieldIgnoreMap fieldIgnoreMap;
//
//	public static void main(String[] args) {
//		new DatabaseDebugger().setVisible(true);
//	}
//
//	public DatabaseDebugger() {
//		SwingUtil.setLookAndFeelToNice();
//		setTitle("Database Debugger");
//		setSize(800, 480);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		this.emfPackages.add(StorePackage.eINSTANCE);
//		this.emfPackages.add(Ifc2x3tc1Package.eINSTANCE);
//		
//		try {
//			fieldIgnoreMap = new FileFieldIgnoreMap(emfPackages, Paths.get("../BimServer/www/WEB-INF/ignore.xml").toURI().toURL());
//		} catch (MalformedURLException e1) {
//			e1.printStackTrace();
//		}
//
//		columnDatabase = new BerkeleyColumnDatabase(Paths.get("../BimServer/database"));
//		initInternalStructure();
//
//		JPanel selectPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
//		JLabel selectLabel = new JLabel("Table");
//		selectPanel.add(selectLabel);
//		final JComboBox comboBox = new JComboBox();
//		Set<EClass> keyBSet = classifiers.keyBSet();
//		Set<EClass> newSet = new TreeSet<EClass>(new Comparator<EClass>(){
//			@Override
//			public int compare(EClass o1, EClass o2) {
//				return o1.getName().compareTo(o2.getName());
//			}});
//		newSet.addAll(keyBSet);
//		for (EClass eClass : newSet) {
//			comboBox.addItem(new EClassContainer(eClass));
//		}
//		final TableModel model = new TableModel(columnDatabase, classifiers);
//		final JTable table = new JTable(model);
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		comboBox.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				model.update(((EClassContainer) comboBox.getSelectedItem()).getEClass());
//			}
//		});
//		selectPanel.add(comboBox);
//		final DetailsPanel details = new DetailsPanel(fieldIgnoreMap);
//		final JPanel bottom = new JPanel(new BorderLayout());
//		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				if (table.getSelectedRow() == -1) {
//					details.clear();
//				} else {
//					details.init(((EClassContainer) comboBox.getSelectedItem()).getEClass(), model.getValue(table.getSelectedRow()));
//					bottom.paintComponents(bottom.getGraphics());
//				}
//			}});
//
//		JScrollPane scroll = new JScrollPane(table);
//
//		JPanel left = new JPanel(new BorderLayout());
//		left.add(scroll, BorderLayout.CENTER);
//		bottom.add(left, BorderLayout.WEST);
//		bottom.add(details, BorderLayout.CENTER);
//
//		getContentPane().setLayout(new BorderLayout());
//		getContentPane().add(selectPanel, BorderLayout.NORTH);
//		getContentPane().add(bottom, BorderLayout.CENTER);
//	}
//
//	private class EClassContainer {
//		private final EClass eClass;
//
//		public EClassContainer(EClass eClass) {
//			this.eClass = eClass;
//		}
//
//		@Override
//		public String toString() {
//			return eClass.getName();
//		}
//
//		public EClass getEClass() {
//			return eClass;
//		}
//	}
//
//	public void initInternalStructure() {
//		RecordIterator recordIterator = columnDatabase.getRecordIterator(CLASS_LOOKUP_TABLE);
//		Record record = recordIterator.next();
//		while (record != null) {
//			String string = BinUtils.byteArrayToString(record.getValue());
//			EClass eClass = (EClass) getEClassifier(string);
//			classifiers.put(BinUtils.byteArrayToShort(record.getKey()), eClass);
//			record = recordIterator.next();
//		}
//		recordIterator.close();
//	}
//
//	private EClassifier getEClassifier(String classifierName) {
//		for (EPackage ePackage : emfPackages) {
//			if (ePackage.getEClassifier(classifierName) != null) {
//				return ePackage.getEClassifier(classifierName);
//			}
//		}
//		return null;
//	}
//}