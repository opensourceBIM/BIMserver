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
import org.bimserver.models.ifc2x3tc1.IfcAsymmetricIShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asymmetric IShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidth <em>Top Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidthAsString <em>Top Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThickness <em>Top Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThicknessAsString <em>Top Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadius <em>Top Flange Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadiusAsString <em>Top Flange Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAsymmetricIShapeProfileDefImpl#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAsymmetricIShapeProfileDefImpl#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAsymmetricIShapeProfileDefImpl extends IfcIShapeProfileDefImpl
		implements IfcAsymmetricIShapeProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAsymmetricIShapeProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTopFlangeWidth() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeWidth(double newTopFlangeWidth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH, newTopFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeWidthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeWidthAsString(String newTopFlangeWidthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH_AS_STRING,
				newTopFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTopFlangeThickness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeThickness(double newTopFlangeThickness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS, newTopFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeThickness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeThickness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeThicknessAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeThicknessAsString(String newTopFlangeThicknessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING,
				newTopFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeThicknessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeThicknessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTopFlangeFilletRadius() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeFilletRadius(double newTopFlangeFilletRadius) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS,
				newTopFlangeFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeFilletRadius() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeFilletRadius() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeFilletRadiusAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeFilletRadiusAsString(String newTopFlangeFilletRadiusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING,
				newTopFlangeFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeFilletRadiusAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeFilletRadiusAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCentreOfGravityInY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInY(double newCentreOfGravityInY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_Y,
				newCentreOfGravityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInYAsString(String newCentreOfGravityInYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_YAS_STRING,
				newCentreOfGravityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__CENTRE_OF_GRAVITY_IN_YAS_STRING);
	}

} //IfcAsymmetricIShapeProfileDefImpl
