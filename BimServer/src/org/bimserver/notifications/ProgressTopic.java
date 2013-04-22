package org.bimserver.notifications;

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

import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.LongActionState;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ProgressTopic extends Topic {

	private long uoid;
	private SProgressTopicType type;
	private String description;
	private ProgressTopicKey key;
	private LongActionState lastProgress;

	public ProgressTopic(ProgressTopicKey key, long uoid, SProgressTopicType type, String description) {
		this.key = key;
		this.uoid = uoid;
		this.type = type;
		this.description = description;
	}
	
	public ProgressTopicKey getKey() {
		return key;
	}
	
	public void updateProgress(LongActionState state) {
		lastProgress = state;
		for (EndPoint endPoint : getEndPoints()) {
			try {
				endPoint.getNotificationInterface().progress(key.getId(), new SConverter().convertToSObject(state));
			} catch (UserException e) {
				e.printStackTrace();
			} catch (ServerException e) {
				e.printStackTrace();
			}
		}
	}
	
	public LongActionState getLastProgress() {
		return lastProgress;
	}
	
	public SProgressTopicType getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public void register(EndPoint endPoint) throws TopicRegisterException {
		if (endPoint.getUoid() != uoid) {
			throw new TopicRegisterException("This user cannot register for updates on this Topic");
		}
		super.register(endPoint);
	}

	public void unregister(EndPoint endPoint) throws TopicRegisterException {
		super.unregister(endPoint);
	}

	public void close() {
	}
}