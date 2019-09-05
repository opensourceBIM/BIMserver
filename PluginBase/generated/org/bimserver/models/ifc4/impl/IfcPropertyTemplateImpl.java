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
import org.bimserver.models.ifc4.IfcComplexPropertyTemplate;
import org.bimserver.models.ifc4.IfcPropertySetTemplate;
import org.bimserver.models.ifc4.IfcPropertyTemplate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyTemplateImpl#getPartOfComplexTemplate <em>Part Of Complex Template</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyTemplateImpl#getPartOfPsetTemplate <em>Part Of Pset Template</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertyTemplateImpl extends IfcPropertyTemplateDefinitionImpl implements IfcPropertyTemplate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PROPERTY_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcComplexPropertyTemplate> getPartOfComplexTemplate() {
		return (EList<IfcComplexPropertyTemplate>) eGet(Ifc4Package.Literals.IFC_PROPERTY_TEMPLATE__PART_OF_COMPLEX_TEMPLATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartOfComplexTemplate() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_TEMPLATE__PART_OF_COMPLEX_TEMPLATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartOfComplexTemplate() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_TEMPLATE__PART_OF_COMPLEX_TEMPLATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPropertySetTemplate> getPartOfPsetTemplate() {
		return (EList<IfcPropertySetTemplate>) eGet(Ifc4Package.Literals.IFC_PROPERTY_TEMPLATE__PART_OF_PSET_TEMPLATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartOfPsetTemplate() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_TEMPLATE__PART_OF_PSET_TEMPLATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartOfPsetTemplate() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_TEMPLATE__PART_OF_PSET_TEMPLATE);
	}

} //IfcPropertyTemplateImpl
