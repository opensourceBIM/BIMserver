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
import org.bimserver.models.ifc2x3.IfcStructuralLinearActionVarying;
import org.bimserver.models.ifc2x3.IfcStructuralLoad;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Linear Action Varying</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLinearActionVaryingImpl#getVaryingAppliedLoadLocation <em>Varying Applied Load Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLinearActionVaryingImpl#getSubsequentAppliedLoads <em>Subsequent Applied Loads</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLinearActionVaryingImpl extends IfcStructuralLinearActionImpl implements IfcStructuralLinearActionVarying
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLinearActionVaryingImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralLinearActionVarying();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getVaryingAppliedLoadLocation()
	{
		return (IfcShapeAspect)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLinearActionVarying_VaryingAppliedLoadLocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaryingAppliedLoadLocation(IfcShapeAspect newVaryingAppliedLoadLocation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLinearActionVarying_VaryingAppliedLoadLocation(), newVaryingAppliedLoadLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralLoad> getSubsequentAppliedLoads()
	{
		return (EList<IfcStructuralLoad>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLinearActionVarying_SubsequentAppliedLoads(), true);
	}

} //IfcStructuralLinearActionVaryingImpl
