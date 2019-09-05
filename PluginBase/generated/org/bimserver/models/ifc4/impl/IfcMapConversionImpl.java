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
import org.bimserver.models.ifc4.IfcMapConversion;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Map Conversion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getEastings <em>Eastings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getEastingsAsString <em>Eastings As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getNorthings <em>Northings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getNorthingsAsString <em>Northings As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getOrthogonalHeight <em>Orthogonal Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getOrthogonalHeightAsString <em>Orthogonal Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getXAxisAbscissa <em>XAxis Abscissa</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getXAxisAbscissaAsString <em>XAxis Abscissa As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getXAxisOrdinate <em>XAxis Ordinate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getXAxisOrdinateAsString <em>XAxis Ordinate As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcMapConversionImpl#getScaleAsString <em>Scale As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMapConversionImpl extends IfcCoordinateOperationImpl implements IfcMapConversion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMapConversionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_MAP_CONVERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEastings() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__EASTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEastings(double newEastings) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__EASTINGS, newEastings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEastingsAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__EASTINGS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEastingsAsString(String newEastingsAsString) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__EASTINGS_AS_STRING, newEastingsAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getNorthings() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__NORTHINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNorthings(double newNorthings) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__NORTHINGS, newNorthings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNorthingsAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__NORTHINGS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNorthingsAsString(String newNorthingsAsString) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__NORTHINGS_AS_STRING, newNorthingsAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOrthogonalHeight() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__ORTHOGONAL_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrthogonalHeight(double newOrthogonalHeight) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__ORTHOGONAL_HEIGHT, newOrthogonalHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOrthogonalHeightAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__ORTHOGONAL_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrthogonalHeightAsString(String newOrthogonalHeightAsString) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__ORTHOGONAL_HEIGHT_AS_STRING, newOrthogonalHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getXAxisAbscissa() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ABSCISSA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXAxisAbscissa(double newXAxisAbscissa) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ABSCISSA, newXAxisAbscissa);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetXAxisAbscissa() {
		eUnset(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ABSCISSA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetXAxisAbscissa() {
		return eIsSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ABSCISSA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getXAxisAbscissaAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ABSCISSA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXAxisAbscissaAsString(String newXAxisAbscissaAsString) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ABSCISSA_AS_STRING, newXAxisAbscissaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetXAxisAbscissaAsString() {
		eUnset(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ABSCISSA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetXAxisAbscissaAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ABSCISSA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getXAxisOrdinate() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ORDINATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXAxisOrdinate(double newXAxisOrdinate) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ORDINATE, newXAxisOrdinate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetXAxisOrdinate() {
		eUnset(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ORDINATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetXAxisOrdinate() {
		return eIsSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ORDINATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getXAxisOrdinateAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ORDINATE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXAxisOrdinateAsString(String newXAxisOrdinateAsString) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ORDINATE_AS_STRING, newXAxisOrdinateAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetXAxisOrdinateAsString() {
		eUnset(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ORDINATE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetXAxisOrdinateAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__XAXIS_ORDINATE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScale() {
		return (Double) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__SCALE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale(double newScale) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__SCALE, newScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScale() {
		eUnset(Ifc4Package.Literals.IFC_MAP_CONVERSION__SCALE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScale() {
		return eIsSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__SCALE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScaleAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_MAP_CONVERSION__SCALE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScaleAsString(String newScaleAsString) {
		eSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__SCALE_AS_STRING, newScaleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScaleAsString() {
		eUnset(Ifc4Package.Literals.IFC_MAP_CONVERSION__SCALE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScaleAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_MAP_CONVERSION__SCALE_AS_STRING);
	}

} //IfcMapConversionImpl
