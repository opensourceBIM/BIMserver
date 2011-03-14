/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcSIPrefix;
import org.bimserver.models.ifc2x3.IfcSIUnit;
import org.bimserver.models.ifc2x3.IfcSIUnitName;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc SI Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSIUnitImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSIUnitImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSIUnitImpl extends IfcNamedUnitImpl implements IfcSIUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSIUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSIUnit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSIPrefix getPrefix() {
		return (IfcSIPrefix)eGet(Ifc2x3Package.eINSTANCE.getIfcSIUnit_Prefix(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefix(IfcSIPrefix newPrefix) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSIUnit_Prefix(), newPrefix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSIUnitName getName() {
		return (IfcSIUnitName)eGet(Ifc2x3Package.eINSTANCE.getIfcSIUnit_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(IfcSIUnitName newName) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSIUnit_Name(), newName);
	}

} //IfcSIUnitImpl
