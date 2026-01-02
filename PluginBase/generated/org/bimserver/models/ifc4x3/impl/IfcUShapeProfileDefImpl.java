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
import org.bimserver.models.ifc4x3.IfcUShapeProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc UShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getFlangeWidth <em>Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getFlangeWidthAsString <em>Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getEdgeRadius <em>Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getEdgeRadiusAsString <em>Edge Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getFlangeSlope <em>Flange Slope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcUShapeProfileDefImpl#getFlangeSlopeAsString <em>Flange Slope As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcUShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcUShapeProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcUShapeProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_Depth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepth(double newDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_Depth(), newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_DepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthAsString(String newDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_DepthAsString(), newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeWidth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeWidth(double newFlangeWidth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeWidth(), newFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeWidthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeWidthAsString(String newFlangeWidthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeWidthAsString(), newFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWebThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_WebThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThickness(double newWebThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_WebThickness(), newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_WebThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThicknessAsString(String newWebThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_WebThicknessAsString(), newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeThickness(double newFlangeThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeThickness(), newFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeThicknessAsString(String newFlangeThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeThicknessAsString(), newFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFilletRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadius(double newFilletRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FilletRadius(), newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilletRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadiusAsString(String newFilletRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FilletRadiusAsString(), newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEdgeRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_EdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdgeRadius(double newEdgeRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_EdgeRadius(), newEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEdgeRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_EdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEdgeRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_EdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEdgeRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_EdgeRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdgeRadiusAsString(String newEdgeRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_EdgeRadiusAsString(), newEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEdgeRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_EdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEdgeRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_EdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeSlope() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeSlope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeSlope(double newFlangeSlope) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeSlope(), newFlangeSlope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeSlope() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeSlope() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeSlope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeSlopeAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeSlopeAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeSlopeAsString(String newFlangeSlopeAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeSlopeAsString(), newFlangeSlopeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFlangeSlopeAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeSlopeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFlangeSlopeAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcUShapeProfileDef_FlangeSlopeAsString());
	}

} //IfcUShapeProfileDefImpl
