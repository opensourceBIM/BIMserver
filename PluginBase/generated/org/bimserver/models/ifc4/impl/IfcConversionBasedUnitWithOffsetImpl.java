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
import org.bimserver.models.ifc4.IfcConversionBasedUnitWithOffset;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Conversion Based Unit With Offset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConversionBasedUnitWithOffsetImpl#getConversionOffset <em>Conversion Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcConversionBasedUnitWithOffsetImpl#getConversionOffsetAsString <em>Conversion Offset As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConversionBasedUnitWithOffsetImpl extends IfcConversionBasedUnitImpl implements IfcConversionBasedUnitWithOffset {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConversionBasedUnitWithOffsetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CONVERSION_BASED_UNIT_WITH_OFFSET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getConversionOffset() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CONVERSION_BASED_UNIT_WITH_OFFSET__CONVERSION_OFFSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConversionOffset(double newConversionOffset) {
		eSet(Ifc4Package.Literals.IFC_CONVERSION_BASED_UNIT_WITH_OFFSET__CONVERSION_OFFSET, newConversionOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConversionOffsetAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CONVERSION_BASED_UNIT_WITH_OFFSET__CONVERSION_OFFSET_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConversionOffsetAsString(String newConversionOffsetAsString) {
		eSet(Ifc4Package.Literals.IFC_CONVERSION_BASED_UNIT_WITH_OFFSET__CONVERSION_OFFSET_AS_STRING, newConversionOffsetAsString);
	}

} //IfcConversionBasedUnitWithOffsetImpl
