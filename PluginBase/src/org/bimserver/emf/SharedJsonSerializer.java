package org.bimserver.emf;

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