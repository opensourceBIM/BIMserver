package org.bimserver.jqep;

import java.io.PrintWriter;
import java.util.List;

import org.bimserver.plugins.QueryEngineHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.*;

public class Query implements QueryInterface {

	private IfcModelInterface model;
	private Reporter reporter;

	@Override
	public void query(IfcModelInterface source, IfcModelInterface dest, Reporter reporter, QueryEngineHelper queryEngineHelper) {
		reporter.info("Running plumbing example");
		this.reporter = reporter;
		this.model = source;
		step1();
	}

	private void step1() {
		List<IfcDistributionPort> ports = model.getAll(IfcDistributionPort.class);
		for (IfcDistributionPort port : ports) {
			if (port.getConnectedTo().size() == 0 && port.getConnectedFrom().size() == 0) {
				reporter.info("Step 1: DistributionPort = " + port.getName());
				step2(port);
			}
		}
	}

	private void step2(IfcDistributionPort distributionPort) {
		IfcElement relatedElement = distributionPort.getContainedIn().getRelatedElement();
		reporter.info("Step 2: FlowSegment = " + relatedElement.getName());
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
				reporter.info("Step 3: Port= " + relevantPortsFound + "DistributionPort = " + name);
				step4((IfcDistributionPort) distributionPort);
			}
		}
		if (originalPortsFound != 1) {
			reporter.info("Step3: originalPortsFound != 1");
		}
		if (relevantPortsFound != 1) {
			reporter.info("Step3: relevantPortsFound != 1");
		}
	}

	private void step4(IfcDistributionPort distributionPort) {
		IfcPort relatingPort = distributionPort.getConnectedFrom().get(0).getRelatingPort();
		reporter.info("Step 4: RelatingDistributionPort = " + relatingPort.getName());
		step5((IfcDistributionPort) relatingPort);
	}

	private void step5(IfcDistributionPort distributionPort) {
		IfcElement unknown = distributionPort.getContainedIn().getRelatedElement();
		String name = unknown.getName();
		if (unknown instanceof IfcFlowSegment) {
			reporter.info("Step 5: FlowSegment = " + name);
			step3(unknown, distributionPort);
		} else if (unknown instanceof IfcFlowFitting) {
			reporter.info("Step 5: FlowFitting = " + name);
			step6((IfcFlowFitting) unknown, distributionPort);
		} else if (unknown instanceof IfcFlowTerminal) {
			reporter.info("Step 5: Endpoint (terminal) = " + name);
		} else {
			reporter.info("Step5: Incorrect entity found");
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
				reporter.info("Step 6: Port = " + relevantPortsFound + " DistributionPort = " + name);
				step4(distributionPort);
				relevantPortsFound++;
			}
		}
		if (originalPortsFound != 1) {
			reporter.info("Step 6: originalPortsFound != 1");
		}
		if (relevantPortsFound != 1) {
			reporter.info("Step 6: relevantPortsFound != 1");
		}
	}
}