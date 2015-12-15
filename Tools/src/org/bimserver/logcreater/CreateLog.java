package org.bimserver.logcreater;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.plugins.services.BimServerClientInterface;

import au.com.bytecode.opencsv.CSVWriter;

public class CreateLog {
	private final Map<GregorianCalendar, Event> timeline = new TreeMap<>();

	public static abstract class Event {
	}
	
	public static class ProjectCreated extends Event {

		private SProject sProject;

		public ProjectCreated(SProject sProject) {
			this.sProject = sProject;
		}
		
		@Override
		public String toString() {
			return sProject.getName();
		}
	}
	
	public static class UserCreated extends Event {
		private SUser sUser;

		public UserCreated(SUser sUser) {
			this.sUser = sUser;
		}

		@Override
		public String toString() {
			return sUser.getName();
		}
	}
	
	public static class RevisionCreated extends Event {
		private SRevision sRevision;

		public RevisionCreated(SRevision sRevision) {
			this.sRevision = sRevision;
		}
		
		@Override
		public String toString() {
			return sRevision.getComment();
		}
	}
	
	public static void main(String[] args) {
		new CreateLog().create();
	}

	private void create() {
		try (BimServerClientInterface client = LocalDevSetup.setupJson("")) {
			List<SProject> projects = client.getBimsie1ServiceInterface().getAllProjects(false, false);
			for (SProject sProject : projects) {
				GregorianCalendar created = new GregorianCalendar();
				created.setTime(sProject.getCreatedDate());
				timeline.put(created, new ProjectCreated(sProject));
				List<SRevision> revisions = client.getBimsie1ServiceInterface().getAllRevisionsOfProject(sProject.getOid());
				for (SRevision sRevision : revisions) {
					GregorianCalendar gregorianCalendar = new GregorianCalendar();
					gregorianCalendar.setTime(sRevision.getDate());
					timeline.put(gregorianCalendar, new RevisionCreated(sRevision));
				}
			}
			List<SUser> users = client.getServiceInterface().getAllUsers();
			for (SUser sUser : users) {
				GregorianCalendar created = new GregorianCalendar();
				created.setTime(sUser.getCreatedOn());
				timeline.put(created, new UserCreated(sUser));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File("elassticlog.csv")))) {
			csvWriter.writeNext(new String[]{"Date/Time", "Type", "Description"});
			for (GregorianCalendar date : timeline.keySet()) {
				
				Event event = timeline.get(date);
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				csvWriter.writeNext(new String[format.format()]{"", });
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}