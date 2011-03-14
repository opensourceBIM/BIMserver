/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcActorSelect;
import org.bimserver.models.ifc2x3.IfcConstructionMaterialResource;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Construction Material Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionMaterialResourceImpl#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionMaterialResourceImpl#getUsageRatio <em>Usage Ratio</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionMaterialResourceImpl#getUsageRatioAsString <em>Usage Ratio As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConstructionMaterialResourceImpl extends IfcConstructionResourceImpl implements IfcConstructionMaterialResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstructionMaterialResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorSelect> getSuppliers() {
		return (EList<IfcActorSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_Suppliers(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuppliers() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_Suppliers());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuppliers() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_Suppliers());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUsageRatio() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatio(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageRatio(float newUsageRatio) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatio(), newUsageRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsageRatio() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsageRatio() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsageRatioAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatioAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageRatioAsString(String newUsageRatioAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatioAsString(), newUsageRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsageRatioAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatioAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsageRatioAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatioAsString());
	}

} //IfcConstructionMaterialResourceImpl
