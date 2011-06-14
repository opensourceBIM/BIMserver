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
import org.bimserver.models.ifc2x3.IfcColour;
import org.bimserver.models.ifc2x3.IfcTextStyleForDefinedFont;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style For Defined Font</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleForDefinedFontImpl#getColour <em>Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleForDefinedFontImpl#getBackgroundColour <em>Background Colour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextStyleForDefinedFontImpl extends IdEObjectImpl implements IfcTextStyleForDefinedFont
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextStyleForDefinedFontImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont();
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
	public IfcColour getColour()
	{
		return (IfcColour)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_Colour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColour(IfcColour newColour)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_Colour(), newColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColour getBackgroundColour()
	{
		return (IfcColour)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_BackgroundColour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColour(IfcColour newBackgroundColour)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_BackgroundColour(), newBackgroundColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBackgroundColour()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_BackgroundColour());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBackgroundColour()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleForDefinedFont_BackgroundColour());
	}

} //IfcTextStyleForDefinedFontImpl
