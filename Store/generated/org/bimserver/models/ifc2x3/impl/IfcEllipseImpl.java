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
import org.bimserver.models.ifc2x3.IfcEllipse;

import org.bimserver.models.ifc2x3.impl.IfcConicImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Ellipse</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseImpl#getSemiAxis1 <em>Semi Axis1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseImpl#getSemiAxis1AsString <em>Semi Axis1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseImpl#getSemiAxis2 <em>Semi Axis2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseImpl#getSemiAxis2AsString <em>Semi Axis2 As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEllipseImpl extends IfcConicImpl implements IfcEllipse
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
	protected IfcEllipseImpl()
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
		return Ifc2x3Package.Literals.IFC_ELLIPSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSemiAxis1()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ELLIPSE__SEMI_AXIS1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis1(float newSemiAxis1)
	{
		eSet(Ifc2x3Package.Literals.IFC_ELLIPSE__SEMI_AXIS1, newSemiAxis1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemiAxis1AsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ELLIPSE__SEMI_AXIS1_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis1AsString(String newSemiAxis1AsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ELLIPSE__SEMI_AXIS1_AS_STRING, newSemiAxis1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSemiAxis2()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_ELLIPSE__SEMI_AXIS2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis2(float newSemiAxis2)
	{
		eSet(Ifc2x3Package.Literals.IFC_ELLIPSE__SEMI_AXIS2, newSemiAxis2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemiAxis2AsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ELLIPSE__SEMI_AXIS2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis2AsString(String newSemiAxis2AsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_ELLIPSE__SEMI_AXIS2_AS_STRING, newSemiAxis2AsString);
	}

} //IfcEllipseImpl
