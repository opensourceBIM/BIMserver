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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcBendingParameterSelect;
import org.bimserver.models.ifc4.IfcReinforcingMeshType;
import org.bimserver.models.ifc4.IfcReinforcingMeshTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcing Mesh Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getMeshLength <em>Mesh Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getMeshLengthAsString <em>Mesh Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getMeshWidth <em>Mesh Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getMeshWidthAsString <em>Mesh Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getBendingShapeCode <em>Bending Shape Code</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingMeshTypeImpl#getBendingParameters <em>Bending Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcReinforcingMeshTypeImpl extends IfcReinforcingElementTypeImpl implements IfcReinforcingMeshType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReinforcingMeshTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingMeshTypeEnum getPredefinedType() {
		return (IfcReinforcingMeshTypeEnum) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcReinforcingMeshTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMeshLength() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshLength(double newMeshLength) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_LENGTH, newMeshLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshLength() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshLength() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeshLengthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshLengthAsString(String newMeshLengthAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_LENGTH_AS_STRING, newMeshLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshLengthAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshLengthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMeshWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshWidth(double newMeshWidth) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_WIDTH, newMeshWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshWidth() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshWidth() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeshWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshWidthAsString(String newMeshWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_WIDTH_AS_STRING, newMeshWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshWidthAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshWidthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__MESH_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitudinalBarNominalDiameter() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_NOMINAL_DIAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarNominalDiameter(double newLongitudinalBarNominalDiameter) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_NOMINAL_DIAMETER, newLongitudinalBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongitudinalBarNominalDiameter() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_NOMINAL_DIAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongitudinalBarNominalDiameter() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_NOMINAL_DIAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarNominalDiameterAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_NOMINAL_DIAMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarNominalDiameterAsString(String newLongitudinalBarNominalDiameterAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_NOMINAL_DIAMETER_AS_STRING, newLongitudinalBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongitudinalBarNominalDiameterAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_NOMINAL_DIAMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongitudinalBarNominalDiameterAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_NOMINAL_DIAMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransverseBarNominalDiameter() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_NOMINAL_DIAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarNominalDiameter(double newTransverseBarNominalDiameter) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_NOMINAL_DIAMETER, newTransverseBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransverseBarNominalDiameter() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_NOMINAL_DIAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransverseBarNominalDiameter() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_NOMINAL_DIAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarNominalDiameterAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_NOMINAL_DIAMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarNominalDiameterAsString(String newTransverseBarNominalDiameterAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_NOMINAL_DIAMETER_AS_STRING, newTransverseBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransverseBarNominalDiameterAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_NOMINAL_DIAMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransverseBarNominalDiameterAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_NOMINAL_DIAMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitudinalBarCrossSectionArea() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_CROSS_SECTION_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarCrossSectionArea(double newLongitudinalBarCrossSectionArea) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_CROSS_SECTION_AREA, newLongitudinalBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongitudinalBarCrossSectionArea() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_CROSS_SECTION_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongitudinalBarCrossSectionArea() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_CROSS_SECTION_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarCrossSectionAreaAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_CROSS_SECTION_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarCrossSectionAreaAsString(String newLongitudinalBarCrossSectionAreaAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_CROSS_SECTION_AREA_AS_STRING, newLongitudinalBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongitudinalBarCrossSectionAreaAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_CROSS_SECTION_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongitudinalBarCrossSectionAreaAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_CROSS_SECTION_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransverseBarCrossSectionArea() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_CROSS_SECTION_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarCrossSectionArea(double newTransverseBarCrossSectionArea) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_CROSS_SECTION_AREA, newTransverseBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransverseBarCrossSectionArea() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_CROSS_SECTION_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransverseBarCrossSectionArea() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_CROSS_SECTION_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarCrossSectionAreaAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_CROSS_SECTION_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarCrossSectionAreaAsString(String newTransverseBarCrossSectionAreaAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_CROSS_SECTION_AREA_AS_STRING, newTransverseBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransverseBarCrossSectionAreaAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_CROSS_SECTION_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransverseBarCrossSectionAreaAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_CROSS_SECTION_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitudinalBarSpacing() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarSpacing(double newLongitudinalBarSpacing) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_SPACING, newLongitudinalBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongitudinalBarSpacing() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongitudinalBarSpacing() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarSpacingAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_SPACING_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarSpacingAsString(String newLongitudinalBarSpacingAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_SPACING_AS_STRING, newLongitudinalBarSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongitudinalBarSpacingAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_SPACING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongitudinalBarSpacingAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__LONGITUDINAL_BAR_SPACING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransverseBarSpacing() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarSpacing(double newTransverseBarSpacing) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_SPACING, newTransverseBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransverseBarSpacing() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransverseBarSpacing() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarSpacingAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_SPACING_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarSpacingAsString(String newTransverseBarSpacingAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_SPACING_AS_STRING, newTransverseBarSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransverseBarSpacingAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_SPACING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransverseBarSpacingAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__TRANSVERSE_BAR_SPACING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBendingShapeCode() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__BENDING_SHAPE_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBendingShapeCode(String newBendingShapeCode) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__BENDING_SHAPE_CODE, newBendingShapeCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBendingShapeCode() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__BENDING_SHAPE_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBendingShapeCode() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__BENDING_SHAPE_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcBendingParameterSelect> getBendingParameters() {
		return (EList<IfcBendingParameterSelect>) eGet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__BENDING_PARAMETERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBendingParameters() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__BENDING_PARAMETERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBendingParameters() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_MESH_TYPE__BENDING_PARAMETERS);
	}

} //IfcReinforcingMeshTypeImpl
