/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis2Placement;
import org.bimserver.models.ifc2x3.IfcConnectionPortGeometry;
import org.bimserver.models.ifc2x3.IfcProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Port Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPortGeometryImpl#getLocationAtRelatingElement <em>Location At Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPortGeometryImpl#getLocationAtRelatedElement <em>Location At Related Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPortGeometryImpl#getProfileOfPort <em>Profile Of Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConnectionPortGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionPortGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionPortGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getLocationAtRelatingElement() {
		return (IfcAxis2Placement)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationAtRelatingElement(IfcAxis2Placement newLocationAtRelatingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatingElement(), newLocationAtRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getLocationAtRelatedElement() {
		return (IfcAxis2Placement)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatedElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationAtRelatedElement(IfcAxis2Placement newLocationAtRelatedElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatedElement(), newLocationAtRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLocationAtRelatedElement() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLocationAtRelatedElement() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_LocationAtRelatedElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getProfileOfPort() {
		return (IfcProfileDef)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_ProfileOfPort(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileOfPort(IfcProfileDef newProfileOfPort) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPortGeometry_ProfileOfPort(), newProfileOfPort);
	}

} //IfcConnectionPortGeometryImpl
