/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis1Placement;
import org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Revolved Area Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRevolvedAreaSolidImpl#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRevolvedAreaSolidImpl#getAngle <em>Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRevolvedAreaSolidImpl#getAngleAsString <em>Angle As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRevolvedAreaSolidImpl extends IfcSweptAreaSolidImpl implements IfcRevolvedAreaSolid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRevolvedAreaSolidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRevolvedAreaSolid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis1Placement getAxis() {
		return (IfcAxis1Placement)eGet(Ifc2x3Package.eINSTANCE.getIfcRevolvedAreaSolid_Axis(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxis(IfcAxis1Placement newAxis) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRevolvedAreaSolid_Axis(), newAxis);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAngle() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRevolvedAreaSolid_Angle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngle(float newAngle) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRevolvedAreaSolid_Angle(), newAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAngleAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRevolvedAreaSolid_AngleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngleAsString(String newAngleAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRevolvedAreaSolid_AngleAsString(), newAngleAsString);
	}

} //IfcRevolvedAreaSolidImpl
