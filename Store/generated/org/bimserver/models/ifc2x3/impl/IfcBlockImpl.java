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
import org.bimserver.models.ifc2x3.IfcBlock;

import org.bimserver.models.ifc2x3.impl.IfcCsgPrimitive3DImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getXLength <em>XLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getXLengthAsString <em>XLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getYLength <em>YLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getYLengthAsString <em>YLength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getZLength <em>ZLength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBlockImpl#getZLengthAsString <em>ZLength As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBlockImpl extends IfcCsgPrimitive3DImpl implements IfcBlock
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
	protected IfcBlockImpl()
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
		return Ifc2x3Package.Literals.IFC_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getXLength()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_BLOCK__XLENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLength(float newXLength)
	{
		eSet(Ifc2x3Package.Literals.IFC_BLOCK__XLENGTH, newXLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_BLOCK__XLENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXLengthAsString(String newXLengthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_BLOCK__XLENGTH_AS_STRING, newXLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYLength()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_BLOCK__YLENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYLength(float newYLength)
	{
		eSet(Ifc2x3Package.Literals.IFC_BLOCK__YLENGTH, newYLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_BLOCK__YLENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYLengthAsString(String newYLengthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_BLOCK__YLENGTH_AS_STRING, newYLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getZLength()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_BLOCK__ZLENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZLength(float newZLength)
	{
		eSet(Ifc2x3Package.Literals.IFC_BLOCK__ZLENGTH, newZLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_BLOCK__ZLENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZLengthAsString(String newZLengthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_BLOCK__ZLENGTH_AS_STRING, newZLengthAsString);
	}

} //IfcBlockImpl
