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
import org.bimserver.models.ifc4x3.IfcCovering;
import org.bimserver.models.ifc4x3.IfcCoveringTypeEnum;
import org.bimserver.models.ifc4x3.IfcRelCoversBldgElements;
import org.bimserver.models.ifc4x3.IfcRelCoversSpaces;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Covering</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCoveringImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCoveringImpl#getCoversSpaces <em>Covers Spaces</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCoveringImpl#getCoversElements <em>Covers Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCoveringImpl extends IfcBuiltElementImpl implements IfcCovering {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCoveringImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_COVERING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCoveringTypeEnum getPredefinedType() {
		return (IfcCoveringTypeEnum) eGet(Ifc4x3Package.Literals.IFC_COVERING__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcCoveringTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_COVERING__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4x3Package.Literals.IFC_COVERING__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4x3Package.Literals.IFC_COVERING__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelCoversSpaces> getCoversSpaces() {
		return (EList<IfcRelCoversSpaces>) eGet(Ifc4x3Package.Literals.IFC_COVERING__COVERS_SPACES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoversSpaces() {
		eUnset(Ifc4x3Package.Literals.IFC_COVERING__COVERS_SPACES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoversSpaces() {
		return eIsSet(Ifc4x3Package.Literals.IFC_COVERING__COVERS_SPACES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelCoversBldgElements> getCoversElements() {
		return (EList<IfcRelCoversBldgElements>) eGet(Ifc4x3Package.Literals.IFC_COVERING__COVERS_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoversElements() {
		eUnset(Ifc4x3Package.Literals.IFC_COVERING__COVERS_ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoversElements() {
		return eIsSet(Ifc4x3Package.Literals.IFC_COVERING__COVERS_ELEMENTS);
	}

} //IfcCoveringImpl
