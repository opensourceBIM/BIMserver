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
import org.bimserver.models.ifc4.IfcSurfaceStyleRefraction;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Style Refraction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceStyleRefractionImpl#getRefractionIndex <em>Refraction Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceStyleRefractionImpl#getRefractionIndexAsString <em>Refraction Index As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceStyleRefractionImpl#getDispersionFactor <em>Dispersion Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceStyleRefractionImpl#getDispersionFactorAsString <em>Dispersion Factor As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSurfaceStyleRefractionImpl extends IfcPresentationItemImpl implements IfcSurfaceStyleRefraction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceStyleRefractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRefractionIndex() {
		return (Double) eGet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefractionIndex(double newRefractionIndex) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX, newRefractionIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRefractionIndex() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRefractionIndex() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRefractionIndexAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefractionIndexAsString(String newRefractionIndexAsString) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX_AS_STRING, newRefractionIndexAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRefractionIndexAsString() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRefractionIndexAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDispersionFactor() {
		return (Double) eGet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispersionFactor(double newDispersionFactor) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR, newDispersionFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDispersionFactor() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDispersionFactor() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDispersionFactorAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispersionFactorAsString(String newDispersionFactorAsString) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR_AS_STRING, newDispersionFactorAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDispersionFactorAsString() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDispersionFactorAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR_AS_STRING);
	}

} //IfcSurfaceStyleRefractionImpl
