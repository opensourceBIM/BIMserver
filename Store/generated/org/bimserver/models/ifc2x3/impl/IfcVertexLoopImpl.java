/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcVertex;
import org.bimserver.models.ifc2x3.IfcVertexLoop;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Vertex Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVertexLoopImpl#getLoopVertex <em>Loop Vertex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcVertexLoopImpl extends IfcLoopImpl implements IfcVertexLoop {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcVertexLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcVertexLoop();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertex getLoopVertex() {
		return (IfcVertex)eGet(Ifc2x3Package.eINSTANCE.getIfcVertexLoop_LoopVertex(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopVertex(IfcVertex newLoopVertex) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcVertexLoop_LoopVertex(), newLoopVertex);
	}

} //IfcVertexLoopImpl
