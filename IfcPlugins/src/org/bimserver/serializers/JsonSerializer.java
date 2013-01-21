package org.bimserver.serializers;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.bimserver.emf.Delegate;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.ifc.IfcSerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class JsonSerializer extends IfcSerializer {

	@Override
	public void reset() {
	}

	@Override
	protected boolean write(OutputStream outputStream) throws SerializerException {
		PrintWriter out = new PrintWriter(outputStream);
		out.write("{");
		out.write("\"objects\":[");
		boolean first = true;
		for (IdEObject idEObject : getModel().getValues()) {
			if (((IdEObjectImpl) idEObject).getLoadingState() == Delegate.State.LOADED) {
				if (idEObject.eClass().getEAnnotation("hidden") == null) {
					if (!first) {
						out.write(",");
					} else {
						first = false;
					}
					out.write("{");
					out.write("\"oid\":\"" + idEObject.getOid() + "\",");
					out.write("\"__type\":\"" + idEObject.eClass().getName() + "\",");
					boolean firstF = true;
					for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
						if (eStructuralFeature.getEAnnotation("hidden") == null) {
							if (eStructuralFeature instanceof EReference) {
								Object value = idEObject.eGet(eStructuralFeature);
								if (value != null) {
									if (firstF) {
										firstF = false;
									} else {
										out.write(",");
									}
									if (eStructuralFeature.isMany()) {
										List<?> list = (List<?>) value;
										out.write("\"__ref" + eStructuralFeature.getName() + "\":[");
										boolean f = true;
										for (Object o : list) {
											if (!f) {
												out.write(",");
											} else {
												f = false;
											}
											IdEObject ref = (IdEObject) o;
											out.write("" + ref.getOid());
										}
										out.write("]");
									} else {
										IdEObject ref = (IdEObject) value;
										out.write("\"__ref" + eStructuralFeature.getName() + "\":" + ref.getOid());
									}
								}
							} else {
								Object value = idEObject.eGet(eStructuralFeature);
								if (value != null) {
									if (firstF) {
										firstF = false;
									} else {
										out.write(",");
									}
									if (eStructuralFeature.isMany()) {
										List<?> list = (List<?>) value;
										out.write("\"" + eStructuralFeature.getName() + "\":[");
										boolean f = true;
										for (Object o : list) {
											if (!f) {
												out.write(",");
											} else {
												f = false;
											}
											writePrimitive(out, o);
										}
										out.write("]");
									} else {
										out.write("\"" + eStructuralFeature.getName() + "\":");
										writePrimitive(out, value);
									}
								}
							}
						}
					}
					out.write("}");
				}
			}
		}
		out.write("]");
		out.write("}");
		out.flush();
		return false;
	}

	private void writePrimitive(PrintWriter out, Object value) {
		if (value instanceof String || value instanceof Enum) {
			out.write("\"" + value + "\"");
		} else {
			out.write("" + value);
		}
	}
}