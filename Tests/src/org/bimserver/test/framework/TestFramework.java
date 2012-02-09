package org.bimserver.test.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TestFramework {
	private static final int NR_VIRTUAL_USERS = 1;
	private static final File IFC_FILES_FOLDER = new File("../TestData/data");
	private final List<File> files = new ArrayList<File>();
	private final Set<VirtualUser> virtualUsers = new HashSet<VirtualUser>();
	private final Random random = new Random();
	
	public static void main(String[] args) {
		new TestFramework().start();
	}

	private void start() {
		initFiles();
		RandomBimServerClientFactory randomBimServerClientFactory = new RandomBimServerClientFactory();
		VirtualUserFactory virtualUserFactory = new VirtualUserFactory(this, randomBimServerClientFactory);
		for (int i=0; i<NR_VIRTUAL_USERS; i++) {
			VirtualUser virtualUser = virtualUserFactory.create("" + i);
			virtualUsers.add(virtualUser);
		}
		for (VirtualUser virtualUser : virtualUsers) {
			virtualUser.start();
		}
	}

	private void initFiles() {
		for (File file : IFC_FILES_FOLDER.listFiles()) {
			if (file.isFile() && !file.getName().contains(".svn")) {
				files.add(file);
			}
		}
	}

	public synchronized File getRandomFile() {
		return files.get(random.nextInt(files.size()));
	}

	public synchronized void unsubsribe(VirtualUser virtualUser) {
		virtualUsers.remove(virtualUser);
	}
}