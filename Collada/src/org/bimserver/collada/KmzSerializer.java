package org.bimserver.collada;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.plugins.ifcengine.IfcEngineFactory;
import org.bimserver.plugins.serializers.BimModelSerializer;
import org.bimserver.plugins.serializers.PackageDefinition;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KmzSerializer extends BimModelSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KmzSerializer.class);
	private ColladaSerializer ifcToCollada;
	private Project project;

	public void init(Project project, User user, String fileName, IfcModel model, SchemaDefinition schemaDefinition, FieldIgnoreMap fieldIgnoreMap, IfcEngineFactory ifcEngineFactory, PackageDefinition packageDefinition) throws SerializerException {
		super.init(fileName, model, fieldIgnoreMap);
		this.project = project;
		try {
			ifcToCollada = new ColladaSerializer();
			ifcToCollada.init(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory, packageDefinition);
		} catch (SerializerException e) {
			throw new SerializerException(e);
		}
	}

	@Override
	protected void reset() {
		setMode(Mode.BODY);
	}
	
	@Override
	public boolean write(OutputStream out) {
		if (getMode() == Mode.BODY) {
			try {
				ZipOutputStream zipOutputStream = new ZipOutputStream(out);
				zipOutputStream.putNextEntry(new ZipEntry("doc.kml"));
				writeKmlFile(zipOutputStream);
				zipOutputStream.closeEntry();
				zipOutputStream.putNextEntry(new ZipEntry("files/collada.dae"));
				ifcToCollada.write(zipOutputStream);
				zipOutputStream.closeEntry();
				zipOutputStream.finish();
				zipOutputStream.flush();
			} catch (IOException e) {
				LOGGER.error("", e);
			}
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private void writeKmlFile(OutputStream out) {
		PrintWriter writer = new PrintWriter(out);
		writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.println("<kml xmlns=\"http://earth.google.com/kml/2.1\">");
		writer.println("<Placemark>");
		writer.println("	<name>" + project.getName() + "</name>");
		writer.println("	<description>" + project.getDescription() + "</description>");
		writer.println("	<LookAt>");
		writer.println("		<longitude>" + project.getGeoTag().getX() + "</longitude>");
		writer.println("		<latitude>" + project.getGeoTag().getY() + "</latitude>");
		writer.println("		<altitude>0</altitude>");
		writer.println("		<heading>-27.70337734057933</heading>");
		writer.println("		<tilt>65.74454495876547</tilt>");
		writer.println("		<range>127.2393107680517</range>");
		writer.println("	</LookAt>");
		writer.println("	<Model id=\"model_4\">");
		writer.println("		<altitudeMode>relativeToGround</altitudeMode>");
		writer.println("		<Location>");
		writer.println("			<longitude>" + project.getGeoTag().getX() + "</longitude>");
		writer.println("			<latitude>" + project.getGeoTag().getY() + "</latitude>");
		writer.println("			<altitude>" + project.getGeoTag().getZ() + "</altitude>");
		writer.println("		</Location>");
		writer.println("		<Orientation>");
		writer.println("			<heading>" + project.getGeoTag().getDirectionAngle() + "</heading>");
		writer.println("			<tilt>0</tilt>");
		writer.println("			<roll>0</roll>");
		writer.println("		</Orientation>");
		writer.println("		<Scale>");
		writer.println("			<x>1</x>");
		writer.println("			<y>1</y>");
		writer.println("			<z>1</z>");
		writer.println("		</Scale>");
		writer.println("		<Link>");
		writer.println("			<href>files/collada.dae</href>");
		writer.println("		</Link>");
		writer.println("	</Model>");
		writer.println("</Placemark>");
		writer.println("</kml>");
		writer.flush();
	}
}