package org.bimserver.demoplugins.service.tco;

import java.io.IOException;

import com.google.gdata.util.ServiceException;

public class TestTcoGoogleSpreadSheet {
	public static void main(String[] args) {
		TcoGoogleSpreadSheet tcoGoogleSpreadSheet = new TcoGoogleSpreadSheet(args[0], args[1], args[2]);
		
		tcoGoogleSpreadSheet.setCollectiveExternalFacadeArea(123.45);
		tcoGoogleSpreadSheet.setCollectiveExternalFloorArea(123.45);
		tcoGoogleSpreadSheet.setCollectiveExternalRoofArea(123.45);
		tcoGoogleSpreadSheet.setCollectiveGrossFloorArea(123.45);
		tcoGoogleSpreadSheet.setCollectiveNumberOfFloors(12);
		tcoGoogleSpreadSheet.setCollectiveVolume(123.45);
		
		tcoGoogleSpreadSheet.setHouseHoldExternalFacadeAread(55.1);
		tcoGoogleSpreadSheet.setHouseHoldExternalFloorArea(55.2);
		tcoGoogleSpreadSheet.setHouseHoldExternalRoofArea(55.2);
		tcoGoogleSpreadSheet.setHouseHoldGrossFloorArea(55.2);
		tcoGoogleSpreadSheet.setHouseHoldNumberOfFloors(7);
		tcoGoogleSpreadSheet.setHouseHoldVolume(500.2);
		
		try {
			tcoGoogleSpreadSheet.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}