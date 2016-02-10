package org.bimserver.plugins.serializers;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class RemovableFileOutputStream extends FileOutputStream {

	private Path file;

	public RemovableFileOutputStream(Path file) throws FileNotFoundException {
		super(file.toFile());
		this.file = file;
	}
	
	public void remove() throws IOException {
		if (Files.exists(file)) {
			Files.delete(file);
		}
	}

	public abstract void cancel() throws IOException;
}