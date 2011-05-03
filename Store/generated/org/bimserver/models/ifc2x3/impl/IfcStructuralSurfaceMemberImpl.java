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
import org.bimserver.models.ifc2x3.IfcStructuralSurfaceMember;
import org.bimserver.models.ifc2x3.IfcStructuralSurfaceTypeEnum;

import org.bimserver.models.ifc2x3.impl.IfcStructuralMemberImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Surface Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberImpl#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberImpl#getThicknessAsString <em>Thickness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralSurfaceMemberImpl extends IfcStructuralMemberImpl implements IfcStructuralSurfaceMember
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
	protected IfcStructuralSurfaceMemberImpl()
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
		return Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralSurfaceTypeEnum getPredefinedType()
	{
		return (IfcStructuralSurfaceTypeEnum)eGet(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcStructuralSurfaceTypeEnum newPredefinedType)
	{
		eSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThickness()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThickness(float newThickness)
	{
		eSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS, newThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThickness()
	{
		eUnset(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThickness()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThicknessAsString(String newThicknessAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS_AS_STRING, newThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThicknessAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS_AS_STRING);
	}

} //IfcStructuralSurfaceMemberImpl
