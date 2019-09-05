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
import org.bimserver.models.ifc4.IfcRelCoversSpaces;
import org.bimserver.models.ifc4.IfcRelSpaceBoundary;
import org.bimserver.models.ifc4.IfcSpace;
import org.bimserver.models.ifc4.IfcSpaceTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpaceImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpaceImpl#getElevationWithFlooring <em>Elevation With Flooring</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpaceImpl#getElevationWithFlooringAsString <em>Elevation With Flooring As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpaceImpl#getHasCoverings <em>Has Coverings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSpaceImpl#getBoundedBy <em>Bounded By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSpaceImpl extends IfcSpatialStructureElementImpl implements IfcSpace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpaceTypeEnum getPredefinedType() {
		return (IfcSpaceTypeEnum) eGet(Ifc4Package.Literals.IFC_SPACE__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcSpaceTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_SPACE__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_SPACE__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_SPACE__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getElevationWithFlooring() {
		return (Double) eGet(Ifc4Package.Literals.IFC_SPACE__ELEVATION_WITH_FLOORING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationWithFlooring(double newElevationWithFlooring) {
		eSet(Ifc4Package.Literals.IFC_SPACE__ELEVATION_WITH_FLOORING, newElevationWithFlooring);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationWithFlooring() {
		eUnset(Ifc4Package.Literals.IFC_SPACE__ELEVATION_WITH_FLOORING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationWithFlooring() {
		return eIsSet(Ifc4Package.Literals.IFC_SPACE__ELEVATION_WITH_FLOORING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElevationWithFlooringAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_SPACE__ELEVATION_WITH_FLOORING_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElevationWithFlooringAsString(String newElevationWithFlooringAsString) {
		eSet(Ifc4Package.Literals.IFC_SPACE__ELEVATION_WITH_FLOORING_AS_STRING, newElevationWithFlooringAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetElevationWithFlooringAsString() {
		eUnset(Ifc4Package.Literals.IFC_SPACE__ELEVATION_WITH_FLOORING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetElevationWithFlooringAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_SPACE__ELEVATION_WITH_FLOORING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelCoversSpaces> getHasCoverings() {
		return (EList<IfcRelCoversSpaces>) eGet(Ifc4Package.Literals.IFC_SPACE__HAS_COVERINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasCoverings() {
		eUnset(Ifc4Package.Literals.IFC_SPACE__HAS_COVERINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasCoverings() {
		return eIsSet(Ifc4Package.Literals.IFC_SPACE__HAS_COVERINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelSpaceBoundary> getBoundedBy() {
		return (EList<IfcRelSpaceBoundary>) eGet(Ifc4Package.Literals.IFC_SPACE__BOUNDED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBoundedBy() {
		eUnset(Ifc4Package.Literals.IFC_SPACE__BOUNDED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBoundedBy() {
		return eIsSet(Ifc4Package.Literals.IFC_SPACE__BOUNDED_BY);
	}

} //IfcSpaceImpl
