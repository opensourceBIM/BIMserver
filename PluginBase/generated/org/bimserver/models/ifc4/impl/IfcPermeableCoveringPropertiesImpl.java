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
import org.bimserver.models.ifc4.IfcPermeableCoveringOperationEnum;
import org.bimserver.models.ifc4.IfcPermeableCoveringProperties;
import org.bimserver.models.ifc4.IfcShapeAspect;
import org.bimserver.models.ifc4.IfcWindowPanelPositionEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Permeable Covering Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPermeableCoveringPropertiesImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPermeableCoveringPropertiesImpl#getPanelPosition <em>Panel Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPermeableCoveringPropertiesImpl#getFrameDepth <em>Frame Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPermeableCoveringPropertiesImpl#getFrameDepthAsString <em>Frame Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPermeableCoveringPropertiesImpl#getFrameThickness <em>Frame Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPermeableCoveringPropertiesImpl#getFrameThicknessAsString <em>Frame Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPermeableCoveringPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPermeableCoveringPropertiesImpl extends IfcPreDefinedPropertySetImpl implements IfcPermeableCoveringProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPermeableCoveringPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPermeableCoveringOperationEnum getOperationType() {
		return (IfcPermeableCoveringOperationEnum) eGet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__OPERATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationType(IfcPermeableCoveringOperationEnum newOperationType) {
		eSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__OPERATION_TYPE, newOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowPanelPositionEnum getPanelPosition() {
		return (IfcWindowPanelPositionEnum) eGet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__PANEL_POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelPosition(IfcWindowPanelPositionEnum newPanelPosition) {
		eSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__PANEL_POSITION, newPanelPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFrameDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameDepth(double newFrameDepth) {
		eSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_DEPTH, newFrameDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFrameDepth() {
		eUnset(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFrameDepth() {
		return eIsSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFrameDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameDepthAsString(String newFrameDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_DEPTH_AS_STRING, newFrameDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFrameDepthAsString() {
		eUnset(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFrameDepthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFrameThickness() {
		return (Double) eGet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameThickness(double newFrameThickness) {
		eSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_THICKNESS, newFrameThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFrameThickness() {
		eUnset(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFrameThickness() {
		return eIsSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFrameThicknessAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameThicknessAsString(String newFrameThicknessAsString) {
		eSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_THICKNESS_AS_STRING, newFrameThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFrameThicknessAsString() {
		eUnset(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFrameThicknessAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__FRAME_THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeAspect getShapeAspectStyle() {
		return (IfcShapeAspect) eGet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__SHAPE_ASPECT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle) {
		eSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__SHAPE_ASPECT_STYLE, newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShapeAspectStyle() {
		eUnset(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShapeAspectStyle() {
		return eIsSet(Ifc4Package.Literals.IFC_PERMEABLE_COVERING_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

} //IfcPermeableCoveringPropertiesImpl
