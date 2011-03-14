/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEdge;
import org.bimserver.models.ifc2x3.IfcOrientedEdge;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Oriented Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrientedEdgeImpl#getEdgeElement <em>Edge Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrientedEdgeImpl#getOrientation <em>Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcOrientedEdgeImpl extends IfcEdgeImpl implements IfcOrientedEdge {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOrientedEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcOrientedEdge();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEdge getEdgeElement() {
		return (IfcEdge)eGet(Ifc2x3Package.eINSTANCE.getIfcOrientedEdge_EdgeElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeElement(IfcEdge newEdgeElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcOrientedEdge_EdgeElement(), newEdgeElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getOrientation() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcOrientedEdge_Orientation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientation(Tristate newOrientation) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcOrientedEdge_Orientation(), newOrientation);
	}

} //IfcOrientedEdgeImpl
