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
import org.bimserver.models.ifc4x3.IfcZShapeProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc ZShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getDepthAsString <em>Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getFlangeWidth <em>Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getFlangeWidthAsString <em>Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getWebThickness <em>Web Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getWebThicknessAsString <em>Web Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getFlangeThickness <em>Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getFlangeThicknessAsString <em>Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getFilletRadius <em>Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getFilletRadiusAsString <em>Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getEdgeRadius <em>Edge Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcZShapeProfileDefImpl#getEdgeRadiusAsString <em>Edge Radius As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcZShapeProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcZShapeProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcZShapeProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_Depth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepth(double newDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_Depth(), newDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_DepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthAsString(String newDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_DepthAsString(), newDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeWidth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeWidth(double newFlangeWidth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeWidth(), newFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeWidthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeWidthAsString(String newFlangeWidthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeWidthAsString(), newFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWebThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_WebThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThickness(double newWebThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_WebThickness(), newWebThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_WebThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebThicknessAsString(String newWebThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_WebThicknessAsString(), newWebThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFlangeThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeThickness(double newFlangeThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeThickness(), newFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFlangeThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlangeThicknessAsString(String newFlangeThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FlangeThicknessAsString(), newFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFilletRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadius(double newFilletRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadius(), newFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilletRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilletRadiusAsString(String newFilletRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadiusAsString(), newFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFilletRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFilletRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_FilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEdgeRadius() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdgeRadius(double newEdgeRadius) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadius(), newEdgeRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEdgeRadius() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEdgeRadius() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEdgeRadiusAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdgeRadiusAsString(String newEdgeRadiusAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadiusAsString(), newEdgeRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEdgeRadiusAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEdgeRadiusAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcZShapeProfileDef_EdgeRadiusAsString());
	}

} //IfcZShapeProfileDefImpl
