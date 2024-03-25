package org.bimserver.database.queries.om;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.bimserver.emf.PackageMetaData;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class JsonQueryConverterFromResources extends JsonQueryObjectModelConverter {

    public JsonQueryConverterFromResources(PackageMetaData packageMetaData) {
        super(packageMetaData);
    }

    public Set<String> getAllDefinesNamesFromFile(String namespaceString) throws QueryException {
        URL resource = getClass().getClassLoader().getResource("json/" + namespaceString + ".json");
        if (resource == null) {
            throw new QueryException("Could not find '" + namespaceString + "' namespace in predefined queries");
        }

        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try {
            ObjectNode predefinedQuery = OBJECT_MAPPER.readValue(resource, ObjectNode.class);
            Query query = parseJson(namespaceString, predefinedQuery);
            Map<String, Include> defines = query.getDefines();
            return defines.keySet();
        } catch (IOException e) {
            throw new QueryException(e);
        }
    }

    public Map<String, Include> getDefinesFromFile(String namespaceString, List<String> includeNames, boolean useCaching) throws QueryException {
        URL resource = getClass().getClassLoader().getResource("json/" + namespaceString);
        if (resource == null) {
            throw new QueryException("Could not find '" + namespaceString + "' namespace in predefined queries");
        }

        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        Map<String, Include> defines = new HashMap<>();
        try {
            ObjectNode predefinedQuery = OBJECT_MAPPER.readValue(resource, ObjectNode.class);
            Query query = parseJson(namespaceString, predefinedQuery);

            for (String includeName : includeNames) {
                Include define = query.getDefine(includeName);
                defines.put(includeName, define);
            }
        } catch (IOException e) {
            throw new QueryException(e);
        }
        return defines;
    }

    @Override
    public Include getDefineFromFile(String includeName, boolean useCaching) throws QueryException {
        Include include = null;
        if (useCaching) {
            include = CACHED_DEFINES.get(includeName);
        }
        if (include != null) {
            return include;
        }
        String namespaceString = includeName.substring(0, includeName.indexOf(":"));
        String singleIncludeName = includeName.substring(includeName.indexOf(":") + 1);
        URL resource;

        resource = getClass().getClassLoader().getResource("json/" + namespaceString + ".json");
        if (resource == null) {
            throw new QueryException("Could not find '" + namespaceString + "' namespace in predefined queries");
        }

        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try {
            ObjectNode predefinedQuery = OBJECT_MAPPER.readValue(resource, ObjectNode.class);
            Query query = parseJson(namespaceString, predefinedQuery);
            Include define = query.getDefine(singleIncludeName);
            if (copyExternalDefines) {
                define = define.copy();
            }
            if (define == null) {
                throw new QueryException("Could not find '" + singleIncludeName + "' in defines in namespace " + query.getName());
            }
            if (useCaching) {
                CACHED_DEFINES.put(includeName, define);
            }
            return define;
        } catch (IOException e) {
            throw new QueryException(e);
        }
    }
}
