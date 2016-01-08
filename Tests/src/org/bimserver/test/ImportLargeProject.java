package org.bimserver.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;

public class ImportLargeProject {
	public static void main(String[] args) {
		BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
		try {
			Path baseFolder = Paths.get("C:\\Users\\Ruben de Laat\\Documents\\ttt");
			
			Bimsie1ServiceInterface serviceInterface = client.getBimsie1ServiceInterface();
			SProject mainProject = serviceInterface.addProject("Tekla Demo Model", "ifc2x3tc1");
			SProject architectural = serviceInterface.addProjectAsSubProject("Architectural", mainProject.getOid(), "ifc2x3tc1");
			SProject teklaHouseArchitectural = serviceInterface.addProjectAsSubProject("Tekla House Architectural", architectural.getOid(), "ifc2x3tc1");
			SProject structuralSteal = serviceInterface.addProjectAsSubProject("Structural Steal", mainProject.getOid(), "ifc2x3tc1");
			SProject teklaHouseStructural = serviceInterface.addProjectAsSubProject("Tekla House Structural", structuralSteal.getOid(), "ifc2x3tc1");
			SProject foundation = serviceInterface.addProjectAsSubProject("Foundation", mainProject.getOid(), "ifc2x3tc1");
			SProject teklaHouseFoundationFootings = serviceInterface.addProjectAsSubProject("Tekla Hose Foundation Footings", foundation.getOid(), "ifc2x3tc1");
			SProject teklaHouseFoundationPiles = serviceInterface.addProjectAsSubProject("Tekla Hose Foundation Piles", foundation.getOid(), "ifc2x3tc1");
			SProject teklaHouseFoundationRebars = serviceInterface.addProjectAsSubProject("Tekla Hose Foundation Rebars", foundation.getOid(), "ifc2x3tc1");
			SProject teklaHouseFoundationEmbedments = serviceInterface.addProjectAsSubProject("Tekla Hose Foundation Embedments", foundation.getOid(), "ifc2x3tc1");
			SProject cipConcreteContractor = serviceInterface.addProjectAsSubProject("CIP Concrete Contractor", mainProject.getOid(), "ifc2x3tc1");
			serviceInterface.addProjectAsSubProject("Tekla House CIP Pours", cipConcreteContractor.getOid(), "ifc2x3tc1");
			SProject teklaHouseCIPRebars = serviceInterface.addProjectAsSubProject("Tekla House CIP Rebars", cipConcreteContractor.getOid(), "ifc2x3tc1");
			SProject teklaHouseCIPColumns = serviceInterface.addProjectAsSubProject("Tekla House CIP Columns", cipConcreteContractor.getOid(), "ifc2x3tc1");
			SProject formWork = serviceInterface.addProjectAsSubProject("Formwork", mainProject.getOid(), "ifc2x3tc1");
			serviceInterface.addProjectAsSubProject("Column Formwork", formWork.getOid(), "ifc2x3tc1");
			SProject precast = serviceInterface.addProjectAsSubProject("Precast", mainProject.getOid(), "ifc2x3tc1");
			SProject teklaHousePrecastRebars = serviceInterface.addProjectAsSubProject("Tekla House Precast Rebars", precast.getOid(), "ifc2x3tc1");
			SProject teklaHousePrecastConcrete = serviceInterface.addProjectAsSubProject("Tekla House Precast Concrete", precast.getOid(), "ifc2x3tc1");
			SProject mep = serviceInterface.addProjectAsSubProject("MEP", mainProject.getOid(), "ifc2x3tc1");
			SProject teklaHouseMEPGround = serviceInterface.addProjectAsSubProject("Teklas House MEP, Ground", mep.getOid(), "ifc2x3tc1");
			SProject teklaHouseMEP1 = serviceInterface.addProjectAsSubProject("Tekla House MEP, 1st", mep.getOid(), "ifc2x3tc1");
			SProject teklaHouseMEP2 = serviceInterface.addProjectAsSubProject("Tekla House MEP, 2nd", mep.getOid(), "ifc2x3tc1");
			SProject teklaHouseMEP3 = serviceInterface.addProjectAsSubProject("Tekla House MEP, 3rd", mep.getOid(), "ifc2x3tc1");
			SProject teklaHouseMEPRoof = serviceInterface.addProjectAsSubProject("Tekla House MEP, Roof", mep.getOid(), "ifc2x3tc1");
			SProject site = serviceInterface.addProjectAsSubProject("Site", mainProject.getOid(), "ifc2x3tc1");
			serviceInterface.addProjectAsSubProject("Site.skp", site.getOid(), "ifc2x3tc1");
			serviceInterface.addProjectAsSubProject("Tower crane", site.getOid(), "ifc2x3tc1");
			serviceInterface.addProjectAsSubProject("Caterpillar", site.getOid(), "ifc2x3tc1");
			serviceInterface.addProjectAsSubProject("Excavator", site.getOid(), "ifc2x3tc1");
			SProject grid = serviceInterface.addProjectAsSubProject("Grid", mainProject.getOid(), "ifc2x3tc1");
			SProject teklaHouseGrids = serviceInterface.addProjectAsSubProject("Tekla House Grids", grid.getOid(), "ifc2x3tc1");
			
			SDeserializerPluginConfiguration deserializer = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", grid.getOid());
			
			client.checkin(teklaHouseStructural.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Structural.ifcZIP"));
			client.checkin(teklaHouseGrids.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Grids.ifc"));
			client.checkin(teklaHouseFoundationFootings.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Foundation Footings.ifcZIP"));
			client.checkin(teklaHouseFoundationPiles.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Foundation Piles.ifcZIP"));
			client.checkin(teklaHouseFoundationRebars.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Foundation Rebars.ifcZIP"));
			client.checkin(teklaHouseFoundationEmbedments.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Foundation Embedments.ifcZIP"));
			client.checkin(teklaHousePrecastRebars.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Precast Rebars.ifcZIP"));
			client.checkin(teklaHousePrecastConcrete.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Precast Concrete.ifcZIP"));
//			client.checkin(teklaHouseCIPPours.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder, "Tekla House CIP Pours.ifc"));
			client.checkin(teklaHouseCIPRebars.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House CIP Rebars.ifcZIP"));
			client.checkin(teklaHouseCIPColumns.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House CIP Columns.ifcZIP"));
			client.checkin(teklaHouseArchitectural.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House Architectural.ifczip"));
			client.checkin(teklaHouseMEPGround.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House MEP, Ground.ifc"));
			client.checkin(teklaHouseMEP1.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House MEP, 1st.ifc"));
			client.checkin(teklaHouseMEP2.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House MEP, 2nd.ifc"));
			client.checkin(teklaHouseMEP3.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House MEP, 3rd.ifc"));
			client.checkin(teklaHouseMEPRoof.getOid(), "Initial", deserializer.getOid(), false, true, baseFolder.resolve("Tekla House MEP, Roof.ifc"));

			mainProject = serviceInterface.getProjectByPoid(mainProject.getOid());
			SSerializerPluginConfiguration serializer = client.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
			client.download(mainProject.getLastRevisionId(), serializer.getOid(), Paths.get("output.ifc"));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}