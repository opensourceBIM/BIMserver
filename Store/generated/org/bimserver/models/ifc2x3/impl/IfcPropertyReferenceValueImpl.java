/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcObjectReferenceSelect;
import org.bimserver.models.ifc2x3.IfcPropertyReferenceValue;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Reference Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyReferenceValueImpl#getUsageName <em>Usage Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyReferenceValueImpl#getPropertyReference <em>Property Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPropertyReferenceValueImpl extends IfcSimplePropertyImpl implements IfcPropertyReferenceValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyReferenceValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsageName() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_UsageName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageName(String newUsageName) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_UsageName(), newUsageName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsageName() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_UsageName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsageName() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_UsageName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectReferenceSelect getPropertyReference() {
		return (IfcObjectReferenceSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_PropertyReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyReference(IfcObjectReferenceSelect newPropertyReference) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyReferenceValue_PropertyReference(), newPropertyReference);
	}

} //IfcPropertyReferenceValueImpl
