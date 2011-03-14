package org.bimserver.serializers;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.bimserver.ifc.BimModelSerializer;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SerializerException;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.shared.ResultType;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ObjectInfoSerializer extends BimModelSerializer {

	private SimpleMode mode = SimpleMode.BUSY;
	
	public ObjectInfoSerializer(Project project, User user, String fileName, IfcModel model, FieldIgnoreMap fieldIgnoreMap) {
		super(fileName, model, fieldIgnoreMap);
	}

	@Override
	public int write(OutputStream outputStream) throws SerializerException {
		if (mode == SimpleMode.BUSY) {
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
			mode = SimpleMode.DONE;
			return 1;
		} else if (mode == SimpleMode.DONE) {
			return -1;
		}
		return -1;
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
					if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())
							|| eStructuralFeature.getEType() == Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId()) {
						EObject value = (EObject) eGet;
						if (value != null) {
							out.println("<td>" + value.eGet(value.eClass().getEStructuralFeature("wrappedValue")) + "</td>");
						}
					} else {
						
					}
				} else {
					if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())
							|| eStructuralFeature.getEType() == Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId()) {
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

	@Override
	public String getContentType() {
		return ResultType.OBJECT_INFO.getContentType();
	}
}