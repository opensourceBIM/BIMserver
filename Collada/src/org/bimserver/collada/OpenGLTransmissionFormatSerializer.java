package org.bimserver.collada;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcFeatureElementSubtraction;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class OpenGLTransmissionFormatSerializer extends EmfSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OpenGLTransmissionFormatSerializer.class);
	private ColladaSerializer colladaSerializer = null;
	private PluginManager pluginManager = null;
	private ProjectInfo projectInfo = null;

	// Export settings-related.
	private String returnType = ".zip";
	public Collada2GLTFConfiguration configuration = new Collada2GLTFConfiguration();
	public boolean wantJSONPrettyPrint = false;
	public boolean wantSinglePass = true;

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

	// Filter to get files that end in ".glsl".
	private static final FilenameFilter getOnlyGLSLFilesFilter = new FilenameFilter()
	{
		@Override public boolean accept(File dir, String name)
		{
			File file = new File(dir, name);
			boolean notADirectory = !file.isDirectory();
			String realName = name.toLowerCase(Locale.ENGLISH);
			boolean isGLSL = realName.endsWith(".glsl");
			return notADirectory && isGLSL;
		}
	};

	// Filter to get files that end in ".json".
	private static final FilenameFilter getOnlyJSONFilesFilter = new FilenameFilter()
	{
		@Override public boolean accept(File dir, String name)
		{
			File file = new File(dir, name);
			boolean notADirectory = !file.isDirectory();
			String realName = name.toLowerCase(Locale.ENGLISH);
			boolean isJSON = realName.endsWith(".json");
			return notADirectory && isJSON;
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

	public OpenGLTransmissionFormatSerializer(Collada2GLTFConfiguration configuration, String returnType, boolean wantSinglePass) {
		super();
		//
		this.configuration = configuration;
		this.returnType = returnType.toLowerCase(Locale.ENGLISH);
		this.wantSinglePass = wantSinglePass;
	}

	public OpenGLTransmissionFormatSerializer(String returnType) {
		super();
		//
		this.returnType = returnType.toLowerCase(Locale.ENGLISH);
	}

	//
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, pluginManager, renderEnginePlugin, packageMetaData, normalizeOids);
		this.pluginManager = pluginManager;
		this.projectInfo = projectInfo;
		try {
			colladaSerializer = new ColladaSerializer();
			// Get a configuration for the Collada serializer that will just include lights and cameras. 
			ColladaConfiguration baseConfiguration = new ColladaConfiguration(model.getAllWithSubTypes(IfcProduct.class), true, true, wantSinglePass);
			colladaSerializer.init(model, projectInfo, pluginManager, renderEnginePlugin, packageMetaData, normalizeOids, baseConfiguration);
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
	protected boolean write(OutputStream outputStream) throws SerializerException {
		if (getMode() == Mode.BODY) {
			// Store the directory ("gltf") to write executables into (beneath "tmp").
			File collada2gltfWorkspaceDirectory = null;
			// Store the directory to write models into (beneath "gltf").
			File writeDirectory = null;
			// Optionally, store the path to the collada2gltf executable.
			File collada2gltfExecutable = null;
			try {
				File tempDirectory = pluginManager.getTempDir();
				if (!tempDirectory.exists())
					tempDirectory.mkdir();
				// Get a link to the directory where collada2gltf might be installed, and where temporary folders will definitely be created.
				collada2gltfWorkspaceDirectory = new File(tempDirectory, "gltf");
				// Create the permanent resource directory if it doesn't exist.
				if (!collada2gltfWorkspaceDirectory.exists())
					collada2gltfWorkspaceDirectory.mkdir();
				// Will always fail iff OS is not Windows or MacOSX (others require binary to be built locally).
				if (SystemUtils.IS_OS_MAC_OSX || SystemUtils.IS_OS_WINDOWS)
				{
					// Get the resource bundle (contains binaries).
					OpenGLTransmissionFormatResourceBundle bundle = new OpenGLTransmissionFormatResourceBundle();
					// Check to see if there is a pre-packaged binary folder: "gltf".
					if (collada2gltfWorkspaceDirectory.exists())
					{
						// If MacOSX, use "collada2gltf" binary file.
						if (SystemUtils.IS_OS_MAC_OSX)
						{
							File macOSXcollada2gltfExecutable = new File(collada2gltfWorkspaceDirectory, "collada2gltf");
							// Write "collada2gltf".
							if (!macOSXcollada2gltfExecutable.exists())
								bundle.writeWindowsExecutable(macOSXcollada2gltfExecutable);
							// If it now exists, use the path.
							if (macOSXcollada2gltfExecutable.exists())
								collada2gltfExecutable = macOSXcollada2gltfExecutable;
						}
						// If Windows, use "collada2gltf.exe" executable.
						else if (SystemUtils.IS_OS_WINDOWS)
						{
							File windowsOScollada2gltfExecutable = new File(collada2gltfWorkspaceDirectory, "collada2gltf.exe");
							// Write "collada2gltf.exe".
							if (!windowsOScollada2gltfExecutable.exists())
								bundle.writeWindowsExecutable(windowsOScollada2gltfExecutable);
							// If it now exists, use the path.
							if (windowsOScollada2gltfExecutable.exists())
								collada2gltfExecutable = windowsOScollada2gltfExecutable;
						}
					}
				}
				// Create a unique identifier for the temporary directory where collada2gltf will export files.
				UUID id = UUID.randomUUID();
				// Create an abstraction for the write directory path.
				writeDirectory = new File(collada2gltfWorkspaceDirectory, id.toString());
				// Create the write directory if it doesn't exist.
				if (!writeDirectory.exists())
					writeDirectory.mkdir();
				// Export in a single pass. Otherwise, export the individual IfcProducts individually (very slow, very space efficient).
				if (wantSinglePass)
					exportInSinglePass(outputStream, writeDirectory, collada2gltfExecutable);
				else
					exportInMultiplePasses(outputStream, writeDirectory, collada2gltfExecutable);
			} catch (IOException e) {
				String errorMessage = String.format("Could not write file of return type, %s.", returnType);
				LOGGER.error(errorMessage, e);
			} finally {
				// Attempt to clean up the temporary directory created by this serializer.
				try {
					if (writeDirectory != null && writeDirectory.exists())
						FileUtils.deleteDirectory(writeDirectory);
				} catch (IOException ioe) {
					String errorMessage = String.format("Could not delete directory: %s", writeDirectory);
					LOGGER.error(errorMessage, ioe);
				}
			}
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private void exportInSinglePass(OutputStream outputStream, File writeDirectory, File collada2gltfExecutable) throws IOException, UnsupportedEncodingException {
		String thisFileStub = projectInfo.getName();
		// Create file.
		exportToGLTF(thisFileStub, writeDirectory, collada2gltfExecutable);
		// Regardless of success, send the whole result back (may effectively be empty results).
		if (returnType == ".zip")
			zipTheDirectory(outputStream, writeDirectory);
		else if (returnType == ".json")
			jsonTheDirectory(outputStream, writeDirectory);
	}

	private void exportInMultiplePasses(OutputStream outputStream, File writeDirectory, File collada2gltfExecutable) throws IOException, UnsupportedEncodingException {
		// Export just the lights and camera into a DAE then into the output of collada2gltf.
		boolean success = createBaseJSONStructure(writeDirectory, collada2gltfExecutable);
		// If success, write the files into the stream. Otherwise, write an empty file into the stream.
		if (success) {
			// Get the result back in as a JSON abstraction.
			File expectedOutputFile = new File(writeDirectory, String.format("%s.json", projectInfo.getName()));
			JsonElement base = readFileAsJSON(expectedOutputFile);
			// Perform the individual passes, cleaning them up individually as they are joined.
			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class))
			{
				// Make sure the IFC product is not a subtraction.
				if (!(ifcProduct instanceof IfcFeatureElementSubtraction))
				{
					// Make sure there's actual geometry.
					GeometryInfo geometryInfo = ifcProduct.getGeometry();
					if (geometryInfo != null) {
						// Reconfigure the Collada serializer.
						configureColladaSerializerForProduct(ifcProduct);
						// Want at least: 10250235.json from 10250235.dae
						String thisFileStub = String.format("%d", ifcProduct.getOid());
						// Create file.
						boolean thisWasSuccessful = exportToGLTF(thisFileStub, writeDirectory, collada2gltfExecutable);
						// If exporting the sub-file to glTF was successful, patch it into the base JSON object.
						if (thisWasSuccessful) {
							// Get a name like: 10250235.json.
							File expectedSubProcessOutputFile = new File(writeDirectory, String.format("%s.json", thisFileStub));
							// Get the result back in as a JSON abstraction.
							JsonElement other = readFileAsJSON(expectedSubProcessOutputFile);
							// Join JSON to base.
							base = selectivelyJoinTwoJSONElements(base, other, thisFileStub);
							// Rename compression.bin.
							renameCompressionBinTo(String.format("compression_%s", thisFileStub), writeDirectory);
						}
					}
				}
			}
			// Delete unused GLSL files and unused JSON files.
			cleanUpDirectoryForPackaging(writeDirectory, base);
			// Write base back into a JSON file.
			writeFileUsingJsonElement(expectedOutputFile, base);
			// Send the whole result back.
			if (returnType == ".zip")
				zipTheDirectory(outputStream, writeDirectory);
			else if (returnType == ".json")
				jsonTheDirectory(outputStream, writeDirectory);
		} else {
			LOGGER.info("Could not export to glTF. Are you missing the collada2gltf executable on the operating system's path? Is the input too large? Are there lights in the library_lights that aren't used in a scene?");
			// Send back empty (but valid) versions of the requested type.
			if (returnType == ".zip")
				writeEmptyZIPFile(outputStream, writeDirectory);
			else if (returnType == ".json")
				writeEmptyJSONFile(outputStream, writeDirectory);
		}
	}

	private void configureColladaSerializerForProduct(IfcProduct product) {
		colladaSerializer.configuration = new ColladaConfiguration(Arrays.asList(product), false, false, true);
		colladaSerializer.reset();
	}

	/*
	 * File-based methods, specifically to handle writing an output file into the stream.
	 */
	// Launch a thread to run the program "collada2gltf", which takes a Collada file as input and writes other files out to a directory.
	private boolean exportToGLTF(File writeDirectory, File collada2gltfExecutable) {
		return exportToGLTF(projectInfo.getName(), writeDirectory, collada2gltfExecutable);
	}

	private boolean exportToGLTF(String nameStub, File writeDirectory, File collada2gltfExecutable) {
		try {
			// Get the Collada file.
			File colladaFile = writeColladaFile(nameStub, writeDirectory);
			if (collada2gltfExecutable != null) {
				File absoluteExecutable = collada2gltfExecutable.getAbsoluteFile();
				configuration.executable = absoluteExecutable.getPath();
			}
			// Reconfigure for new thread.
			configuration.fileName = colladaFile.getName();
			// Launch a thread to run the collada2gltf converter.
			Collada2GLTFThread thread = new Collada2GLTFThread(writeDirectory, configuration);
			synchronized (thread) {
				thread.start();
				// Force wait until the thread's subprocess is done running (i.e. the files have all been created).
				while (thread.done == false)
				{
					// Intentional no operation.
				}
			}
			// Signal the success or failure of the action.
			return (thread.done && !thread.crashed) ? true : false;
		} catch (IOException | SerializerException e) {
			return false;
		}
	}

	private File writeColladaFile(String nameStub, File writeDirectory) throws IOException, FileNotFoundException, SerializerException {
		File colladaFile = new File(writeDirectory, String.format("%s.dae", nameStub));
		// Create the Collada file: example.dae
		if (!colladaFile.exists())
			colladaFile.createNewFile();
		// Prepare to write the Collada file.
		FileOutputStream fileOutputStream = new FileOutputStream(colladaFile);
		// Write into the Collada file.
		colladaSerializer.write(fileOutputStream);
		// Push the data into the stream.
		fileOutputStream.flush();
		// Finalize the stream and close the file.
		fileOutputStream.close();
		// Return the file abstraction.
		return colladaFile;
	}

	private void writeEmptyZIPFile(OutputStream outputStream, File f) throws IOException {
		// Create the archive.
		ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
		// Push the data into the parent stream (gets returned to the server).
		zipOutputStream.finish();
		zipOutputStream.flush();
	}

	private void writeEmptyJSONFile(OutputStream outputStream, File writeDirectory) throws IOException {
		OutputStream jsonOutputStream = outputStream;
		// Write the opening brace and a new-line.
		jsonOutputStream.write(String.format("{}").getBytes());
		// Push the data into the parent stream (gets returned to the server).
		jsonOutputStream.flush();
	}

	private void zipTheDirectory(OutputStream outputStream, File writeDirectory) throws IOException {
		// Create the archive.
		ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
		// Copy the files into the ZIP file.
		for (File f : writeDirectory.listFiles(ignoreDAEFilter))
			addFileToZIP(f, zipOutputStream);
		// Push the data into the parent stream (gets returned to the server).
		zipOutputStream.finish();
		zipOutputStream.flush();
	}

	private void jsonTheDirectory(OutputStream outputStream, File writeDirectory) throws UnsupportedEncodingException, IOException {
		// Create a root object.
		JsonObject root = new JsonObject();
		// Put the individual files into a JSON file.
		for (File f : writeDirectory.listFiles(ignoreDAEFilter))
			addFileToJSON(root, f);
		// Configure the builder.
		GsonBuilder builder = new GsonBuilder();
		builder.disableHtmlEscaping();
		if (wantJSONPrettyPrint)
			builder.setPrettyPrinting();
		Gson gson = builder.create();
		// Get the JSON string.
		String output = gson.toJson(root);
		// Push the data into the parent stream (gets returned to the server).
		outputStream.write(output.getBytes());
	}

	public void addFileToZIP(File file, ZipOutputStream outputStream) throws FileNotFoundException, IOException {
		// Get file name: example.file
		String fileName = file.getName();
		// Create an abstraction for how it will appear in the ZIP file.
		ZipEntry zipEntry = new ZipEntry(fileName);
		// Write the file's abstraction into the ZIP file.
		outputStream.putNextEntry(zipEntry);
		// Prepare to read the actual file.
		FileInputStream inputStream = new FileInputStream(file);
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

	private void addFileToJSON(JsonObject root, File f) throws IOException, UnsupportedEncodingException {
		// Use the file name as the key: file.ext
		String key = f.getName();
		// Get mime-types for the different files (at least one of which is binary). 
		String mimeType = getExpectedMimeType(f);
		// Set the encoding.
		String encoding = "base64";
		// Construct the data URI header, in format: data:mime/type;encoding
		String dataURIHeader = String.format("data:%s;%s", mimeType, encoding);
		// Create a place to store the base64 bytes.
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		// Base64 encode the file.
		encodeFileToBase64Stream(f, stream);
		// Remove extraneous newlines; data:text/plain;base64,base64-string-in-UTF-8
		String entryText = String.format("%s,%s", dataURIHeader, stream.toString("UTF-8")).replace(String.format("%n"), "");
		// "filename.ext": "data:text/plain;base64,base64-string-in-UTF-8",(new-line)
		root.addProperty(key, entryText);
	}

	private String getExpectedMimeType(File f) {
		String fileName = f.getName();
		String extension = FilenameUtils.getExtension(fileName);
		if (extension.equalsIgnoreCase("glsl"))
			return "text/plain";
		else if (extension.equalsIgnoreCase("json"))
			return "application/json";
		else
			return "application/octet-stream";
	}

	public void encodeFileToBase64Stream(File file, OutputStream base64OutputStream) throws IOException {
		InputStream is = new FileInputStream(file);
		OutputStream out = new Base64OutputStream(base64OutputStream);
		IOUtils.copy(is, out);
		is.close();
		out.close();
	}

	/*
	 * JSON-related methods, specifically used to join the output of two individual sets of collada2gltf output into one file. 
	 */
	private boolean createBaseJSONStructure(File writeDirectory, File collada2gltfExecutable) {
		// Get the expected name of the base file: P1.dae.
		File expectedOutputFile = new File(writeDirectory, String.format("%s.json", projectInfo.getName()));
		// Send a basic Collada (DAE) file into collada2gltf. File should include non-empty: asset, library_cameras, library lights, library_visual_scenes, scene.
		boolean success = exportToGLTF(writeDirectory, collada2gltfExecutable);
		// If the file was successful, attempt to sanitize the output.
		if (success)
			cleanBufferViewEntryInJSONFile(expectedOutputFile);
		// Send back whether everything went well or not.
		return success;
	}

	private void cleanBufferViewEntryInJSONFile(File expectedOutputFile) {
		// Replace the "bufferViews" object with a blank dictionary (collada2gltf erroneously drops 2 unused buffer views into the structure on an empty file).
		JsonElement root = readFileAsJSON(expectedOutputFile);
		// If it's valid (and it should be), clean up the mess collada2gltf leaves.
		if (root.isJsonObject()) {
			// Get the root object.
			JsonObject rootObject = root.getAsJsonObject();
			// If it has bufferViews, 
			if (rootObject.has("bufferViews"))
			{
				// Get the bufferViews object, with the intention of making a copy only of the ones that have a byte length greater than zero.
				JsonObject bufferViewsObject = rootObject.get("bufferViews").getAsJsonObject();
				JsonObject newBufferViewsObject = new JsonObject();
				// Entry set yields key like: bufferView_2
				for (Map.Entry<String, JsonElement> entry : bufferViewsObject.entrySet())
				{
					// Get: "bufferView_22", { "buffer": "P1", ... }
					String propertyName = entry.getKey();
					JsonElement bufferViewElement = entry.getValue();
					// Cast to dictionary.
					JsonObject bufferObject = bufferViewElement.getAsJsonObject();
					// Only include buffer view objects that aren't empty (because empty ones aren't referenced by collada2gltf, but collada2gltf erroneously includes them anyway even if there's no geometry or buffers).
					if (bufferObject.get("byteLength").getAsInt() > 0)
					{
						// Add the existing buffer to the replacement.
						newBufferViewsObject.add(propertyName, bufferViewElement);
					}
				}
				rootObject.remove("bufferViews");
				rootObject.add("bufferViews", newBufferViewsObject);
			}
		}
		writeFileUsingJsonElement(expectedOutputFile, root);
	}

	private JsonElement readFileAsJSON(File expectedOutputFile) {
		String result;
		try {
			result = FileUtils.readFileToString(expectedOutputFile);
		} catch (IOException e) {
			// Something bad happened, but send something readable to the next step anyway.
			result = "{}";
			e.printStackTrace();
		}
		// Parse the existing file.
		JsonParser parser = new JsonParser();
		JsonReader reader = new JsonReader(new StringReader(result));
		reader.setLenient(true);
		JsonElement root = parser.parse(reader);
		// Send root back.
		return root;
	}

	private boolean writeFileUsingJsonElement(File expectedOutputFile, JsonElement root) {
		boolean success = false;
		// Write the file back out.
		try (Writer writer = new FileWriter(expectedOutputFile)) {
			GsonBuilder builder = new GsonBuilder();
			if (wantJSONPrettyPrint)
				builder.setPrettyPrinting();
			Gson gson = builder.create();
			gson.toJson(root, writer);
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	private JsonElement selectivelyJoinTwoJSONElements(JsonElement baseElement, JsonElement otherElement, String suffix)
	{
		JsonObject base = baseElement.getAsJsonObject();
		JsonObject other = otherElement.getAsJsonObject();
		//
		if (other.has("accessors"))
		{
			JsonElement accesssorsElement = getOrCreateJSONElement(base, "accessors");
			JsonObject accesssorsObject = accesssorsElement.getAsJsonObject();
			JsonObject joining = other.get("accessors").getAsJsonObject();
			// Entry set yields key like: accessor_16.
			for (Map.Entry<String, JsonElement> entry : joining.entrySet())
			{
				// Get: "accessor_16", { "bufferView": "bufferView_22", ... }
				String propertyName = entry.getKey();
				JsonElement joiningElement = entry.getValue();
				// Cast to dictionary object.
				JsonObject joiningObject = joiningElement.getAsJsonObject();
				// Convert: accessor_16 to accessor_16_suffix.
				String safePropertyName = String.format("%s_%s", propertyName, suffix);
				// Get the element of the bufferView, which is in form "bufferView_22".
				JsonElement bufferViewElement = joiningObject.get("bufferView");
				String bufferViewName = bufferViewElement.getAsString();
				// Create a new bufferView name: bufferView_22_suffix.
				String safeBufferViewName = String.format("%s_%s", bufferViewName, suffix);
				// Remove the existing path element.
				joiningObject.remove("bufferView");
				// Add the new one, containing the safety name: bufferView_22_suffix.
				joiningObject.addProperty("bufferView", safeBufferViewName);
				// "accesor_16_suffix": { "bufferView": "bufferView_22_suffix", ... }
				accesssorsObject.add(safePropertyName, joiningElement);
			}
		}
		if (other.has("bufferViews"))
		{
			JsonElement bufferViewsElement = getOrCreateJSONElement(base, "bufferViews");
			JsonObject bufferViewsObject = bufferViewsElement.getAsJsonObject();
			JsonObject joining = other.get("bufferViews").getAsJsonObject();
			// Entry set yields key like: bufferView_22
			for (Map.Entry<String, JsonElement> entry : joining.entrySet())
			{
				// Get: "bufferView_22", { "buffer": "P1", ... }
				String propertyName = entry.getKey();
				JsonElement joiningElement = entry.getValue();
				// Cast to dictionary.
				JsonObject joiningObject = joiningElement.getAsJsonObject();
				// Only include buffer view objects that aren't empty (because empty ones aren't referenced by collada2gltf, but collada2gltf erroneously includes them anyway during Open3DGC compression).
				if (joiningObject.get("byteLength").getAsInt() > 0)
				{
					// Convert: bufferView_22 to bufferView_22_suffix.
					String safePropertyName = String.format("%s_%s", propertyName, suffix);
					// Get the element of the buffer; value is a key to look up data beneath the "buffers" dictionary. 
					JsonElement bufferElement = joiningObject.get("buffer");
					// Get the buffer name: compression.
					String bufferName = bufferElement.getAsString();
					// Convert: compression to compression_suffix.
					String safeBufferName = (bufferName.equalsIgnoreCase("compression")) ? String.format("%s_%s", bufferName, suffix) : bufferName;
					// Remove the existing buffer element. 
					joiningObject.remove("buffer");
					// Add the new one, containing the safety name(s): bufferView_22_suffix and P1_suffix.
					joiningObject.addProperty("buffer", safeBufferName);
					// "bufferView_22_suffix": { "buffer": "P1_suffix", ... }
					bufferViewsObject.add(safePropertyName, joiningElement);
				}
			}
		}
		if (other.has("buffers"))
		{
			JsonElement buffersElement = getOrCreateJSONElement(base, "buffers");
			JsonObject buffersObject = buffersElement.getAsJsonObject();
			JsonObject joining = other.get("buffers").getAsJsonObject();
			// Entry set yields key like: P1 (name of converted file) or "compression" (if using Open3DGC compression).
			for (Map.Entry<String, JsonElement> entry : joining.entrySet())
			{
				// Get: "P1", { "path": "P1.bin", ... }
				String propertyName = entry.getKey();
				JsonElement joiningElement = entry.getValue();
				// Cast to dictionary object.
				JsonObject joiningObject = joiningElement.getAsJsonObject();
				// Only include buffer view objects that aren't empty (because empty ones aren't referenced by collada2gltf, but collada2gltf erroneously includes them anyway during Open3DGC compression).
				if (joiningObject.get("byteLength").getAsInt() > 0)
				{
					if (propertyName.equalsIgnoreCase("compression")) {
						// Convert: compression to compression_suffix.
						String safePropertyName = String.format("%s_%s", propertyName, suffix);
						// Get the element of the path to file, which is in form "P1.bin" or "compression.bin".
						JsonElement pathElement = joiningObject.get("path");
						String pathName = pathElement.getAsString();
						// Extract the file without the extension: P1.
						String basePathName = FilenameUtils.removeExtension(pathName);
						// Extract the extension: bin.
						String fileExtension = FilenameUtils.getExtension(pathName);
						// Create a new file name: P1_suffix.bin.
						String safePathName = String.format("%s_%s.%s", basePathName, suffix, fileExtension);
						// Remove the existing path element.
						joiningObject.remove("path");
						// Add the new one, containing the safety name: P1_suffix.bin.
						joiningObject.addProperty("path", safePathName);
						// "P1_suffix": { "path": "P1_suffix.bin", ... }
						buffersObject.add(safePropertyName, joiningElement);
					} else 
						buffersObject.add(propertyName, joiningElement);
				}
			}
		}
		// Prepare a place to store technique rewrites to be used only in the material definitions.
		List<SimpleEntry<String, String>> techniqueReplacementTable = new ArrayList<SimpleEntry<String, String>>();
		//
		List<SimpleEntry<String, String>> programReplacementTable = new ArrayList<SimpleEntry<String, String>>();
		// Techniques must happen before materials.
		if (other.has("techniques"))
		{
			JsonElement techniquesElement = getOrCreateJSONElement(base, "techniques");
			JsonObject techniquesObject = techniquesElement.getAsJsonObject();
			JsonObject joining = other.get("techniques").getAsJsonObject();
			// Entry set yields key like: technique0.
			for (Map.Entry<String, JsonElement> entry : joining.entrySet())
			{
				// Get: "technique0", { ... }
				String propertyName = entry.getKey();
				JsonElement joiningElement = entry.getValue();
				JsonObject techniqueObject = joiningElement.getAsJsonObject();
				// Look for existing technique/program.
				String equivalentTechnique = nameOfEquivalentTechniqueInBaseObject(base, other, propertyName);
				if (equivalentTechnique != null)
					techniqueReplacementTable.add(new SimpleEntry<String, String>(propertyName, equivalentTechnique));
				else {
					// If not equivalent, count number of techniques; return that count + 1 as safeTechniqueNumber.
					int safeTechniqueNumber = nextSafeTechniqueNumber(techniquesObject);
					// Then, write a replacement technique object with key: "technique%d" where %d is safeTechniqueNumber.
					String safeTechniqueName = String.format("technique%d", safeTechniqueNumber);
					techniqueReplacementTable.add(new SimpleEntry<String, String>(propertyName, safeTechniqueName));
					// Then, count number of programs; return that count + 1 as firstSafeProgramNumber.
					JsonElement baseProgramsElement = getOrCreateJSONElement(base, "programs");
					JsonObject baseProgramsObject = baseProgramsElement.getAsJsonObject();
					int firstSafeProgramNumber = nextSafeProgramNumber(baseProgramsObject);
					// Then, rewrite the object's "passes" -> pass -> "instanceProgram" -> "program" to be "program_%d" where %d is firstSafeProgramNumber.
					JsonObject passesObject = techniqueObject.get("passes").getAsJsonObject();
					JsonObject programsObject = other.get("programs").getAsJsonObject();
					JsonObject shadersObject = other.get("shaders").getAsJsonObject();
					JsonObject baseShadersObject = getOrCreateJSONElement(base, "shaders").getAsJsonObject();
					for (Entry<String, JsonElement> passEntry : passesObject.entrySet()) {
						JsonObject passObject = passEntry.getValue().getAsJsonObject();
						JsonObject instanceProgramObject = passObject.get("instanceProgram").getAsJsonObject();
						// Get existing program name.
						String programNameToRewrite = instanceProgramObject.get("program").getAsString();
						//
						SimpleEntry<String, String> equivalentProgramReplacementEntry = getEntryByKey(programNameToRewrite, programReplacementTable);
						String safeProgramName;
						if (equivalentProgramReplacementEntry != null) {
							// If the program can request an equivalent program, just rewrite the name in the pass.
							safeProgramName = equivalentProgramReplacementEntry.getValue();
						} else {
							// If the program cannot request an equivalent program, rewrite the name in the pass
							// Get a safe name for the program.
							safeProgramName = String.format("program_%d", firstSafeProgramNumber);
							firstSafeProgramNumber++;
							// Mark the existing program name to be rewritten as the safe program name.
							programReplacementTable.add(new SimpleEntry<String, String>(programNameToRewrite, safeProgramName));
							// Get the existing program object.
							JsonObject programObject = programsObject.get(programNameToRewrite).getAsJsonObject();
							// Add applicable shaders to the base object.
							for (String shaderCategory : Arrays.asList("fragmentShader", "vertexShader", "geometryShader", "tessellationShader", "computeShader")) {
								if (programObject.has(shaderCategory))
								{
									String shaderName = programObject.get(shaderCategory).getAsString();
									JsonElement shaderElement = shadersObject.get(shaderName);
									// TODO: Optionally, rename shader files.
									// Add shaders to base object.
									baseShadersObject.add(shaderName, shaderElement);
								}
							}
							// Add the program to the base object under the safe program name.
							baseProgramsObject.add(safeProgramName, programObject);
						}
						// Update the program in the pass's "instanceProgram" -> "program" from: program_0 to program_safeProgramNumber
						instanceProgramObject.remove("program");
						instanceProgramObject.addProperty("program", safeProgramName);
					}
					// Add technique to base object.
					techniquesObject.add(safeTechniqueName, joiningElement);
				}
			}
		}
		if (other.has("materials"))
		{
			JsonElement materialsElement = getOrCreateJSONElement(base, "materials");
			JsonObject materialsObject = materialsElement.getAsJsonObject();
			JsonObject joining = other.get("materials").getAsJsonObject();
			// Entry set yields key like: IfcSlab-fx.
			for (Map.Entry<String, JsonElement> entry : joining.entrySet())
			{
				// Get: "IfcSlab-fx", { ... }
				String propertyName = entry.getKey();
				JsonElement joiningElement = entry.getValue();
				if (!materialsObject.has(propertyName)) {
					JsonObject otherSpecificMaterialObject = joiningElement.getAsJsonObject();
					JsonObject otherInstanceTechniqueObject = otherSpecificMaterialObject.get("instanceTechnique").getAsJsonObject();
					String techniqueRequest = otherInstanceTechniqueObject.get("technique").getAsString();
					// Check if there's an existing replacement entry to translate requests for technique0 to techniqueX.
					SimpleEntry<String, String> replacementEntry = getEntryByKey(techniqueRequest, techniqueReplacementTable);
					if (replacementEntry != null) {
						String newTechnique = replacementEntry.getValue();
						otherInstanceTechniqueObject.remove("technique");
						otherInstanceTechniqueObject.addProperty("technique", newTechnique);
					}
					// Otherwise, see if there's an one available in the base object.
					else {
						String newTechnique = nameOfEquivalentTechniqueInBaseObject(base, other, techniqueRequest);
						if (newTechnique != null) {
							otherInstanceTechniqueObject.remove("technique");
							otherInstanceTechniqueObject.addProperty("technique", newTechnique);
						}
					}
					materialsObject.add(propertyName, joiningElement);
				}
			}
		}
		if (other.has("meshes"))
		{
			JsonElement meshesElement = getOrCreateJSONElement(base, "meshes");
			JsonObject meshesObject = meshesElement.getAsJsonObject();
			JsonObject joining = other.get("meshes").getAsJsonObject();
			// Entry set yields key like: "geom-131696".
			for (Map.Entry<String, JsonElement> entry : joining.entrySet())
			{
				// Get: "geom-131696", { "primitives": [{ "attributes": { "NORMAL": "accessor_20", ... }, "indices": "accesor_16", ... }, ], ... }
				String propertyName = entry.getKey();
				JsonElement joiningElement = entry.getValue();
				if (!meshesObject.has(propertyName))
				{
					// Cast to dictionary object.
					JsonObject joiningObject = joiningElement.getAsJsonObject();
					// Get primitives array element.
					JsonElement primitivesArrayElement = joiningObject.get("primitives");
					JsonArray primitivesArray = primitivesArrayElement.getAsJsonArray();
					Iterator<JsonElement> iterator = primitivesArray.iterator();
					while (iterator.hasNext())
					{
						JsonElement dictionaryElement = iterator.next();
						JsonObject dictionaryObject = dictionaryElement.getAsJsonObject();
						// Get "attributes" sub-section.
						JsonElement attributesElement = dictionaryObject.get("attributes");
						JsonObject attributesObject = attributesElement.getAsJsonObject();
						JsonObject newAttributesObject = new JsonObject();
						// Yields keys like: "NORMAL", "POSITION", etc.
						for (Entry<String, JsonElement> thisEntry : attributesObject.entrySet())
						{
							String thisKey = thisEntry.getKey();
							JsonElement thisElement = thisEntry.getValue();
							String accessorName = thisElement.getAsString();
							String safeAccessorName = String.format("%s_%s", accessorName, suffix);
							newAttributesObject.addProperty(thisKey, safeAccessorName);
						}
						dictionaryObject.remove("attributes");
						dictionaryObject.add("attributes", newAttributesObject);
						// Get "indices" entry.
						JsonElement indicesElement = dictionaryObject.get("indices");
						String indicesAccessorName = indicesElement.getAsString();
						String safeIndicesAccessorName = String.format("%s_%s", indicesAccessorName, suffix);
						dictionaryObject.remove("indices");
						dictionaryObject.addProperty("indices", safeIndicesAccessorName);
					}
					if (joiningObject.has("extensions"))
					{
						// Get extensions dictionary. Iterate keys.
						JsonObject extensionsObject = joiningObject.get("extensions").getAsJsonObject();
						// Yields things like: Open3DGC-compression
						for (Entry<String, JsonElement> extension : extensionsObject.entrySet())
						{
							JsonElement payload = extension.getValue();
							if (payload instanceof JsonObject)
							{
								JsonObject payloadObject = payload.getAsJsonObject();
								// Get "compressedData"?
								for (Entry<String, JsonElement> payloadElement: payloadObject.entrySet())
								{
									JsonElement itemElement = payloadElement.getValue();
									// 
									if (itemElement instanceof JsonObject) {
										//
										JsonObject itemObject = itemElement.getAsJsonObject();
										if (itemObject.has("bufferView"))
										{
											String bufferViewName = itemObject.get("bufferView").getAsString();
											String safeBufferViewName = String.format("%s_%s", bufferViewName, suffix);
											itemObject.remove("bufferView");
											itemObject.addProperty("bufferView", safeBufferViewName);
										}
									}
								}
							}
						}
					}
					// "P1_suffix": { "path": "P1_suffix.bin", ... }
					meshesObject.add(propertyName, joiningElement);
				}
			}
		}
		if (other.has("nodes"))
		{
			JsonElement nodesElement = getOrCreateJSONElement(base, "nodes");
			JsonObject nodesObject = nodesElement.getAsJsonObject();
			JsonObject joining = other.get("nodes").getAsJsonObject();
			// Entry set yields key like: node-131696.
			for (Map.Entry<String, JsonElement> entry : joining.entrySet())
			{
				// Get: "node-131696", { ... }
				String propertyName = entry.getKey();
				JsonElement joiningElement = entry.getValue();
				if (!nodesObject.has(propertyName))
					nodesObject.add(propertyName, joiningElement);
			}
		}
		if (other.has("scenes"))
		{
			JsonElement scenesElement = getOrCreateJSONElement(base, "scenes");
			JsonObject scenesObject = scenesElement.getAsJsonObject();
			JsonObject joining = other.get("scenes").getAsJsonObject();
			// Entry set yields key like: defaultScene.
			for (Map.Entry<String, JsonElement> entry : joining.entrySet())
			{
				// Get: "defaultScene", { "nodes": [ "node-131696", ... ], }
				String propertyName = entry.getKey();
				JsonElement joiningElement = entry.getValue();
				// Scene key not found in the base, so add the whole thing.
				if (!scenesObject.has(propertyName))
					scenesObject.add(propertyName, joiningElement);
				// Scene key is found in the base, so append the values.
				else {
					// Get the base propertyName (dictionary) -> "nodes" array.
					JsonElement baseScene = scenesObject.get(propertyName);
					JsonObject baseSceneObject = baseScene.getAsJsonObject();
					JsonElement baseNodesElement = baseSceneObject.get("nodes");
					JsonArray baseNodesArray = baseNodesElement.getAsJsonArray();
					// Get the joining propertyName (dictionary) -> "nodes" array.
					JsonObject joiningObject = joiningElement.getAsJsonObject();
					JsonElement nodesElement = joiningObject.get("nodes");
					JsonArray nodesArray = nodesElement.getAsJsonArray();
					// Add the values.
					baseNodesArray.addAll(nodesArray);
				}
			}
		}
		return baseElement;
	}

	private JsonElement getOrCreateJSONElement(JsonObject base, String nameOfEntry) {
		JsonElement element = base.get(nameOfEntry);
		if (element == null) {
			element = new JsonObject();
			base.add(nameOfEntry, element);
		}
		return element;
	}

	private void renameCompressionBinTo(String newNameStub, File directory) {
		// Add ".bin" to the file name stub, if ".bin" is missing.
		if (!newNameStub.toLowerCase(Locale.ENGLISH).endsWith(".bin"))
			newNameStub = String.format("%s.bin", newNameStub);
		// Make the new file name be beneath the directory.
		File newFile = new File(directory, newNameStub);
		// Get a link to the old file name.
		File oldFile = new File(directory, "compression.bin");
		// If the old file name exists, rename it.
		if (oldFile.exists())
			oldFile.renameTo(newFile);
	}

	private void cleanUpDirectoryForPackaging(File writeDirectory, JsonElement base) {
		// Pass 2: delete GLSL files that are unused by the resulting JSON from Pass 1.
		deleteAllUnnecessaryShaderFiles(base, writeDirectory);
		// Delete all the JSON files that are not the main JSON file (so named after the project's name).
		deleteAllUnnecessaryJSONFiles(writeDirectory);
	}

	private void deleteAllUnnecessaryJSONFiles(File directory) {
		String baseFileName = String.format("%s.json", projectInfo.getName());
		List<String> list = Arrays.asList(baseFileName);
		// Get all *.glsl files.
		File[] files = directory.listFiles(getOnlyJSONFilesFilter);
		// Delete the ones that are used by the JSON element.
		for (File file : files)
			if (!list.contains(file.getName()))
				file.delete();
	}

	private void deleteAllUnnecessaryShaderFiles(JsonElement rootElement, File directory) {
		List<String> list = getShaderFiles(rootElement);
		// Get all *.glsl files.
		File[] files = directory.listFiles(getOnlyGLSLFilesFilter);
		// Delete the ones that are used by the JSON element.
		for (File file : files)
			if (!list.contains(file.getName()))
				file.delete();
	}

	private List<String> getShaderFiles(JsonElement rootElement) {
		List<String> list = new ArrayList<String>();
		JsonObject rootObject = rootElement.getAsJsonObject();
		// If root has a "shaders" entry, read it.
		if (rootObject.has("shaders"))
		{
			JsonObject shadersObject = rootObject.get("shaders").getAsJsonObject();
			for (Entry<String, JsonElement> entry : shadersObject.entrySet()) {
				JsonObject shaderObject = entry.getValue().getAsJsonObject();
				// If the shader object has a path, add it to the list of files.
				if (shaderObject.has("path"))
					list.add(shaderObject.get("path").getAsString());
			}
		}
		return list;
	}

	private SimpleEntry<String, String> getEntryByKey(String key, List<SimpleEntry<String, String>> list)
	{
		Iterator<SimpleEntry<String, String>> iterator = list.iterator();
		while (iterator.hasNext()) {
			SimpleEntry<String, String> entry = iterator.next();
			if (entry.getKey() == key)
				return entry;
		}
		return null;
	}

	private String nameOfEquivalentTechniqueInBaseObject(JsonElement rootElement, JsonElement otherRootElement, String name)
	{
		JsonObject otherRootObject = otherRootElement.getAsJsonObject();
		JsonObject otherTechniques = otherRootObject.get("techniques").getAsJsonObject();
		if (otherTechniques.has(name))
		{
			JsonObject otherTechnique = otherTechniques.get(name).getAsJsonObject();
			return nameOfEquivalentTechniqueInBaseObject(rootElement, otherTechnique);
		}
		return null;
	}

	private String nameOfEquivalentTechniqueInBaseObject(JsonElement rootElement, JsonObject otherTechnique) {
		String equivalentTechniqueName = null;
		/* Test for technique equality should be:
		 *  1. "techniqueX" -> "parameters" are equivalent (captures changes like different input parameters; ex: transparency versus no transparency).
		 *  2. "techniqueX" -> "pass" are equivalent.
		 *  3. "techniqueX" -> "passes" -> pass (from 2) -> "states" are equivalent.
		 *  4. "techniqueX" -> "passes" -> pass (from 2) -> "details" are equivalent.
		 *  5. "techniqueX" -> "passes" -> pass (from 2) -> "instanceProgram" -> "attributes" are equivalent.
		 *  6. "techniqueX" -> "passes" -> pass (from 2) -> "instanceProgram" -> "uniforms" are equivalent.
		 */
		JsonObject rootObject = rootElement.getAsJsonObject();
		if (rootObject.has("techniques"))
		{
			JsonObject existingTechniques = rootObject.get("techniques").getAsJsonObject();
			// Yields keys like: technique0
			for (Entry<String, JsonElement> existingTechnique : existingTechniques.entrySet())
			{
				// Get: technique0
				String techniqueName = existingTechnique.getKey();
				JsonObject techniqueObject = existingTechnique.getValue().getAsJsonObject();
				JsonElement parameters = techniqueObject.get("parameters");
				JsonElement otherParameters = otherTechnique.get("parameters");
				// If parameters are equivalent; and,
				if (parametersAreEqual(parameters, otherParameters)) {
					String pass = techniqueObject.get("pass").getAsString();
					String otherPass = otherTechnique.get("pass").getAsString();
					// If the pass names are the same; and,
					if (pass.equals(otherPass)) {
						//
						JsonObject passes = techniqueObject.get("passes").getAsJsonObject();
						JsonObject otherPasses = otherTechnique.get("passes").getAsJsonObject();
						//
						JsonObject passObject = passes.get(pass).getAsJsonObject();
						JsonObject otherPassObject = otherPasses.get(pass).getAsJsonObject();
						//
						JsonElement states = passObject.get("states");
						JsonElement otherStates = otherPassObject.get("states");
						// If the states are equivalent; and,
						if (statesAreEqual(states, otherStates))
						{
							JsonElement details = passObject.get("details");
							JsonElement otherDetails = otherPassObject.get("details");
							// If the details are equivalent; and,
							if (detailsAreEqual(details, otherDetails))
							{
								JsonObject instanceProgram = passObject.get("instanceProgram").getAsJsonObject();
								JsonObject otherInstanceProgram = otherPassObject.get("instanceProgram").getAsJsonObject();
								//
								JsonElement attributes = instanceProgram.get("attributes");
								JsonElement otherAttributes = otherInstanceProgram.get("attributes");
								// If the attributes are equivalent; and,
								if (attributesAreEqual(attributes, otherAttributes))
								{
									JsonElement uniforms = instanceProgram.get("uniforms");
									JsonElement otherUniforms = otherInstanceProgram.get("uniforms");
									// If the uniforms are equivalent; then, the objects are equal. 
									if (uniformsAreEqual(uniforms, otherUniforms))
										return techniqueName;
								}
							}
						}
					}
				}
			}
		}
		return equivalentTechniqueName;
	}

	// Semantic convenience methods.
	private boolean parametersAreEqual(JsonElement parameters, JsonElement otherParameters) {
		return twoJSONEelementsAreEqual(parameters, otherParameters);
	}

	private boolean statesAreEqual(JsonElement states, JsonElement otherStates) {
		return twoJSONEelementsAreEqual(states, otherStates);
	}

	private boolean detailsAreEqual(JsonElement details, JsonElement otherDetails) {
		return twoJSONEelementsAreEqual(details, otherDetails);
	}

	private boolean attributesAreEqual(JsonElement attributes, JsonElement otherAttributes) {
		return twoJSONEelementsAreEqual(attributes, otherAttributes);
	}

	private boolean uniformsAreEqual(JsonElement uniforms, JsonElement otherUniforms) {
		return twoJSONEelementsAreEqual(uniforms, otherUniforms);
	}

	private boolean twoJSONEelementsAreEqual(JsonElement element, JsonElement otherElement) {
		// Internal equivalence test against members.
		return (element.equals(otherElement)) ? true : false;
	}

	private int nextSafeTechniqueNumber(JsonObject techniquesObject)
	{
		// Techniques are zero-indexed. So, a count should properly yield the next index.
		return techniquesObject.entrySet().size();
	}

	private int nextSafeProgramNumber(JsonObject programsObject)
	{
		// Programs are zero-indexed. So, a count should properly yield the next index.
		return programsObject.entrySet().size();
	}
}
