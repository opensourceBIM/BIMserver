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
import org.bimserver.models.ifc4x3.IfcObject;
import org.bimserver.models.ifc4x3.IfcRelDefinesByObject;
import org.bimserver.models.ifc4x3.IfcRelDefinesByProperties;
import org.bimserver.models.ifc4x3.IfcRelDefinesByType;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcObjectImpl#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcObjectImpl#getIsDeclaredBy <em>Is Declared By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcObjectImpl#getDeclares <em>Declares</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcObjectImpl#getIsTypedBy <em>Is Typed By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcObjectImpl#getIsDefinedBy <em>Is Defined By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcObjectImpl extends IfcObjectDefinitionImpl implements IfcObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getObjectType() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_OBJECT__OBJECT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectType(String newObjectType) {
		eSet(Ifc4x3Package.Literals.IFC_OBJECT__OBJECT_TYPE, newObjectType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetObjectType() {
		eUnset(Ifc4x3Package.Literals.IFC_OBJECT__OBJECT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetObjectType() {
		return eIsSet(Ifc4x3Package.Literals.IFC_OBJECT__OBJECT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByObject> getIsDeclaredBy() {
		return (EList<IfcRelDefinesByObject>) eGet(Ifc4x3Package.Literals.IFC_OBJECT__IS_DECLARED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsDeclaredBy() {
		eUnset(Ifc4x3Package.Literals.IFC_OBJECT__IS_DECLARED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsDeclaredBy() {
		return eIsSet(Ifc4x3Package.Literals.IFC_OBJECT__IS_DECLARED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByObject> getDeclares() {
		return (EList<IfcRelDefinesByObject>) eGet(Ifc4x3Package.Literals.IFC_OBJECT__DECLARES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDeclares() {
		eUnset(Ifc4x3Package.Literals.IFC_OBJECT__DECLARES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDeclares() {
		return eIsSet(Ifc4x3Package.Literals.IFC_OBJECT__DECLARES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByType> getIsTypedBy() {
		return (EList<IfcRelDefinesByType>) eGet(Ifc4x3Package.Literals.IFC_OBJECT__IS_TYPED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsTypedBy() {
		eUnset(Ifc4x3Package.Literals.IFC_OBJECT__IS_TYPED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsTypedBy() {
		return eIsSet(Ifc4x3Package.Literals.IFC_OBJECT__IS_TYPED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelDefinesByProperties> getIsDefinedBy() {
		return (EList<IfcRelDefinesByProperties>) eGet(Ifc4x3Package.Literals.IFC_OBJECT__IS_DEFINED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsDefinedBy() {
		eUnset(Ifc4x3Package.Literals.IFC_OBJECT__IS_DEFINED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsDefinedBy() {
		return eIsSet(Ifc4x3Package.Literals.IFC_OBJECT__IS_DEFINED_BY);
	}

} //IfcObjectImpl
