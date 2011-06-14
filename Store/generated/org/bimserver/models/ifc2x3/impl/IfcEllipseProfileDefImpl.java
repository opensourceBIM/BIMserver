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
import org.bimserver.models.ifc2x3.IfcEllipseProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Ellipse Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseProfileDefImpl#getSemiAxis1 <em>Semi Axis1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseProfileDefImpl#getSemiAxis1AsString <em>Semi Axis1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseProfileDefImpl#getSemiAxis2 <em>Semi Axis2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseProfileDefImpl#getSemiAxis2AsString <em>Semi Axis2 As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEllipseProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcEllipseProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEllipseProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSemiAxis1()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef_SemiAxis1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis1(float newSemiAxis1)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef_SemiAxis1(), newSemiAxis1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemiAxis1AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef_SemiAxis1AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis1AsString(String newSemiAxis1AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef_SemiAxis1AsString(), newSemiAxis1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSemiAxis2()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef_SemiAxis2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis2(float newSemiAxis2)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef_SemiAxis2(), newSemiAxis2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemiAxis2AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef_SemiAxis2AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis2AsString(String newSemiAxis2AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEllipseProfileDef_SemiAxis2AsString(), newSemiAxis2AsString);
	}

} //IfcEllipseProfileDefImpl
