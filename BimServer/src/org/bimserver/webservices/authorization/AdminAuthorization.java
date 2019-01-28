package org.bimserver.webservices.authorization;

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

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class AdminAuthorization extends Authorization {
	public static final byte ID = 5;

	public AdminAuthorization(int expires, TimeUnit expiresUnit) {
		super(expires, expiresUnit);
	}
	
	private AdminAuthorization() {
		super();
	}

	public static AdminAuthorization fromBuffer(ByteBuffer buffer) {
		return new AdminAuthorization();
	}

	public byte getId() {
		return ID;
	}
	
	@Override
	protected int getBufferSize() {
		return 0;
	}

	@Override
	public void getBytes(ByteBuffer buffer) {
	}
}