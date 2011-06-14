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
import org.bimserver.models.ifc2x3.IfcCartesianTransformationOperator2DnonUniform;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cartesian Transformation Operator2 Dnon Uniform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator2DnonUniformImpl#getScale2 <em>Scale2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator2DnonUniformImpl#getScale2AsString <em>Scale2 As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCartesianTransformationOperator2DnonUniformImpl extends IfcCartesianTransformationOperator2DImpl implements IfcCartesianTransformationOperator2DnonUniform
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCartesianTransformationOperator2DnonUniformImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator2DnonUniform();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getScale2()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator2DnonUniform_Scale2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale2(float newScale2)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator2DnonUniform_Scale2(), newScale2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScale2AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator2DnonUniform_Scale2AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale2AsString(String newScale2AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCartesianTransformationOperator2DnonUniform_Scale2AsString(), newScale2AsString);
	}

} //IfcCartesianTransformationOperator2DnonUniformImpl
