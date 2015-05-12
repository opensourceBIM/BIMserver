package net.sourceforge.osexpress.parser;

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

public class ExternalId {

	/*
	 * may represent an id of a schema referenced or used by another schema with
	 * its new name if it exists/ may also represent a couple id-type
	 */

	public String schema; /* schema from which this element is referenced/used */
	public String id;
	public String rename;
	public ExpressParserTokenTypes type;

	public ExternalId(String id) {
		this.id = id;
	}

	public ExternalId(String id, ExpressParserTokenTypes type) {
		this.id = id;
		this.type = type;
	}

	public void setSchema(String s) {
		schema = s;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}
}
