package org.bimserver.collada;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.BimModelSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KmzSerializer extends BimModelSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KmzSerializer.class);
	private ColladaSerializer ifcToCollada;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException {
		super.init(model, projectInfo, pluginManager);
		try {
			ifcToCollada = new ColladaSerializer();
			ifcToCollada.init(model, projectInfo, pluginManager);
		} catch (SerializerException e) {
			throw new SerializerException(e);
		}
	}

	@Override
	protected void reset() {
		setMode(Mode.BODY);
	}
	
	@Override
	public boolean write(OutputStream out) throws SerializerException {
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
		writer.println("	<name>" + getProjectInfo().getName() + "</name>");
		writer.println("	<description>" + getProjectInfo().getDescription() + "</description>");
		writer.println("	<LookAt>");
		writer.println("		<longitude>" + getProjectInfo().getX() + "</longitude>");
		writer.println("		<latitude>" + getProjectInfo().getY() + "</latitude>");
		writer.println("		<altitude>0</altitude>");
		writer.println("		<heading>-27.70337734057933</heading>");
		writer.println("		<tilt>65.74454495876547</tilt>");
		writer.println("		<range>127.2393107680517</range>");
		writer.println("	</LookAt>");
		writer.println("	<Model id=\"model_4\">");
		writer.println("		<altitudeMode>relativeToGround</altitudeMode>");
		writer.println("		<Location>");
		writer.println("			<longitude>" + getProjectInfo().getX() + "</longitude>");
		writer.println("			<latitude>" + getProjectInfo().getY() + "</latitude>");
		writer.println("			<altitude>" + getProjectInfo().getZ() + "</altitude>");
		writer.println("		</Location>");
		writer.println("		<Orientation>");
		writer.println("			<heading>" + getProjectInfo().getDirectionAngle() + "</heading>");
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