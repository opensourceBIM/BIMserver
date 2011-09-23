package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SRunResult implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("RunResult");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("runOke", boolean.class));
		sClass.addField(new SField("warnings", java.lang.String.class, true));
		sClass.addField(new SField("errors", java.lang.String.class, true));
		sClass.addField(new SField("output", java.lang.String.class));
	}
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	public SClass getSClass() {
		return sClass;
	}
	
	public Object sGet(SField sField) {
		if (sField.getName().equals("runOke")) {
			return isRunOke();
		}
		if (sField.getName().equals("warnings")) {
			return getWarnings();
		}
		if (sField.getName().equals("errors")) {
			return getErrors();
		}
		if (sField.getName().equals("output")) {
			return getOutput();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private boolean runOke;
	private List<java.lang.String> warnings = new ArrayList<java.lang.String>();
	private List<java.lang.String> errors = new ArrayList<java.lang.String>();
	private java.lang.String output;
	public boolean isRunOke() {
		return runOke;
	}

	public void setRunOke(boolean runOke) {
		this.runOke = runOke;
	}

	public List<java.lang.String> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<java.lang.String> warnings) {
		this.warnings = warnings;
	}

	public List<java.lang.String> getErrors() {
		return errors;
	}

	public void setErrors(List<java.lang.String> errors) {
		this.errors = errors;
	}
	public java.lang.String getOutput() {
		return output;
	}

	public void setOutput(java.lang.String output) {
		this.output = output;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
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
		SRunResult other = (SRunResult) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}