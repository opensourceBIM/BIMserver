package org.bimserver.querycompiler;

public class VirtualClassLoader extends ClassLoader {
	private final VirtualFile baseDir;

	public VirtualClassLoader(ClassLoader parent, VirtualFile baseDir) {
		super(parent);
		this.baseDir = baseDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		VirtualFile virtualFile = baseDir.get(name);
		if (virtualFile != null) {
			byte[] bytes = virtualFile.getData();
			return defineClass(name, bytes, 0, bytes.length);
		}
		if (name.equals("org.bimserver.querycompiler.QueryInterface")) {
			return super.findClass(name);
		} else {
			throw new ClassNotFoundException();
		}
	}
}