package org.bimserver.shared;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ByteBufferWrappedVirtualObject extends AbstractByteBufferVirtualObject implements WrappedVirtualObject {

	private EClass eClass;

	public ByteBufferWrappedVirtualObject(Reusable reusable, EClass eClass) {
		super(10);
		this.eClass = eClass;
		buffer.putShort((short) -reusable.getDatabaseInterface().getCidOfEClass(eClass));
	}

	@Override
	public EClass eClass() {
		return eClass;
	}

	@Override
	public void setAttribute(EStructuralFeature eStructuralFeature, Object value) throws BimserverDatabaseException {
		writePrimitiveValue(eStructuralFeature, value);
	}

	public ByteBuffer write() throws BimserverDatabaseException {
		return buffer;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}
}