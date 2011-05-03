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
import org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator2D;
import org.bimserver.models.ifc2x3.IfcDerivedProfileDef;
import org.bimserver.models.ifc2x3.IfcProfileDef;

import org.bimserver.models.ifc2x3.impl.IfcProfileDefImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Derived Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDerivedProfileDefImpl#getParentProfile <em>Parent Profile</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDerivedProfileDefImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDerivedProfileDefImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDerivedProfileDefImpl extends IfcProfileDefImpl implements IfcDerivedProfileDef
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
	protected IfcDerivedProfileDefImpl()
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
		return Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getParentProfile()
	{
		return (IfcProfileDef)eGet(Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF__PARENT_PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentProfile(IfcProfileDef newParentProfile)
	{
		eSet(Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF__PARENT_PROFILE, newParentProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator2D getOperator()
	{
		return (IfcCartesianTransformationOperator2D)eGet(Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF__OPERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(IfcCartesianTransformationOperator2D newOperator)
	{
		eSet(Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF__OPERATOR, newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF__LABEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel)
	{
		eSet(Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF__LABEL, newLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLabel()
	{
		eUnset(Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF__LABEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLabel()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_DERIVED_PROFILE_DEF__LABEL);
	}

} //IfcDerivedProfileDefImpl
