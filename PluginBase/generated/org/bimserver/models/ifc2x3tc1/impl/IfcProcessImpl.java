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
import org.bimserver.models.ifc2x3tc1.IfcProcess;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsToProcess;
import org.bimserver.models.ifc2x3tc1.IfcRelSequence;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProcessImpl#getOperatesOn <em>Operates On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProcessImpl#getIsSuccessorFrom <em>Is Successor From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcProcessImpl#getIsPredecessorTo <em>Is Predecessor To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcProcessImpl extends IfcObjectImpl implements IfcProcess {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelAssignsToProcess> getOperatesOn() {
		return (EList<IfcRelAssignsToProcess>) eGet(Ifc2x3tc1Package.Literals.IFC_PROCESS__OPERATES_ON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOperatesOn() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PROCESS__OPERATES_ON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOperatesOn() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PROCESS__OPERATES_ON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelSequence> getIsSuccessorFrom() {
		return (EList<IfcRelSequence>) eGet(Ifc2x3tc1Package.Literals.IFC_PROCESS__IS_SUCCESSOR_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsSuccessorFrom() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PROCESS__IS_SUCCESSOR_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsSuccessorFrom() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PROCESS__IS_SUCCESSOR_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelSequence> getIsPredecessorTo() {
		return (EList<IfcRelSequence>) eGet(Ifc2x3tc1Package.Literals.IFC_PROCESS__IS_PREDECESSOR_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsPredecessorTo() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PROCESS__IS_PREDECESSOR_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsPredecessorTo() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PROCESS__IS_PREDECESSOR_TO);
	}

} //IfcProcessImpl
