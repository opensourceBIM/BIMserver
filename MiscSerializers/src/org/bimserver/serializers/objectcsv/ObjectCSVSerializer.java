package org.bimserver.serializers.objectcsv;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcQuantityArea;
import org.bimserver.models.ifc2x3tc1.IfcQuantityCount;
import org.bimserver.models.ifc2x3tc1.IfcQuantityLength;
import org.bimserver.models.ifc2x3tc1.IfcQuantityTime;
import org.bimserver.models.ifc2x3tc1.IfcQuantityVolume;
import org.bimserver.models.ifc2x3tc1.IfcQuantityWeight;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.impl.IfcObjectImpl;
import org.bimserver.models.ifc2x3tc1.impl.IfcRootImpl;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ObjectCSVSerializer extends EmfSerializer {

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		if (getMode() == Mode.BODY) {
			PrintWriter out = new PrintWriter(outputStream);
			out.println("GUID; Enitity; Attribute; Attibute Value; Property Set | Quantity; Property | Quantity; Value");
			for (IdEObject eObject : model.getObjects().values()) {
				if (eObject.eClass().getEAnnotation("hidden") == null) {
//					writeTable(out, eObject);
					String GUID="";
					if (eObject instanceof IfcObjectImpl && (eObject instanceof IfcPropertySet)==false && (eObject instanceof IfcPropertySingleValue)==false  )
					{	GUID=((IfcRootImpl)eObject).getGlobalId();
						for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
							Object eGet = eObject.eGet(eStructuralFeature);
							if (eStructuralFeature instanceof EAttribute && !eStructuralFeature.getName().endsWith("AsString")) {
								out.print(GUID+ "; "+eObject.eClass().getName()+";");
								
								if (eStructuralFeature.getUpperBound() == 1) {
									out.println(eStructuralFeature.getName() +";" +eGet + ";;;;");
								} else {
									List<Object> list = (List<Object>) eGet;
									
									for (Object object : list) {
										out.println(object + ",  ");
									}
									
								}
							}
							 else if (eStructuralFeature instanceof EReference) {
									if (eStructuralFeature.getUpperBound() == 1) {
										if (eStructuralFeature.getEType().getEAnnotation("wrapped") != null) {
											EObject value = (EObject) eGet;
											if (value != null) {
												out.print(value.eGet(value.eClass().getEStructuralFeature("wrappedValue")) );
											}
										} else {
											
										}
									} else {
										if (eStructuralFeature.getEType().getEAnnotation("wrapped") != null) {
											List<EObject> list = (List<EObject>) eGet;
											
											for (EObject object : list) {
												out.println( object.eGet(object.eClass().getEStructuralFeature("wrappedValue")) );
											}
											
										} else {
											
										}
									}
								}
						}
						IfcObject ob = (IfcObject)eObject;
						for (IfcRelDefines def : ob.getIsDefinedBy())
						{
//							System.out.println(def.getName());
							if (def instanceof IfcRelDefinesByProperties)
							{
								
								IfcPropertySetDefinition propSet = (IfcPropertySetDefinition)((IfcRelDefinesByProperties)def).getRelatingPropertyDefinition() ;
								if (propSet instanceof IfcPropertySet){
									for (IfcProperty prop:((IfcPropertySet)propSet).getHasProperties())
									{

										if (prop instanceof IfcPropertySingleValue){
											IfcValue val = ((IfcPropertySingleValue)prop).getNominalValue();
											Object eGet = val.eGet(val.eClass().getEStructuralFeature("wrappedValue"));
											out.println(ob.getGlobalId()+";"+ob.eClass().getName()+"; ; ;"+propSet.getName()+"; "+prop.getName()+";"+ eGet.toString());
										}
									}
								}
								else if (propSet instanceof IfcElementQuantity){
									for (IfcPhysicalQuantity quantity:((IfcElementQuantity)propSet).getQuantities())
									{

										String strValue = "";
										
										if (quantity instanceof IfcQuantityLength)
											strValue = ((IfcQuantityLength)quantity).getLengthValueAsString();
										if (quantity instanceof IfcQuantityArea)
											strValue = ((IfcQuantityArea)quantity).getAreaValueAsString();
										if (quantity instanceof IfcQuantityVolume)
											strValue = ((IfcQuantityVolume)quantity).getVolumeValueAsString();
										if (quantity instanceof  IfcQuantityCount)
											strValue = (( IfcQuantityCount)quantity).getCountValueAsString();
										if (quantity instanceof  IfcQuantityWeight)
											strValue = (( IfcQuantityWeight)quantity).getWeightValueAsString();
										if (quantity instanceof IfcQuantityTime)
											strValue = ((IfcQuantityTime)quantity).getTimeValueAsString();
										
//										Object eGet = val.eGet(val.eClass().getEStructuralFeature("wrappedValue"));
										out.println(ob.getGlobalId()+";"+ob.eClass().getName()+"; ; ;"+propSet.getName()+"; "+quantity.getName()+";"+ strValue);
									}
									
								}
								
							}
							
							
						}
						
					}
					
				}
			}
			
			
			
			out.flush();
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	
}