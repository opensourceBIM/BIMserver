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
import org.bimserver.models.ifc4x3.IfcProfileDef;
import org.bimserver.models.ifc4x3.IfcRelAssociatesProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Associates Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRelAssociatesProfileDefImpl#getRelatingProfileDef <em>Relating Profile Def</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelAssociatesProfileDefImpl extends IfcRelAssociatesImpl implements IfcRelAssociatesProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssociatesProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_REL_ASSOCIATES_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProfileDef getRelatingProfileDef() {
		return (IfcProfileDef) eGet(Ifc4x3Package.Literals.IFC_REL_ASSOCIATES_PROFILE_DEF__RELATING_PROFILE_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelatingProfileDef(IfcProfileDef newRelatingProfileDef) {
		eSet(Ifc4x3Package.Literals.IFC_REL_ASSOCIATES_PROFILE_DEF__RELATING_PROFILE_DEF, newRelatingProfileDef);
	}

} //IfcRelAssociatesProfileDefImpl
