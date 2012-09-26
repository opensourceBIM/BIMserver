package org.bimserver.clashdetection.bcf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.IOUtils;
import org.bimserver.bcf.markup.Markup;
import org.bimserver.bcf.visinfo.VisualizationInfo;

public class Issue {
	private byte[] imageData;
	private Markup markup;
	private VisualizationInfo visualizationInfo;
	private UUID uuid;

	public Issue(UUID uuid) {
		this.uuid = uuid;
	}

	public void setMarkup(Markup markup) {
		this.markup = markup;
	}

	public void setVisualizationInfo(VisualizationInfo visualizationInfo) {
		this.visualizationInfo = visualizationInfo;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public VisualizationInfo getVisualizationInfo() {
		return visualizationInfo;
	}

	public Markup getMarkup() {
		return markup;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void write(ZipOutputStream zipOutputStream) throws IOException, BcfException {
		ZipEntry markup = new ZipEntry(getUuid().toString() + "/markup.bcf");
		zipOutputStream.putNextEntry(markup);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Markup.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(this.markup, zipOutputStream);
		} catch (JAXBException e) {
			throw new BcfException(e);
		}

		ZipEntry visualizationInfo = new ZipEntry(getUuid().toString() + "/viewpoint.bcfv");
		zipOutputStream.putNextEntry(visualizationInfo);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(VisualizationInfo.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(this.visualizationInfo, zipOutputStream);
		} catch (JAXBException e) {
			throw new BcfException(e);
		}

		ZipEntry image = new ZipEntry(getUuid().toString() + "/snapshot.png");
		zipOutputStream.putNextEntry(image);
		ByteArrayInputStream bais = new ByteArrayInputStream(getImageData());
		IOUtils.copy(bais, zipOutputStream);
	}
}
