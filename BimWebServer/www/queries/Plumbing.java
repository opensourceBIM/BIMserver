package org.bimserver.querycompiler;

import java.io.PrintWriter;
import java.util.List;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.emf.Ifc2x3.IfcDistributionPort;
import org.bimserver.ifc.emf.Ifc2x3.IfcElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcFlowFitting;
import org.bimserver.ifc.emf.Ifc2x3.IfcFlowSegment;
import org.bimserver.ifc.emf.Ifc2x3.IfcFlowTerminal;
import org.bimserver.ifc.emf.Ifc2x3.IfcPort;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelConnectsPortToElement;

public class Query implements QueryInterface {

	private IfcModel model;
	private PrintWriter out;

	@Override
	public void query(IfcModel model, PrintWriter out) {
		this.model = model;
		this.out = out;
		step1();
	}

	private void step1() {
		List<IfcDistributionPort> ports = model.getAll(IfcDistributionPort.class);
		for (IfcDistributionPort port : ports) {
			if (port.getConnectedTo().size() == 0 && port.getConnectedFrom().size() == 0) {
				out.println("Step 1: DistributionPort = " + port.getName());
				step2(port);
			}
		}
	}

	private void step2(IfcDistributionPort distributionPort) {
		IfcElement relatedElement = distributionPort.getContainedIn().getRelatedElement();
		out.println("Step 2: FlowSegment = " + relatedElement.getName());
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
				out.println("Step 3: Port= " + relevantPortsFound + "DistributionPort = " + name);
				step4((IfcDistributionPort) distributionPort);
			}
		}
		if (originalPortsFound != 1) {
			out.println("Step3: originalPortsFound != 1");
		}
		if (relevantPortsFound != 1) {
			out.println("Step3: relevantPortsFound != 1");
		}
	}

	private void step4(IfcDistributionPort distributionPort) {
		IfcPort relatingPort = distributionPort.getConnectedFrom().get(0).getRelatingPort();
		out.println("Step 4: RelatingDistributionPort = " + relatingPort.getName());
		step5((IfcDistributionPort) relatingPort);
	}

	private void step5(IfcDistributionPort distributionPort) {
		IfcElement unknown = distributionPort.getContainedIn().getRelatedElement();
		String name = unknown.getName();
		if (unknown instanceof IfcFlowSegment) {
			out.println("Step 5: FlowSegment = " + name);
			step3(unknown, distributionPort);
		} else if (unknown instanceof IfcFlowFitting) {
			out.println("Step 5: FlowFitting = " + name);
			step6((IfcFlowFitting) unknown, distributionPort);
		} else if (unknown instanceof IfcFlowTerminal) {
			out.println("Step 5: Endpoint (terminal) = " + name);
		} else {
			out.println("Step5: Incorrect entity found");
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
				out.println("Step 6: Port = " + relevantPortsFound + " DistributionPort = " + name);
				step4(distributionPort);
				relevantPortsFound++;
			}
		}
		if (originalPortsFound != 1) {
			out.println("Step 6: originalPortsFound != 1");
		}
		if (relevantPortsFound != 1) {
			out.println("Step 6: relevantPortsFound != 1");
		}
	}
}