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
import org.bimserver.models.ifc2x3.IfcShapeAspect;
import org.bimserver.models.ifc2x3.IfcWindowLiningProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Window Lining Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getLiningDepth <em>Lining Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getLiningDepthAsString <em>Lining Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getLiningThickness <em>Lining Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getLiningThicknessAsString <em>Lining Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getTransomThickness <em>Transom Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getTransomThicknessAsString <em>Transom Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getMullionThickness <em>Mullion Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getMullionThicknessAsString <em>Mullion Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getFirstTransomOffset <em>First Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getFirstTransomOffsetAsString <em>First Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getSecondTransomOffset <em>Second Transom Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getSecondTransomOffsetAsString <em>Second Transom Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getFirstMullionOffset <em>First Mullion Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getFirstMullionOffsetAsString <em>First Mullion Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getSecondMullionOffset <em>Second Mullion Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getSecondMullionOffsetAsString <em>Second Mullion Offset As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcWindowLiningPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcWindowLiningProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWindowLiningPropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLiningDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningDepth(float newLiningDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningDepth(), newLiningDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningDepth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningDepth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiningDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningDepthAsString(String newLiningDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningDepthAsString(), newLiningDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningDepthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningDepthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLiningThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningThickness(float newLiningThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningThickness(), newLiningThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiningThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiningThicknessAsString(String newLiningThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningThicknessAsString(), newLiningThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLiningThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiningThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_LiningThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransomThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_TransomThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomThickness(float newTransomThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_TransomThickness(), newTransomThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_TransomThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_TransomThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransomThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_TransomThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransomThicknessAsString(String newTransomThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_TransomThicknessAsString(), newTransomThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransomThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_TransomThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransomThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_TransomThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMullionThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_MullionThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMullionThickness(float newMullionThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_MullionThickness(), newMullionThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMullionThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_MullionThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMullionThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_MullionThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMullionThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_MullionThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMullionThicknessAsString(String newMullionThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_MullionThicknessAsString(), newMullionThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMullionThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_MullionThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMullionThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_MullionThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFirstTransomOffset()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstTransomOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstTransomOffset(float newFirstTransomOffset)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstTransomOffset(), newFirstTransomOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFirstTransomOffset()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstTransomOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFirstTransomOffset()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstTransomOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstTransomOffsetAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstTransomOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstTransomOffsetAsString(String newFirstTransomOffsetAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstTransomOffsetAsString(), newFirstTransomOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFirstTransomOffsetAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstTransomOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFirstTransomOffsetAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstTransomOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSecondTransomOffset()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondTransomOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondTransomOffset(float newSecondTransomOffset)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondTransomOffset(), newSecondTransomOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSecondTransomOffset()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondTransomOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSecondTransomOffset()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondTransomOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecondTransomOffsetAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondTransomOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondTransomOffsetAsString(String newSecondTransomOffsetAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondTransomOffsetAsString(), newSecondTransomOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSecondTransomOffsetAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondTransomOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSecondTransomOffsetAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondTransomOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFirstMullionOffset()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstMullionOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstMullionOffset(float newFirstMullionOffset)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstMullionOffset(), newFirstMullionOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFirstMullionOffset()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstMullionOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFirstMullionOffset()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstMullionOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstMullionOffsetAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstMullionOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstMullionOffsetAsString(String newFirstMullionOffsetAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstMullionOffsetAsString(), newFirstMullionOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFirstMullionOffsetAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstMullionOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFirstMullionOffsetAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_FirstMullionOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSecondMullionOffset()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondMullionOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondMullionOffset(float newSecondMullionOffset)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondMullionOffset(), newSecondMullionOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSecondMullionOffset()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondMullionOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSecondMullionOffset()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondMullionOffset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecondMullionOffsetAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondMullionOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondMullionOffsetAsString(String newSecondMullionOffsetAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondMullionOffsetAsString(), newSecondMullionOffsetAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSecondMullionOffsetAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondMullionOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSecondMullionOffsetAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_SecondMullionOffsetAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getShapeAspectStyle()
	{
		return (IfcShapeAspect)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_ShapeAspectStyle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_ShapeAspectStyle(), newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShapeAspectStyle()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_ShapeAspectStyle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShapeAspectStyle()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcWindowLiningProperties_ShapeAspectStyle());
	}

} //IfcWindowLiningPropertiesImpl
