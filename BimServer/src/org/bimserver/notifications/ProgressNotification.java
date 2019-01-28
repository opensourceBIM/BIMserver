package org.bimserver.notifications;

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

import org.bimserver.BimServer;
import org.bimserver.models.store.LongActionState;

public class ProgressNotification extends Notification {

	private LongActionState state;
	private ProgressTopic topic;

	public ProgressNotification(BimServer bimServer, ProgressTopic topic, LongActionState state) {
		super(bimServer);
		this.topic = topic;
		this.state = state;
	}

	@Override
	public void process() {
		topic.updateProgress(state);
	}
}