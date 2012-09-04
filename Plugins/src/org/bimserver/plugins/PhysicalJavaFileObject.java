package org.bimserver.plugins;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;

public class PhysicalJavaFileObject implements JavaFileObject {

	private final File file;

	public PhysicalJavaFileObject(File file) {
		this.file = file;
	}

	@Override
	public URI toUri() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public InputStream openInputStream() throws IOException {
		return null;
	}

	@Override
	public OutputStream openOutputStream() throws IOException {
		return null;
	}

	@Override
	public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
		return null;
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return null;
	}

	@Override
	public Writer openWriter() throws IOException {
		return null;
	}

	@Override
	public long getLastModified() {
		return 0;
	}

	@Override
	public boolean delete() {
		return false;
	}

	@Override
	public Kind getKind() {
		return null;
	}

	@Override
	public boolean isNameCompatible(String simpleName, Kind kind) {
		return false;
	}

	@Override
	public NestingKind getNestingKind() {
		return null;
	}

	@Override
	public Modifier getAccessLevel() {
		return null;
	}

	public String getCleanName() {
		return null;
	}
}