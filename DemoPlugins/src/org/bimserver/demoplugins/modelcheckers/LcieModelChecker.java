package org.bimserver.demoplugins.modelcheckers;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.models.store.ModelCheckerResultItem;
import org.bimserver.models.store.ModelCheckerResultLine;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.modelchecker.ModelCheckException;
import org.bimserver.plugins.modelchecker.ModelChecker;

public class LcieModelChecker implements ModelChecker {

	private static class SpaceRequirement {
		public SpaceRequirement(float usableHeight, float grossArea, float netArea) {
			this.usableHeight = usableHeight;
			this.grossArea = grossArea;
			this.netArea = netArea;
		}
		
		public float usableHeight;
		public float grossArea;
		public float netArea;
	}
	
	private static final Map<String, SpaceRequirement> requirements = new HashMap<>();
	
	static {
		requirements.put("2JMEMJb4j6nRYIbsuNlMs2", new SpaceRequirement(2.5f, 6.56f, 6.56f));
		requirements.put("1ZDMQhNXj6vOp7Co7KkLYA", new SpaceRequirement(2.5f, 22.62f, 22.62f));
		requirements.put("1RxyaNqZzDjx4MmfzfzpwN", new SpaceRequirement(2.8f, 19.72f, 19.72f));
		requirements.put("3FsA6ND79CVRy8pjIPSJjJ", new SpaceRequirement(2.5f, 7.445f, 7.445f));
		requirements.put("0DBAGyg3HCPxdTwh0blBxq", new SpaceRequirement(2.8f, 13.92f, 13.92f));
		requirements.put("3U_CFba1TE5ARONs3O9kML", new SpaceRequirement(2.8f, 27.84f, 27.84f));
		requirements.put("1UU_$gavn9qO07D6mocU5v", new SpaceRequirement(2.8f, 3.28f, 3.28f));
		requirements.put("09iwDlq3v8XRuPxQTVVQtZ", new SpaceRequirement(2.5f, 6.56f, 6.56f));
		requirements.put("1gm8lSFWD9thUpBmThMW6x", new SpaceRequirement(2.5f, 22.62f, 22.62f));
		requirements.put("3wE50ve8PEDuzKIKglEmzO", new SpaceRequirement(2.8f, 19.72f, 19.72f));
		requirements.put("0pLJQvhsP5sRfRYZvDl4SO", new SpaceRequirement(2.5f, 7.445f, 7.445f));
		requirements.put("1PLKkszi198RJJ44V2nDIe", new SpaceRequirement(2.8f, 13.915f, 13.915f));
		requirements.put("07tcB$I_PB3A0QTejhg3bC", new SpaceRequirement(2.8f, 27.84f, 27.84f));
		requirements.put("2J3$jOMsH74BLkS2P_4IZp", new SpaceRequirement(2.8f, 3.28f, 3.28f));
	}
	
	@Override
	public ModelCheckerResult check(IfcModelInterface model, byte[] compiledCode) throws ModelCheckException {
		ModelCheckerResult result = StoreFactory.eINSTANCE.createModelCheckerResult();
		for (String guid : requirements.keySet()) {
			SpaceRequirement spaceRequirement = requirements.get(guid);
			IfcSpace space = (IfcSpace) model.getByGuid(guid);
			if (space == null) {
				ModelCheckerResultLine item = StoreFactory.eINSTANCE.createModelCheckerResultLine();
				item.setFieldOrClass("IfcSpace");
				item.setValue("Not good");
			} else {
				for (IfcRelDefines ifcRelDefines : space.getIsDefinedBy()) {
					if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
						IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
						IfcPropertySetDefinition relatingPropertyDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
						System.out.println(relatingPropertyDefinition);
					}
				}
			}
		}
		return result;
	}

	@Override
	public byte[] compile(String code) throws ModelCheckException {
		return null;
	}
}