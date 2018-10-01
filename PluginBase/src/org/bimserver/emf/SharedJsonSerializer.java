package org.bimserver.emf;

import java.io.OutputStream;
import java.util.Iterator;

import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.StreamingReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharedJsonSerializer implements StreamingReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(SharedJsonSerializer.class);
	enum Mode {
		HEADER, BODY, FOOTER, DONE
	}

	private static final boolean SERIALIZE_EMPTY_LISTS = false;

	private Mode mode = Mode.HEADER;
	private boolean firstObject = true;
	private Iterator<IdEObject> iterator;

	private IfcModelInterface model;

	private boolean includeHidden;

	private EmfJsonSerializer emfJsonSerializer;

	public SharedJsonSerializer(IfcModelInterface model, boolean includeHidden) {
		this.model = model;
		this.includeHidden = includeHidden;
	}

	public boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		if (this.emfJsonSerializer == null) {
			this.emfJsonSerializer = new EmfJsonSerializer(outputStream, includeHidden, SERIALIZE_EMPTY_LISTS);
		}
		try {
			if (mode == Mode.HEADER) {
				this.emfJsonSerializer.print("{");
				IfcHeader ifcHeader = model.getModelMetaData().getIfcHeader();
				if (ifcHeader != null) {
					this.emfJsonSerializer.print("\"header\":");
					this.emfJsonSerializer.writeObject(ifcHeader);
					this.emfJsonSerializer.print("\n,");
				}
				this.emfJsonSerializer.print("\"objects\":[");
				mode = Mode.BODY;
				iterator = model.iterator();
				return true;
			} else if (mode == Mode.BODY) {
				if (iterator.hasNext()) {
					IdEObject object = iterator.next();
					if (object.getOid() == -1) {
						throw new SerializerException("Object cannot have oid -1 " + object.eClass().getName());
					}
					if (object.eClass().getEAnnotation("hidden") == null || includeHidden) {
						if (!firstObject) {
							this.emfJsonSerializer.print(",");
						} else {
							firstObject = false;
						}
						this.emfJsonSerializer.writeObject(object);
					}
					return true;
				} else {
					this.emfJsonSerializer.print("]");
					this.emfJsonSerializer.print("}");
					mode = Mode.FOOTER;
					return true;
				}
			} else if (mode == Mode.FOOTER) {
				mode = Mode.DONE;
				return false;
			}
		} catch (Throwable e) {
			throw new SerializerException(e);
		}
		return false;
	}

	@Override
	public boolean write(OutputStream out) {
		try {
			return write(out, null);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
		return false;
	}
}