package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.List;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.MergeIdentifier;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * This class exists for 2 purposes
 * 	- Performance, the database is only accessed 1 time for reading the initial settings, not for subsequent reads (writes of course always access the database)
 *  - Ease of use, the user does not have to create a database session for every read/write etc...
 *  
 * Warning: The Settings object is reused and not thread safe, so when multiple users change settings at the same time, things could get messy
 */ 
public class SettingsManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(SettingsManager.class);
	private BimDatabase database;
	private Settings settings;

	public SettingsManager(BimDatabase database) {
		this.database = database;
	}
	
	public static Settings createDefaultSettings() {
		Settings settings = StoreFactory.eINSTANCE.createSettings();
		settings.setCustomLogoAddress("http://www.bimserver.org/version/defaultlogo.gif");
		settings.setEmailSenderAddress("");
		settings.setSiteAddress("");
		settings.setSmtpServer("");
		settings.setRegistrationAddition("");
		settings.setHeaderAddition("");
		settings.setFooterAddition("<script type=\"text/javascript\">var _gaq = _gaq || [];_gaq.push(['_setAccount', 'UA-12034708-3']);_gaq.push(['_trackPageview']);(function() {var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);})();</script>");
		settings.setProtocolBuffersPort(8020);
		settings.setAllowSelfRegistration(false);
		settings.setAllowUsersToCreateTopLevelProjects(false);
		settings.setAutoTestClashes(false);
		settings.setCheckinMergingEnabled(false);
		settings.setIntelligentMerging(false);
		settings.setHideUserListForNonAdmin(true);
		settings.setShowVersionUpgradeAvailable(false);
		settings.setCacheOutputFiles(false);
		settings.setMergeIdentifier(MergeIdentifier.GUID);
		return settings;
	}
	
	public synchronized void saveSettings() {
		DatabaseSession session = database.createSession();
		try {
			session.store(settings);
			session.commit();
		} catch (BimserverLockConflictException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	public synchronized Settings getSettings() {
		if (settings == null) {
			DatabaseSession session = database.createSession();
			try {
				IfcModelInterface model = session.getAllOfType(StorePackage.eINSTANCE.getSettings(), false, null);
				List<Settings> allSettings = model.getAll(Settings.class);
				if (allSettings.size() == 1) {
					settings = allSettings.get(0);
				}
			} catch (BimserverDatabaseException e) {
				LOGGER.error("", e);
			} finally {
				session.close();
			}
		}
		return settings;
	}

	public void setSettings(Settings settings) {
		for (EStructuralFeature eStructuralFeature : settings.eClass().getEAllStructuralFeatures()) {
			this.settings.eSet(eStructuralFeature, settings.eGet(eStructuralFeature));
		}
		saveSettings();
	}
}
