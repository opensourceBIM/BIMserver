package org.bimserver.demoplugins.service.planner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.bimserver.demoplugins.service.planner.Event.Timing;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcDateAndTime;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcProcess;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelAssigns;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsTasks;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToProcess;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcScheduleTimeControl;
import org.bimserver.models.ifc2x3tc1.IfcTask;

import com.google.common.base.Charsets;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class EventLog implements Iterable<Event> {
	private final List<Event> events = new ArrayList<>();

	public EventLog() {
	}
	
	public EventLog(InputStream inputStream) {
		CSVReader reader = new CSVReader(new InputStreamReader(inputStream, Charsets.UTF_8));
		try {
			String[] header = reader.readNext();
			String[] line = reader.readNext();
			while (line != null) {
				Event event = new Event();
				event.setGuid(line[0]);
				event.setType(line[1]);
				event.setNlSfb(line[2]);
				event.setMaterial(line[3]);
				event.setTask(line[4]);
				event.setResource(line[5]);
				event.setTaskName(line[6]);
				event.setTaskStart(parseDate(line[7]));
				event.setTaskFinish(parseDate(line[8]));
				if (line.length > 9) {
					String timing = line[9];
					if (timing.equals("On time")) {
						event.setTiming(Timing.ON_TIME);
					} else if (timing.equals("Too late")) {
						event.setTiming(Timing.TOO_LATE);
					}
				}
				events.add(event);
				line = reader.readNext();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public EventLog(EventLog eventLog) {
		for (Event event : eventLog) {
			events.add(event);
		}
	}

	public EventLog(IfcModelInterface model, String nlsfbPropertyName, String materialPropertyName) {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			Event event = new Event();
			event.setGuid(ifcProduct.getGlobalId());
			event.setResource(ifcProduct.getName());
			event.setType(ifcProduct.eClass().getName());
			
			for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
				if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
					IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
					IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
					if (propertySetDefinition instanceof IfcPropertySet) {
						IfcPropertySet ifcPropertySet = (IfcPropertySet)propertySetDefinition;
						for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
							if (ifcProperty instanceof IfcPropertySingleValue) {
								IfcPropertySingleValue propertyValue = (IfcPropertySingleValue)ifcProperty;
								if (propertyValue.getNominalValue() instanceof IfcLabel) {
									IfcLabel label = (IfcLabel)propertyValue.getNominalValue();
									if (ifcProperty.getName().equals(materialPropertyName)) {
										event.setMaterial(label.getWrappedValue());
									} else if (ifcProperty.getName().equals(nlsfbPropertyName)) {
										event.setNlSfb(label.getWrappedValue());
									}
								}
							}
						}
					}
				}
			}
			
			for (IfcRelAssigns ifcRelAssigns : ifcProduct.getHasAssignments()) {
				if (ifcRelAssigns instanceof IfcRelAssignsToProcess) {
					IfcRelAssignsToProcess ifcRelAssignsToProcess = (IfcRelAssignsToProcess)ifcRelAssigns;
					IfcProcess ifcProcess = ifcRelAssignsToProcess.getRelatingProcess();
					if (ifcProcess instanceof IfcTask) {
						IfcTask task = (IfcTask)ifcProcess;
						event.setTaskName(task.getName());
						event.setTask(task.getTaskId());
						
						for (IfcRelAssigns ifcRelAssigns2 : task.getHasAssignments()) {
							if (ifcRelAssigns2 instanceof IfcRelAssignsTasks) {
								IfcRelAssignsTasks ifcRelAssignsTasks = (IfcRelAssignsTasks)ifcRelAssigns2;
								IfcScheduleTimeControl timeForTask = ifcRelAssignsTasks.getTimeForTask();
								IfcDateAndTime start = (IfcDateAndTime) timeForTask.getScheduleStart();
								IfcDateAndTime finish = (IfcDateAndTime) timeForTask.getScheduleFinish();
								
								event.setTaskStart(parseDate(start));
								event.setTaskFinish(parseDate(finish));
							}
						}
					}
				}
				events.add(event);
				event = event.copy();
			}
		}
	}

	private GregorianCalendar parseDate(IfcDateAndTime start) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.set(Calendar.YEAR, start.getDateComponent().getYearComponent());
		gregorianCalendar.set(Calendar.MONTH, start.getDateComponent().getMonthComponent() + 1);
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, start.getDateComponent().getDayComponent());
		return gregorianCalendar;
	}

	private GregorianCalendar parseDate(String string) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("d-M-y");
		Date date = dateFormat.parse(string);
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		return gregorianCalendar;
	}
	
	public EventLog getOrderedByStartDate() {
		EventLog eventLog = new EventLog(this);
		Collections.sort(eventLog.events);
		return eventLog;
	}

	public void add(EventLog eventLog) {
		for (Event event : eventLog.events) {
			this.events.add(event);
		}
	}

	@Override
	public Iterator<Event> iterator() {
		return events.iterator();
	}
	
	public String formatDate(GregorianCalendar gregorianCalendar) {
		DateFormat dateFormat = new SimpleDateFormat("d-M-y");
		return dateFormat.format(gregorianCalendar.getTime());
	}

	public String toCsvString() throws IOException {
		StringWriter sw = new StringWriter();
		CSVWriter csvWriter = new CSVWriter(sw);
		csvWriter.writeNext(new String[]{"GUID", "ifcClass", "Nl-sfb", "Material", "Task", "Resource", "TaskName", "TaskStart", "TaskFinish"});

		for (Event event : events) {
			csvWriter.writeNext(new String[]{
				event.getGuid(),
				event.getType(),
				event.getNlSfb(),
				event.getMaterial(),
				event.getTask(),
				event.getResource(),
				event.getTaskName(),
				formatDate(event.getTaskStart()),
				formatDate(event.getTaskFinish())
			});
		}

		csvWriter.close();
		return sw.toString();
	}
}