/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcBoundedCurve;
import org.bimserver.models.ifc2x3.IfcPolygonalBoundedHalfSpace;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Polygonal Bounded Half Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPolygonalBoundedHalfSpaceImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPolygonalBoundedHalfSpaceImpl#getPolygonalBoundary <em>Polygonal Boundary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPolygonalBoundedHalfSpaceImpl extends IfcHalfSpaceSolidImpl implements IfcPolygonalBoundedHalfSpace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPolygonalBoundedHalfSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPolygonalBoundedHalfSpace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D getPosition() {
		return (IfcAxis2Placement3D)eGet(Ifc2x3Package.eINSTANCE.getIfcPolygonalBoundedHalfSpace_Position(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(IfcAxis2Placement3D newPosition) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPolygonalBoundedHalfSpace_Position(), newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundedCurve getPolygonalBoundary() {
		return (IfcBoundedCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcPolygonalBoundedHalfSpace_PolygonalBoundary(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolygonalBoundary(IfcBoundedCurve newPolygonalBoundary) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPolygonalBoundedHalfSpace_PolygonalBoundary(), newPolygonalBoundary);
	}

} //IfcPolygonalBoundedHalfSpaceImpl
