/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEnvironmentalImpactCategoryEnum;
import org.bimserver.models.ifc2x3.IfcEnvironmentalImpactValue;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Environmental Impact Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEnvironmentalImpactValueImpl#getImpactType <em>Impact Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEnvironmentalImpactValueImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEnvironmentalImpactValueImpl#getUserDefinedCategory <em>User Defined Category</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEnvironmentalImpactValueImpl extends IfcAppliedValueImpl implements IfcEnvironmentalImpactValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEnvironmentalImpactValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImpactType() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue_ImpactType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpactType(String newImpactType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue_ImpactType(), newImpactType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnvironmentalImpactCategoryEnum getCategory() {
		return (IfcEnvironmentalImpactCategoryEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue_Category(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(IfcEnvironmentalImpactCategoryEnum newCategory) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue_Category(), newCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedCategory() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue_UserDefinedCategory(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedCategory(String newUserDefinedCategory) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue_UserDefinedCategory(), newUserDefinedCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedCategory() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue_UserDefinedCategory());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedCategory() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcEnvironmentalImpactValue_UserDefinedCategory());
	}

} //IfcEnvironmentalImpactValueImpl
