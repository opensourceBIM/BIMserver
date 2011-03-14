/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPropertyEnumeratedValue;
import org.bimserver.models.ifc2x3.IfcPropertyEnumeration;
import org.bimserver.models.ifc2x3.IfcValue;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Enumerated Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyEnumeratedValueImpl#getEnumerationValues <em>Enumeration Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyEnumeratedValueImpl#getEnumerationReference <em>Enumeration Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPropertyEnumeratedValueImpl extends IfcSimplePropertyImpl implements IfcPropertyEnumeratedValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyEnumeratedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPropertyEnumeratedValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getEnumerationValues() {
		return (EList<IfcValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyEnumeratedValue_EnumerationValues(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyEnumeration getEnumerationReference() {
		return (IfcPropertyEnumeration)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyEnumeratedValue_EnumerationReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumerationReference(IfcPropertyEnumeration newEnumerationReference) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyEnumeratedValue_EnumerationReference(), newEnumerationReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEnumerationReference() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyEnumeratedValue_EnumerationReference());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEnumerationReference() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyEnumeratedValue_EnumerationReference());
	}

} //IfcPropertyEnumeratedValueImpl
