/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDerivedUnit;
import org.bimserver.models.ifc2x3.IfcDerivedUnitElement;
import org.bimserver.models.ifc2x3.IfcDerivedUnitEnum;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Derived Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDerivedUnitImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDerivedUnitImpl#getUnitType <em>Unit Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDerivedUnitImpl#getUserDefinedType <em>User Defined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDerivedUnitImpl extends IdEObjectImpl implements IfcDerivedUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDerivedUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDerivedUnit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDerivedUnitElement> getElements() {
		return (EList<IfcDerivedUnitElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_Elements(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedUnitEnum getUnitType() {
		return (IfcDerivedUnitEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UnitType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitType(IfcDerivedUnitEnum newUnitType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UnitType(), newUnitType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedType() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UserDefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedType(String newUserDefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UserDefinedType(), newUserDefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedType() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UserDefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedType() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDerivedUnit_UserDefinedType());
	}

} //IfcDerivedUnitImpl
