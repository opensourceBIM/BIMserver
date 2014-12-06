package org.bimserver.plugins.serializers;

public interface ProgressReporter {
	void update(long progress, long max);
}
