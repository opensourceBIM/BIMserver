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
import org.bimserver.models.ifc4.IfcAsymmetricIShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asymmetric IShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeWidth <em>Bottom Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeWidthAsString <em>Bottom Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getOverallDepth <em>Overall Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getOverallDepthAsString <em>Overall Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeThickness <em>Bottom Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeThicknessAsString <em>Bottom Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeFilletRadius <em>Bottom Flange Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeFilletRadiusAsString <em>Bottom Flange Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidth <em>Top Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidthAsString <em>Top Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThickness <em>Top Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThicknessAsString <em>Top Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadius <em>Top Flange Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadiusAsString <em>Top Flange Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeEdgeRadius <em>Bottom Flange Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeEdgeRadiusAsString <em>Bottom Flange Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeSlope <em>Bottom Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeSlopeAsString <em>Bottom Flange Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeEdgeRadius <em>Top Flange Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeEdgeRadiusAsString <em>Top Flange Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeSlope <em>Top Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeSlopeAsString <em>Top Flange Slope As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAsymmetricIShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcAsymmetricIShapeProfileDef {
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
		return Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeWidth(double newBottomFlangeWidth) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_WIDTH, newBottomFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeWidthAsString(String newBottomFlangeWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_WIDTH_AS_STRING, newBottomFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOverallDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__OVERALL_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallDepth(double newOverallDepth) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__OVERALL_DEPTH, newOverallDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOverallDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__OVERALL_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallDepthAsString(String newOverallDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__OVERALL_DEPTH_AS_STRING, newOverallDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWebThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__WEB_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThickness(double newWebThickness) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__WEB_THICKNESS, newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__WEB_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThicknessAsString(String newWebThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__WEB_THICKNESS_AS_STRING, newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeThickness(double newBottomFlangeThickness) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_THICKNESS, newBottomFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeThicknessAsString(String newBottomFlangeThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_THICKNESS_AS_STRING, newBottomFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeFilletRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeFilletRadius(double newBottomFlangeFilletRadius) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_FILLET_RADIUS, newBottomFlangeFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeFilletRadius() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeFilletRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeFilletRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeFilletRadiusAsString(String newBottomFlangeFilletRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_FILLET_RADIUS_AS_STRING, newBottomFlangeFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeFilletRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeFilletRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeWidth(double newTopFlangeWidth) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH, newTopFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeWidthAsString(String newTopFlangeWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_WIDTH_AS_STRING, newTopFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeThickness(double newTopFlangeThickness) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS, newTopFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeThickness() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeThicknessAsString(String newTopFlangeThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING, newTopFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeFilletRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeFilletRadius(double newTopFlangeFilletRadius) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS, newTopFlangeFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeFilletRadius() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeFilletRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeFilletRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeFilletRadiusAsString(String newTopFlangeFilletRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING, newTopFlangeFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeFilletRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeFilletRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeEdgeRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_EDGE_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeEdgeRadius(double newBottomFlangeEdgeRadius) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_EDGE_RADIUS, newBottomFlangeEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeEdgeRadius() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeEdgeRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeEdgeRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_EDGE_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeEdgeRadiusAsString(String newBottomFlangeEdgeRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_EDGE_RADIUS_AS_STRING, newBottomFlangeEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeEdgeRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeEdgeRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeSlope() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_SLOPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeSlope(double newBottomFlangeSlope) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_SLOPE, newBottomFlangeSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeSlope() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeSlope() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeSlopeAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_SLOPE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeSlopeAsString(String newBottomFlangeSlopeAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_SLOPE_AS_STRING, newBottomFlangeSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeSlopeAsString() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_SLOPE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeSlopeAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__BOTTOM_FLANGE_SLOPE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeEdgeRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_EDGE_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeEdgeRadius(double newTopFlangeEdgeRadius) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_EDGE_RADIUS, newTopFlangeEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeEdgeRadius() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeEdgeRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeEdgeRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_EDGE_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeEdgeRadiusAsString(String newTopFlangeEdgeRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_EDGE_RADIUS_AS_STRING, newTopFlangeEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeEdgeRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeEdgeRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeSlope() {
		return (Double) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_SLOPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeSlope(double newTopFlangeSlope) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_SLOPE, newTopFlangeSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeSlope() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeSlope() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeSlopeAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_SLOPE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeSlopeAsString(String newTopFlangeSlopeAsString) {
		eSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_SLOPE_AS_STRING, newTopFlangeSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeSlopeAsString() {
		eUnset(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_SLOPE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeSlopeAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF__TOP_FLANGE_SLOPE_AS_STRING);
	}

} //IfcAsymmetricIShapeProfileDefImpl
