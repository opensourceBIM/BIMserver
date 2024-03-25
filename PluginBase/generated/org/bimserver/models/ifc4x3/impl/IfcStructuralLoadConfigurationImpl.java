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
import org.bimserver.models.ifc4x3.IfcStructuralLoadConfiguration;
import org.bimserver.models.ifc4x3.IfcStructuralLoadOrResult;
import org.bimserver.models.ifc4x3.ListOfIfcLengthMeasure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadConfigurationImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadConfigurationImpl#getLocations <em>Locations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadConfigurationImpl extends IfcStructuralLoadImpl
		implements IfcStructuralLoadConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcStructuralLoadOrResult> getValues() {
		return (EList<IfcStructuralLoadOrResult>) eGet(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_CONFIGURATION__VALUES,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ListOfIfcLengthMeasure> getLocations() {
		return (EList<ListOfIfcLengthMeasure>) eGet(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_CONFIGURATION__LOCATIONS,
				true);
	}

} //IfcStructuralLoadConfigurationImpl
