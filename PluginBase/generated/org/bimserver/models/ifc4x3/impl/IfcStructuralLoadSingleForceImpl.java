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
import org.bimserver.models.ifc4x3.IfcStructuralLoadSingleForce;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Force</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getForceX <em>Force X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getForceXAsString <em>Force XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getForceY <em>Force Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getForceYAsString <em>Force YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getForceZ <em>Force Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getForceZAsString <em>Force ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getMomentX <em>Moment X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getMomentXAsString <em>Moment XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getMomentY <em>Moment Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getMomentYAsString <em>Moment YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getMomentZ <em>Moment Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleForceImpl#getMomentZAsString <em>Moment ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadSingleForceImpl extends IfcStructuralLoadStaticImpl
		implements IfcStructuralLoadSingleForce {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleForceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getForceX() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForceX(double newForceX) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceX(), newForceX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetForceX() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetForceX() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getForceXAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForceXAsString(String newForceXAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceXAsString(), newForceXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetForceXAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetForceXAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getForceY() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForceY(double newForceY) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceY(), newForceY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetForceY() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetForceY() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getForceYAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForceYAsString(String newForceYAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceYAsString(), newForceYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetForceYAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetForceYAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getForceZ() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForceZ(double newForceZ) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceZ(), newForceZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetForceZ() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetForceZ() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getForceZAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForceZAsString(String newForceZAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceZAsString(), newForceZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetForceZAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetForceZAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_ForceZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMomentX() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMomentX(double newMomentX) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentX(), newMomentX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMomentX() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMomentX() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMomentXAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMomentXAsString(String newMomentXAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentXAsString(), newMomentXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMomentXAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMomentXAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMomentY() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMomentY(double newMomentY) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentY(), newMomentY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMomentY() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMomentY() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMomentYAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMomentYAsString(String newMomentYAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentYAsString(), newMomentYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMomentYAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMomentYAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMomentZ() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMomentZ(double newMomentZ) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentZ(), newMomentZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMomentZ() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMomentZ() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMomentZAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMomentZAsString(String newMomentZAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentZAsString(), newMomentZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMomentZAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMomentZAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleForce_MomentZAsString());
	}

} //IfcStructuralLoadSingleForceImpl
