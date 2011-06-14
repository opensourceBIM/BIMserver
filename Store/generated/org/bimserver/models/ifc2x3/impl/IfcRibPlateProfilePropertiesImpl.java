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
import org.bimserver.models.ifc2x3.IfcRibPlateDirectionEnum;
import org.bimserver.models.ifc2x3.IfcRibPlateProfileProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rib Plate Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getThicknessAsString <em>Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getRibHeight <em>Rib Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getRibHeightAsString <em>Rib Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getRibWidth <em>Rib Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getRibWidthAsString <em>Rib Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getRibSpacing <em>Rib Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getRibSpacingAsString <em>Rib Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRibPlateProfilePropertiesImpl extends IfcProfilePropertiesImpl implements IfcRibPlateProfileProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRibPlateProfilePropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_Thickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThickness(float newThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_Thickness(), newThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_Thickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_Thickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_ThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThicknessAsString(String newThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_ThicknessAsString(), newThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_ThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_ThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRibHeight()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibHeight(float newRibHeight)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibHeight(), newRibHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibHeight()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibHeight()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRibHeightAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibHeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibHeightAsString(String newRibHeightAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibHeightAsString(), newRibHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibHeightAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibHeightAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRibWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibWidth(float newRibWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibWidth(), newRibWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibWidth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibWidth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRibWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibWidthAsString(String newRibWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibWidthAsString(), newRibWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibWidthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibWidthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRibSpacing()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibSpacing(float newRibSpacing)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibSpacing(), newRibSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibSpacing()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibSpacing()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRibSpacingAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibSpacingAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRibSpacingAsString(String newRibSpacingAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibSpacingAsString(), newRibSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRibSpacingAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRibSpacingAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_RibSpacingAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRibPlateDirectionEnum getDirection()
	{
		return (IfcRibPlateDirectionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_Direction(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(IfcRibPlateDirectionEnum newDirection)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRibPlateProfileProperties_Direction(), newDirection);
	}

} //IfcRibPlateProfilePropertiesImpl
