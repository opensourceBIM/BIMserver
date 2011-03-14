/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConnectionPointGeometry;
import org.bimserver.models.ifc2x3.IfcPointOrVertexPoint;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Point Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPointGeometryImpl#getPointOnRelatingElement <em>Point On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPointGeometryImpl#getPointOnRelatedElement <em>Point On Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConnectionPointGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionPointGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionPointGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcConnectionPointGeometry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPointOrVertexPoint getPointOnRelatingElement() {
		return (IfcPointOrVertexPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointGeometry_PointOnRelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointOnRelatingElement(IfcPointOrVertexPoint newPointOnRelatingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointGeometry_PointOnRelatingElement(), newPointOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPointOrVertexPoint getPointOnRelatedElement() {
		return (IfcPointOrVertexPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointGeometry_PointOnRelatedElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointOnRelatedElement(IfcPointOrVertexPoint newPointOnRelatedElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointGeometry_PointOnRelatedElement(), newPointOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPointOnRelatedElement() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPointGeometry_PointOnRelatedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPointOnRelatedElement() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointGeometry_PointOnRelatedElement());
	}

} //IfcConnectionPointGeometryImpl
