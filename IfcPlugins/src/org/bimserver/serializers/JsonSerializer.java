package org.bimserver.serializers;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.bimserver.emf.Delegate;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.ifc.IfcSerializer;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class JsonSerializer extends IfcSerializer {

	enum Mode {
		HEADER, BODY, FOOTER, DONE
	}

	private UTF8PrintWriter out;
	private Mode mode = Mode.HEADER;
	private boolean firstObject = true;
	private Iterator<IdEObject> iterator;

	@Override
	public void reset() {
	}

	@Override
	protected boolean write(OutputStream outputStream) throws SerializerException {
		if (out == null) {
			out = new UTF8PrintWriter(outputStream);
		}
		if (mode == Mode.HEADER) {
			out.write("{");
			out.write("\"objects\":[");
			mode = Mode.BODY;
			iterator = getModel().iterator();
			return true;
		} else if (mode == Mode.BODY) {
			if (iterator.hasNext()) {
				IdEObject object = iterator.next();
				if (((IdEObjectImpl) object).getLoadingState() == Delegate.State.LOADED) {
					if (object.eClass().getEAnnotation("hidden") == null) {
						if (!firstObject) {
							out.write(",");
						} else {
							firstObject = false;
						}
						out.write("{");
						out.write("\"oid\":\"" + object.getOid() + "\",");
						out.write("\"__type\":\"" + object.eClass().getName() + "\",");
						boolean firstF = true;
						for (EStructuralFeature eStructuralFeature : object.eClass().getEAllStructuralFeatures()) {
							if (eStructuralFeature.getEAnnotation("hidden") == null) {
								if (eStructuralFeature instanceof EReference) {
									Object value = object.eGet(eStructuralFeature);
									if (value != null) {
										if (firstF) {
											firstF = false;
										} else {
											out.write(",");
										}
										if (eStructuralFeature.isMany()) {
											List<?> list = (List<?>) value;
											boolean isWrapped = false;
											for (Object o : list) {
												if (Ifc2x3tc1Package.eINSTANCE.getWrappedValue().isSuperTypeOf(((IdEObject)o).eClass())) {
													// A little tricky, can we assume if one object in this list is embedded, they all are?
													isWrapped = true;
													break;
												}
											}
											if (isWrapped) {
												out.write("\"__emb" + eStructuralFeature.getName() + "\":[");
											} else {
												out.write("\"__ref" + eStructuralFeature.getName() + "\":[");
											}
											boolean f = true;
											for (Object o : list) {
												if (!f) {
													out.write(",");
												} else {
													f = false;
												}
												IdEObject ref = (IdEObject) o;
												if (ref.getOid() == -1) {
													writeObject(out, ref);
												} else {
													out.write("" + ref.getOid());
												}
											}
											out.write("]");
										} else {
											IdEObject ref = (IdEObject) value;
											if (ref instanceof IfcGloballyUniqueId) {
												out.write("\"" + eStructuralFeature.getName() + "\":");
												writePrimitive(out, eStructuralFeature, ((IfcGloballyUniqueId)ref).getWrappedValue());
											} else {
												out.write("\"__ref" + eStructuralFeature.getName() + "\":" + ref.getOid());
											}
										}
									}
								} else {
									Object value = object.eGet(eStructuralFeature);
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
												writePrimitive(out, eStructuralFeature, o);
											}
											out.write("]");
										} else {
											out.write("\"" + eStructuralFeature.getName() + "\":");
											writePrimitive(out, eStructuralFeature, value);
										}
									}
								}
							}
						}
						out.write("}");
					}
				}
				return true;
			} else {
				mode = Mode.FOOTER;
				return true;
			}
		} else if (mode == Mode.FOOTER) {
			out.write("]");
			out.write("}");
			out.flush();
			mode = Mode.DONE;
			return false;
		}
		return false;
	}

	private void writeObject(UTF8PrintWriter out, IdEObject object) {
		if (Ifc2x3tc1Package.eINSTANCE.getWrappedValue().isSuperTypeOf(object.eClass())) {
			EStructuralFeature wrappedFeature = object.eClass().getEStructuralFeature("wrappedValue");
			out.write("{");
			out.write("\"__type\":\"" + object.eClass().getName() + "\",");
			out.write("\"value\":");
			writePrimitive(out, wrappedFeature, object.eGet(wrappedFeature));
			out.write("}");
		} else {
			out.write("" + object.getOid());
		}
	}

	private void writePrimitive(PrintWriter out, EStructuralFeature feature, Object value) {
		if (value instanceof String || value instanceof Enum) {
			out.write("\"" + value + "\"");
		} else {
			out.write("" + value);
		}
	}
}