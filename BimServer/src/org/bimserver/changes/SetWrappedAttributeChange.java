package org.bimserver.changes;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcBoolean;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class SetWrappedAttributeChange implements Change {

	private Long oid;
	private String attributeName;
	private String type;
	private Object value;

	public SetWrappedAttributeChange(Long oid, String attributeName, String type, Object value) {
		this.oid = oid;
		this.attributeName = attributeName;
		this.type = type;
		this.value = value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(BimServer bimServer, Revision previousRevision, Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession, Map<Long, HashMapVirtualObject> created, Map<Long, HashMapVirtualObject> deleted) throws UserException, BimserverLockConflictException,
			BimserverDatabaseException, IOException, QueryException {
		PackageMetaData packageMetaData = databaseSession.getMetaDataManager().getPackageMetaData(project.getSchema());
		
		Query query = new Query(packageMetaData);
		QueryPart queryPart = query.createQueryPart();
		queryPart.addOid(oid);
		
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(previousRevision.getOid()), packageMetaData);
		HashMapVirtualObject object = queryObjectProvider.next();
		
		EClass eClass = databaseSession.getEClassForOid(oid);
		if (object == null) {
			object = created.get(oid);
		}
		if (object == null) {
			throw new UserException("No object of type \"" + eClass.getName() + "\" with oid " + oid + " found in project with pid " + project.getId());
		}
		EReference eReference = packageMetaData.getEReference(eClass.getName(), attributeName);
		if (eReference == null) {
			throw new UserException("No reference with the name \"" + attributeName + "\" found in class \"" + eClass.getName() + "\"");
		}
		if (value instanceof List && eReference.isMany()) {
			List sourceList = (List)value;
			if (!eReference.isMany()) {
				throw new UserException("Attribute is not of type 'many'");
			}
			List list = (List)object.eGet(eReference);
			for (Object o : sourceList) {
				if (eReference.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
					List asStringList = (List)object.eGet(object.eClass().getEStructuralFeature(attributeName + "AsString"));
					asStringList.add(String.valueOf(o));
				}
				list.add(o);
			}
			databaseSession.save(object, concreteRevision.getId());
		} else {
			if (eReference.isMany()) {
				throw new UserException("Attribute is not of type 'single'");
			}
			if (eReference.getEType() instanceof EEnum) {
				EEnum eEnum = (EEnum) eReference.getEType();
				object.set(eReference.getName(), eEnum.getEEnumLiteral(((String) value).toUpperCase()).getInstance());
			} else {
				EClass typeEClass = (EClass) packageMetaData.getEClassifier(type);
				if (typeEClass.getEAnnotation("wrapped") == null) {
					throw new UserException("Not a wrapped type");
				}
				HashMapWrappedVirtualObject wrappedObject = new HashMapWrappedVirtualObject(typeEClass);
				if (typeEClass == Ifc2x3tc1Package.eINSTANCE.getIfcBoolean()) {
					if ((Boolean)value == true) {
						value = Tristate.TRUE;
					} else {
						value = Tristate.FALSE;
					}
				}
				wrappedObject.set(wrappedObject.eClass().getEStructuralFeature("wrappedValue").getName(), value);
				object.set(eReference.getName(), wrappedObject);
			}
//			if (value instanceof Double) {
//				idEObject.eSet(idEObject.eClass().getEStructuralFeature(attributeName + "AsString"), String.valueOf((Double)value));
//			}
			databaseSession.save(object, concreteRevision.getId());
		}
	}
}