package org.bimserver.client;

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

import java.util.Collection;
import java.util.List;

import org.bimserver.client.ClientIfcModel.ModelState;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EDelegatingList<E> extends AbstractEList<E> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EDelegatingList.class);
	private AbstractEList<E> delegate;
	private ClientIfcModel model;
	private IdEObject subject;
	private EStructuralFeature feature;

	public EDelegatingList(ClientIfcModel model, IdEObject subject, EStructuralFeature feature, AbstractEList<E> delegate) {
		this.model = model;
		this.subject = subject;
		this.feature = feature;
		this.delegate = delegate;
	}

	@Override
	public boolean add(E newValue) {
		if (model.getModelState() != ModelState.LOADING) {
			try {
				if (newValue instanceof String) {
					model.getBimServerClient().getLowLevelInterface().addStringAttribute(model.getTransactionId(), subject.getOid(), feature.getName(), (String) newValue);
				} else if (newValue instanceof Double) {
					model.getBimServerClient().getLowLevelInterface().addDoubleAttribute(model.getTransactionId(), subject.getOid(), feature.getName(), (Double) newValue);
				} else if (newValue instanceof Boolean) {
					model.getBimServerClient().getLowLevelInterface().addBooleanAttribute(model.getTransactionId(), subject.getOid(), feature.getName(), (Boolean) newValue);
				} else if (newValue instanceof Integer) {
					model.getBimServerClient().getLowLevelInterface().addIntegerAttribute(model.getTransactionId(), subject.getOid(), feature.getName(), (Integer) newValue);
				} else if (newValue instanceof IdEObject) {
					model.getBimServerClient().getLowLevelInterface()
							.addReference(model.getTransactionId(), subject.getOid(), feature.getName(), ((IdEObject) newValue).getOid());
				} else {
					throw new RuntimeException("Unimplemented " + feature.getEType().getName() + " " + newValue);
				}
			} catch (ServerException e) {
				LOGGER.error("", e);
			} catch (UserException e) {
				LOGGER.error("", e);
			} catch (PublicInterfaceNotFoundException e) {
				LOGGER.error("", e);
			}
		}
		return super.add(newValue);
	}

	@Override
	public E setUnique(int index, E newValue) {
		if (model.getModelState() != ModelState.LOADING) {
			try {
				if (newValue instanceof String) {
					model.getBimServerClient().getLowLevelInterface().setStringAttributeAtIndex(model.getTransactionId(), subject.getOid(), feature.getName(), index, (String) newValue);
				} else if (newValue instanceof Double) {
					model.getBimServerClient().getLowLevelInterface().setDoubleAttributeAtIndex(model.getTransactionId(), subject.getOid(), feature.getName(), index, (Double) newValue);
				} else if (newValue instanceof Boolean) {
					model.getBimServerClient().getLowLevelInterface().setBooleanAttributeAtIndex(model.getTransactionId(), subject.getOid(), feature.getName(), index, (Boolean) newValue);
				} else if (newValue instanceof Integer) {
					model.getBimServerClient().getLowLevelInterface().setIntegerAttributeAtIndex(model.getTransactionId(), subject.getOid(), feature.getName(), index, (Integer) newValue);
				} else if (newValue instanceof IdEObject) {
					model.getBimServerClient().getLowLevelInterface()
							.addReference(model.getTransactionId(), subject.getOid(), feature.getName(), ((IdEObject) newValue).getOid());
				} else {
					throw new RuntimeException("Unimplemented " + feature.getEType().getName() + " " + newValue);
				}
			} catch (ServerException e) {
				LOGGER.error("", e);
			} catch (UserException e) {
				LOGGER.error("", e);
			} catch (PublicInterfaceNotFoundException e) {
				LOGGER.error("", e);
			}
		}
		return delegate.setUnique(index, newValue);
	}

	@Override
	public void addUnique(E object) {
		delegate.addUnique(object);
	}

	@Override
	public void addUnique(int index, E object) {
		delegate.addUnique(index, object);
	}

	@Override
	public boolean addAllUnique(Collection<? extends E> collection) {
		return delegate.addAllUnique(collection);
	}

	@Override
	public boolean addAllUnique(int index, Collection<? extends E> collection) {
		return delegate.addAllUnique(index, collection);
	}

	@Override
	public boolean addAllUnique(Object[] objects, int start, int end) {
		return delegate.addAllUnique(objects, start, end);
	}

	@Override
	public boolean addAllUnique(int index, Object[] objects, int start, int end) {
		return delegate.addAllUnique(index, objects, start, end);
	}

	@Override
	public E remove(int index) {
		return delegate.remove(index);
	}

	@Override
	public E move(int targetIndex, int sourceIndex) {
		return delegate.move(targetIndex, sourceIndex);
	}

	@Override
	protected List<E> basicList() {
		return delegate;
	}

	@Override
	public E get(int index) {
		return delegate.get(index);
	}

	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	protected E primitiveGet(int index) {
		return null;
	}
}