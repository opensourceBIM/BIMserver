package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.Random;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public abstract class Action {
	private final TestFramework testFramework;
	private ActionResults actionResults = new ActionResults();
	private Random random;

	public Action(TestFramework testFramework) {
		this.testFramework = testFramework;
		random = new Random();
	}
	
	public Random getRandom() {
		return random;
	}
	
	public TestFramework getTestFramework() {
		return testFramework;
	}
	
	public String randomString() {
		return "" + Math.abs(random.nextInt());
	}

	public abstract void execute(VirtualUser virtualUser) throws ServerException, UserException;
	public int getWeight() {
		return 1;
	}
	
	public ActionResults getActionResults() {
		return actionResults;
	}
	
	public boolean nextBoolean() {
		return random.nextBoolean();
	}
	
	public int nextInt() {
		return random.nextInt();
	}

	public int nextInt(int max) {
		return random.nextInt(max);
	}
}
