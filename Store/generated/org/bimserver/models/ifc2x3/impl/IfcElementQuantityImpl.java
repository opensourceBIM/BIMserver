/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcElementQuantity;
import org.bimserver.models.ifc2x3.IfcPhysicalQuantity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Element Quantity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementQuantityImpl#getMethodOfMeasurement <em>Method Of Measurement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcElementQuantityImpl#getQuantities <em>Quantities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcElementQuantityImpl extends IfcPropertySetDefinitionImpl implements IfcElementQuantity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcElementQuantityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcElementQuantity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodOfMeasurement() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcElementQuantity_MethodOfMeasurement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodOfMeasurement(String newMethodOfMeasurement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcElementQuantity_MethodOfMeasurement(), newMethodOfMeasurement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMethodOfMeasurement() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcElementQuantity_MethodOfMeasurement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMethodOfMeasurement() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcElementQuantity_MethodOfMeasurement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPhysicalQuantity> getQuantities() {
		return (EList<IfcPhysicalQuantity>)eGet(Ifc2x3Package.eINSTANCE.getIfcElementQuantity_Quantities(), true);
	}

} //IfcElementQuantityImpl
