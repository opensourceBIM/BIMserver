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
import org.bimserver.models.ifc2x3.IfcCharacterStyleSelect;
import org.bimserver.models.ifc2x3.IfcTextFontSelect;
import org.bimserver.models.ifc2x3.IfcTextStyle;
import org.bimserver.models.ifc2x3.IfcTextStyleSelect;

import org.bimserver.models.ifc2x3.impl.IfcPresentationStyleImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleImpl#getTextCharacterAppearance <em>Text Character Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleImpl#getTextStyle <em>Text Style</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleImpl#getTextFontStyle <em>Text Font Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextStyleImpl extends IfcPresentationStyleImpl implements IfcTextStyle
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
	protected IfcTextStyleImpl()
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
		return Ifc2x3Package.Literals.IFC_TEXT_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCharacterStyleSelect getTextCharacterAppearance()
	{
		return (IfcCharacterStyleSelect)eGet(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextCharacterAppearance(IfcCharacterStyleSelect newTextCharacterAppearance)
	{
		eSet(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE, newTextCharacterAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextCharacterAppearance()
	{
		eUnset(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextCharacterAppearance()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextStyleSelect getTextStyle()
	{
		return (IfcTextStyleSelect)eGet(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextStyle(IfcTextStyleSelect newTextStyle)
	{
		eSet(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE, newTextStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextStyle()
	{
		eUnset(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextStyle()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextFontSelect getTextFontStyle()
	{
		return (IfcTextFontSelect)eGet(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_FONT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextFontStyle(IfcTextFontSelect newTextFontStyle)
	{
		eSet(Ifc2x3Package.Literals.IFC_TEXT_STYLE__TEXT_FONT_STYLE, newTextFontStyle);
	}

} //IfcTextStyleImpl
