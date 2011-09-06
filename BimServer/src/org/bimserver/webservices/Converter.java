package org.bimserver.webservices;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.compare.CompareResult;
import org.bimserver.ifc.compare.CompareResult.Item;
import org.bimserver.ifc.compare.CompareResult.ObjectAdded;
import org.bimserver.ifc.compare.CompareResult.ObjectDeleted;
import org.bimserver.ifc.compare.CompareResult.ObjectModified;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.SCompareResult;
import org.bimserver.shared.SDataObject;
import org.bimserver.shared.SCompareResult.SObjectAdded;
import org.bimserver.shared.SCompareResult.SObjectModified;
import org.bimserver.shared.SCompareResult.SObjectRemoved;
import org.bimserver.tools.generators.GenerateUtils;
import org.bimserver.utils.StringUtils;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Converter {
	private static final Logger LOGGER = LoggerFactory.getLogger(Converter.class);
	
	@SuppressWarnings({ "unchecked" })
	public static <T> T convertEnum(Enumerator enumerator, Class<T> targetClass) {
		Object[] enumConstants = targetClass.getEnumConstants();
		for (Object t : enumConstants) {
			Enum<?> en = (Enum<?>) t;
			try {
				Method method2 = en.getDeclaringClass().getMethod("getOrdinal");
				Object invoke = method2.invoke(en);
				if ((Integer) invoke == enumerator.getValue()) {
					return (T) t;
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T convert(Enum enumerator, Class<T> targetClass) {
		Object[] enumConstants = targetClass.getEnumConstants();
		for (Object t : enumConstants) {
			Enum<?> en = (Enum<?>) t;
			try {
				Method method2 = en.getDeclaringClass().getMethod("getOrdinal");
				Object invoke = method2.invoke(en);
				if ((Integer) invoke == enumerator.ordinal()) {
					return (T) t;
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static <T> List<T> convert(Collection<? extends IdEObject> list, Class<T> targetClass) {
		List<T> newList = new ArrayList<T>();
		if (list == null) {
			return null;
		}
		for (IdEObject eObject : list) {
			newList.add(convert(eObject, targetClass));
		}
		return newList;
	}

	@SuppressWarnings("unchecked")
	public static <T extends IdEObject> T convert(Object original, Class<T> targetClass, BimDatabaseSession session) {
		if (original == null) {
			return null;
		}
		EClass eClass = (EClass) StorePackage.eINSTANCE.getEClassifier(targetClass.getSimpleName());
		IdEObject idEObject = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
		try {
			Method getOidMethod = original.getClass().getMethod("getOid");
			Long oid = (Long) getOidMethod.invoke(original);
			if (oid == 0) {
				oid = -1L;
			}
			idEObject.setOid(oid);
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			try {
				String methodName = "get" + StringUtils.firstUpperCase(eStructuralFeature.getName());
				if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
					methodName = "is" + StringUtils.firstUpperCase(eStructuralFeature.getName());
				}
				if (eStructuralFeature instanceof EReference) {
					methodName += "Id";
				}
				Method method = original.getClass().getMethod(methodName);
				Object value = method.invoke(original);
				if (eStructuralFeature instanceof EReference) {
					Long refOid = (Long) value;
					idEObject.eSet(eStructuralFeature, session.get((EClass) eStructuralFeature.getEType(), refOid, false));
				} else {
					idEObject.eSet(eStructuralFeature, value);
				}
			} catch (SecurityException e) {
				LOGGER.error("", e);
			} catch (NoSuchMethodException e) {
				LOGGER.error("", e);
			} catch (IllegalArgumentException e) {
				LOGGER.error("", e);
			} catch (IllegalAccessException e) {
				LOGGER.error("", e);
			} catch (InvocationTargetException e) {
				LOGGER.error("", e);
			}
		}
		return (T) idEObject;
	}

	@SuppressWarnings("unchecked")
	public static <T> T convert(IdEObject original, Class<T> targetClass) {
		if (original == null) {
			return null;
		}
		try {
			Class<?> realClass = Class.forName("org.bimserver.interfaces.objects.S" + original.eClass().getName());
			T newInstance = (T) realClass.newInstance();
			Method setOidMethod = targetClass.getMethod("setOid", new Class[] { long.class });
			setOidMethod.invoke(newInstance, original.getOid());
			EClass eClass = original.eClass();
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				Object value = original.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EAttribute) {
					if (eStructuralFeature.getEType() instanceof EEnum) {
						Enumerator enumerator = (Enumerator) value;
						Class<?> forName = Class.forName("org.bimserver.interfaces.objects.S" + eStructuralFeature.getEType().getName());
						Object[] enumConstants = forName.getEnumConstants();
						Boolean found = false;
						for (Object t : enumConstants) {
							Enum<?> en = (Enum<?>) t;
							Method method2 = en.getDeclaringClass().getMethod("getOrdinal");
							Object invoke = method2.invoke(en);
							if ((Integer) invoke == enumerator.getValue()) {
								try {
									Method method = realClass.getMethod(GenerateUtils.makeSetter(eStructuralFeature), new Class[] { forName });
									method.invoke(newInstance, t);
								} catch (NoSuchMethodException e) {
								}
								found = true;
								break;
							}
						}
						if (!found) {
							LOGGER.info(value.toString() + " not found");
						}
					} else if (eStructuralFeature.getEType() instanceof EDataType) {
						try {
							Method method = realClass.getMethod(GenerateUtils.makeSetter(eStructuralFeature), new Class[] { eStructuralFeature.getEType().getInstanceClass() });
							if (value != null) {
								method.invoke(newInstance, value);
							}
						} catch (NoSuchMethodException e) {
						}
					}
				} else if (eStructuralFeature instanceof EReference) {
					if (eStructuralFeature.isMany()) {
						List<IdEObject> list = (List<IdEObject>) value;
						List<Long> newList = new ArrayList<Long>();
						for (IdEObject val : list) {
							newList.add(val.getOid());
						}
						try {
							Method method = realClass.getMethod(GenerateUtils.makeSetter(eStructuralFeature), new Class[] { List.class });
							method.invoke(newInstance, newList);
						} catch (NoSuchMethodException e) {
						}
					} else {
						try {
							Method method = realClass.getMethod(GenerateUtils.makeSetter(eStructuralFeature), new Class[] { long.class });
							if (value == null) {
								method.invoke(newInstance, -1);
							} else {
								IdEObject referencedObject = (IdEObject) value;
								method.invoke(newInstance, referencedObject.getOid());
							}
						} catch (NoSuchMethodException e) {
						}
					}
				}
			}
			return newInstance;
		} catch (InstantiationException e) {
			LOGGER.error("", e);
		} catch (IllegalAccessException e) {
			LOGGER.error("", e);
		} catch (SecurityException e) {
			LOGGER.error("", e);
		} catch (IllegalArgumentException e) {
			LOGGER.error("", e);
		} catch (InvocationTargetException e) {
			LOGGER.error("", e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("", e);
		} catch (NoSuchMethodException e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	public static UserType convert(SUserType sUserType) {
		switch (sUserType) {
		case ADMIN:
			return UserType.ADMIN;
		case ANONYMOUS:
			return UserType.ANONYMOUS;
		case USER:
			return UserType.USER;
		}
		return null;
	}

	public static SCompareResult convert(CompareResult compareResult, Class<SCompareResult> class1, BimDatabaseSession session) {
		SCompareResult sCompareResult = new SCompareResult();
		Map<EClass, List<Item>> items = compareResult.getItems();
		for (EClass key : items.keySet()) {
			List<Item> list = items.get(key);
			for (Item item : list) {
				SDataObject dataObject = new SDataObject(item.geteObject().eClass().getName(), item.geteObject().getOid(), getGuid(item.geteObject()), getName(item.geteObject()));
				if (item instanceof ObjectAdded) {
					sCompareResult.add(new SObjectAdded(dataObject));
				} else if (item instanceof ObjectDeleted) {
					sCompareResult.add(new SObjectRemoved(dataObject));
				} else if (item instanceof ObjectModified) {
					ObjectModified objectModified = (ObjectModified) item;
					sCompareResult.add(new SObjectModified(dataObject, objectModified.getFeature().getName(), objectModified.getOldValue() == null ? "null" : objectModified
							.getOldValue().toString(), objectModified.getNewValue() == null ? "null" : objectModified.getNewValue().toString()));
				}
			}
		}
		return sCompareResult;
	}
	
	public static ClashDetectionSettings convert(SClashDetectionSettings sClashDetectionSettings, BimDatabaseSession bimDatabaseSession) {
		ClashDetectionSettings clashDetectionSettings = StoreFactory.eINSTANCE.createClashDetectionSettings();
		clashDetectionSettings.setMargin(sClashDetectionSettings.getMargin());
		for (String ignoredClass : sClashDetectionSettings.getIgnoredClasses()) {
			if (!ignoredClass.equals("none")) {
				clashDetectionSettings.getIgnoredClasses().add(ignoredClass);
			}
		}
		for (Long poid : sClashDetectionSettings.getProjects()) {
			Project project = bimDatabaseSession.get(StorePackage.eINSTANCE.getProject(), poid, false);
			clashDetectionSettings.getProjects().add(project);
		}
		for (Long roid : sClashDetectionSettings.getRevisions()) {
			Revision revision = bimDatabaseSession.get(StorePackage.eINSTANCE.getRevision(), roid, false);
			clashDetectionSettings.getRevisions().add(revision);
		}
		return clashDetectionSettings;
	}
	
	public static SClashDetectionSettings convert(ClashDetectionSettings clashDetectionSettings) {
		SClashDetectionSettings sClashDetectionSettings = new SClashDetectionSettings();
		sClashDetectionSettings.setMargin(clashDetectionSettings.getMargin());
		for (String cl : clashDetectionSettings.getIgnoredClasses()) {
			clashDetectionSettings.getIgnoredClasses().add(cl);
		}
		for (Project project : clashDetectionSettings.getProjects()) {
			sClashDetectionSettings.getProjects().add(project.getOid());
		}
		for (Revision revision : clashDetectionSettings.getRevisions()) {
			sClashDetectionSettings.getRevisions().add(revision.getOid());
		}
		return sClashDetectionSettings;
	}
	
	private static String getName(EObject eObject) {
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) eObject;
			if (ifcRoot.getName() != null) {
				return ifcRoot.getName();
			}
		}
		return null;
	}

	private static String getGuid(EObject eObject) {
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) eObject;
			if (ifcRoot.getGlobalId() != null) {
				return ifcRoot.getGlobalId().getWrappedValue();
			}
		}
		return null;
	}
}