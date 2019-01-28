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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAssigns;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Object Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcObjectDefinitionImpl#getHasAssignments <em>Has Assignments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcObjectDefinitionImpl#getIsDecomposedBy <em>Is Decomposed By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcObjectDefinitionImpl#getDecomposes <em>Decomposes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcObjectDefinitionImpl#getHasAssociations <em>Has Associations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcObjectDefinitionImpl extends IfcRootImpl implements IfcObjectDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcObjectDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelAssigns> getHasAssignments() {
		return (EList<IfcRelAssigns>) eGet(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__HAS_ASSIGNMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasAssignments() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__HAS_ASSIGNMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasAssignments() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__HAS_ASSIGNMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelDecomposes> getIsDecomposedBy() {
		return (EList<IfcRelDecomposes>) eGet(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__IS_DECOMPOSED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsDecomposedBy() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__IS_DECOMPOSED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsDecomposedBy() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__IS_DECOMPOSED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelDecomposes> getDecomposes() {
		return (EList<IfcRelDecomposes>) eGet(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__DECOMPOSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDecomposes() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__DECOMPOSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDecomposes() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__DECOMPOSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelAssociates> getHasAssociations() {
		return (EList<IfcRelAssociates>) eGet(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__HAS_ASSOCIATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasAssociations() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__HAS_ASSOCIATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasAssociations() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_OBJECT_DEFINITION__HAS_ASSOCIATIONS);
	}

} //IfcObjectDefinitionImpl
