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
import org.bimserver.models.ifc4x3.IfcIShapeProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc IShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getOverallWidth <em>Overall Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getOverallWidthAsString <em>Overall Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getOverallDepth <em>Overall Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getOverallDepthAsString <em>Overall Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getFlangeEdgeRadius <em>Flange Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getFlangeEdgeRadiusAsString <em>Flange Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getFlangeSlope <em>Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIShapeProfileDefImpl#getFlangeSlopeAsString <em>Flange Slope As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcIShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcIShapeProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcIShapeProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOverallWidth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_OverallWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallWidth(double newOverallWidth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_OverallWidth(), newOverallWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOverallWidthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_OverallWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallWidthAsString(String newOverallWidthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_OverallWidthAsString(), newOverallWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOverallDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_OverallDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallDepth(double newOverallDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_OverallDepth(), newOverallDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOverallDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_OverallDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallDepthAsString(String newOverallDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_OverallDepthAsString(), newOverallDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWebThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_WebThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThickness(double newWebThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_WebThickness(), newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_WebThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThicknessAsString(String newWebThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_WebThicknessAsString(), newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeThickness(double newFlangeThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeThickness(), newFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeThicknessAsString(String newFlangeThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeThicknessAsString(), newFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFilletRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadius(double newFilletRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FilletRadius(), newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilletRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadiusAsString(String newFilletRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FilletRadiusAsString(), newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeEdgeRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeEdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeEdgeRadius(double newFlangeEdgeRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeEdgeRadius(), newFlangeEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeEdgeRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeEdgeRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeEdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeEdgeRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeEdgeRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeEdgeRadiusAsString(String newFlangeEdgeRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeEdgeRadiusAsString(), newFlangeEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeEdgeRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeEdgeRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeEdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeSlope() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeSlope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeSlope(double newFlangeSlope) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeSlope(), newFlangeSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeSlope() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeSlope() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeSlopeAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeSlopeAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeSlopeAsString(String newFlangeSlopeAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeSlopeAsString(), newFlangeSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeSlopeAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeSlopeAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcIShapeProfileDef_FlangeSlopeAsString());
	}

} //IfcIShapeProfileDefImpl
