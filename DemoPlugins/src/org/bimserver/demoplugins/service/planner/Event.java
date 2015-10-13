package org.bimserver.demoplugins.service.planner;

import java.util.GregorianCalendar;

public class Event implements Comparable<Event> {
	private String guid;
	private String type;
	private String nlSfb;
	private String material;
	private String task;
	private String resource;
	private String taskName;
	private GregorianCalendar taskStart;
	private GregorianCalendar taskFinish;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNlSfb() {
		return nlSfb;
	}

	public void setNlSfb(String nlSfb) {
		this.nlSfb = nlSfb;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public GregorianCalendar getTaskStart() {
		return taskStart;
	}

	public void setTaskStart(GregorianCalendar taskStart) {
		this.taskStart = taskStart;
	}

	public GregorianCalendar getTaskFinish() {
		return taskFinish;
	}

	public void setTaskFinish(GregorianCalendar taskFinish) {
		this.taskFinish = taskFinish;
	}

	@Override
	public int compareTo(Event o) {
		return taskStart.compareTo(o.taskStart);
	}
}