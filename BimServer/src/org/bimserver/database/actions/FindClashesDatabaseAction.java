package org.bimserver.database.actions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.ifc2x3.WrappedValue;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Clash;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.EidClash;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.GuidanceProviderException;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineClash;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.UserException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindClashesDatabaseAction extends BimDatabaseAction<Set<? extends Clash>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(FindClashesDatabaseAction.class);
	@SuppressWarnings("unused")
	private final long actingUoid;
	private final ClashDetectionSettings clashDetectionSettings;
	private final BimServer bimServer;

	public FindClashesDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, ClashDetectionSettings clashDetectionSettings,  long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.clashDetectionSettings = clashDetectionSettings;
		this.actingUoid = actingUoid;
	}

	@Override
	public Set<? extends Clash> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Map<Long, Revision> oidToRoidMap = new HashMap<Long, Revision>();

		// Look in the cache
		Set<EidClash> clashDetection = bimServer.getClashDetectionCache().getClashDetection(clashDetectionSettings);
		if (clashDetection != null) {
			return clashDetection;
		}

		Project project = null;
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (Revision revision : clashDetectionSettings.getRevisions()) {
			project = revision.getProject();
			for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
				IfcModel source = new IfcModel();
				getDatabaseSession().getMap(source, concreteRevision.getProject().getId(), concreteRevision.getId(), true);
				source.setDate(concreteRevision.getDate());
				ifcModelSet.add(source);
				for (Long oid : source.keySet()) {
					oidToRoidMap.put(oid, revision);
				}
			}
		}
		IfcModelInterface ifcModel = bimServer.getMergerFactory().createMerger().merge(project, ifcModelSet, false);
		IfcModel newModel = new IfcModel();
		Map<IdEObject, IdEObject> converted = new HashMap<IdEObject, IdEObject>();
		for (IdEObject idEObject : ifcModel.getValues()) {
			if (!clashDetectionSettings.getIgnoredClasses().contains(idEObject.eClass().getName())) {
				cleanupModel(idEObject.eClass(), idEObject, newModel, ifcModel, converted);
			}
		}
		SerializerPlugin serializerPlugin = (SerializerPlugin) bimServer.getPluginManager().getPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializer", true);
		EmfSerializer ifcSerializer = serializerPlugin.createSerializer();
		try {
			ifcSerializer.init(newModel, null, null);
			byte[] bytes = ifcSerializer.getBytes();
			IfcEngine ifcEngine = bimServer.getPluginManager().requireIfcEngine().createIfcEngine();
			try {
				IfcEngineModel ifcEngineModel = ifcEngine.openModel(bytes);
				try {
					Set<IfcEngineClash> clashes = ifcEngineModel.findClashesWithEids(clashDetectionSettings.getMargin());

					Set<EidClash> eidClashes = new HashSet<EidClash>();
					for (IfcEngineClash clash : clashes) {
						EidClash eidClash = StoreFactory.eINSTANCE.createEidClash();
						eidClash.setName1(clash.getName1());
						eidClash.setName2(clash.getName2());
						eidClash.setType1(clash.getType1());
						eidClash.setType2(clash.getType2());
					}

					// Store in cache
					bimServer.getClashDetectionCache().storeClashDetection(clashDetectionSettings, eidClashes);

					for (EidClash clash : eidClashes) {
						IfcRoot object1 = (IfcRoot) newModel.get(clash.getEid1());
						clash.setName1(object1.getName());
						clash.setType1(object1.eClass().getName());
						clash.setRevision1(oidToRoidMap.get(clash.getEid1()));
						IfcRoot object2 = (IfcRoot) newModel.get(clash.getEid2());
						clash.setName2(object2.getName());
						clash.setType2(object2.eClass().getName());
						clash.setRevision2(oidToRoidMap.get(clash.getEid2()));
					}
					return eidClashes;
				} finally {
					ifcEngineModel.close();
				}
			} catch (PluginException e) {
				LOGGER.error("", e);
			} finally {
				ifcEngine.close();
			}
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private IdEObject cleanupModel(EClass originalEClass, IdEObject original, IfcModelInterface newModel, IfcModelInterface ifcModel, Map<IdEObject, IdEObject> converted) throws UserException {
		if (converted.containsKey(original)) {
			return converted.get(original);
		}
		IdEObject newObject = (IdEObject) original.eClass().getEPackage().getEFactoryInstance().create(original.eClass());
		newObject.setOid(original.getOid());
		converted.put(original, newObject);
		if (!(newObject instanceof WrappedValue) && !(newObject instanceof IfcGloballyUniqueId)) {
			newModel.add(newObject.getOid(), newObject);
		}
		GuidanceProvider guidanceProvider;
		try {
			guidanceProvider = bimServer.getPluginManager().requireGuidanceProvider();
		} catch (GuidanceProviderException e) {
			throw new UserException(e);
		}
		for (EStructuralFeature eStructuralFeature : original.eClass().getEAllStructuralFeatures()) {
			if (!guidanceProvider.shouldIgnoreField(originalEClass, original.eClass(), eStructuralFeature)) {
				Object get = original.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EAttribute) {
					if (get instanceof Float || get instanceof Double) {
						EStructuralFeature floatStringFeature = original.eClass().getEStructuralFeature("wrappedValueAsString");
						if (floatStringFeature != null) {
							Object floatString = original.eGet(floatStringFeature);
							newObject.eSet(floatStringFeature, floatString);
						} else {
							newObject.eSet(eStructuralFeature, get);
						}
					} else {
						newObject.eSet(eStructuralFeature, get);
					}
				} else if (eStructuralFeature instanceof EReference) {
					if (get == null) {
					} else {
						if (eStructuralFeature.isMany()) {
							BasicEList<EObject> list = (BasicEList<EObject>) get;
							BasicEList<EObject> toList = (BasicEList<EObject>) newObject.eGet(eStructuralFeature);
							for (Object o : list) {
								if (converted.containsKey(o)) {
									toList.addUnique(converted.get(o));
								} else {
									IdEObject result = cleanupModel(originalEClass, (IdEObject) o, newModel, ifcModel, converted);
									if (result != null) {
										toList.addUnique(result);
									}
								}
							}
						} else {
							if (converted.containsKey(get)) {
								newObject.eSet(eStructuralFeature, converted.get(get));
							} else {
								newObject.eSet(eStructuralFeature, cleanupModel(originalEClass, (IdEObject) get, newModel, ifcModel, converted));
							}
						}
					}
				}
			}
		}
		return newObject;
	}
}