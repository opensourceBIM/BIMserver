package org.bimserver.tests;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.shared.ChangeSet;

public class ChangeSetReader {
	public static void main(String[] args) {
		new ChangeSetReader().start();
	}

	private void start() {
		try {
			JAXBContext context = JAXBContext.newInstance(ChangeSet.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ChangeSet changeSet = (ChangeSet)unmarshaller.unmarshal(new File("changeset_example.xml"));
			System.out.println(changeSet);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
