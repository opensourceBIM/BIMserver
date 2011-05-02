package org.bimserver;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EStructuralFeature;

/*
 * This class exists for 2 purposes
 * 	- Performance, the database is only accessed 1 time for reading the initial settings, not for subsequent reads (writes of course always access the database)
 *  - Ease of use, the user does not have to create a database session for every read/write etc...
 *  
 * Warning: The Settings object is reused and not thread safe, so when multiple users change settings at the same time, things could get messy
 */ 
public class SettingsManager {

	private BimDatabase database;
	private Settings settings;

	public SettingsManager(BimDatabase database) {
		this.database = database;
	}
	
	public static Settings createDefaultSettings() {
		Settings settings = StoreFactory.eINSTANCE.createSettings();
		settings.setCustomLogoAddress("http://www.bimserver.org/version/defaultlogo.gif");
		settings.setEmailSenderAddress("");
		settings.setEnabledExportTypes("IFC,IFCXML,COLLADA,CITYGML,KMZ");
		settings.setSiteAddress("");
		settings.setSmtpServer("");
		settings.setRegistrationAddition("");
		settings.setHeaderAddition("");
		settings.setFooterAddition("");
		return settings;
	}
	
	public synchronized void saveSettings() {
		BimDatabaseSession session = database.createSession(true);
		try {
			session.store(settings);
			session.commit();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public synchronized Settings getSettings() {
		if (settings == null) {
			BimDatabaseSession session = database.createReadOnlySession();
			try {
				IfcModel model = session.getAllOfType(StorePackage.eINSTANCE.getSettings(), false);
				if (model.size() == 1) {
					IdEObject idEObject = model.getValues().iterator().next();
					if (idEObject instanceof Settings) {
						settings = (Settings) idEObject;
					}
				}
			} catch (BimDatabaseException e) {
				e.printStackTrace();
			} catch (BimDeadlockException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return settings;
	}

	public Set<String> getEnabledExportTypesAsSet() {
		Set<String> resultTypes = new HashSet<String>();
		String[] split = getSettings().getEnabledExportTypes().split(",");
		for (String s : split) {
			resultTypes.add(s);
		}
		return resultTypes;
	}

	public void updateEnabledResultTypes(Set<String> resultTypes) {
		String enabledExportTypes = "";
		for (String resultType : resultTypes) {
			enabledExportTypes += resultType + ",";
		}
		if (enabledExportTypes.endsWith(",")) {
			enabledExportTypes = enabledExportTypes.substring(0, enabledExportTypes.length() - 1);
		}
		getSettings().setEnabledExportTypes(enabledExportTypes);
		saveSettings();
	}

	public void setSettings(Settings settings) {
		for (EStructuralFeature eStructuralFeature : settings.eClass().getEAllStructuralFeatures()) {
			this.settings.eSet(eStructuralFeature, settings.eGet(eStructuralFeature));
		}
		saveSettings();
	}
}
