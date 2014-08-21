package org.bimserver.serializers.ifctordf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

import fi.ni.ExpressReader;
import fi.ni.IFC_ClassModel;

public class IfcToRdfSerializer extends EmfSerializer {

	private File expressFile;

	@Override
	public void reset() {
	}

	public IfcToRdfSerializer(File expressFile) {
		this.expressFile = expressFile;
	}
	
	@Override
	protected boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		// Quite inefficient, first write the model to IFC (byte buffer), then call the IfcToRdf code

		SerializerPlugin serializerPlugin = getPluginManager().getSerializerPlugin("org.bimserver.ifc.step.serializer.Ifc2x3tc1StepSerializerPlugin", true);
		Serializer serializer = serializerPlugin.createSerializer(null);
		serializer.init(getModel(), null, getPluginManager(), null, getPackageMetaData(), true);
		ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
		serializer.writeToOutputStream(outputStream2, progressReporter);
		InputStream inputStream = new ByteArrayInputStream(outputStream2.toByteArray());
		String fileName = "test.ifc";
		ExpressReader er = new ExpressReader(expressFile.getAbsolutePath());
		IFC_ClassModel model = new IFC_ClassModel(fileName, inputStream, er.getEntities(), er.getTypes(), "model name");
		try {
			model.listRDF(outputStream, "ifc", null);
		} catch (IOException e) {
			throw new SerializerException(e);
		} catch (SQLException e) {
			throw new SerializerException(e);
		}
		return false;
	}
}