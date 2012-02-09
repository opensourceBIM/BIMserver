package org.bimserver.test.framework.actions;

import java.util.Random;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public abstract class Action {
	private final TestFramework testFramework;
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
