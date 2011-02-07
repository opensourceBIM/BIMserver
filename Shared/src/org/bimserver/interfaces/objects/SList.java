package org.bimserver.interfaces.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="result")
@XmlAccessorType(XmlAccessType.NONE)
public class SList {
	@XmlElement
	private List<?> list;

	public void setList(List<?> list) {
		this.list = list;
	}

	public List<?> getList() {
		return list;
	}
}