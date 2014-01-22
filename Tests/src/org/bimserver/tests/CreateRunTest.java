package org.bimserver.tests;

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
import java.io.PrintWriter;

public class CreateRunTest {
	public static void main(String[] args) {
		new CreateRunTest().start();
	}

	private void start() {
		try {
			PrintWriter out = new PrintWriter(new File("runtest.sh"));
			out.println("#!/bin/sh");
			addEclipseProject(out, new File("BimCombined"));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addEclipseProject(PrintWriter out, File projectFolder) {
	}
}