/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcReinforcementDefinitionProperties;
import org.bimserver.models.ifc4.IfcSectionReinforcementProperties;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcement Definition Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementDefinitionPropertiesImpl#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcementDefinitionPropertiesImpl#getReinforcementSectionDefinitions <em>Reinforcement Section Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcReinforcementDefinitionPropertiesImpl extends IfcPreDefinedPropertySetImpl implements IfcReinforcementDefinitionProperties {
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
		return Ifc4Package.Literals.IFC_REINFORCEMENT_DEFINITION_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefinitionType() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_DEFINITION_PROPERTIES__DEFINITION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefinitionType(String newDefinitionType) {
		eSet(Ifc4Package.Literals.IFC_REINFORCEMENT_DEFINITION_PROPERTIES__DEFINITION_TYPE, newDefinitionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDefinitionType() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCEMENT_DEFINITION_PROPERTIES__DEFINITION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDefinitionType() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCEMENT_DEFINITION_PROPERTIES__DEFINITION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcSectionReinforcementProperties> getReinforcementSectionDefinitions() {
		return (EList<IfcSectionReinforcementProperties>) eGet(Ifc4Package.Literals.IFC_REINFORCEMENT_DEFINITION_PROPERTIES__REINFORCEMENT_SECTION_DEFINITIONS, true);
	}

} //IfcReinforcementDefinitionPropertiesImpl
