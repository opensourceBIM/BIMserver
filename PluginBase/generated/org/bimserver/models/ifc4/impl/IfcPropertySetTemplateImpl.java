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
import org.bimserver.models.ifc4.IfcPropertySetTemplate;
import org.bimserver.models.ifc4.IfcPropertySetTemplateTypeEnum;
import org.bimserver.models.ifc4.IfcPropertyTemplate;
import org.bimserver.models.ifc4.IfcRelDefinesByTemplate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Set Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertySetTemplateImpl#getTemplateType <em>Template Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertySetTemplateImpl#getApplicableEntity <em>Applicable Entity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertySetTemplateImpl#getHasPropertyTemplates <em>Has Property Templates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertySetTemplateImpl#getDefines <em>Defines</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertySetTemplateImpl extends IfcPropertyTemplateDefinitionImpl implements IfcPropertySetTemplate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertySetTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertySetTemplateTypeEnum getTemplateType() {
		return (IfcPropertySetTemplateTypeEnum) eGet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__TEMPLATE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTemplateType(IfcPropertySetTemplateTypeEnum newTemplateType) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__TEMPLATE_TYPE, newTemplateType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTemplateType() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__TEMPLATE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTemplateType() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__TEMPLATE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApplicableEntity() {
		return (String) eGet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__APPLICABLE_ENTITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicableEntity(String newApplicableEntity) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__APPLICABLE_ENTITY, newApplicableEntity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetApplicableEntity() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__APPLICABLE_ENTITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetApplicableEntity() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__APPLICABLE_ENTITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPropertyTemplate> getHasPropertyTemplates() {
		return (EList<IfcPropertyTemplate>) eGet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__HAS_PROPERTY_TEMPLATES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByTemplate> getDefines() {
		return (EList<IfcRelDefinesByTemplate>) eGet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__DEFINES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDefines() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__DEFINES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDefines() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_SET_TEMPLATE__DEFINES);
	}

} //IfcPropertySetTemplateImpl
