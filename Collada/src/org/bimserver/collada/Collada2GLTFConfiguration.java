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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collada2GLTFConfiguration {
	// OpenGL Transformation Format settings.
	public String executable = null;
	public String fileName = null;
	public String compressionType = null; // Can be Open3DGC; -c "Open3DGC"
	public String compressionMode = null; // Can be "ascii", "binary"; -m "ascii"
	public boolean wantDefaultLighting = false; // -l (if true)
	public boolean wantExperimentalMode = false; // -s (if true)
	public boolean wantExportAnimations = true; // -a true (default; or) -a false
	public boolean wantInvertTransparency = false; // -i (if true)
	public boolean wantIndividualPasses = false; // -d (if true)

	public Collada2GLTFConfiguration()
	{
		// Use default settings.
	}

	public Collada2GLTFConfiguration(String fileName)
	{
		this.fileName = fileName;
	}

	public Collada2GLTFConfiguration(String fileName, String compressionType, String compressionMode, boolean wantDefaultLighting, boolean wantExperimentalMode, boolean wantExportAnimations, boolean wantInvertTransparency, boolean wantIndividualPasses) {
		this.fileName = fileName;
		this.compressionType = compressionType;
		this.compressionMode = compressionMode;
		this.wantDefaultLighting = wantDefaultLighting;
		this.wantExperimentalMode = wantExperimentalMode;
		this.wantExportAnimations = wantExportAnimations;
		this.wantInvertTransparency = wantInvertTransparency;
		this.wantIndividualPasses = wantIndividualPasses;
	}

	public Collada2GLTFConfiguration(String compressionType, String compressionMode, boolean wantDefaultLighting, boolean wantExperimentalMode, boolean wantExportAnimations, boolean wantInvertTransparency, boolean wantIndividualPasses) {
		this.compressionType = compressionType;
		this.compressionMode = compressionMode;
		this.wantDefaultLighting = wantDefaultLighting;
		this.wantExperimentalMode = wantExperimentalMode;
		this.wantExportAnimations = wantExportAnimations;
		this.wantInvertTransparency = wantInvertTransparency;
		this.wantIndividualPasses = wantIndividualPasses;
	}

	public List<String> getCall()
	{
		ArrayList<String> list = new ArrayList<String>();
		// Add the application.
		list.add((executable == null) ? "collada2gltf" : executable);
		// Required parameters.
		if (fileName != null)
			list.addAll(Arrays.asList(new String[] {"-f", String.format("\"%s\"", fileName)}));
		else
			return list;
		// Optional parameters.
		if (compressionType != null)
			list.addAll(Arrays.asList(new String[] {"-c", String.format("\"%s\"", compressionType)}));
		if (compressionMode != null)
			list.addAll(Arrays.asList(new String[] {"-m", String.format("\"%s\"", compressionMode)}));
		if (wantDefaultLighting)
			list.addAll(Arrays.asList(new String[] {"-l", }));
		if (wantExperimentalMode)
			list.addAll(Arrays.asList(new String[] {"-s", }));
		if (!wantExportAnimations)
			list.addAll(Arrays.asList(new String[] {"-a", String.format("\"%s\"", "false")}));
		if (wantInvertTransparency)
			list.addAll(Arrays.asList(new String[] {"-i", }));
		if (wantIndividualPasses)
			list.addAll(Arrays.asList(new String[] {"-d", }));
		return list;
	}
}