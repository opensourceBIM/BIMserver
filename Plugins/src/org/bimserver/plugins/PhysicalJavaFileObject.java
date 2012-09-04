package org.bimserver.plugins;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public PhysicalJavaFileObject(File file) {
		this.file = file;
		try {
			if (file.isFile()) {
				FileInputStream fis = new FileInputStream(file);
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				IOUtils.copy(fis, byteArrayOutputStream);
				data = byteArrayOutputStream.toByteArray();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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