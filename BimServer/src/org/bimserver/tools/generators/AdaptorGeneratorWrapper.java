package org.bimserver.tools.generators;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.bimserver.shared.meta.SService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class AdaptorGeneratorWrapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(SConverterGeneratorWrapper.class);

	public void generate(Class<?> interfaceClass, SService sService) {
		File adaptorFile = new File("../PluginBase/generated/org/bimserver/shared/interfaces/" + interfaceClass.getSimpleName() + "Adaptor.java");
		AdaptorGenerator adaptorGenerator = new AdaptorGenerator();
		String generated = adaptorGenerator.generate(sService);
		try {
			OutputStream fileOutputStream = new FileOutputStream(adaptorFile);
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