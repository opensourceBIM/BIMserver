package org.bimserver.ifc;

import java.io.OutputStream;
import java.net.URL;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.bimserver.ifc.xml.serializer.IfcXmlSerializer;
import org.bimserver.plugins.ifcengine.IfcEngineFactory;
import org.bimserver.plugins.ignoreproviders.IgnoreProvider;
import org.bimserver.plugins.schema.Schema;
import org.bimserver.plugins.serializers.BimModelSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XsltSerializer extends BimModelSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(XsltSerializer.class);
	private URL xsltUrl;
	private XsltParameter[] parameters;

	@Override
	public void init(IfcModelInterface model, Schema schema, IgnoreProvider ignoreProvider, IfcEngineFactory ifcEngineFactory, ProjectInfo projectInfo) throws SerializerException {
		super.init(model, schema, ignoreProvider, ifcEngineFactory, projectInfo);
	}

	@Override
	protected void reset() {
		setMode(Mode.BODY);
	}
	
	@Override
	protected boolean write(OutputStream outputStream) throws SerializerException {
		IfcXmlSerializer ifcXmlSerializer = new IfcXmlSerializer();
		ifcXmlSerializer.init(model, getSchema(), getIgnoreProvider(), getIfcEngineFactory(), null);
		TransformerFactory factory = TransformerFactory.newInstance();

		try {
			StreamSource xslStream = new StreamSource(xsltUrl.openStream());
			try {
				Transformer transformer = factory.newTransformer(xslStream);
				for (XsltParameter xsltParameter : parameters) {
					transformer.setParameter(xsltParameter.getKey(), xsltParameter.getValue());
				}
				transformer.setErrorListener(new ErrorListener() {

					@Override
					public void warning(TransformerException e) throws TransformerException {
					}

					@Override
					public void fatalError(TransformerException e) throws TransformerException {
						LOGGER.error("", e);
					}

					@Override
					public void error(TransformerException e) throws TransformerException {
						LOGGER.error("", e);
					}
				});

				StreamSource in = new StreamSource(ifcXmlSerializer.getInputStream());
				StreamResult out = new StreamResult(outputStream);
				transformer.transform(in, out);
			} catch (TransformerConfigurationException e) {
				throw new SerializerException(e);
			} catch (TransformerException e) {
				throw new SerializerException(e);
			}
		} catch (Throwable e) {
			throw new SerializerException(e);
		}
		return false;
	}
}