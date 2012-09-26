package org.bimserver.clashdetection.bcf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.bimserver.bcf.markup.Markup;
import org.bimserver.bcf.visinfo.VisualizationInfo;
import org.bimserver.utils.FakeClosingInputStream;

public class Bcf {
	private final Map<UUID, Issue> issues = new HashMap<UUID, Issue>();
	
	public Bcf() {
	}
	
	public static Bcf read(File file) throws BcfException, IOException {
		FileInputStream inputStream = new FileInputStream(file);
		try {
			return read(inputStream);
		} finally {
			inputStream.close();
		}
	}

	private void readInternal(InputStream inputStream) throws BcfException {
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		try {
			for (ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry()) {
				String name = zipEntry.getName();
				if (name.contains("/")) {
					String uuidString = name.substring(0, name.indexOf("/"));
					UUID uuid = UUID.fromString(uuidString);
					Issue issue = issues.get(uuid);
					if (issue == null) {
						issue = new Issue(uuid);
						issues.put(uuid, issue);
					}
					if (zipEntry.getName().endsWith(".bcf")) {
						try {
							JAXBContext jaxbContext = JAXBContext.newInstance(Markup.class);
							Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
							issue.setMarkup((Markup)unmarshaller.unmarshal(new FakeClosingInputStream(zipInputStream)));
						} catch (JAXBException e) {
							throw new BcfException(e);
						}
					} else if (zipEntry.getName().endsWith(".bcfv")) {
						try {
							JAXBContext jaxbContext = JAXBContext.newInstance(VisualizationInfo.class);
							Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
							issue.setVisualizationInfo((VisualizationInfo)unmarshaller.unmarshal(new FakeClosingInputStream(zipInputStream)));
						} catch (JAXBException e) {
							throw new BcfException(e);
						}
					} else if (zipEntry.getName().endsWith(".png")) {
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						IOUtils.copy(zipInputStream, baos);
						issue.setImageData(baos.toByteArray());
					}
				} else {
					throw new BcfException("Unexpected zipfile content");
				}
			}
			zipInputStream.close();
		} catch (IOException e) {
			throw new BcfException(e);
		}
	}
	
	public void addIssue(Issue issue) {
		issues.put(issue.getUuid(), issue);
	}
	
	public static Bcf read(InputStream inputStream) throws BcfException {
		Bcf bcf = new Bcf();
		bcf.readInternal(inputStream);
		return bcf;
	}
	
	public void write(OutputStream outputStream) throws BcfException, IOException {
		ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
		for (Issue issue : issues.values()) {
			issue.write(zipOutputStream);
		}
		zipOutputStream.finish();
		zipOutputStream.close();
	}
	
	public Collection<Issue> getIssues() {
		return issues.values();
	}
	
	public void write(File file) throws BcfException, IOException {
		FileOutputStream outputStream = new FileOutputStream(file);
		try {
			write(outputStream);
		} finally {
			outputStream.close();
		}
	}

	public byte[] toBytes() throws BcfException, IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		write(out);
		return out.toByteArray();
	}
}