package org.bimserver.plugins;

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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import com.google.common.base.Charsets;

public class PhysicalJavaFileObject implements JavaFileObject {

	private final File file;
	private byte[] data;

	public PhysicalJavaFileObject(File file) throws IOException {
		this.file = file;
		if (file.isFile()) {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			IOUtils.copy(fis, byteArrayOutputStream);
			data = byteArrayOutputStream.toByteArray();
		}
	}

	@Override
	public URI toUri() {
		return file.toURI();
	}

	@Override
	public String getName() {
		return file.getName();
	}

	@Override
	public InputStream openInputStream() throws IOException {
		return new ByteArrayInputStream(data);
	}

	@Override
	public OutputStream openOutputStream() throws IOException {
		return new ByteArrayOutputStream() {
			@Override
			public void close() throws IOException {
				super.close();
				data = this.toByteArray();
			}
		};
	}

	@Override
	public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
		return new StringReader(new String(data, Charsets.UTF_8));
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return new String(data, Charsets.UTF_8);
	}

	@Override
	public Writer openWriter() throws IOException {
		return new StringWriter() {
			@Override
			public void close() throws IOException {
				super.close();
				data = this.toString().getBytes(Charsets.UTF_8);
			}
		};
	}

	@Override
	public long getLastModified() {
		return file.lastModified();
	}

	@Override
	public boolean delete() {
		return file.delete();
	}

	@Override
	public Kind getKind() {
		if (file.getName().endsWith(".java")) {
			return Kind.SOURCE;
		} else if (file.getName().endsWith(".class")) {
			return Kind.CLASS;
		} else if (file.getName().endsWith(".html")) {
			return Kind.HTML;
		}
		return Kind.OTHER;
	}

	@Override
	public boolean isNameCompatible(String simpleName, Kind kind) {
		return true;
	}

	@Override
	public NestingKind getNestingKind() {
		return NestingKind.TOP_LEVEL;
	}

	@Override
	public Modifier getAccessLevel() {
		return Modifier.PUBLIC;
	}

	public String getCleanName() {
		String name = getName();
		if (name.contains(".")) {
			name = name.substring(0, name.indexOf("."));
		}
		return name.replace(File.separator, ".");
	}
}