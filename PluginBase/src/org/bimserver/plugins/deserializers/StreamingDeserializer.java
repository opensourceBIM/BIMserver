package org.bimserver.plugins.deserializers;

import java.io.InputStream;
import java.util.Map;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.shared.QueryContext;
import org.eclipse.emf.ecore.EClass;

public interface StreamingDeserializer {
	void init(PackageMetaData packageMetaData);
	void setProgressReporter(ByteProgressReporter byteProgressReporter);
	long read(InputStream inputStream, String fileName, long fileSize, QueryContext reusable) throws DeserializeException;
	IfcHeader getIfcHeader();
	Map<EClass, Integer> getSummaryMap();
}
