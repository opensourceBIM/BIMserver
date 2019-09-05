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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcReference;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReferenceImpl#getTypeIdentifier <em>Type Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReferenceImpl#getAttributeIdentifier <em>Attribute Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReferenceImpl#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReferenceImpl#getListPositions <em>List Positions</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReferenceImpl#getInnerReference <em>Inner Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcReferenceImpl extends IdEObjectImpl implements IfcReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTypeIdentifier() {
		return (String) eGet(Ifc4Package.Literals.IFC_REFERENCE__TYPE_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypeIdentifier(String newTypeIdentifier) {
		eSet(Ifc4Package.Literals.IFC_REFERENCE__TYPE_IDENTIFIER, newTypeIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTypeIdentifier() {
		eUnset(Ifc4Package.Literals.IFC_REFERENCE__TYPE_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTypeIdentifier() {
		return eIsSet(Ifc4Package.Literals.IFC_REFERENCE__TYPE_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAttributeIdentifier() {
		return (String) eGet(Ifc4Package.Literals.IFC_REFERENCE__ATTRIBUTE_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttributeIdentifier(String newAttributeIdentifier) {
		eSet(Ifc4Package.Literals.IFC_REFERENCE__ATTRIBUTE_IDENTIFIER, newAttributeIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAttributeIdentifier() {
		eUnset(Ifc4Package.Literals.IFC_REFERENCE__ATTRIBUTE_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAttributeIdentifier() {
		return eIsSet(Ifc4Package.Literals.IFC_REFERENCE__ATTRIBUTE_IDENTIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInstanceName() {
		return (String) eGet(Ifc4Package.Literals.IFC_REFERENCE__INSTANCE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceName(String newInstanceName) {
		eSet(Ifc4Package.Literals.IFC_REFERENCE__INSTANCE_NAME, newInstanceName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInstanceName() {
		eUnset(Ifc4Package.Literals.IFC_REFERENCE__INSTANCE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInstanceName() {
		return eIsSet(Ifc4Package.Literals.IFC_REFERENCE__INSTANCE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getListPositions() {
		return (EList<Long>) eGet(Ifc4Package.Literals.IFC_REFERENCE__LIST_POSITIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetListPositions() {
		eUnset(Ifc4Package.Literals.IFC_REFERENCE__LIST_POSITIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetListPositions() {
		return eIsSet(Ifc4Package.Literals.IFC_REFERENCE__LIST_POSITIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReference getInnerReference() {
		return (IfcReference) eGet(Ifc4Package.Literals.IFC_REFERENCE__INNER_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInnerReference(IfcReference newInnerReference) {
		eSet(Ifc4Package.Literals.IFC_REFERENCE__INNER_REFERENCE, newInnerReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInnerReference() {
		eUnset(Ifc4Package.Literals.IFC_REFERENCE__INNER_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInnerReference() {
		return eIsSet(Ifc4Package.Literals.IFC_REFERENCE__INNER_REFERENCE);
	}

} //IfcReferenceImpl
