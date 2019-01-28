package org.bimserver;

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

import java.nio.file.Paths;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;

/**
 * @author Ruben de Laat
 *
 *	Use this class to start a BIMserver in your development environment when you have all the BIMserver source code checked out
 *
 */
public class LocalDevBimServerStarter extends AbstractLocalDevBimServerStarter {
	
	public static void main(String[] args) {
		OptionsParser optionsParser = new OptionsParser(args);
		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher(Paths.get("../"));
		new LocalDevBimServerStarter().start(-1, "127.0.0.1", "LocalDev BIMserver (8080)", 8080, 8085, optionsParser.getPluginDirectories(), optionsParser.getHome(), resourceFetcher, Paths.get("../BimServer").resolve("www").toAbsolutePath().toString(), true);
	}
}