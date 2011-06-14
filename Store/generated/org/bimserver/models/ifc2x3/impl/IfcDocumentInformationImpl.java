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
import org.bimserver.models.ifc2x3.IfcActorSelect;
import org.bimserver.models.ifc2x3.IfcCalendarDate;
import org.bimserver.models.ifc2x3.IfcDateAndTime;
import org.bimserver.models.ifc2x3.IfcDocumentConfidentialityEnum;
import org.bimserver.models.ifc2x3.IfcDocumentElectronicFormat;
import org.bimserver.models.ifc2x3.IfcDocumentInformation;
import org.bimserver.models.ifc2x3.IfcDocumentInformationRelationship;
import org.bimserver.models.ifc2x3.IfcDocumentReference;
import org.bimserver.models.ifc2x3.IfcDocumentStatusEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Document Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getDocumentId <em>Document Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getDocumentReferences <em>Document References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getIntendedUse <em>Intended Use</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getDocumentOwner <em>Document Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getLastRevisionTime <em>Last Revision Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getElectronicFormat <em>Electronic Format</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getValidFrom <em>Valid From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getValidUntil <em>Valid Until</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getIsPointedTo <em>Is Pointed To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl#getIsPointer <em>Is Pointer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDocumentInformationImpl extends IdEObjectImpl implements IfcDocumentInformation
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDocumentInformationImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcDocumentInformation();
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
	public String getDocumentId()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentId(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentId(String newDocumentId)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentId(), newDocumentId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentReference> getDocumentReferences()
	{
		return (EList<IfcDocumentReference>)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentReferences(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDocumentReferences()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDocumentReferences()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Purpose(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Purpose(), newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPurpose()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPurpose()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Purpose());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntendedUse()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_IntendedUse(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntendedUse(String newIntendedUse)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_IntendedUse(), newIntendedUse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntendedUse()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_IntendedUse());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntendedUse()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_IntendedUse());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScope()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Scope(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(String newScope)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Scope(), newScope);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScope()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Scope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScope()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Scope());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRevision()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Revision(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(String newRevision)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Revision(), newRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRevision()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Revision());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRevision()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Revision());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getDocumentOwner()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentOwner(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentOwner(IfcActorSelect newDocumentOwner)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentOwner(), newDocumentOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDocumentOwner()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentOwner());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDocumentOwner()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_DocumentOwner());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorSelect> getEditors()
	{
		return (EList<IfcActorSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Editors(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditors()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Editors());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditors()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Editors());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateAndTime getCreationTime()
	{
		return (IfcDateAndTime)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_CreationTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(IfcDateAndTime newCreationTime)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_CreationTime(), newCreationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreationTime()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_CreationTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreationTime()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_CreationTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateAndTime getLastRevisionTime()
	{
		return (IfcDateAndTime)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_LastRevisionTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastRevisionTime(IfcDateAndTime newLastRevisionTime)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_LastRevisionTime(), newLastRevisionTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastRevisionTime()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_LastRevisionTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastRevisionTime()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_LastRevisionTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentElectronicFormat getElectronicFormat()
	{
		return (IfcDocumentElectronicFormat)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ElectronicFormat(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElectronicFormat(IfcDocumentElectronicFormat newElectronicFormat)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ElectronicFormat(), newElectronicFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElectronicFormat()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ElectronicFormat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElectronicFormat()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ElectronicFormat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getValidFrom()
	{
		return (IfcCalendarDate)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ValidFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidFrom(IfcCalendarDate newValidFrom)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ValidFrom(), newValidFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValidFrom()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ValidFrom());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValidFrom()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ValidFrom());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getValidUntil()
	{
		return (IfcCalendarDate)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ValidUntil(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidUntil(IfcCalendarDate newValidUntil)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ValidUntil(), newValidUntil);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetValidUntil()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ValidUntil());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetValidUntil()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_ValidUntil());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentConfidentialityEnum getConfidentiality()
	{
		return (IfcDocumentConfidentialityEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Confidentiality(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidentiality(IfcDocumentConfidentialityEnum newConfidentiality)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Confidentiality(), newConfidentiality);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentStatusEnum getStatus()
	{
		return (IfcDocumentStatusEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Status(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(IfcDocumentStatusEnum newStatus)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_Status(), newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentInformationRelationship> getIsPointedTo()
	{
		return (EList<IfcDocumentInformationRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_IsPointedTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentInformationRelationship> getIsPointer()
	{
		return (EList<IfcDocumentInformationRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcDocumentInformation_IsPointer(), true);
	}

} //IfcDocumentInformationImpl
