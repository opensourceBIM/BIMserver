package org.bimserver.tools.generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class SConverterGeneratorWrapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(SConverterGeneratorWrapper.class);
	private File sourceFolder = new File("../BimServer/generated");
	private File packageFolder = new File(sourceFolder, "org" + File.separator + "bimserver" + File.separator + "interfaces");

	public static void main(String[] args) {
		Set<EPackage> ePackages = new HashSet<EPackage>();
		ePackages.add(StorePackage.eINSTANCE);
		ePackages.add(LogPackage.eINSTANCE);
		new SConverterGeneratorWrapper().generate(ePackages);
	}

	public void generate(Set<EPackage> ePackages) {
		try {
			FileUtils.forceMkdir(packageFolder);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		SConverterGenerator converterGenerator = new SConverterGenerator();
		String generated = converterGenerator.generate(ePackages);
		File file = new File(packageFolder, "SConverter.java");
		try {
			OutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(generated.getBytes(Charsets.UTF_8));
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
}