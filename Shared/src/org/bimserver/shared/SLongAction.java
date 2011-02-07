package org.bimserver.shared;

import java.util.Date;

public class SLongAction {
	private String identification;
	private long userOid;
	private Date start;
	private String username;
	private String name;

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getIdentification() {
		return identification;
	}

	public void setUserOid(long userOid) {
		this.userOid = userOid;
	}

	public long getUserOid() {
		return userOid;
	}

	public void setStart(Date start) {
		this.start = start;
	}
	
	public Date getStart() {
		return start;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
