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
import org.bimserver.models.ifc4x3.IfcBendingParameterSelect;
import org.bimserver.models.ifc4x3.IfcReinforcingMeshType;
import org.bimserver.models.ifc4x3.IfcReinforcingMeshTypeEnum;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcing Mesh Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getMeshLength <em>Mesh Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getMeshLengthAsString <em>Mesh Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getMeshWidth <em>Mesh Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getMeshWidthAsString <em>Mesh Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getBendingShapeCode <em>Bending Shape Code</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshTypeImpl#getBendingParameters <em>Bending Parameters</em>}</li>
 * </ul>
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
		return Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingMeshTypeEnum getPredefinedType() {
		return (IfcReinforcingMeshTypeEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_PredefinedType(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcReinforcingMeshTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMeshLength() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshLength(double newMeshLength) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshLength(), newMeshLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMeshLength() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMeshLength() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMeshLengthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshLengthAsString(String newMeshLengthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshLengthAsString(), newMeshLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMeshLengthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMeshLengthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMeshWidth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshWidth(double newMeshWidth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshWidth(), newMeshWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMeshWidth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMeshWidth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMeshWidthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshWidthAsString(String newMeshWidthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshWidthAsString(), newMeshWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMeshWidthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMeshWidthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_MeshWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLongitudinalBarNominalDiameter() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarNominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarNominalDiameter(double newLongitudinalBarNominalDiameter) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarNominalDiameter(),
				newLongitudinalBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarNominalDiameter() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarNominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarNominalDiameter() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarNominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongitudinalBarNominalDiameterAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarNominalDiameterAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarNominalDiameterAsString(String newLongitudinalBarNominalDiameterAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarNominalDiameterAsString(),
				newLongitudinalBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarNominalDiameterAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarNominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarNominalDiameterAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarNominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransverseBarNominalDiameter() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarNominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarNominalDiameter(double newTransverseBarNominalDiameter) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarNominalDiameter(),
				newTransverseBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarNominalDiameter() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarNominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarNominalDiameter() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarNominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransverseBarNominalDiameterAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarNominalDiameterAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarNominalDiameterAsString(String newTransverseBarNominalDiameterAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarNominalDiameterAsString(),
				newTransverseBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarNominalDiameterAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarNominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarNominalDiameterAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarNominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLongitudinalBarCrossSectionArea() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarCrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarCrossSectionArea(double newLongitudinalBarCrossSectionArea) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarCrossSectionArea(),
				newLongitudinalBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarCrossSectionArea() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarCrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarCrossSectionArea() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarCrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongitudinalBarCrossSectionAreaAsString() {
		return (String) eGet(
				Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarCrossSectionAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarCrossSectionAreaAsString(String newLongitudinalBarCrossSectionAreaAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarCrossSectionAreaAsString(),
				newLongitudinalBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarCrossSectionAreaAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarCrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarCrossSectionAreaAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarCrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransverseBarCrossSectionArea() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarCrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarCrossSectionArea(double newTransverseBarCrossSectionArea) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarCrossSectionArea(),
				newTransverseBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarCrossSectionArea() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarCrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarCrossSectionArea() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarCrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransverseBarCrossSectionAreaAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarCrossSectionAreaAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarCrossSectionAreaAsString(String newTransverseBarCrossSectionAreaAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarCrossSectionAreaAsString(),
				newTransverseBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarCrossSectionAreaAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarCrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarCrossSectionAreaAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarCrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLongitudinalBarSpacing() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarSpacing(double newLongitudinalBarSpacing) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarSpacing(), newLongitudinalBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarSpacing() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarSpacing() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongitudinalBarSpacingAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarSpacingAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarSpacingAsString(String newLongitudinalBarSpacingAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarSpacingAsString(),
				newLongitudinalBarSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarSpacingAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarSpacingAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_LongitudinalBarSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransverseBarSpacing() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarSpacing(double newTransverseBarSpacing) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarSpacing(), newTransverseBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarSpacing() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarSpacing() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransverseBarSpacingAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarSpacingAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarSpacingAsString(String newTransverseBarSpacingAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarSpacingAsString(),
				newTransverseBarSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarSpacingAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarSpacingAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_TransverseBarSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBendingShapeCode() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_BendingShapeCode(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBendingShapeCode(String newBendingShapeCode) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_BendingShapeCode(), newBendingShapeCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBendingShapeCode() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_BendingShapeCode());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBendingShapeCode() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_BendingShapeCode());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcBendingParameterSelect> getBendingParameters() {
		return (EList<IfcBendingParameterSelect>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_BendingParameters(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBendingParameters() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_BendingParameters());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBendingParameters() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMeshType_BendingParameters());
	}

} //IfcReinforcingMeshTypeImpl
