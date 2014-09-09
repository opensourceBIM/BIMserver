package org.bimserver.serializers.ifctordf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Collection;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

import fi.ni.ExpressReader;
import fi.ni.IFC_ClassModel;
import fi.ni.rdf.VirtConfig;

public class IfcToRdfSerializer extends EmfSerializer {

	private File expressFile;

	@Override
	public void reset() {
	}

	public IfcToRdfSerializer(File expressFile) {
		this.expressFile = expressFile;
	}
	
	@Override
	protected boolean write(OutputStream outputStream) throws SerializerException {
		Collection<SerializerPlugin> serializerPlugins = getPluginManager().getAllSerializerPlugins(true);
		SerializerPlugin serializerPlugin = serializerPlugins.iterator().next();
		Serializer serializer = serializerPlugin.createSerializer(null);
		serializer.init(getModel(), null, getPluginManager(), null, null, true);
		ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
		serializer.writeToOutputStream(outputStream2);
		InputStream inputStream = new ByteArrayInputStream(outputStream2.toByteArray());
		String fileName = "test.ifc";
		ExpressReader er = new ExpressReader(expressFile.getAbsolutePath());
		IFC_ClassModel model = new IFC_ClassModel(fileName, inputStream, er.getEntities(), er.getTypes(), "model name");
		try {
			VirtConfig virtConfig = new VirtConfig();
			model.listRDF(outputStream, "", virtConfig);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}