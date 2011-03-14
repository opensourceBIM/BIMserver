/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcComplexProperty;
import org.bimserver.models.ifc2x3.IfcProperty;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Complex Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcComplexPropertyImpl#getUsageName <em>Usage Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcComplexPropertyImpl#getHasProperties <em>Has Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcComplexPropertyImpl extends IfcPropertyImpl implements IfcComplexProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcComplexPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcComplexProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsageName() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcComplexProperty_UsageName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageName(String newUsageName) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcComplexProperty_UsageName(), newUsageName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcProperty> getHasProperties() {
		return (EList<IfcProperty>)eGet(Ifc2x3Package.eINSTANCE.getIfcComplexProperty_HasProperties(), true);
	}

} //IfcComplexPropertyImpl
