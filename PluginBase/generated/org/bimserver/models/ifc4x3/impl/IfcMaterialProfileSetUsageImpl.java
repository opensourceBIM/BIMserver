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
import org.bimserver.models.ifc4x3.IfcMaterialProfileSet;
import org.bimserver.models.ifc4x3.IfcMaterialProfileSetUsage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Profile Set Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialProfileSetUsageImpl#getForProfileSet <em>For Profile Set</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialProfileSetUsageImpl#getCardinalPoint <em>Cardinal Point</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialProfileSetUsageImpl#getReferenceExtent <em>Reference Extent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialProfileSetUsageImpl#getReferenceExtentAsString <em>Reference Extent As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialProfileSetUsageImpl extends IfcMaterialUsageDefinitionImpl
		implements IfcMaterialProfileSetUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialProfileSetUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialProfileSet getForProfileSet() {
		return (IfcMaterialProfileSet) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ForProfileSet(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForProfileSet(IfcMaterialProfileSet newForProfileSet) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ForProfileSet(), newForProfileSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getCardinalPoint() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_CardinalPoint(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCardinalPoint(long newCardinalPoint) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_CardinalPoint(), newCardinalPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCardinalPoint() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_CardinalPoint());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCardinalPoint() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_CardinalPoint());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getReferenceExtent() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ReferenceExtent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceExtent(double newReferenceExtent) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ReferenceExtent(), newReferenceExtent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferenceExtent() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ReferenceExtent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferenceExtent() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ReferenceExtent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReferenceExtentAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ReferenceExtentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceExtentAsString(String newReferenceExtentAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ReferenceExtentAsString(),
				newReferenceExtentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferenceExtentAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ReferenceExtentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferenceExtentAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialProfileSetUsage_ReferenceExtentAsString());
	}

} //IfcMaterialProfileSetUsageImpl
