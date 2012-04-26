package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

//import java.io.FileNotFoundException;
//import java.util.Map;
//import java.util.Properties;
//
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3tc1Package;
//import org.bimserver.ifc.file.reader.IfcFileReader;
//import org.bimserver.tests.DbWriteTest.DatabaseEngine;
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EAttribute;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EPackage;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.teneo.PersistenceOptions;
//import org.eclipse.emf.teneo.hibernate.HbDataStore;
//import org.eclipse.emf.teneo.hibernate.HbHelper;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Environment;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Ifc2Db {
//	private Session session;
//	private Transaction tx;
//	private static final Logger LOGGER = LoggerFactory.getLogger(Ifc2Db.class);
//	
//	public static void main(String[] args) {
//		new Ifc2Db().start();
//	}
//
//	private void start() {
//		initDb();
//		try {
//			ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//			schemaParser.parse();
//			SchemaDefinition schemaDefinition = schemaParser.getSchema();
//			
//			Map<Long, EObject> map = new IfcFileReader().read(schemaDefinition, TestFileConstants.MERGE_TEST_SOURCE_FILE);
//			for (Long key : map.keySet()) {
//				LOGGER.info("id: " + key);
//				EObject object = map.get(key);
//				for (EAttribute attribute : object.eClass().getEAllAttributes()) {
//					Object get = object.eGet(attribute);
//					if (get != null) {
//						if (get instanceof Enum) {
//							LOGGER.info("enum");
//						} else {
//							writeObject(get);
//						}
//					}
//				}
//				for (EReference reference : object.eClass().getEAllReferences()) {
//					Object get = object.eGet(reference);
//					if (get != null) {
//						if (get instanceof EList) {
//							LOGGER.info("list");
//						} else {
//							writeObject(get);
//						}
//					}
//				}
//				writeObject(object);
//			}
//			tx.commit();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void initDb() {
//		DatabaseEngine databaseEngine = DatabaseEngine.MYSQL;
//		String hbName = "MySF"; 
//		String dbName = "ifc"; 
//		final Properties props = new Properties();
//		if (databaseEngine == DatabaseEngine.MYSQL) {
//			props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
//			props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + dbName);
//			props.setProperty(Environment.DIALECT, org.hibernate.dialect.MySQL5InnoDBDialect.class.getName());
//			props.setProperty(PersistenceOptions.MAXIMUM_SQL_NAME_LENGTH, "64");			
//		}
//		if (databaseEngine == DatabaseEngine.POSTGRESQL) {
//			props.setProperty(Environment.DRIVER, "org.postgresql.Driver");
//			props.setProperty(Environment.URL, "jdbc:postgresql://127.0.0.1:5432/" + dbName);
//			props.setProperty(Environment.DIALECT, org.hibernate.dialect.PostgreSQLDialect.class.getName());
//		}
//		props.setProperty(Environment.USER, "ifc");
//		props.setProperty(Environment.PASS, "ifc");
//		props.setProperty(PersistenceOptions.INHERITANCE_MAPPING, "JOINED");
////		props.setProperty(PersistenceOptions.USE_MAPPING_FILE, "true");
//		
//		HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);
//		hbds.setEPackages(new EPackage[]{Ifc2x3tc1Package.eINSTANCE});
//		hbds.setProperties(props);
//		hbds.initialize();
//		session = hbds.getSessionFactory().openSession();
//		
//		tx = session.getTransaction();
//		tx.begin();
//
//	}
//	
//	private void writeObject(Object object) {
//		session.save(object);
//	}
//}
