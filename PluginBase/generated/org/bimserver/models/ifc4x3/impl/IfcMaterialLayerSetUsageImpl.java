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
import org.bimserver.models.ifc4x3.IfcDirectionSenseEnum;
import org.bimserver.models.ifc4x3.IfcLayerSetDirectionEnum;
import org.bimserver.models.ifc4x3.IfcMaterialLayerSet;
import org.bimserver.models.ifc4x3.IfcMaterialLayerSetUsage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer Set Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetUsageImpl#getForLayerSet <em>For Layer Set</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetUsageImpl#getLayerSetDirection <em>Layer Set Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetUsageImpl#getDirectionSense <em>Direction Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetUsageImpl#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetUsageImpl#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetUsageImpl#getReferenceExtent <em>Reference Extent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcMaterialLayerSetUsageImpl#getReferenceExtentAsString <em>Reference Extent As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMaterialLayerSetUsageImpl extends IfcMaterialUsageDefinitionImpl implements IfcMaterialLayerSetUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialLayerSetUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialLayerSet getForLayerSet() {
		return (IfcMaterialLayerSet) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ForLayerSet(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForLayerSet(IfcMaterialLayerSet newForLayerSet) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ForLayerSet(), newForLayerSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLayerSetDirectionEnum getLayerSetDirection() {
		return (IfcLayerSetDirectionEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_LayerSetDirection(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayerSetDirection(IfcLayerSetDirectionEnum newLayerSetDirection) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_LayerSetDirection(), newLayerSetDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirectionSenseEnum getDirectionSense() {
		return (IfcDirectionSenseEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_DirectionSense(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDirectionSense(IfcDirectionSenseEnum newDirectionSense) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_DirectionSense(), newDirectionSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOffsetFromReferenceLine() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_OffsetFromReferenceLine(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetFromReferenceLine(double newOffsetFromReferenceLine) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_OffsetFromReferenceLine(), newOffsetFromReferenceLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOffsetFromReferenceLineAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_OffsetFromReferenceLineAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetFromReferenceLineAsString(String newOffsetFromReferenceLineAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_OffsetFromReferenceLineAsString(),
				newOffsetFromReferenceLineAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getReferenceExtent() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ReferenceExtent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceExtent(double newReferenceExtent) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ReferenceExtent(), newReferenceExtent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferenceExtent() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ReferenceExtent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferenceExtent() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ReferenceExtent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReferenceExtentAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ReferenceExtentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceExtentAsString(String newReferenceExtentAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ReferenceExtentAsString(), newReferenceExtentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferenceExtentAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ReferenceExtentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferenceExtentAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ReferenceExtentAsString());
	}

} //IfcMaterialLayerSetUsageImpl
