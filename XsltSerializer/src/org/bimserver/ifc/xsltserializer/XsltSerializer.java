package org.bimserver.ifc.xsltserializer;

import java.io.OutputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.BimModelSerializer;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XsltSerializer extends BimModelSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(XsltSerializer.class);
	private URL xsltUrl;
	private Set<XsltParameter> parameters = new HashSet<XsltParameter>();

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException {
		super.init(model, projectInfo, pluginManager);
	}

	public void setXsltUrl(URL url) {
		xsltUrl = url;
	}

	@Override
	protected void reset() {
		setMode(Mode.BODY);
	}

	@Override
	protected boolean write(OutputStream outputStream) throws SerializerException {
		switch (getMode()) {
		case BODY:
			SerializerPlugin plugin = (SerializerPlugin) getPluginManager().getPlugin("org.bimserver.ifc.xml.serializer.IfcXmlSerializerPlugin", true);
			EmfSerializer ifcXmlSerializer = plugin.createSerializer();
			ifcXmlSerializer.init(model, null, getPluginManager());
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
					outputStream.flush();
				} catch (TransformerConfigurationException e) {
					throw new SerializerException(e);
				} catch (TransformerException e) {
					throw new SerializerException(e);
				}
			} catch (Throwable e) {
				throw new SerializerException(e);
			}
			setMode(Mode.FINISHED);
			return true;
		case FINISHED:
			return false;
		}
		return false;
	}

	public void addParameter(XsltParameter xsltParameter) {
		parameters.add(xsltParameter);
	}
}