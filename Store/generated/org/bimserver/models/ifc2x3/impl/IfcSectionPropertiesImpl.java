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
import org.bimserver.models.ifc2x3.IfcProfileDef;
import org.bimserver.models.ifc2x3.IfcSectionProperties;
import org.bimserver.models.ifc2x3.IfcSectionTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Section Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSectionPropertiesImpl#getSectionType <em>Section Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSectionPropertiesImpl#getStartProfile <em>Start Profile</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSectionPropertiesImpl#getEndProfile <em>End Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSectionPropertiesImpl extends IdEObjectImpl implements IfcSectionProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSectionPropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcSectionProperties();
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
	public IfcSectionTypeEnum getSectionType()
	{
		return (IfcSectionTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcSectionProperties_SectionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSectionType(IfcSectionTypeEnum newSectionType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSectionProperties_SectionType(), newSectionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getStartProfile()
	{
		return (IfcProfileDef)eGet(Ifc2x3Package.eINSTANCE.getIfcSectionProperties_StartProfile(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartProfile(IfcProfileDef newStartProfile)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSectionProperties_StartProfile(), newStartProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef getEndProfile()
	{
		return (IfcProfileDef)eGet(Ifc2x3Package.eINSTANCE.getIfcSectionProperties_EndProfile(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndProfile(IfcProfileDef newEndProfile)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSectionProperties_EndProfile(), newEndProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEndProfile()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSectionProperties_EndProfile());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEndProfile()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSectionProperties_EndProfile());
	}

} //IfcSectionPropertiesImpl
