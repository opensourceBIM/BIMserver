package org.bimserver.client;

import java.util.Collection;
import java.util.List;

import org.bimserver.client.ClientIfcModel.ModelState;
import org.bimserver.emf.IdEObject;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EDelegatingList<E> extends AbstractEList<E> {

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
					model.getBimServerClient().getBimsie1LowLevelInterface().addStringAttribute(model.getTransactionId(), subject.getOid(), feature.getName(), (String) newValue);
				} else if (newValue instanceof Double) {
					model.getBimServerClient().getBimsie1LowLevelInterface().addDoubleAttribute(model.getTransactionId(), subject.getOid(), feature.getName(), (Double) newValue);
				} else if (newValue instanceof Boolean) {
					model.getBimServerClient().getBimsie1LowLevelInterface().addBooleanAttribute(model.getTransactionId(), subject.getOid(), feature.getName(), (Boolean) newValue);
				} else if (newValue instanceof Integer) {
					model.getBimServerClient().getBimsie1LowLevelInterface().addIntegerAttribute(model.getTransactionId(), subject.getOid(), feature.getName(), (Integer) newValue);
				} else if (newValue instanceof IdEObject) {
					model.getBimServerClient().getBimsie1LowLevelInterface()
							.addReference(model.getTransactionId(), subject.getOid(), feature.getName(), ((IdEObject) newValue).getOid());
				} else {
					throw new RuntimeException("Unimplemented " + feature.getEType().getName() + " " + newValue);
				}
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			} catch (PublicInterfaceNotFoundException e) {
				e.printStackTrace();
			}
		}
		return super.add(newValue);
	}

	@Override
	public E setUnique(int index, E newValue) {
		if (model.getModelState() != ModelState.LOADING) {
			try {
				if (newValue instanceof String) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setStringAttributeAtIndex(model.getTransactionId(), subject.getOid(), feature.getName(), index, (String) newValue);
				} else if (newValue instanceof Double) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setDoubleAttributeAtIndex(model.getTransactionId(), subject.getOid(), feature.getName(), index, (Double) newValue);
				} else if (newValue instanceof Boolean) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setBooleanAttributeAtIndex(model.getTransactionId(), subject.getOid(), feature.getName(), index, (Boolean) newValue);
				} else if (newValue instanceof Integer) {
					model.getBimServerClient().getBimsie1LowLevelInterface().setIntegerAttributeAtIndex(model.getTransactionId(), subject.getOid(), feature.getName(), index, (Integer) newValue);
				} else if (newValue instanceof IdEObject) {
					model.getBimServerClient().getBimsie1LowLevelInterface()
							.addReference(model.getTransactionId(), subject.getOid(), feature.getName(), ((IdEObject) newValue).getOid());
				} else {
					throw new RuntimeException("Unimplemented " + feature.getEType().getName() + " " + newValue);
				}
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			} catch (PublicInterfaceNotFoundException e) {
				e.printStackTrace();
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
		return addAllUnique(collection);
	}

	@Override
	public boolean addAllUnique(int index, Collection<? extends E> collection) {
		return addAllUnique(index, collection);
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