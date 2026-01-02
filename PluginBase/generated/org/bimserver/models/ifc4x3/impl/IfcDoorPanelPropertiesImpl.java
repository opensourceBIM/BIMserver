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
import org.bimserver.models.ifc4x3.IfcDoorPanelOperationEnum;
import org.bimserver.models.ifc4x3.IfcDoorPanelPositionEnum;
import org.bimserver.models.ifc4x3.IfcDoorPanelProperties;
import org.bimserver.models.ifc4x3.IfcShapeAspect;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door Panel Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorPanelPropertiesImpl#getPanelDepth <em>Panel Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorPanelPropertiesImpl#getPanelDepthAsString <em>Panel Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorPanelPropertiesImpl#getPanelOperation <em>Panel Operation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorPanelPropertiesImpl#getPanelWidth <em>Panel Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorPanelPropertiesImpl#getPanelWidthAsString <em>Panel Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorPanelPropertiesImpl#getPanelPosition <em>Panel Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorPanelPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPanelDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelDepth(double newPanelDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelDepth(), newPanelDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPanelDepth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPanelDepth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPanelDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelDepthAsString(String newPanelDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelDepthAsString(), newPanelDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPanelDepthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPanelDepthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorPanelOperationEnum getPanelOperation() {
		return (IfcDoorPanelOperationEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelOperation(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelOperation(IfcDoorPanelOperationEnum newPanelOperation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelOperation(), newPanelOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPanelWidth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelWidth(double newPanelWidth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelWidth(), newPanelWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPanelWidth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPanelWidth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPanelWidthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelWidthAsString(String newPanelWidthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelWidthAsString(), newPanelWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPanelWidthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPanelWidthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorPanelPositionEnum getPanelPosition() {
		return (IfcDoorPanelPositionEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelPosition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPanelPosition(IfcDoorPanelPositionEnum newPanelPosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_PanelPosition(), newPanelPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeAspect getShapeAspectStyle() {
		return (IfcShapeAspect) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_ShapeAspectStyle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_ShapeAspectStyle(), newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShapeAspectStyle() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_ShapeAspectStyle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShapeAspectStyle() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorPanelProperties_ShapeAspectStyle());
	}

} //IfcDoorPanelPropertiesImpl
