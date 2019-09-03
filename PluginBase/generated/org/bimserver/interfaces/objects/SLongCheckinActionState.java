package org.bimserver.interfaces.objects;

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
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SLongCheckinActionState extends SLongActionState implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private long roid;
	private int deserializeErrorCode;

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public UUID getUuid() {
		return this.uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public int getRid() {
		return rid;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SLongCheckinActionState.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("start")) {
			return getStart();
		}
		if (sField.getName().equals("end")) {
			return getEnd();
		}
		if (sField.getName().equals("progress")) {
			return getProgress();
		}
		if (sField.getName().equals("state")) {
			return getState();
		}
		if (sField.getName().equals("title")) {
			return getTitle();
		}
		if (sField.getName().equals("stage")) {
			return getStage();
		}
		if (sField.getName().equals("errors")) {
			return getErrors();
		}
		if (sField.getName().equals("warnings")) {
			return getWarnings();
		}
		if (sField.getName().equals("infos")) {
			return getInfos();
		}
		if (sField.getName().equals("topicId")) {
			return getTopicId();
		}
		if (sField.getName().equals("roid")) {
			return getRoid();
		}
		if (sField.getName().equals("deserializeErrorCode")) {
			return getDeserializeErrorCode();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		if (sField.getName().equals("uuid")) {
			return getUuid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	@SuppressWarnings("unchecked")

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("start")) {
			setStart((Date)val);
			return;
		}
		if (sField.getName().equals("end")) {
			setEnd((Date)val);
			return;
		}
		if (sField.getName().equals("progress")) {
			setProgress((Integer)val);
			return;
		}
		if (sField.getName().equals("state")) {
			setState((SActionState)val);
			return;
		}
		if (sField.getName().equals("title")) {
			setTitle((String)val);
			return;
		}
		if (sField.getName().equals("stage")) {
			setStage((Integer)val);
			return;
		}
		if (sField.getName().equals("errors")) {
			setErrors((List<String>)val);
			return;
		}
		if (sField.getName().equals("warnings")) {
			setWarnings((List<String>)val);
			return;
		}
		if (sField.getName().equals("infos")) {
			setInfos((List<String>)val);
			return;
		}
		if (sField.getName().equals("topicId")) {
			setTopicId((Long)val);
			return;
		}
		if (sField.getName().equals("roid")) {
			setRoid((Long)val);
			return;
		}
		if (sField.getName().equals("deserializeErrorCode")) {
			setDeserializeErrorCode((Integer)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		if (sField.getName().equals("rid")) {
			setRid((Integer)val);
			return;
		}
		if (sField.getName().equals("uuid")) {
			setUuid((UUID)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public long getRoid() {
		return roid;
	}

	public void setRoid(long roid) {
		this.roid = roid;
	}
	
	public int getDeserializeErrorCode() {
		return deserializeErrorCode;
	}

	public void setDeserializeErrorCode(int deserializeErrorCode) {
		this.deserializeErrorCode = deserializeErrorCode;
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
		SLongCheckinActionState other = (SLongCheckinActionState) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}