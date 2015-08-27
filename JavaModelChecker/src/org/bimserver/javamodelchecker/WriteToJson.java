package org.bimserver.javamodelchecker;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class WriteToJson {
	public static void main(String[] args) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode rootNode = objectMapper.createObjectNode();
			ArrayNode array = objectMapper.createArrayNode();
			rootNode.set("modelcheckers", array);
	
			ObjectNode objectNode = objectMapper.createObjectNode();
			array.add(objectNode);
			objectNode.put("name", "Check window widths");
			objectNode.put("description", "Check window widths");
			objectNode.put("modelCheckerPluginClassName", "org.bimserver.javamodelchecker.JavaModelCheckerPlugin");
			objectNode.put("code", changeClassName(FileUtils.readFileToString(new File("src/org/bimserver/javamodelchecker/WindowWidthChecker.java")), "WindowWidthChecker"));
	
			objectNode = objectMapper.createObjectNode();
			array.add(objectNode);
			objectNode.put("name", "Pass always");
			objectNode.put("description", "Pass always");
			objectNode.put("modelCheckerPluginClassName", "org.bimserver.javamodelchecker.JavaModelCheckerPlugin");
			objectNode.put("code", changeClassName(FileUtils.readFileToString(new File("src/org/bimserver/javamodelchecker/PassAlways.java")), "PassAlways"));
	
			objectNode = objectMapper.createObjectNode();
			array.add(objectNode);
			objectNode.put("name", "Fail always");
			objectNode.put("description", "Fail always");
			objectNode.put("modelCheckerPluginClassName", "org.bimserver.javamodelchecker.JavaModelCheckerPlugin");
			objectNode.put("code", changeClassName(FileUtils.readFileToString(new File("src/org/bimserver/javamodelchecker/FailAlways.java")), "FailAlways"));
			
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("modelcheckers.json"), rootNode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String changeClassName(String code, String name) {
		return code.replace("public class " + name, "public class Implementation");
	}
}
