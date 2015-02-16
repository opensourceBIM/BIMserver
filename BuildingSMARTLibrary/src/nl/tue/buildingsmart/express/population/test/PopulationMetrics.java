package nl.tue.buildingsmart.express.population.test;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashMap;
import java.util.TreeSet;

import nl.tue.buildingsmart.express.dictionary.Namespaces;
import nl.tue.buildingsmart.express.population.EntityInstance;
import nl.tue.buildingsmart.express.population.ModelPopulation;

@SuppressWarnings("all")
public class PopulationMetrics {
	ModelPopulation pop;
	Namespaces nsConf;
	HashMap<String, Integer> namespaceMembers = new HashMap<String, Integer>();

	public PopulationMetrics(ModelPopulation pop, Namespaces nsConf) {

		this.pop = pop;
		this.nsConf = nsConf;
	}

	public void countEntitiesPerNamespace() {
		for (String ns : nsConf.getNamespaces()) {
			namespaceMembers.put(ns, new Integer(0));
		}
		for (EntityInstance entInst : pop.getInstances().values()) {
			String ns = nsConf.getNS(entInst.getEntityDefinition().getName());

			namespaceMembers.put(ns, namespaceMembers.get(ns) + 1);
		}
		TreeSet<String> ts = new TreeSet(namespaceMembers.keySet());
		for (String ns : ts) {

			System.out.println(ns + ";" + namespaceMembers.get(ns));
		}
	}
}
