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

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGeneralProfileProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc General Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getPhysicalWeight <em>Physical Weight</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getPhysicalWeightAsString <em>Physical Weight As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getPerimeter <em>Perimeter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getPerimeterAsString <em>Perimeter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getMinimumPlateThickness <em>Minimum Plate Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getMinimumPlateThicknessAsString <em>Minimum Plate Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getMaximumPlateThickness <em>Maximum Plate Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getMaximumPlateThicknessAsString <em>Maximum Plate Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcGeneralProfilePropertiesImpl extends IfcProfilePropertiesImpl implements IfcGeneralProfileProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGeneralProfilePropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPhysicalWeight()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PhysicalWeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalWeight(float newPhysicalWeight)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PhysicalWeight(), newPhysicalWeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPhysicalWeight()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PhysicalWeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPhysicalWeight()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PhysicalWeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhysicalWeightAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PhysicalWeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalWeightAsString(String newPhysicalWeightAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PhysicalWeightAsString(), newPhysicalWeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPhysicalWeightAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PhysicalWeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPhysicalWeightAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PhysicalWeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPerimeter()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_Perimeter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerimeter(float newPerimeter)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_Perimeter(), newPerimeter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPerimeter()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_Perimeter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPerimeter()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_Perimeter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPerimeterAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PerimeterAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerimeterAsString(String newPerimeterAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PerimeterAsString(), newPerimeterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPerimeterAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PerimeterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPerimeterAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_PerimeterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMinimumPlateThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MinimumPlateThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumPlateThickness(float newMinimumPlateThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MinimumPlateThickness(), newMinimumPlateThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumPlateThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MinimumPlateThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumPlateThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MinimumPlateThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumPlateThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MinimumPlateThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumPlateThicknessAsString(String newMinimumPlateThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MinimumPlateThicknessAsString(), newMinimumPlateThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumPlateThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MinimumPlateThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumPlateThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MinimumPlateThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaximumPlateThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MaximumPlateThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPlateThickness(float newMaximumPlateThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MaximumPlateThickness(), newMaximumPlateThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumPlateThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MaximumPlateThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumPlateThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MaximumPlateThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumPlateThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MaximumPlateThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPlateThicknessAsString(String newMaximumPlateThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MaximumPlateThicknessAsString(), newMaximumPlateThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumPlateThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MaximumPlateThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumPlateThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_MaximumPlateThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCrossSectionArea()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_CrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionArea(float newCrossSectionArea)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_CrossSectionArea(), newCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCrossSectionArea()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_CrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCrossSectionArea()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_CrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCrossSectionAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_CrossSectionAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionAreaAsString(String newCrossSectionAreaAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_CrossSectionAreaAsString(), newCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCrossSectionAreaAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_CrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCrossSectionAreaAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeneralProfileProperties_CrossSectionAreaAsString());
	}

} //IfcGeneralProfilePropertiesImpl
