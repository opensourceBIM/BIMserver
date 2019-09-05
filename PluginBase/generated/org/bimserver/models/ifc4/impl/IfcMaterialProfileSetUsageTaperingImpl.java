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
import org.bimserver.models.ifc4.IfcMaterialProfileSet;
import org.bimserver.models.ifc4.IfcMaterialProfileSetUsageTapering;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Profile Set Usage Tapering</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileSetUsageTaperingImpl#getForProfileEndSet <em>For Profile End Set</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMaterialProfileSetUsageTaperingImpl#getCardinalEndPoint <em>Cardinal End Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialProfileSetUsageTaperingImpl extends IfcMaterialProfileSetUsageImpl implements IfcMaterialProfileSetUsageTapering {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialProfileSetUsageTaperingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET_USAGE_TAPERING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialProfileSet getForProfileEndSet() {
		return (IfcMaterialProfileSet) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET_USAGE_TAPERING__FOR_PROFILE_END_SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForProfileEndSet(IfcMaterialProfileSet newForProfileEndSet) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET_USAGE_TAPERING__FOR_PROFILE_END_SET, newForProfileEndSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getCardinalEndPoint() {
		return (Long) eGet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET_USAGE_TAPERING__CARDINAL_END_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCardinalEndPoint(long newCardinalEndPoint) {
		eSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET_USAGE_TAPERING__CARDINAL_END_POINT, newCardinalEndPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCardinalEndPoint() {
		eUnset(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET_USAGE_TAPERING__CARDINAL_END_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCardinalEndPoint() {
		return eIsSet(Ifc4Package.Literals.IFC_MATERIAL_PROFILE_SET_USAGE_TAPERING__CARDINAL_END_POINT);
	}

} //IfcMaterialProfileSetUsageTaperingImpl
