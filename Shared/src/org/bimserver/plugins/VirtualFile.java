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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class VirtualFile implements JavaFileObject {

	private static final Logger LOGGER = LoggerFactory.getLogger(VirtualFile.class);
	private final Map<String, VirtualFile> files = new HashMap<String, VirtualFile>();
	private final String name;
	private byte[] data = new byte[0];
	private VirtualFile parent;
	private URI uri;
	private final Set<VirtualFile> sourceFiles = new HashSet<VirtualFile>();

	public VirtualFile() {
		this.parent = null;
		this.name = null;
	}
	
	public VirtualFile(VirtualFile parent, String name) {
		this.parent = parent;
		this.name = name;
		if (name != null & parent != null) {
			try {
				if (parent.toUri() != null) {
					this.uri = new URI(parent.toUri() + "/" + name);
				} else {
					this.uri = new URI(name.replace("\\", "/"));
				}
			} catch (URISyntaxException e) {
				LOGGER.error("", e);
			}
		} else {
			uri = null;
		}
	}

	public VirtualFile(File file) throws IOException {
		this(null, file);
	}
	
	public VirtualFile(VirtualFile parent, File file) throws IOException {
		this.parent = parent;
		this.name = file.getName();
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				files.put(f.getName(), new VirtualFile(this, f));
			}
		} else {
			setData(FileUtils.readFileToByteArray(file));
		}
	}

	public VirtualFile createFile(String path) {
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		if (path.contains(File.separator)) {
			String newName = path.substring(0, path.indexOf(File.separator));
			if (files.containsKey(newName)) {
				VirtualFile virtualFile = files.get(newName);
				return virtualFile.createFile(path.substring(path.indexOf(File.separator) + 1));
			} else {
				VirtualFile virtualFile = new VirtualFile(this, newName);
				files.put(newName, virtualFile);
				return virtualFile.createFile(path.substring(path.indexOf(File.separator) + 1));
			}
		} else {
			VirtualFile virtualFile = new VirtualFile(this, path);
			if (path.endsWith(".java")) {
				sourceFiles.add(virtualFile);
			}
			files.put(path, virtualFile);
			return virtualFile;
		}
	}

	public void setStringContent(String content) {
		data = content.getBytes(Charsets.UTF_8);
	}

	public OutputStream openOutputStream() {
		return new ByteArrayOutputStream() {
			@Override
			public void close() throws IOException {
				super.close();
				data = this.toByteArray();
			}
		};
	}

	public void createJar(OutputStream outputStream) {
		try {
			JarOutputStream jarOutputStream = new JarOutputStream(outputStream);
			createJar(jarOutputStream);
			jarOutputStream.finish();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public void dumpToDir(File dir) {
		if (isDirectory()) {
			dir.mkdir();
			for (VirtualFile virtualFile : files.values()) {
				virtualFile.dumpToDir(new File(dir, virtualFile.name));
			}
		} else {
			try {
				FileOutputStream fos = new FileOutputStream(dir);
				ByteArrayInputStream bais = new ByteArrayInputStream(data);
				IOUtils.copy(bais, fos);
				fos.close();
			} catch (FileNotFoundException e) {
				LOGGER.error("", e);
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
	}

	private void createJar(JarOutputStream jarOutputStream) throws IOException {
		for (VirtualFile virtualFile : files.values()) {
			if (virtualFile.isDirectory()) {
				virtualFile.createJar(jarOutputStream);
			} else {
				JarEntry jarEntry = new JarEntry(virtualFile.getName().replace(File.separator, "/"));
				jarOutputStream.putNextEntry(jarEntry);
				InputStream inputStream = virtualFile.openInputStream();
				IOUtils.copy(inputStream, jarOutputStream);
				inputStream.close();
			}
		}
	}

	public InputStream openInputStream() {
		return new ByteArrayInputStream(data);
	}

	public Collection<VirtualFile> listFiles() {
		return files.values();
	}

	public boolean isDirectory() {
		return files.size() != 0;
	}

	public String getName() {
		if (parent != null && parent.getName() != null) {
			return parent.getName() + "/" + name;
		} else {
			return name;
		}
	}

	public List<VirtualFile> getAllJavaFileObjects() {
		List<VirtualFile> list = new ArrayList<VirtualFile>(sourceFiles);
		for (VirtualFile virtualFile : files.values()) {
			if (virtualFile.isDirectory()) {
				list.addAll(virtualFile.getAllJavaFileObjects());
			}
		}
		return list;
	}

	@Override
	public Modifier getAccessLevel() {
		return Modifier.PUBLIC;
	}

	@Override
	public Kind getKind() {
		if (name.endsWith(".java")) {
			return Kind.SOURCE;
		} else if (name.endsWith(".class")) {
			return Kind.CLASS;
		} else if (name.endsWith(".html")) {
			return Kind.HTML;
		} else {
			return Kind.OTHER;
		}
	}

	@Override
	public NestingKind getNestingKind() {
		return NestingKind.TOP_LEVEL;
	}

	@Override
	public boolean isNameCompatible(String simpleName, Kind kind) {
		return true;
	}

	@Override
	public boolean delete() {
		return parent.remove(this);
	}

	private boolean remove(VirtualFile virtualFile) {
		return files.remove(virtualFile.getName()) != null;
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
		return new String(data, Charsets.UTF_8);
	}

	@Override
	public long getLastModified() {
		return 0;
	}

	@Override
	public Reader openReader(boolean ignoreEncodingErrors) {
		return new StringReader(new String(data, Charsets.UTF_8));
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
	public URI toUri() {
		return uri;
	}

	public String getPackageName() {
		String name = getName();
		return name.replace("/", ".");
	}

	public Collection<VirtualFile> getFiles() {
		return files.values();
	}

	public Collection<VirtualFile> getFiles(Set<Kind> kinds) {
		ArrayList<VirtualFile> list = new ArrayList<VirtualFile>();
		for (VirtualFile f : files.values()) {
			for (Kind kind : kinds) {
				if (f.name.endsWith(kind.extension.toLowerCase())) {
					if (f.name.endsWith(".class")) {
						list.add(f);
					}
				}
			}
		}
		return list;
	}

	public void integrate(VirtualFile baseDir) {
		if (baseDir.isDirectory()) {
			for (VirtualFile file : baseDir.getFiles()) {
				if (files.containsKey(file.name)) {
					if (file.isDirectory()) {
						files.get(file.name).integrate(file);
					} else {
						files.get(file.name).add(file);
					}
				} else {
					files.put(file.name, file);
					file.parent = this;
				}
			}
		}
	}

	private void add(VirtualFile file) {
		files.put(file.name, file);
	}

	@Override
	public String toString() {
		return uri.toString();
	}

	public Collection<VirtualFile> getFiles(Set<Kind> kinds, String path) {
		if (path.contains("/")) {
			String substring = path.substring(0, path.indexOf("/"));
			if (files.containsKey(substring)) {
				return files.get(substring).getFiles(kinds, path.substring(path.indexOf("/") + 1));
			}
		} else {
			if (files.containsKey(path)) {
				return files.get(path).getFiles(kinds);
			}
		}
		return new ArrayList<VirtualFile>();
	}

	public String getSimpleName() {
		return name;
	}

	public String getCleanName() {
		String name = getName();
		if (name.contains(".")) {
			name = name.substring(0, name.indexOf("."));
		}
		return name.replace("/", ".");
	}

	public boolean containsType(String path) {
		if (path.contains("/")) {
			String newName = path.substring(0, path.indexOf("/"));
			if (files.containsKey(newName)) {
				return files.get(newName).containsType(path.substring(path.indexOf("/") + 1));
			} else {
				return false;
			}
		} else {
			return files.containsKey(path);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VirtualFile other = (VirtualFile) obj;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	public VirtualFile get(String name) {
		return files.get(name);
	}

	public VirtualFile getClass(String name) {
		if (name.contains(".")) {
			VirtualFile virtualFile = files.get(name.substring(0, name.indexOf(".")));
			if (virtualFile == null) {
				throw new RuntimeException("Not found: " + name);
			}
			return virtualFile.getClass(name.substring(name.indexOf(".") + 1));
		}
		return files.get(name + ".class");
	}
	
	public byte[] getData() {
		return data;
	}

	public static VirtualFile fromJar(File file) throws IOException {
		return fromJar(new FileInputStream(file));
	}

	public static VirtualFile fromJar(InputStream inputStream) throws IOException {
		VirtualFile result = new VirtualFile();
		JarInputStream jarInputStream = new JarInputStream(inputStream);
		JarEntry jarEntry = jarInputStream.getNextJarEntry();
		while (jarEntry != null) {
			String n = jarEntry.getName();
			n = n.replace("/", File.separator);
			n = n.replace("\\", File.separator);
			VirtualFile newFile = result.createFile(n);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			IOUtils.copy(jarInputStream, byteArrayOutputStream);
			newFile.setData(byteArrayOutputStream.toByteArray());
			jarEntry = jarInputStream.getNextJarEntry();
		}
		return result;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}

	public void add(File file) {
		
	}
	
	public static VirtualFile fromDirectory(File file) throws IOException {
		return new VirtualFile(file);
	}

	public void copyTo(VirtualFile virtualFile) {
		// TODO
	}

	public void setData(InputStream inputStream) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		IOUtils.copy(inputStream, output);
		setData(output.toByteArray());
		inputStream.close();
	}
}