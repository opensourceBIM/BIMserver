package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Charsets;

public class NetUtils {
	public static String getContent(URL url, int timeOut) throws IOException {
		URLConnection openConnection = url.openConnection();
		openConnection.setConnectTimeout(timeOut);
		openConnection.setReadTimeout(timeOut);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		InputStream in = openConnection.getInputStream();
		IOUtils.copy(in, byteArrayOutputStream);
		in.close();
		return new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8);
	}
}
