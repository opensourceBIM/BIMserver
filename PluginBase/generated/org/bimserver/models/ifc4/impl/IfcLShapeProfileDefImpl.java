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
import org.bimserver.models.ifc4.IfcLShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc LShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getWidthAsString <em>Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getThicknessAsString <em>Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getEdgeRadius <em>Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getEdgeRadiusAsString <em>Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getLegSlope <em>Leg Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLShapeProfileDefImpl#getLegSlopeAsString <em>Leg Slope As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcLShapeProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLShapeProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepth(double newDepth) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__DEPTH, newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthAsString(String newDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__DEPTH_AS_STRING, newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(double newWidth) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__WIDTH, newWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWidth() {
		eUnset(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWidth() {
		return eIsSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidthAsString(String newWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__WIDTH_AS_STRING, newWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWidthAsString() {
		eUnset(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWidthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThickness(double newThickness) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__THICKNESS, newThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThicknessAsString(String newThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__THICKNESS_AS_STRING, newThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFilletRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__FILLET_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadius(double newFilletRadius) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__FILLET_RADIUS, newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadius() {
		eUnset(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__FILLET_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilletRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadiusAsString(String newFilletRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING, newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__FILLET_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEdgeRadius() {
		return (Double) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__EDGE_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdgeRadius(double newEdgeRadius) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__EDGE_RADIUS, newEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEdgeRadius() {
		eUnset(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEdgeRadius() {
		return eIsSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__EDGE_RADIUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEdgeRadiusAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__EDGE_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdgeRadiusAsString(String newEdgeRadiusAsString) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__EDGE_RADIUS_AS_STRING, newEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEdgeRadiusAsString() {
		eUnset(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEdgeRadiusAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__EDGE_RADIUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLegSlope() {
		return (Double) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__LEG_SLOPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLegSlope(double newLegSlope) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__LEG_SLOPE, newLegSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLegSlope() {
		eUnset(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__LEG_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLegSlope() {
		return eIsSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__LEG_SLOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLegSlopeAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__LEG_SLOPE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLegSlopeAsString(String newLegSlopeAsString) {
		eSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__LEG_SLOPE_AS_STRING, newLegSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLegSlopeAsString() {
		eUnset(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__LEG_SLOPE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLegSlopeAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_LSHAPE_PROFILE_DEF__LEG_SLOPE_AS_STRING);
	}

} //IfcLShapeProfileDefImpl
