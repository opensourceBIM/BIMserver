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
import org.bimserver.models.ifc2x3.IfcMaterialLayer;
import org.bimserver.models.ifc2x3.IfcMaterialLayerSet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetImpl#getMaterialLayers <em>Material Layers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetImpl#getLayerSetName <em>Layer Set Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetImpl#getTotalThickness <em>Total Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetImpl#getTotalThicknessAsString <em>Total Thickness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMaterialLayerSetImpl extends IdEObjectImpl implements IfcMaterialLayerSet
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialLayerSetImpl()
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
		return Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET;
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
	@SuppressWarnings("unchecked")
	public EList<IfcMaterialLayer> getMaterialLayers()
	{
		return (EList<IfcMaterialLayer>)eGet(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__MATERIAL_LAYERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayerSetName()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__LAYER_SET_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerSetName(String newLayerSetName)
	{
		eSet(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__LAYER_SET_NAME, newLayerSetName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLayerSetName()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__LAYER_SET_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLayerSetName()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__LAYER_SET_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTotalThickness()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalThickness(float newTotalThickness)
	{
		eSet(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS, newTotalThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTotalThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalThicknessAsString(String newTotalThicknessAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MATERIAL_LAYER_SET__TOTAL_THICKNESS_AS_STRING, newTotalThicknessAsString);
	}

} //IfcMaterialLayerSetImpl
