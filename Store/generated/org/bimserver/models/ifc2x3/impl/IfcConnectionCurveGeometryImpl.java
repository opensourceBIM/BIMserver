/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConnectionCurveGeometry;
import org.bimserver.models.ifc2x3.IfcCurveOrEdgeCurve;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Curve Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionCurveGeometryImpl#getCurveOnRelatingElement <em>Curve On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionCurveGeometryImpl#getCurveOnRelatedElement <em>Curve On Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConnectionCurveGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionCurveGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionCurveGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcConnectionCurveGeometry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveOrEdgeCurve getCurveOnRelatingElement() {
		return (IfcCurveOrEdgeCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionCurveGeometry_CurveOnRelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveOnRelatingElement(IfcCurveOrEdgeCurve newCurveOnRelatingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionCurveGeometry_CurveOnRelatingElement(), newCurveOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveOrEdgeCurve getCurveOnRelatedElement() {
		return (IfcCurveOrEdgeCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionCurveGeometry_CurveOnRelatedElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveOnRelatedElement(IfcCurveOrEdgeCurve newCurveOnRelatedElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionCurveGeometry_CurveOnRelatedElement(), newCurveOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveOnRelatedElement() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionCurveGeometry_CurveOnRelatedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveOnRelatedElement() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionCurveGeometry_CurveOnRelatedElement());
	}

} //IfcConnectionCurveGeometryImpl
