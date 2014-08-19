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

import java.io.File;
import java.io.IOException;

public class Collada2GLTFThread implements Runnable {
	// Thread-related.
	private Thread t;
	private static final String threadName = "COLLADA2GLTF Export";
	public boolean done = false;
	public boolean crashed = false;

	// File-related.
	private File basePath = null;
	private Collada2GLTFConfiguration configuration = new Collada2GLTFConfiguration(); 

	public Collada2GLTFThread(File file, File basePath){
		this.configuration = new Collada2GLTFConfiguration(file.getName());
		this.basePath = basePath;
	}

	public Collada2GLTFThread(File basePath, Collada2GLTFConfiguration configuration){
		this.basePath = basePath;
		this.configuration = configuration;
	}

	@Override
	public void run() {
		done = false;
		crashed = false;
		// Build the process.
		ProcessBuilder builder = new ProcessBuilder(configuration.getCall());
		// Set the working directory to the place where the DAE is.
		builder.directory(basePath);
		try {
			// Attempt to run the subprocess.
			Process p = builder.start();
			// Attempt to wait for it to finish.
			synchronized(p) {
				p.waitFor();
			}
		} catch (IOException e) {
			e.printStackTrace();
			crashed = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			crashed = true;
		} catch (Exception e) {
			e.printStackTrace();
			crashed = true;
		}
		done = true;
	}

	public void start ()
	{
		if (t == null)
		{
			// Passes in the run.
			t = new Thread (this, threadName);
			t.start ();
		}
	}
}
