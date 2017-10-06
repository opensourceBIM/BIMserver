package org.bimserver.bimbots;

import java.util.Set;

import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.plugins.SchemaName;

public interface BimBotsServiceInterface {
	BimBotsOutput runBimBot(BimBotsInput input, SObjectType settings) throws BimBotsException;
	Set<SchemaName> getAvailableInputs();
	Set<SchemaName> getAvailableOutputs();
}
