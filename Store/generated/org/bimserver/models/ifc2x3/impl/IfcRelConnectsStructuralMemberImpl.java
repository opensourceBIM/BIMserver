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
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcBoundaryCondition;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralMember;
import org.bimserver.models.ifc2x3.IfcStructuralConnection;
import org.bimserver.models.ifc2x3.IfcStructuralConnectionCondition;
import org.bimserver.models.ifc2x3.IfcStructuralMember;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Structural Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralMemberImpl#getRelatingStructuralMember <em>Relating Structural Member</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralMemberImpl#getRelatedStructuralConnection <em>Related Structural Connection</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralMemberImpl#getAppliedCondition <em>Applied Condition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralMemberImpl#getAdditionalConditions <em>Additional Conditions</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralMemberImpl#getSupportedLength <em>Supported Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralMemberImpl#getSupportedLengthAsString <em>Supported Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralMemberImpl#getConditionCoordinateSystem <em>Condition Coordinate System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsStructuralMemberImpl extends IfcRelConnectsImpl implements IfcRelConnectsStructuralMember
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsStructuralMemberImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralMember getRelatingStructuralMember()
	{
		return (IfcStructuralMember)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_RelatingStructuralMember(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingStructuralMember(IfcStructuralMember newRelatingStructuralMember)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_RelatingStructuralMember(), newRelatingStructuralMember);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralConnection getRelatedStructuralConnection()
	{
		return (IfcStructuralConnection)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_RelatedStructuralConnection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedStructuralConnection(IfcStructuralConnection newRelatedStructuralConnection)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_RelatedStructuralConnection(), newRelatedStructuralConnection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundaryCondition getAppliedCondition()
	{
		return (IfcBoundaryCondition)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AppliedCondition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedCondition(IfcBoundaryCondition newAppliedCondition)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AppliedCondition(), newAppliedCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAppliedCondition()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AppliedCondition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAppliedCondition()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AppliedCondition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralConnectionCondition getAdditionalConditions()
	{
		return (IfcStructuralConnectionCondition)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AdditionalConditions(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalConditions(IfcStructuralConnectionCondition newAdditionalConditions)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AdditionalConditions(), newAdditionalConditions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAdditionalConditions()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AdditionalConditions());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAdditionalConditions()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_AdditionalConditions());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSupportedLength()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedLength(float newSupportedLength)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLength(), newSupportedLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSupportedLength()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSupportedLength()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSupportedLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedLengthAsString(String newSupportedLengthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLengthAsString(), newSupportedLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSupportedLengthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSupportedLengthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_SupportedLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D getConditionCoordinateSystem()
	{
		return (IfcAxis2Placement3D)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_ConditionCoordinateSystem(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionCoordinateSystem(IfcAxis2Placement3D newConditionCoordinateSystem)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_ConditionCoordinateSystem(), newConditionCoordinateSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConditionCoordinateSystem()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_ConditionCoordinateSystem());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConditionCoordinateSystem()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralMember_ConditionCoordinateSystem());
	}

} //IfcRelConnectsStructuralMemberImpl
