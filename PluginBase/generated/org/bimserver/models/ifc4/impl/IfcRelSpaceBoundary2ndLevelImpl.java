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
import org.bimserver.models.ifc4.IfcRelSpaceBoundary2ndLevel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Space Boundary2nd Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundary2ndLevelImpl#getCorrespondingBoundary <em>Corresponding Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcRelSpaceBoundary2ndLevelImpl#getCorresponds <em>Corresponds</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelSpaceBoundary2ndLevelImpl extends IfcRelSpaceBoundary1stLevelImpl implements IfcRelSpaceBoundary2ndLevel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelSpaceBoundary2ndLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY2ND_LEVEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelSpaceBoundary2ndLevel getCorrespondingBoundary() {
		return (IfcRelSpaceBoundary2ndLevel) eGet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY2ND_LEVEL__CORRESPONDING_BOUNDARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCorrespondingBoundary(IfcRelSpaceBoundary2ndLevel newCorrespondingBoundary) {
		eSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY2ND_LEVEL__CORRESPONDING_BOUNDARY, newCorrespondingBoundary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCorrespondingBoundary() {
		eUnset(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY2ND_LEVEL__CORRESPONDING_BOUNDARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCorrespondingBoundary() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY2ND_LEVEL__CORRESPONDING_BOUNDARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelSpaceBoundary2ndLevel> getCorresponds() {
		return (EList<IfcRelSpaceBoundary2ndLevel>) eGet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY2ND_LEVEL__CORRESPONDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCorresponds() {
		eUnset(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY2ND_LEVEL__CORRESPONDS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCorresponds() {
		return eIsSet(Ifc4Package.Literals.IFC_REL_SPACE_BOUNDARY2ND_LEVEL__CORRESPONDS);
	}

} //IfcRelSpaceBoundary2ndLevelImpl
