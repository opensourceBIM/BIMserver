/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDirectionSenseEnum;
import org.bimserver.models.ifc2x3.IfcLayerSetDirectionEnum;
import org.bimserver.models.ifc2x3.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3.IfcMaterialLayerSetUsage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer Set Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetUsageImpl#getForLayerSet <em>For Layer Set</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetUsageImpl#getLayerSetDirection <em>Layer Set Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetUsageImpl#getDirectionSense <em>Direction Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetUsageImpl#getOffsetFromReferenceLine <em>Offset From Reference Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetUsageImpl#getOffsetFromReferenceLineAsString <em>Offset From Reference Line As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMaterialLayerSetUsageImpl extends IdEObjectImpl implements IfcMaterialLayerSetUsage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialLayerSetUsageImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialLayerSet getForLayerSet()
	{
		return (IfcMaterialLayerSet)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ForLayerSet(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForLayerSet(IfcMaterialLayerSet newForLayerSet)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_ForLayerSet(), newForLayerSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLayerSetDirectionEnum getLayerSetDirection()
	{
		return (IfcLayerSetDirectionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_LayerSetDirection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerSetDirection(IfcLayerSetDirectionEnum newLayerSetDirection)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_LayerSetDirection(), newLayerSetDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirectionSenseEnum getDirectionSense()
	{
		return (IfcDirectionSenseEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_DirectionSense(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectionSense(IfcDirectionSenseEnum newDirectionSense)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_DirectionSense(), newDirectionSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOffsetFromReferenceLine()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_OffsetFromReferenceLine(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetFromReferenceLine(float newOffsetFromReferenceLine)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_OffsetFromReferenceLine(), newOffsetFromReferenceLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOffsetFromReferenceLineAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_OffsetFromReferenceLineAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetFromReferenceLineAsString(String newOffsetFromReferenceLineAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayerSetUsage_OffsetFromReferenceLineAsString(), newOffsetFromReferenceLineAsString);
	}

} //IfcMaterialLayerSetUsageImpl
