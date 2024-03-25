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
import org.bimserver.models.ifc4x3.IfcAlignmentCant;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Alignment Cant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantImpl#getRailHeadDistance <em>Rail Head Distance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantImpl#getRailHeadDistanceAsString <em>Rail Head Distance As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAlignmentCantImpl extends IfcLinearElementImpl implements IfcAlignmentCant {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAlignmentCantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRailHeadDistance() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT__RAIL_HEAD_DISTANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRailHeadDistance(double newRailHeadDistance) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT__RAIL_HEAD_DISTANCE, newRailHeadDistance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRailHeadDistanceAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT__RAIL_HEAD_DISTANCE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRailHeadDistanceAsString(String newRailHeadDistanceAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT__RAIL_HEAD_DISTANCE_AS_STRING, newRailHeadDistanceAsString);
	}

} //IfcAlignmentCantImpl
