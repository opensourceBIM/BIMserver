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
import org.bimserver.models.ifc4x3.IfcReinforcingMesh;
import org.bimserver.models.ifc4x3.IfcReinforcingMeshTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcing Mesh</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getMeshLength <em>Mesh Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getMeshLengthAsString <em>Mesh Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getMeshWidth <em>Mesh Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getMeshWidthAsString <em>Mesh Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingMeshImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcReinforcingMeshImpl extends IfcReinforcingElementImpl implements IfcReinforcingMesh {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReinforcingMeshImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMeshLength() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshLength(double newMeshLength) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLength(), newMeshLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMeshLength() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMeshLength() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMeshLengthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshLengthAsString(String newMeshLengthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLengthAsString(), newMeshLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMeshLengthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMeshLengthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMeshWidth() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshWidth(double newMeshWidth) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidth(), newMeshWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMeshWidth() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMeshWidth() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMeshWidthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshWidthAsString(String newMeshWidthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidthAsString(), newMeshWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMeshWidthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMeshWidthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLongitudinalBarNominalDiameter() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarNominalDiameter(double newLongitudinalBarNominalDiameter) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameter(),
				newLongitudinalBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarNominalDiameter() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarNominalDiameter() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongitudinalBarNominalDiameterAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameterAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarNominalDiameterAsString(String newLongitudinalBarNominalDiameterAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameterAsString(),
				newLongitudinalBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarNominalDiameterAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarNominalDiameterAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransverseBarNominalDiameter() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarNominalDiameter(double newTransverseBarNominalDiameter) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameter(),
				newTransverseBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarNominalDiameter() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarNominalDiameter() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransverseBarNominalDiameterAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameterAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarNominalDiameterAsString(String newTransverseBarNominalDiameterAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameterAsString(),
				newTransverseBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarNominalDiameterAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarNominalDiameterAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLongitudinalBarCrossSectionArea() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarCrossSectionArea(double newLongitudinalBarCrossSectionArea) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionArea(),
				newLongitudinalBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarCrossSectionArea() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarCrossSectionArea() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongitudinalBarCrossSectionAreaAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionAreaAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarCrossSectionAreaAsString(String newLongitudinalBarCrossSectionAreaAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionAreaAsString(),
				newLongitudinalBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarCrossSectionAreaAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarCrossSectionAreaAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransverseBarCrossSectionArea() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarCrossSectionArea(double newTransverseBarCrossSectionArea) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionArea(),
				newTransverseBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarCrossSectionArea() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarCrossSectionArea() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransverseBarCrossSectionAreaAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionAreaAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarCrossSectionAreaAsString(String newTransverseBarCrossSectionAreaAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionAreaAsString(),
				newTransverseBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarCrossSectionAreaAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarCrossSectionAreaAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLongitudinalBarSpacing() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarSpacing(double newLongitudinalBarSpacing) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacing(), newLongitudinalBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarSpacing() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarSpacing() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLongitudinalBarSpacingAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacingAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLongitudinalBarSpacingAsString(String newLongitudinalBarSpacingAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacingAsString(),
				newLongitudinalBarSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLongitudinalBarSpacingAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLongitudinalBarSpacingAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTransverseBarSpacing() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarSpacing(double newTransverseBarSpacing) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacing(), newTransverseBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarSpacing() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarSpacing() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTransverseBarSpacingAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacingAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransverseBarSpacingAsString(String newTransverseBarSpacingAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacingAsString(),
				newTransverseBarSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTransverseBarSpacingAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTransverseBarSpacingAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingMeshTypeEnum getPredefinedType() {
		return (IfcReinforcingMeshTypeEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcReinforcingMeshTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_PredefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingMesh_PredefinedType());
	}

} //IfcReinforcingMeshImpl
