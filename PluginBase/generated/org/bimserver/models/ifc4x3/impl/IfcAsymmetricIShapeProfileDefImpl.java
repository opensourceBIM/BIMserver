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
import org.bimserver.models.ifc4x3.IfcAsymmetricIShapeProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asymmetric IShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeWidth <em>Bottom Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeWidthAsString <em>Bottom Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getOverallDepth <em>Overall Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getOverallDepthAsString <em>Overall Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeThickness <em>Bottom Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeThicknessAsString <em>Bottom Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeFilletRadius <em>Bottom Flange Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeFilletRadiusAsString <em>Bottom Flange Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidth <em>Top Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidthAsString <em>Top Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThickness <em>Top Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThicknessAsString <em>Top Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadius <em>Top Flange Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadiusAsString <em>Top Flange Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeEdgeRadius <em>Bottom Flange Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeEdgeRadiusAsString <em>Bottom Flange Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeSlope <em>Bottom Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getBottomFlangeSlopeAsString <em>Bottom Flange Slope As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeEdgeRadius <em>Top Flange Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeEdgeRadiusAsString <em>Top Flange Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeSlope <em>Top Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeSlopeAsString <em>Top Flange Slope As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAsymmetricIShapeProfileDefImpl extends IfcParameterizedProfileDefImpl
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
		return Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeWidth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeWidth(double newBottomFlangeWidth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeWidth(), newBottomFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeWidthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeWidthAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeWidthAsString(String newBottomFlangeWidthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeWidthAsString(),
				newBottomFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOverallDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_OverallDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallDepth(double newOverallDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_OverallDepth(), newOverallDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOverallDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_OverallDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallDepthAsString(String newOverallDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_OverallDepthAsString(), newOverallDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWebThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_WebThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThickness(double newWebThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_WebThickness(), newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_WebThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThicknessAsString(String newWebThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_WebThicknessAsString(), newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeThickness(double newBottomFlangeThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeThickness(),
				newBottomFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeThicknessAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeThicknessAsString(String newBottomFlangeThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeThicknessAsString(),
				newBottomFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeFilletRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeFilletRadius(double newBottomFlangeFilletRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadius(),
				newBottomFlangeFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeFilletRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeFilletRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeFilletRadiusAsString() {
		return (String) eGet(
				Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeFilletRadiusAsString(String newBottomFlangeFilletRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadiusAsString(),
				newBottomFlangeFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeFilletRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeFilletRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeWidth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeWidth(double newTopFlangeWidth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeWidth(), newTopFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeWidthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeWidthAsString(String newTopFlangeWidthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeWidthAsString(),
				newTopFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeThickness(double newTopFlangeThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThickness(), newTopFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeThickness() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeThickness() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeThicknessAsString(String newTopFlangeThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString(),
				newTopFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeThicknessAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeThicknessAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeFilletRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeFilletRadius(double newTopFlangeFilletRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius(),
				newTopFlangeFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeFilletRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeFilletRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeFilletRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeFilletRadiusAsString(String newTopFlangeFilletRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString(),
				newTopFlangeFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeFilletRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeFilletRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeEdgeRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeEdgeRadius(double newBottomFlangeEdgeRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadius(),
				newBottomFlangeEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeEdgeRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeEdgeRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeEdgeRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadiusAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeEdgeRadiusAsString(String newBottomFlangeEdgeRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadiusAsString(),
				newBottomFlangeEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeEdgeRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeEdgeRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBottomFlangeSlope() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeSlope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeSlope(double newBottomFlangeSlope) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeSlope(), newBottomFlangeSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeSlope() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeSlope() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBottomFlangeSlopeAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeSlopeAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBottomFlangeSlopeAsString(String newBottomFlangeSlopeAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeSlopeAsString(),
				newBottomFlangeSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBottomFlangeSlopeAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBottomFlangeSlopeAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_BottomFlangeSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeEdgeRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeEdgeRadius(double newTopFlangeEdgeRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadius(), newTopFlangeEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeEdgeRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeEdgeRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeEdgeRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadiusAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeEdgeRadiusAsString(String newTopFlangeEdgeRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadiusAsString(),
				newTopFlangeEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeEdgeRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeEdgeRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTopFlangeSlope() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeSlope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeSlope(double newTopFlangeSlope) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeSlope(), newTopFlangeSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeSlope() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeSlope() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTopFlangeSlopeAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeSlopeAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTopFlangeSlopeAsString(String newTopFlangeSlopeAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeSlopeAsString(),
				newTopFlangeSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTopFlangeSlopeAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTopFlangeSlopeAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeSlopeAsString());
	}

} //IfcAsymmetricIShapeProfileDefImpl
