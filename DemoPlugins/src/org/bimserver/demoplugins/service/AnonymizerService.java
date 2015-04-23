package org.bimserver.demoplugins.service;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.ModelMetaData;
import org.bimserver.interfaces.objects.SIfcHeader;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class AnonymizerService extends AbstractModifyRevisionService {

	private static final String ANONYMIZED = "[ANONYMIZED]";

	public AnonymizerService() {
		super("AnonymizerService", "Anonymizes your model");
	}

	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException, PublicInterfaceNotFoundException, BimServerClientException {
		SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
		final IfcModelInterface model = bimServerClientInterface.getModel(project, roid, true, false);

		SService service = bimServerClientInterface.getServiceInterface().getService(soid);

		for (IfcPerson ifcPerson : model.getAll(IfcPerson.class)) {
			ifcPerson.setFamilyName(ANONYMIZED);
			ifcPerson.setGivenName(ANONYMIZED);
			ifcPerson.setId(ANONYMIZED);
		}
		for (IfcOrganization ifcOrganization : model.getAll(IfcOrganization.class)) {
			ifcOrganization.setDescription(ANONYMIZED);
			ifcOrganization.setId(ANONYMIZED);
			ifcOrganization.setName(ANONYMIZED);
		}
		ModelMetaData modelMetaData = model.getModelMetaData();
		modelMetaData.setAuthorizedUser(ANONYMIZED);
		modelMetaData.setName(ANONYMIZED);
		SIfcHeader ifcHeader = model.getIfcHeader();
		ifcHeader.setAuthorization(ANONYMIZED);
		ifcHeader.setFilename(ANONYMIZED);
		ifcHeader.setOriginatingSystem(ANONYMIZED);
		ifcHeader.setPreProcessorVersion(ANONYMIZED);
		for (int i=0; i<ifcHeader.getAuthor().size(); i++) {
			ifcHeader.getAuthor().set(i, ANONYMIZED);
		}
		for (int i=0; i<ifcHeader.getOrganization().size(); i++) {
			ifcHeader.getOrganization().set(i, ANONYMIZED);
		}
		for (int i=0; i<ifcHeader.getDescription().size(); i++) {
			ifcHeader.getDescription().set(i, ANONYMIZED);
		}

		if (service.getWriteRevisionId() != -1 && service.getWriteRevisionId() != project.getOid()) {
			model.checkin(service.getWriteRevisionId(), "Anonymized");
		} else {
			model.commit("Anonymized");
		}
	}

	@Override
	public ProgressType getProgressType() {
		return ProgressType.UNKNOWN;
	}
}