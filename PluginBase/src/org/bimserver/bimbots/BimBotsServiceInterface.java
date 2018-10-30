package org.bimserver.bimbots;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.Set;

import org.bimserver.interfaces.objects.SObjectType;

public interface BimBotsServiceInterface {
	BimBotsOutput runBimBot(BimBotsInput input, BimBotContext bimBotContext, SObjectType settings) throws BimBotsException;
	boolean requiresGeometry();
	Set<String> getAvailableInputs() throws BimBotsException;
	Set<String> getAvailableOutputs() throws BimBotsException;
	boolean needsRawInput();
}
