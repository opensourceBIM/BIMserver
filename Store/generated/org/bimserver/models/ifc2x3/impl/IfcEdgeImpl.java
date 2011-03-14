/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEdge;
import org.bimserver.models.ifc2x3.IfcVertex;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeImpl#getEdgeStart <em>Edge Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeImpl#getEdgeEnd <em>Edge End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEdgeImpl extends IfcTopologicalRepresentationItemImpl implements IfcEdge {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcEdge();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertex getEdgeStart() {
		return (IfcVertex)eGet(Ifc2x3Package.eINSTANCE.getIfcEdge_EdgeStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeStart(IfcVertex newEdgeStart) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdge_EdgeStart(), newEdgeStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertex getEdgeEnd() {
		return (IfcVertex)eGet(Ifc2x3Package.eINSTANCE.getIfcEdge_EdgeEnd(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeEnd(IfcVertex newEdgeEnd) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdge_EdgeEnd(), newEdgeEnd);
	}

} //IfcEdgeImpl
