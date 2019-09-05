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
import org.bimserver.models.ifc4.IfcTShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc TShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFlangeWidth <em>Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFlangeWidthAsString <em>Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFlangeEdgeRadius <em>Flange Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getWebEdgeRadius <em>Web Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getWebEdgeRadiusAsString <em>Web Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getWebSlope <em>Web Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getWebSlopeAsString <em>Web Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFlangeSlope <em>Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTShapeProfileDefImpl#getFlangeSlopeAsString <em>Flange Slope As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcTShapeProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTShapeProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepth(double newDepth) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__DEPTH, newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthAsString(String newDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__DEPTH_AS_STRING, newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeWidth(double newFlangeWidth) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_WIDTH, newFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeWidthAsString(String newFlangeWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_WIDTH_AS_STRING, newFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWebThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThickness(double newWebThickness) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_THICKNESS, newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThicknessAsString(String newWebThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_THICKNESS_AS_STRING, newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeThickness(double newFlangeThickness) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_THICKNESS, newFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeThicknessAsString(String newFlangeThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_THICKNESS_AS_STRING, newFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFilletRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadius(double newFilletRadius) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FILLET_RADIUS, newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadius() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilletRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadiusAsString(String newFilletRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING, newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeEdgeRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_EDGE_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeEdgeRadius(double newFlangeEdgeRadius) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_EDGE_RADIUS, newFlangeEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeEdgeRadius() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeEdgeRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeEdgeRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_EDGE_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeEdgeRadiusAsString(String newFlangeEdgeRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_EDGE_RADIUS_AS_STRING, newFlangeEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeEdgeRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeEdgeRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWebEdgeRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_EDGE_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebEdgeRadius(double newWebEdgeRadius) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_EDGE_RADIUS, newWebEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWebEdgeRadius() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWebEdgeRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebEdgeRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_EDGE_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebEdgeRadiusAsString(String newWebEdgeRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_EDGE_RADIUS_AS_STRING, newWebEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWebEdgeRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWebEdgeRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWebSlope() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_SLOPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebSlope(double newWebSlope) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_SLOPE, newWebSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWebSlope() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWebSlope() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebSlopeAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_SLOPE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebSlopeAsString(String newWebSlopeAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_SLOPE_AS_STRING, newWebSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWebSlopeAsString() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_SLOPE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWebSlopeAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__WEB_SLOPE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeSlope() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_SLOPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeSlope(double newFlangeSlope) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_SLOPE, newFlangeSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeSlope() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeSlope() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeSlopeAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_SLOPE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeSlopeAsString(String newFlangeSlopeAsString) {
		eSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_SLOPE_AS_STRING, newFlangeSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeSlopeAsString() {
		eUnset(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_SLOPE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeSlopeAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_TSHAPE_PROFILE_DEF__FLANGE_SLOPE_AS_STRING);
	}

} //IfcTShapeProfileDefImpl
