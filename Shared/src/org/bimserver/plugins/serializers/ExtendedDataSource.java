package org.bimserver.plugins.serializers;

import java.io.IOException;
import java.io.OutputStream;

import javax.activation.DataSource;

import org.bimserver.BimserverDatabaseException;

public abstract class ExtendedDataSource implements DataSource {
	public abstract void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException, IOException, BimserverDatabaseException;
}
