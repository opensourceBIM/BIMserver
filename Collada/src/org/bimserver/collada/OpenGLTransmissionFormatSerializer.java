package org.bimserver.collada;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.IOUtils;
import org.bimserver.collada.Collada2GLTFThread.Collada2GLTFConfiguration;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenGLTransmissionFormatSerializer extends EmfSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OpenGLTransmissionFormatSerializer.class);
	private ColladaSerializer colladaSerializer = null;
	private PluginManagerInterface pluginManager = null;
	private ProjectInfo projectInfo = null;
	
	// Export settings-related.
	private String returnType = ".zip";
	public Collada2GLTFConfiguration configuration = new Collada2GLTFConfiguration();
	
	// Filter files that are not directories and Collada files (.DAE).
	private static final FilenameFilter ignoreDAEFilter = new FilenameFilter()
	{
		@Override public boolean accept(File dir, String name)
		{
			File file = new File(dir, name);
			boolean notADirectory = !file.isDirectory();
			String realName = name.toLowerCase(Locale.ENGLISH);
			boolean notADAE = !realName.endsWith(".dae");
			return notADirectory && notADAE;
		}
	};
	
	//
	public OpenGLTransmissionFormatSerializer() {
		super();
	}

	public OpenGLTransmissionFormatSerializer(Collada2GLTFConfiguration configuration) {
		super();
		//
		this.configuration = configuration;
	}

	public OpenGLTransmissionFormatSerializer(Collada2GLTFConfiguration configuration, String returnType) {
		super();
		//
		this.configuration = configuration;
		this.returnType = returnType.toLowerCase(Locale.ENGLISH);
	}

	public OpenGLTransmissionFormatSerializer(String returnType) {
		super();
		//
		this.returnType = returnType.toLowerCase(Locale.ENGLISH);
	}

	//
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManagerInterface pluginManager, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, pluginManager, packageMetaData, normalizeOids);
		this.pluginManager = pluginManager;
		this.projectInfo = projectInfo;
		try {
			colladaSerializer = new ColladaSerializer();
			colladaSerializer.init(model, projectInfo, pluginManager, packageMetaData, normalizeOids);
		} catch (SerializerException e) {
			throw new SerializerException(e);
		}
		// Set the file name to be exported (after it's been serialized in the Collada serializer).
		this.configuration.fileName = projectInfo.getName() + ".dae";
	}

	@Override
	public void reset() {
		if (colladaSerializer != null)
			colladaSerializer.reset();
		//
		setMode(Mode.BODY);
	}

	@Override
	protected boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		if (getMode() == Mode.BODY) {
			Path writeDirectory = null;
			try {
				Path tempDirectory = pluginManager.getTempDir();
				if (!Files.exists(tempDirectory))
					Files.createDirectory(tempDirectory);
				//
				UUID id = UUID.randomUUID();
				writeDirectory = tempDirectory.resolve(id.toString());
				if (!Files.exists(writeDirectory)) {
					Files.createDirectories(writeDirectory);
				}
				// Export the IFC objects internally into a DAE then into the output of collada2gltf. 
				exportToGLTF(writeDirectory);
				//
				if (returnType == ".zip")
					zipTheDirectory(outputStream, writeDirectory);
				else if (returnType == ".json")
					jsonTheDirectory(outputStream, writeDirectory);
			} catch (IOException e) {
				LOGGER.error("", e);
			} finally {
				// Attempt to clean up the temporary directory created by this serializer.
				try {
					if (writeDirectory != null && Files.exists(writeDirectory)) {
						PathUtils.removeDirectoryWithContent(writeDirectory);
					}
				} catch (IOException ioe) {}
			}
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private void jsonTheDirectory(OutputStream outputStream, Path writeDirectory) throws IOException, UnsupportedEncodingException {
		OutputStream jsonOutputStream = outputStream;
		// Write the opening brace and a new-line.
		jsonOutputStream.write(String.format("{%n").getBytes());
		// Put the individual files into a JSON file.
		for (Path f : PathUtils.list(writeDirectory)) {
			addFileToJSON(jsonOutputStream, f);
		}
		// Write the closing brace.
		jsonOutputStream.write(String.format("}").getBytes());
		// Push the data into the parent stream (gets returned to the server).
		jsonOutputStream.flush();
	}

	private void addFileToJSON(OutputStream jsonOutputStream, Path f) throws IOException, UnsupportedEncodingException {
		// Use the file name as the key: file.ext
		String key = f.getFileName().toString();
		// Create a place to store the base64 bytes.
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		// Base64 encode the file.
		encodeFileToBase64Stream(f, stream);
		// Write it out as: 	"key": "data:text/plain;base64,base64-string-in-UTF-8",(new-line)
		jsonOutputStream.write(String.format("\t\"%s\": \"%s,%s\",%n", key, "data:text/plain;base64", stream.toString("UTF-8")).getBytes());
	}

	public void encodeFileToBase64Stream(Path file, OutputStream base64OutputStream) throws IOException {
		InputStream inputStream = Files.newInputStream(file);
		OutputStream out = new Base64OutputStream(base64OutputStream, true);
		IOUtils.copy(inputStream, out);
		inputStream.close();
		out.close();
	}

	private void zipTheDirectory(OutputStream outputStream, Path writeDirectory) throws IOException {
		// Create the archive.
		ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
		// Copy the files into the ZIP file.
		for (Path f : PathUtils.list(writeDirectory)) {
			addToZipFile(f, zipOutputStream);
		}
		// Push the data into the parent stream (gets returned to the server).
		zipOutputStream.finish();
		zipOutputStream.flush();
	}

	private void exportToGLTF(Path writeDirectory) throws IOException, FileNotFoundException, SerializerException {
		Path colladaFile = writeDirectory.resolve(projectInfo.getName() + ".dae");
		// Create the Collada file: example.dae
		if (!Files.exists(colladaFile)) {
			Files.createFile(colladaFile);
		}
		// Prepare to write the Collada file.
		OutputStream outputStream = Files.newOutputStream(colladaFile);
		// Write into the Collada file.
		colladaSerializer.write(outputStream, null);
		// Push the data into the stream.
		outputStream.flush();
		// Finalize the stream and close the file.
		outputStream.close();
		// Launch a thread to run the collada2gltf converter.
		Collada2GLTFThread thread = new Collada2GLTFThread(colladaFile, writeDirectory);
		synchronized (thread) {
			thread.start();
			// Force wait until the thread's subprocess is done running (i.e. the files have all been created).
			while (thread.done == false)
			{
				// Intentional no operation.
			}
		}
	}

	public void addToZipFile(Path file, ZipOutputStream outputStream) throws FileNotFoundException, IOException {
		// Get file name: example.file
		String fileName = file.getFileName().toString();
		// Create an abstraction for how it will appear in the ZIP file.
		ZipEntry zipEntry = new ZipEntry(fileName);
		// Write the file's abstraction into the ZIP file.
		outputStream.putNextEntry(zipEntry);
		// Prepare to read the actual file.
		InputStream inputStream = Files.newInputStream(file);
		// Buffer the file 4 kilobytes at a time.
		byte[] bytes = new byte[4096];
		// Read the file to its conclusion, writing out the information on the way.
		int length = 0;
		while ((length = inputStream.read(bytes)) != -1)
			outputStream.write(bytes, 0, length);
		// Close the included file stream.
		inputStream.close();
		// Close the entry in the ZIP file.
		outputStream.closeEntry();
	}
}