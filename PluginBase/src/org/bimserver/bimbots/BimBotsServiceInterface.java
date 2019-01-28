package org.bimserver.bimbots;

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

import java.util.Set;

import org.bimserver.database.queries.om.Query;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.PluginConfiguration;

public interface BimBotsServiceInterface {
	/**
	 * This method calls the BIMbot
	 * 
	 * @param input
	 *            Input object, contains a bit of information, but mainly
	 *            provides the model with getIfcModel()
	 * @param bimBotContext
	 *            A context objects. Can currently be used by the BIMbot to
	 *            provide progress indication. Also the current username can be
	 *            gotten from this object
	 * @param settings
	 *            The (user-specific) settings for this BIMbot call
	 * @return The result of the BIMbot.
	 * @throws BimBotsException
	 */
	BimBotsOutput runBimBot(BimBotsInput input, BimBotContext bimBotContext, PluginConfiguration settings) throws BimBotsException;

	/**
	 * @return A Set of schema's this BIMbot can handle as an input
	 * @throws BimBotsException
	 */
	Set<String> getAvailableInputs() throws BimBotsException;

	/**
	 * @return A Set of schema's this BIMbot can output
	 * @throws BimBotsException
	 */
	Set<String> getAvailableOutputs() throws BimBotsException;

	/**
	 * @return Whether this BIMbot requires geometry (IfcProduct.getGeometry).
	 *         The main reason for this setting is performance. Services that
	 *         don't need geometry can perform much faster without loading all
	 *         geometry from a model/the database.
	 */
	boolean requiresGeometry();

	/**
	 * @return Whether this BIMbot requires the raw input (byte[]) of the model.
	 *         This can be useful when for example sending the input to other
	 *         bots. In that case a serializer/deserialize cycle can be avoided.
	 */
	boolean needsRawInput();

	/**
	 * @return Whether or not the BIMbot thinks the whole model should be
	 *         preloaded. This can be much faster in some cases, as the latency
	 *         can quickly add-up loading the data in individual calls
	 */
	boolean preloadCompleteModel();

	/**
	 * NOT IMPLEMENTED YET ON THE CALLING SIDE
	 * 
	 * The BIMbot can specify a query that will be applied to the input
	 * 
	 * @param packageMetaData
	 * @return The query to apply to the input before submitting it to
	 *         runBimBot, or null for no query (the whole model will be
	 *         submitted)
	 */
	Query getPreloadQuery(PackageMetaData packageMetaData);
}
