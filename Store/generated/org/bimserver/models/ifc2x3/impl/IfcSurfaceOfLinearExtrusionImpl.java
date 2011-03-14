/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDirection;
import org.bimserver.models.ifc2x3.IfcSurfaceOfLinearExtrusion;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Of Linear Extrusion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceOfLinearExtrusionImpl#getExtrudedDirection <em>Extruded Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceOfLinearExtrusionImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceOfLinearExtrusionImpl#getDepthAsString <em>Depth As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSurfaceOfLinearExtrusionImpl extends IfcSweptSurfaceImpl implements IfcSurfaceOfLinearExtrusion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceOfLinearExtrusionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSurfaceOfLinearExtrusion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getExtrudedDirection() {
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceOfLinearExtrusion_ExtrudedDirection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtrudedDirection(IfcDirection newExtrudedDirection) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceOfLinearExtrusion_ExtrudedDirection(), newExtrudedDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDepth() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceOfLinearExtrusion_Depth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepth(float newDepth) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceOfLinearExtrusion_Depth(), newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceOfLinearExtrusion_DepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepthAsString(String newDepthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceOfLinearExtrusion_DepthAsString(), newDepthAsString);
	}

} //IfcSurfaceOfLinearExtrusionImpl
