package org.bimserver.bimbots;

import java.util.Set;

import org.bimserver.interfaces.objects.SObjectType;

public interface BimBotsServiceInterface {
	BimBotsOutput runBimBot(BimBotsInput input, SObjectType settings) throws BimBotsException;
	Set<String> getAvailableInputs() throws BimBotsException;
	Set<String> getAvailableOutputs() throws BimBotsException;
}
