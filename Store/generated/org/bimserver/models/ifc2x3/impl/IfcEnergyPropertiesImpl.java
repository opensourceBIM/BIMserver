/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEnergyProperties;
import org.bimserver.models.ifc2x3.IfcEnergySequenceEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Energy Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEnergyPropertiesImpl#getEnergySequence <em>Energy Sequence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEnergyPropertiesImpl#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEnergyPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcEnergyProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEnergyPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcEnergyProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnergySequenceEnum getEnergySequence() {
		return (IfcEnergySequenceEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_EnergySequence(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergySequence(IfcEnergySequenceEnum newEnergySequence) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_EnergySequence(), newEnergySequence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedEnergySequence() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_UserDefinedEnergySequence(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedEnergySequence(String newUserDefinedEnergySequence) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_UserDefinedEnergySequence(), newUserDefinedEnergySequence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedEnergySequence() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_UserDefinedEnergySequence());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedEnergySequence() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_UserDefinedEnergySequence());
	}

} //IfcEnergyPropertiesImpl
