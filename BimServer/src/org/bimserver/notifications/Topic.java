package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.generated.Bimsie1NotificationInterfaceImpl1;
import org.bimserver.generated.Bimsie1NotificationInterfaceReflector1;
import org.bimserver.generated.Bimsie1RemoteServiceInterfaceImpl1;
import org.bimserver.generated.Bimsie1RemoteServiceInterfaceReflector1;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.shared.json.ReflectorException;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Topic {
	private static final Logger LOGGER = LoggerFactory.getLogger(Topic.class);
	
	private static class LoggingReflector implements Reflector {

		private class Call {
			private String interfaceName;
			private String methodName;
			private Class<?> definedReturnType;
			private KeyValuePair[] args;

			public Call(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) {
				this.interfaceName = interfaceName;
				this.methodName = methodName;
				this.definedReturnType = definedReturnType;
				this.args = args;
			}
			
			public String getInterfaceName() {
				return interfaceName;
			}
			
			public String getMethodName() {
				return methodName;
			}
			
			public Class<?> getDefinedReturnType() {
				return definedReturnType;
			}
			
			public KeyValuePair[] getArgs() {
				return args;
			}
		}
		
		private final List<Call> calls = new ArrayList<Topic.LoggingReflector.Call>();
		
		@Override
		public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException,
				ReflectorException {
			return null;
		}
		
		public List<Call> getCalls() {
			return calls;
		}
	}
	
	private static class FakeEndpoint implements EndPoint{
		private final LoggingReflector loggingReflector = new LoggingReflector();
		private final Bimsie1RemoteServiceInterfaceImpl1 bimsie1RemoteServiceInterfaceImpl1 = new Bimsie1RemoteServiceInterfaceImpl1(loggingReflector);
		private final Bimsie1NotificationInterfaceImpl1 bimsie1NotificationInterfaceImpl1 = new Bimsie1NotificationInterfaceImpl1(loggingReflector);
		
		@Override
		public long getUoid() {
			return 0;
		}
		
		@Override
		public Bimsie1RemoteServiceInterface getRemoteServiceInterface() {
			return bimsie1RemoteServiceInterfaceImpl1;
		}
		
		@Override
		public Bimsie1NotificationInterface getNotificationInterface() {
			return bimsie1NotificationInterfaceImpl1;
		}
		
		@Override
		public long getEndPointId() {
			return 0;
		}
		
		@Override
		public void cleanup() {
		}

		public void replay(EndPoint endPoint) {
			for (org.bimserver.notifications.Topic.LoggingReflector.Call call : loggingReflector.getCalls()) {
				Reflector reflector = null;
				if (call.getInterfaceName().equals(Bimsie1NotificationInterface.class.getName())) {
					reflector = new Bimsie1NotificationInterfaceReflector1(getNotificationInterface());
				} else if (call.getInterfaceName().equals(Bimsie1RemoteServiceInterface.class.getName())) {
					reflector = new Bimsie1RemoteServiceInterfaceReflector1(getRemoteServiceInterface());
				}
				try {
					reflector.callMethod(call.getInterfaceName(), call.getMethodName(), call.getDefinedReturnType(), call.getArgs());
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		}
	}
	
	private final Set<EndPoint> endPoints = new HashSet<EndPoint>();
	private final FakeEndpoint fakeEndPoint = new FakeEndpoint();

	public Topic() {
//		endPoints.add(fakeEndPoint);
	}
	
	public static interface Mapper {
		void map(EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException;
	}
	
	public synchronized void map(Mapper mapper) throws UserException, ServerException, BimserverDatabaseException {
		for (EndPoint endPoint : endPoints) {
			mapper.map(endPoint);
		}
	}
	
	public synchronized void register(EndPoint endPoint) throws TopicRegisterException {
		endPoints.add(endPoint);
//		fakeEndPoint.replay(endPoint);
	}

	public synchronized void unregister(EndPoint endPoint) throws TopicRegisterException {
		endPoints.remove(endPoint);
	}
}