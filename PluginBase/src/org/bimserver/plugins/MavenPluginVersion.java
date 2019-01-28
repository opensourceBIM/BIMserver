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

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Model;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.version.Version;

public class MavenPluginVersion extends PluginVersion {

	private Version version;
	private List<MavenDependency> dependencies = new ArrayList<>();
	private Artifact artifact;
	private Model model;

	public MavenPluginVersion(Artifact artifact, Version version) {
		this.artifact = artifact;
		this.version = version;
	}
	
	public Artifact getArtifact() {
		return artifact;
	}
	
	public String getVersion() {
		return version.toString();
	}

	public void addDependency(MavenDependency mavenDependency) {
		dependencies.add(mavenDependency);
	}
	
	public List<MavenDependency> getDependencies() {
		return dependencies;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public Model getModel() {
		return model;
	}

	@Override
	public String getDescription() {
		return getModel().getDescription();
	}

	@Override
	public String getName() {
		return getModel().getName();
	}

	@Override
	public String getOrganization() {
		return getModel().getOrganization().getName();
	}
}
