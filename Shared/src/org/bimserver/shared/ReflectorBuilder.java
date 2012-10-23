package org.bimserver.shared;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.ServicesMap;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class ReflectorBuilder {
	private ServicesMap servicesMap;
	private ClassPool pool;
	private static int implementationCounter = 0;

	public ReflectorBuilder(ServicesMap servicesMap) {
		this.servicesMap = servicesMap;
	}

	public static void main(String[] args) {
		ServicesMap servicesMap = new ServicesMap();
		SService sService = new SService("", org.bimserver.shared.interfaces.ServiceInterface.class);
		servicesMap.add(sService);
		servicesMap.add(new SService("", NotificationInterface.class, sService));
		
		ReflectorBuilder reflectorBuilder = new ReflectorBuilder(servicesMap);
		ReflectorFactory reflectorFactory = reflectorBuilder.newReflectorFactory();
		ServiceInterface createReflector = reflectorFactory.createReflector(ServiceInterface.class, new Reflector() {
			
			@Override
			public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException {
				return null;
			}
		});
		System.out.println(createReflector);
	}
	
	@SuppressWarnings("unchecked")
	public ReflectorFactory newReflectorFactory() {
		implementationCounter++;
		try {
			pool = ClassPool.getDefault();
			pool.insertClassPath(new ClassClassPath(this.getClass()));
			
			for (String name : servicesMap.keySet()) {
				SService sService = servicesMap.get(name);
				build("org.bimserver.interfaces", (Class<? extends PublicInterface>) Class.forName("org.bimserver.shared.interfaces." + name), sService);
			}
			
			CtClass reflectorFactoryImpl = pool.makeClass("org.bimserver.reflector.ReflectorFactoryImpl" + implementationCounter);
			reflectorFactoryImpl.addInterface(pool.get("org.bimserver.shared.ReflectorFactory"));
			CtClass[] parameters = new CtClass[2];
			parameters[0] = pool.get("java.lang.Class");
			parameters[1] = pool.get("org.bimserver.shared.reflector.Reflector");
			CtMethod method = new CtMethod(pool.get("org.bimserver.shared.interfaces.PublicInterface"), "createReflector", parameters, reflectorFactoryImpl);
			StringBuilder methodBuilder = new StringBuilder();
			methodBuilder.append("{");
			methodBuilder.append("if (1==0) {");
			for (String name : servicesMap.keySet()) {
				methodBuilder.append("} else if ($1.getSimpleName().equals(\"" + name + "\")) {");
				methodBuilder.append("return new org.bimserver.interfaces." + name + "Impl" + implementationCounter + "($2);");
			}
			methodBuilder.append("}");
			methodBuilder.append("return null;");
			methodBuilder.append("}");
			method.setBody(methodBuilder.toString());
			reflectorFactoryImpl.addMethod(method);
			Class<?> class1 = pool.toClass(reflectorFactoryImpl, getClass().getClassLoader(), getClass().getProtectionDomain());
			return (ReflectorFactory) class1.newInstance();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void build(String implPackageName, Class<? extends PublicInterface> interfaceClass, org.bimserver.shared.meta.SService sService) {
		try {
			CtClass reflectorImplClass = pool.makeClass(implPackageName + "." + interfaceClass.getSimpleName() + "Impl" + implementationCounter);
			reflectorImplClass.addInterface(pool.get(interfaceClass.getName()));
			CtClass reflectorClass = pool.get("org.bimserver.shared.reflector.Reflector");
			CtField reflectorField = new CtField(reflectorClass, "reflector", reflectorImplClass);
			reflectorImplClass.addField(reflectorField);
			CtConstructor constructor = new CtConstructor(new CtClass[] {reflectorClass}, reflectorImplClass);
			StringBuilder sb = new StringBuilder();
			reflectorImplClass.addConstructor(constructor);
			sb.append("{");
			sb.append("this.reflector = $1;");
			sb.append("}");
			constructor.setBody(sb.toString());
			
			for (SMethod sMethod : sService.getMethods()) {
				CtClass[] parameters = new CtClass[sMethod.getParameters().size()];
				int i=0;
				for (org.bimserver.shared.meta.SParameter sParameter : sMethod.getParameters()) {
					parameters[i] = pool.get(sParameter.getType().getName());
					i++;
				}
				CtMethod method = new CtMethod(pool.get(sMethod.getReturnType().getName()), sMethod.getName(), parameters, reflectorImplClass);
				StringBuilder methodBuilder = new StringBuilder();
				methodBuilder.append("{");
				if (sMethod.getReturnType().isVoid()) {
				} else {
					methodBuilder.append("return (" + sMethod.getReturnType().getName() + ")");
				}
				methodBuilder.append("reflector.callMethod(\"" + interfaceClass.getSimpleName() + "\", \"" + sMethod.getName() + "\", " + sMethod.getReturnType().getName() + ".class");
				if (sMethod.getParameters().isEmpty()) {
					methodBuilder.append(", new org.bimserver.shared.reflector.KeyValuePair[0]");
				} else {
					methodBuilder.append(", new org.bimserver.shared.reflector.KeyValuePair[]{");
					int x=1;
					for (SParameter sParameter : sMethod.getParameters()) {
						methodBuilder.append("new org.bimserver.shared.reflector.KeyValuePair(\"" + sParameter.getName() + "\", $" + x + ")");
						if (sMethod.getParameter(sMethod.getParameters().size() - 1) != sParameter) {
							methodBuilder.append(", ");
						}
						x++;
					}
					methodBuilder.append("}");
				}
				methodBuilder.append(");");
				methodBuilder.append("}");
				method.setBody(methodBuilder.toString());
				reflectorImplClass.addMethod(method);
			}
			pool.toClass(reflectorImplClass, getClass().getClassLoader(), getClass().getProtectionDomain());
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
	}
}