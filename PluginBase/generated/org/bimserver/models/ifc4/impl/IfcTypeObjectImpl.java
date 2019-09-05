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
import org.bimserver.models.ifc4.IfcRelDefinesByType;
import org.bimserver.models.ifc4.IfcTypeObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Type Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTypeObjectImpl#getApplicableOccurrence <em>Applicable Occurrence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTypeObjectImpl#getHasPropertySets <em>Has Property Sets</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTypeObjectImpl#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTypeObjectImpl extends IfcObjectDefinitionImpl implements IfcTypeObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTypeObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TYPE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApplicableOccurrence() {
		return (String) eGet(Ifc4Package.Literals.IFC_TYPE_OBJECT__APPLICABLE_OCCURRENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicableOccurrence(String newApplicableOccurrence) {
		eSet(Ifc4Package.Literals.IFC_TYPE_OBJECT__APPLICABLE_OCCURRENCE, newApplicableOccurrence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetApplicableOccurrence() {
		eUnset(Ifc4Package.Literals.IFC_TYPE_OBJECT__APPLICABLE_OCCURRENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetApplicableOccurrence() {
		return eIsSet(Ifc4Package.Literals.IFC_TYPE_OBJECT__APPLICABLE_OCCURRENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPropertySetDefinition> getHasPropertySets() {
		return (EList<IfcPropertySetDefinition>) eGet(Ifc4Package.Literals.IFC_TYPE_OBJECT__HAS_PROPERTY_SETS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasPropertySets() {
		eUnset(Ifc4Package.Literals.IFC_TYPE_OBJECT__HAS_PROPERTY_SETS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasPropertySets() {
		return eIsSet(Ifc4Package.Literals.IFC_TYPE_OBJECT__HAS_PROPERTY_SETS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByType> getTypes() {
		return (EList<IfcRelDefinesByType>) eGet(Ifc4Package.Literals.IFC_TYPE_OBJECT__TYPES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTypes() {
		eUnset(Ifc4Package.Literals.IFC_TYPE_OBJECT__TYPES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTypes() {
		return eIsSet(Ifc4Package.Literals.IFC_TYPE_OBJECT__TYPES);
	}

} //IfcTypeObjectImpl
