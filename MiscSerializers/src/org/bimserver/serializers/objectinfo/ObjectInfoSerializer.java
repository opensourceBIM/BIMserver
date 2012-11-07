package org.bimserver.serializers.objectinfo;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ObjectInfoSerializer extends EmfSerializer {

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}
	
	@Override
	public boolean write(OutputStream outputStream) throws SerializerException {
		if (getMode() == Mode.BODY) {
			PrintWriter out = new PrintWriter(outputStream);
			EObject mainObject = model.getMainObject();
			if (mainObject != null) {
				writeTable(out, mainObject);
			} else {
				for (EObject eObject : model.getObjects().values()) {
					writeTable(out, eObject);
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

	@SuppressWarnings("unchecked")
	private void writeTable(PrintWriter out, EObject eObject) {
		out.println("<h1>" + eObject.eClass().getName() + "</h1>");
		out.println("<table>");
		for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
			out.println("<tr>");
			out.println("<td>" + eStructuralFeature.getName() + "</td>");
			Object eGet = eObject.eGet(eStructuralFeature);
			if (eStructuralFeature instanceof EAttribute) {
				if (eStructuralFeature.getUpperBound() == 1) {
					out.println("<td>" + eGet + "</td>");
				} else {
					List<Object> list = (List<Object>) eGet;
					out.println("<td>");
					for (Object object : list) {
						out.println(object + " ");
					}
					out.println("</td>");
				}
			} else if (eStructuralFeature instanceof EReference) {
				if (eStructuralFeature.getUpperBound() == 1) {
					if (Ifc2x3tc1Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())
							|| eStructuralFeature.getEType() == Ifc2x3tc1Package.eINSTANCE.getIfcGloballyUniqueId()) {
						EObject value = (EObject) eGet;
						if (value != null) {
							out.println("<td>" + value.eGet(value.eClass().getEStructuralFeature("wrappedValue")) + "</td>");
						}
					} else {
						
					}
				} else {
					if (Ifc2x3tc1Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())
							|| eStructuralFeature.getEType() == Ifc2x3tc1Package.eINSTANCE.getIfcGloballyUniqueId()) {
						List<EObject> list = (List<EObject>) eGet;
						out.println("<td>");
						for (EObject object : list) {
							out.println("<td>" + object.eGet(object.eClass().getEStructuralFeature("wrappedValue")) + "</td>");
						}
						out.println("</td>");
					} else {
						
					}
				}
			}
			out.println("</tr>");
		}
		out.println("</table>");
	}
}