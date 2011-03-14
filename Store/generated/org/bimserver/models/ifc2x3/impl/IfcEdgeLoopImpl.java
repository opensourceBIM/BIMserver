/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEdgeLoop;
import org.bimserver.models.ifc2x3.IfcOrientedEdge;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Edge Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeLoopImpl#getEdgeList <em>Edge List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEdgeLoopImpl extends IfcLoopImpl implements IfcEdgeLoop {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEdgeLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcEdgeLoop();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcOrientedEdge> getEdgeList() {
		return (EList<IfcOrientedEdge>)eGet(Ifc2x3Package.eINSTANCE.getIfcEdgeLoop_EdgeList(), true);
	}

} //IfcEdgeLoopImpl
