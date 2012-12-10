package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.slf4j.LoggerFactory;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

public class VirtualClassLoader extends ClassLoader {
	private final VirtualFile baseDir;

	public VirtualClassLoader(ClassLoader parent, VirtualFile baseDir) {
		super(parent);
		this.baseDir = baseDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		VirtualFile virtualFile = baseDir.getClass(name);
		if (virtualFile != null) {
			byte[] bytes = virtualFile.getData();
			return defineClass(name, bytes, 0, bytes.length);
		}
		if (name.equals("org.bimserver.jqep.QueryInterface")) {
			return super.findClass(name);
		} else {
			LoggerFactory.getLogger(VirtualClassLoader.class).info(name);
			throw new ClassNotFoundException();
		}
	}
}