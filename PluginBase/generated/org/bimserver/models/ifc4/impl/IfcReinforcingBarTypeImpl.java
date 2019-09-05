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
import org.bimserver.models.ifc4.IfcBendingParameterSelect;
import org.bimserver.models.ifc4.IfcReinforcingBarSurfaceEnum;
import org.bimserver.models.ifc4.IfcReinforcingBarType;
import org.bimserver.models.ifc4.IfcReinforcingBarTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcing Bar Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getBarLength <em>Bar Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getBarLengthAsString <em>Bar Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getBarSurface <em>Bar Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getBendingShapeCode <em>Bending Shape Code</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcReinforcingBarTypeImpl#getBendingParameters <em>Bending Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcReinforcingBarTypeImpl extends IfcReinforcingElementTypeImpl implements IfcReinforcingBarType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReinforcingBarTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBarTypeEnum getPredefinedType() {
		return (IfcReinforcingBarTypeEnum) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcReinforcingBarTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getNominalDiameter() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__NOMINAL_DIAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominalDiameter(double newNominalDiameter) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__NOMINAL_DIAMETER, newNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominalDiameter() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__NOMINAL_DIAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominalDiameter() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__NOMINAL_DIAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNominalDiameterAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__NOMINAL_DIAMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominalDiameterAsString(String newNominalDiameterAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__NOMINAL_DIAMETER_AS_STRING, newNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominalDiameterAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__NOMINAL_DIAMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominalDiameterAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__NOMINAL_DIAMETER_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCrossSectionArea() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__CROSS_SECTION_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCrossSectionArea(double newCrossSectionArea) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__CROSS_SECTION_AREA, newCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCrossSectionArea() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__CROSS_SECTION_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCrossSectionArea() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__CROSS_SECTION_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCrossSectionAreaAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__CROSS_SECTION_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCrossSectionAreaAsString(String newCrossSectionAreaAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__CROSS_SECTION_AREA_AS_STRING, newCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCrossSectionAreaAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__CROSS_SECTION_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCrossSectionAreaAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__CROSS_SECTION_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBarLength() {
		return (Double) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarLength(double newBarLength) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_LENGTH, newBarLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarLength() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarLength() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBarLengthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarLengthAsString(String newBarLengthAsString) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_LENGTH_AS_STRING, newBarLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarLengthAsString() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarLengthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBarSurfaceEnum getBarSurface() {
		return (IfcReinforcingBarSurfaceEnum) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarSurface(IfcReinforcingBarSurfaceEnum newBarSurface) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_SURFACE, newBarSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarSurface() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_SURFACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarSurface() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BAR_SURFACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBendingShapeCode() {
		return (String) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BENDING_SHAPE_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBendingShapeCode(String newBendingShapeCode) {
		eSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BENDING_SHAPE_CODE, newBendingShapeCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBendingShapeCode() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BENDING_SHAPE_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBendingShapeCode() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BENDING_SHAPE_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcBendingParameterSelect> getBendingParameters() {
		return (EList<IfcBendingParameterSelect>) eGet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BENDING_PARAMETERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBendingParameters() {
		eUnset(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BENDING_PARAMETERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBendingParameters() {
		return eIsSet(Ifc4Package.Literals.IFC_REINFORCING_BAR_TYPE__BENDING_PARAMETERS);
	}

} //IfcReinforcingBarTypeImpl
