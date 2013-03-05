package org.bimserver.serializers;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.bimserver.emf.Delegate;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.ifc.IfcSerializer;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.base.Charsets;

public class JsonSerializer extends IfcSerializer {

	enum Mode {
		HEADER, BODY, FOOTER, DONE
	}
	
	private boolean serializerEmptyLists = false;

	private UTF8PrintWriter out;
	private Mode mode = Mode.HEADER;
	private boolean firstObject = true;
	private Iterator<IdEObject> iterator;

	@Override
	public void reset() {
	}

	@Override
	protected boolean write(OutputStream outputStream) throws SerializerException {
		try {
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
					if (!firstObject) {
						out.write(",");
					} else {
						firstObject = false;
					}
					if (((IdEObjectImpl) object).getLoadingState() != Delegate.State.LOADED) {
						out.write("{");
						out.write("\"__oid\":" + object.getOid() + ",");
						out.write("\"__type\":\"" + object.eClass().getName() + "\",");
						out.write("\"__state\":\"NOT_LOADED\"");
						out.write("}");
					} else {
						out.write("{");
						out.write("\"__oid\":" + object.getOid() + ",");
						out.write("\"__type\":\"" + object.eClass().getName() + "\",");
						out.write("\"__state\":\"LOADED\",");
						boolean firstF = true;
						for (EStructuralFeature eStructuralFeature : object.eClass().getEAllStructuralFeatures()) {
		//						if (eStructuralFeature.getEAnnotation("hidden") == null) {
								if (eStructuralFeature instanceof EReference) {
									Object value = object.eGet(eStructuralFeature);
									if (value != null) {
										if (eStructuralFeature.isMany()) {
											List<?> list = (List<?>) value;
											if (serializerEmptyLists || !list.isEmpty()) {
												if (firstF) {
													firstF = false;
												} else {
													out.write(",");
												}
												boolean isWrapped = false;
												for (Object o : list) {
													if (((IdEObject)o).eClass().getEAnnotation("wrapped") != null) {
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
											}
										} else {
											if (firstF) {
												firstF = false;
											} else {
												out.write(",");
											}
											IdEObject ref = (IdEObject) value;
											if (ref instanceof IfcGloballyUniqueId) {
												out.write("\"" + eStructuralFeature.getName() + "\":");
												writePrimitive(out, eStructuralFeature, ((IfcGloballyUniqueId)ref).getWrappedValue());
											} else if (((IdEObject)ref).eClass().getEAnnotation("wrapped") != null) {
												out.write("\"__emb" + eStructuralFeature.getName() + "\":");
												writeObject(out, ref);
											} else {
												out.write("\"__ref" + eStructuralFeature.getName() + "\":" + ref.getOid());
											}
										}
									}
								} else {
									Object value = object.eGet(eStructuralFeature);
									if (value != null) {
										if (eStructuralFeature.isMany()) {
											List<?> list = (List<?>) value;
											if (serializerEmptyLists || !list.isEmpty()) {
												if (firstF) {
													firstF = false;
												} else {
													out.write(",");
												}
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
											}
										} else {
											if (firstF) {
												firstF = false;
											} else {
												out.write(",");
											}
											out.write("\"" + eStructuralFeature.getName() + "\":");
											writePrimitive(out, eStructuralFeature, value);
										}
									}
								}
		//						}
						}
						out.write("}");
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
		} catch (Throwable e) {
			throw new SerializerException(e);
		}
		return false;
	}

	private void writeObject(UTF8PrintWriter out, IdEObject object) {
		if (object.eClass().getEAnnotation("wrapped") != null) {
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
		if (value instanceof String) {
			out.write(JSONObject.quote((String)value));
		} else if (value instanceof byte[]) {
			out.write("\"" + new String(Base64.encodeBase64((byte[])value), Charsets.UTF_8) + "\"");
		} else if (value instanceof Enum) {
			 if (value.toString().equalsIgnoreCase("true") || value.toString().equalsIgnoreCase("false")) {
				 out.write(value.toString().toLowerCase());
			 } else {
				out.write("\"" + value + "\"");
			 }
		} else {
			out.write("" + value);
		}
	}
}