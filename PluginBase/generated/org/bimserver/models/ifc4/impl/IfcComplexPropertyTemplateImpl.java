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
import org.bimserver.models.ifc4.IfcComplexPropertyTemplateTypeEnum;
import org.bimserver.models.ifc4.IfcPropertyTemplate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Complex Property Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcComplexPropertyTemplateImpl#getUsageName <em>Usage Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcComplexPropertyTemplateImpl#getTemplateType <em>Template Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcComplexPropertyTemplateImpl#getHasPropertyTemplates <em>Has Property Templates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcComplexPropertyTemplateImpl extends IfcPropertyTemplateImpl implements IfcComplexPropertyTemplate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcComplexPropertyTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUsageName() {
		return (String) eGet(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__USAGE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsageName(String newUsageName) {
		eSet(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__USAGE_NAME, newUsageName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUsageName() {
		eUnset(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__USAGE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUsageName() {
		return eIsSet(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__USAGE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcComplexPropertyTemplateTypeEnum getTemplateType() {
		return (IfcComplexPropertyTemplateTypeEnum) eGet(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__TEMPLATE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTemplateType(IfcComplexPropertyTemplateTypeEnum newTemplateType) {
		eSet(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__TEMPLATE_TYPE, newTemplateType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTemplateType() {
		eUnset(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__TEMPLATE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTemplateType() {
		return eIsSet(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__TEMPLATE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPropertyTemplate> getHasPropertyTemplates() {
		return (EList<IfcPropertyTemplate>) eGet(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__HAS_PROPERTY_TEMPLATES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasPropertyTemplates() {
		eUnset(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__HAS_PROPERTY_TEMPLATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasPropertyTemplates() {
		return eIsSet(Ifc4Package.Literals.IFC_COMPLEX_PROPERTY_TEMPLATE__HAS_PROPERTY_TEMPLATES);
	}

} //IfcComplexPropertyTemplateImpl
