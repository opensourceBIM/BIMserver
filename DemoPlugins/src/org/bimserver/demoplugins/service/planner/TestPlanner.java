//package org.bimserver.demoplugins.service.planner;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//public class TestPlanner {
//	public static void main(String[] args) {
//		EventLog eventLog;
//		try {
//			eventLog = new EventLog(new FileInputStream(new File("D:/Dropbox/Process Mining BIMserver/Ifc met planningsdata/eventlog.csv")));
//			Planner planner = new Planner();
//			planner.feedTrainingData(eventLog);
//			planner.analyze();
//			for (Planning planning : planner.getPlanningsForMaterial("IFC_dakplaat_195_overstek_ongeisoleerd")) {
//				System.out.println(planning);
//			}
//		} catch (FileNotFoundException | PlanningException e) {
//			e.printStackTrace();
//		}
//	}
//}
