package org.bimserver.database.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.cache.ClashDetectionCache;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.log.AccessMethod;
import org.bimserver.database.store.Clash;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.EidClash;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.ifc.emf.Ifc2x3.IfcGloballyUniqueId;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.ifc.emf.Ifc2x3.WrappedValue;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifcengine.FailSafeIfcEngine;
import org.bimserver.ifcengine.IfcEngineException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.ifcengine.IfcEngineModel;
import org.bimserver.merging.Merger;
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
	private final long actingUoid;
	private final IfcEngineFactory ifcEngineFactory;
	private final SchemaDefinition schema;
	private final ClashDetectionSettings clashDetectionSettings;
	private final FieldIgnoreMap fieldIgnoreMap;

	public FindClashesDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, ClashDetectionSettings clashDetectionSettings, SchemaDefinition schema,
			IfcEngineFactory ifcEngineFactory, FieldIgnoreMap fieldIgnoreMap, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.fieldIgnoreMap = fieldIgnoreMap;
		this.clashDetectionSettings = clashDetectionSettings;
		this.schema = schema;
		this.ifcEngineFactory = ifcEngineFactory;
		this.actingUoid = actingUoid;
	}

	@Override
	public Set<? extends Clash> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Map<Long, Revision> oidToRoidMap = new HashMap<Long, Revision>();

		// Look in the cache
		Set<EidClash> clashDetection = ClashDetectionCache.getInstance().getClashDetection(clashDetectionSettings);
		if (clashDetection != null) {
			return clashDetection;
		}

		Project project = null;
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (Revision revision : clashDetectionSettings.getRevisions()) {
			project = revision.getProject();
			for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
				IfcModel source = getDatabaseSession().getMap(concreteRevision.getProject().getId(), concreteRevision.getId(), true);
				source.setDate(concreteRevision.getDate());
				ifcModelSet.add(source);
				for (Long oid : source.keySet()) {
					oidToRoidMap.put(oid, revision);
				}
			}
		}
		IfcModel ifcModel = new Merger().merge(project, ifcModelSet, false);
		IfcModel newModel = new IfcModel();
		Map<IdEObject, IdEObject> converted = new HashMap<IdEObject, IdEObject>();
		for (IdEObject idEObject : ifcModel.getValues()) {
			if (!clashDetectionSettings.getIgnoredClasses().contains(idEObject.eClass().getName())) {
				cleanupModel(idEObject.eClass(), idEObject, newModel, ifcModel, converted);
			}
		}
		IfcStepSerializer ifcStepSerializer = new IfcStepSerializer(null, getUserByUoid(actingUoid), "", newModel, schema);
		try {
			byte[] bytes = ifcStepSerializer.getBytes();
			FailSafeIfcEngine failSafeIfcEngine = ifcEngineFactory.createFailSafeIfcEngine();
			try {
				IfcEngineModel ifcEngineModel = failSafeIfcEngine.openModel(bytes);
				try {
					Set<EidClash> clashes = ifcEngineModel.findClashesByEid(clashDetectionSettings.getMargin());

					// Store in cache
					ClashDetectionCache.getInstance().storeClashDetection(clashDetectionSettings, clashes);

					for (EidClash clash : clashes) {
						IfcRoot object1 = (IfcRoot) newModel.get(clash.getEid1());
						clash.setName1(object1.getName());
						clash.setType1(object1.eClass().getName());
						clash.setRevision1(oidToRoidMap.get(clash.getEid1()));
						IfcRoot object2 = (IfcRoot) newModel.get(clash.getEid2());
						clash.setName2(object2.getName());
						clash.setType2(object2.eClass().getName());
						clash.setRevision2(oidToRoidMap.get(clash.getEid2()));
					}
					return clashes;
				} finally {
					ifcEngineModel.close();
				}
			} catch (IfcEngineException e) {
				LOGGER.error("", e);
			} finally {
				failSafeIfcEngine.close();
			}
		} catch (IfcEngineException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private IdEObject cleanupModel(EClass originalEClass, IdEObject original, IfcModel newModel, IfcModel ifcModel, Map<IdEObject, IdEObject> converted) {
		if (converted.containsKey(original)) {
			return converted.get(original);
		}
		IdEObject newObject = (IdEObject) original.eClass().getEPackage().getEFactoryInstance().create(original.eClass());
		newObject.setOid(original.getOid());
		converted.put(original, newObject);
		if (!(newObject instanceof WrappedValue) && !(newObject instanceof IfcGloballyUniqueId)) {
			newModel.add(newObject.getOid(), newObject);
		}
		for (EStructuralFeature eStructuralFeature : original.eClass().getEAllStructuralFeatures()) {
			if (!fieldIgnoreMap.shouldIgnoreField(originalEClass, original.eClass(), eStructuralFeature)) {
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