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
import org.bimserver.models.ifc4x3.IfcMapConversion;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Map Conversion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getEastings <em>Eastings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getEastingsAsString <em>Eastings As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getNorthings <em>Northings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getNorthingsAsString <em>Northings As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getOrthogonalHeight <em>Orthogonal Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getOrthogonalHeightAsString <em>Orthogonal Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getXAxisAbscissa <em>XAxis Abscissa</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getXAxisAbscissaAsString <em>XAxis Abscissa As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getXAxisOrdinate <em>XAxis Ordinate</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getXAxisOrdinateAsString <em>XAxis Ordinate As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMapConversionImpl#getScaleAsString <em>Scale As String</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcMapConversion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEastings() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_Eastings(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEastings(double newEastings) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_Eastings(), newEastings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEastingsAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_EastingsAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEastingsAsString(String newEastingsAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_EastingsAsString(), newEastingsAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getNorthings() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_Northings(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNorthings(double newNorthings) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_Northings(), newNorthings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNorthingsAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_NorthingsAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNorthingsAsString(String newNorthingsAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_NorthingsAsString(), newNorthingsAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOrthogonalHeight() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_OrthogonalHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrthogonalHeight(double newOrthogonalHeight) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_OrthogonalHeight(), newOrthogonalHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOrthogonalHeightAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_OrthogonalHeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrthogonalHeightAsString(String newOrthogonalHeightAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_OrthogonalHeightAsString(), newOrthogonalHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getXAxisAbscissa() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisAbscissa(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXAxisAbscissa(double newXAxisAbscissa) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisAbscissa(), newXAxisAbscissa);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetXAxisAbscissa() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisAbscissa());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetXAxisAbscissa() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisAbscissa());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getXAxisAbscissaAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisAbscissaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXAxisAbscissaAsString(String newXAxisAbscissaAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisAbscissaAsString(), newXAxisAbscissaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetXAxisAbscissaAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisAbscissaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetXAxisAbscissaAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisAbscissaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getXAxisOrdinate() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisOrdinate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXAxisOrdinate(double newXAxisOrdinate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisOrdinate(), newXAxisOrdinate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetXAxisOrdinate() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisOrdinate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetXAxisOrdinate() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisOrdinate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getXAxisOrdinateAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisOrdinateAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXAxisOrdinateAsString(String newXAxisOrdinateAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisOrdinateAsString(), newXAxisOrdinateAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetXAxisOrdinateAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisOrdinateAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetXAxisOrdinateAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_XAxisOrdinateAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScale() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_Scale(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale(double newScale) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_Scale(), newScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScale() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMapConversion_Scale());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScale() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_Scale());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScaleAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_ScaleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScaleAsString(String newScaleAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_ScaleAsString(), newScaleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScaleAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMapConversion_ScaleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScaleAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMapConversion_ScaleAsString());
	}

} //IfcMapConversionImpl
