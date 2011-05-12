package org.bimserver.serializers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.SettingsManager;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.plugins.ifcengine.IfcEngineFactory;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.PackageDefinition;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.ResultType.Type;
import org.bimserver.version.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmfSerializerFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmfSerializerFactory.class);
	
	public abstract class EmfSerializerCreator {
		public abstract EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException;
	}

	Comparator<ResultType> resultTypeComparator = new Comparator<ResultType>(){
		@Override
		public int compare(ResultType o1, ResultType o2) {
			return o1.compareTo(o2);
		}};
	
	private static final EmfSerializerFactory INSTANCE = new EmfSerializerFactory();
	private final Map<String, ResultType> resultTypes = new TreeMap<String, ResultType>();
	private final Map<ResultType, EmfSerializerCreator> serializerCreators = new HashMap<ResultType, EmfSerializerCreator>();
	private FieldIgnoreMap fieldIgnoreMap;
	private PackageDefinition colladaSettings;
	private SchemaDefinition schemaDefinition;
	private Version version;

	private IfcEngineFactory ifcEngineFactory;
	private ResourceFetcher resourceFetcher;
	private SettingsManager settingsManager;

	private final Set<SerializerPlugin> serializerPlugins = new HashSet<SerializerPlugin>();
	
	private EmfSerializerFactory() {
	}

	public static EmfSerializerFactory getInstance() {
		return INSTANCE;
	}

	public void init(Version version, SchemaDefinition schemaDefinition, FieldIgnoreMap fieldIgnoreMap, IfcEngineFactory ifcEngineFactory, PackageDefinition colladaSettings, ResourceFetcher resourceFetcher, SettingsManager settingsManager) {
		this.version = version;
		this.schemaDefinition = schemaDefinition;
		this.fieldIgnoreMap = fieldIgnoreMap;
		this.ifcEngineFactory = ifcEngineFactory;
		this.colladaSettings = colladaSettings;
		this.resourceFetcher = resourceFetcher;
		this.settingsManager = settingsManager;
	}
	
	public void register(ResultType resultType, EmfSerializerCreator emfSerializerCreator) {
		resultTypes.put(resultType.getName(), resultType);
		serializerCreators.put(resultType, emfSerializerCreator);
	}

	public void unregister(ResultType resultType, EmfSerializerCreator emfSerializerCreator) {
		resultTypes.remove(resultType.getName());
		serializerCreators.remove(resultType);
	}
	
	public EmfSerializer create(Project project, User user, ResultType resultType, IfcModel model, String name) throws NoSerializerFoundException, SerializerException {
		EmfSerializerCreator emfSerializerCreator = serializerCreators.get(resultType);
		if (emfSerializerCreator == null) {
			throw new NoSerializerFoundException("Serializer for type " + resultType.getNiceName() + " not found or not enabled");
		}
		return emfSerializerCreator.create(project, user, model, name);
	}

	public Set<ResultType> getMultipleResultTypes() {
		Set<ResultType> result = new TreeSet<ResultType>(resultTypeComparator);
		for (ResultType resultType : resultTypes.values()) {
			if (resultType.getMultiple() == Type.MULTIPLE) {
				result.add(resultType);
			}
		}
		return result;
	}

	public Set<ResultType> getSingleResultTypes() {
		Set<ResultType> result = new TreeSet<ResultType>(resultTypeComparator);
		for (ResultType resultType : resultTypes.values()) {
			if (resultType.getMultiple() == Type.SINGLE) {
				result.add(resultType);
			}
		}
		return result;
	}

	public void initSerializers() {
		ServiceLoader<SerializerPlugin> loader = ServiceLoader.load(SerializerPlugin.class);
		Iterator<SerializerPlugin> iterator = loader.iterator();
		while (iterator.hasNext()) {
			SerializerPlugin serializerPlugin = iterator.next();
			LOGGER.info("Loading serializer: " + serializerPlugin.getName());
			serializerPlugins.add(serializerPlugin);
		}
		
		
		String enabledExportTypesString = settingsManager.getSettings().getEnabledExportTypes();
		String[] enabledExportTypes = enabledExportTypesString.split(",");
		Set<String> enabled = new HashSet<String>();
		for (String type : enabledExportTypes) {
			String upperCase = type.trim().toUpperCase();
			if (!upperCase.equals("")) {
				enabled.add(upperCase);
			}
		}
//		register(new ResultType("IFC", "IFC2x3", "ifc", "application/ifc", UseInCheckout.USE_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.TRUE, enabled.contains("IFC")), new EmfSerializerCreator(){
//			@Override
//			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) {
//				IfcStepSerializer ifcSerializer = new IfcStepSerializer(project, user, fileName, model, schemaDefinition);
//				ifcSerializer.setFileDescription("Bimserver.org " + version.getVersion() + " generated IFC file");
//				ifcSerializer.setPreProcessorVersion("Bimserver.org " + version.getVersion());
//				return ifcSerializer;
//			}
//		});
//		register(new ResultType("IFCXML", "IFCXML2x3", "ifcxml", "application/ifcxml", UseInCheckout.USE_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("IFCXML")), new EmfSerializerCreator() {
//			@Override
//			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
//				return new IfcXmlSerializer(fileName, model, schemaDefinition);
//			}
//		});
//		register(new ResultType("IFCTXT", "Plain text IFC", "txt", "text", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("IFCTXT")), new EmfSerializerCreator() {
//			@Override
//			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
//				IfcStepSerializer ifcSerializer = new IfcStepSerializer(project, user, fileName, model, schemaDefinition);
//				ifcSerializer.setFileDescription("Bimserver.org " + version.getVersion() + " generated IFC file");
//				ifcSerializer.setPreProcessorVersion("Bimserver.org " + version.getVersion());
//				return ifcSerializer;
//			}
//		});
//		register(new ResultType("CITYGML", "City GML 1.0.0", "gml", "application/gml", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("CITYGML")), new EmfSerializerCreator() {
//			@Override
//			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
//				CityGmlSerializer cityGmlSerializer = new CityGmlSerializer();
//				cityGmlSerializer.init(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory);
//				return cityGmlSerializer;
//			}
//		});
//		register(new ResultType("COLLADA", "Collada", "dae", "appliction/collada", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("COLLADA")), new EmfSerializerCreator() {
//			@Override
//			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
//				ColladaSerializer colladaSerializer = new ColladaSerializer();
//				colladaSerializer.init(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory, colladaSettings);
//				return colladaSerializer;
//			}
//		});
//		register(new ResultType("KMZ", "KMZ", "kmz", "application/vnd.google-earth.kmz", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("KMZ")), new EmfSerializerCreator() {
//			@Override
//			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
//				KmzSerializer kmzSerializer = new KmzSerializer();
//				kmzSerializer.init(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory, colladaSettings);
//				return kmzSerializer;
//			}
//		});
//		register(new ResultType("O3D_JSON", "WebGL", "o3djson", "appliction/json", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("O3D_JSON")), new EmfSerializerCreator() {
//			@Override
//			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
//				O3dJsonSerializer o3dJsonSerializer = new O3dJsonSerializer();
//				o3dJsonSerializer.init(project, user, fileName, model, fieldIgnoreMap, schemaDefinition, ifcEngineFactory);
//				return o3dJsonSerializer;
//			}
//		});
//		register(new ResultType("OBJECT_INFO", "Object Info", "html", "text/html", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.SINGLE, DefaultSelected.FALSE, enabled.contains("OBJECT_INFO")), new EmfSerializerCreator() {
//			@Override
//			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) {
//				ObjectInfoSerializer objectInfoSerializer = new ObjectInfoSerializer();
//				objectInfoSerializer.init(fileName, model);
//				return objectInfoSerializer;
//			}
//		});
	}

	public ResultType getResultType(String resultTypeName) {
		return resultTypes.get(resultTypeName);
	}

	public boolean resultTypeEnabled(String resultTypeName) {
		return getResultType(resultTypeName).isEnabled();
	}

	public Set<String> getAllSerializerClassNames() {
		Set<String> classNames = new HashSet<String>();
		ServiceLoader<EmfSerializer> loader = ServiceLoader.load(EmfSerializer.class);
		Iterator<EmfSerializer> iterator = loader.iterator();
		while (iterator.hasNext()) {
			EmfSerializer next = iterator.next();
			classNames.add(next.getClass().getSimpleName());
		}
		return classNames;
	}
}