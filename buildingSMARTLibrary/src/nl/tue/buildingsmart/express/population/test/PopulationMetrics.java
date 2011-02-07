package nl.tue.buildingsmart.express.population.test;

import java.util.HashMap;
import java.util.TreeSet;

import nl.tue.buildingsmart.express.dictionary.Namespaces;
import nl.tue.buildingsmart.express.population.EntityInstance;
import nl.tue.buildingsmart.express.population.ModelPopulation;

@SuppressWarnings("all")
public class PopulationMetrics {
	ModelPopulation pop;
	Namespaces nsConf;
	HashMap<String,Integer> namespaceMembers = new HashMap<String,Integer>();
	public PopulationMetrics(ModelPopulation pop, Namespaces nsConf) {
		
		this.pop = pop;
		this.nsConf = nsConf;
	}
	
	public void countEntitiesPerNamespace(){
		for (String ns:nsConf.getNamespaces()){
			namespaceMembers.put(ns, new Integer(0));
		}
		for (EntityInstance entInst:pop.getInstances().values()){
			String ns = nsConf.getNS(entInst.getEntityDefinition().getName());
			
			namespaceMembers.put(ns, namespaceMembers.get(ns)+1);
		}
		TreeSet<String> ts = new TreeSet(namespaceMembers.keySet());
		for (String ns:ts){
			
			System.out.println(ns+";"+namespaceMembers.get(ns));
		}
	}
}
