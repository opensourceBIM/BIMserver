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
import org.bimserver.models.ifc2x3.IfcShapeAspect;
import org.bimserver.models.ifc2x3.IfcStructuralSurfaceMemberVarying;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Surface Member Varying</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getSubsequentThickness <em>Subsequent Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getSubsequentThicknessAsString <em>Subsequent Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getVaryingThicknessLocation <em>Varying Thickness Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getVaryingThickness <em>Varying Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getVaryingThicknessAsString <em>Varying Thickness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralSurfaceMemberVaryingImpl extends IfcStructuralSurfaceMemberImpl implements IfcStructuralSurfaceMemberVarying
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralSurfaceMemberVaryingImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Float> getSubsequentThickness()
	{
		return (EList<Float>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_SubsequentThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getSubsequentThicknessAsString()
	{
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_SubsequentThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getVaryingThicknessLocation()
	{
		return (IfcShapeAspect)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThicknessLocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaryingThicknessLocation(IfcShapeAspect newVaryingThicknessLocation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThicknessLocation(), newVaryingThicknessLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVaryingThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaryingThickness(float newVaryingThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThickness(), newVaryingThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVaryingThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaryingThicknessAsString(String newVaryingThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThicknessAsString(), newVaryingThicknessAsString);
	}

} //IfcStructuralSurfaceMemberVaryingImpl
