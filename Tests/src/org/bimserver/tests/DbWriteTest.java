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

//import java.util.Properties;
//
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3tc1Package;
//import org.eclipse.emf.ecore.EPackage;
//import org.eclipse.emf.teneo.PersistenceOptions;
//import org.eclipse.emf.teneo.hibernate.HbDataStore;
//import org.eclipse.emf.teneo.hibernate.HbHelper;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Environment;
//
//public class DbWriteTest {
//	public enum DatabaseEngine {
//		MYSQL,
//		POSTGRESQL
//	}
//	
//	public static void main(String[] args) {
//		new DbWriteTest().taneo();
//	}
//	
//	private void taneo() {
//		DatabaseEngine databaseEngine = DatabaseEngine.MYSQL;
//		
//		// the name of the datastore
//		String hbName = "MySF"; 
//
//		// the name of the database, this database should exist but does not need to contain tables
//		String dbName = "ifc"; 
//
//		// Set the database information, Environment is org.hibernate.cfg.Environment
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
//		// create the HbDataStore
//		HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);
//
//		// sets its epackages stored in this datastore
//		hbds.setEPackages(new EPackage[]{Ifc2x3tc1Package.eINSTANCE});
//
//		// set the relational database to use and other properties
//		hbds.setProperties(props);
//
//		// initialize, also creates the database tables
//		hbds.initialize();
//		
//		// Create a session and a transaction
//		Session session = hbds.getSessionFactory().openSession();
//		Transaction tx = session.getTransaction();
//
//		// start a transaction, create a library and make it persistent
//		tx.begin();
//
////		IfcWall wall = Ifc2x3tc1Factory.eINSTANCE.createIfcWall();
////		IfcText description = Ifc2x3tc1Factory.eINSTANCE.createIfcText();
////		session.save(description);
////		description.setWrappedValue("test");
////		wall.setDescription(description );
////		IfcLabel label = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
////		label.setWrappedValue("test");
////		session.save(label);
////		wall.setName(label);
////		session.save(wall);
//		
////		IfcRoot ifcRoot = Ifc2x3tc1Factory.eINSTANCE.createIfcRoot();
////		IfcText createIfcText = Ifc2x3tc1Factory.eINSTANCE.createIfcText();
////		createIfcText.setWrappedValue("Test");
////		ifcRoot.setDescription(createIfcText);
////		session.save(ifcRoot);
//		
//		//		
////		Library lib = LibraryFactory.eINSTANCE.createLibrary();
////		lib.setName("My Library");
////		session.save(lib);
////
////		// create a writer
////		Writer writer = LibraryFactory.eINSTANCE.createWriter();
////		writer.setName("JRR Tolkien");
////			       
////		// and one of his books
////		Book book = LibraryFactory.eINSTANCE.createBook();
////		book.setAuthor(writer);
////		book.setPages(305);
////		book.setTitle("The Hobbit");
////		book.setCategory(BookCategory.SCIENCE_FICTION);
////			
////		// add the writer/book to the library. The writer and book are automatically
////		// made persistent because they are added to the library which is already
////		// made persistent
////		lib.getWriters().add(writer);
////		lib.getBooks().add(book);
////			        
////		// at commit the objects will be present in the database
//
//		tx.commit();
//
////		Query query = session.createQuery("SELECT wall FROM IfcWall wall WHERE "
////				+ " wall.name.embeddedValue='test'");
////		System.out.prinde btln(query.list().size());
////		
////		List list = session.createCriteria(IfcWallImpl.class).add(Restrictions.eq("name", "test")).list();
//		
//		// and close of 
//		session.close();
//	}
//	
//}
