package org.bimserver.version;

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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Version;
import org.bimserver.plugins.ResourceFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VersionChecker {
	private static final Logger LOGGER = LoggerFactory.getLogger(VersionChecker.class);
	private GregorianCalendar lastCheck;
	private Version onlineVersion;
	private final ResourceFetcher resourceFetcher;

	public VersionChecker(ResourceFetcher resourceFetcher) {
		this.resourceFetcher = resourceFetcher;
	}

	public synchronized Version getOnlineVersion() {
		if (lastCheck == null || lastCheck.before(getReferenceDate())) {
			LOGGER.info("Fetching online version info");
			try {
				URL url = new URL("http://www.bimserver.org/version/latest.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Version.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				onlineVersion = (Version) unmarshaller.unmarshal(url);
				lastCheck = new GregorianCalendar();
				return onlineVersion;
			} catch (UnmarshalException e) {
				LOGGER.error("", e);
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			} catch (JAXBException e) {
				LOGGER.error("", e);
			}
			if (onlineVersion == null) {
				onlineVersion = StoreFactory.eINSTANCE.createVersion();
				onlineVersion.setDownloadUrl("unknown");
				onlineVersion.setMajor(-1);
				onlineVersion.setMinor(-1);
				onlineVersion.setRevision(-1);
				onlineVersion.setSupportEmail("unknown");
				onlineVersion.setSupportUrl("unknown");
				onlineVersion.setDate(new Date(0));
				lastCheck = new GregorianCalendar();
			}
		}
		return onlineVersion;
	}

	private GregorianCalendar getReferenceDate() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.add(Calendar.HOUR_OF_DAY, -1);
		return gregorianCalendar;
	}

	public Version getLocalVersion() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Version.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Version version = (Version) unmarshaller.unmarshal(resourceFetcher.getResource("version.xml"));
			return version;
		} catch (JAXBException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public boolean updateNeeded() {
		Version localVersion = getLocalVersion();
		Version onlineVersion = getOnlineVersion();
		if (localVersion.getMajor() < onlineVersion.getMajor()) {
			return true;
		} else if (localVersion.getMajor() == onlineVersion.getMajor()) {
			if (localVersion.getMinor() < onlineVersion.getMinor()) {
				return true;
			} else if (localVersion.getMinor() == onlineVersion.getMinor()) {
				if (localVersion.getRevision() < onlineVersion.getRevision()) {
					return true;
				}
			}
		}
		return false;
	}
}