/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcReinforcingElement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcing Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingElementImpl#getSteelGrade <em>Steel Grade</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcReinforcingElementImpl extends IfcBuildingElementComponentImpl implements IfcReinforcingElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReinforcingElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcReinforcingElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSteelGrade() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingElement_SteelGrade(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteelGrade(String newSteelGrade) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingElement_SteelGrade(), newSteelGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSteelGrade() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcReinforcingElement_SteelGrade());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSteelGrade() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingElement_SteelGrade());
	}

} //IfcReinforcingElementImpl
