package org.bimserver.database;

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

public class UncheckedBimserverDatabaseException extends RuntimeException {

	private static final long serialVersionUID = 3947604679506343680L;

	public UncheckedBimserverDatabaseException(String message, Throwable e) {
		super(message, e);
	}

	public UncheckedBimserverDatabaseException(String message) {
		super(message);
	}
	
	public UncheckedBimserverDatabaseException(Throwable e) {
		super(e);
	}
}
