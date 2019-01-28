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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcAheadOrBehind;
import org.bimserver.models.ifc2x3tc1.IfcCoordinatedUniversalTimeOffset;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Coordinated Universal Time Offset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCoordinatedUniversalTimeOffsetImpl#getHourOffset <em>Hour Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCoordinatedUniversalTimeOffsetImpl#getMinuteOffset <em>Minute Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCoordinatedUniversalTimeOffsetImpl#getSense <em>Sense</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCoordinatedUniversalTimeOffsetImpl extends IdEObjectImpl implements IfcCoordinatedUniversalTimeOffset {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCoordinatedUniversalTimeOffsetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET;
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
	public long getHourOffset() {
		return (Long) eGet(Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET__HOUR_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHourOffset(long newHourOffset) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET__HOUR_OFFSET, newHourOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMinuteOffset() {
		return (Long) eGet(Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET__MINUTE_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinuteOffset(long newMinuteOffset) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET__MINUTE_OFFSET, newMinuteOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinuteOffset() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET__MINUTE_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinuteOffset() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET__MINUTE_OFFSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAheadOrBehind getSense() {
		return (IfcAheadOrBehind) eGet(Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET__SENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSense(IfcAheadOrBehind newSense) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET__SENSE, newSense);
	}

} //IfcCoordinatedUniversalTimeOffsetImpl
