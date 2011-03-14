/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcReinforcementDefinitionProperties;
import org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcement Definition Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcementDefinitionPropertiesImpl#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcementDefinitionPropertiesImpl#getReinforcementSectionDefinitions <em>Reinforcement Section Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcReinforcementDefinitionPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcReinforcementDefinitionProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReinforcementDefinitionPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcReinforcementDefinitionProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefinitionType() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcementDefinitionProperties_DefinitionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitionType(String newDefinitionType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcementDefinitionProperties_DefinitionType(), newDefinitionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefinitionType() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcReinforcementDefinitionProperties_DefinitionType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefinitionType() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcReinforcementDefinitionProperties_DefinitionType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcSectionReinforcementProperties> getReinforcementSectionDefinitions() {
		return (EList<IfcSectionReinforcementProperties>)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcementDefinitionProperties_ReinforcementSectionDefinitions(), true);
	}

} //IfcReinforcementDefinitionPropertiesImpl
