/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcProfileDef;
import org.bimserver.models.ifc2x3.IfcSweptAreaSolid;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Swept Area Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptAreaSolidImpl#getSweptArea <em>Swept Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptAreaSolidImpl#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSweptAreaSolidImpl extends IfcSolidModelImpl implements IfcSweptAreaSolid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSweptAreaSolidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSweptAreaSolid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getSweptArea() {
		return (IfcProfileDef)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptAreaSolid_SweptArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSweptArea(IfcProfileDef newSweptArea) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptAreaSolid_SweptArea(), newSweptArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D getPosition() {
		return (IfcAxis2Placement3D)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptAreaSolid_Position(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(IfcAxis2Placement3D newPosition) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptAreaSolid_Position(), newPosition);
	}

} //IfcSweptAreaSolidImpl
