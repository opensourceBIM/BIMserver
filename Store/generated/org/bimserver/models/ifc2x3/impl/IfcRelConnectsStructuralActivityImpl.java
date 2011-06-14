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
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralActivityAssignmentSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Structural Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralActivityImpl#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralActivityImpl#getRelatedStructuralActivity <em>Related Structural Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsStructuralActivityImpl extends IfcRelConnectsImpl implements IfcRelConnectsStructuralActivity
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsStructuralActivityImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralActivityAssignmentSelect getRelatingElement()
	{
		return (IfcStructuralActivityAssignmentSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingElement(IfcStructuralActivityAssignmentSelect newRelatingElement)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement(), newRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralActivity getRelatedStructuralActivity()
	{
		return (IfcStructuralActivity)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatedStructuralActivity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedStructuralActivity(IfcStructuralActivity newRelatedStructuralActivity)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatedStructuralActivity(), newRelatedStructuralActivity);
	}

} //IfcRelConnectsStructuralActivityImpl
