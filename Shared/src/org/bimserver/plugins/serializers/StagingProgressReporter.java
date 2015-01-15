package org.bimserver.plugins.serializers;

import org.bimserver.plugins.serializers.ProgressReporter;

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
}