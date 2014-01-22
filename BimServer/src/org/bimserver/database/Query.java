package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import org.bimserver.emf.QueryInterface;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Query implements QueryInterface {

	public static enum Deep {
		NO,
		YES
	}
	
	private final Integer pid;
	private final Integer rid;
	private final ObjectIDM objectIDM;
	private final Deep deep;
	private final int stopRid;

	private static final Query DEFAULT = new Query();
	
	public static Query getDefault() {
		return DEFAULT;
	}
	
	private Query() {
		this.pid = Database.STORE_PROJECT_ID;
		this.rid = Integer.MAX_VALUE;
		this.stopRid = Integer.MIN_VALUE;
		this.objectIDM = null;
		this.deep = Deep.NO;
	}
	
	public Query(int pid, int rid) {
		this.pid = pid;
		this.rid = rid;
		this.stopRid = Integer.MIN_VALUE;
		this.objectIDM = null;
		this.deep = Deep.NO;
	}
	
	public Query(boolean deep) {
		this.pid = Database.STORE_PROJECT_ID;
		this.rid = Integer.MAX_VALUE;
		this.stopRid = Integer.MIN_VALUE;
		this.objectIDM = null;
		this.deep = deep ? Deep.YES : Deep.NO;
	}

	public Query(Integer pid, Integer rid, Deep deep) {
		this.objectIDM = null;
		this.pid = pid;
		this.rid = rid;
		this.stopRid = Integer.MIN_VALUE;
		this.deep = deep;
	}

	public Query(Integer pid, Integer rid, ObjectIDM objectIDM, Deep deep) {
		this.pid = pid;
		this.rid = rid;
		this.stopRid = Integer.MIN_VALUE;
		this.objectIDM = objectIDM;
		this.deep = deep;
	}
	
	public Query(int pid, int rid, ObjectIDM objectIDM, Deep deep, int stopRid) {
		this.pid = pid;
		this.rid = rid;
		this.stopRid = stopRid;
		this.objectIDM = objectIDM;
		this.deep = deep;
	}

	public int getStopRid() {
		return stopRid;
	}

	public int getPid() {
		return pid;
	}
	
	public int getRid() {
		return rid;
	}

	public boolean isDeep() {
		return deep == Deep.YES;
	}
	
	public ObjectIDM getObjectIDM() {
		return objectIDM;
	}
	
	public boolean shouldIncludeClass(EClass eClass) {
		return objectIDM == null || objectIDM.shouldIncludeClass(eClass, eClass);
	}

	public boolean shouldFollowReference(EClass originalQueryClass, EClass eClass, EStructuralFeature feature) {
		return objectIDM == null || objectIDM.shouldFollowReference(originalQueryClass, eClass, feature);
	}
}