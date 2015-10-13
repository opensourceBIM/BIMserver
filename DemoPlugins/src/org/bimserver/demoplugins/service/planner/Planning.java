package org.bimserver.demoplugins.service.planner;

import java.util.LinkedHashSet;
import java.util.Set;

public class Planning {
	
	private final Set<Task> tasks = new LinkedHashSet<>();

	public void add(Task task) {
		tasks.add(task);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planning other = (Planning) obj;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Task task : tasks) {
			sb.append(task + " - ");
		}
		sb.delete(sb.length() - 2, sb.length());
		return sb.toString();
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}
}