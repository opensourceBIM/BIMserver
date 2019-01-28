package org.bimserver.webservices.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bimserver.interfaces.objects.SServiceField;
import org.bimserver.interfaces.objects.SServiceInterface;
import org.bimserver.interfaces.objects.SServiceMethod;
import org.bimserver.interfaces.objects.SServiceParameter;
import org.bimserver.interfaces.objects.SServiceSimpleType;
import org.bimserver.interfaces.objects.SServiceType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.webservices.ServiceMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MetaServiceImpl extends GenericServiceImpl implements MetaInterface {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	public MetaServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public List<SServiceInterface> getServiceInterfaces() throws ServerException, UserException {
		List<SServiceInterface> sServiceInterfaces = new ArrayList<SServiceInterface>();
		for (String name : getBimServer().getServicesMap().keySetName()) {
			SServiceInterface sServiceInterface = convertServiceInterface(name);
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

	private SServiceInterface convertServiceInterface(String name) {
		SServiceInterface sServiceInterface = new SServiceInterface();
		SService byName = getBimServer().getServicesMap().getByName(name);
		sServiceInterface.setName(name);
		sServiceInterface.setNameSpace(byName.getNameSpace());
		sServiceInterface.setSimpleName(byName.getSimpleName());
		return sServiceInterface;
	}

	@Override
	public List<SServiceMethod> getServiceMethods(String serviceInterfaceName) throws ServerException, UserException {
		List<SServiceMethod> sServiceMethods = new ArrayList<SServiceMethod>();
		SService sService = getBimServer().getServicesMap().getByName(serviceInterfaceName);
		if (sService == null) {
			throw new UserException("Service \"" + serviceInterfaceName + "\" not found");
		}
		for (SMethod sMethod : sService.getMethods()) {
			SServiceMethod sServiceMethod = convertMethod(sMethod);
			sServiceMethods.add(sServiceMethod);
		}
		return sServiceMethods;
	}

	private SServiceMethod convertMethod(SMethod sMethod) {
		SServiceMethod sServiceMethod = new SServiceMethod();
		sServiceMethod.setName(sMethod.getName());
		sServiceMethod.setDoc(sMethod.getDoc());
		sServiceMethod.setReturnDoc(sMethod.getReturnDoc());
		// sServiceMethod.setReturnType(sMethod.getReturnType().getName());
		return sServiceMethod;
	}

	@Override
	public List<SServiceType> getServiceTypes() throws ServerException, UserException {
		List<SServiceType> sServiceTypes = new ArrayList<SServiceType>();
		for (SClass sType : getBimServer().getServicesMap().getTypes()) {
			sServiceTypes.add(createSServiceType(sType, false));
		}
		return sServiceTypes;
	}

	public List<String> getEnumLiterals(String enumName) throws UserException {
		List<String> result = new ArrayList<String>();
		SClass type = getBimServer().getServicesMap().getType(enumName);
		for (Object enumConstant : type.getInstanceClass().getEnumConstants()) {
			result.add(enumConstant.toString());
		}
		return result;
	}
	
	// TODO Recursion to same type will result in endless loop
	public SServiceType createSServiceType(SClass sClass, boolean recurse) throws UserException, ServerException {
		if (sClass == null) {
			return null;
		}
		SServiceType sServiceType = new SServiceType();
		sServiceType.setName(sClass.getName());
		sServiceType.setSimpleName(sClass.getSimpleName());
		sServiceType.setSimpleType(SServiceSimpleType.valueOf(sClass.getSimpleType().name()));
		for (SField field : sClass.getOwnFields()) {
			SServiceField sServiceField = new SServiceField();
			sServiceField.setName(field.getName());
			if (recurse) {
				sServiceField.setType(createSServiceType(field.getType(), recurse));
				sServiceField.setGenericType(createSServiceType(field.getGenericType(), recurse));
			}
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
			sServiceParameter.setType(createSServiceType(sParameter.getType(), false));
			sServiceParameter.setGenericType(createSServiceType(sParameter.getGenericType(), false));
			sServiceParameters.add(sServiceParameter);
		}
		return sServiceParameters;
	}

	@Override
	public SServiceInterface getServiceInterface(String serviceInterfaceName) throws ServerException, UserException {
		return convertServiceInterface(serviceInterfaceName);
	}

	@Override
	public SServiceMethod getServiceMethod(String serviceInterfaceName, String methodName) throws ServerException, UserException {
		SService sService = getBimServer().getServicesMap().getByName(serviceInterfaceName);
		if (sService == null) {
			throw new UserException("Service \"" + serviceInterfaceName + "\" not found");
		}
		return convertMethod(sService.getMethod(methodName));
	}

	@Override
	public String getAllAsJson() throws ServerException, UserException {
		return getBimServer().getServicesMap().toJson(OBJECT_MAPPER).toString();
	}
}