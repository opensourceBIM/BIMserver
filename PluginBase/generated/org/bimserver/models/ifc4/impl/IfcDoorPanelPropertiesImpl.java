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
import org.bimserver.models.ifc4.IfcDoorPanelOperationEnum;
import org.bimserver.models.ifc4.IfcDoorPanelPositionEnum;
import org.bimserver.models.ifc4.IfcDoorPanelProperties;
import org.bimserver.models.ifc4.IfcShapeAspect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door Panel Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorPanelPropertiesImpl#getPanelDepth <em>Panel Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorPanelPropertiesImpl#getPanelDepthAsString <em>Panel Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorPanelPropertiesImpl#getPanelOperation <em>Panel Operation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorPanelPropertiesImpl#getPanelWidth <em>Panel Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorPanelPropertiesImpl#getPanelWidthAsString <em>Panel Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorPanelPropertiesImpl#getPanelPosition <em>Panel Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorPanelPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDoorPanelPropertiesImpl extends IfcPreDefinedPropertySetImpl implements IfcDoorPanelProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDoorPanelPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPanelDepth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_DEPTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelDepth(double newPanelDepth) {
		eSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_DEPTH, newPanelDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPanelDepth() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPanelDepth() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_DEPTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPanelDepthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_DEPTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelDepthAsString(String newPanelDepthAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_DEPTH_AS_STRING, newPanelDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPanelDepthAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPanelDepthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_DEPTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorPanelOperationEnum getPanelOperation() {
		return (IfcDoorPanelOperationEnum) eGet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_OPERATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelOperation(IfcDoorPanelOperationEnum newPanelOperation) {
		eSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_OPERATION, newPanelOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPanelWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelWidth(double newPanelWidth) {
		eSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_WIDTH, newPanelWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPanelWidth() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPanelWidth() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPanelWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelWidthAsString(String newPanelWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_WIDTH_AS_STRING, newPanelWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPanelWidthAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPanelWidthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorPanelPositionEnum getPanelPosition() {
		return (IfcDoorPanelPositionEnum) eGet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelPosition(IfcDoorPanelPositionEnum newPanelPosition) {
		eSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__PANEL_POSITION, newPanelPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeAspect getShapeAspectStyle() {
		return (IfcShapeAspect) eGet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__SHAPE_ASPECT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle) {
		eSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__SHAPE_ASPECT_STYLE, newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShapeAspectStyle() {
		eUnset(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShapeAspectStyle() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR_PANEL_PROPERTIES__SHAPE_ASPECT_STYLE);
	}

} //IfcDoorPanelPropertiesImpl
