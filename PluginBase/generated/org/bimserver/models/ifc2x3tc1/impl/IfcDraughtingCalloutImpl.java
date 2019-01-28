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
import org.bimserver.models.ifc2x3tc1.IfcDraughtingCallout;
import org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutElement;
import org.bimserver.models.ifc2x3tc1.IfcDraughtingCalloutRelationship;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Draughting Callout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDraughtingCalloutImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDraughtingCalloutImpl#getIsRelatedFromCallout <em>Is Related From Callout</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDraughtingCalloutImpl#getIsRelatedToCallout <em>Is Related To Callout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDraughtingCalloutImpl extends IfcGeometricRepresentationItemImpl implements IfcDraughtingCallout {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDraughtingCalloutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_DRAUGHTING_CALLOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutElement> getContents() {
		return (EList<IfcDraughtingCalloutElement>) eGet(Ifc2x3tc1Package.Literals.IFC_DRAUGHTING_CALLOUT__CONTENTS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutRelationship> getIsRelatedFromCallout() {
		return (EList<IfcDraughtingCalloutRelationship>) eGet(
				Ifc2x3tc1Package.Literals.IFC_DRAUGHTING_CALLOUT__IS_RELATED_FROM_CALLOUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsRelatedFromCallout() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DRAUGHTING_CALLOUT__IS_RELATED_FROM_CALLOUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsRelatedFromCallout() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DRAUGHTING_CALLOUT__IS_RELATED_FROM_CALLOUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutRelationship> getIsRelatedToCallout() {
		return (EList<IfcDraughtingCalloutRelationship>) eGet(
				Ifc2x3tc1Package.Literals.IFC_DRAUGHTING_CALLOUT__IS_RELATED_TO_CALLOUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsRelatedToCallout() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_DRAUGHTING_CALLOUT__IS_RELATED_TO_CALLOUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsRelatedToCallout() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_DRAUGHTING_CALLOUT__IS_RELATED_TO_CALLOUT);
	}

} //IfcDraughtingCalloutImpl
