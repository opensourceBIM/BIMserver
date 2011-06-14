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
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcRepresentationContext;
import org.bimserver.models.ifc2x3.IfcUnitAssignment;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProjectImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProjectImpl#getPhase <em>Phase</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProjectImpl#getRepresentationContexts <em>Representation Contexts</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProjectImpl#getUnitsInContext <em>Units In Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcProjectImpl extends IfcObjectImpl implements IfcProject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProjectImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcProject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProject_LongName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProject_LongName(), newLongName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongName()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProject_LongName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongName()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProject_LongName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhase()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProject_Phase(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhase(String newPhase)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProject_Phase(), newPhase);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPhase()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProject_Phase());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPhase()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProject_Phase());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRepresentationContext> getRepresentationContexts()
	{
		return (EList<IfcRepresentationContext>)eGet(Ifc2x3Package.eINSTANCE.getIfcProject_RepresentationContexts(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnitAssignment getUnitsInContext()
	{
		return (IfcUnitAssignment)eGet(Ifc2x3Package.eINSTANCE.getIfcProject_UnitsInContext(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitsInContext(IfcUnitAssignment newUnitsInContext)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProject_UnitsInContext(), newUnitsInContext);
	}

} //IfcProjectImpl
