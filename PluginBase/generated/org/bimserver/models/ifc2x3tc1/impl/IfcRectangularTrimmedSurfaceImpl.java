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
import org.bimserver.models.ifc2x3tc1.IfcRectangularTrimmedSurface;
import org.bimserver.models.ifc2x3tc1.IfcSurface;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rectangular Trimmed Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getU1 <em>U1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getU1AsString <em>U1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getV1 <em>V1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getV1AsString <em>V1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getU2 <em>U2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getU2AsString <em>U2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getV2 <em>V2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getV2AsString <em>V2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getUsense <em>Usense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getVsense <em>Vsense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRectangularTrimmedSurfaceImpl#getDim <em>Dim</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRectangularTrimmedSurfaceImpl extends IfcBoundedSurfaceImpl implements IfcRectangularTrimmedSurface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRectangularTrimmedSurfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getBasisSurface() {
		return (IfcSurface) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__BASIS_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisSurface(IfcSurface newBasisSurface) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__BASIS_SURFACE, newBasisSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getU1() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU1(double newU1) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U1, newU1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getU1AsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U1_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU1AsString(String newU1AsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U1_AS_STRING, newU1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getV1() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV1(double newV1) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V1, newV1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getV1AsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V1_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV1AsString(String newV1AsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V1_AS_STRING, newV1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getU2() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU2(double newU2) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U2, newU2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getU2AsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU2AsString(String newU2AsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U2_AS_STRING, newU2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getV2() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV2(double newV2) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V2, newV2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getV2AsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV2AsString(String newV2AsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V2_AS_STRING, newV2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getUsense() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__USENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsense(Tristate newUsense) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__USENSE, newUsense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getVsense() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__VSENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVsense(Tristate newVsense) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__VSENSE, newVsense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDim() {
		return (Long) eGet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(long newDim) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__DIM, newDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDim() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__DIM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDim() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__DIM);
	}

} //IfcRectangularTrimmedSurfaceImpl
