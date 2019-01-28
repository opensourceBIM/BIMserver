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

import java.io.PrintStream;

import org.eclipse.aether.AbstractRepositoryListener;
import org.eclipse.aether.RepositoryEvent;

public class ConsoleRepositoryListener extends AbstractRepositoryListener {

	private PrintStream out;

	public ConsoleRepositoryListener() {
		this(null);
	}

	public ConsoleRepositoryListener(PrintStream out) {
		this.out = (out != null) ? out : System.out;
	}

	public void artifactDeployed(RepositoryEvent event) {
		out.println("Deployed " + event.getArtifact() + " to " + event.getRepository());
	}

	public void artifactDeploying(RepositoryEvent event) {
		out.println("Deploying " + event.getArtifact() + " to " + event.getRepository());
	}

	public void artifactDescriptorInvalid(RepositoryEvent event) {
		out.println("Invalid artifact descriptor for " + event.getArtifact() + ": " + event.getException().getMessage());
	}

	public void artifactDescriptorMissing(RepositoryEvent event) {
		out.println("Missing artifact descriptor for " + event.getArtifact());
	}

	public void artifactInstalled(RepositoryEvent event) {
		out.println("Installed " + event.getArtifact() + " to " + event.getFile());
	}

	public void artifactInstalling(RepositoryEvent event) {
		out.println("Installing " + event.getArtifact() + " to " + event.getFile());
	}

	public void artifactResolved(RepositoryEvent event) {
		out.println("Resolved artifact " + event.getArtifact() + " from " + event.getRepository());
	}

	public void artifactDownloading(RepositoryEvent event) {
		out.println("Downloading artifact " + event.getArtifact() + " from " + event.getRepository());
	}

	public void artifactDownloaded(RepositoryEvent event) {
		out.println("Downloaded artifact " + event.getArtifact() + " from " + event.getRepository());
	}

	public void artifactResolving(RepositoryEvent event) {
		out.println("Resolving artifact " + event.getArtifact());
	}

	public void metadataDeployed(RepositoryEvent event) {
		out.println("Deployed " + event.getMetadata() + " to " + event.getRepository());
	}

	public void metadataDeploying(RepositoryEvent event) {
		out.println("Deploying " + event.getMetadata() + " to " + event.getRepository());
	}

	public void metadataInstalled(RepositoryEvent event) {
		out.println("Installed " + event.getMetadata() + " to " + event.getFile());
	}

	public void metadataInstalling(RepositoryEvent event) {
		out.println("Installing " + event.getMetadata() + " to " + event.getFile());
	}

	public void metadataInvalid(RepositoryEvent event) {
		out.println("Invalid metadata " + event.getMetadata());
	}

	public void metadataResolved(RepositoryEvent event) {
		out.println("Resolved metadata " + event.getMetadata() + " from " + event.getRepository());
	}

	public void metadataResolving(RepositoryEvent event) {
		out.println("Resolving metadata " + event.getMetadata() + " from " + event.getRepository());
	}
}