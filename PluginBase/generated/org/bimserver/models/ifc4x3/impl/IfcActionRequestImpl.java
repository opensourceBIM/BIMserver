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
import org.bimserver.models.ifc4x3.IfcActionRequest;
import org.bimserver.models.ifc4x3.IfcActionRequestTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Action Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActionRequestImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActionRequestImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActionRequestImpl#getLongDescription <em>Long Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcActionRequestImpl extends IfcControlImpl implements IfcActionRequest {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcActionRequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcActionRequest();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActionRequestTypeEnum getPredefinedType() {
		return (IfcActionRequestTypeEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcActionRequestTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcActionRequest_PredefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_PredefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatus() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_Status(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(String newStatus) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_Status(), newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatus() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcActionRequest_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatus() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_LongDescription(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongDescription(String newLongDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_LongDescription(), newLongDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcActionRequest_LongDescription());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcActionRequest_LongDescription());
	}

} //IfcActionRequestImpl
