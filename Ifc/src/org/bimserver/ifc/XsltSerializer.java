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

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.xml.writer.IfcXmlSerializer;
import org.bimserver.shared.ResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XsltSerializer extends BimModelSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(XsltSerializer.class);
	private final SchemaDefinition schemaDefinition;
	private final URL xsltUrl;
	private final XsltParameter[] parameters;
	private final ResultType resultType;

	public XsltSerializer(String fileName, IfcModel model, FieldIgnoreMap fieldIgnoreMap, SchemaDefinition schemaDefinition, URL xsltUrl, ResultType resultType,
			XsltParameter... parameters) {
		super(fileName, model, fieldIgnoreMap);
		this.schemaDefinition = schemaDefinition;
		this.xsltUrl = xsltUrl;
		this.resultType = resultType;
		this.parameters = parameters;
	}

	@Override
	protected void reset() {
		setMode(Mode.BODY);
	}
	
	@Override
	protected boolean write(OutputStream outputStream) throws SerializerException {
		IfcXmlSerializer ifcXmlSerializer = new IfcXmlSerializer(getName(), model, schemaDefinition);
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