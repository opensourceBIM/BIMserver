package org.bimserver.serializers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.SettingsManager;
import org.bimserver.citygml.CityGmlSerializer;
import org.bimserver.collada.ColladaSerializer;
import org.bimserver.collada.KmzSerializer;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.PackageDefinition;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifc.xml.writer.IfcXmlSerializer;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.o3d.O3dJsonSerializer;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.ResultType.DefaultSelected;
import org.bimserver.shared.ResultType.Type;
import org.bimserver.shared.ResultType.UseInCheckout;
import org.bimserver.shared.ResultType.UserType;
import org.bimserver.version.Version;

public class EmfSerializerFactory {
	
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
			if (resultType.getType() == Type.MULTIPLE) {
				result.add(resultType);
			}
		}
		return result;
	}

	public Set<ResultType> getSingleResultTypes() {
		Set<ResultType> result = new TreeSet<ResultType>(resultTypeComparator);
		for (ResultType resultType : resultTypes.values()) {
			if (resultType.getType() == Type.SINGLE) {
				result.add(resultType);
			}
		}
		return result;
	}

	public void initSerializers() {
		String enabledExportTypesString = settingsManager.getSettings().getEnabledExportTypes();
		String[] enabledExportTypes = enabledExportTypesString.split(",");
		Set<String> enabled = new HashSet<String>();
		for (String type : enabledExportTypes) {
			String upperCase = type.trim().toUpperCase();
			if (!upperCase.equals("")) {
				enabled.add(upperCase);
			}
		}
		register(new ResultType("IFC", "IFC2x3", "ifc", "application/ifc", UseInCheckout.USE_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.TRUE, enabled.contains("IFC")), new EmfSerializerCreator(){
			@Override
			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) {
				IfcStepSerializer ifcSerializer = new IfcStepSerializer(project, user, fileName, model, schemaDefinition);
				ifcSerializer.setFileDescription("Bimserver.org " + version.getVersion() + " generated IFC file");
				ifcSerializer.setPreProcessorVersion("Bimserver.org " + version.getVersion());
				return ifcSerializer;
			}
		});
		register(new ResultType("IFCXML", "IFCXML2x3", "ifcxml", "application/ifcxml", UseInCheckout.USE_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("IFCXML")), new EmfSerializerCreator() {
			@Override
			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
				return new IfcXmlSerializer(fileName, model, schemaDefinition);
			}
		});
		register(new ResultType("IFCTXT", "Plain text IFC", "txt", "text", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("IFCTXT")), new EmfSerializerCreator() {
			@Override
			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
				IfcStepSerializer ifcSerializer = new IfcStepSerializer(project, user, fileName, model, schemaDefinition);
				ifcSerializer.setFileDescription("Bimserver.org " + version.getVersion() + " generated IFC file");
				ifcSerializer.setPreProcessorVersion("Bimserver.org " + version.getVersion());
				return ifcSerializer;
			}
		});
		register(new ResultType("CITYGML", "City GML 1.0.0", "gml", "application/gml", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("CITYGML")), new EmfSerializerCreator() {
			@Override
			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
				return new CityGmlSerializer(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory);
			}
		});
		register(new ResultType("COLLADA", "Collada", "dae", "appliction/collada", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("COLLADA")), new EmfSerializerCreator() {
			@Override
			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
				return new ColladaSerializer(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory, colladaSettings);
			}
		});
		register(new ResultType("KMZ", "KMZ", "kmz", "application/vnd.google-earth.kmz", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("KMZ")), new EmfSerializerCreator() {
			@Override
			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
				return new KmzSerializer(project, user, fileName, model, schemaDefinition, fieldIgnoreMap, ifcEngineFactory, colladaSettings);
			}
		});
		register(new ResultType("O3D_JSON", "WebGL", "o3djson", "appliction/json", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.MULTIPLE, DefaultSelected.FALSE, enabled.contains("O3D_JSON")), new EmfSerializerCreator() {
			@Override
			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) throws SerializerException {
				return new O3dJsonSerializer(project, user, fileName, model, fieldIgnoreMap, schemaDefinition, ifcEngineFactory);
			}
		});
		register(new ResultType("OBJECT_INFO", "Object Info", "html", "text/html", UseInCheckout.USE_NOT_IN_CHECKOUT, UserType.USER_TYPE, Type.SINGLE, DefaultSelected.FALSE, enabled.contains("OBJECT_INFO")), new EmfSerializerCreator() {
			@Override
			public EmfSerializer create(Project project, User user, IfcModel model, String fileName) {
				return new ObjectInfoSerializer(project, user, fileName, model, fieldIgnoreMap);
			}
		});
	}

	public ResultType getResultType(String resultTypeName) {
		return resultTypes.get(resultTypeName);
	}

	public boolean resultTypeEnabled(String resultTypeName) {
		return getResultType(resultTypeName).isEnabled();
	}
}