package org.bimserver.citygml.objects;

import ade.FlowTerminalType;

public class FlowTerminal extends VisualElement {

	public FlowTerminal(FlowTerminalType flowTerminalType) {
		super(flowTerminalType);
	}
	
	public FlowTerminal() {
		this(new FlowTerminalType());
	}
}