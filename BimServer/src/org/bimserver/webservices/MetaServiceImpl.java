package org.bimserver.webservices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bimserver.interfaces.objects.SServiceField;
import org.bimserver.interfaces.objects.SServiceInterface;
import org.bimserver.interfaces.objects.SServiceMethod;
import org.bimserver.interfaces.objects.SServiceParameter;
import org.bimserver.interfaces.objects.SServiceType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;

public class MetaServiceImpl extends GenericServiceImpl implements MetaInterface {
	public MetaServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public List<SServiceInterface> getServiceInterfaces() throws ServerException, UserException {
		List<SServiceInterface> sServiceInterfaces = new ArrayList<SServiceInterface>();
		for (String name : getBimServer().getServicesMap().keySetName()) {
			SServiceInterface sServiceInterface = new SServiceInterface();
			sServiceInterface.setName(name);
			sServiceInterface.setSimpleName(getBimServer().getServicesMap().getByName(name).getSimpleName());
			sServiceInterfaces.add(sServiceInterface);
		}
		Collections.sort(sServiceInterfaces, new Comparator<SServiceInterface>() {
			@Override
			public int compare(SServiceInterface o1, SServiceInterface o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return sServiceInterfaces;
	}

	@Override
	public List<SServiceMethod> getServiceMethods(String serviceInterfaceName) throws ServerException, UserException {
		List<SServiceMethod> sServiceMethods = new ArrayList<SServiceMethod>();
		SService sService = getBimServer().getServicesMap().getByName(serviceInterfaceName);
		if (sService == null) {
			throw new UserException("Service \"" + serviceInterfaceName + "\" not found");
		}
		for (SMethod sMethod : sService.getMethods()) {
			SServiceMethod sServiceMethod = new SServiceMethod();
			sServiceMethod.setName(sMethod.getName());
			sServiceMethod.setDoc(sMethod.getDoc());
			sServiceMethod.setReturnDoc(sMethod.getReturnDoc());
			// sServiceMethod.setReturnType(sMethod.getReturnType().getName());
			sServiceMethods.add(sServiceMethod);
		}
		return sServiceMethods;
	}

	@Override
	public List<SServiceType> getServiceTypes(String serviceInterfaceName) throws ServerException, UserException {
		List<SServiceType> sServiceTypes = new ArrayList<SServiceType>();
		SService serviceInterface = getBimServer().getServicesMap().getByName(serviceInterfaceName);
		if (serviceInterface == null) {
			throw new UserException("Service \"" + serviceInterfaceName + "\" not found");
		}
		for (SClass sType : serviceInterface.getTypes()) {
			SServiceType sServiceType = new SServiceType();
			sServiceType.setName(sType.getName());
			sServiceTypes.add(sServiceType);
		}
		return sServiceTypes;
	}

	// TODO Recursion to same type will result in endless loop
	public SServiceType createSServiceType(SClass sClass) throws UserException, ServerException {
		if (sClass == null) {
			return null;
		}
		SServiceType sServiceType = new SServiceType();
		sServiceType.setName(sClass.getName());
		sServiceType.setSimpleName(sClass.getSimpleName());
		for (SField field : sClass.getAllFields()) {
			SServiceField sServiceField = new SServiceField();
			sServiceField.setName(field.getName());
			sServiceField.setType(createSServiceType(field.getType()));
			sServiceField.setGenericType(createSServiceType(field.getGenericType()));
			sServiceField.setDoc(field.getDoc());
			sServiceType.getFields().add(sServiceField);
		}
		return sServiceType;
	}

	@Override
	public List<SServiceParameter> getServiceMethodParameters(String serviceInterfaceName, String serviceMethodName) throws ServerException, UserException {
		List<SServiceParameter> sServiceParameters = new ArrayList<SServiceParameter>();
		SService serviceInterface = getBimServer().getServicesMap().getByName(serviceInterfaceName);
		if (serviceInterface == null) {
			throw new UserException("Service \"" + serviceInterfaceName + "\" not found");
		}
		SMethod sMethod = serviceInterface.getSMethod(serviceMethodName);
		if (sMethod == null) {
			throw new UserException("Method \"" + serviceMethodName + "\" not found in \"" + serviceInterfaceName + "\"");
		}
		for (SParameter sParameter : sMethod.getParameters()) {
			SServiceParameter sServiceParameter = new SServiceParameter();
			sServiceParameter.setName(sParameter.getName());
			sServiceParameter.setDoc(sParameter.getDoc());
			sServiceParameter.setType(createSServiceType(sParameter.getType()));
			sServiceParameter.setGenericType(createSServiceType(sParameter.getGenericType()));
			sServiceParameters.add(sServiceParameter);
		}
		return sServiceParameters;
	}
}