package org.bimserver.services;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.bimserver.shared.Token;
import org.bimserver.utils.GeneratorUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenManager implements Job {

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenManager.class);
	private static final int TOKEN_TTL_SECONDS = 60*60; // one hour
	private final HashMap<Token, Long> tokens = new HashMap<Token, Long>();

	public synchronized long getUoid(Token token) {
		return tokens.get(token);
	}

	public synchronized Token newToken(long uoid) {
		Date expires = new Date(new Date().getTime() + (TOKEN_TTL_SECONDS * 1000));
		Token token = new Token(GeneratorUtils.generateToken(), expires);
		tokens.put(token, uoid);
		return token;
	}

	public synchronized void cleanup() {
		LOGGER.info("Cleaning up tokens");
		Date now = new Date();
		Iterator<Token> iterator = tokens.keySet().iterator();
		while (iterator.hasNext()) {
			Token token = iterator.next();
			if (token.getExpiresAsDate().before(now)) {
				LOGGER.info("Removing token " + token.getTokenString() + " because it is expired");
				iterator.remove();
			}
		}
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		cleanup();
	}

	public synchronized int getNumberOfTokens() {
		return tokens.size();
	}

	public synchronized void remove(Token token) {
		tokens.remove(token);
	}
}