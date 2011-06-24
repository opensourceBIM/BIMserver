package org.bimserver.tests;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.util.List;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.models.ifc2x3.IfcDistributionPort;
import org.bimserver.models.ifc2x3.IfcElement;
import org.bimserver.models.ifc2x3.IfcFlowFitting;
import org.bimserver.models.ifc2x3.IfcFlowSegment;
import org.bimserver.models.ifc2x3.IfcFlowTerminal;
import org.bimserver.models.ifc2x3.IfcPort;
import org.bimserver.models.ifc2x3.IfcRelConnectsPortToElement;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcRioleringTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcRioleringTest.class);
	private IfcModelInterface model;

	public static void main(String[] args) {
		new IfcRioleringTest().start();
	}

	private void start() {
		File src = TestFile.RIOLERING_TEST.getFile();
		PluginManager pluginManager;
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager();
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			try {
				deserializer.read(src, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model = deserializer.getModel();
			step1();
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
	}

	private void step1() {
		List<IfcDistributionPort> ports = model.getAll(IfcDistributionPort.class);
		for (IfcDistributionPort port : ports) {
			if (port.getConnectedTo().size() == 0 && port.getConnectedFrom().size() == 0) {
				LOGGER.info("Step 1: DistributionPort = " + port.getName());
				step2(port);
			}
		}
	}

	private void step2(IfcDistributionPort distributionPort) {
		IfcElement relatedElement = distributionPort.getContainedIn().getRelatedElement();
		LOGGER.info("Step 2: FlowSegment = " + relatedElement.getName());
		step3(relatedElement, distributionPort);
	}

	private void step3(IfcElement relatedElement, IfcDistributionPort originaldistributionPort) {
		int originalPortsFound = 0;
		int relevantPortsFound = 0;
		for (IfcRelConnectsPortToElement ifcRelConnectsPortToElement : relatedElement.getHasPorts()) {
			IfcPort distributionPort = ifcRelConnectsPortToElement.getRelatingPort();
			if (distributionPort == originaldistributionPort) {
				originalPortsFound++;
			} else {
				String name = distributionPort.getName();
				relevantPortsFound++;
				LOGGER.info("Step 3: Port= " + relevantPortsFound + "DistributionPort = " + name);
				step4((IfcDistributionPort) distributionPort);
			}
		}
		if (originalPortsFound != 1) {
			LOGGER.info("Step3: originalPortsFound != 1");
		}
		if (relevantPortsFound != 1) {
			LOGGER.info("Step3: relevantPortsFound != 1");
		}
	}

	private void step4(IfcDistributionPort distributionPort) {
		IfcPort relatingPort = distributionPort.getConnectedFrom().get(0).getRelatingPort();
		LOGGER.info("Step 4: RelatingDistributionPort = " + relatingPort.getName());
		step5((IfcDistributionPort) relatingPort);
	}

	private void step5(IfcDistributionPort distributionPort) {
		IfcElement unknown = distributionPort.getContainedIn().getRelatedElement();
		String name = unknown.getName();
		if (unknown instanceof IfcFlowSegment) {
			LOGGER.info("Step 5: FlowSegment = " + name);
			step3(unknown, distributionPort);
		} else if (unknown instanceof IfcFlowFitting) {
			LOGGER.info("Step 5: FlowFitting = " + name);
			step6((IfcFlowFitting) unknown, distributionPort);
		} else if (unknown instanceof IfcFlowTerminal) {
			LOGGER.info("Step 5: Endpoint (terminal) = " + name);
		} else {
			LOGGER.info("Step5: Incorrect entity found");
		}
	}

	private void step6(IfcFlowFitting unknown, IfcDistributionPort originalDistributionPort) {
		int originalPortsFound = 0;
		int relevantPortsFound = 0;
		for (IfcRelConnectsPortToElement relConnectsPortToElement : unknown.getHasPorts()) {
			IfcDistributionPort distributionPort = (IfcDistributionPort) relConnectsPortToElement.getRelatingPort();
			if (distributionPort == originalDistributionPort) {
				originalPortsFound++;
			} else {
				String name = distributionPort.getName();
				LOGGER.info("Step 6: Port = " + relevantPortsFound + " DistributionPort = " + name);
				step4(distributionPort);
				relevantPortsFound++;
			}
		}
		if (originalPortsFound != 1) {
			LOGGER.info("Step 6: originalPortsFound != 1");
		}
		if (relevantPortsFound != 1) {
			LOGGER.info("Step 6: relevantPortsFound != 1");
		}
	}
}