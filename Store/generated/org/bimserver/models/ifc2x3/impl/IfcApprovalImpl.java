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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcApproval;
import org.bimserver.models.ifc2x3.IfcApprovalActorRelationship;
import org.bimserver.models.ifc2x3.IfcApprovalRelationship;
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Approval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getApprovalDateTime <em>Approval Date Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getApprovalStatus <em>Approval Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getApprovalLevel <em>Approval Level</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getApprovalQualifier <em>Approval Qualifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApprovalImpl#getRelates <em>Relates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcApprovalImpl extends IdEObjectImpl implements IfcApproval
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
	protected IfcApprovalImpl()
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
		return Ifc2x3Package.Literals.IFC_APPROVAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPROVAL__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription()
	{
		eUnset(Ifc2x3Package.Literals.IFC_APPROVAL__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_APPROVAL__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getApprovalDateTime()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_DATE_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApprovalDateTime(IfcDateTimeSelect newApprovalDateTime)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_DATE_TIME, newApprovalDateTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApprovalStatus()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApprovalStatus(String newApprovalStatus)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_STATUS, newApprovalStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApprovalStatus()
	{
		eUnset(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApprovalStatus()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApprovalLevel()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_LEVEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApprovalLevel(String newApprovalLevel)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_LEVEL, newApprovalLevel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApprovalLevel()
	{
		eUnset(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_LEVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApprovalLevel()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_LEVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApprovalQualifier()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_QUALIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApprovalQualifier(String newApprovalQualifier)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_QUALIFIER, newApprovalQualifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApprovalQualifier()
	{
		eUnset(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_QUALIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApprovalQualifier()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_APPROVAL__APPROVAL_QUALIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPROVAL__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPROVAL__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcApprovalActorRelationship> getActors()
	{
		return (EList<IfcApprovalActorRelationship>)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__ACTORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcApprovalRelationship> getIsRelatedWith()
	{
		return (EList<IfcApprovalRelationship>)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__IS_RELATED_WITH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcApprovalRelationship> getRelates()
	{
		return (EList<IfcApprovalRelationship>)eGet(Ifc2x3Package.Literals.IFC_APPROVAL__RELATES, true);
	}

} //IfcApprovalImpl
