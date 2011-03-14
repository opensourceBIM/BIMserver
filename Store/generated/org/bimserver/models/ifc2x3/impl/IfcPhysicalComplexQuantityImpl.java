/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPhysicalComplexQuantity;
import org.bimserver.models.ifc2x3.IfcPhysicalQuantity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Physical Complex Quantity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPhysicalComplexQuantityImpl#getHasQuantities <em>Has Quantities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPhysicalComplexQuantityImpl#getDiscrimination <em>Discrimination</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPhysicalComplexQuantityImpl#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPhysicalComplexQuantityImpl#getUsage <em>Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPhysicalComplexQuantityImpl extends IfcPhysicalQuantityImpl implements IfcPhysicalComplexQuantity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPhysicalComplexQuantityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPhysicalQuantity> getHasQuantities() {
		return (EList<IfcPhysicalQuantity>)eGet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_HasQuantities(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiscrimination() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Discrimination(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscrimination(String newDiscrimination) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Discrimination(), newDiscrimination);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuality() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Quality(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuality(String newQuality) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Quality(), newQuality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetQuality() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Quality());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetQuality() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Quality());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsage() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Usage(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsage(String newUsage) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Usage(), newUsage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsage() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Usage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsage() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPhysicalComplexQuantity_Usage());
	}

} //IfcPhysicalComplexQuantityImpl
