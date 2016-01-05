package org.bimserver.demoplugins.service.planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.demoplugins.service.planner.Event.Timing;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcIdentifier;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;

public class Planner {
	private EventLog trainingData;
	
	private Map<String, Planning> planningsByGuid = new HashMap<>();
	
//	private Map<String, Planning> planningsByMaterial = new HashMap<>();

	private Map<String, List<String>> materialToGuid = new HashMap<>();
	
	private final Map<String, Task> tasks = new HashMap<>();

	private Set<String> materialAggregators;

	private String materialParameter;
	
	public Planner(String materialParameter) {
		this.materialParameter = materialParameter;
	}
	
	public void feedTrainingData(EventLog eventLog) {
		if (this.trainingData == null) {
			this.trainingData = new EventLog();
		}
		this.trainingData.add(eventLog);
	}

	private Task getOrCreateTask(String code, String description) {
		Task task = tasks.get(description);
		if (task == null) {
			task = new Task(description, code, description);
			tasks.put(description, task);
		}
		return task;
	}
	
	private List<String> getOrCreateListOfGuid(String material) {
		List<String> list = materialToGuid.get(material);
		if (list == null) {
			list = new ArrayList<String>();
			materialToGuid.put(material, list);
		}
		return list;
	}

	private Planning getOrCreatePlanning(String guid) {
		Planning planning = planningsByGuid.get(guid);
		if (planning == null) {
			planning = new Planning();
			planningsByGuid.put(guid, planning);
		}
		return planning;
	}
	
	public void analyze(Set<String> materialAggregators) {
		this.materialAggregators = materialAggregators;
		for (Event event : trainingData.getOrderedByStartDate()) {
			Planning planning = getOrCreatePlanning(event.getGuid());
			getOrCreateListOfGuid(event.getMaterial()).add(event.getGuid());
			Task task = getOrCreateTask(event.getTask(), event.getTaskName());
			if (event.getTiming() == Timing.ON_TIME) {
				task.addOnTime();
			} else if (event.getTiming() == Timing.TOO_LATE) {
				task.addNotOnTime();
			} else {
				task.addUnknown();
			}
			planning.add(task);
		}
	}
	
	public Set<Planning> getPlanningsForMaterial(String material) throws PlanningException {
		Set<Planning> plannings = new HashSet<>();
		List<String> guids = materialToGuid.get(material);
		if (guids == null) {
			throw new PlanningException("Material not found: " + material);
		}
		for (String guid : guids) {
			Planning planning = planningsByGuid.get(guid);
			plannings.add(planning);
		}
		return plannings;
	}
	
	private String extractMaterial(IfcProduct ifcProduct) {
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
								if (ifcProperty.getName().equals(materialParameter)) {
									return label.getWrappedValue();
								}
							} else if (propertyValue.getNominalValue() instanceof IfcIdentifier) {
								IfcIdentifier ifcIdentifier = (IfcIdentifier)propertyValue.getNominalValue();
								if (ifcProperty.getName().equals(materialParameter)) {
									return ifcIdentifier.getWrappedValue();
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	private String getSimlifiedMaterialName(String materialName) {
		for (String simplified : materialAggregators) {
			if (!simplified.equals("") && materialName.toLowerCase().contains(simplified.toLowerCase())) {
				return simplified;
			}
		}
		return materialName;
	}
	
	public Map<String, PlanningAdvice> getSuggestedPlanningsPerMaterial(IfcModelInterface model) {
		Map<String, PlanningAdvice> result = new HashMap<>();
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			String originalMaterial = extractMaterial(ifcProduct);
			if (originalMaterial != null) {
				String simplifiedMaterial = getSimlifiedMaterialName(originalMaterial);
				PlanningAdvice planningAdvice = result.get(simplifiedMaterial);
				if (planningAdvice == null) {
					planningAdvice = new PlanningAdvice();
					List<String> list = materialToGuid.get(originalMaterial);
					if (list == null) {
						list = materialToGuid.get(simplifiedMaterial);
					}
					if (list == null) {
						planningAdvice.setDatabaseCount(0);
					} else {
						Set<String> set = new HashSet<>(list);
						planningAdvice.setDatabaseCount(set.size());
						for (String guid : list) {
							Planning planning = planningsByGuid.get(guid);
							if (planning != null) {
								planningAdvice.addVariant(planning);
							}
						}
					}
					result.put(simplifiedMaterial, planningAdvice);
				}
				planningAdvice.incrementModelCount(ifcProduct);
			}
		}		
		return result;
	}
}