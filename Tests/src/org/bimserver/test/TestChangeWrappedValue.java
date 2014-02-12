package org.bimserver.test;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

public class TestChangeWrappedValue {
	public static void main(String[] args) {
		new TestChangeWrappedValue().start();
	}

	private void start() {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			long poid = 131073;
			long roid = 131075;
			ClientIfcModel model = client.getModel(poid, roid, true);
			
			for (IfcPropertySingleValue prop : model.getAll(IfcPropertySingleValue.class)) {
				IfcValue value = ((IfcPropertySingleValue) prop).getNominalValue();
				if(value instanceof IfcLabel){
					System.out.println(prop.getOid() + " is " + ((IfcLabel) value).getWrappedValue() );
		    	   ((IfcLabel) value).setWrappedValue(((IfcLabel) value).getWrappedValue() + " changed");
				}
			}
			
			model.commit("blaat");
		} catch (ServiceException | ChannelConnectionException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
