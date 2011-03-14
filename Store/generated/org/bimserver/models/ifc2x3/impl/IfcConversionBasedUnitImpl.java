/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConversionBasedUnit;
import org.bimserver.models.ifc2x3.IfcMeasureWithUnit;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Conversion Based Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConversionBasedUnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConversionBasedUnitImpl#getConversionFactor <em>Conversion Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConversionBasedUnitImpl extends IfcNamedUnitImpl implements IfcConversionBasedUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConversionBasedUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcConversionBasedUnit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConversionBasedUnit_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConversionBasedUnit_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureWithUnit getConversionFactor() {
		return (IfcMeasureWithUnit)eGet(Ifc2x3Package.eINSTANCE.getIfcConversionBasedUnit_ConversionFactor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConversionFactor(IfcMeasureWithUnit newConversionFactor) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConversionBasedUnit_ConversionFactor(), newConversionFactor);
	}

} //IfcConversionBasedUnitImpl
