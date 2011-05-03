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
import org.bimserver.models.ifc2x3.IfcDirection;
import org.bimserver.models.ifc2x3.IfcVector;

import org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationItemImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Vector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVectorImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVectorImpl#getMagnitude <em>Magnitude</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVectorImpl#getMagnitudeAsString <em>Magnitude As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcVectorImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcVectorImpl extends IfcGeometricRepresentationItemImpl implements IfcVector
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
	protected IfcVectorImpl()
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
		return Ifc2x3Package.Literals.IFC_VECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getOrientation()
	{
		return (IfcDirection)eGet(Ifc2x3Package.Literals.IFC_VECTOR__ORIENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientation(IfcDirection newOrientation)
	{
		eSet(Ifc2x3Package.Literals.IFC_VECTOR__ORIENTATION, newOrientation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMagnitude()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_VECTOR__MAGNITUDE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMagnitude(float newMagnitude)
	{
		eSet(Ifc2x3Package.Literals.IFC_VECTOR__MAGNITUDE, newMagnitude);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMagnitudeAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_VECTOR__MAGNITUDE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMagnitudeAsString(String newMagnitudeAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_VECTOR__MAGNITUDE_AS_STRING, newMagnitudeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.Literals.IFC_VECTOR__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.Literals.IFC_VECTOR__DIM, newDim);
	}

} //IfcVectorImpl
