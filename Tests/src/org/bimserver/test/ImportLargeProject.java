package org.bimserver.test;

import java.io.File;
import java.io.IOException;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;

public class ImportLargeProject {
	public static void main(String[] args) {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			File baseFolder = new File("C:\\Users\\Ruben de Laat\\Documents\\ttt");
			
			Bimsie1ServiceInterface serviceInterface = client.getBimsie1ServiceInterface();
			SProject mainProject = serviceInterface.addProject("Tekla Demo Model");
			SProject architectural = serviceInterface.addProjectAsSubProject("Architectural", mainProject.getOid());
			SProject teklaHouseArchitectural = serviceInterface.addProjectAsSubProject("Tekla House Architectural", architectural.getOid());
			SProject structuralSteal = serviceInterface.addProjectAsSubProject("Structural Steal", mainProject.getOid());
			SProject teklaHouseStructural = serviceInterface.addProjectAsSubProject("Tekla House Structural", structuralSteal.getOid());
			SProject foundation = serviceInterface.addProjectAsSubProject("Foundation", mainProject.getOid());
			SProject teklaHouseFoundationFootings = serviceInterface.addProjectAsSubProject("Tekla Hose Foundation Footings", foundation.getOid());
			SProject teklaHouseFoundationPiles = serviceInterface.addProjectAsSubProject("Tekla Hose Foundation Piles", foundation.getOid());
			SProject teklaHouseFoundationRebars = serviceInterface.addProjectAsSubProject("Tekla Hose Foundation Rebars", foundation.getOid());
			SProject teklaHouseFoundationEmbedments = serviceInterface.addProjectAsSubProject("Tekla Hose Foundation Embedments", foundation.getOid());
			SProject cipConcreteContractor = serviceInterface.addProjectAsSubProject("CIP Concrete Contractor", mainProject.getOid());
			SProject teklaHouseCIPPours = serviceInterface.addProjectAsSubProject("Tekla House CIP Pours", cipConcreteContractor.getOid());
			SProject teklaHouseCIPRebars = serviceInterface.addProjectAsSubProject("Tekla House CIP Rebars", cipConcreteContractor.getOid());
			SProject teklaHouseCIPColumns = serviceInterface.addProjectAsSubProject("Tekla House CIP Columns", cipConcreteContractor.getOid());
			SProject formWork = serviceInterface.addProjectAsSubProject("Formwork", mainProject.getOid());
			SProject columnFormwork = serviceInterface.addProjectAsSubProject("Column Formwork", formWork.getOid());
			SProject precast = serviceInterface.addProjectAsSubProject("Precast", mainProject.getOid());
			SProject teklaHousePrecastRebars = serviceInterface.addProjectAsSubProject("Tekla House Precast Rebars", precast.getOid());
			SProject teklaHousePrecastConcrete = serviceInterface.addProjectAsSubProject("Tekla House Precast Concrete", precast.getOid());
			SProject mep = serviceInterface.addProjectAsSubProject("MEP", mainProject.getOid());
			SProject teklaHouseMEPGround = serviceInterface.addProjectAsSubProject("Teklas House MEP, Ground", mep.getOid());
			SProject teklaHouseMEP1 = serviceInterface.addProjectAsSubProject("Tekla House MEP, 1st", mep.getOid());
			SProject teklaHouseMEP2 = serviceInterface.addProjectAsSubProject("Tekla House MEP, 2nd", mep.getOid());
			SProject teklaHouseMEP3 = serviceInterface.addProjectAsSubProject("Tekla House MEP, 3rd", mep.getOid());
			SProject teklaHouseMEPRoof = serviceInterface.addProjectAsSubProject("Tekla House MEP, Roof", mep.getOid());
			SProject site = serviceInterface.addProjectAsSubProject("Site", mainProject.getOid());
			SProject siteSkp = serviceInterface.addProjectAsSubProject("Site.skp", site.getOid());
			SProject towerCrane = serviceInterface.addProjectAsSubProject("Tower crane", site.getOid());
			SProject caterpillar = serviceInterface.addProjectAsSubProject("Caterpillar", site.getOid());
			SProject excavator = serviceInterface.addProjectAsSubProject("Excavator", site.getOid());
			SProject grid = serviceInterface.addProjectAsSubProject("Grid", mainProject.getOid());
			SProject teklaHouseGrids = serviceInterface.addProjectAsSubProject("Tekla House Grids", grid.getOid());
			
			SDeserializerPluginConfiguration deserializer = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");
			
			client.checkin(teklaHouseStructural.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Structural.ifcZIP"));
			client.checkin(teklaHouseGrids.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Grids.ifc"));
			client.checkin(teklaHouseFoundationFootings.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Foundation Footings.ifcZIP"));
			client.checkin(teklaHouseFoundationPiles.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Foundation Piles.ifcZIP"));
			client.checkin(teklaHouseFoundationRebars.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Foundation Rebars.ifcZIP"));
			client.checkin(teklaHouseFoundationEmbedments.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Foundation Embedments.ifcZIP"));
			client.checkin(teklaHousePrecastRebars.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Precast Rebars.ifcZIP"));
			client.checkin(teklaHousePrecastConcrete.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Precast Concrete.ifcZIP"));
//			client.checkin(teklaHouseCIPPours.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House CIP Pours.ifc"));
			client.checkin(teklaHouseCIPRebars.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House CIP Rebars.ifcZIP"));
			client.checkin(teklaHouseCIPColumns.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House CIP Columns.ifcZIP"));
			client.checkin(teklaHouseArchitectural.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House Architectural.ifczip"));
			client.checkin(teklaHouseMEPGround.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House MEP, Ground.ifc"));
			client.checkin(teklaHouseMEP1.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House MEP, 1st.ifc"));
			client.checkin(teklaHouseMEP2.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House MEP, 2nd.ifc"));
			client.checkin(teklaHouseMEP3.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House MEP, 3rd.ifc"));
			client.checkin(teklaHouseMEPRoof.getOid(), "Initial", deserializer.getOid(), false, true, new File(baseFolder, "Tekla House MEP, Roof.ifc"));

			mainProject = serviceInterface.getProjectByPoid(mainProject.getOid());
			SSerializerPluginConfiguration serializer = client.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
			client.download(mainProject.getLastRevisionId(), serializer.getOid(), new File("output.ifc"));
		} catch (ServiceException | ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}