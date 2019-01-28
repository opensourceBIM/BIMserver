package org.bimserver.plugins.serializers;

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

public class StagingProgressReporter implements ProgressReporter {

	private ProgressReporter progressReporter;
	private int nrOfStages;
	private int currentStage;

	public StagingProgressReporter(ProgressReporter progressReporter, int nrOfStages) {
		this.progressReporter = progressReporter;
		this.nrOfStages = nrOfStages;
	}
	
	public void incStage() {
		currentStage++;
	}

	@Override
	public void update(long progress, long max) {
		// TODO can probably do this without floatingpoints...
		
		float perc = (float)progress / (max * nrOfStages);
		float basePerc = (float)currentStage / nrOfStages;
		float totalPerc = perc + basePerc;
		if (progress + 1 == max && (currentStage + 1) == nrOfStages) {
			progressReporter.update(1000, 1000);
		} else {
			progressReporter.update((long) (totalPerc * 1000), 1000);
		}
	}

	@Override
	public void setTitle(String stage) {
		// TODO Auto-generated method stub
		
	}
}