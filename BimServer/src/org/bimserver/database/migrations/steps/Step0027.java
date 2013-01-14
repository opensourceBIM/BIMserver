package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0027 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass systemInfo = schema.createEClass("store", "SystemInfo");
		schema.createEAttribute(systemInfo, "cpucores", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(systemInfo, "datetime", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(systemInfo, "osname", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(systemInfo, "osversion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(systemInfo, "userName", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(systemInfo, "userHome", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(systemInfo, "userDir", EcorePackage.eINSTANCE.getEString());
		
		EClass javaInfo = schema.createEClass("store", "JavaInfo");
		schema.createEAttribute(javaInfo, "heapTotal", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(javaInfo, "heapUsed", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(javaInfo, "heapFree", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(javaInfo, "heapMax", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(javaInfo, "threads", EcorePackage.eINSTANCE.getEInt());

		schema.createEAttribute(javaInfo, "javaHome", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaVendor", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaVendorurl", EcorePackage.eINSTANCE.getEString());
		
		schema.createEAttribute(javaInfo, "javavmVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javavmVendor", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javavmName", EcorePackage.eINSTANCE.getEString());

		schema.createEAttribute(javaInfo, "javaspecVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaspecVendor", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaspecName", EcorePackage.eINSTANCE.getEString());

		schema.createEAttribute(javaInfo, "javaClassVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaClasspath", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(javaInfo, "javaLibrarypath", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(javaInfo, "javaIoTmp", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaCompiler", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaExtdir", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaFileSeparator", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaPathSeparator", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaLineSeparator", EcorePackage.eINSTANCE.getEString());

		EClass bimserverInfo = schema.createEClass("store", "BimServerInfo");
		schema.createEAttribute(bimserverInfo, "currentVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(bimserverInfo, "currentDate", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(bimserverInfo, "schemaVersion", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "latestDate", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(bimserverInfo, "latestVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(bimserverInfo, "projects", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "revisions", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "users", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "checkouts", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "serverLogUrl", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(bimserverInfo, "started", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(bimserverInfo, "uptime", EcorePackage.eINSTANCE.getEString());
	}

	@Override
	public String getDescription() {
		return "Server information classes";
	}
}