package org.bimserver.citygml;

import java.util.Collection;
import java.util.Vector;

import org.citygml4j.model.citygml.ade.ADEContext;
import org.citygml4j.model.citygml.ade.ADEConvertBuilder;
import org.citygml4j.model.citygml.ade.ADEModelMapper;

import ade.ObjectFactory;

public class XBuildingAdeContext implements ADEContext {
	public static final String NAMESPACE_URI = "http://www.citygml.org/ade/xbuilding";

	private Vector<Package> jaxbPackages;
	private Vector<ADEModelMapper> modelMapper;
	private Vector<ADEConvertBuilder> convertBuilder;

	public XBuildingAdeContext() {
		jaxbPackages = new Vector<Package>();
		jaxbPackages.add(ObjectFactory.class.getPackage());
		modelMapper = new Vector<ADEModelMapper>();
		modelMapper.add(new XBuildingAdeModelMapper());
	}

	@Override
	public Collection<ADEConvertBuilder> getADEConvertBuilder() {
		return convertBuilder;
	}

	@Override
	public Collection<ADEModelMapper> getADEModelMapper() {
		return modelMapper;
	}

	@Override
	public Collection<Package> getJAXBPackages() {
		return jaxbPackages;
	}

	@Override
	public String getNamespaceURI() {
		return NAMESPACE_URI;
	}
}