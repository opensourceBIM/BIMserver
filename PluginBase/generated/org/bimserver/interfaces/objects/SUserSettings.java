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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SUserSettings implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private List<Long> serializers = new ArrayList<Long>();
	private List<Long> objectIDMs = new ArrayList<Long>();
	private List<Long> renderEngines = new ArrayList<Long>();
	private List<Long> deserializers = new ArrayList<Long>();
	private List<Long> queryEngines = new ArrayList<Long>();
	private List<Long> modelMergers = new ArrayList<Long>();
	private List<Long> modelCompares = new ArrayList<Long>();
	private long defaultModelMergerId = -1;
	private long defaultModelCompareId = -1;
	private long defaultQueryEngineId = -1;
	private long defaultRenderEngineId = -1;
	private long defaultSerializerId = -1;
	private long defaultObjectIDMId = -1;
	private List<Long> services = new ArrayList<Long>();

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
		SUserSettings.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("serializers")) {
			return getSerializers();
		}
		if (sField.getName().equals("objectIDMs")) {
			return getObjectIDMs();
		}
		if (sField.getName().equals("renderEngines")) {
			return getRenderEngines();
		}
		if (sField.getName().equals("deserializers")) {
			return getDeserializers();
		}
		if (sField.getName().equals("queryEngines")) {
			return getQueryEngines();
		}
		if (sField.getName().equals("modelMergers")) {
			return getModelMergers();
		}
		if (sField.getName().equals("modelCompares")) {
			return getModelCompares();
		}
		if (sField.getName().equals("defaultModelMergerId")) {
			return getDefaultModelMergerId();
		}
		if (sField.getName().equals("defaultModelCompareId")) {
			return getDefaultModelCompareId();
		}
		if (sField.getName().equals("defaultQueryEngineId")) {
			return getDefaultQueryEngineId();
		}
		if (sField.getName().equals("defaultRenderEngineId")) {
			return getDefaultRenderEngineId();
		}
		if (sField.getName().equals("defaultSerializerId")) {
			return getDefaultSerializerId();
		}
		if (sField.getName().equals("defaultObjectIDMId")) {
			return getDefaultObjectIDMId();
		}
		if (sField.getName().equals("services")) {
			return getServices();
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
		if (sField.getName().equals("serializers")) {
			setSerializers((List<Long>)val);
			return;
		}
		if (sField.getName().equals("objectIDMs")) {
			setObjectIDMs((List<Long>)val);
			return;
		}
		if (sField.getName().equals("renderEngines")) {
			setRenderEngines((List<Long>)val);
			return;
		}
		if (sField.getName().equals("deserializers")) {
			setDeserializers((List<Long>)val);
			return;
		}
		if (sField.getName().equals("queryEngines")) {
			setQueryEngines((List<Long>)val);
			return;
		}
		if (sField.getName().equals("modelMergers")) {
			setModelMergers((List<Long>)val);
			return;
		}
		if (sField.getName().equals("modelCompares")) {
			setModelCompares((List<Long>)val);
			return;
		}
		if (sField.getName().equals("defaultModelMergerId")) {
			setDefaultModelMergerId((Long)val);
			return;
		}
		if (sField.getName().equals("defaultModelCompareId")) {
			setDefaultModelCompareId((Long)val);
			return;
		}
		if (sField.getName().equals("defaultQueryEngineId")) {
			setDefaultQueryEngineId((Long)val);
			return;
		}
		if (sField.getName().equals("defaultRenderEngineId")) {
			setDefaultRenderEngineId((Long)val);
			return;
		}
		if (sField.getName().equals("defaultSerializerId")) {
			setDefaultSerializerId((Long)val);
			return;
		}
		if (sField.getName().equals("defaultObjectIDMId")) {
			setDefaultObjectIDMId((Long)val);
			return;
		}
		if (sField.getName().equals("services")) {
			setServices((List<Long>)val);
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
	
	public List<Long> getSerializers() {
		return serializers;
	}

	public void setSerializers(List<Long> serializers) {
		this.serializers = serializers;
	}
	
	public List<Long> getObjectIDMs() {
		return objectIDMs;
	}

	public void setObjectIDMs(List<Long> objectIDMs) {
		this.objectIDMs = objectIDMs;
	}
	
	public List<Long> getRenderEngines() {
		return renderEngines;
	}

	public void setRenderEngines(List<Long> renderEngines) {
		this.renderEngines = renderEngines;
	}
	
	public List<Long> getDeserializers() {
		return deserializers;
	}

	public void setDeserializers(List<Long> deserializers) {
		this.deserializers = deserializers;
	}
	
	public List<Long> getQueryEngines() {
		return queryEngines;
	}

	public void setQueryEngines(List<Long> queryEngines) {
		this.queryEngines = queryEngines;
	}
	
	public List<Long> getModelMergers() {
		return modelMergers;
	}

	public void setModelMergers(List<Long> modelMergers) {
		this.modelMergers = modelMergers;
	}
	
	public List<Long> getModelCompares() {
		return modelCompares;
	}

	public void setModelCompares(List<Long> modelCompares) {
		this.modelCompares = modelCompares;
	}
	
	public long getDefaultModelMergerId() {
		return defaultModelMergerId;
	}

	public void setDefaultModelMergerId(long defaultModelMergerId) {
		this.defaultModelMergerId = defaultModelMergerId;
	}
	
	public long getDefaultModelCompareId() {
		return defaultModelCompareId;
	}

	public void setDefaultModelCompareId(long defaultModelCompareId) {
		this.defaultModelCompareId = defaultModelCompareId;
	}
	
	public long getDefaultQueryEngineId() {
		return defaultQueryEngineId;
	}

	public void setDefaultQueryEngineId(long defaultQueryEngineId) {
		this.defaultQueryEngineId = defaultQueryEngineId;
	}
	
	public long getDefaultRenderEngineId() {
		return defaultRenderEngineId;
	}

	public void setDefaultRenderEngineId(long defaultRenderEngineId) {
		this.defaultRenderEngineId = defaultRenderEngineId;
	}
	
	public long getDefaultSerializerId() {
		return defaultSerializerId;
	}

	public void setDefaultSerializerId(long defaultSerializerId) {
		this.defaultSerializerId = defaultSerializerId;
	}
	
	public long getDefaultObjectIDMId() {
		return defaultObjectIDMId;
	}

	public void setDefaultObjectIDMId(long defaultObjectIDMId) {
		this.defaultObjectIDMId = defaultObjectIDMId;
	}
	
	public List<Long> getServices() {
		return services;
	}

	public void setServices(List<Long> services) {
		this.services = services;
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
		SUserSettings other = (SUserSettings) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}