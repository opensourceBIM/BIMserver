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
import org.bimserver.models.ifc4.IfcSurfaceReinforcementArea;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Reinforcement Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceReinforcementAreaImpl#getSurfaceReinforcement1 <em>Surface Reinforcement1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceReinforcementAreaImpl#getSurfaceReinforcement1AsString <em>Surface Reinforcement1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceReinforcementAreaImpl#getSurfaceReinforcement2 <em>Surface Reinforcement2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceReinforcementAreaImpl#getSurfaceReinforcement2AsString <em>Surface Reinforcement2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceReinforcementAreaImpl#getShearReinforcement <em>Shear Reinforcement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcSurfaceReinforcementAreaImpl#getShearReinforcementAsString <em>Shear Reinforcement As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSurfaceReinforcementAreaImpl extends IfcStructuralLoadOrResultImpl implements IfcSurfaceReinforcementArea {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceReinforcementAreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getSurfaceReinforcement1() {
		return (EList<Double>) eGet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSurfaceReinforcement1() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSurfaceReinforcement1() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getSurfaceReinforcement1AsString() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT1_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSurfaceReinforcement1AsString() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT1_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSurfaceReinforcement1AsString() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT1_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getSurfaceReinforcement2() {
		return (EList<Double>) eGet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSurfaceReinforcement2() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSurfaceReinforcement2() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getSurfaceReinforcement2AsString() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSurfaceReinforcement2AsString() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT2_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSurfaceReinforcement2AsString() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SURFACE_REINFORCEMENT2_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getShearReinforcement() {
		return (Double) eGet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SHEAR_REINFORCEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShearReinforcement(double newShearReinforcement) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SHEAR_REINFORCEMENT, newShearReinforcement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShearReinforcement() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SHEAR_REINFORCEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShearReinforcement() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SHEAR_REINFORCEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getShearReinforcementAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SHEAR_REINFORCEMENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShearReinforcementAsString(String newShearReinforcementAsString) {
		eSet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SHEAR_REINFORCEMENT_AS_STRING, newShearReinforcementAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetShearReinforcementAsString() {
		eUnset(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SHEAR_REINFORCEMENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetShearReinforcementAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_SURFACE_REINFORCEMENT_AREA__SHEAR_REINFORCEMENT_AS_STRING);
	}

} //IfcSurfaceReinforcementAreaImpl
