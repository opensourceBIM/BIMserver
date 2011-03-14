/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPoint;
import org.bimserver.models.ifc2x3.IfcVertexPoint;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Vertex Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVertexPointImpl#getVertexGeometry <em>Vertex Geometry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcVertexPointImpl extends IfcVertexImpl implements IfcVertexPoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcVertexPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcVertexPoint();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPoint getVertexGeometry() {
		return (IfcPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcVertexPoint_VertexGeometry(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVertexGeometry(IfcPoint newVertexGeometry) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcVertexPoint_VertexGeometry(), newVertexGeometry);
	}

} //IfcVertexPointImpl
