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
import org.bimserver.models.ifc2x3tc1.IfcServiceLife;
import org.bimserver.models.ifc2x3tc1.IfcServiceLifeTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Service Life</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcServiceLifeImpl#getServiceLifeType <em>Service Life Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcServiceLifeImpl#getServiceLifeDuration <em>Service Life Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcServiceLifeImpl#getServiceLifeDurationAsString <em>Service Life Duration As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcServiceLifeImpl extends IfcControlImpl implements IfcServiceLife {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcServiceLifeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcServiceLifeTypeEnum getServiceLifeType() {
		return (IfcServiceLifeTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE__SERVICE_LIFE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceLifeType(IfcServiceLifeTypeEnum newServiceLifeType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE__SERVICE_LIFE_TYPE, newServiceLifeType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getServiceLifeDuration() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE__SERVICE_LIFE_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceLifeDuration(double newServiceLifeDuration) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE__SERVICE_LIFE_DURATION, newServiceLifeDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceLifeDurationAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE__SERVICE_LIFE_DURATION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceLifeDurationAsString(String newServiceLifeDurationAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SERVICE_LIFE__SERVICE_LIFE_DURATION_AS_STRING,
				newServiceLifeDurationAsString);
	}

} //IfcServiceLifeImpl
