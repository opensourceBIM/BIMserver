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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc4x3.IfcRelDefinesByProperties;
import org.bimserver.models.ifc4x3.IfcRelDefinesByTemplate;
import org.bimserver.models.ifc4x3.IfcTypeObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Set Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertySetDefinitionImpl#getDefinesType <em>Defines Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertySetDefinitionImpl#getIsDefinedBy <em>Is Defined By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPropertySetDefinitionImpl#getDefinesOccurrence <em>Defines Occurrence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertySetDefinitionImpl extends IfcPropertyDefinitionImpl implements IfcPropertySetDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertySetDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcTypeObject> getDefinesType() {
		return (EList<IfcTypeObject>) eGet(Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__DEFINES_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDefinesType() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__DEFINES_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDefinesType() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__DEFINES_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByTemplate> getIsDefinedBy() {
		return (EList<IfcRelDefinesByTemplate>) eGet(Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__IS_DEFINED_BY,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsDefinedBy() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__IS_DEFINED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsDefinedBy() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__IS_DEFINED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByProperties> getDefinesOccurrence() {
		return (EList<IfcRelDefinesByProperties>) eGet(
				Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__DEFINES_OCCURRENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDefinesOccurrence() {
		eUnset(Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__DEFINES_OCCURRENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDefinesOccurrence() {
		return eIsSet(Ifc4x3Package.Literals.IFC_PROPERTY_SET_DEFINITION__DEFINES_OCCURRENCE);
	}

} //IfcPropertySetDefinitionImpl
