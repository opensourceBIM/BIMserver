package org.bimserver.cache;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileCache {
	private File cacheDir = new File("cache");
	private static final Logger LOGGER = LoggerFactory.getLogger(FileCache.class);

	public void store(int pid, int rid, String extension, SCheckoutResult checkoutResult) {
		try {
			String fileName = pid + "." + rid + "." + extension;
			File file = new File(cacheDir, fileName);
			EmfSerializer emfSerializer = (EmfSerializer) checkoutResult.getFile().getDataSource();
			FileOutputStream out = new FileOutputStream(file);
			emfSerializer.writeToOutputStream(out);
			out.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
	}

	public SCheckoutResult get(int pid, int rid, String extension) {
		String fileName = pid + "." + rid + "." + extension;
		File file = new File(cacheDir, fileName);
		SCheckoutResult checkoutResult = new SCheckoutResult();
		checkoutResult.setProjectName("" + pid);
		checkoutResult.setRevisionNr(rid);
		checkoutResult.setFile(new DataHandler(new FileDataSource(file)));
		return checkoutResult;
	}

	public boolean contains(int pid, int rid, String extension) {
		String fileName = pid + "." + rid + "." + extension;
		File file = new File(cacheDir, fileName);
		return file.exists() && file.isFile();
	}
}