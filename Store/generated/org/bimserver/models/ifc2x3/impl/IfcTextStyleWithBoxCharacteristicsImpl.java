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
import org.bimserver.models.ifc2x3.IfcSizeSelect;
import org.bimserver.models.ifc2x3.IfcTextStyleWithBoxCharacteristics;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style With Box Characteristics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getBoxHeight <em>Box Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getBoxHeightAsString <em>Box Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getBoxWidth <em>Box Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getBoxWidthAsString <em>Box Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getBoxSlantAngle <em>Box Slant Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getBoxSlantAngleAsString <em>Box Slant Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getBoxRotateAngle <em>Box Rotate Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getBoxRotateAngleAsString <em>Box Rotate Angle As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl#getCharacterSpacing <em>Character Spacing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextStyleWithBoxCharacteristicsImpl extends IdEObjectImpl implements IfcTextStyleWithBoxCharacteristics
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextStyleWithBoxCharacteristicsImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics();
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
	public float getBoxHeight()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxHeight(float newBoxHeight)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxHeight(), newBoxHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoxHeight()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoxHeight()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoxHeightAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxHeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxHeightAsString(String newBoxHeightAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxHeightAsString(), newBoxHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoxHeightAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoxHeightAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBoxWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxWidth(float newBoxWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxWidth(), newBoxWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoxWidth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoxWidth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoxWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxWidthAsString(String newBoxWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxWidthAsString(), newBoxWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoxWidthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoxWidthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBoxSlantAngle()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxSlantAngle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxSlantAngle(float newBoxSlantAngle)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxSlantAngle(), newBoxSlantAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoxSlantAngle()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxSlantAngle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoxSlantAngle()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxSlantAngle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoxSlantAngleAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxSlantAngleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxSlantAngleAsString(String newBoxSlantAngleAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxSlantAngleAsString(), newBoxSlantAngleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoxSlantAngleAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxSlantAngleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoxSlantAngleAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxSlantAngleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBoxRotateAngle()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxRotateAngle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxRotateAngle(float newBoxRotateAngle)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxRotateAngle(), newBoxRotateAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoxRotateAngle()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxRotateAngle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoxRotateAngle()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxRotateAngle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoxRotateAngleAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxRotateAngleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxRotateAngleAsString(String newBoxRotateAngleAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxRotateAngleAsString(), newBoxRotateAngleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoxRotateAngleAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxRotateAngleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoxRotateAngleAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_BoxRotateAngleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getCharacterSpacing()
	{
		return (IfcSizeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_CharacterSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacterSpacing(IfcSizeSelect newCharacterSpacing)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_CharacterSpacing(), newCharacterSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCharacterSpacing()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_CharacterSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCharacterSpacing()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleWithBoxCharacteristics_CharacterSpacing());
	}

} //IfcTextStyleWithBoxCharacteristicsImpl
