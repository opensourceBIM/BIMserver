package org.bimserver.test.framework;

import java.io.File;

public class TestResult {
	private long startTime;
	private long endTime;
	private final File file;
	private String description;
	private ResultCode resultCode;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
		done();
	}

	enum ResultCode {
		OKE, SERVER_COMMIT_ERROR, OTHER_SERVER_ERROR, COMPARE_ERROR;
	}

	public TestResult(File sourceFile) {
		file = sourceFile;
		startTime = System.nanoTime();
	}

	public File getFile() {
		return file;
	}

	public long getTotalTime() {
		return endTime - startTime;
	}

	public void done() {
		endTime = System.nanoTime();
	}
}