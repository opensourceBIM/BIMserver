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
import org.bimserver.models.ifc4.IfcPropertySetDefinition;
import org.bimserver.models.ifc4.IfcPropertySetTemplate;
import org.bimserver.models.ifc4.IfcRelDefinesByTemplate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Defines By Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelDefinesByTemplateImpl#getRelatedPropertySets <em>Related Property Sets</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelDefinesByTemplateImpl#getRelatingTemplate <em>Relating Template</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelDefinesByTemplateImpl extends IfcRelDefinesImpl implements IfcRelDefinesByTemplate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelDefinesByTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_DEFINES_BY_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPropertySetDefinition> getRelatedPropertySets() {
		return (EList<IfcPropertySetDefinition>) eGet(Ifc4Package.Literals.IFC_REL_DEFINES_BY_TEMPLATE__RELATED_PROPERTY_SETS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertySetTemplate getRelatingTemplate() {
		return (IfcPropertySetTemplate) eGet(Ifc4Package.Literals.IFC_REL_DEFINES_BY_TEMPLATE__RELATING_TEMPLATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingTemplate(IfcPropertySetTemplate newRelatingTemplate) {
		eSet(Ifc4Package.Literals.IFC_REL_DEFINES_BY_TEMPLATE__RELATING_TEMPLATE, newRelatingTemplate);
	}

} //IfcRelDefinesByTemplateImpl
