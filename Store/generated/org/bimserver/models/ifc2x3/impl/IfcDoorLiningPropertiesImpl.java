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
import org.bimserver.models.ifc2x3.IfcDoorLiningProperties;
import org.bimserver.models.ifc2x3.IfcShapeAspect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door Lining Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getLiningDepth <em>Lining Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getLiningDepthAsString <em>Lining Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getLiningThickness <em>Lining Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getLiningThicknessAsString <em>Lining Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getThresholdDepth <em>Threshold Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getThresholdDepthAsString <em>Threshold Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getThresholdThickness <em>Threshold Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getThresholdThicknessAsString <em>Threshold Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getTransomThickness <em>Transom Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getTransomThicknessAsString <em>Transom Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getTransomOffset <em>Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getTransomOffsetAsString <em>Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getLiningOffset <em>Lining Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getLiningOffsetAsString <em>Lining Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getThresholdOffset <em>Threshold Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getThresholdOffsetAsString <em>Threshold Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getCasingThickness <em>Casing Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getCasingThicknessAsString <em>Casing Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getCasingDepth <em>Casing Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getCasingDepthAsString <em>Casing Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDoorLiningPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcDoorLiningProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDoorLiningPropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLiningDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningDepth(float newLiningDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepth(), newLiningDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningDepth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningDepth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiningDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningDepthAsString(String newLiningDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepthAsString(), newLiningDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningDepthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningDepthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLiningThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningThickness(float newLiningThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThickness(), newLiningThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiningThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningThicknessAsString(String newLiningThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThicknessAsString(), newLiningThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThresholdDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdDepth(float newThresholdDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepth(), newThresholdDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdDepth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdDepth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThresholdDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdDepthAsString(String newThresholdDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepthAsString(), newThresholdDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdDepthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdDepthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThresholdThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdThickness(float newThresholdThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThickness(), newThresholdThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThresholdThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdThicknessAsString(String newThresholdThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThicknessAsString(), newThresholdThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransomThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomThickness(float newTransomThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThickness(), newTransomThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransomThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomThicknessAsString(String newTransomThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThicknessAsString(), newTransomThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransomOffset()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomOffset(float newTransomOffset)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffset(), newTransomOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomOffset()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomOffset()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransomOffsetAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomOffsetAsString(String newTransomOffsetAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffsetAsString(), newTransomOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomOffsetAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomOffsetAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_TransomOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLiningOffset()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningOffset(float newLiningOffset)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffset(), newLiningOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningOffset()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningOffset()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiningOffsetAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningOffsetAsString(String newLiningOffsetAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffsetAsString(), newLiningOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningOffsetAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningOffsetAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_LiningOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThresholdOffset()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdOffset(float newThresholdOffset)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffset(), newThresholdOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdOffset()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdOffset()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThresholdOffsetAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdOffsetAsString(String newThresholdOffsetAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffsetAsString(), newThresholdOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThresholdOffsetAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThresholdOffsetAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ThresholdOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCasingThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasingThickness(float newCasingThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThickness(), newCasingThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCasingThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCasingThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCasingThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasingThicknessAsString(String newCasingThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThicknessAsString(), newCasingThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCasingThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCasingThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCasingDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasingDepth(float newCasingDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepth(), newCasingDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCasingDepth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCasingDepth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCasingDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCasingDepthAsString(String newCasingDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepthAsString(), newCasingDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCasingDepthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCasingDepthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_CasingDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getShapeAspectStyle()
	{
		return (IfcShapeAspect)eGet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ShapeAspectStyle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ShapeAspectStyle(), newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShapeAspectStyle()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ShapeAspectStyle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShapeAspectStyle()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDoorLiningProperties_ShapeAspectStyle());
	}

} //IfcDoorLiningPropertiesImpl
