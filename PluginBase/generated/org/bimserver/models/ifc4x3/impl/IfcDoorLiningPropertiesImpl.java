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
import org.bimserver.models.ifc4x3.IfcDoorLiningProperties;
import org.bimserver.models.ifc4x3.IfcShapeAspect;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door Lining Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningDepth <em>Lining Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningDepthAsString <em>Lining Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningThickness <em>Lining Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningThicknessAsString <em>Lining Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getThresholdDepth <em>Threshold Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getThresholdDepthAsString <em>Threshold Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getThresholdThickness <em>Threshold Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getThresholdThicknessAsString <em>Threshold Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getTransomThickness <em>Transom Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getTransomThicknessAsString <em>Transom Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getTransomOffset <em>Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getTransomOffsetAsString <em>Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningOffset <em>Lining Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningOffsetAsString <em>Lining Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getThresholdOffset <em>Threshold Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getThresholdOffsetAsString <em>Threshold Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getCasingThickness <em>Casing Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getCasingThicknessAsString <em>Casing Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getCasingDepth <em>Casing Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getCasingDepthAsString <em>Casing Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningToPanelOffsetX <em>Lining To Panel Offset X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningToPanelOffsetXAsString <em>Lining To Panel Offset XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningToPanelOffsetY <em>Lining To Panel Offset Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorLiningPropertiesImpl#getLiningToPanelOffsetYAsString <em>Lining To Panel Offset YAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDoorLiningPropertiesImpl extends IfcPreDefinedPropertySetImpl implements IfcDoorLiningProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDoorLiningPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningDepth(double newLiningDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepth(), newLiningDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningDepth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningDepth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningDepthAsString(String newLiningDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepthAsString(), newLiningDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningDepthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningDepthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningThickness(double newLiningThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThickness(), newLiningThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningThickness() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningThickness() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningThicknessAsString(String newLiningThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThicknessAsString(), newLiningThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningThicknessAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningThicknessAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getThresholdDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdDepth(double newThresholdDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepth(), newThresholdDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdDepth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdDepth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThresholdDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdDepthAsString(String newThresholdDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepthAsString(), newThresholdDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdDepthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdDepthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getThresholdThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdThickness(double newThresholdThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThickness(), newThresholdThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdThickness() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdThickness() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThresholdThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdThicknessAsString(String newThresholdThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThicknessAsString(),
				newThresholdThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdThicknessAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdThicknessAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransomThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomThickness(double newTransomThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThickness(), newTransomThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomThickness() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomThickness() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransomThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomThicknessAsString(String newTransomThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThicknessAsString(),
				newTransomThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomThicknessAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomThicknessAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransomOffset() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomOffset(double newTransomOffset) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffset(), newTransomOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomOffset() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomOffset() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransomOffsetAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransomOffsetAsString(String newTransomOffsetAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffsetAsString(), newTransomOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransomOffsetAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransomOffsetAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningOffset() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningOffset(double newLiningOffset) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffset(), newLiningOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningOffset() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningOffset() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningOffsetAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningOffsetAsString(String newLiningOffsetAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffsetAsString(), newLiningOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningOffsetAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningOffsetAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getThresholdOffset() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdOffset(double newThresholdOffset) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffset(), newThresholdOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdOffset() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdOffset() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThresholdOffsetAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThresholdOffsetAsString(String newThresholdOffsetAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffsetAsString(), newThresholdOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThresholdOffsetAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThresholdOffsetAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCasingThickness() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCasingThickness(double newCasingThickness) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThickness(), newCasingThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCasingThickness() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCasingThickness() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCasingThicknessAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCasingThicknessAsString(String newCasingThicknessAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThicknessAsString(), newCasingThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCasingThicknessAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCasingThicknessAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCasingDepth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCasingDepth(double newCasingDepth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepth(), newCasingDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCasingDepth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCasingDepth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCasingDepthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCasingDepthAsString(String newCasingDepthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepthAsString(), newCasingDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCasingDepthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCasingDepthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeAspect getShapeAspectStyle() {
		return (IfcShapeAspect) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ShapeAspectStyle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ShapeAspectStyle(), newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShapeAspectStyle() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ShapeAspectStyle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShapeAspectStyle() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_ShapeAspectStyle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningToPanelOffsetX() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetX(double newLiningToPanelOffsetX) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetX(), newLiningToPanelOffsetX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetX() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetX() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningToPanelOffsetXAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetXAsString(String newLiningToPanelOffsetXAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetXAsString(),
				newLiningToPanelOffsetXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetXAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetXAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLiningToPanelOffsetY() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetY(double newLiningToPanelOffsetY) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetY(), newLiningToPanelOffsetY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetY() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetY() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiningToPanelOffsetYAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLiningToPanelOffsetYAsString(String newLiningToPanelOffsetYAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetYAsString(),
				newLiningToPanelOffsetYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLiningToPanelOffsetYAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLiningToPanelOffsetYAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningToPanelOffsetYAsString());
	}

} //IfcDoorLiningPropertiesImpl
