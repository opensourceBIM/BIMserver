package org.bimserver.database.actions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.Service;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.Clash;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.EidClash;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifcengine.FailSafeIfcEngine;
import org.bimserver.ifcengine.IfcEngineException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.ifcengine.IfcEngineModel;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.shared.UserException;
import org.bimserver.utils.TempUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FindClashesDatabaseAction extends BimDatabaseAction<Set<? extends Clash>> {
	private static File tempDir;
	private static int dumpCounter = 0;

	static {
		tempDir = TempUtils.makeTempDir("bimserver" + File.separator + Service.class.hashCode());
	}

	private final SClashDetectionSettings sClashDetectionSettings;
	private final long actingUoid;
	private final IfcEngineFactory ifcEngineFactory;
	private final SchemaDefinition schema;

	public FindClashesDatabaseAction(AccessMethod accessMethod, SClashDetectionSettings sClashDetectionSettings, SchemaDefinition schema, IfcEngineFactory ifcEngineFactory, long actingUoid) {
		super(accessMethod);
		this.sClashDetectionSettings = sClashDetectionSettings;
		this.schema = schema;
		this.ifcEngineFactory = ifcEngineFactory;
		this.actingUoid = actingUoid;
	}

	@Override
	public Set<? extends Clash> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Map<Long, Revision> oidToRoidMap = new HashMap<Long, Revision>();
		Project project = null;
		Set<IfcModel> ifcModels = new HashSet<IfcModel>();
		for (Long roid : sClashDetectionSettings.getRevisions()) {
			Revision revision = bimDatabaseSession.getRevisionByRoid(roid);
			project = revision.getProject();
			for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
				IfcModel source = new IfcModel(bimDatabaseSession.getMap(concreteRevision.getProject().getId(), concreteRevision.getId()).getMap());
				ifcModels.add(source);
				for (Long oid : source.keySet()) {
					oidToRoidMap.put(oid, revision);
				}
			}
		}
		IfcModel ifcModel = BimDatabaseAction.merge(project, ifcModels);
		IfcModel newModel = new IfcModel();
		Map<IdEObject, IdEObject> converted = new HashMap<IdEObject, IdEObject>();
		for (IdEObject idEObject : ifcModel.getValues()) {
			cleanupModel(idEObject, newModel, ifcModel, new HashSet<String>(sClashDetectionSettings.getIgnoredClasses()), converted);
		}
		File file = createTempFile();
		IfcStepSerializer ifcStepSerializer = new IfcStepSerializer(null, bimDatabaseSession
				.getUserByUoid(actingUoid), file.getName(), newModel, schema);
		try {
			ifcStepSerializer.writeToFile(file);
			FailSafeIfcEngine failSafeIfcEngine = ifcEngineFactory.createFailSafeIfcEngine();
			try {
				IfcEngineModel ifcEngineModel = failSafeIfcEngine.openModel(file);
				try {
					Set<EidClash> clashes = ifcEngineModel.findClashesByEid(sClashDetectionSettings.getMargin());
					ifcEngineModel.close();
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
				e.printStackTrace();
			} finally {
				failSafeIfcEngine.close();
			}
		} catch (SerializerException e) {
			e.printStackTrace();
		}
		return null;
	}

	private synchronized static int incDumpCounter() {
		return ++dumpCounter;
	}

	public static File createTempFile() {
		File makeTempFile = TempUtils.makeTempFile(tempDir, (incDumpCounter()) + ".ifc");
		try {
			makeTempFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return makeTempFile;
	}
	
	@SuppressWarnings("unchecked")
	private IdEObject cleanupModel(IdEObject original, IfcModel newModel, IfcModel ifcModel, Set<String> ignoredClasses, Map<IdEObject, IdEObject> converted) {
		if (converted.containsKey(original)) {
			return converted.get(original);
		}
		if (!ignoredClasses.contains(original.eClass().getName())) {
			IdEObject newObject = (IdEObject) original.eClass().getEPackage().getEFactoryInstance().create(original.eClass());
			newObject.setOid(original.getOid());
			converted.put(original, newObject);
			for (EStructuralFeature eStructuralFeature : original.eClass().getEAllStructuralFeatures()) {
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
									IdEObject result = cleanupModel((IdEObject) o, newModel, ifcModel, ignoredClasses, converted);
									if (result != null) {
										toList.addUnique(result);
									}
								}
							}
						} else {
							if (converted.containsKey(get)) {
								newObject.eSet(eStructuralFeature, converted.get(get));
							} else {
								newObject.eSet(eStructuralFeature, cleanupModel((IdEObject) get, newModel, ifcModel, ignoredClasses, converted));
							}
						}
					}
				}
			}
			newModel.add(newObject.getOid(), newObject);
			return newObject;
		}
		return null;
	}
}