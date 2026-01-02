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
import org.bimserver.models.ifc4x3.IfcShapeAspect;
import org.bimserver.models.ifc4x3.IfcWindowPanelOperationEnum;
import org.bimserver.models.ifc4x3.IfcWindowPanelPositionEnum;
import org.bimserver.models.ifc4x3.IfcWindowPanelProperties;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Window Panel Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWindowPanelPropertiesImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWindowPanelPropertiesImpl#getPanelPosition <em>Panel Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWindowPanelPropertiesImpl#getFrameDepth <em>Frame Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWindowPanelPropertiesImpl#getFrameDepthAsString <em>Frame Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWindowPanelPropertiesImpl#getFrameThickness <em>Frame Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWindowPanelPropertiesImpl#getFrameThicknessAsString <em>Frame Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWindowPanelPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcWindowPanelPropertiesImpl extends IfcPreDefinedPropertySetImpl implements IfcWindowPanelProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWindowPanelPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowPanelOperationEnum getOperationType() {
		return (IfcWindowPanelOperationEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_OperationType(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationType(IfcWindowPanelOperationEnum newOperationType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_OperationType(), newOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowPanelPositionEnum getPanelPosition() {
		return (IfcWindowPanelPositionEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_PanelPosition(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelPosition(IfcWindowPanelPositionEnum newPanelPosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_PanelPosition(), newPanelPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFrameDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameDepth(double newFrameDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameDepth(), newFrameDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFrameDepth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFrameDepth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFrameDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameDepthAsString(String newFrameDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameDepthAsString(), newFrameDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFrameDepthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFrameDepthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFrameThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameThickness(double newFrameThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameThickness(), newFrameThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFrameThickness() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFrameThickness() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFrameThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameThicknessAsString(String newFrameThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameThicknessAsString(), newFrameThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFrameThicknessAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFrameThicknessAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_FrameThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeAspect getShapeAspectStyle() {
		return (IfcShapeAspect) eGet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_ShapeAspectStyle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_ShapeAspectStyle(), newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShapeAspectStyle() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_ShapeAspectStyle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShapeAspectStyle() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcWindowPanelProperties_ShapeAspectStyle());
	}

} //IfcWindowPanelPropertiesImpl
