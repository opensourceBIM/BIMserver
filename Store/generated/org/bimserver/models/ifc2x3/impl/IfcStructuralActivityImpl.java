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
import org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralLoad;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralActivityImpl#getAppliedLoad <em>Applied Load</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralActivityImpl#getGlobalOrLocal <em>Global Or Local</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralActivityImpl#getAssignedToStructuralItem <em>Assigned To Structural Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralActivityImpl extends IfcProductImpl implements IfcStructuralActivity
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralActivityImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralActivity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoad getAppliedLoad()
	{
		return (IfcStructuralLoad)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_AppliedLoad(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedLoad(IfcStructuralLoad newAppliedLoad)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_AppliedLoad(), newAppliedLoad);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGlobalOrLocalEnum getGlobalOrLocal()
	{
		return (IfcGlobalOrLocalEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_GlobalOrLocal(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOrLocal(IfcGlobalOrLocalEnum newGlobalOrLocal)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_GlobalOrLocal(), newGlobalOrLocal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsStructuralActivity getAssignedToStructuralItem()
	{
		return (IfcRelConnectsStructuralActivity)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_AssignedToStructuralItem(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignedToStructuralItem(IfcRelConnectsStructuralActivity newAssignedToStructuralItem)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralActivity_AssignedToStructuralItem(), newAssignedToStructuralItem);
	}

} //IfcStructuralActivityImpl
